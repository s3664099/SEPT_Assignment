package com.sept.wall;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

//This needs to be added to allow the autowired to function
@Service
public class PostHardCode {
	
	//creates a list of posts and sets the last value
	private static List<Post> postlist = new ArrayList<Post>();
	private int postValue = 39;
	
	//creates and adds some posts to the list
	static {
		postlist.add(new Post (34,"This is cool",LocalDate.now()));
		postlist.add(new Post (38,"Multiple Choice Sucks",LocalDate.now()));
		postlist.add(new Post (21,"Not cool dude, not cool",LocalDate.now()));
		postlist.add(new Post (30,"Yeah, just that",LocalDate.now()));
	}
	
	//returns a list of all posts
	public List getAll(int studentId) {
		return postlist;
	}
	
	//returns a list of all visible posts
	public List getAllVisible(int studentId) {
		
		List<Post> listToSend = new ArrayList<Post>();
		
		//iterates through list of posts and removes the ones 
		//that aren't visible
		for (Post post:postlist) {
			if (post.getDisplay())
				listToSend.add(post);
		}
		
		return listToSend;
	}
	
	//adds a post to the list
	public void add(int studentId, String post) {
		postlist.add(new Post(postValue, post, LocalDate.now()));
		postValue++;
	}
	
	//returns a post based on the id passed through to it
	public Post findPostbyId(int studentId, int id) {
		Post foundpost = null;
		
		for (Post post: postlist) {
			if (id == post.getId())
				foundpost = post;
		}
		
		return foundpost;
	}
	
	//deletes a post based on the id of the post
	public void deletePost(int studentId, int id) {
		
		for (Post post: postlist) {
			if (id == post.getId())
				post.setDisplay();
		}
		
	}
	
	//get a post based on the id of the post
	public Post getPostById(int studentId, int id) {
		
		Post postToReturn = null;
		
		for (Post post: postlist) {
			if (id == post.getId())
				postToReturn = post;
		}
		
		return postToReturn;
		
	}

}
