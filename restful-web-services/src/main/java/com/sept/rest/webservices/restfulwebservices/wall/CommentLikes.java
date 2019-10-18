package com.sept.rest.webservices.restfulwebservices.wall;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class CommentLikes {
	public CommentLikes() {
		
	}
	
	public CommentLikes(CommentLikesIdentity id) {
		super();
		this.id = id;
	}
	
	public CommentLikes(Long commentId, int studentId) {
		super();
		this.id = new CommentLikesIdentity(commentId, studentId);
	}

	@EmbeddedId
	private CommentLikesIdentity id;

	public CommentLikesIdentity getId() {
		return id;
	}

	public void setId(CommentLikesIdentity id) {
		this.id = id;
	}
	
	public Long getCommentId() {
		return id.getCommentId();
	}
	
	public void setCommentId(Long commentId) {
		id.setCommentId(commentId);
	}
	
	public int getStudentId() {
		return id.getStudentId();
	}
	
	public void setStudentId(int studentId) {
		id.setStudentId(studentId);
	}
}
