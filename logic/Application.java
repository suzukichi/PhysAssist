package logic;

import java.awt.EventQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

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
	}
}
