package com.sept.rest.database.connection;

import java.sql.*;

/**
 * Class defining a connection to the test database and executing queries against it.
 * 
 * @author Jon Ware
 *
 */
public class TestDatabase {
	private static final String DB_NAME = "High5Database";
	private static final String DB_USER = "root";
	private static final String	DB_PASS = "High5";
	private static final String DB_URL = "127.0.0.1:32768";
	
	private Connection db;
	
	public TestDatabase() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			
			DriverManager.getConnection(String.format("jdbc:mysql://%s/%s", DB_URL, DB_NAME), DB_USER, DB_PASS);
    	} catch (SQLException ex) {
    		System.err.println("SQLException: " + ex.getMessage());
    		System.err.println("SQLState: " + ex.getSQLState());
    		System.err.println("VendorError: " + ex.getErrorCode());
    	} catch (Exception ex) {
        	// TODO: handle the error
    	}
	}
	
	public ResultSet getStudents() {
		ResultSet result = null;
		
		try {
			Statement query = db.createStatement();
			result = query.executeQuery("SELECT * FROM Students");
			query.close();
		} catch (SQLException ex) {
    		System.err.println("SQLException: " + ex.getMessage());
    		System.err.println("SQLState: " + ex.getSQLState());
    		System.err.println("VendorError: " + ex.getErrorCode());
    	}
		
		return result;
	}
	
	public ResultSet getPosts(int studentID) {
		ResultSet result = null;
		
		try {
			Statement query = db.createStatement();
			result = query.executeQuery(String.format("SELECT * "
					+ "FROM WallPosts "
					+ "WHERE OwnerID = %s "
					+ "ORDER BY Creation_Time = ", 
					studentID));
		} catch (SQLException ex) {
    		System.err.println("SQLException: " + ex.getMessage());
    		System.err.println("SQLState: " + ex.getSQLState());
    		System.err.println("VendorError: " + ex.getErrorCode());
    	}
		
		return result;
	}
	
	public ResultSet getWallComments(int postID) {
		ResultSet result = null;
		
		try {
			Statement query = db.createStatement();
			result = query.executeQuery(String.format("SELECT Students.Display_Name, WallComments.CommentID, WallComments.ParentID, WallComments.AuthorID, WallComments.Creation_Time, WallComments.Modified_Time, WallComments.Message, WallComments.Edited, WallComments.Deleted "
					+ "FROM WallComments "
					+ "JOIN Students ON WallComments.AuthorID = Students.StudentID "
					+ "WHERE WallComments.ParentID = %s "
					+ "ORDER BY WallComments.Creation_Time", 
					postID));
		} catch (SQLException ex) {
    		System.err.println("SQLException: " + ex.getMessage());
    		System.err.println("SQLState: " + ex.getSQLState());
    		System.err.println("VendorError: " + ex.getErrorCode());
    	}
		
		return result;
	}
	
	public ResultSet deletePost(int postID) {
		ResultSet result = null;
		
		try {
			Statement query = db.createStatement();
			result = query.executeQuery(String.format("UPDATE WallPosts "
					+ "SET Deleted = true "
					+ "WHERE PostID = %s", 
					postID));
		} catch (SQLException ex) {
    		System.err.println("SQLException: " + ex.getMessage());
    		System.err.println("SQLState: " + ex.getSQLState());
    		System.err.println("VendorError: " + ex.getErrorCode());
    	}
		
		return result;
	}
	
	public ResultSet editPost(int postID, String message) {
		ResultSet result = null;
		
		try {
			Statement query = db.createStatement();
			result = query.executeQuery(String.format("UPDATE WallPosts "
					+ "SET Edited = true, Message = %s "
					+ "WHERE PostID = %s", 
					message, postID));
		} catch (SQLException ex) {
    		System.err.println("SQLException: " + ex.getMessage());
    		System.err.println("SQLState: " + ex.getSQLState());
    		System.err.println("VendorError: " + ex.getErrorCode());
    	}
		
		return result;
	}
	
	public ResultSet createPost(int studentID, String message) {
		ResultSet result = null;
		// TODO: update database to automatically generate PostID 
		try {
			Statement query = db.createStatement();
			result = query.executeQuery(String.format("INSERT INTO WallPosts "
					+ "(AuthorID, Message)"
					+ "VALUES %s, %s", 
					studentID, message));
		} catch (SQLException ex) {
    		System.err.println("SQLException: " + ex.getMessage());
    		System.err.println("SQLState: " + ex.getSQLState());
    		System.err.println("VendorError: " + ex.getErrorCode());
    	}
		
		return result;
	}
	
	public ResultSet deleteComment(int commentID) {
		ResultSet result = null;
		
		try {
			Statement query = db.createStatement();
			result = query.executeQuery(String.format("UPDATE WallComments "
					+ "SET Deleted = true "
					+ "WHERE CommentID = %s", 
					commentID));
		} catch (SQLException ex) {
    		System.err.println("SQLException: " + ex.getMessage());
    		System.err.println("SQLState: " + ex.getSQLState());
    		System.err.println("VendorError: " + ex.getErrorCode());
    	}
		
		return result;
	}
	
	public ResultSet editComment(int commentID, String message) {
		ResultSet result = null;
		
		try {
			Statement query = db.createStatement();
			result = query.executeQuery(String.format("UPDATE WallComments "
					+ "SET Edited = true, Message = %s "
					+ "WHERE CommentID = %s", 
					message, commentID));
		} catch (SQLException ex) {
    		System.err.println("SQLException: " + ex.getMessage());
    		System.err.println("SQLState: " + ex.getSQLState());
    		System.err.println("VendorError: " + ex.getErrorCode());
    	}
		
		return result;
	}
	
	public ResultSet createComment(int studentID, String message) {
		ResultSet result = null;
		// TODO: update database to automatically generate CommentID 
		try {
			Statement query = db.createStatement();
			result = query.executeQuery(String.format("INSERT INTO WallComments "
					+ "(AuthorID, Message)"
					+ "VALUES %s, %s", 
					studentID, message));
		} catch (SQLException ex) {
    		System.err.println("SQLException: " + ex.getMessage());
    		System.err.println("SQLState: " + ex.getSQLState());
    		System.err.println("VendorError: " + ex.getErrorCode());
    	}
		
		return result;
	}
	
	public void closeConnection() {
		try {
			db.close();
		} catch (SQLException ex) {
    		System.err.println("SQLException: " + ex.getMessage());
    		System.err.println("SQLState: " + ex.getSQLState());
    		System.err.println("VendorError: " + ex.getErrorCode());
    	} finally {
    		db = null;
		}
	}
}