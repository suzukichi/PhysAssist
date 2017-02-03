/*
 * Quiz.java
 *
 * Quizzes are a collection of questions(max 100) that may belong to a class or
 * be public. Quizzes have the option of being viewable, having multiple attempts
 * possible, may have a due date, or timer. 
 *
 * @author Chris Thibodeau
 * Created Feb 3, 2017
 */
   
public class Quiz
{
   //classID is the class it belongs to. creatorID necessary?
   private long quizID, classID, creatorID;
   private String name;
   private Question[] questions; //should this be arrayList?
   private long startDate, endDate;
   //Class quizzes are instantiated as invisible to students 
   private boolean isOpen, isVisible;
   private int maxNumAttempts, maxAttemptTime;
   private long[] submissions;

   //Fills name, start and end dates, timer, and number of possible attempts
   // with preset values.
   public Quiz(long classID)//long creatorID
   {
      
   }
   
   //Validates and assigns parameters. Instantiates other quiz variables.
   public Quiz(long classID, String name, long startDate, long endDate, 
               int numAttempts, int timer)
   {

   }

   /* TODO
    * Will either use submissions to track, create a QuizScore object, 
    * possibly both. The quiz will be scored. Storage of score will be dependent
    * on whether the quiz is public or belongs to a class.
    *
    * Method is called when user submits, user chooses to leave and submit,
    * or time runs out.
    */
   public void submit()
   {
   
   }

   /* TODO
    * Somehow use submissions and Student data to count number of submissions 
    * from that user.
    *
    * @param student - object used to verify elligibility
    *
    * @returns number of times student has taken this quiz.
    */
   public int getNumAttempts(Student student)
   {
      return 0;
   }

   /*
    * 
    * Maybe just a GUI side method??
    */
   public void toggleVisibility()
   {
   
   }
   
   /*
    * Opens the quiz to the class. Upon creation, logic decides whether quiz 
    * is open or closed based on start/end dates. 
    */
   public void open()
   {

   }

   /*
    * Closes the quiz to the class. Upon creation, logic decides whether quiz
    * is open or closed based on the start/end dates. After end date is 
    * reached, quiz will close.
    */
   public void close()
   {

   }

   //TODO other functionality?
   //teacher edit students quiz scores
   //


   /*
    * Following methods may not be needed based on design.
    */ 
   public void addQuestion(Question question)
   {

   }
   
   public void addQuestion(Question question, int index)
   {

   }

   public Question removeQuestion(int index)
   {
      return null;
   } 

   public Question getQuestion(int index)
   {
      return null;
   }

   public Question[] getQuestions(int index)
   {
      return null;
   }
   
