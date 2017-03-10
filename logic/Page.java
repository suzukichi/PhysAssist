package logic;
/*
 * Page.java
 * 
 * 
 * 
 * @author Kyle Ringler
 * Created Feb 13, 2017
 */
public abstract class Page {

  private String name;
  
  public Page(String name) {
    this.name = name;
  }
  
  public abstract void display();
}
