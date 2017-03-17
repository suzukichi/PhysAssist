package logic;

import java.awt.EventQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

//import test.TestAST;



public class Application {
	static final Logger LOGGER = Logger.getLogger(Application.class.getName());
	private guis.MainFrame frame;
	private LoginPage loginController;
	private HomePage homeController;
	
	public Application(){
		init();
	}
	
	public static void main(String[] args){
		EventQueue.invokeLater(() -> {try { new Application(); } 
		 catch (Exception e) { 
			 LOGGER.log(Level.FINE, e.toString(), e); 
			 } 
		});
				
				/*new Runnable() {
			@Override
			public void run() {
				try {
					new Application();
				} catch (Exception e) {
					LOGGER.log(Level.FINE, e.toString(), e);
				}
			}
		});*/
		
		
	}
	
	public void init() {
		//create MainFrame
		frame = new guis.MainFrame();
		guis.MainWindow view = frame.getPanel();
		
		//create login controller, passes user ID to home
		homeController = new HomePage(view);
		loginController = new LoginPage(view);
		loginController.setHomeController(homeController);
		view.getCardLayout().show(view, "login");
		//creates home page controller
			//creates topic controller 
				//cascades to create reference, equations, topics and lists views
				//topics, topic, reference, equations equation
			//create groups
			//courseList = new CourseList(view, 0);
				//cascades to posts, course page
				//courses, course[list of posts, quizzes?], posts
			
			//settings controller
				//leads to settings page, grabs user default settings and pulls it up.
				//or it is on the page and performs the appropriate save?
		//login controller
			//on login page, handles login logic
		//home controller
			//on login page, update settings button(rm from menu = ezpz, else hard)
		//view.getCardLayout().show(view, "login");
	}
	
	
}
