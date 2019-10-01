package com.sept.rest.webservices.restfulwebservices.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sept.rest.webservices.restfulwebservices.entities.Comments;

@Repository
public interface CommentsRepository extends CrudRepository<Comments, Long> {

	List<Comments> findByParentIdAndDeletedFalseOrderByCreationTimeDesc(Integer PostID);

	Comments findByCommentIdAndDeletedFalse(long id);
	
	
}
