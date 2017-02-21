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
	public void testPostConstructor() {
		String title = "Test Post";
		String text = "This is a post created by TestPostConstructor";
		Post p = new Post(title, text);
		assertEquals(title, p.title);
		assertEquals(text, p.text);
	}

}
