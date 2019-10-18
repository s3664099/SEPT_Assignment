package com.sept.rest.webservices.restfulwebservices.wall;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostLikesRepository extends CrudRepository<PostLikes, PostLikesIdentity> {
	List<PostLikes> findByIdStudentId(Integer studentID);
	
	List<PostLikes> findByIdPostId(Integer postID);
}
