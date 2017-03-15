package logic;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import logic.Classroom;
import logic.ClassroomPage;
import logic.GeneralUser;
import logic.Professor;
import logic.Student;

/*
 * User.java
 * 
 * Holds all information related to a user.
 * 
 * @author Daniel Sabsay
 * Created Feb 8, 2017
 */

public class User {
  private String username;
  private String firstName;
  private String lastName;
  private long userID;
  private String password;
  private String email;
  private long registrationDate;
  private List<Course> coursesEnrolled;
  private List<Course> coursesOwned;
  
  public User(String username, String firstName, String lastName, String password, String email) {
    this.username = username;
    this.firstName = firstName;
    this.lastName = lastName;
    this.password = password;
    this.email = email;
    
    this.coursesEnrolled = new ArrayList<Course>();
    this.coursesOwned = new ArrayList<Course>();
  }
  
  public User(long userID) {
    String qGetUser = "SELECT `username`, `password`, `first_name`, `last_name`, `email`, `registration_date`" +
        " FROM `users` " +
        " WHERE `userid` = ?";
    String[] pGetUser = {DB.T_I, String.valueOf(userID)};      

    ArrayList<HashMap<String, String>> rows = (DB.getInstance()).query(qGetUser, pGetUser);
    
    if (rows.size() != 1) {
      // throw an exception
      // Means that there is no user in the DB for the userID
      System.err.println("rows.size != 1");
    }
    
    HashMap<String, String> user = rows.get(0);
    
    this.userID = userID;
    this.username = user.get("username");
    this.password = user.get("password");
    this.firstName = user.get("first_name");
    this.lastName = user.get("last_name");
    this.email = user.get("email");
    this.registrationDate = Long.parseLong(user.get("registration_date"));
    
    // load enrolled courses here
    this.coursesEnrolled = loadEnrolledCoursesList();
    this.coursesOwned = loadOwnedCoursesList();
  }
  
  /*
   * Loads a list of courses the user is enrolled in from the DB.
   */
  private List<Course> loadEnrolledCoursesList() {
    List<Course> list = new ArrayList<Course>();
    DB db = DB.getInstance();

    String qGetTopicsForParent = "SELECT * FROM `students` t" +
        " WHERE `userid` = ?";
    
    String[] pGetTopicsForParent = {DB.T_I, String.valueOf(userID)};

    ArrayList<HashMap<String, String>> rows = db.query(qGetTopicsForParent, pGetTopicsForParent);
    
    ArrayList<Long> courseIDList = new ArrayList<Long>();
    
    for (HashMap<String, String> row : rows) {
      courseIDList.add(Long.parseLong(row.get("classroomid")));
    }
    
    // now get course objects
    for (long courseID : courseIDList) {
      list.add(new Course(courseID));
    }
        
    return list;
  }
  
  /*
   * Gets a list of courses the user owns from the DB.
   */
  private List<Course> loadOwnedCoursesList() {
    List<Course> list = new ArrayList<Course>();
    DB db = DB.getInstance();

    String qGetOwnedCourses = "SELECT * FROM `classes` t" +
        " WHERE `ownerid` = ?";
    
    String[] pGetOwnedCourses = {DB.T_I, String.valueOf(userID)};

    ArrayList<HashMap<String, String>> rows = db.query(qGetOwnedCourses, pGetOwnedCourses);
    
    ArrayList<Long> courseIDList = new ArrayList<Long>();
    
    for (HashMap<String, String> row : rows) {
      courseIDList.add(Long.parseLong(row.get("classroomid")));
    }
    
    // now get course objects
    for (long courseID : courseIDList) {
      list.add(new Course(courseID));
    }
    
    return list;
  }
  
  //TODO
  public void save() {
    
  }
  
  /*
   * Returns list of the user's enrolled courses.
   */
  public List<Course> getEnrolledCourses() {
    return this.coursesEnrolled;
  }
  
  public List<Course> getOwnedCourses() {
    return this.coursesEnrolled;
  }
  
  /*
   * Enroll the user in a classroom.
   */
  public void enrollClassroom(long classroom) {
    
  }
  
  /*
   * Enroll the user in a classroom.
   */
  public void enrollCourse(Course course) {
    coursesEnrolled.add(course);
    
    //TODO: need to add this enrollment to the students table
  }
  
  /*
   * Drop the user from a classroom.
   */
  public void dropClassroom(long classroom) {
    
  }
  
  // duplicate of dropClassroom() ?
  public void dropCourse(Course course) {
    coursesEnrolled.remove(course);
    
    //TODO: need to remove this enrollment from the students table
  }
  
  /*
   * Add a created classroom to this user's owned classrooms.
   * This effectively makes the user a professor of the classroom.
   */
  public void teachCourse(Course course) {
    coursesOwned.add(course);
  }
  
  /*
   * Remove the classroom from the user's list of owned classrooms.
   * This must be called when removing a classroom from the system.
   */
  public void endCourse(Course course) {
    coursesOwned.remove(course);
    course.delete();
  }
  
  /*
   * Returns the user's permissions for the specified page.
   */
  /*
  public Role getPermission(Page page) {
    if (page instanceof ClassroomPage) {
      ClassroomPage classroomPage = (ClassroomPage) page;
      Classroom c = classroomPage.classroom;
      
      if (classroomsEnrolled.contains(c)) {
        return new Student();
      }
      if (classroomsOwned.contains(c)) {
        return new Professor();
      }
      return new GeneralUser();
    } else {
      return new GeneralUser();
    }
  }
  */
  
  /*
   * Returns the role, as a string, of the user for the given Course.
   */
  public String getPermission(Course course) {
      if (coursesEnrolled.contains(course)) {
        return "student";
      }
      if (coursesOwned.contains(course)) {
        return "professor";
      }
      return "general_user";
  }
  
  public String toString() {
    return "User: {userID: " + userID + ", userName: " + username + "\n   Enrolled: "
        + coursesEnrolled + "\n Owned: " + coursesOwned + "\n}";
  }

}
