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
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.UIManager;
import javax.swing.JSeparator;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.GridLayout;
import javax.swing.JTextPane;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.JPasswordField;

public class Settings extends JPanel {
	private JTextField textField;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JPasswordField passwordField_2;

	/**
	 * Create the panel.
	 */
	public Settings() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setVgap(0);
		flowLayout.setHgap(0);
		flowLayout.setAlignment(FlowLayout.LEFT);
		panel.setBorder(new EmptyBorder(0, 0, 0, 0));
		panel.setBackground(new Color(255, 0, 0));
		add(panel, BorderLayout.NORTH);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(UIManager.getColor("Button.background"));
		panel_2.setPreferredSize(new Dimension(10, 250));
		panel_2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		add(panel_2, BorderLayout.SOUTH);
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.X_AXIS));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(UIManager.getColor("Button.background"));
		panel_2.add(panel_1);
		panel_1.setLayout(null);
		
		JTextPane usernameText = new JTextPane();
		usernameText.setBackground(UIManager.getColor("Button.background"));
		usernameText.setBorder(null);
		usernameText.setText("Username");
		usernameText.setBounds(91, 30, 122, 20);
		panel_1.add(usernameText);
		
		JTextPane oldPassText = new JTextPane();
		oldPassText.setText("Enter Current Password: ");
		oldPassText.setBorder(null);
		oldPassText.setBackground(SystemColor.menu);
		oldPassText.setBounds(91, 92, 122, 20);
		panel_1.add(oldPassText);
		
		JTextPane txtpnEnterNewPassword = new JTextPane();
		txtpnEnterNewPassword.setText("Enter New Password: ");
		txtpnEnterNewPassword.setBorder(null);
		txtpnEnterNewPassword.setBackground(SystemColor.menu);
		txtpnEnterNewPassword.setBounds(91, 123, 122, 20);
		panel_1.add(txtpnEnterNewPassword);
		
		JTextPane txtpnReenterNewPassword = new JTextPane();
		txtpnReenterNewPassword.setText("Re-enter Password: ");
		txtpnReenterNewPassword.setBorder(null);
		txtpnReenterNewPassword.setBackground(SystemColor.menu);
		txtpnReenterNewPassword.setBounds(91, 154, 122, 20);
		panel_1.add(txtpnReenterNewPassword);
		
		JPanel panel_3 = new JPanel();
		panel_2.add(panel_3);
		panel_3.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(10, 30, 130, 20);
		panel_3.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Change Username");
		btnNewButton.setBounds(83, 61, 130, 23);
		panel_3.add(btnNewButton);
		
		JButton button = new JButton("Change Username");
		button.setBounds(83, 61, 130, 23);
		panel_3.add(button);
		
		JButton btnChangePassword = new JButton("Change Password");
		btnChangePassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnChangePassword.setBounds(83, 187, 130, 23);
		panel_3.add(btnChangePassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(10, 88, 130, 20);
		panel_3.add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(10, 119, 130, 20);
		panel_3.add(passwordField_1);
		
		passwordField_2 = new JPasswordField();
		passwordField_2.setBounds(10, 150, 130, 20);
		panel_3.add(passwordField_2);
		
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
		
		JLabel header = new JLabel("Settings");
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
