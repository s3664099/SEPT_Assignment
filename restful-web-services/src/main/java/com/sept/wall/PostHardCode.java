package com.middlewareapp.wall;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

//This needs to be added to allow the autowired to function
@Service
public class PostHardCode {
	
	//creates a list of posts and sets the last value
	private static List<Post> postlist = new ArrayList<Post>();
	private Long postValue = new Long(39);
	private int studentId = 1;
	
	//creates and adds some posts to the list
	static {
		postlist.add(new Post (new Long(34),"This is cool",new Date()));
		postlist.add(new Post (new Long(38),"Multiple Choice Sucks",new Date()));
		postlist.add(new Post (new Long(21),"Not cool dude, not cool",new Date()));
		postlist.add(new Post (new Long(30),"Yeah, just that",new Date()));
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
	public boolean addPostToWall(int studentId, String post, Date date) {
		
		boolean success = false;
		
		if (studentId == this.studentId) {
			postlist.add(new Post(postValue, post, date));
			postValue++;
			success = true;
		}
		
		return success;
	}
	
	//returns the last post added to the list
	public Post getLastPost() {
		
		return postlist.get(postlist.size());
		
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
	public boolean deletePost(int studentId, int id) {
		
		boolean success = false;
		
		for (Post post: postlist) {
			if (id == post.getId()) {
				post.setDisplay();
				success = true;
			}
		}
		
		return success;
		
	}
	
	//get a post based on the id of the post
	public void updatePostById(int studentId, int id, String message) {
		
		Post postToReturn = null;
		
		for (Post post: postlist) {
			if (id == post.getId())
				postToReturn = post;
		}
		
		postToReturn.editPost(message);
		
	}

}
