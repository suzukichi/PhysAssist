package guis;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;

public class Page extends JPanel{
   protected String locationName;
   protected JPanel contentPanel;
   protected JPanel headerPanel;
   
   protected void createHeader() {
		setLayout(new BorderLayout(0, 0));
		
	   headerPanel = new JPanel();
      headerPanel.setBorder(new EmptyBorder(0, 0, 0, 0));
      headerPanel.setBackground(StyleGuide.headerMain);
		add(headerPanel, BorderLayout.NORTH);

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
		ImageIcon icon = new ImageIcon(Home.class.getResource("/images/backButtonIcon.png"));
		Image image = icon.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
		icon = new ImageIcon(image);
		headerPanel.setLayout(new BoxLayout(headerPanel, BoxLayout.X_AXIS));
		backButton.setIcon(icon);
		headerPanel.add(backButton);
		
		this.setupPageTitle();
		
		JLabel menu = new JLabel("");
		menu.setHorizontalAlignment(SwingConstants.TRAILING);
		
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
		
		JMenuItem mntmSettings = new JMenuItem("Settings");
		mntmSettings.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent event) {
				super.mousePressed(event);
		    	 if (event.getButton() == MouseEvent.BUTTON1) {
		    		 
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
		popupMenu.add(mntmSettings);
		
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
		
		// click will close the menu. need it to act as a drop down where second click closes.
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
		headerPanel.add(menu);
		contentPanel = new JPanel();
		contentPanel.setBorder(null);
		contentPanel.setBackground(StyleGuide.background);
		add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
   }

   protected void setupPageTitle() {
      // TODO: how to get title to work ok?
		JLabel pageTitle = new JLabel(this.locationName);
		pageTitle.setForeground(StyleGuide.header1);
		pageTitle.setBorder(new EmptyBorder(0, 113, 0, 113));
		pageTitle.setFont(new Font("DialogInput", Font.BOLD, 22));
		pageTitle.setBackground(StyleGuide.contentBackground);
		headerPanel.add(pageTitle);
   }

   private void addPopup(JLabel menu, JPopupMenu popupMenu) {
      // Auto-generated method stub
   }
}
