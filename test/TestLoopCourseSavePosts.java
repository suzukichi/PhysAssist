//shiv sulkar
package test;

import static org.junit.Assert.*;
import logic.Course;
import logic.Post;

import org.junit.Test;

public class TestLoopCourseSavePosts {
	@Test
	public void loopNever(){
		Course c = new Course(0,"a","b");
		assertEquals(0,c.savePosts(),0);
	}
	
	@Test
	public void loopOnce(){
		Course c = new Course(0,"a","b");
		c.setTestingMode(true);
		Post pOne = new Post("abc","def");
		c.addPost(pOne);
		assertEquals(1,c.savePosts(),0);
	}
	
	@Test
	public void loopN(){
		Course c = new Course(0,"a","b");
		c.setTestingMode(true);
		Post pN1 = new Post("abc","def");
		Post pN2 = new Post("abc","def");
		c.addPost(pN1);
		c.addPost(pN2);
		assertEquals(2,c.savePosts(),0);
	}

}
