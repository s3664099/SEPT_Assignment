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

public class PostController {
	
	//creates a constructor to be used for the process
	@Autowired

	//At this stage this is hardcoded
	//However, it will be the class which ultimately sends the SQL through
	//to the database
	PostHardCode backEndDataBase;
	//DBLink code;
			
	//method to get a list of all visible posts
	@GetMapping(path = "users/{studentid}/PostVisible")
	public List<Post> sendVisiblePostList(@PathVariable int studentid) {
		
		return backEndDataBase.getAll(studentid);
		
	}
	
	//method to get a list of all posts
	@GetMapping(path = "users/{studentid}/PostAll")
	public List<Post> sendPostList(@PathVariable int studentid) {
		
		return backEndDataBase.getAllVisible(studentid);
		
	}
	
	
	//delete post by id
	@DeleteMapping(path = "users/{studentid}/DeletePost/{id}")
	public ResponseEntity<String> DeletePost(@PathVariable int studentid, @PathVariable int id) {
		
		//Attempts to delete the post
		boolean success = backEndDataBase.deletePost(studentid, id);
		
		//if the attempt is successful, this is advised
		if (!success) {
			return ResponseEntity.badRequest().body("Unable to Locate Post");
		}
		
		//otherwise the successful request is returned
		return ResponseEntity.status(HttpStatus.OK).body("Delete Post Successful");
		
	}
	
	//get post by id
	@GetMapping(path = "users/{studentid}/GetPost/{id}")
	public Post getPost(@PathVariable int studentid, @PathVariable int id) {
		
		return backEndDataBase.findPostbyId(studentid, id);
		
	}
	
	//add a new post to the wall
	@PostMapping(path = "users/{studentid}/AddPost/{post}")
	public ResponseEntity<Void> newPost(@PathVariable int studentid, @RequestBody String post) {
		
		Date date = new Date();

		boolean success = backEndDataBase.addPostToWall(studentid, post, date);
		
		//if the user is not the user for the wall
		if (!success) {
			
			//a bad request is sent back
			return ResponseEntity.badRequest().build();
		}
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(backEndDataBase.getLastPost().getId()).toUri();
		
		return ResponseEntity.created(uri).build();		
		
		
	}
	
	//edit post on wall
	@GetMapping(path = "users/{studentid/EditPost/{id}/{post}")
	public void newPost(@PathVariable int studentId, int id, String post ) {
		
		Post modPost = backEndDataBase.findPostbyId(studentId, id);
		
		modPost.setModDate();
		modPost.editPost(post);
		
	}

}
