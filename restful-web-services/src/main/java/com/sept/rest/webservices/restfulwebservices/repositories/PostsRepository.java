package com.sept.rest.webservices.restfulwebservices.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sept.rest.webservices.restfulwebservices.entities.Posts;

@Repository
public interface PostsRepository extends JpaRepository<Posts, Long> {

	List<Posts> findByOwnerIdAndDeletedFalse(int studentID);

	Posts findBypostIdAndDeletedFalse(int id);
	
	
}
