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

import com.sept.rest.webservices.restfulwebservices.entities.Posts;
import com.sept.rest.webservices.restfulwebservices.repositories.PostsRepository;
import com.sept.rest.webservices.restfulwebservices.repositories.StudentsRepository;

// Class containing all mappings related to posts on a wall
@RestController
@CrossOrigin(origins="http://localhost:4200")
public class PostsResource {
	
	@Autowired
	
	private PostsRepository postsRepository;
	private StudentsRepository studentsRepository;
	
	// Mapping to get a list of all undeleted posts for a given wall
	//		When specific id can be determined rework to fetch appropriate wall
	@GetMapping(path = "/jpa/users/{username}/wall")
	public List<Posts> sendVisiblePostList(@PathVariable String username) {
		int studentId = studentsRepository.findByDisplay_name(username).getStudentID();
		return postsRepository.findByOwner_idAndDeletedFalse(studentId);
	}
	
	// Mapping to get a specific post if undeleted
	@GetMapping(path = "/jpa/users/{username}/post/{postId}")
	public Posts getPost(@PathVariable String username, @PathVariable int postId) {
		return postsRepository.findByIdAndDeletedFalse(postId);
	}
	
	// Mapping to add a new post to the wall
	@PostMapping(path = "/jpa/users/{username}/wall/{wallId}")
	public ResponseEntity<Void> newPost(@PathVariable String username, @PathVariable int wallId, @RequestBody Posts post) {
		
		// Ensure new post will be appended to users wall and not someone else's
		post.setOwnerID(studentsRepository.findByDisplay_name(username).getStudentID());
			
		// Store new post in database
		Posts newPost = postsRepository.save(post);
			
		// Append the new Posts id to the url path
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newPost.getPostID()).toUri();
			
		// Construct an entity to return
		return ResponseEntity.created(uri).build();
	}
	
	// Mapping to edit a post. Returns unedited post with unauthorized status if user is not posts owner
	@PutMapping("/jpa/users/{username}/post/{postId}")
	public ResponseEntity<Posts> updateTodo(
			@PathVariable String username,
			@PathVariable int postId, @RequestBody Posts post) {
		
		// Check that this is post by the user
		if (studentsRepository.findByDisplay_name(username).getStudentID() == post.getOwnerID()) {

			// Store edited post in database
			Posts editedPost = postsRepository.save(post);
			
			// Construct an entity to return
			return new ResponseEntity<Posts>(editedPost, HttpStatus.OK);
		}
		
		// User not Authorized to edit post. Unchanged post returned with appropriate status
		return new ResponseEntity<Posts>(post, HttpStatus.UNAUTHORIZED);
	}
	
	// Mapping to remove a post from the wall
	@DeleteMapping("/jpa/users/{username}/post/{postId}")
	public ResponseEntity<Void> deletePost(
			@PathVariable String username, @PathVariable int postId) {

		// Retrieve post to be removed from the wall
		Posts post = postsRepository.findByIdAndDeletedFalse(postId);
		
		// Check that user has permission to delete post
		if (studentsRepository.findByDisplay_name(username).getStudentID() == post.getOwnerID()) {
			
			// Set post to not be displayed
			post.setDeleted(true);
			
			// Update database
			postsRepository.save(post);
			
			// Construct an entity to return
			return ResponseEntity.noContent().build();
		}
		
		// User not authorized to delete post. Respond with appropriate status
		return new ResponseEntity<Void>(HttpStatus.UNAUTHORIZED);
	}

}