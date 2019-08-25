package com.sept.wall;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.After;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.example.demo.Post;
import com.example.demo.User;
import com.inflectra.spiratest.addons.junitextension.SpiraTestCase;
import com.inflectra.spiratest.addons.junitextension.SpiraTestConfiguration;

@SpiraTestConfiguration(
        //following are REQUIRED
        url = "https://rmit-university.spiraservice.net",
        login = "s3664099",
        password = "",
        projectId = 379
)

class PostTests {

	static Post post;
	static User user;
	static User user1;
	static Date date;
	
	@BeforeAll	
	public static void setUpBeforeClass() throws Exception {
		date = new Date();
		user = new User("Mr Bean",3999999,"Mr","Bean");
		post = new Post(user.getStudentId(), 001, "Hello, this is a post", date);
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
	@SpiraTestCase(testCaseId = 7565)
	public void testDate() {
		assertEquals(date,post.getDate());
	}
	
	@Test
	@SpiraTestCase(testCaseId = 8448)
	public void testDisplayTrue() {
		assertTrue(post.getDisplay());
	}
		
	@Test
	@SpiraTestCase(testCaseId = 8449)
	public void testDisplayToggle() {
		
		post.setDisplay();
		assertFalse(post.getDisplay());
	}
	
	@Test
	@SpiraTestCase(testCaseId = 8450)
	public void testMessage() {
		
		assertEquals("Hello, this is a post", post.getPost());
	}
	
	@Test
	@SpiraTestCase(testCaseId = 8451)
	public void testEditPost() {

		post.editPost("Truly, this is a post");
		assertEquals("Truly, this is a post", post.getPost());
	}
	
	@Test
	@SpiraTestCase(testCaseId = 8452)
	public void testNoLikes() {
		assertEquals(5,post.getNoLikes());
	}
	
	@Test
	@SpiraTestCase(testCaseId = 8454)
	public void testAddLike() {

		user1 = new User("Mr Bean",010,"Mr","Bean");
		post.likePost(user1);
		assertEquals(6,post.getNoLikes());
	}
	
	@Test
	@SpiraTestCase(testCaseId = 8455)
	public void testRejectLike() {
		
		user1 = new User("Mr Bean",005,"Mr","Bean");
		assertTrue(post.likePost(user1));
	}
	
	@AfterEach
	public void resetDisplay() {
		
		post.editPost("Hello, this is a post");
		if(!post.getDisplay())
			post.setDisplay();
		
		if(post.getNoLikes()==6)
			post.removeLike(new User("Mr Bean",010,"Mr","Bean"));
	}


}
