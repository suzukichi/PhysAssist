package test;

/*
 * TestCourse.java
 * 
 * Tests for the Course class.
 * Integration Tests: Course.java, Post.java, Database.java
 * 
 * @author Daniel Sabsay
 * Created March 14, 2017
 */

import static org.junit.Assert.*;

import org.junit.Test;

import logic.Course;
import logic.Post;

public class TestCourse {

  /*
   * Integration Test: Course.java, DB.java
   */
  @Test
  public void testCourseConstructionDB() {
    Course course = new Course(50, "test course", "Description of test course.");
    course.save();
    
    Course fromDB = new Course(course.getCourseID());
    //TODO should compare objects
    //assertEquals(course.courseName, fromDB.courseName);
    assertEquals(course, fromDB);
    
    course.delete();
  }

  /*
   * Integration Test: Course.java, Post.java, DB.java
   */
  @Test
  public void testCourseWithPosts() {
    Course course = new Course(55, "test course", "Description of test course.");
    course.save();
    // have to get courseID
    long courseID = course.getCourseID();

    Post p = new Post("test post", "This is a test post for a test course", courseID);
    //TODO maybe right an addPost() method that would also save the post to the DB.
    course.addPost(p);
    
    // save to DB
    course.save();
    
    Course fromDB = new Course(courseID);
    // This should check the post text, not compare objects.
    //TODO Comparing objects is a more rigorous test
    assertEquals(course, fromDB);
    
    course.delete();
  }

}
