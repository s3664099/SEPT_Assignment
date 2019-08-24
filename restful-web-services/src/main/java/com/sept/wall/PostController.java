package com.sept.wall;

import java.time.LocalDate;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//Controller
@RestController
@CrossOrigin(origins="http://localhost:4200")

public class PostController {
	
	@GetMapping(path = "/Post")
	public Post SendPost() {
		
		return new Post(1,"This is a post", LocalDate.now());
		
	}
	

}
