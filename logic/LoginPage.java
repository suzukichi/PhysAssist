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
  public HomePage homeController;
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
 
   public int verify(String username, String password) {
	   long userID = 0;
	   /**DB db = DB.getInstance();
      String q_getTopic = "SELECT 'title', 'topicid" +
                          " FROM `topic_revisions` tr" +
                          " JOIN `topics` t " +
                          "WHERE t.`parentid` = ? " +
                          " ORDER BY `title` DESC";
      String[] p_getTopic = {DB.T_I, String.valueOf(0)};
      ArrayList<HashMap<String, String>> rows = db.query(q_getTopic, p_getTopic);

      if(rows.isEmpty()){
        //TODO throw exception
        return;
      }
      for(int i = 0; i < rows.size(); i++) {
         System.out.println(rows.get(i).get("title"));
         System.out.println(Long.valueOf(rows.get(i).get("topicid")));
      }*/
	   //query for username, compare passwords
	   //view will show home or error based on 0 or 1
	   //controller passes userID to homePage
	   //homeController = new HomePage(view, userID);
	   return 0;
	   
   }
	
	public void initView(MainWindow view){
		  page = new guis.Login();
		  page.addController(this);
		  view.add(page, "login");
	  }
}
