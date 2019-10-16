package com.sept.rest.webservices.restfulwebservices.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sept.rest.webservices.restfulwebservices.entities.PostLikes;
import com.sept.rest.webservices.restfulwebservices.entities.PostLikesIdentity;

@Repository
public interface PostLikesRepository extends CrudRepository<PostLikes, PostLikesIdentity> {
	List<PostLikes> findByIdStudentId(Integer studentID);
	
	List<PostLikes> findByIdPostId(Integer postID);
}
