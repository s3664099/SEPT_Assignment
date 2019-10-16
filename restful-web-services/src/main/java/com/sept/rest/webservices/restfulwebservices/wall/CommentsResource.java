package com.sept.rest.webservices.restfulwebservices.wall;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.sept.rest.webservices.restfulwebservices.entities.CommentLikes;
import com.sept.rest.webservices.restfulwebservices.entities.Comments;
import com.sept.rest.webservices.restfulwebservices.entities.Students;
import com.sept.rest.webservices.restfulwebservices.repositories.CommentLikesRepository;
import com.sept.rest.webservices.restfulwebservices.repositories.CommentsRepository;
import com.sept.rest.webservices.restfulwebservices.repositories.StudentsRepository;

// Class containing all mappings related to posts on a wall
@RestController
@CrossOrigin(origins="http://localhost:4200")
public class CommentsResource {
	
	@Autowired
	private CommentsRepository commentsRepository;
	
	@Autowired
	private StudentsRepository studentsRepository;
	
	@Autowired
	private CommentLikesRepository likesRepository;
	
	// Mapping to get a list of all undeleted posts for a given wall
	//		When specific id can be determined rework to fetch appropriate wall
	@GetMapping(path = "/jpa/users/{username}/post/{postId}/comment")
	public List<Comments> sendVisibleCommentsList(@PathVariable String username, @PathVariable Integer postId) {
		
		List<Comments> list = commentsRepository.findByParentIdAndDeletedFalseOrderByCreationTimeDesc(postId);
		
		for (Comments comment : list) {
			Students author = studentsRepository.findByStudentId(comment.getAuthorID());
			comment.setAuthorName(author.getDisplay_Name());
			List<CommentLikes> likes = likesRepository.findByCommentId(comment.getCommentID());
			comment.setLikes(likes.size());
		}
		
		return list;
	}
	
	// Mapping to get a specific post if undeleted
	@GetMapping(path = "/jpa/users/{username}/comment/{commentId}")
	public Comments getComment(@PathVariable String username, @PathVariable Long commentId) {
		return commentsRepository.findByCommentIdAndDeletedFalse(commentId);
	}
	
	// Mapping to add a new post to the wall
	@PostMapping(path = "/jpa/users/{username}/post/{postId}/comment")
	public ResponseEntity<Void> newComment(@PathVariable String username, @PathVariable Integer postId, @RequestBody Comments comment) {

		// Ensure new comment will be appended to the correct post
		comment.setAuthorID(studentsRepository.findBydisplayName(username).getStudentID());
		comment.setParentId(postId);
			
		// Store new post in database
		Comments newComment = commentsRepository.save(comment);
			
		// Append the new Posts id to the url path
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newComment.getCommentID()).toUri();
			
		// Construct an entity to return
		return ResponseEntity.created(uri).build();
	}
	
	// Mapping to edit a post. Returns unedited post with unauthorized status if user is not posts owner
	@PutMapping("/jpa/users/{username}/comment/{commentId}")
	public ResponseEntity<Comments> updateComment(
			@PathVariable String username,
			@PathVariable Long commentId, @RequestBody Comments comment) {
		
		// Check that this is post by the user
		if(studentsRepository.findBydisplayName(username).getStudentID() == comment.getAuthorID()) {
		   int ownerID = studentsRepository.findBydisplayName(username).getStudentID();
		   comment.setAuthorID(ownerID);
		   // Store edited post in database
		   Comments editedComment = commentsRepository.save(comment);
		   
		   // Construct an entity to return
		   return new ResponseEntity<Comments>(editedComment, HttpStatus.OK);
		}
		
		// User not Authorized to edit post. Unchanged post returned with appropriate status
		return new ResponseEntity<Comments>(comment, HttpStatus.FORBIDDEN);
	}
	
	// Mapping to remove a post from the wall
	@DeleteMapping("/jpa/users/{username}/comment/{commentId}")
	public ResponseEntity<Void> deletePost(@PathVariable String username, @PathVariable Long commentId) {

		// Retrieve post to be removed from the wall
		
		Comments comment = commentsRepository.findByCommentIdAndDeletedFalse(commentId);
		// Check that user has permission to delete post
		if (studentsRepository.findBydisplayName(username).getStudentID() == comment.getAuthorID()) {
			
			// Set post to not be displayed
			comment.setDeleted(true);
			
			// Update database
			commentsRepository.save(comment);
			// Construct an entity to return
			return ResponseEntity.noContent().build();
		}
		// User not authorized to delete post. Respond with appropriate status
		return new ResponseEntity<Void>(HttpStatus.FORBIDDEN);
	}
	
	// Mapping to Like a comment
	@GetMapping("/jpa/users/{username}/comment/{commentId}/like")
	public ResponseEntity<Void> likeComment(@PathVariable String username, @PathVariable Long commentId) {
		// get user id
		int studentId = studentsRepository.findBydisplayName(username).getStudentID();
		
		// create Like entity
		CommentLikes like = new CommentLikes(commentId, studentId);
		
		// store it
		likesRepository.save(like);
		
		return ResponseEntity.noContent().build();
	}

}
