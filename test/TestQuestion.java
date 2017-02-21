package test;

/*
 * @author Kyle
 */

import static org.junit.Assert.*;
import org.junit.Test;
import logic.Question;
import logic.ShortAnswerQuestion;

public class TestQuestion {

  @Test
  public void TestQuestionConstructor() {
    String title = "Test Question";
    String text = "Are you in class?";
    Question question = new ShortAnswerQuestion(title, text);
    assertEquals(title, question.getTitle());
    assertEquals(text, question.getText());
  }
}
