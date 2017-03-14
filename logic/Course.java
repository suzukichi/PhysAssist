package logic;

public class Course {
  public long courseID, professorID;
  public String courseName, description;
  public Student[] students;
  public long startDate;
  public Post[] posts; //diff representation?
  
  public Course(long courseID, long professorID, String courseName, String description,
      long startDate) {
    this.courseID = courseID;
    this.professorID = professorID;
    this.courseName = courseName;
    this.description = description;
    this.startDate = startDate;
    
    // need to load all posts from db
  }
  
  /*
   * Loads all posts from the DB for this Course.
   */
  private void loadPosts() {
    
  }
}
