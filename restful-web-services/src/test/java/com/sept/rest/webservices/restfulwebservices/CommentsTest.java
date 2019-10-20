package com.sept.rest.webservices.restfulwebservices;

import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.sql.Timestamp;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.sept.rest.webservices.restfulwebservices.wall.*;

@RunWith(SpringRunner.class)
@ContextConfiguration()
@SpringBootTest
public class CommentsTest {
	
	private static Comments comments;
	private static Timestamp time;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		time = new Timestamp(0);
		long commentId = 1;
		int authorId = 1;
		Integer parentId = 1;
		comments = new Comments(commentId, authorId, parentId, "message",time, time, false, false);
	}
	
	@Test
	public void setAndGetCommentID() {
		long expect = 20;
		long commentID = 20;
		comments.setCommentID(commentID);
		long result = comments.getCommentID();
		assertEquals(result, expect);
	}
	
	@Test 
	public void setAndGetCommentMessage() {
		String expect = "hello world";
		comments.setMessage("hello world");
		String result = comments.getMessage();
		assertEquals(result, expect);
	}
	
	@Test 
	public void isDeleted() {
		comments.setDeleted(true);
		assertTrue(comments.isDeleted());
		comments.setDeleted(false);
		assertFalse(comments.isDeleted());
	}
	
	@Test
	public void isEdited() {
		assertFalse(comments.isEdited());
	}
	
	@Test
	public void setEdited() {
		comments.setEdited(true);
		assertTrue(comments.isEdited());
		comments.setEdited(false);
		assertFalse(comments.isEdited());
	}
	
	@Test
	public void getCreationTime() {
		Timestamp expected = new Timestamp(0);
		Timestamp result = comments.getCreation_Time();
		assertEquals(result,expected);
	}
	
	@Test
	public void getModifieTime() {
		Timestamp expected = new Timestamp(0);
		Timestamp result = comments.getModified_Time();
		assertEquals(result,expected);
	}

}
