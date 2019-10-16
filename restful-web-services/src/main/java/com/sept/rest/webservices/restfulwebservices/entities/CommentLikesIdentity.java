package com.sept.rest.webservices.restfulwebservices.entities;

import java.io.Serializable;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Embeddable
public class CommentLikesIdentity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 591499324604891297L;

	public CommentLikesIdentity(Long commentId, int studentId) {
		super();
		this.commentId = commentId;
		this.studentId = studentId;
	}
	
	public CommentLikesIdentity() {
		
	}
	
	@NotNull
	private Long commentId;
	@NotNull
	private int studentId;
	
	public Long getCommentId() {
		return commentId;
	}
	public void setCommentId(Long commentId) {
		this.commentId = commentId;
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
		result = prime * result + ((commentId == null) ? 0 : commentId.hashCode());
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
		CommentLikesIdentity other = (CommentLikesIdentity) obj;
		if (commentId == null) {
			if (other.commentId != null)
				return false;
		} else if (!commentId.equals(other.commentId))
			return false;
		if (studentId != other.studentId)
			return false;
		return true;
	}
}
