package com.middlewareapp.wall;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostJPARepository extends JpaRepository<Post, Long> {
	
	List<Post> findByStudentId(int studentNumber);
	
}
