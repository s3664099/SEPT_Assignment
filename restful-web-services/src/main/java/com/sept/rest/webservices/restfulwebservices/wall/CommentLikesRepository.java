package com.sept.rest.webservices.restfulwebservices.wall;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentLikesRepository extends CrudRepository<CommentLikes, CommentLikesIdentity> {
	List<CommentLikes> findByIdStudentId(Integer studentID);
	
	List<CommentLikes> findByIdCommentId(Long CommentID);
}
