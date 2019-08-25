package com.sept.wall;

import java.sql.ResultSet;

public interface DBint {
	
	public ResultSet getPosts(int studentID);
	
	public ResultSet getPostId();
	
	public void addPost(Post post);

}
