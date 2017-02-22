package logic;
import java.util.ArrayList;
import java.util.List;

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
  public List<Classroom> classroomsEnrolled;
  public List<Classroom> classroomsOwned;
  
  public User(String username, String firstName, String lastName, String password, String email) {
    this.username = username;
    this.firstName = firstName;
    this.lastName = lastName;
    this.password = password;
    this.email = email;
    
    this.classroomsEnrolled = new ArrayList<Classroom>();
    this.classroomsOwned = new ArrayList<Classroom>();
  }
  
  /*
   * Enroll the user in a classroom.
   */
  public void enrollClassroom(long classroom) {
    
  }
  
  /*
   * Enroll the user in a classroom.
   */
  public void enrollClassroom(Classroom classroom) {
    classroomsEnrolled.add(classroom);
  }
  
  /*
   * Drop the user from a classroom.
   */
  public void dropClassroom(long classroom) {
    
  }
  
  // duplicate of dropClassroom() ?
  public void removeClassroom(long classroom) {
    
  }
  
  /*
   * Returns the user's permissions for the specified page.
   */
  public Role getPermission(Page page) {
    
  }
}
