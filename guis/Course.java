package guis;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.SoftBevelBorder;

public class Course extends JPanel {

	/**
	 * Create the panel.
	 */
	public Course() {
setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setVgap(0);
		flowLayout.setHgap(0);
		flowLayout.setAlignment(FlowLayout.LEFT);
		panel.setBorder(new EmptyBorder(0, 0, 0, 0));
		panel.setBackground(new Color(255, 0, 0));
		add(panel, BorderLayout.NORTH);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(null);
		panel_1.setBackground(UIManager.getColor("Button.background"));
		add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.Y_AXIS));
		
		JLabel backButton = new JLabel("");
		backButton.setToolTipText("Back");
		backButton.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		backButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent event) {
			      super.mouseClicked(event);

			      
			}
			@Override
			public void mousePressed(MouseEvent event) {
				super.mousePressed(event);
				if (event.getSource() instanceof JLabel) {
			    	 if (event.getButton() == MouseEvent.BUTTON1) {
				         JLabel label = (JLabel)event.getSource();
				         label.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
				         System.out.println("Label was clicked: " + label.getText());
			    	 }
			      }
			}
		});
		ImageIcon icon = new ImageIcon(Home.class.getResource("/images/leftIcon.png"));
		Image image = icon.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
		icon = new ImageIcon(image);
		backButton.setIcon(icon);
		panel.add(backButton);
		
		JLabel header = new JLabel("--Insert Class Info--");
		header.setForeground(new Color(0, 0, 0));
		header.setBorder(new EmptyBorder(0, 115, 0, 111));
		header.setFont(new Font("DialogInput", Font.BOLD, 22));
		header.setBackground(new Color(0, 0, 0));
		panel.add(header);
		
		
		
		JLabel menu = new JLabel("");
		
		JPopupMenu popupMenu = new JPopupMenu();
		addPopup(menu, popupMenu);
		
		
		JMenuItem menuTopicButton = new JMenuItem("Home");
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
		    		 cards.show(main, "home");
		    		 
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
		popupMenu.add(menuTopicButton);
		
		JMenuItem mntmTopics = new JMenuItem("Topics");
		mntmTopics.addMouseListener(new MouseAdapter() {
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
		mntmTopics.setBorder(null);
		mntmTopics.setHorizontalTextPosition(SwingConstants.LEFT);
		mntmTopics.setHorizontalAlignment(SwingConstants.LEFT);
		mntmTopics.setVerticalTextPosition(SwingConstants.TOP);
		mntmTopics.setVerticalAlignment(SwingConstants.TOP);
		mntmTopics.setPreferredSize(new Dimension(45, 22));
		mntmTopics.setFont(new Font("DialogInput", Font.PLAIN, 12));
		popupMenu.add(mntmTopics);
		
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
		popupMenu.add(menuGroupButton);
		
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
		popupMenu.add(menuQuizButton);
		
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
		popupMenu.add(mntmCalculator);
		
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
		popupMenu.add(mntmLogOut);
		
		menu.setToolTipText("Menu");
		menu.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		
		boolean menuTrigger = false; //click will close the menu. need it to act as a drop down where second click closes.
		menu.addMouseListener(new MouseAdapter() {
			boolean menuTrigger = false;
			@Override
			public void mouseClicked(MouseEvent event) {
			      super.mouseClicked(event);

			      if (event.getSource() instanceof JLabel) {
			         JLabel label = (JLabel)event.getSource();
			         if (!menuTrigger && event.getButton() == MouseEvent.BUTTON1) {
			        	 popupMenu.show(event.getComponent(), -23, 55);
				         menu.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
				         System.out.println("Label2 was clicked: " + label.getText());
				         menuTrigger = true;
			         }
			         if(!popupMenu.isVisible()) {
			        	 menuTrigger = false;
			        	 menu.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
			        	 
			         }
		         }
			}
			
		});
		
		addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent arg0) {
				super.mouseMoved(arg0);
				if(!popupMenu.isVisible())
					menu.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
			}
		});
		ImageIcon icon2 = new ImageIcon(Home.class.getResource("/images/menuIcon.png"));
		Image image2 = icon2.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
		icon2 = new ImageIcon(image2);
		menu.setIcon(icon2);
		panel.add(menu);
	}

	private void addPopup(JLabel menu, JPopupMenu popupMenu) {
		// TODO Auto-generated method stub
	}

}
