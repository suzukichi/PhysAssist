package logic;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.bind.annotation.adapters.HexBinaryAdapter;


/*
 * User.java
 * 
 * Holds all information related to a user.
 * 
 * @author Daniel Sabsay
 * Created Feb 8, 2017
 */

public class User {
  private static final Logger LOGGER = Logger.getLogger(User.class.getName());
  private boolean testMode = false;
  private String username;
  private String firstName;
  private String lastName;
  private long userID;
  private String password;
  private String email;
  private long registrationDate;
  private List<Course> coursesEnrolled;
  private List<Course> coursesOwned;
  private static final String FROM_USERS = " FROM `users`";
  public User(String username, String firstName, String lastName, String password, String email) {
    this.username = username;
    this.firstName = firstName;
    this.lastName = lastName;
    this.password = encrypt(password);
    this.email = email;
    this.userID = 0;
    
    this.coursesEnrolled = new ArrayList<>();
    this.coursesOwned = new ArrayList<>();
  }
  
  public User(long userID) {
    String qGetUser = "SELECT `username`, `password`, `first_name`, `last_name`, `email`, `registration_date`" +
                      FROM_USERS +
                      " WHERE `userid` = ?";
    String[] pGetUser = {DB.T_I, String.valueOf(userID)};      

    List<HashMap<String, String>> rows = (DB.getInstance()).query(qGetUser, pGetUser);
    
    if (rows.size() != 1) {
    	throw new IllegalArgumentException("User rows.size != 1 - No such user in database.");
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
    List<Course> list = new ArrayList<>();
    DB db = DB.getInstance();

    String qGetTopicsForParent = "SELECT * FROM `students` t" +
        " WHERE `userid` = ?";
    
    String[] pGetTopicsForParent = {DB.T_I, String.valueOf(userID)};

    List<HashMap<String, String>> rows = db.query(qGetTopicsForParent, pGetTopicsForParent);
    
    ArrayList<Long> courseIDList = new ArrayList<>();
    loadLoop(courseIDList,rows);
    
    // now get course objects
    initCourses(list,courseIDList);       
    return list;
  }
  
  public int initCourses(List<Course> list, List<Long> courseIDList){
	  int iterations=0;
	  // Loop tested in test/TestLoopUserinitCourses.java
	  for (long courseID : courseIDList) {
		  if(!testMode){
			  list.add(new Course(courseID));
		  }
	      iterations++;
	  }  
	  return iterations;
  }
  
  /*
   * Gets a list of courses the user owns from the DB.
   */
  private List<Course> loadOwnedCoursesList() {
    List<Course> list = new ArrayList<>();
    DB db = DB.getInstance();

    String qGetOwnedCourses = "SELECT * FROM `classrooms` t" +
        " WHERE `ownerid` = ?";
    
    String[] pGetOwnedCourses = {DB.T_I, String.valueOf(userID)};

    List<HashMap<String, String>> rows = db.query(qGetOwnedCourses, pGetOwnedCourses);
    
    ArrayList<Long> courseIDList = new ArrayList<>();
    
    loadLoop(courseIDList,rows);
    
    // now get course objects
    initCourses(list,courseIDList);
    
    return list;
  }
  
  public void loadLoop(List<Long> courseIDList,List<HashMap<String, String>> rows){
	  for (HashMap<String, String> row : rows) {
	      courseIDList.add(Long.parseLong(row.get("classroomid")));
	  }
  }
  
  public void save() {
     DB db = DB.getInstance();
     String qSaveUser = "INSERT INTO `users` " +
                        " SET `userid` = ?, `username` = ?, `password` = ?," + 
                        "     `first_name` = ?, `last_name` = ?, `email` = ?," + 
                        "     `registration_date` = ?" + 
                        " ON DUPLICATE KEY UPDATE" +
                        "    `username` = ?, `password` = ?," + 
                        "    `first_name` = ?, `last_name` = ?, `email` = ?"; 
     String[] pSaveUser = {
        DB.T_I, String.valueOf(this.userID),
        DB.T_S, this.username,
        DB.T_S, this.password,
        DB.T_S, this.firstName,
        DB.T_S, this.lastName,
        DB.T_S, this.email,
        DB.T_I, String.valueOf(this.registrationDate),

        DB.T_S, this.username,
        DB.T_S, this.password,
        DB.T_S, this.firstName,
        DB.T_S, this.lastName,
        DB.T_S, this.email
     };

     db.execute(qSaveUser, pSaveUser);
     
     if (this.userID <= 0) {
        String qGetUserID = "SELECT `userid`" + FROM_USERS +
                            " WHERE `username` = ? AND `registration_date` = ?" + 
                            " LIMIT 1";
        String[] pGetUserID = {
           DB.T_S, this.username,
           DB.T_I, String.valueOf(this.registrationDate)
        };
        
        this.userID = Long.valueOf(db.query(qGetUserID, pGetUserID).get(0).get("userid"));
     }
  }
  
  public void delete() {
     String qDeleteUser = "DELETE" + FROM_USERS + " WHERE `userid` = ?";
     String[] pDeleteUser = {
        DB.T_I, String.valueOf(this.userID) 
     };
     
     DB.getInstance().execute(qDeleteUser, pDeleteUser);
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
  public void enrollCourse(Course course) {
    if (course.enrollStudent(this)) {
       coursesEnrolled.add(course);
    }
  }
  
  // duplicate of dropClassroom() ?
  public void dropCourse(Course course) {
    if (course.dropStudent(this)) {
       coursesEnrolled.remove(course);
    }
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
  
  @Override
  public String toString() {
    return "User: {userID: " + userID + ", userName: " + username + "\n   Enrolled: "
        + coursesEnrolled + "\n Owned: " + coursesOwned + "\n}";
  }

  /**
   * Temporary fix to hash passwords.
   * Need to further enforce security.
   * @param plainText
   * @return
   */
  public static String encrypt(String plainText) { 
	  String hashedText = "";
	  try {
		  MessageDigest digest = MessageDigest.getInstance("SHA-256");
		  byte[] hash = digest.digest(plainText.getBytes(StandardCharsets.UTF_8));
		  hashedText = new HexBinaryAdapter().marshal(hash);
	  }
	  catch(NoSuchAlgorithmException e){
		  LOGGER.log(Level.FINE, e.toString(), e);
	  }
	  return hashedText;
  }
  
  /**
   * 
   * @param username
   * @param password
   * @return userID on success, < 0  on fail
   */
  public static long verify(String username, String password) {
	    DB db = DB.getInstance();

	    String qGetLoginInfo = "SELECT password, userID" + 
	    						FROM_USERS +
	    						" WHERE `username` = ?";
	    String[] pGetLoginInfo = {DB.T_S, String.valueOf(username)};

	    List<HashMap<String, String>> rows = db.query(qGetLoginInfo, pGetLoginInfo);
	    
	    if(rows.size() != 1) {
	    	return -2; //no username found or multiple in database(checked on creation)
	    }
	    
	    HashMap<String, String> row = rows.get(0);
	    if(row.get("password").equals(encrypt(password))) {
	    	String userID = row.get("userID");
	    	if (userID == null) 
	    		return 1;
	    	return Long.parseLong(userID);
	    }
	    
	    return -1;
  }
  
  @Override
  public int hashCode() {
    return Objects.hash(username, firstName, lastName, userID, password, email, registrationDate,
        coursesEnrolled, coursesOwned);
  }
  
  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    User other = (User) obj;
    
    boolean firstComp = Objects.equals(this.username, other.username) &&
            Objects.equals(this.firstName, other.firstName) &&
            Objects.equals(this.lastName, other.lastName);
    boolean secondComp = Objects.equals(this.userID, other.userID) &&
            Objects.equals(this.password, other.password) &&
            Objects.equals(this.email, other.email);
    boolean thirdComp = Objects.equals(this.registrationDate, this.registrationDate) &&
            Objects.equals(this.coursesEnrolled, other.coursesEnrolled) &&
            Objects.equals(this.coursesOwned, this.coursesOwned);
    
    return firstComp && secondComp && thirdComp;
  }
  
  public static boolean nameExists(String username) {
	  DB db = DB.getInstance();
	    String qGetLoginInfo = "SELECT `username`" +
	    							FROM_USERS +
	    							" WHERE `username` = ?";
	    
	    String[] pGetLoginInfo = {DB.T_S, String.valueOf(username)};
	    List<HashMap<String, String>> rows = db.query(qGetLoginInfo, pGetLoginInfo);
	    
	    if(rows.size() < 0) {
	    	return true; //no username found or multiple in database(checked on creation)
	    }
	    return false;
  }
  
  public static boolean emailExists(String email) {
	  DB db = DB.getInstance();

	    String qGetLoginInfo = "SELECT *" +
	    							FROM_USERS +
	    							" WHERE `email` = ?";
	    
	    String[] pGetLoginInfo = {DB.T_S, String.valueOf(email)};

	    List<HashMap<String, String>> rows = db.query(qGetLoginInfo, pGetLoginInfo);
	    
	    if(rows.size() < 0) {
	    	return true; //no email found or multiple in database(checked on creation)
	    }
	    return false;
  }
  
  public long getUserID()
  {
	  return this.userID;
  }
  
  public void setUserID(long userID)
  {
	  this.userID = userID;
  }
  
  public String getUsername() 
  {
	  return this.username;
  }
  
  public void setUsername(String username)
  {
	  this.username = username;
  }
  
  public String getPassword() 
  {
	  return this.password;
  }
  
  public void setPassword(String password) 
  {
	  this.password = password;
  }
  
  public String getEmail()
  {
	  return this.email;
  }
  
  public void setEmail(String email)
  {
	  this.email = email;
  }
  
  public String getFirstName()
  {
	  return this.firstName;
  }
  
  public void setFirstName(String firstName)
  {
	  this.firstName = firstName;
  }
  
  public String getLastName()
  {
	  return this.lastName;
  }
  
  public void setLastName(String lastName)
  {
	  this.lastName = lastName;
  }
  public void setTestMode(boolean mode){
	  testMode = mode;
  }
}
