package com.sept.rest.webservices.restfulwebservices.wall;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.sept.rest.webservices.restfulwebservices.entities.Students;
import com.sept.rest.webservices.restfulwebservices.repositories.StudentsRepository;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class StudentResource {
	
	@Autowired
	private StudentsRepository studentsRepository;
	
	@GetMapping(path = "/jpa/users/studentlist")
	public List<Students> viewStudentList() {
		return studentsRepository.findAll();
	}
	
	@GetMapping(path = "/jpa/users/student/{username}")
	public Students getStudent(@PathVariable String username) {
		return studentsRepository.findBydisplayName(username);
	}
}