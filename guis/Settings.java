package guis;

import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class Settings extends Page {
	private JTextField usernameField;
	private JTextField firstNameField;
	private JTextField lastNameField;
	private JTextField emailField;
	private JPasswordField passwordField;
	private JPasswordField passwordField1;
	private JPasswordField passwordField2;
	private JPanel bodyPanel;
	private JPanel formatPanel;
	private JTextPane userNameErrorText;
	private JTextPane passwordErrorText;
	private String username;
	private String email;
	
	private transient  logic.SettingsPage controller;

	/*
	 * Create the panel.
	 */
	public Settings() {
	   this.locationName = "Settings";
	   this.createHeader();
	   
	   bodyPanel = new JPanel();
	   GridBagLayout gblbodyPanel = new GridBagLayout();
	   gblbodyPanel.rowWeights = new double[]{0.0};
	   gblbodyPanel.columnWeights = new double[]{1.0};
	   this.contentPanel.add(bodyPanel);
	   bodyPanel.setLayout(gblbodyPanel);
	   
	   formatPanel = new JPanel();
	   formatPanel.setLayout(new BoxLayout(formatPanel, BoxLayout.Y_AXIS));
	   GridBagConstraints gbcformatPanel = new GridBagConstraints();
	   gbcformatPanel.insets = new Insets(0, 0, 5, 0);
	   gbcformatPanel.gridy = 0;
	   gbcformatPanel.gridx = 0;
	   bodyPanel.add(formatPanel, gbcformatPanel);
	   this.createUsernamePanel();
	   this.createPasswordPanel();
	   this.createNamePanel();
	   this.createEmailPanel();
	}
	
	private void createUsernamePanel() {	
		JPanel usernameWrap = new JPanel();
		usernameWrap.setBorder(new EmptyBorder(10, 0, 10, 0));
		usernameWrap.setBackground(StyleGuide.background2);
		formatPanel.add(usernameWrap);
		usernameWrap.setLayout(new BoxLayout(usernameWrap, BoxLayout.Y_AXIS));
		
		JPanel p1 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) p1.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		usernameWrap.add(p1);
		
		JTextPane usernameText = new JTextPane();
		usernameText.setFocusable(false);
		p1.add(usernameText);
		usernameText.setBackground(StyleGuide.background2);
		usernameText.setBorder(null);
		usernameText.setText("Username:        ");
		usernameText.setBounds(91, 30, 122, 20);
		
		usernameField = new JTextField();
		p1.add(usernameField);
		usernameField.setBounds(10, 30, 130, 20);
		usernameField.setColumns(20);
		
		JPanel p2 = new JPanel();
		FlowLayout flowLayout11 = (FlowLayout) p2.getLayout();
		flowLayout11.setAlignment(FlowLayout.RIGHT);
		usernameWrap.add(p2);
		
		JButton btnChangeUsername = new JButton("Change Username");
		p2.add(btnChangeUsername);
		btnChangeUsername.setBounds(83, 61, 130, 23);
		
		JPanel p3 = new JPanel();
		usernameWrap.add(p3);
		
		JTextPane userNameErrorText1 = new JTextPane();
		userNameErrorText1.setVisible(false);
		userNameErrorText1.setForeground(StyleGuide.errorText);
		userNameErrorText1.setBackground(StyleGuide.background2);
		userNameErrorText1.setText("Name in use!");
		userNameErrorText1.setFocusable(false);
		p3.add(userNameErrorText1);
	}
	
	private void createPasswordPanel() {
		JPanel passwordWrap = new JPanel();
		passwordWrap.setBorder(new EmptyBorder(10, 0, 10, 0));
		passwordWrap.setBackground(StyleGuide.background2);
		passwordWrap.setLayout(new BoxLayout(passwordWrap, BoxLayout.Y_AXIS));
		formatPanel.add(passwordWrap);
		
		JPanel p1 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) p1.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		passwordWrap.add(p1);
		JTextPane oldPassText = new JTextPane();
		oldPassText.setFocusable(false);
		oldPassText.setText("Enter Current Password:     ");
		oldPassText.setBorder(null);
		oldPassText.setBackground(SystemColor.menu);
		oldPassText.setBounds(91, 92, 122, 20);
		p1.add(oldPassText);


		passwordField = new JPasswordField();
		passwordField.setColumns(20);
		passwordField.setBounds(10, 88, 130, 20);
		p1.add(passwordField);
		
		
		JPanel p2 = new JPanel();
		FlowLayout flowLayout1 = (FlowLayout) p2.getLayout();
		flowLayout1.setAlignment(FlowLayout.RIGHT);
		passwordWrap.add(p2);
		JTextPane txtpnEnterNewPassword = new JTextPane();
		txtpnEnterNewPassword.setFocusable(false);
		txtpnEnterNewPassword.setText("Enter New Password:    ");
		txtpnEnterNewPassword.setBorder(null);
		txtpnEnterNewPassword.setBackground(SystemColor.menu);
		txtpnEnterNewPassword.setBounds(91, 123, 122, 20);
		p2.add(txtpnEnterNewPassword);
		
		passwordField1 = new JPasswordField();
		passwordField1.setColumns(20);
		passwordField1.setBounds(10, 150, 130, 20);
		p2.add(passwordField1);
		
		JPanel p3 = new JPanel();
		FlowLayout flowLayout2 = (FlowLayout) p3.getLayout();
		flowLayout2.setAlignment(FlowLayout.RIGHT);
		passwordWrap.add(p3);
		JTextPane txtpnReenterNewPassword = new JTextPane();
		txtpnReenterNewPassword.setFocusable(false);
		txtpnReenterNewPassword.setText("Re-enter Password:       ");
		txtpnReenterNewPassword.setBorder(null);
		txtpnReenterNewPassword.setBackground(SystemColor.menu);
		txtpnReenterNewPassword.setBounds(91, 154, 122, 20);
		p3.add(txtpnReenterNewPassword);

		passwordField2 = new JPasswordField();
		passwordField2.setColumns(20);
		passwordField2.setBounds(10, 150, 130, 20);
		p3.add(passwordField2);
		
		JPanel p4 = new JPanel();
		FlowLayout flowLayout3 = (FlowLayout) p4.getLayout();
		flowLayout3.setAlignment(FlowLayout.RIGHT);
		passwordWrap.add(p4);
		
		JButton btnChangePassword = new JButton("Change Password");
		p4.add(btnChangePassword);
		btnChangePassword.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnChangePassword.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnChangePassword.setBounds(83, 187, 130, 23);
		
		JPanel p5 = new JPanel();
		passwordErrorText = new JTextPane();
		passwordErrorText = new JTextPane();
		passwordErrorText.setForeground(StyleGuide.errorText);
		passwordErrorText.setBackground(StyleGuide.background2);
		passwordErrorText.setText("Error! Password Incorrect or duplicates do not match!");
		passwordErrorText.setFocusable(false);
		passwordErrorText.setVisible(false);
		p5.add(passwordErrorText);
		passwordWrap.add(p5);
	}
	
	private void createNamePanel() {
		JPanel nameWrap = new JPanel();
		nameWrap.setBorder(new EmptyBorder(10, 0, 10, 0));
		nameWrap.setBackground(StyleGuide.background2);
		formatPanel.add(nameWrap);
		nameWrap.setLayout(new BoxLayout(nameWrap, BoxLayout.Y_AXIS));
		
		JPanel p1 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) p1.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		JTextPane firstNameText = new JTextPane();
		firstNameText.setFocusable(false);
		firstNameText.setBackground(StyleGuide.background2);
		firstNameText.setBorder(null);
		firstNameText.setText("First Name: ");
		firstNameText.setBounds(91, 30, 122, 20);
		p1.add(firstNameText);
		nameWrap.add(p1);
		
		firstNameField = new JTextField();
		firstNameField.setBounds(10, 30, 130, 20);
		p1.add(firstNameField);
		firstNameField.setColumns(15);
		
		JPanel p2 = new JPanel();
		FlowLayout flowLayout1 = (FlowLayout) p2.getLayout();
		flowLayout1.setAlignment(FlowLayout.RIGHT);
		JTextPane lastNameText = new JTextPane();
		lastNameText.setFocusable(false);
		lastNameText.setBackground(StyleGuide.background2);
		lastNameText.setBorder(null);
		lastNameText.setText("Last Name: ");
		lastNameText.setBounds(91, 30, 122, 20);
		p2.add(lastNameText);
		nameWrap.add(p2);
		
		lastNameField = new JTextField();
		lastNameField.setBounds(10, 30, 130, 20);
		p2.add(lastNameField);
		lastNameField.setColumns(15);
		
		JPanel p3 = new JPanel();
		FlowLayout flp3 = (FlowLayout) p3.getLayout();
		flp3.setAlignment(FlowLayout.RIGHT);
		nameWrap.add(p3);
		
		JButton btnChangeName = new JButton("Edit Full Name");
		p3.add(btnChangeName);
		btnChangeName.setBounds(83, 61, 130, 23);
	}
	
	private void createEmailPanel() {	
		JPanel emailWrap = new JPanel();
		emailWrap.setBorder(new EmptyBorder(10, 0, 10, 0));
		emailWrap.setBackground(StyleGuide.background2);
		formatPanel.add(emailWrap);
		emailWrap.setLayout(new BoxLayout(emailWrap, BoxLayout.Y_AXIS));
		
		JPanel p1 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) p1.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		emailWrap.add(p1);
		
		JTextPane emailText = new JTextPane();
		emailText.setFocusable(false);
		p1.add(emailText);
		emailText.setBackground(StyleGuide.background2);
		emailText.setBorder(null);
		emailText.setText("Email:            ");
		emailText.setBounds(91, 30, 122, 20);
		
		emailField = new JTextField();
		p1.add(emailField);
		emailField.setBounds(10, 30, 130, 20);
		emailField.setColumns(20);
		
		JPanel p2 = new JPanel();
		FlowLayout flowLayout1 = (FlowLayout) p2.getLayout();
		flowLayout1.setAlignment(FlowLayout.RIGHT);
		emailWrap.add(p2);
		
		JButton btnChangeEmail = new JButton("Change Email");
		p2.add(btnChangeEmail);
		btnChangeEmail.setBounds(83, 61, 130, 23);
	}
	
	public void updateText(String username, String email) {
		this.usernameField.setText(username);
		this.emailField.setText(email);
		this.username = username;
		this.email = email;
	}
	
	public void addController(logic.SettingsPage controller) {
		this.controller = controller;
	}
	
	public void changeUsername() {
		if(!this.usernameField.getText().equals(username)) {
			int result = controller.editUsername(this.usernameField.getText());
			if (result >= 0)
				this.userNameErrorText.setVisible(false);
			else
				this.userNameErrorText.setVisible(true);
		}
	}
	
	public void changePassword() {
		if(this.passwordField1.equals(this.passwordField2))
		{
			this.passwordErrorText.setText("Error! Passwords don't match");
			this.passwordErrorText.setVisible(true);
		}
		int result = controller.editPassword(this.usernameField.getText());
		if(result >= 0) {
			this.passwordErrorText.setVisible(false);
		}
		else {
			this.passwordErrorText.setText("Incorrect Password!");
			this.passwordErrorText.setVisible(true);
		}
			
	}
	
	public void changeName() {
		controller.editName(this.firstNameField.getText(), this.lastNameField.getText());
	}
	
	public void changeEmail() {
		if(!this.emailField.getText().equals(email)) {
			int result = controller.editEmail(this.emailField.getText());
			if (result >= 0)
				this.userNameErrorText.setVisible(false);
			else
				this.userNameErrorText.setVisible(true);
		}
	}
}
