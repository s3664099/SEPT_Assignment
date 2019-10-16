package com.sept.rest.webservices.restfulwebservices.entities;

import java.sql.Timestamp;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Posts {
	
	public Posts() {
		
	}
	
	public Posts(Integer postID, int ownerID, String message, Timestamp creation_Time,
			Timestamp modified_Time,  boolean deleted, boolean edited) 
	{
		super();
		postId = postID;
		ownerId = ownerID;
		this.message = message;
		creationTime = creation_Time;
		modifiedTime = modified_Time;
		this.deleted = deleted;
		this.edited = edited;
	}
	
	//basic post variables
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private Integer postId;
	private int ownerId;
	private String message;
	private Timestamp creationTime;
	private Timestamp modifiedTime;
	private boolean deleted;
	private boolean edited;
	private int likes;
	
	public Integer getPostID() {
		return postId;
	}
	public void setPostID(Integer postID) {
		postId = postID;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getOwnerID() {
		return ownerId;
	}
	public void setOwnerID(int ownerID) {
		ownerId = ownerID;
	}
	public boolean isDeleted() {
		return deleted;
	}
	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
	public boolean isEdited() {
		return edited;
	}
	public void setEdited(boolean edited) {
		this.edited = edited;
	}
	public Timestamp getCreation_Time() {
		return creationTime;
	}
	public Timestamp getModified_Time() {
		return modifiedTime;
	}
	public void setCreation_Time(Timestamp creation_Time) {
		creationTime = creation_Time;
	}
	public void setModified_Time(Timestamp modified_Time) {
		modifiedTime = modified_Time;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (postId ^ (postId >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Posts other = (Posts) obj;
		if (postId != other.postId)
			return false;
		return true;
	}

	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}
}