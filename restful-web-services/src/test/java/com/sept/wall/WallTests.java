import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;


public class WallTests {

	static Post post;
	static User user;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		user = new User("Mr Bean",3999999,"Mr","Bean");
		post = new Post(user, 001, "Hello, this is a post");
	}


	@Test
	public void testDisplayTrue() {
						
		post.setDisplay();
		assertEquals(true, post.getDisplay());
	}
	
	@Test
	public void testDisplayToggle() {
		
		post.setDisplay();
		assertEquals(false, post.getDisplay());

	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

}
