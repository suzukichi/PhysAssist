package logic;
/*
 * LoginPage.java
 * 
 * 
 * 
 * @author Kyle Ringler
 * Created Feb 13, 2017
 */

import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JLabel;

import guis.MainWindow;

public class LoginPage extends Page {
  private boolean isRegister;
  private guis.Login page;
  public guis.MainWindow view;
  
  //pass controller topics or query them
  public LoginPage(guis.MainWindow view){
	  this.view = view;
	  initView(view);
  }
  
  @Override
  public void display() {
      
  }
  
	/**
	 * This controller exists on home page topics button and menu topics.
	 * Nothing need be done as topics will not dynamically change.
	 */
	@Override
	public void mouseClicked(MouseEvent event) {
		// TODO Auto-generated method stub
		//nothing here
	}
 
	/**
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
   public int verify(String username, String password) {
	   long userID = User.verify(username, password);
	   
	   if(userID < 0) {
		   return -1;
	   }
	   else {
		   this.user = new User(userID);
		   return 1;
	   }
   }
	
	public void initView(MainWindow view){
		  page = new guis.Login();
		  page.addController(this);
		  view.add(page, "login");
	  }
}
