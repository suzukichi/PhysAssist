package logic;

public abstract class Question {
  private long questionID;
  private long quizID;
  private String text;
  private String title;
  private long selectedAnswer;
  private int points;
  private enum type {};
  private Answer answer;
  
  public Question(String title, String text) {
    this.title = title;
    this.text = text;
  }
  
  public String getText() {
    return text;
  }
  
  public String getTitle() {
    return title;
  }
  
  public void markString(String str) {
    
  }
  
  
}
