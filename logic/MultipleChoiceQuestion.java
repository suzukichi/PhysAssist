package logic;

public class MultipleChoiceQuestion extends Question {
  private long answerID;
  private Choice[] choices;
  
  public MultipleChoiceQuestion(String title, String text) {
    super(title, text);
  }
}
