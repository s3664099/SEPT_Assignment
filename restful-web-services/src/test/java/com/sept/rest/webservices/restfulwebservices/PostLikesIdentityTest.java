package com.sept.rest.webservices.restfulwebservices;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.sept.rest.webservices.restfulwebservices.students.Students;
import com.sept.rest.webservices.restfulwebservices.wall.PostLikesIdentity;

@RunWith(SpringRunner.class)
@ContextConfiguration()
@SpringBootTest


public class PostLikesIdentityTest {
	
	private static PostLikesIdentity like;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception{
		like = new PostLikesIdentity(20, 10);
	}
	
	@Test
	public void getPostId() {
		int expect = 20;
		like.setPostId(20);
		int result = like.getPostId();
		assertEquals(result, expect);
	}
	
	@Test
	public void getStudentId() {
		int expect = 10;
		like.setStudentId(10);
		int result = like.getStudentId();
		assertEquals(result, expect);
	}
	
	@Test
	public void setPostId() {
		int expect = 30;
		like.setPostId(30);
		int result = like.getPostId();
		assertEquals(result, expect);
	}
	
	@Test
	public void setStudentId() {
		int expect = 40;
		like.setStudentId(40);
		int result = like.getStudentId();
		assertEquals(result, expect);
	}
}
