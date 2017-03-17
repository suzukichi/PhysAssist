//shiv sulkar
package test;
import org.junit.Test;
import static org.junit.Assert.*;
import logic.Post;
import logic.Course;
public class TestLoopCoursepost {
	
	@Test
	public void testLoopNever(){
		Course c = new Course(1,"SE", "Programming");
		int never = c.toStringHelper("");
		assertEquals(0,never,0);
	}
	
	@Test
	public void testLoopOnce(){
		Course c1 = new Course(1,"SE", "Programming");
		Post p1 = new Post("abc","def");
		c1.addPost(p1);
		int one = c1.toStringHelper("");
		assertEquals(1,one,0);
	}
	
	@Test
	public void testLoopN(){
		Course c2 = new Course(1,"SE", "Programming");
		Post p3 = new Post("abc","def");
		Post p4 = new Post("def","efg");
		c2.addPost(p3);
		c2.addPost(p4);
		int n = c2.toStringHelper("");
		assertEquals(2,n,0);
	}
}
