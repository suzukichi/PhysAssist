package guis;

import java.awt.CardLayout;

import javax.swing.JPanel;

public class MainWindow extends JPanel {

	private CardLayout cardlayout;
	private Topics topicList;
	private JPanel main;
	/**
	 * Create the panel.
	 */
	public MainWindow() {
		cardlayout = new CardLayout(0, 0);
		setLayout(cardlayout);
		
		main = new JPanel(cardlayout);
		add(new ViewTopic(), "category");
		Equations temp = new Equations();
		add(temp, "equations");
		Equation temp1 = new Equation();
		add(temp1, "equation");
		add(new Notification(), "notification");
		add(new Reference(), "reference");
		add(new Course(), "group");
		cardlayout.show(this, "equation");
	}
	
	public CardLayout getCardLayout() {
		return cardlayout;
	}
}
