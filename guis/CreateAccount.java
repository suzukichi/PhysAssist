package guis;

import java.awt.CardLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
public class CreateAccount extends Page {
JPanel usernamePanel; 
private JTextField usernameField;
private JTextField firstNameField;
private JTextField lastNameField;
private JTextField emailField;
private JPasswordField passwordField;
private JPasswordField passwordField1;
private JPasswordField passwordField2;
public JPanel bodyPanel;
public JPanel formatPanel;
public JTextPane userNameErrorText;
public JTextPane emailErrorText;

public logic.LoginPage controller;

	public CreateAccount() {
		
	   this.locationName = "Sign Up";
	   this.createHeader();
	   
	   bodyPanel = new JPanel();
	   GridBagLayout gbl_bodyPanel = new GridBagLayout();
	   this.contentPanel.add(bodyPanel);
	   bodyPanel.setLayout(gbl_bodyPanel);
	   
	   formatPanel = new JPanel();
	   formatPanel.setLayout(new BoxLayout(formatPanel, BoxLayout.Y_AXIS));
	   GridBagConstraints gbc_formatPanel = new GridBagConstraints();
	   gbc_formatPanel.gridx = 0;
	   bodyPanel.add(formatPanel, gbc_formatPanel);
	   this.createAccountPanel();
	}
	
	private void createAccountPanel() {
		JPanel p1 = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) p1.getLayout();
		flowLayout_2.setAlignment(FlowLayout.RIGHT);
		JTextPane usernameText = new JTextPane();
		usernameText.setFocusable(false);
		p1.add(usernameText);
		usernameText.setBackground(UIManager.getColor("Button.background"));
		usernameText.setBorder(null);
		usernameText.setText("Username:  ");
		usernameText.setBounds(91, 30, 122, 20);
		
		usernameField = new JTextField();
		p1.add(usernameField);
		usernameField.setBounds(10, 30, 130, 20);
		usernameField.setColumns(20);
		formatPanel.add(p1);
		
		JPanel p2 = new JPanel();
		
		userNameErrorText = new JTextPane();
		userNameErrorText.setVisible(false);
		userNameErrorText.setForeground(StyleGuide.errorText);
		userNameErrorText.setBackground(UIManager.getColor("Button.background"));
		userNameErrorText.setText("Name in use!");
		userNameErrorText.setFocusable(false);
		p2.add(userNameErrorText);
		formatPanel.add(p2);
		
		JPanel p3 = new JPanel();
		formatPanel.add(p3);
		FlowLayout flowLayout = (FlowLayout) p3.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		JTextPane passwordText = new JTextPane();
		passwordText.setFocusable(false);
		passwordText.setText("Password:  ");
		passwordText.setBorder(null);
		passwordText.setBackground(SystemColor.menu);
		passwordText.setBounds(91, 92, 122, 20);
		p3.add(passwordText);
		
		passwordField = new JPasswordField();
		passwordField.setColumns(20);
		passwordField.setBounds(10, 88, 130, 20);
		p3.add(passwordField);
		
		JPanel reEnterPanel = new JPanel();
		formatPanel.add(reEnterPanel);
		flowLayout = (FlowLayout) reEnterPanel.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		JTextPane password2Text = new JTextPane();
		password2Text.setFocusable(false);
		password2Text.setText("Re-enter:  ");
		password2Text.setBorder(null);
		password2Text.setBackground(SystemColor.menu);
		password2Text.setBounds(91, 92, 122, 20);
		reEnterPanel.add(password2Text);
		
		passwordField1 = new JPasswordField();
		passwordField1.setColumns(20);
		passwordField1.setBounds(10, 88, 130, 20);
		reEnterPanel.add(passwordField1);
		
		JPanel p4 = new JPanel();
		flowLayout = (FlowLayout) p4.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		formatPanel.add(p4);
		
		JTextPane emailText = new JTextPane();
		emailText.setFocusable(false);
		p4.add(emailText);
		emailText.setBackground(UIManager.getColor("Button.background"));
		emailText.setBorder(null);
		emailText.setText("Email:            ");
		emailText.setBounds(91, 30, 122, 20);
		
		emailField = new JTextField();
		p4.add(emailField);
		emailField.setBounds(10, 30, 130, 20);
		emailField.setColumns(20);
		
		JPanel emailErrorPanel = new JPanel();
		formatPanel.add(emailErrorPanel);
		emailErrorText = new JTextPane();
		emailErrorText.setVisible(false);
		emailErrorText.setForeground(StyleGuide.errorText);
		emailErrorText.setBackground(UIManager.getColor("Button.background"));
		emailErrorText.setText("Email in use!");
		emailErrorText.setFocusable(false);
		emailErrorPanel.add(emailErrorText);
		
		JPanel p5 = new JPanel();
		flowLayout = (FlowLayout) p5.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		JTextPane firstNameText = new JTextPane();
		firstNameText.setFocusable(false);
		firstNameText.setBackground(UIManager.getColor("Button.background"));
		firstNameText.setBorder(null);
		firstNameText.setText("First Name: ");
		firstNameText.setBounds(91, 30, 122, 20);
		p5.add(firstNameText);
		formatPanel.add(p5);
		
		firstNameField = new JTextField();
		firstNameField.setBounds(10, 30, 130, 20);
		p5.add(firstNameField);
		firstNameField.setColumns(15);
		
		JPanel p6 = new JPanel();
		flowLayout = (FlowLayout) p6.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		JTextPane lastNameText = new JTextPane();
		lastNameText.setFocusable(false);
		lastNameText.setBackground(UIManager.getColor("Button.background"));
		lastNameText.setBorder(null);
		lastNameText.setText("Last Name: ");
		lastNameText.setBounds(91, 30, 122, 20);
		p6.add(lastNameText);
		formatPanel.add(p6);
		
		lastNameField = new JTextField();
		lastNameField.setBounds(10, 30, 130, 20);
		p6.add(lastNameField);
		lastNameField.setColumns(15);
		
		JPanel p7 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) p7.getLayout();
		flowLayout_1.setAlignment(FlowLayout.RIGHT);
		formatPanel.add(p7);
		
		JButton btnCreate = new JButton("Create Account");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				validate();
				
			}
		});
		p7.add(btnCreate);
		btnCreate.setBounds(83, 61, 130, 23);
	}
	
	private MainWindow getMainFromButton(JButton button) {
		JPanel temp = (JPanel) button.getParent();
   		JPanel temp2 = (JPanel) temp.getParent();
   		JPanel temp3 = (JPanel) temp2.getParent();
   		JPanel temp4 = (JPanel) temp3.getParent();
   		JPanel temp5 = (JPanel) temp4.getParent();
   		return (MainWindow) temp5.getParent();
	}
	
	public void addController(logic.LoginPage controller) {
		this.controller = controller;
	}
	
	public void validate(ActionEvent arg0) {
		int result = controller.validate(usernameField.getText(), firstNameField.getText(), lastNameField.getText(),
											new String(passwordField.getPassword()), emailField.getText());
		if(result == -1) {
			userNameErrorText.setVisible(true);
			emailErrorText.setVisible(false);
		}
		else if(result == -2) {
			userNameErrorText.setVisible(false);
			emailErrorText.setVisible(true);
		}
		else {
			userNameErrorText.setVisible(false);
			emailErrorText.setVisible(false);
			MainWindow main = getMainFromButton((JButton)arg0.getSource());
			CardLayout cards = main.getCardLayout();
	   		cards.show(main, "home");
		}
	}
}
