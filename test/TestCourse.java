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
    long professorID = 3;
    Course course = new Course(professorID, "test course", "Description of test course.");
    course.save();
    
    Course fromDB = new Course(course.getCourseID());
    assertEquals(course, fromDB);
    
    course.delete();
  }

  /*
   * Integration Test: Course.java, Post.java, DB.java
   */
  @Test
  public void testCourseWithPosts() {
    long professorID = 4;
    Course course = new Course(professorID, "test course", "Description of test course.");
    course.save();

    Post p = new Post("test post", "This is a test post for a test course", course.getCourseID());
    course.addPost(p);
    
    course.save();
    
    Course fromDB = new Course(course.getCourseID());

    assertEquals(course, fromDB);
    
    course.delete();
  }

  public String utf8It(String input) {
     StringBuilder b = new StringBuilder();

     for (char c : input.toCharArray()) {
         if (c >= 128)
             b.append("\\u").append(String.format("%04X", (int) c));
         else
             b.append(c);
     }

     return b.toString();
  }

}
