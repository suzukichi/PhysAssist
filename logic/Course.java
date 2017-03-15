package logic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class Course {
  public long courseID;
  public long professorID;
  public String courseName;
  public String description;
  public Student[] students;
  public long startDate;
  public List<Post> posts;
  
  public Course(long professorID, String courseName, String description, long startDate) {
    this.courseID = 0;
    this.professorID = professorID;
    this.courseName = courseName;
    this.description = description;
    this.startDate = startDate;
    this.posts = new ArrayList<Post>();

    //this.posts = posts;
    
    //loadPosts();
  }
  
  public Course(long courseID) {
    loadCourse(courseID);
    loadPosts();
  }
  
  /*
   * Loads the course information from the DB.
   */
  private void loadCourse(long courseID) {
    DB db = DB.getInstance();

    String qGetCourse = "SELECT `classroomid`, `title`, `description`, `ownerid`, `start_date`, `status`" + 
                        " FROM `classrooms` " +
                        " WHERE `classroomid` = ?" + 
                        " LIMIT 1";
    
    String[] pGetCourse = {DB.T_I, String.valueOf(courseID)};

    ArrayList<HashMap<String, String>> rows = db.query(qGetCourse, pGetCourse);
    
    if (rows.size() != 1) {
      // throw an exception
      // Means that there is no course in the DB for the courseID
      System.err.println("rows.size != 1");
    }
    
    HashMap<String, String> courseEntry = rows.get(0);
    
    this.courseID = courseID;
    this.professorID = Long.parseLong(courseEntry.get("ownerid"));
    this.courseName = courseEntry.get("title");
    this.description = courseEntry.get("description");
    this.startDate = Long.parseLong(courseEntry.get("start_date"));
  }
  
  /*
   * Loads all the posts for this course from the DB.
   */
  private void loadPosts() {
    DB db = DB.getInstance();
    
    String qGetPostsForCourse = "SELECT * FROM `posts` t" +
        " WHERE `classroomid` = ?";
    
    String[] pGetPostsForCourse = {DB.T_I, String.valueOf(courseID)};

    ArrayList<HashMap<String, String>> rows = db.query(qGetPostsForCourse, pGetPostsForCourse);
    
    System.out.println("getPosts: rows: ");
    System.out.println(rows);
    
    ArrayList<Long> postIDList = new ArrayList<Long>();
    
    for (HashMap<String, String> row : rows) {
      postIDList.add(Long.parseLong(row.get("postid")));
    }
    
    this.posts = new ArrayList<Post>();
    
    for (long postID : postIDList) {
      posts.add(new Post(postID));
    }
  }
  
  public void save() {
    DB db = DB.getInstance();
    
    String setFields = "`classroomid` = ?, `title` = ?, `description` = ?, `ownerid` = ?," +
        " `start_date` = ?";
    String[] p_saveCourse = {
       DB.T_I, String.valueOf(this.courseID),
       DB.T_S, this.courseName,
       DB.T_S, this.description,
       DB.T_I, String.valueOf(this.professorID),
       DB.T_I, String.valueOf(this.startDate),

       DB.T_I, String.valueOf(this.courseID),
       DB.T_S, this.courseName,
       DB.T_S, this.description,
       DB.T_I, String.valueOf(this.professorID),
       DB.T_I, String.valueOf(this.startDate)
    };

    String q_saveCourse = "INSERT INTO `classrooms`" +
                          " SET " + setFields + 
                          " ON DUPLICATE KEY UPDATE " + setFields;
     
     int insertedRows = db.execute(q_saveCourse, p_saveCourse);
     
     System.out.println("Inserted rows: " + insertedRows);
    
     if (this.courseID <= 0) {
       String qGetPostid = "SELECT `classroomid`" +
                           " FROM `classrooms`" + 
                           " WHERE `ownerid` = ? AND `start_date` = ?" + 
                           " LIMIT 1";
       String[] pGetPostid = {
          DB.T_I, String.valueOf(this.professorID),
          DB.T_I, String.valueOf(this.startDate)
       };

       this.courseID = Long.valueOf(DB.getInstance().query(qGetPostid, pGetPostid).get(0).get("classroomid"));
     }

     savePosts();
  }
  
  /*
   * Saves all Posts that belong to this Course to the DB.
   */
  private void savePosts() {
    for (Post p : posts) {
      p.save();
    }
  }
  
  /*
   * Delete this course from the DB.
   */
  public void delete() {
     DB db = DB.getInstance();
     String qDeleteTopic = "DELETE FROM `classrooms` WHERE `classroomid` = ?";
     String[] params = {DB.T_I, String.valueOf(this.courseID)};
     
     db.execute(qDeleteTopic, params);
     
     // Must delete all Posts from DB as well.
     for (Post p : this.posts) {
        p.delete();
     }

     this.posts.clear();
 }
  
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
    Course other = (Course) obj;
    
    return Objects.equals(this.courseID, other.courseID) &&
        Objects.equals(this.courseName, other.courseName) &&
        Objects.equals(this.description, other.description) &&
        Objects.equals(this.professorID, other.professorID) &&
        Objects.equals(this.startDate, other.startDate) &&
        Objects.equals(this.posts, other.posts);
  }
  
  public boolean enrollStudent(User s) {
     DB db = DB.getInstance();
    
     String qEnrollStudent = "INSERT IGNORE INTO `students` SET `userid` = ?, `classroomid` = ?";
     String[] pEnrollStudent = {
        DB.T_I, String.valueOf(this.courseID),
        DB.T_I, String.valueOf(s.userID)
     };
     
     db.execute(qEnrollStudent, pEnrollStudent);
     
     // In the future, check that public registration is enabled here.
     return true;
  }
  
  @Override
  public int hashCode() {
    return Objects.hash(courseID, courseName, description, professorID, startDate, posts);
  }
  
  public String toString() {
    String rep = "{Course: ";
    rep += " courseID: " + courseID;
    rep += " courseName: " + courseName;
    rep += " description: " + description;
    rep += " posts: [\n";
    
    for (Post p : posts) {
      rep += "   " + p.toString() + ", \n";
    }
    
    rep += "   ]}\n";
    
    return rep;
    //return "Course: " + courseID + ", " + courseName + ", " + description;
  }
}
