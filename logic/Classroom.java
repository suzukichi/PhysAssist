package logic;
/**
 * 
 *
 * Created: 2/12/16
 * Author: Chris Thibodeau - cathibod
 * Phys-Assist Project
 */

public class Classroom
{
    public long classroomID, professorID;
    public String classroomName, description;
    public Student students[];
    public long startDate, endDate;
    public Quiz quizzes[]; //diff representation?
    public Post posts[]; //diff representation?

    public Classroom(String ClassroomName, String description, long professorID)
    {

    }

    public Classroom(String classroomName, String description, long professorID,
		  long startDate, long endDate)
    {
      this.classroomName = classroomName;
      this.description = description;
      this.professorID = professorID;
      this.startDate = startDate;
      this.endDate = endDate;
    }
    
    public int addStudent(Student student) // void?
    {
      return 0;
    }
    
    public Student removeStudent(Student student) //index?
    {
      return null;
    }

    public int addQuiz(Quiz quiz) //void?
    {
      return 0;
    }

    public Quiz removeQuiz(Quiz quiz) //index?
    {
      return null;
    }

    public void notifyClass(String message)
    {
      
    }

    //remove what?
    public void remove()
    {
      
    }
}
