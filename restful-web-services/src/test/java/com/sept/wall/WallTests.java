package com.sept.wall;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;


public class WallTests {

	static Post post;
	static User user;
	static User user1;
	static LocalDate date;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		user = new User("Mr Bean",3999999,"Mr","Bean");
		post = new Post(user, 001, "Hello, this is a post");
		date = LocalDate.now();
		
		user1 = new User("Mr Bean",001,"Mr","Bean");
		post.likePost(user1);
		user1 = new User("Mr Bean",002,"Mr","Bean");
		post.likePost(user1);
		user1 = new User("Mr Bean",003,"Mr","Bean");
		post.likePost(user1);
		user1 = new User("Mr Bean",004,"Mr","Bean");
		post.likePost(user1);
		user1 = new User("Mr Bean",005,"Mr","Bean");
		post.likePost(user1);
		
	}

	@Test
	public void testDate() {
		assertEquals(date,post.getDate());
	}
	
	@Test
	public void testDisplayTrue() {
		assertTrue(post.getDisplay());
	}
		
	@Test
	public void testDisplayToggle() {
		
		post.setDisplay();
		assertFalse(post.getDisplay());
	}
	
	@Test
	public void testMessage() {
		
		assertEquals("Hello, this is a post", post.getPost());
	}
	
	@Test
	public void testEditPost() {

		post.editPost("Truly, this is a post");
		assertEquals("Truly, this is a post", post.getPost());
	}
	
	@Test
	public void testNoLikes() {
		assertEquals(5,post.getNoLikes());
	}
	
	@Test
	public void testAddLike() {

		user1 = new User("Mr Bean",010,"Mr","Bean");
		post.likePost(user1);
		assertEquals(6,post.getNoLikes());
	}
	
	@Test
	public void testRejectLike() {
		
		user1 = new User("Mr Bean",005,"Mr","Bean");
		assertTrue(post.likePost(user1));
	}
	
	@After
	public void resetDisplay() {
		
		post.editPost("Hello, this is a post");
		if(!post.getDisplay())
			post.setDisplay();
		
		if(post.getNoLikes()==6)
			post.removeLike(new User("Mr Bean",010,"Mr","Bean"));
	}


}
