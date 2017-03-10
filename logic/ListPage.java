package logic;
/*
 * ListPage.java
 * 
 * 
 * 
 * @author Kyle Ringler
 * Created Feb 13, 2017
 */

public abstract class ListPage extends Page {
  
  public ListPage(String name) {
    super(name);
  }
  
  public abstract void display(String str);
}
