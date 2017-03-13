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
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.JFormattedTextField;
import javax.swing.JTextPane;
import javax.swing.JPasswordField;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JPanel {
	private JTextField usernameField;
	private JPasswordField passwordField;
	private JButton loginButton, createButton, forgotButton;
	private logic.LoginPage controller;
	
	/**
	 * Create the panel.
	 */
	public Login() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setSize(new Dimension(0, 50));
		panel.setBorder(new EmptyBorder(0, 0, 0, 0));
		panel.setBackground(new Color(255, 0, 0));
		add(panel, BorderLayout.NORTH);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(null);
		panel_1.setBackground(UIManager.getColor("Button.background"));
		add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		
		usernameField = new JTextField();
		usernameField.setBounds(237, 61, 110, 20);
		panel_1.add(usernameField);
		usernameField.setColumns(10);
		
		JTextPane usernameText = new JTextPane();
		usernameText.setText("Username: ");
		usernameText.setBackground(UIManager.getColor("Button.background"));
		usernameText.setBounds(124, 61, 86, 20);
		panel_1.add(usernameText);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(237, 104, 110, 20);
		panel_1.add(passwordField);
		
		loginButton = new JButton("Login");
		loginButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				login(e);
			}
		});
		loginButton.setBounds(258, 135, 89, 23);
		panel_1.add(loginButton);
		
		forgotButton = new JButton("Forgot Password?");
		forgotButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		forgotButton.setBounds(91, 216, 119, 23);
		panel_1.add(forgotButton);
		
		createButton = new JButton("Sign Up");
		createButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		createButton.setBounds(237, 216, 89, 23);
		panel_1.add(createButton);
		
		JTextPane passwordText = new JTextPane();
		passwordText.setText("Password: ");
		passwordText.setBackground(SystemColor.menu);
		passwordText.setBounds(124, 104, 86, 20);
		panel_1.add(passwordText);
		ImageIcon icon = new ImageIcon(Home.class.getResource("/images/leftIcon.png"));
		Image image = icon.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
		icon = new ImageIcon(image);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(StyleGuide.headerMain);
		panel.add(panel_2);
		
		JLabel header = new JLabel("Login");
		panel_2.add(header);
		header.setForeground(new Color(0, 0, 0));
		header.setBorder(new EmptyBorder(0, 125, 0, 127));
		header.setFont(new Font("DialogInput", Font.BOLD, 22));
		header.setBackground(new Color(0, 0, 0));
		
	}

	public void addController(logic.LoginPage controller) {
		this.controller = controller;
	}
	
	public void login(MouseEvent event){
		if(controller.verify(usernameField.getText(), new String(passwordField.getPassword())) == 1) {
			JPanel temp = (JPanel) ((JButton)event.getSource()).getParent();
   		 JPanel temp2 = (JPanel) temp.getParent();
   		 JPanel temp3 = (JPanel) temp2.getParent();
   		 MainWindow main = (MainWindow) temp3.getParent();
   		 CardLayout cards = main.getCardLayout();
   		 cards.show(main, "home");
		}
		else {
			
		}
			
	}
	
	private void addPopup(JLabel menu, JPopupMenu popupMenu) {
		// TODO Auto-generated method stub
		
	}
}
