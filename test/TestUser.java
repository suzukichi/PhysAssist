package test;

/*
 * TestUser.java
 * 
 * Holds all unit tests for User.java.
 * 
 * @author Daniel Sabsay
 * Created Feb 8, 2017
 */

import static org.junit.Assert.*;
import org.junit.Test;

import logic.Course;
import logic.User;

public class TestUser {

	private static final String USERNAME = "username";
	private static final String SMITH = "smith";
	private static final String BOBEMAIL = "bob@email.com";
	private static final String COURSE = "test course";
	private static final String DESCRIPTION = "test course description";
	
  @Test
  public void testGetPermissionStudent() {
    User user = new User(USERNAME, "bob", SMITH, "bla", BOBEMAIL);
    Course c = new Course(1, COURSE, DESCRIPTION);
    
    user.enrollCourse(c);
    assertEquals("student", user.getPermission(c));
  }
  
  @Test
  public void testGetPermissionProfessor() {
    User user = new User(USERNAME, "bob", SMITH, "bla", BOBEMAIL);
    Course c = new Course(1, COURSE, DESCRIPTION);
    
    user.teachCourse(c);
    assertEquals("professor", user.getPermission(c));
  }
  
  @Test
  public void testGetPermissionGeneralUser() {
    User user = new User(USERNAME, "bob", SMITH, "bla", BOBEMAIL);
    Course c = new Course(1, COURSE, DESCRIPTION);
    
    assertEquals("general_user", user.getPermission(c));
  }
  
  @Test
  public void testConstructionDB() {
     long now = System.currentTimeMillis() / 1000L;
     User u = new User("TestDBUser-" + now, "firstname", "lastName", "pass", "asdf@as.df");
     u.save();

     User uDB = new User(u.getUserID());
     
     assertEquals(u, uDB);
     
     u.delete();
  }
}
  
 
