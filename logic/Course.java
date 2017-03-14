package logic;

public class Course {
  public long courseID, professorID;
  public String courseName, description;
  public Student[] students;
  public long startDate, endDate;
  public Post[] posts; //diff representation?
  
  public Course(long courseID, long professorID, String courseName, String description,
      long startDate, long endDate) {
    this.courseID = courseID;
    this.professorID = professorID;
    this.courseName = courseName;
    this.description = description;
    this.startDate = startDate;
    this.endDate = endDate;
    
    // need to load all posts from db
  }
}
