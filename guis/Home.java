package guis;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.CardLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JPopupMenu;
import javax.swing.JRootPane;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenuItem;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Dimension;
import java.awt.Rectangle;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;

import java.awt.FlowLayout;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.BoxLayout;
import java.awt.event.MouseMotionAdapter;
import javax.swing.UIManager;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.GridLayout;

public class Home extends JPanel {

	private JLabel topicButton;
	private JLabel groupButton;
	private JLabel settingsButton;
	
	/**
	 * Create the panel.
	 */
	public Home() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(50, 56));
		panel.setBorder(new EmptyBorder(0, 0, 0, 0));
		panel.setBackground(new Color(255, 0, 0));
		add(panel, BorderLayout.NORTH);
		panel.setLayout(null);
		
		
		
		JLabel menu = new JLabel("");
		menu.setBounds(467, 0, 56, 56);
		panel.add(menu);
		
		JPopupMenu popupMenu_1 = new JPopupMenu();
		popupMenu_1.setBounds(new Rectangle(0, 0, 1, 1));
		addPopup(menu, popupMenu_1);
		
		
		JMenuItem menuTopicButton = new JMenuItem("Topics");
		menuTopicButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent event) {
				super.mousePressed(event);
				if (event.getButton() == MouseEvent.BUTTON1) {
					JMenuItem menuItem = (JMenuItem) event.getSource();
					JPopupMenu popupMenu = (JPopupMenu) menuItem.getParent();
					JLabel label = (JLabel) popupMenu.getInvoker();
		    		 JPanel temp = (JPanel) label.getParent();
		    		 JPanel temp2 = (JPanel) temp.getParent();
		    		MainWindow main = (MainWindow) temp2.getParent();
		    		 CardLayout cards = main.getCardLayout();
		    		 cards.show(main, "topics");
		    		 
				}
			}
		});
		menuTopicButton.setBorder(null);
		menuTopicButton.setPreferredSize(new Dimension(45, 22));
		menuTopicButton.setHorizontalTextPosition(SwingConstants.LEFT);
		menuTopicButton.setHorizontalAlignment(SwingConstants.LEFT);
		menuTopicButton.setVerticalTextPosition(SwingConstants.TOP);
		menuTopicButton.setVerticalAlignment(SwingConstants.TOP);
		menuTopicButton.setFont(new Font("DialogInput", Font.PLAIN, 12));
		popupMenu_1.add(menuTopicButton);
		
		JMenuItem menuGroupButton = new JMenuItem("Groups");
		menuGroupButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent event) {
				super.mousePressed(event);
		    	 if (event.getButton() == MouseEvent.BUTTON1) {
		    		 JMenuItem menuItem = (JMenuItem) event.getSource();
						JPopupMenu popupMenu = (JPopupMenu) menuItem.getParent();
						JLabel label = (JLabel) popupMenu.getInvoker();
			    		 JPanel temp = (JPanel) label.getParent();
			    		 JPanel temp2 = (JPanel) temp.getParent();
			    		MainWindow main = (MainWindow) temp2.getParent();
			    		 CardLayout cards = main.getCardLayout();
		    		 cards.show(main, "groups");
		    	 }
			}
		});
		menuGroupButton.setBorder(null);
		menuGroupButton.setHorizontalTextPosition(SwingConstants.LEFT);
		menuGroupButton.setHorizontalAlignment(SwingConstants.LEFT);
		menuGroupButton.setVerticalTextPosition(SwingConstants.TOP);
		menuGroupButton.setVerticalAlignment(SwingConstants.TOP);
		menuGroupButton.setPreferredSize(new Dimension(45, 22));
		menuGroupButton.setFont(new Font("DialogInput", Font.PLAIN, 12));
		popupMenu_1.add(menuGroupButton);
		
		JMenuItem menuQuizButton = new JMenuItem("Quizzes");
		menuQuizButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent event) {
				super.mousePressed(event);
		    	 if (event.getButton() == MouseEvent.BUTTON1) {
		    		 JMenuItem menuItem = (JMenuItem) event.getSource();
						JPopupMenu popupMenu = (JPopupMenu) menuItem.getParent();
						JLabel label = (JLabel) popupMenu.getInvoker();
			    		 JPanel temp = (JPanel) label.getParent();
			    		 JPanel temp2 = (JPanel) temp.getParent();
			    		MainWindow main = (MainWindow) temp2.getParent();
			    		 CardLayout cards = main.getCardLayout();
		    		 cards.show(main, "quizzes");
				}
			}
		});
		menuQuizButton.setBorder(null);
		menuQuizButton.setHorizontalTextPosition(SwingConstants.LEFT);
		menuQuizButton.setVerticalTextPosition(SwingConstants.TOP);
		menuQuizButton.setVerticalAlignment(SwingConstants.TOP);
		menuQuizButton.setPreferredSize(new Dimension(45, 22));
		menuQuizButton.setFont(new Font("DialogInput", Font.PLAIN, 12));
		popupMenu_1.add(menuQuizButton);
		
		JMenuItem mntmCalculator = new JMenuItem("Calculator");
		mntmCalculator.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent event) {
				super.mousePressed(event);
				if (event.getButton() == MouseEvent.BUTTON1) {
			   
				}
			}
		});
		mntmCalculator.setBorder(null);
		mntmCalculator.setHorizontalAlignment(SwingConstants.LEFT);
		mntmCalculator.setHorizontalTextPosition(SwingConstants.LEFT);
		mntmCalculator.setVerticalTextPosition(SwingConstants.TOP);
		mntmCalculator.setVerticalAlignment(SwingConstants.TOP);
		mntmCalculator.setPreferredSize(new Dimension(65, 22));
		mntmCalculator.setFont(new Font("DialogInput", Font.PLAIN, 12));
		popupMenu_1.add(mntmCalculator);
		
		JMenuItem mntmSettings = new JMenuItem("Settings");
		mntmSettings.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent event) {
				super.mousePressed(event);
		    	 if (event.getButton() == MouseEvent.BUTTON1) {
		    		 JMenuItem menuItem = (JMenuItem) event.getSource();
						JPopupMenu popupMenu = (JPopupMenu) menuItem.getParent();
						JLabel label = (JLabel) popupMenu.getInvoker();
			    		 JPanel temp = (JPanel) label.getParent();
			    		 JPanel temp2 = (JPanel) temp.getParent();
			    		MainWindow main = (MainWindow) temp2.getParent();
			    		 CardLayout cards = main.getCardLayout();
		    		 cards.show(main, "settings");
		    	 }
			}
		});
		mntmSettings.setBorder(null);
		mntmSettings.setHorizontalTextPosition(SwingConstants.LEFT);
		mntmSettings.setHorizontalAlignment(SwingConstants.LEFT);
		mntmSettings.setVerticalTextPosition(SwingConstants.TOP);
		mntmSettings.setVerticalAlignment(SwingConstants.TOP);
		mntmSettings.setPreferredSize(new Dimension(45, 22));
		mntmSettings.setFont(new Font("DialogInput", Font.PLAIN, 12));
		popupMenu_1.add(mntmSettings);
		
		JMenuItem mntmLogOut = new JMenuItem("Log Out");
		mntmLogOut.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent event) {
				super.mousePressed(event);
		    	 if (event.getButton() == MouseEvent.BUTTON1) {
		    		 JMenuItem menuItem = (JMenuItem) event.getSource();
						JPopupMenu popupMenu = (JPopupMenu) menuItem.getParent();
						JLabel label = (JLabel) popupMenu.getInvoker();
			    		 JPanel temp = (JPanel) label.getParent();
			    		 JPanel temp2 = (JPanel) temp.getParent();
			    		MainWindow main = (MainWindow) temp2.getParent();
			    		 CardLayout cards = main.getCardLayout();
		    		 cards.show(main, "login");
		    	 }
			}
		});
		mntmLogOut.setBorder(null);
		mntmLogOut.setAlignmentY(0.0f);
		mntmLogOut.setAlignmentX(0.0f);
		mntmLogOut.setHorizontalTextPosition(SwingConstants.LEFT);
		mntmLogOut.setHorizontalAlignment(SwingConstants.LEFT);
		mntmLogOut.setVerticalTextPosition(SwingConstants.TOP);
		mntmLogOut.setVerticalAlignment(SwingConstants.TOP);
		mntmLogOut.setPreferredSize(new Dimension(45, 22));
		mntmLogOut.setFont(new Font("DialogInput", Font.PLAIN, 12));
		popupMenu_1.add(mntmLogOut);
		
		menu.setToolTipText("Menu");
		menu.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		menu.addMouseListener(new MouseAdapter() {
			boolean menuTrigger = false;
			@Override
			public void mousePressed(MouseEvent event) {
			      super.mousePressed(event);

			      if (event.getSource() instanceof JLabel) {
			         JLabel label = (JLabel)event.getSource();
			         if (!menuTrigger && event.getButton() == MouseEvent.BUTTON1) {
			        	 popupMenu_1.show(event.getComponent(), -23, 55);
				         menu.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
				         System.out.println("Label2 was clicked: " + label.getText());
				         menuTrigger = true;
			         }
			         if(!popupMenu_1.isVisible()) {
			        	 menuTrigger = false;
			        	 menu.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
			        	 
			         }
		         }
			}
			
		});
		
		JPanel headerPanel = new JPanel();
		headerPanel.setBounds(0, 0, 523, 56);
		headerPanel.setBackground(StyleGuide.headerMain);
		panel.add(headerPanel);
		
		JLabel groupName = new JLabel("PhysAssist");
		groupName.setVerticalAlignment(SwingConstants.BOTTOM);
		groupName.setHorizontalAlignment(SwingConstants.CENTER);
		headerPanel.add(groupName);
		groupName.setForeground(Color.BLACK);
		groupName.setFont(new Font("DialogInput", Font.BOLD, 22));
		groupName.setBorder(new EmptyBorder(0, 0, 0, 0));
		groupName.setBackground(Color.BLACK);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(null);
		panel_1.setBackground(new Color(211, 211, 211));
		add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.Y_AXIS));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(UIManager.getColor("Button.background"));
		panel_2.setSize(new Dimension(448, 50));
		panel_2.setBorder(new EmptyBorder(0, 0, 0, 0));
		FlowLayout flowLayout_1 = (FlowLayout) panel_2.getLayout();
		flowLayout_1.setVgap(0);
		flowLayout_1.setHgap(0);
		panel_1.add(panel_2);
		ImageIcon topicIcon = new ImageIcon(Home.class.getResource("/images/topicIcon.png"));
		Image topicImage = topicIcon.getImage().getScaledInstance(450, 110, Image.SCALE_DEFAULT);
		topicIcon = new ImageIcon(topicImage);
		
		topicButton = new JLabel("");
		topicButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent event) {
				super.mouseClicked(event);
				if (event.getSource() instanceof JLabel) {
			    	 if (event.getButton() == MouseEvent.BUTTON1) {
			    		 JLabel label = (JLabel) event.getSource();
			    		 JPanel temp = (JPanel) label.getParent();
			    		 JPanel temp2 = (JPanel) temp.getParent();
			    		 JPanel temp3 = (JPanel) temp2.getParent();
			    		 MainWindow main = (MainWindow) temp3.getParent();
			    		 CardLayout cards = main.getCardLayout();
			    		 cards.show(main, "topics");
			    	 }
				}
			}
		});
		topicButton.setIcon(topicIcon);
		panel_2.add(topicButton);
		
		groupButton = new JLabel("");
		panel_2.add(groupButton);
		groupButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent event) {
				super.mouseClicked(event);
				if (event.getSource() instanceof JLabel) {
			    	 if (event.getButton() == MouseEvent.BUTTON1) {
						JLabel label = (JLabel) event.getSource();
			    		 JPanel temp = (JPanel) label.getParent();
			    		 JPanel temp2 = (JPanel) temp.getParent();
			    		 JPanel temp3 = (JPanel) temp2.getParent();
			    		 MainWindow main = (MainWindow) temp3.getParent();
			    		 CardLayout cards = main.getCardLayout();
			    		 cards.show(main, "groups");
			    	 }
				}
			}
		});
		ImageIcon groupIcon = new ImageIcon(Home.class.getResource("/images/groupIcon.png"));
		Image groupImage = groupIcon.getImage().getScaledInstance(450, 110, Image.SCALE_DEFAULT);
		groupIcon = new ImageIcon(groupImage);
		groupButton.setIcon(groupIcon);
		
		
		settingsButton = new JLabel("");
		panel_2.add(settingsButton);
		settingsButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent event) {
				super.mouseClicked(event);
				if (event.getSource() instanceof JLabel) {
			    	 if (event.getButton() == MouseEvent.BUTTON1) {
						JLabel label = (JLabel) event.getSource();
			    		 JPanel temp = (JPanel) label.getParent();
			    		 JPanel temp2 = (JPanel) temp.getParent();
			    		 JPanel temp3 = (JPanel) temp2.getParent();
			    		 MainWindow main = (MainWindow) temp3.getParent();
			    		 CardLayout cards = main.getCardLayout();
			    		 cards.show(main, "settings");
			    	 }
				}
			}
		});
		ImageIcon settingsIcon = new ImageIcon(Home.class.getResource("/images/settingsIcon.png"));
		Image settingsImage = settingsIcon.getImage().getScaledInstance(450, 110, Image.SCALE_DEFAULT);
		settingsIcon = new ImageIcon(settingsImage);
		settingsButton.setIcon(settingsIcon);
		
		JLabel aboutButton = new JLabel("");
		panel_2.add(aboutButton);
		aboutButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent event) {
				super.mouseClicked(event);
				if (event.getSource() instanceof JLabel) {
			    	 if (event.getButton() == MouseEvent.BUTTON1) {
						JLabel label = (JLabel) event.getSource();
			    		 JPanel temp = (JPanel) label.getParent();
			    		 JPanel temp2 = (JPanel) temp.getParent();
			    		 JPanel temp3 = (JPanel) temp2.getParent();
			    		 MainWindow main = (MainWindow) temp3.getParent();
			    		 CardLayout cards = main.getCardLayout();
			    		 cards.show(main, "about");
			    	 }
				}
			}
		});
		ImageIcon aboutIcon = new ImageIcon(Home.class.getResource("/images/aboutIcon.png"));
		Image aboutImage = aboutIcon.getImage().getScaledInstance(450, 110, Image.SCALE_DEFAULT);
		aboutIcon = new ImageIcon(aboutImage);
		aboutButton.setIcon(aboutIcon);
		
		JPanel panel_4 = new JPanel();
		add(panel_4, BorderLayout.SOUTH);
		ImageIcon icon = new ImageIcon(Home.class.getResource("/images/leftIcon.png"));
		Image image = icon.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
		icon = new ImageIcon(image);
		
		boolean menuTrigger = false; //click will close the menu. need it to act as a drop down where second click closes.
		
		addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent arg0) {
				super.mouseMoved(arg0);
				if(!popupMenu_1.isVisible())
					menu.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
			}
		});
		ImageIcon icon2 = new ImageIcon(Home.class.getResource("/images/menuIcon.png"));
		Image image2 = icon2.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
		icon2 = new ImageIcon(image2);
		menu.setIcon(icon2);
	}

	public void addTopicController(MouseAdapter controller) {
		topicButton.addMouseListener(controller);
	}
	
	public void addCourseController(MouseAdapter controller) {
		groupButton.addMouseListener(controller);
	}
	
	public void addSettingsController(MouseAdapter controller) {
		settingsButton.addMouseListener(controller);
	}
	
	private static void addPopup(Component component, final JPopupMenu popup) {
	}
}
