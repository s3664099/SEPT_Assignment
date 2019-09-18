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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.sept.rest.webservices.restfulwebservices.entities.Posts;
import com.sept.rest.webservices.restfulwebservices.entities.Students;
import com.sept.rest.webservices.restfulwebservices.repositories.PostsRepository;
import com.sept.rest.webservices.restfulwebservices.repositories.StudentsRepository;

//sets up the middleware section of the system
@RestController
@CrossOrigin(origins="http://localhost:4200")
public class PostsResource {
	
	//creates a constructor to be used for the process
	

	//At this stage this is hardcoded
	//However, it will be the class which ultimately sends the SQL through
	//to the database
//	private PostIDHardCode backEndDataBase;
	//DBLink code;

	@Autowired
	private PostsRepository postRepository;
	//private StudentRepository studentRepository;
	
	//method to get a list of all visible posts
	@GetMapping(path = "/jpa/users/{username}/wall")
	public List<Posts> sendVisiblePostList(@PathVariable String username) {
		System.out.println("axios request recieved");
		//int studentID = studentRepository.findByDisplay_name(username).getStudentID();
		//return postRepository.findByStudentId(studentid);
		//return postRepository.findByOwner_id(studentID);
		return (List<Posts>) postRepository.findAll();
	}
	
//	//delete post by id
//	@DeleteMapping(path = "users/{username}/Posts/{id}")
//	public ResponseEntity<String> DeletePost(@PathVariable int studentid, @PathVariable int id) {
//		
//		//Attempts to delete the post
//		//postRepository.deleteById(id);
//		postRepository.deletePost(studentid, id);
//
//		//otherwise the successful request is returned
//		return ResponseEntity.noContent().build();
//		
//	}
//	
//	//add a new post to the wall
//	@PostMapping(path = "users/{studentid}/Posts")
//	public List newPost(@PathVariable int studentid, @RequestBody PostID post) {
//		
//		Date date = new Date();
//		
//		post.setUser(studentid);
//		post.setDate(date);
//		
//		backEndDataBase.addPostToWall(post);
//
//		/*
//		PostID createdPost = postRepository.save(post);
//
//		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
//				.path("/{id}").buildAndExpand(createdPost.getId()).toUri();
//		*/
//		
//		return backEndDataBase.getAllVisible(studentid);		
//		
//	}
//	
//	//edit post on wall
//	@GetMapping(path = "users/{studentid}/Posts/{id}")
//	public List editPost(@PathVariable int studentId, @PathVariable int id, @RequestBody PostID temppost ) {
//		
//		PostID post = backEndDataBase.findPostbyId(studentId, id);
//		
//		post.editPost(temppost.getPost());
//		post.setUser(studentId);
//		
//		//PostID postUpdated = postRepository.save(post);
//		
//		return backEndDataBase.getAllVisible(studentId);
//	}
//	

}
