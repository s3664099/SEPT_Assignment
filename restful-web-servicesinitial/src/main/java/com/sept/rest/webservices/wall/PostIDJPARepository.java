package com.sept.rest.webservices.wall;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostIDJPARepository extends JpaRepository<Post, Long> {
	
	List<Post> findByStudentId(int studentNumber);
	
}
