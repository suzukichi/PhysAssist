package guis;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.UIManager;

public class Login extends Page {
	private JTextField usernameField;
	private JPasswordField passwordField;
	private JButton loginButton, createButton, forgotButton;
	private logic.LoginPage controller;
	
	/**
	 * Create the panel.
	 */
	public Login() {
      this.locationName = "Login";
		this.createHeader();
		// TODO: hide menu.
		
		this.createUsernamePanel();
		this.createPasswordPanel();
		this.createButtons();
	}

	private void createUsernamePanel() {
		JPanel usernamePanel = new JPanel();
		this.contentPanel.add(usernamePanel);

		JTextPane usernameText = new JTextPane();
		usernameText.setText("Username: ");
		usernameText.setBackground(UIManager.getColor("Button.background"));
		usernameText.setBounds(124, 61, 86, 20);
 		usernamePanel.add(usernameText);

		usernameField = new JTextField();
		usernameField.setBounds(237, 61, 110, 20);
		usernamePanel.add(usernameField);
		usernameField.setColumns(10);
	}
	
	private void createPasswordPanel() {	
		JPanel passwordPanel = new JPanel();
		this.contentPanel.add(passwordPanel);

		JTextPane passwordText = new JTextPane();
		passwordText.setText("Password: ");
		passwordText.setBounds(124, 104, 86, 20);
		passwordText.setBackground(UIManager.getColor("Button.background"));
		passwordPanel.add(passwordText);

		passwordField = new JPasswordField();
		passwordField.setBounds(237, 104, 110, 20);
		passwordPanel.add(passwordField);
		passwordField.setColumns(10);
	}
	
	private void createButtons() {
		JPanel buttonsPanel = new JPanel();
		this.contentPanel.add(buttonsPanel);

		createButton = new JButton("Sign Up");
		createButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		createButton.setBounds(237, 216, 89, 23);
		buttonsPanel.add(createButton);

		forgotButton = new JButton("Forgot Password?");
		forgotButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		forgotButton.setBounds(91, 216, 119, 23);
		buttonsPanel.add(forgotButton);

		loginButton = new JButton("Login");
		loginButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				login(e);
			}
		});
		loginButton.setBounds(258, 135, 89, 23);
		buttonsPanel.add(loginButton);
	}

	public void addController(logic.LoginPage controller) {
		this.controller = controller;
	}
	
	public void login(MouseEvent event){
		if (controller.verify(usernameField.getText(), new String(passwordField.getPassword())) == 1) {
			JPanel temp = (JPanel) ((JButton)event.getSource()).getParent();
   		 JPanel temp2 = (JPanel) temp.getParent();
   		 JPanel temp3 = (JPanel) temp2.getParent();
   		 MainWindow main = (MainWindow) temp3.getParent();
   		 CardLayout cards = main.getCardLayout();
   		 cards.show(main, "home");
		} else {
		   // TODO Show invalid username/password combo.
		}
			
	}
}
