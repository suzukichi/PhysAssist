package guis;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
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
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.SoftBevelBorder;

@SuppressWarnings("serial")
public class Page extends JPanel {
   protected String locationName;
   protected JPanel contentPanel;
   protected JPanel headerPanel;
   
   protected void createHeader() {
		setLayout(new BorderLayout(0, 0));
		
	   headerPanel = new JPanel();
      headerPanel.setBorder(new EmptyBorder(0, 0, 0, 0));
      headerPanel.setBackground(StyleGuide.headerMain);
		add(headerPanel, BorderLayout.PAGE_START);
		headerPanel.setLayout(new BorderLayout(0, 0));
		
		this.setupPageTitle();

		// menu should not be shown on login page.
		this.setupMenu();

		contentPanel = new JPanel();
		contentPanel.setBorder(null);
		contentPanel.setBackground(StyleGuide.background);
		add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
   }
   JPopupMenu popupMenu;
   JLabel menu;
   protected void setupMenu() {	
		menu = new JLabel("");
		popupMenu = new JPopupMenu();
		addPopup(menu, popupMenu);

		// click will close the menu. need it to act as a drop down where second click closes.
		menu.addMouseListener(new MouseAdapter() {
			boolean menuTrigger = false;
			@Override
			public void mouseClicked(MouseEvent event) {
			      super.mouseClicked(event);

			      if (event.getSource() instanceof JLabel) {
			         if (!menuTrigger && event.getButton() == MouseEvent.BUTTON1) {
                     popupMenu.show(event.getComponent(), -23, 55);
				         menu.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
				         menuTrigger = true;
			         }

			         if (!popupMenu.isVisible()) {
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
				if(!popupMenu.isVisible()) {
					menu.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
				}
			}
		});
		ImageIcon menuIcon = new ImageIcon(Home.class.getResource("/images/menuIcon.png"));
		Image menuIconImage = menuIcon.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
		menuIcon = new ImageIcon(menuIconImage);
		menu.setIcon(menuIcon);
		headerPanel.add(menu, BorderLayout.EAST);
		
		JMenuItem menuHomeButton = new JMenuItem("Home");
		menuHomeButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent event) {
				super.mousePressed(event);
				showDropdownCard(event, "home");
			}
		});
		menuHomeButton.setBorder(null);
		menuHomeButton.setPreferredSize(new Dimension(45, 22));
		menuHomeButton.setHorizontalTextPosition(SwingConstants.LEFT);
		menuHomeButton.setHorizontalAlignment(SwingConstants.LEFT);
		menuHomeButton.setVerticalTextPosition(SwingConstants.TOP);
		menuHomeButton.setVerticalAlignment(SwingConstants.TOP);
		menuHomeButton.setFont(new Font("DialogInput", Font.PLAIN, 12));
		popupMenu.add(menuHomeButton, BorderLayout.EAST);
		
		JMenuItem menuTopicButton = new JMenuItem("Topics");
		menuTopicButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent event) {
				super.mousePressed(event);
				showDropdownCard(event, "topics");
			}
		});
		menuTopicButton.setBorder(null);
		menuTopicButton.setPreferredSize(new Dimension(45, 22));
		menuTopicButton.setHorizontalTextPosition(SwingConstants.LEFT);
		menuTopicButton.setHorizontalAlignment(SwingConstants.LEFT);
		menuTopicButton.setVerticalTextPosition(SwingConstants.TOP);
		menuTopicButton.setVerticalAlignment(SwingConstants.TOP);
		menuTopicButton.setFont(new Font("DialogInput", Font.PLAIN, 12));
		popupMenu.add(menuTopicButton, BorderLayout.EAST);
		JMenuItem menuGroupButton = new JMenuItem("Groups");
		menuGroupButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent event) {
				super.mousePressed(event);
				showDropdownCard(event, "groups");
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
		
		JMenuItem mntmCalculator = new JMenuItem("Calculator");
		mntmCalculator.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent event) {
				super.mousePressed(event);
				new logic.Calculator();
				showDropdownCard(event, "calculator");
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
				showDropdownCard(event, "settings");
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
				showDropdownCard(event, "login");
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
		
   }

   protected void createBackButton() {
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
			    	 }
            }
			}
		});
		ImageIcon icon = new ImageIcon(Home.class.getResource("/images/backButtonIcon.png"));
		Image image = icon.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
		icon = new ImageIcon(image);
		headerPanel.setLayout(new BoxLayout(headerPanel, BoxLayout.X_AXIS));
		backButton.setIcon(icon);
		headerPanel.add(backButton, BorderLayout.LINE_START);
   }

   protected void setupPageTitle() {
		JLabel pageTitle = new JLabel(this.locationName);
		pageTitle.setForeground(StyleGuide.header1);
		pageTitle.setBorder(new EmptyBorder(0, 113, 0, 113));
		pageTitle.setFont(new Font("DialogInput", Font.BOLD, 22));
		pageTitle.setBackground(StyleGuide.contentBackground);
		headerPanel.add(pageTitle);
   }

   protected void showDropdownCard(MouseEvent event, String location) {
      if (event.getButton() != MouseEvent.BUTTON1) {
         return;
      }

      JMenuItem menuItem = (JMenuItem) event.getSource();
      JPopupMenu popupMenu = (JPopupMenu) menuItem.getParent();
      JLabel label = (JLabel) popupMenu.getInvoker();
      JPanel temp = (JPanel) label.getParent();
      JPanel temp2 = (JPanel) temp.getParent();
      MainWindow main = (MainWindow) temp2.getParent();
      CardLayout cards = main.getCardLayout();
      cards.show(main, location);
   }

   private void addPopup(JLabel menu, JPopupMenu popupMenu) {
      // Auto-generated method stub
   }
}
