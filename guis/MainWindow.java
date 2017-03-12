package guis;

import java.awt.CardLayout;

import javax.swing.JPanel;

public class MainWindow extends JPanel {

	private CardLayout cardlayout;
	public Topics topicList;
	JPanel main;
	/**
	 * Create the panel.
	 */
	public MainWindow() {
		cardlayout = new CardLayout(0, 0);
		setLayout(cardlayout);
		
		main = new JPanel(cardlayout);
		add(new Home(), "home");
		add(new About(), "about");
		
		topicList = new Topics();
		add(topicList, "topics1");
		add(new Courses(), "groups");
		add(new Login(), "login");
		add(new Quizzes(), "quizzes");
		add(new Settings(), "settings");
		
		add(new Topic(), "category");
		add(new Equations(), "equations");
		add(new Equation(), "equation");
		add(new Notification(), "notification");
		add(new Quiz(), "quiz");
		add(new Reference(), "reference");
		add(new Course(), "group");
	}
	
	public CardLayout getCardLayout() {
		return cardlayout;
	}
	
	public void addView(JPanel view, String name){
		
	}

}
