package com.sept.rest.webservices.wall;

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
	private PostIDHardCode backEndDataBase;
	//DBLink code;
	
	private PostIDJPARepository postRepository;
	
	//method to get a list of all visible posts
	@GetMapping(path = "users/{username}/Posts")
	public List<PostID> sendVisiblePostList(@PathVariable long studentid) {
		
		//return postRepository.findByStudentId(studentid);
		return backEndDataBase.getAllVisible(1);
	}
	
	//delete post by id
	@DeleteMapping(path = "users/{username}/Posts/{id}")
	public ResponseEntity<String> DeletePost(@PathVariable int studentid, @PathVariable int id) {
		
		//Attempts to delete the post
		//postRepository.deleteById(id);
		backEndDataBase.deletePost(studentid, id);

		//otherwise the successful request is returned
		return ResponseEntity.noContent().build();
		
	}
	
	//add a new post to the wall
	@PostMapping(path = "users/{studentid}/Posts/{add}")
	public List newPost(@PathVariable int studentid, @RequestBody PostID post) {
		
		Date date = new Date();
		
		post.setUser(studentid);
		post.setDate(date);
		
		backEndDataBase.addPostToWall(post);

		/*
		PostID createdPost = postRepository.save(post);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(createdPost.getId()).toUri();
		*/
		
		return backEndDataBase.getAllVisible(studentid);		
		
	}
	
	//edit post on wall
	@GetMapping(path = "users/{studentid}/Posts/{id}")
	public List editPost(@PathVariable int studentId, @PathVariable int id, @RequestBody PostID temppost ) {
		
		PostID post = backEndDataBase.findPostbyId(studentId, id);
		
		post.editPost(temppost.getPost());
		post.setUser(studentId);
		
		//PostID postUpdated = postRepository.save(post);
		
		return backEndDataBase.getAllVisible(studentId);
	}
	

}
