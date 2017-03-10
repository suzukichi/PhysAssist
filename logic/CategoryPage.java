package logic;
/*
 * CategoryPage.java
 * 
 * 
 * 
 * @author Kyle Ringler
 * Created Feb 13, 2017
 */

public class CategoryPage extends Page {

  private long categoryID;
  
  public CategoryPage(String name, long categoryID) {
    super(name);
    this.categoryID = categoryID;
  }
  
  public void display() {
    
  }
}
