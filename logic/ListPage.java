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
  public String searchTerm;
  
  public abstract void display(String str);
}