//shiv sulkar
package test;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;
import logic.Course;
import logic.User;
import org.junit.Test;
public class TestLoopUserinitCourses {
	@Test
	public void loopNever(){
		ArrayList<Long> al = new ArrayList<Long>();
	    List<Course> cl = new ArrayList<Course>(); 
		User u = new User("","","","","");
		u.setTestMode(true);
		int i = u.initCourses(cl, al);
		assertEquals(0,i,0);
	}
	@Test
	public void loopOnce(){
		//Long<>
		ArrayList<Long> al = new ArrayList<Long>();
		al.add((long)1);
	    List<Course> cl = new ArrayList<Course>(); 
		cl.add(new Course(0,"a","b"));
		User u = new User("","","","","");
		u.setTestMode(true);
		int i = u.initCourses(cl, al);
		assertEquals(1,i,0);
	}
	@Test
	public void loopN(){
		//Long<>
		ArrayList<Long> al = new ArrayList<Long>();
		al.add((long)1);
		al.add((long)2);
	    List<Course> cl = new ArrayList<Course>(); 
		cl.add(new Course(0,"a","b"));
		cl.add(new Course(1,"a","b"));
		User u = new User("","","","","");
		u.setTestMode(true);
		int i = u.initCourses(cl, al);
		assertEquals(2,i,0);
	}

}
