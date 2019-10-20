package com.sept.rest.webservices.restfulwebservices;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.sept.rest.webservices.restfulwebservices.wall.CommentLikes;
import com.sept.rest.webservices.restfulwebservices.wall.CommentLikesIdentity;

@RunWith(SpringRunner.class)
@ContextConfiguration()
@SpringBootTest
public class CommentLikesTest {

	private static CommentLikes likes;
	private static CommentLikesIdentity id;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception{
		Long commentId = (long) 1;
		int studentId = 2;
		id = new CommentLikesIdentity(commentId, studentId);
		likes = new CommentLikes(id);
		
	}
	
	@Test 
	public void getId() {
		Long commentId = (long) 1;
		int studentId = 2;
		CommentLikesIdentity expect = new CommentLikesIdentity(commentId, studentId);
		likes.setId(new CommentLikesIdentity(commentId, studentId));
		CommentLikesIdentity result = likes.getId();
		assertEquals(result, expect);
	}
	
	@Test
	public void getCommmentId() {
		Long expect = (long) 1;
		likes.setCommentId((long)1);
		Long result = likes.getCommentId();
		assertEquals(result, expect);
	}
	
	@Test
	public void setId() {
		Long commentId = (long)2;
		int studentId = 4;
		CommentLikesIdentity expect = new CommentLikesIdentity(commentId, studentId);
		likes.setId(new CommentLikesIdentity(commentId, studentId));
		CommentLikesIdentity result = likes.getId();
		assertEquals(result, expect);
	}
	
	@Test
	public void setCommentId() {
		Long commentId = (long) 3;
		likes.setCommentId(commentId);
		Long expect = (long) 3;
		Long result = likes.getCommentId();
		assertEquals(result, expect);
	}
	
	@Test
	public void setAndGetStudentId() {
		int expect = 4;
		likes.setStudentId(4);
		int result = likes.getStudentId();
		assertEquals(result, expect);
	}
	
	
	
	
	
	
}
