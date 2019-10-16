package com.sept.rest.webservices.restfulwebservices.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PostLikes {
	public PostLikes(Integer postId, int studentId) {
		super();
		this.postId = postId;
		this.studentId = studentId;
	}
	
	public PostLikes() {
		
	}
	
	@Id
	private Integer postId;
	private int studentId;
	
	public Integer getPostId() {
		return postId;
	}
	public void setPostId(Integer postId) {
		this.postId = postId;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
}
