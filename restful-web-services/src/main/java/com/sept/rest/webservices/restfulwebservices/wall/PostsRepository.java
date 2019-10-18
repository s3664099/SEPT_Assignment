package com.sept.rest.webservices.restfulwebservices.wall;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostsRepository extends CrudRepository<Posts, Integer> {

	List<Posts> findByOwnerIdAndDeletedFalseOrderByCreationTimeDesc(Integer studentID);

	Posts findBypostIdAndDeletedFalse(Integer id);
	
	
}
