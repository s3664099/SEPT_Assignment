package com.sept.rest.database.connection.repository;

import com.sept.rest.database.connection.entity.WallComments;
import org.springframework.data.repository.CrudRepository;

public interface StudentsRepository extends CrudRepository<WallComments, Integer> {
	
}