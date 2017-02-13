/**
 * 
 *
 * Created: 2/12/16
 * Author: Chris Thibodeau - cathibod
 * Phys-Assist Project
 */

public class Course
{
    public long courseID, professorID;
    public String courseName, description;
    public Student students[];
    public long startDate, endDate;
    public Quiz quizzes[]; //diff representation?
    public Post posts[]; //diff representation?

    public Course(String courseName, String description, long professorID)
    {

    }

    public Course(String courseName, String description, long professorID,
		  long startDate, long endDate)
    {

    }
    
    public int addStudent(Student student) // void?
    {

    }
    
    public Student removeStudent(Student student) //index?
    {

    }

    public int addQuiz(Quiz quiz) //void?
    {

    }

    public Quiz removeQuiz(Quiz quiz) //index?
    {

    }

    public void notifyClass(String)
    {

    }

    //remove what?
    public void remove()
    {

    }
}
