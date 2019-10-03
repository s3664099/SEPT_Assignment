package com.sept.rest.webservices.restfulwebservices;

import static org.junit.Assert.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import com.sept.rest.webservices.restfulwebservices.entities.Posts;
import com.sept.rest.webservices.restfulwebservices.repositories.PostsRepository;

@ExtendWith(SpringExtension.class)
@RunWith(SpringRunner.class)
@SpringBootTest
public class RestfulWebServicesApplicationTests {

	private TestEntityManager entityManager;
	private PostsRepository repository;
	
	@Test
	public void contextLoads() {
		
		Posts post = new Posts(1, 0, "Hello", null, null, false, false);
		entityManager.persist(post);
		entityManager.flush();
		
		Optional<Posts> found = repository.findById(post.getPostID());
		
		assertEquals(found.isPresent(), true);

	}
	


}
