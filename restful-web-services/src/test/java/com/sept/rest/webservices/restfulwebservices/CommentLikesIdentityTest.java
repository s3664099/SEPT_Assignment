package com.sept.rest.webservices.restfulwebservices;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;


import com.sept.rest.webservices.restfulwebservices.wall.CommentLikesIdentity;


@RunWith(SpringRunner.class)
@ContextConfiguration()
@SpringBootTest
public class CommentLikesIdentityTest {
	
	private static CommentLikesIdentity likeId;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception{
		Long commentId = (long)1;
		int studentId = 3;
		likeId = new CommentLikesIdentity(commentId, studentId);
	}
	
	@Test
	public void getCommentId() {
		Long expect = (long) 1;
		Long result = likeId.getCommentId();
		assertEquals(result, expect);
	}
	
	@Test
	public void getStudentId() {
		int expect = 3;
		int result = likeId.getStudentId();
		assertEquals(result, expect);
	}
	
	@Test
	public void setCommentId() {
		Long expect = (long) 10;
		likeId.setCommentId((long)10);
		Long result = likeId.getCommentId();
		assertEquals(result, expect);
	}
	
	@Test
	public void setStudentId() {
		int expect = 20;
		likeId.setStudentId(20);
		int result = likeId.getStudentId();
		assertEquals(result, expect);
	}

}
