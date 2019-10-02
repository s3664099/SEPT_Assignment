package com.sept.rest.webservices.restfulwebservices;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.sql.Timestamp;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.sept.rest.webservices.restfulwebservices.entities.Comments;
import com.sept.rest.webservices.restfulwebservices.entities.Posts;
import com.sept.rest.webservices.restfulwebservices.entities.Students;

//@ExtendWith(SpringExtension.class)
//@RunWith(SpringRunner.class)
//@SpringBootTest
public class CommentTest {

	private static Students student;
	private static Posts post;
	private static Comments comment;
	private static Timestamp time;
	
	
//	@Test
//	public void contextLoads() {
//		
//		Posts post = new Posts(1, 0, "Hello", null, null, false, false);
//		entityManager.persist(post);
//		entityManager.flush();
//		
//		Optional<Posts> found = repository.findById(post.getPostID());
//		
//		assertEquals(found.isPresent(), true);
//
//	}
	
	@BeforeAll
	public static void setUpBeforeClass() throws Exception {

		student = new Students("Mr Bean",3999999,"Mr","Bean");
		post = new Posts(001, student.getStudentID(), "Hello, this is a post", null, null, false, false);
		student = new Students("Moto Moto",3111111,"Moto","Moto");
		comment = new Comments((long) 001, student.getStudentID(), 001, "I like em big", null, null, false, false);
		time = new Timestamp(0);
		
	}
	
	@Test
	public void setAndGetPostId() {
		long expected = 69;
		comment.setCommentID(expected);
		long result = comment.getCommentID();
		assertEquals(result, expected);
	}
	
	@Test
	public void setAndGetMessage() {
		String expected = "I like em chunky";
		comment.setMessage(expected);
		String result = comment.getMessage();
		assertEquals(result, expected);
	}
	
	@Test
	public void setAndGetOwnerID() {
		int expected = 420;
		comment.setAuthorID(expected);
		int result = comment.getAuthorID();
		assertEquals(result, expected);
	}
	
	@Test
	public void isDeleted() {
		assertFalse(comment.isDeleted());
	}
	
	@Test
	public void setDeleted() {
		comment.setDeleted(true);
		assertTrue(comment.isDeleted());
		comment.setDeleted(false);
		assertFalse(comment.isDeleted());
	}
	
	@Test
	public void isEdited() {
		assertFalse(comment.isEdited());
	}
	
	@Test
	public void setEdited() {
		comment.setEdited(true);
		assertTrue(comment.isEdited());
		comment.setEdited(false);
		assertFalse(comment.isEdited());
	}
	
	@Test
	public void setCreationTime() {
		comment.setCreation_Time(null);
		assertNull(comment.getCreation_Time());
		comment.setCreation_Time(time);
		assertEquals(comment.getCreation_Time(), time);
	}
	
	@Test
	public void setModifiedTime() {
		comment.setModified_Time(null);
		assertNull(comment.getModified_Time());
		comment.setModified_Time(time);
		assertEquals(comment.getModified_Time(), time);
	}
	
	public void setParentID() {
		comment.setParentId(null);
		assertNull(comment.getParentId());
		int expected = 69;
		comment.setParentId(expected);
		assertEquals(comment.getParentId(), );
	}
	

}
