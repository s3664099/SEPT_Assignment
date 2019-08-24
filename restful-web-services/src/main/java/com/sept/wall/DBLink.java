package com.sept.wall;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DBLink {

	DBint database;
	
	public List<Post> getAll(int studentID) {
		
		List<Post> posts = new ArrayList<Post>();
		
		
		ResultSet results = database.getPosts(studentID);
		
		try {
			while(results.next()) {
			
				Date date = results.getDate(3);
				
				Post post = new Post(results.getInt(2),results.getInt(1),results.getString(5),results.getDate(3));
				
				if (results.getBoolean(7)) {
					posts.add(post);
				} 
			}
			
		} catch (SQLException ex) {
    		System.err.println("SQLException: " + ex.getMessage());
    		System.err.println("SQLState: " + ex.getSQLState());
    		System.err.println("VendorError: " + ex.getErrorCode());
		}
		
		return posts;
	}
	
}
