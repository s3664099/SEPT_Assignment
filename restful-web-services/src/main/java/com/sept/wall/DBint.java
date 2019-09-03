package com.sept.wall;

import java.sql.Date;
import java.sql.ResultSet;

public interface DBint {
	
	public ResultSet getPosts(int studentID);
	
	public ResultSet getPostId();
	
	public void createPost(int id, String message);
	
	public void editPost(int id, String message);
	
	public void deletePost(int id);

}
