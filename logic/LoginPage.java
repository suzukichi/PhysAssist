package logic;
/*
 * LoginPage.java
 * 
 * 
 * 
 * @author Kyle Ringler
 * Created Feb 13, 2017
 */

import guis.MainWindow;

public class LoginPage extends Page {
  private boolean isRegister;
  private guis.Login loginPage;
  private guis.CreateAccount createPage;
  public guis.MainWindow view;
  public logic.HomePage homeController;
  
  //pass controller topics or query them
  public LoginPage(guis.MainWindow view){
	  this.view = view;
	  initView(view);
  }
  
  @Override
  public void display() {
      
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
		   homeController.user =  new User(userID);
		   homeController.passUser();
		   return 1;
	   }
   }
	
   public int validate(String username, String firstName, String lastName, String password, String email) {
	   if(User.nameExists(username))
		   return -1;
	   if(User.emailExists(email))
		   return -2;
	   homeController.user = new logic.User(username, firstName, lastName, password, email);
	   homeController.passUser();
	   return 1;
   }
   
   
	public void initView(MainWindow view){
		loginPage = new guis.Login();
		loginPage.addController(this);
		view.add(loginPage, "login");
		
		createPage = new guis.CreateAccount();
		createPage.addController(this);
		view.add(createPage, "create_account");
	}
}
