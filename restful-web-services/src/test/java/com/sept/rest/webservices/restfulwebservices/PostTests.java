package com.sept.rest.webservices.restfulwebservices;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.After;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

//import com.inflectra.spiratest.addons.junitextension.SpiraTestCase;
//import com.inflectra.spiratest.addons.junitextension.SpiraTestConfiguration;
import com.sept.rest.webservices.user.Students;
import com.sept.rest.webservices.wall.PostID;

class PostTests {

	static PostID post;
	static Students user;
	static Students user1;
	static Date date;
	
	@BeforeAll	
	public static void setUpBeforeClass() throws Exception {
		date = new Date();
		user = new Students("Mr Bean",3999999,"Mr","Bean");
		post = new PostID(user.getStudentID(), "Hello, this is a post", date);
		user1 = new Students("Mr Bean",001,"Mr","Bean");
		post.likePost(user1);
		user1 = new Students("Mr Bean",002,"Mr","Bean");
		post.likePost(user1);
		user1 = new Students("Mr Bean",003,"Mr","Bean");
		post.likePost(user1);
		user1 = new Students("Mr Bean",004,"Mr","Bean");
		post.likePost(user1);
		user1 = new Students("Mr Bean",005,"Mr","Bean");
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

		user1 = new Students("Mr Bean",010,"Mr","Bean");
		post.likePost(user1);
		assertEquals(6,post.getNoLikes());
	}
	
	@Test
	public void testRejectLike() {
		
		user1 = new Students("Mr Bean",005,"Mr","Bean");
		assertTrue(post.likePost(user1));
	}
	
	@AfterEach
	public void resetDisplay() {
		
		post.editPost("Hello, this is a post");
		if(!post.getDisplay())
			post.setDisplay();
		
		if(post.getNoLikes()==6)
			post.removeLike(new Students("Mr Bean",010,"Mr","Bean"));
	}


}
