package logic;

import java.awt.event.MouseAdapter;

/*
 * Page.java
 * 
 * 
 * 
 * @author Kyle Ringler
 * Created Feb 13, 2017
 */
public abstract class Page extends MouseAdapter {

	  private String name;
	  
	  public abstract void display();
}
