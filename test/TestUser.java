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

  @Test
  public void testGetPermissionStudent() {
    User user = new User("username", "bob", "smith", "bla", "bob@email.com");
    Course c = new Course(1, "test course", "test course description", System.currentTimeMillis());
    
    user.enrollCourse(c);
    assertEquals("student", user.getPermission(c));
  }
  
  @Test
  public void testGetPermissionProfessor() {
    User user = new User("username", "bob", "smith", "bla", "bob@email.com");
    Course c = new Course(1, "test course", "test course description", System.currentTimeMillis());
    
    user.teachCourse(c);
    assertEquals("professor", user.getPermission(c));
  }
  
  @Test
  public void testGetPermissionGeneralUser() {
    User user = new User("username", "bob", "smith", "bla", "bob@email.com");
    Course c = new Course(1, "test course", "test course description", System.currentTimeMillis());
    
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
  
  /*
  @Test
  public void TestUserEnrollClassroom() {
    Classroom c = new Classroom("class", "class decsription", 1);
    User user = new User("username", "bob", "smith", "password", "bob@email.com");
    
    user.enrollClassroom(c);
    assertThat(user.classroomsEnrolled, IsCollectionContaining.hasItem(c));
  }
  
  @Test
  public void TestUserGetPermissionStudent() {
    User user = new User("student", "bob", "smith", "password", "bob@email.com");
    Classroom c = new Classroom("physics class", "physics class description", 1, 0, 10);
    Page page = new ClassroomHomePage("class home page", c);
    
    user.enrollClassroom(c);
    
    assertThat(user.getPermission(page), new IsInstanceOf(Student.class));
  }
  
  @Test
  public void TestUserGetPermissionProfessor() {
    User user = new User("prof", "bob", "smith", "password", "bob@email.com");
    Classroom c = new Classroom("physics class", "physics class description", 1, 0, 10);
    Page page = new ClassroomHomePage("class home page", c);
    
    user.teachClassroom(c);
    
    assertThat(user.getPermission(page), new IsInstanceOf(Professor.class));
  }
  
  @Test
  public void TestUserGetPermissionGeneralPageGeneralUser() {
    User user = new User("prof", "bob", "smith", "password", "bob@email.com");
    Classroom c = new Classroom("physics class", "physics class description", 1, 0, 10);
    Page classPage = new ClassroomHomePage("class home page", c);
    
    user.enrollClassroom(c);
    
    Topic topic = new Topic("title", "info");
    Page topicPage = new TopicPage("topic page", topic);
    
    assertThat(user.getPermission(topicPage), new IsInstanceOf(GeneralUser.class));
  }
  
  @Test
  public void TestUserGetPermissionClassroomPageGeneralUser() {
    User user = new User("prof", "bob", "smith", "password", "bob@email.com");
    Classroom physicsClass = new Classroom("physics class", "physics class description", 1, 0, 10);
    //Page classPage = new ClassroomHomePage("class home page", c);
    
    Classroom biologyClass = new Classroom("biology class", "class description", 2, 0, 10);
    Page bioClassPage = new ClassroomHomePage("biology class home page", biologyClass);
    
    user.enrollClassroom(physicsClass);
    
    assertThat(user.getPermission(bioClassPage), new IsInstanceOf(GeneralUser.class));
  }
  */
  
  

}
