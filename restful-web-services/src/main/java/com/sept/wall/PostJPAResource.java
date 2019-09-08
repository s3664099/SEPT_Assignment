package com.sept.wall;

import java.net.URI;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

//sets up the middleware section of the system
@RestController
@CrossOrigin(origins="http://localhost:4200")

public class PostJPAResource {
	
	//creates a constructor to be used for the process
	@Autowired

	//At this stage this is hardcoded
	//However, it will be the class which ultimately sends the SQL through
	//to the database
	private PostHardCode backEndDataBase;
	//DBLink code;
	
	private PostJPARepository postRepository;
			
	//method to get a list of all visible posts
	@GetMapping(path = "users/{studentid}/Posts")
	public List<Post> sendVisiblePostList(@PathVariable int studentid) {
		
		return postRepository.findByStudentId(studentid);
		
	}
		
	//delete post by id
	@DeleteMapping(path = "users/{studentid}/Posts/{id}")
	public ResponseEntity<String> DeletePost(@PathVariable int studentid, @PathVariable Long id) {
		
		//Attempts to delete the post
		postRepository.deleteById(id);

		//otherwise the successful request is returned
		return ResponseEntity.noContent().build();
		
	}
	
	//get post by id
	@GetMapping(path = "users/{studentid}/Posts/{id}")
	public Post getPost(@PathVariable int studentid, @PathVariable Long id) {
		
		return postRepository.findById(id).get();
		
	}
	
	//add a new post to the wall
	@PostMapping(path = "users/{studentid}/Posts")
	public ResponseEntity<Void> newPost(@PathVariable int studentid, @RequestBody Post post) {
		
		Date date = new Date();
		
		post.setUser(studentid);
		post.setDate(date);

		Post createdPost = postRepository.save(post);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(createdPost.getId()).toUri();
		
		return ResponseEntity.created(uri).build();		
		
	}
	
	//add a new comment to the wall
	@PostMapping(path = "users/{studentid}/Posts/{parentPostId}")
	public ResponseEntity<Void> newComment(@PathVariable int studentid,
			@PathVariable Long parentPostId, @RequestBody Post post) {
		
		Date date = new Date();
		
		post.setUser(studentid);
		post.setDate(date);
		post.setParentPostId(parentPostId);

		Post createdPost = postRepository.save(post);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(createdPost.getId()).toUri();
		
		return ResponseEntity.created(uri).build();		
		
	}
	
	//edit post on wall
	@GetMapping(path = "users/{studentid}/Posts/{id}")
	public ResponseEntity<Post> editPost(@PathVariable int studentId, @PathVariable Long id, @RequestBody Post post ) {
				
		post.setModDate();
		post.setUser(studentId);
		Post postUpdated = postRepository.save(post);
		
		return new ResponseEntity<Post>(post, HttpStatus.OK);
	}

}