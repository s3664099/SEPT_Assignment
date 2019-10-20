package com.sept.rest.webservices.restfulwebservices;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.sept.rest.webservices.restfulwebservices.students.*;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

@RunWith(SpringRunner.class)
@ContextConfiguration()
@SpringBootTest
public class StudentsTest {
	
	private static Students student;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception{
		student = new Students("displayName", 20, "givenName", "familyName");
	}
	
	@Test
	public void getDisplayName() {
		String expect = "displayName";
		String result = student.getDisplay_Name();
		assertEquals(result, expect);
	}
	
	@Test
	public void getStudentID() {
		int expect = 20;
		student.setStudentID(20);
		int result = student.getStudentID();
		assertEquals(result, expect);
	}
	
	@Test
	public void getGivenName() {
		String expect = "givenName";
		student.setGiven_Name("givenName");
		String result = student.getGiven_Name();
		assertEquals(result, expect);
	}
	
	@Test
	public void getFamilyName() {
		String expect = "familyName";
		String result = student.getFamily_Name();
		assertEquals(result, expect);
	}
	
	@Test
	public void setStudentID() {
		int expect = 2;
		student.setStudentID(2);
		int result = student.getStudentID();
		assertEquals(result, expect);
	}
	
	@Test
	public void setGivenName() {
		String expect = "newName";
		student.setGiven_Name("newName");
		String result = student.getGiven_Name();
		assertEquals(result, expect);
	}
	
	@Test
	public void setFamilyName() {
		String expect = "newName";
		student.setFamily_Name("newName");
		String result = student.getFamily_Name();
		assertEquals(result, expect);
	}
	
}
