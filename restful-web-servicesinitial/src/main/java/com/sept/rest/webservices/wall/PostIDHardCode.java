package com.sept.rest.webservices.wall;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

//This needs to be added to allow the autowired to function
@Service
public class PostIDHardCode {
	
	//creates a list of posts and sets the last value
	private static List<PostID> postlist = new ArrayList<PostID>();
	private int postValue = 39;
	private int studentId = 1;
	
	//creates and adds some posts to the list
	static {
		postlist.add(new PostID (34,"This is cool",new Date()));
		postlist.add(new PostID (38,"Multiple Choice Sucks",new Date()));
		postlist.add(new PostID (21,"Not cool dude, not cool",new Date()));
		postlist.add(new PostID (30,"Yeah, just that",new Date()));
	}
	
	//returns a list of all posts
	public List getAll(int studentId) {
		return postlist;
	}
	
	//returns a list of all visible posts
	public List getAllVisible(int studentId) {
		
		List<PostID> listToSend = new ArrayList<PostID>();
		
		//iterates through list of posts and removes the ones 
		//that aren't visible
		for (PostID post:postlist) {
			if (post.getDisplay())
				listToSend.add(post);
		}
		
		return listToSend;
	}
	
	//adds a post to the list
	public void addPostToWall(PostID post) {
		
		postlist.add(post);
	}
	
	//returns the last post added to the list
	public PostID getLastPost() {
		
		return postlist.get(postlist.size());
		
	}
	
	//returns a post based on the id passed through to it
	public PostID findPostbyId(int studentId, int id) {
		PostID foundpost = null;
		
		for (PostID post: postlist) {
			if (id == post.getId())
				foundpost = post;
		}
		
		return foundpost;
	}
	
	//deletes a post based on the id of the post
	public boolean deletePost(int studentId, int id) {
		
		boolean success = false;
		
		for (PostID post: postlist) {
			if (id == post.getId()) {
				post.setDisplay();
				success = true;
			}
		}
		
		return success;
		
	}
	
	//get a post based on the id of the post
	public void updatePostById(int studentId, int id, String message) {
		
		PostID postToReturn = null;
		
		for (PostID post: postlist) {
			if (id == post.getId())
				postToReturn = post;
		}
		
		postToReturn.editPost(message);
		
	}

}
