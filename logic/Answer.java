package logic;

public class Answer {
  private long answerID;
  private String text;
  private Question question;
  
  public Answer(String text, Question question) {
    this.text = text;
    this.question = question;
  }
  
  public String getText() {
    return text;
  }
  
  public Question getQuestion() {
    return question;
  }
}
