package test;

/*
 * TestCourse.java
 * 
 * Tests for the Course class.
 * 
 * @author Daniel Sabsay
 * Created March 14, 2017
 */

import static org.junit.Assert.*;

import org.junit.Test;

import logic.Course;
import logic.Post;

public class TestCourse {

  @Test
  public void TestCourseConstructionDB() {
    // Create test course
    long courseID = 100;
    Course toSave = new Course(courseID, 50, "test course", "Description of test course.", 1);
    Post p = new Post("test post", "This is a test post for a test course", 100);
    toSave.posts.add(p);
    
    // save to DB
    toSave.save();
    
    Course toLoad = new Course(courseID);
    assertEquals(toSave, toLoad);
    
    toSave.delete();
  }

}
