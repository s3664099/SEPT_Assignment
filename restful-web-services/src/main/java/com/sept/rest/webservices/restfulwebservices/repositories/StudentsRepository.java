package com.sept.rest.webservices.restfulwebservices.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sept.rest.webservices.restfulwebservices.entities.Students;

@Repository
public interface StudentsRepository extends JpaRepository<Students, Integer> {

	Students findBydisplayName(String username);

	Students findByStudentId(int authorID);
}
