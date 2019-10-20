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

import com.sept.rest.webservices.restfulwebservices.students.Students;
import com.sept.rest.webservices.restfulwebservices.students.StudentsRepository;

// Class containing all mappings related to posts on a wall
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class WallResource {

	@Autowired
	private PostsRepository postsRepository;
	@Autowired
	private PostLikesRepository postLikesRepository;
	@Autowired
	private CommentsRepository commentsRepository;
	@Autowired
	private CommentLikesRepository commentLikesRepository;
	@Autowired
	private StudentsRepository studentsRepository;

	// Mapping to get a list of all undeleted posts for a given wall
	// When specific id can be determined rework to fetch appropriate wall
	@GetMapping(path = "/jpa/users/{username}/post/{postId}/comment")
	public List<Comments> sendVisibleCommentsList(@PathVariable String username, @PathVariable Integer postId) {

		List<Comments> list = commentsRepository.findByParentIdAndDeletedFalseOrderByCreationTimeDesc(postId);

		for (Comments comment : list) {
			Students author = studentsRepository.findByStudentId(comment.getAuthorID());
			comment.setAuthorName(author.getDisplay_Name());
			List<CommentLikes> likes = commentLikesRepository.findByIdCommentId(comment.getCommentID());
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
	public ResponseEntity<Void> newComment(@PathVariable String username, @PathVariable Integer postId,
			@RequestBody Comments comment) {

		// Ensure new comment will be appended to the correct post
		comment.setAuthorID(studentsRepository.findBydisplayName(username).getStudentID());
		comment.setParentId(postId);

		// Store new post in database
		Comments newComment = commentsRepository.save(comment);

		// Append the new Posts id to the url path
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(newComment.getCommentID()).toUri();

		// Construct an entity to return
		return ResponseEntity.created(uri).build();
	}

	// Mapping to edit a post. Returns unedited post with unauthorized status if
	// user is not posts owner
	@PutMapping("/jpa/users/{username}/comment/{commentId}")
	public ResponseEntity<Comments> updateComment(@PathVariable String username, @PathVariable Long commentId,
			@RequestBody Comments comment) {

		// Check that this is post by the user
		if (studentsRepository.findBydisplayName(username).getStudentID() == comment.getAuthorID()) {
			int ownerID = studentsRepository.findBydisplayName(username).getStudentID();
			comment.setAuthorID(ownerID);
			// Store edited post in database
			Comments editedComment = commentsRepository.save(comment);

			// Construct an entity to return
			return new ResponseEntity<Comments>(editedComment, HttpStatus.OK);
		}

		// User not Authorized to edit post. Unchanged post returned with appropriate
		// status
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
		commentLikesRepository.save(like);

		return ResponseEntity.noContent().build();
	}

	// Mapping to get a list of all undeleted posts for a given wall
	// When specific id can be determined rework to fetch appropriate wall
	@GetMapping(path = "/jpa/users/{username}/wall")
	public List<Posts> sendVisiblePostList(@PathVariable String username) {
		System.out.println("getting");
		int studentId = studentsRepository.findBydisplayName(username).getStudentID();
		List<Posts> list = postsRepository.findByOwnerIdAndDeletedFalseOrderByCreationTimeDesc(studentId);

		for (Posts post : list) {
			List<PostLikes> likes = postLikesRepository.findByIdPostId(post.getPostID());
			post.setLikes(likes.size());
		}

		return list;
	}

	// Mapping to get a specific post if undeleted
	@GetMapping(path = "/jpa/users/{username}/post/{postId}")
	public Posts getPost(@PathVariable String username, @PathVariable Integer postId) {
		return postsRepository.findBypostIdAndDeletedFalse(postId);
	}

	// Mapping to add a new post to the wall
	@PostMapping(path = "/jpa/users/{username}/wall")
	public ResponseEntity<Void> newPost(@PathVariable String username, @RequestBody Posts post) {

		// Ensure new post will be appended to users wall and not someone else's
		post.setOwnerID(studentsRepository.findBydisplayName(username).getStudentID());

		// Store new post in database
		Posts newPost = postsRepository.save(post);

		// Append the new Posts id to the url path
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newPost.getPostID())
				.toUri();

		// Construct an entity to return
		return ResponseEntity.created(uri).build();
	}

	// Mapping to edit a post. Returns unedited post with unauthorized status if
	// user is not posts owner
	@PutMapping("/jpa/users/{username}/post/{postId}")
	public ResponseEntity<Posts> updatePost(@PathVariable String username, @PathVariable Integer postId,
			@RequestBody Posts post) {

		// Check that this is post by the user
		if (studentsRepository.findBydisplayName(username).getStudentID() == post.getOwnerID()) {
			int ownerID = studentsRepository.findBydisplayName(username).getStudentID();
			post.setOwnerID(ownerID);
			post.setPostID(postId);
			// Store edited post in database
			Posts editedPost = postsRepository.save(post);

			// Construct an entity to return
			return new ResponseEntity<Posts>(editedPost, HttpStatus.OK);
		}

		// User not Authorized to edit post. Unchanged post returned with appropriate
		// status
		return new ResponseEntity<Posts>(post, HttpStatus.FORBIDDEN);
	}

	// Mapping to remove a post from the wall
	@DeleteMapping("/jpa/users/{username}/post/{postId}")
	public ResponseEntity<Void> deletePost(@PathVariable String username, @PathVariable Integer postId) {

		// Retrieve post to be removed from the wall

		Posts post = postsRepository.findBypostIdAndDeletedFalse(postId);

		// Check that user has permission to delete post
		if (studentsRepository.findBydisplayName(username).getStudentID() == post.getOwnerID()) {

			// Set post to not be displayed
			post.setDeleted(true);

			// Update database
			postsRepository.save(post);
			// Construct an entity to return
			return ResponseEntity.noContent().build();
		}
		// User not authorized to delete post. Respond with appropriate status
		return new ResponseEntity<Void>(HttpStatus.FORBIDDEN);
	}

	// Mapping to Like a post
	@GetMapping("/jpa/users/{username}/post/{postId}/like")
	public ResponseEntity<Void> likePost(@PathVariable String username, @PathVariable Integer postId) {
		// get user id
		int studentId = studentsRepository.findBydisplayName(username).getStudentID();

		// create Like entity
		PostLikes like = new PostLikes(postId, studentId);

		// store it
		postLikesRepository.save(like);

		return ResponseEntity.noContent().build();
	}
}