package com.sept.rest.webservices.restfulwebservices.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sept.rest.webservices.restfulwebservices.entities.CommentLikes;
import com.sept.rest.webservices.restfulwebservices.entities.CommentLikesIdentity;

@Repository
public interface CommentLikesRepository extends CrudRepository<CommentLikes, CommentLikesIdentity> {
	List<CommentLikes> findByIdStudentId(Integer studentID);
	
	List<CommentLikes> findByIdCommentId(Long CommentID);
}
