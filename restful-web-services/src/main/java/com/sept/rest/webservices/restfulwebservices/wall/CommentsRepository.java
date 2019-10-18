package com.sept.rest.webservices.restfulwebservices.wall;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentsRepository extends CrudRepository<Comments, Long> {

	List<Comments> findByParentIdAndDeletedFalseOrderByCreationTimeDesc(Integer PostID);

	Comments findByCommentIdAndDeletedFalse(long id);
	
	
}
