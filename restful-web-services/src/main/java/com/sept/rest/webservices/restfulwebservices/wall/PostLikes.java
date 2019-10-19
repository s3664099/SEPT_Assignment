package com.sept.rest.webservices.restfulwebservices.wall;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class PostLikes {
	public PostLikes(PostLikesIdentity id) {
		this.id = id;
	}
	
	public PostLikes(Integer postId, int studentId) {
		super();
		this.id = new PostLikesIdentity(postId, studentId);
	}
	
	public PostLikes() {
		
	}
	
	@EmbeddedId
	private PostLikesIdentity id;
	
	public Integer getPostId() {
		return id.getPostId();
	}
	
	public void setPostId(Integer postId) {
		id.setPostId(postId);
	}
	
	public int getStudentId() {
		return id.getStudentId();
	}
	
	public void setStudentId(int studentId) {
		id.setStudentId(studentId);
	}

	public PostLikesIdentity getId() {
		return id;
	}

	public void setId(PostLikesIdentity id) {
		this.id = id;
	}
}
