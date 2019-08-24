package com.sept.wall;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

//Controller
@RestController
@CrossOrigin(origins="http://localhost:4200")

public class PostController {
	
	PostHardCode code = new PostHardCode();
	
	@GetMapping(path = "users/Post")
	public Post SendPost() {
		
		return new Post(1,"This is a post", LocalDate.now());
		
	}
	
	@GetMapping(path = "users/{username}/Post/id")
	public ResponseEntity<Void> doPost() {
		
		return ResponseEntity.notFound().build();
	}
	
	@GetMapping(path = "users/{username}/Post")
	public List<Post> SendPostList(@PathVariable String username) {
		
		List<Post> listToSend = new ArrayList<Post>();
		List<Post> listToSearch = code.getAll();
		
		for (Post post:listToSearch) {
			if (post.getDisplay())
				listToSend.add(post);
		}
		
		return listToSend;
		
	}
	
	

}
