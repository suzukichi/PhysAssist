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
    Course course = new Course(50, "test course", "Description of test course.", 1);
    course.save();
    
    Course fromDB = new Course(course.courseID);
    //TODO should compare objects
    assertEquals(course.courseName, fromDB.courseName);
    
    course.delete();
  }

  @Test
  public void TestCourseWithPosts() {
    Course course = new Course(50, "test course", "Description of test course.", 1);
    course.save();

    Post p = new Post("test post", "This is a test post for a test course", 100);
    course.posts.add(p);
    
    // save to DB
    course.save();
    
    Course fromDB = new Course(course.courseID);
    // This should check the post text, not compare objects.
    //TODO Comparing objects is a more rigorous test
    assertEquals(course, fromDB);
    
    course.delete();
    
  }

}
