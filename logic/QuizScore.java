package logic;
/*
 * QuizScore.java
 *
 * QuizScores are objects used to store the relations between students and 
 * the quizzes they take. There may be 0 to many quiz scores per quiz. 
 *
 * TODO
 * how scoring is handled is not designed/approved
 *
 * @author Chris Thibodeau
 * Created Feb 3, 2017
 */
   
public class QuizScore
{  
   private long quizID, userID, quizScoreID;
   private long dateStarted, dateEnded;
   //Class quizzes are instantiated as invisible to students 
   private int totalQuestions, numCorrect;
   private float score;


   //Sets all variables, variables remain constant.
   public QuizScore(long quizID, long userID, long dateStarted, long dateEnded,
                     int correctAnswers, int numQuestions)
   {

   }

   /*
    * Allows teacher to change a students score on a quiz.
    * There will be no implementation of teachers making a certain question
    * correct or not. No implementation of questions with different weights.
    */
   public float setScore(float percent)
   {
     return 0;
   }

   /*
    * Resets the score to the value based on correct/total
    */
   public void resetScore()
   {
   
   }

   /*
    * @returns score either set by the teacher or calculated
    */
   public float getScore()
   {
      return 0;
   }

   /*
    * @returns the time user spent on quiz based on start and end timestamps.
    */
   public int getTimeTaken()
   {
      return 0;
   }
}
