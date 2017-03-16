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
	public TopicListPage topicController;
	//public CourseList courseController;
	public SettingsPage settingsController;
		
  public HomePage(guis.MainWindow view){
	  topicController = new TopicListPage(view);
	  //courseController = new CourseList(view);
	  //settingsController = new SettingsPage(view);
	  initView(view);
  }
  
  public void initView(guis.MainWindow view) {
	  homeView = new guis.Home();
	  homeView.addTopicController(topicController);
	  //homeView.addCourseController(courseController);
	  homeView.addSettingsController(settingsController);
	  settingsController.homeController = this;
	  view.add(homeView, "home");
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
