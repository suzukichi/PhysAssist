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
	//public TopicList topicController;
	//public CourseList courseController;
	public SettingsPage settingsController;
		
  public HomePage(guis.MainWindow view){
	  //topicController = new TopicList(view);
	  //courseController = new CourseList(view);
	  //settingsController = new SettingsPage(view);
	  initView(view);
  }
  
  public void initView(guis.MainWindow view) {
	  homeView = new guis.Home();
	  //homeView.addTopicController(topicController);
	  //homeView.addCourseController(courseController);
	  homeView.addSettingsController(settingsController);
	  
	  view.add(homeView, "home");
  }
	
  /**
   * display does not change after init
   */
  @Override
	public void display() {
    
  }
  
  
}
