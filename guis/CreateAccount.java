package guis;

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
		JPanel accountWrap = new JPanel();
		accountWrap.setBorder(new EmptyBorder(10, 0, 10, 0));
		accountWrap.setBackground(UIManager.getColor("Button.background"));
		formatPanel.add(accountWrap);
		accountWrap.setLayout(new BoxLayout(accountWrap, BoxLayout.Y_AXIS));
		
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
		accountWrap.add(p1);
		accountWrap.add(p1);
		
		JPanel p2 = new JPanel();
		
		JTextPane userNameErrorText = new JTextPane();
		userNameErrorText.setVisible(false);
		userNameErrorText.setForeground(StyleGuide.errorText);
		userNameErrorText.setBackground(UIManager.getColor("Button.background"));
		userNameErrorText.setText("Name in use!");
		userNameErrorText.setFocusable(false);
		p2.add(userNameErrorText);
		accountWrap.add(p2);
		
		JPanel p3 = new JPanel();
		accountWrap.add(p3);
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
		
		JPanel p4 = new JPanel();
		flowLayout = (FlowLayout) p4.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		accountWrap.add(p4);
		
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
		accountWrap.add(p5);
		
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
		accountWrap.add(p6);
		
		lastNameField = new JTextField();
		lastNameField.setBounds(10, 30, 130, 20);
		p6.add(lastNameField);
		lastNameField.setColumns(15);
		
		JPanel p7 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) p7.getLayout();
		flowLayout_1.setAlignment(FlowLayout.RIGHT);
		accountWrap.add(p7);
		
		JButton btnCreate = new JButton("Create Account");
		p7.add(btnCreate);
		btnCreate.setBounds(83, 61, 130, 23);
	}
}
