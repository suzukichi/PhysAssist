package logic;
/*
 * QuizPage.java
 * 
 * 
 * 
 * @author Kyle Ringler
 * Created Feb 13, 2017
 */


public class QuizPage extends Page {

  private long classID;
  
  private Quiz quiz;
  
  public QuizPage(String name, Quiz quiz) {
    super(name);
    this.quiz = quiz;
  }
  
  public void display() {
    
  }
}
