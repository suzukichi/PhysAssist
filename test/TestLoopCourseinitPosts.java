//loop test for calculator

package test;
import java.util.ArrayList;

import org.junit.Test;

import static org.junit.Assert.*; 
import logic.Course;
public class TestLoopCourseinitPosts {
	@Test
	public void testLoopNever(){
	    Course c = new Course(0,"a","b");
	    c.setTestingMode(true);
	    ArrayList<Long> postIDList = new ArrayList<Long>();
	    int i = c.initPosts(postIDList);
		assertEquals(0,i,0);
	}
	@Test
	public void testLoopOnce(){
	    Course c = new Course(0,"a","b");
	    c.setTestingMode(true);
	    ArrayList<Long> postIDList = new ArrayList<Long>();
	    postIDList.add((long)11);
	    int i = c.initPosts(postIDList);
		assertEquals(1,i,0);
	}
	@Test
	public void testLoopN(){
	    Course c = new Course(0,"a","b");
	    c.setTestingMode(true);
	    ArrayList<Long> postIDList = new ArrayList<Long>();
	    postIDList.add((long)11);
	    postIDList.add((long)12);
	    int i = c.initPosts(postIDList);
		assertEquals(2,i,0);
	}
}
