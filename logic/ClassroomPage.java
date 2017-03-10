package logic;

/*
 * ClassroomPage.java
 * 
 * All Pages that are part of a Classroom are Pages of this type.
 * 
 * @author Daniel Sabsay
 * Created Feb 24, 2017
 */

public abstract class ClassroomPage extends Page {
  public Classroom classroom;
  
  public ClassroomPage(String name, Classroom c) {
    super(name);
    this.classroom = c;
  }
}
