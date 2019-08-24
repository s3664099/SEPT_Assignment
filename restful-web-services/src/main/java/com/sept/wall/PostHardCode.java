package com.sept.wall;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PostHardCode {
	
	private static List<Post> postlist = new ArrayList<Post>();
	private int postValue = 39;
	
	public PostHardCode() {
		postlist.add(new Post (34,"This is cool",LocalDate.now()));
		postlist.add(new Post (38,"Multiple Choice Sucks",LocalDate.now()));
		postlist.add(new Post (21,"Not cool dude, not cool",LocalDate.now()));
		postlist.add(new Post (30,"Yeah, just that",LocalDate.now()));
	}
	
	public List getAll() {
		return postlist;
	}
	
	public void add(String post) {
		postlist.add(new Post(postValue, post, LocalDate.now()));
	}
	
	public Post findPostbyId(int id) {
		Post foundpost = null;
		
		for (Post post: postlist) {
			if (id == post.getId())
				foundpost = post;
		}
		
		return foundpost;
	}
	
	public void deletePost(int id) {
		
		for (Post post: postlist) {
			if (id == post.getId())
				post.setDisplay();
		}
		
	}

}
