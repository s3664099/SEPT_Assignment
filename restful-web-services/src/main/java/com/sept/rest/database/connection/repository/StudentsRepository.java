package com.sept.rest.database.connection.repository;

import com.sept.rest.database.connection.entity.Students;
import org.springframework.data.repository.CrudRepository;

public interface StudentsRepository extends CrudRepository<Students, Integer> {
	
}