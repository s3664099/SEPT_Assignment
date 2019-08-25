package com.sept.wall;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBLink {

	//creates the database link
	DBint database;
	
	//method to return all visible posts
	//the results will only be a maximum number of posts however
	//depending on the number of posts the user has on the wall
	public List<Post> getAllVisible(int studentID) {
		
		//creates a list to store the posts
		List<Post> posts = new ArrayList<Post>();
		
		//returns a result set containing all of the posts
		ResultSet results = database.getPosts(studentID);
		
		//removes the data from the result sets
		try {
			while(results.next()) {
			
				//creates a new post containing the details of the post
				Post post = new Post(results.getInt(2),results.getInt(1),results.getString(5),results.getDate(3));
				
				//confirms that the post is visible, and if it is visible
				//adds it to the array list
				if (results.getBoolean(7)) {
					posts.add(post);
				} 
			}
			
		} catch (SQLException ex) {
    		System.err.println("SQLException: " + ex.getMessage());
    		System.err.println("SQLState: " + ex.getSQLState());
    		System.err.println("VendorError: " + ex.getErrorCode());
		}
		
		//returns a list of the posts to the front end
		return posts;
	}
	
	//method to add a new post to the wall
	public void addPostToWall(int studentId, String message, Date date) {
		
		//generates a unique ID by getting the last id in the database
		int postId = getHighestPostId();
		
		//increases the id by one.
		postId++;
		
		//creates a new post object
		Post post = new Post(studentId, postId, message, date);
		
		//passes the object to the database link
		database.addPost(post);
		
	}
	
	//private method to get the last post ID
	private int getHighestPostId() {
		
		//calls an sql to get the highest postID value
		ResultSet results = database.getPostId();
	
		//extracts the value of the ID from the result
		int id = 0;
		try {
			id = results.getInt(1);
		} catch (SQLException ex) {
			
    		System.err.println("SQLException: " + ex.getMessage());
    		System.err.println("SQLState: " + ex.getSQLState());
    		System.err.println("VendorError: " + ex.getErrorCode());
		}
		
		//returns the value of the ID.
		return id;
		
	}
	
}
