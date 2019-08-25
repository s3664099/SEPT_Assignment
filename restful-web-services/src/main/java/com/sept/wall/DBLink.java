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
				Post post = new Post(results.getInt(2),results.getInt(1),results.getString(5),
						results.getDate(3), results.getDate(4), results.getBoolean(6));
				
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
				
		//passes the details of the new post to the database to create a new entry
		database.addPost(studentId, message, date);
	}
	
	//method to update a post on the wall
	public void updatePost(int id, String message, Date modDate, boolean modified) {
		
		database.updatePost(id, message, modDate, modified);
		
	}
	
	//method to update a post's visibility
	public void updateVisibility(int id, boolean visibility) {
		
		database.updateVisibility(id, visibility);
		
	}
	

	
}
