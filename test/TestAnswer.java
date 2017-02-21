package test;

/*
 * @author Kyle
 */

import static org.junit.Assert.*;
import org.junit.Test;

import logic.Answer;
import logic.Question;
import logic.ShortAnswerQuestion;

public class TestAnswer {
  
  @Test
  public void TestAnswerConstructor() {
    String title = "Test Question";
    String questionText = "Is this a NGA?";
    Question question = new ShortAnswerQuestion(title, questionText);
    String answerText = "Yes";
    Answer answer = new Answer(answerText, question);
    assertEquals(answerText, answer.getText());
    assertEquals(question, answer.getQuestion());
  }
  
}
