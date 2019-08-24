package com.sept.wall;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

//sets up the middleware section of the system
@RestController
@CrossOrigin(origins="http://localhost:4200")

public class PostController {
	
	//creates a constructor to be used for the process
	@Autowired

	//At this stage this is hardcoded
	//However, it will be the class which ultimately sends the SQL through
	//to the database
	PostHardCode code;
			
	//method to get a list of all visible posts
	@GetMapping(path = "users/{studentid}/Post")
	public List<Post> sendVisiblePostList(@PathVariable int studentid) {

		List<Post> listToSend = code.getAll(studentid);
		
		return listToSend;
		
	}
	
	//method to get a list of all posts
	@GetMapping(path = "users/{studentid}/Post")
	public List<Post> sendPostList(@PathVariable int studentid) {

		List<Post> listToSend = code.getAllVisible(studentid);
		
		return listToSend;
		
	}
	
	
	//delete post by id
	@GetMapping(path = "users/{studentid}/Post/{id}")
	public void DeletePost(@PathVariable int studentid, int id) {
		
		code.deletePost(studentid, id);
		
	}
	
	//get post by id
	@GetMapping(path = "users/{studentid}/Post/{id}")
	public Post getPost(@PathVariable int studentid, int id) {
		
		return code.findPostbyId(studentid, id);
		
	}
	
	//add a new post to the wall
	@GetMapping(path = "users/{studentid}/Post/{post}")
	public void newPost(@PathVariable int studentid, String post) {
		
		code.add(studentid, post);
		
	}
	
	
	
	

}
