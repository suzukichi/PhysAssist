package test;

import static org.junit.Assert.*;

import org.junit.Test;

import logic.Role;
import logic.Student;

public class TestRole {

  @Test
  public void TestRoleName() {
    Role role = new Student();
    assertEquals("student", role.roleName);
  }

}
