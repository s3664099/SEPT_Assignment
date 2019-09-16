package com.sept.rest.webservices.wall;

import java.util.Date;

public class CommentID extends PostID {
	
	private Long ParentID;

	//constructors
	public CommentID(int studentNumber, Long postId, Long parentID, String post, Date date, Date modDate, boolean modified) {
	
		super(studentNumber, postId, post, date, modDate, modified);
		
		this.ParentID = parentID;

	}

	public CommentID(int long1, Long parentID, String Message, Date date) {
		super(long1, Message, date);
		
		this.ParentID = parentID;
	}

	//getters & setters
	public Long getParentID() {
		return ParentID;
	}

	public void setParentID(Long parentID) {
		ParentID = parentID;
	}
}
