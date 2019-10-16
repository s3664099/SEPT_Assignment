package com.sept.rest.webservices.restfulwebservices.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CommentLikes {
	public CommentLikes(Long commentId, int studentId) {
		super();
		this.commentId = commentId;
		this.studentId = studentId;
	}
	
	public CommentLikes() {
		
	}
	
	@Id
	private Long commentId;
	private int studentId;
	
	public Long getPostId() {
		return commentId;
	}
	public void setPostId(Long commentId) {
		this.commentId = commentId;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
}
