package test;
/**
 * @author diana
 *
 */
import static org.junit.Assert.*;
import org.junit.Test;
import logic.Post;

public class TestPost {
	@Test
	public void testPostNewConstructor() {
		String title = "Test Post";
		String text = "This is a post created by TestPostConstructor";
		Post p = new Post(title, text);
		assertEquals(title, p.title);
		assertEquals(text, p.text);
	}
	
	@Test
	public void testPostConstructorDB() {
		String title = "Please get me out of the db!";
		String text = "All I want is to be with you!";
	   Post op = new Post(title, text);
	   
	   // Save must be run before we can retrieve anything.
	   long postID = op.save();
	   
	   Post post = new Post(postID);
	   
	   assertEquals(postID, post.postID);
	   
	}

	@Test
	public void testPostUpdate() {
		String title = "Test Post";
		String text = "All I want is to be with you!";
	   Post op = new Post(title, text);

	   // Save must be run before we can retrieve anything.
	   long postID = op.save();

		op.title = "Please get me out of the db!";
	   op.save();
	   
	   Post post = new Post(postID);
	   
	   assertEquals(op.title, post.title);
	   
	}

}
