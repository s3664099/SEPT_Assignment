package com.sept.rest.webservices.restfulwebservices;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.sql.Timestamp;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.sept.rest.webservices.restfulwebservices.students.Students;
import com.sept.rest.webservices.restfulwebservices.wall.Posts;

@RunWith(SpringRunner.class)
@ContextConfiguration()
@SpringBootTest
public class PostTest {

	private static Students student;
	private static Posts post;
	private static Timestamp time;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

		student = new Students("Mr Bean",3999999,"Mr","Bean");
		post = new Posts(001, student.getStudentID(), "Hello, this is a post", null, null, false, false);
		time = new Timestamp(0);
		
	}
	
	@Test
	public void setAndGetPostId() {
		int expected = 69;
		post.setPostID(69);
		int result = post.getPostID();
		assertEquals(result, expected);
	}
	
	@Test
	public void setAndGetMessage() {
		String expected = "Hello, this is an edited post";
		post.setMessage(expected);
		String result = post.getMessage();
		assertEquals(result, expected);
	}
	
	@Test
	public void setAndGetOwnerID() {
		int expected = 420;
		post.setOwnerID(expected);
		int result = post.getOwnerID();
		assertEquals(result, expected);
	}
	
	@Test
	public void isDeleted() {
		assertFalse(post.isDeleted());
	}
	
	@Test
	public void setDeleted() {
		post.setDeleted(true);
		assertTrue(post.isDeleted());
		post.setDeleted(false);
		assertFalse(post.isDeleted());
	}
	
	@Test
	public void isEdited() {
		assertFalse(post.isEdited());
	}
	
	@Test
	public void setEdited() {
		post.setEdited(true);
		assertTrue(post.isEdited());
		post.setEdited(false);
		assertFalse(post.isEdited());
	}
	
	@Test
	public void setCreationTime() {
		post.setCreation_Time(null);
		assertNull(post.getCreation_Time());
		post.setCreation_Time(time);
		assertEquals(post.getCreation_Time(), time);
	}
	
	@Test
	public void setModifiedTime() {
		post.setModified_Time(null);
		assertNull(post.getModified_Time());
		post.setModified_Time(time);
		assertEquals(post.getModified_Time(), time);
	}
	
	public void hashcode() {
		int postId = 69;
		post.setPostID(postId);
		int prime = 31;
		int result = 1;
		result = prime * result + (int) (postId ^ (postId >>> 32));
		assertEquals(post.hashCode(), result);
	}
	
	public void equals() {
		assertTrue(post.equals(post));
		assertFalse(post.equals(null));
		assertFalse(post.equals(student));
	}

}
