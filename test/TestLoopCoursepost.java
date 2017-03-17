package test;
import org.junit.Test;
import static org.junit.Assert.*;
import logic.Post;
import logic.Course;
public class TestLoopCoursepost {
	
	@Test
	public void testLoopNever(){
		Course c = new Course(1,"SE", "Programming");
		String never = c.toString();
		assertEquals("{Course:  courseID: 0 courseName: SE description: Programming posts: [\n"+
				"   ]}\n",never);
	}
	
	@Test
	public void testLoopOnce(){
		Course c1 = new Course(1,"SE", "Programming");
		Post p1 = new Post("abc","def");
		c1.addPost(p1);
		String one = c1.toString();
		assertEquals("{Course:  courseID: 0 courseName: SE description: Programming posts: [\n"
				+"      Post: abc, def, \n"
				+"   ]}\n",one);
	}
	
	@Test
	public void testLoopN(){
		Course c2 = new Course(1,"SE", "Programming");
		Post p3 = new Post("abc","def");
		Post p4 = new Post("def","efg");
		c2.addPost(p3);
		c2.addPost(p4);
		String n = c2.toString();
		assertEquals("{Course:  courseID: 0 courseName: SE description: Programming posts: [\n"
				+"      Post: abc, def, \n"
				+"      Post: def, efg, \n"
				+"   ]}\n",n);
	}
}
