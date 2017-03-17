package guis;

import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

public class Home extends Page {

	private JLabel topicButton;
	private JLabel groupButton;
	private JLabel settingsButton;
	private JPanel homepageOptions; 
	private logic.SettingsPage settingsController;
	private logic.TopicListPage topicController;
	
	/**
	 * Create the panel.
	 */
	public Home() {
	   this.locationName = "PhysAssist";
	   this.createHeader();
		
		homepageOptions = new JPanel();
		homepageOptions.setBackground(StyleGuide.background2);
		homepageOptions.setBorder(new EmptyBorder(0, 0, 0, 0));
		FlowLayout flowLayout_1 = (FlowLayout) homepageOptions.getLayout();
		flowLayout_1.setVgap(0);
		flowLayout_1.setHgap(0);
		this.contentPanel.add(homepageOptions);
		
		this.createHomepageOptions();
	}	
		
	private void createHomepageOptions() {
		topicButton = new JLabel("");
		topicButton.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		topicButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent event) {
				super.mouseClicked(event);
			   
				topicController.initCatPage();
				showCard(event, "categories");   
			}
		});
		ImageIcon topicIcon = new ImageIcon(Home.class.getResource("/images/topicIcon.png"));
		Image topicImage = topicIcon.getImage().getScaledInstance(450, 110, Image.SCALE_DEFAULT);
		topicIcon = new ImageIcon(topicImage);
		topicButton.setIcon(topicIcon);
		homepageOptions.add(topicButton);
		
		groupButton = new JLabel("");
		groupButton.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		homepageOptions.add(groupButton);
		groupButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent event) {
				super.mouseClicked(event);
			   showCard(event, "groups");
			}
		});
		ImageIcon groupIcon = new ImageIcon(Home.class.getResource("/images/groupIcon.png"));
		Image groupImage = groupIcon.getImage().getScaledInstance(450, 110, Image.SCALE_DEFAULT);
		groupIcon = new ImageIcon(groupImage);
		groupButton.setIcon(groupIcon);
		
		
		settingsButton = new JLabel("");
		settingsButton.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		homepageOptions.add(settingsButton);
		settingsButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent event) {
				super.mouseClicked(event);
				settingsController.updateSettings();
			   showCard(event, "settings");
			}
		});
		ImageIcon settingsIcon = new ImageIcon(Home.class.getResource("/images/settingsIcon.png"));
		Image settingsImage = settingsIcon.getImage().getScaledInstance(450, 110, Image.SCALE_DEFAULT);
		settingsIcon = new ImageIcon(settingsImage);
		settingsButton.setIcon(settingsIcon);
		
		JLabel aboutButton = new JLabel("");
		aboutButton.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		homepageOptions.add(aboutButton);
		aboutButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent event) {
				super.mouseClicked(event);
			   showCard(event, "about");
			}
		});
		ImageIcon aboutIcon = new ImageIcon(Home.class.getResource("/images/aboutIcon.png"));
		Image aboutImage = aboutIcon.getImage().getScaledInstance(450, 110, Image.SCALE_DEFAULT);
		aboutIcon = new ImageIcon(aboutImage);
		aboutButton.setIcon(aboutIcon);
	}		
	
	public void showCard(MouseEvent event, String location) {
      if (event.getSource() instanceof JLabel && 
       event.getButton() == MouseEvent.BUTTON1) {
         JLabel label = (JLabel) event.getSource();
         JPanel temp = (JPanel) label.getParent();
         JPanel temp2 = (JPanel) temp.getParent();
         JPanel temp3 = (JPanel) temp2.getParent();
         MainWindow main = (MainWindow) temp3.getParent();
         CardLayout cards = main.getCardLayout();
         cards.show(main, location);
      }
	}

	public void addTopicController(logic.TopicListPage controller) {
		topicController = controller;
	}
	
	public void addCourseController(MouseAdapter controller) {
		//groupController = controller;
	}
	
	public void addSettingsController(logic.SettingsPage controller) {
		settingsController = controller;
	}
}
