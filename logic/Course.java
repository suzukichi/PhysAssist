package logic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class Course {
  private long courseID;
  private long professorID;
  private String courseName;
  private String description;
  private long startDate;
  private List<Post> posts;
  
  public Course(long professorID, String courseName, String description) {
    this.courseID = 0;
    this.professorID = professorID;
    this.courseName = courseName;
    this.description = description;
    this.startDate = System.currentTimeMillis() / 1000L;
    this.posts = new ArrayList<>();

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

    List<HashMap<String, String>> rows = db.query(qGetCourse, pGetCourse);
    
    if (rows.size() != 1) {
      throw new IllegalArgumentException("Rows.size() != 1");
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

    List<HashMap<String, String>> rows = db.query(qGetPostsForCourse, pGetPostsForCourse);
    
    ArrayList<Long> postIDList = new ArrayList<>();
    
    for (HashMap<String, String> row : rows) {
      postIDList.add(Long.parseLong(row.get("postid")));
    }
    
    this.posts = new ArrayList<>();
    
    for (long postID : postIDList) {
      posts.add(new Post(postID));
    }
  }
  
  public void save() {
    DB db = DB.getInstance();
    
    String setFields = "`classroomid` = ?, `title` = ?, `description` = ?, `ownerid` = ?," +
        " `start_date` = ?";
    String[] psaveCourse = {
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

    String qsaveCourse = "INSERT INTO `classrooms`" +
                          " SET " + setFields + 
                          " ON DUPLICATE KEY UPDATE " + setFields;
     
     db.execute(qsaveCourse, psaveCourse);
    
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
    // Loop tested in test/TestLoopCourseSavePosts.java
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
  
  public boolean enrollStudent(User s) {
     DB db = DB.getInstance();
    
     String qEnrollStudent = "INSERT IGNORE INTO `students` SET `userid` = ?, `classroomid` = ?";
     String[] pEnrollStudent = {
        DB.T_I, String.valueOf(this.courseID),
        DB.T_I, String.valueOf(s.getUserID())
     };
     
     db.execute(qEnrollStudent, pEnrollStudent);
     
     // In the future, check that public registration is enabled here.
     return true;
  }

  public boolean dropStudent(User s) {
     DB db = DB.getInstance();
    
     String qEnrollStudent = "DELETE FROM `students` WHERE `userid` = ? AND `classroomid` = ?";
     String[] pEnrollStudent = {
        DB.T_I, String.valueOf(this.courseID),
        DB.T_I, String.valueOf(s.getUserID())
     };
     
     db.execute(qEnrollStudent, pEnrollStudent);
     
     // In the future, check # rows altered.
     return true;
  }
  
  @Override
  public String toString() {
    String rep = "{Course: ";
    rep += " courseID: " + courseID;
    rep += " courseName: " + courseName;
    rep += " description: " + description;
    rep += " posts: [\n";
    // Loop tested in test/TestLoopCoursepost.java
    for (Post p : posts) {
      rep += "   " + p.toString() + ", \n";
    }
    
    rep += "   ]}\n";
    
    return rep;
  }
  
  @Override
  public int hashCode() {
    return Objects.hash(courseID, courseName, description, professorID, startDate, posts);
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
    Course other = (Course) obj;
    boolean firstCond = Objects.equals(this.courseID, other.courseID) &&
            Objects.equals(this.courseName, other.courseName) &&
            Objects.equals(this.description, other.description);
    boolean secondCond = Objects.equals(this.professorID, other.professorID) &&
            Objects.equals(this.startDate, other.startDate) &&
            Objects.equals(this.posts, other.posts);
    
    return firstCond && secondCond;
        
  }

public long getCourseID() {
	return this.courseID;
}

public void addPost(Post p) {
	this.posts.add(p);	
}
}
