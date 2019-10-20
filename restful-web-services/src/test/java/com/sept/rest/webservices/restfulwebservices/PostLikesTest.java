package com.sept.rest.webservices.restfulwebservices;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.sept.rest.webservices.restfulwebservices.wall.CommentLikesIdentity;
import com.sept.rest.webservices.restfulwebservices.wall.PostLikes;
import com.sept.rest.webservices.restfulwebservices.wall.PostLikesIdentity;

@RunWith(SpringRunner.class)
@ContextConfiguration()
@SpringBootTest
public class PostLikesTest {
	
	private static PostLikesIdentity likeId;
	private static PostLikes like;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception{
		
		Integer postId = (int)10;
		int studentId = 20;
		
		likeId = new PostLikesIdentity(postId, studentId);
		like = new PostLikes(likeId);
	}
	
	@Test
	public void getId() {
		PostLikesIdentity expect = new PostLikesIdentity((int)10, 20);
		like.setId(new PostLikesIdentity(10,20));
		PostLikesIdentity result = like.getId();
		assertEquals(result, expect);
	}
	
	@Test 
	public void getPostId() {
		Integer expect = 10;
		like.setPostId(10);
		Integer result = like.getPostId();
		assertEquals(result, expect);
	}
	
	@Test
	public void getStudentId() {
		int expect = 20;
		like.setPostId(20);
		int result = like.getStudentId();
		assertEquals(result, expect);
	}
	
	@Test
	public void setPostId() {
		Integer expect = 60;
		like.setPostId(60);
		Integer result = like.getPostId();
		assertEquals(result, expect);
	}
	
	@Test
	public void setStudentId() {
		int expect = 80;
		like.setStudentId(80);
		int result = like.getStudentId();
		assertEquals(result, expect);
	}
	
	@Test
	public void setId() {
		PostLikesIdentity expect = new PostLikesIdentity(1, 2);
		like.setId(new PostLikesIdentity(1,2));
		PostLikesIdentity result = like.getId();
		assertEquals(result, expect);
	}
}
