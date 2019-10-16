package com.sept.rest.webservices.restfulwebservices.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sept.rest.webservices.restfulwebservices.entities.PostLikes;

@Repository
public interface PostLikesRepository extends CrudRepository<PostLikes, Integer> {
	List<PostLikes> findByStudentId(Integer studentID);
	
	List<PostLikes> findByPostId(Integer postID);
}
