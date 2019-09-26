package com.sept.rest.webservices.restfulwebservices.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sept.rest.webservices.restfulwebservices.entities.Posts;

@Repository
public interface PostsRepository extends CrudRepository<Posts, Long> {

	List<Posts> findByOwnerIdAndDeletedFalse(int studentID);

	Posts findBypostIdAndDeletedFalse(int id);
	
}
