package test;

import static org.junit.Assert.*;
import org.hamcrest.core.IsCollectionContaining;

import org.junit.Test;

import logic.Classroom;
import logic.User;

public class TestUser {

  @Test
  public void TestUserEnrollClassroom() {
    Classroom c = new Classroom("class", "class decsription", 1);
    User user = new User("username", "bob", "smith", "password", "bob@email.com");
    
    user.enrollClassroom(c);
    assertThat(user.classroomsEnrolled, IsCollectionContaining.hasItem(c));
  }

}
