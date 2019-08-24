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
			
			DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
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
			result = query.executeQuery("SELECT * FROM WallPosts WHERE OwnerID = " + studentID);
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
			result = query.executeQuery("SELECT * FROM WallComments WHERE ParentID = " + postID);
		} catch (SQLException ex) {
    		System.err.println("SQLException: " + ex.getMessage());
    		System.err.println("SQLState: " + ex.getSQLState());
    		System.err.println("VendorError: " + ex.getErrorCode());
    	}
		
		return result;
	}
	
	
}