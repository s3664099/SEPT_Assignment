package com.sept.rest.webservices.restfulwebservices.students;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentsRepository extends JpaRepository<Students, Integer> {

	Students findBydisplayName(String username);

	Students findByStudentId(int authorID);
}
