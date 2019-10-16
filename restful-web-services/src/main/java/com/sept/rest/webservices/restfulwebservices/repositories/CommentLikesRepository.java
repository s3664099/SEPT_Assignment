package com.sept.rest.webservices.restfulwebservices.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sept.rest.webservices.restfulwebservices.entities.CommentLikes;

@Repository
public interface CommentLikesRepository extends CrudRepository<CommentLikes, Long> {
	List<CommentLikes> findByStudentId(Integer studentID);
	
	List<CommentLikes> findByCommentId(Long CommentID);
}
