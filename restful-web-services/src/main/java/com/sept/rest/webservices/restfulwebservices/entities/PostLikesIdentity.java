package com.sept.rest.webservices.restfulwebservices.entities;

import java.io.Serializable;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Embeddable
public class PostLikesIdentity implements Serializable  {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7679256951706535211L;

	public PostLikesIdentity(Integer postId, int studentId) {
		super();
		this.postId = postId;
		this.studentId = studentId;
	}
	
	public PostLikesIdentity() {
		
	}
	
	@NotNull
	private Integer postId;
	@NotNull
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((postId == null) ? 0 : postId.hashCode());
		result = prime * result + studentId;
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
		PostLikesIdentity other = (PostLikesIdentity) obj;
		if (postId == null) {
			if (other.postId != null)
				return false;
		} else if (!postId.equals(other.postId))
			return false;
		if (studentId != other.studentId)
			return false;
		return true;
	}
}
