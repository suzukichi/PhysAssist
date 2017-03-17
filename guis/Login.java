package guis;

import java.awt.CardLayout;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.UIManager;

@SuppressWarnings("serial")
public class Login extends Page {
	private JPanel bodyPanel;
	private JPanel formatPanel;
	private JTextField usernameField;
	private JPasswordField passwordField;
	private JButton loginButton;
	private JButton createButton;
	private transient logic.LoginPage controller;
	private JPanel textPanel;
	private JTextPane txtpnErrorInvalidUsername;
	private String buttonBackground = "Button.background";
	
	/**
	 * Create the panel.
	 */
	public Login() {
      this.locationName = "Login";
		this.createHeader();
		
		
		bodyPanel = new JPanel();
		GridBagLayout gblbodyPanel = new GridBagLayout();
		this.contentPanel.add(bodyPanel);
		bodyPanel.setLayout(gblbodyPanel);
		
		formatPanel = new JPanel();
		formatPanel.setLayout(new BoxLayout(formatPanel, BoxLayout.Y_AXIS));
		bodyPanel.add(formatPanel);
		
		this.createUsernamePanel();
		this.createPasswordPanel();
		this.createButtons();
		this.createErrorText();
	}
	

	private void createUsernamePanel() {
		JPanel usernamePanel = new JPanel();
		formatPanel.add(usernamePanel);
		
		JTextPane usernameText = new JTextPane();
		usernameText.setFocusable(false);
		usernamePanel.add(usernameText);
		usernameText.setText("Username: ");
		usernameText.setBackground(UIManager.getColor(buttonBackground));
		usernameText.setBounds(100, 86, 61, 20);
		
		usernameField = new JTextField();
		usernamePanel.add(usernameField);
		usernameField.setBounds(215, 86, 86, 20);
		usernameField.setColumns(10);
	}
	
	private void createPasswordPanel() {	
		JPanel passwordPanel = new JPanel();
		formatPanel.add(passwordPanel);

		JTextPane passwordText = new JTextPane();
		passwordText.setFocusable(false);
		passwordText.setText("Password: ");
		passwordText.setBounds(124, 104, 86, 20);
		passwordText.setBackground(UIManager.getColor(buttonBackground));
		passwordPanel.add(passwordText);

		passwordField = new JPasswordField();
		passwordField.setBounds(237, 104, 110, 20);
		passwordPanel.add(passwordField);
		passwordField.setColumns(10);
	}
	
	private void createButtons() {
		JPanel buttonsPanel = new JPanel();
		formatPanel.add(buttonsPanel);

		createButton = new JButton("Sign Up");
		createButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
            MainWindow main = getMainFromButton((JButton) e.getSource());
            CardLayout cards = main.getCardLayout();
            txtpnErrorInvalidUsername.setVisible(false);
            cards.show(main, "create_account");
			}
		});
		createButton.setBounds(237, 216, 89, 23);
		buttonsPanel.add(createButton);

		loginButton = new JButton("Login");
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login(e);
			}
		});
		loginButton.setBounds(258, 135, 89, 23);
		buttonsPanel.add(loginButton);
		
		
	}

	private void createErrorText() {
		textPanel = new JPanel();
		formatPanel.add(textPanel);
		
		txtpnErrorInvalidUsername = new JTextPane();
		txtpnErrorInvalidUsername.setForeground(StyleGuide.errorText);
		txtpnErrorInvalidUsername.setBackground(UIManager.getColor(buttonBackground));
		txtpnErrorInvalidUsername.setText("Error! Invalid username / password combination!");
		txtpnErrorInvalidUsername.setFocusable(false);
		txtpnErrorInvalidUsername.setVisible(false);
		textPanel.add(txtpnErrorInvalidUsername);
	}
	
	public void addController(logic.LoginPage controller) {
		this.controller = controller;
	}
	
	private MainWindow getMainFromButton(JButton button) {
		JPanel temp = (JPanel) button.getParent();
   		JPanel temp2 = (JPanel) temp.getParent();
   		JPanel temp3 = (JPanel) temp2.getParent();
   		JPanel temp4 = (JPanel) temp3.getParent();
   		JPanel temp5 = (JPanel) temp4.getParent();
   		return (MainWindow) temp5.getParent();
	}
	
	public void login(ActionEvent e){
		if (controller.verify(usernameField.getText(), new String(passwordField.getPassword())) == 1) {
			MainWindow main = getMainFromButton((JButton)e.getSource());
			CardLayout cards = main.getCardLayout();
	   		txtpnErrorInvalidUsername.setVisible(false);
	   		cards.show(main, "home");
		} else {
			txtpnErrorInvalidUsername.setVisible(true);
		}
			
	}
}
