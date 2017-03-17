package logic;
/*
 * HomePage.java
 * 
 * 
 * 
 * @author Kyle Ringler
 * Created Feb 13, 2017
 */

public class HomePage extends Page {
	private guis.Home homeView;
	private guis.About aboutView;
	private TopicListPage topicController;
	private SettingsPage settingsController;
		
  public HomePage(guis.MainWindow view){
	  topicController = new TopicListPage(view);
	  //courseController = new CourseList(view);
	  settingsController = new SettingsPage(view);
	  initView(view);
  }
  
  public void initView(guis.MainWindow view) {
	  homeView = new guis.Home();
	  homeView.addTopicController(topicController);
	  //homeView.addCourseController(courseController);
	  homeView.addSettingsController(settingsController);
	  settingsController.setHomeController(this);
	  view.add(homeView, "home");
	  
	  aboutView = new guis.About();
	  view.add(aboutView, "about");
  }
	
  /**
   * display does not change after init
   */
  @Override
	public void display() {
    
  }
  
  public void passUser(){
	  settingsController.user = user;
	  
	  //courseController.user = user;
  }
}
