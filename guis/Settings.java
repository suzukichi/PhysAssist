package guis;

import java.awt.GridBagLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import java.awt.Component;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class Settings extends Page {
	private JTextField usernameField;
	private JTextField firstNameField;
	private JTextField lastNameField;
	private JTextField emailField;
	private JPasswordField passwordField;
	private JPasswordField passwordField1;
	private JPasswordField passwordField2;
	public JPanel bodyPanel;
	public JPanel formatPanel;
	private JTextPane userNameErrorText;

	/**
	 * Create the panel.
	 */
	public Settings() {
	   this.locationName = "Settings";
	   this.createHeader();
	   
	   bodyPanel = new JPanel();
	   GridBagLayout gbl_bodyPanel = new GridBagLayout();
	   gbl_bodyPanel.rowWeights = new double[]{0.0};
	   gbl_bodyPanel.columnWeights = new double[]{1.0};
	   this.contentPanel.add(bodyPanel);
	   bodyPanel.setLayout(gbl_bodyPanel);
	   
	   formatPanel = new JPanel();
	   formatPanel.setLayout(new BoxLayout(formatPanel, BoxLayout.Y_AXIS));
	   GridBagConstraints gbc_formatPanel = new GridBagConstraints();
	   gbc_formatPanel.insets = new Insets(0, 0, 5, 0);
	   gbc_formatPanel.gridy = 0;
	   gbc_formatPanel.gridx = 0;
	   bodyPanel.add(formatPanel, gbc_formatPanel);
	   this.createUsernamePanel();
	   this.createPasswordPanel();
	   this.createNamePanel();
	   this.createEmailPanel();
	}
	
	private void createUsernamePanel() {	
		JPanel usernameWrap = new JPanel();
		usernameWrap.setBorder(new EmptyBorder(10, 0, 10, 0));
		usernameWrap.setBackground(UIManager.getColor("Button.background"));
		formatPanel.add(usernameWrap);
		usernameWrap.setLayout(new BoxLayout(usernameWrap, BoxLayout.Y_AXIS));
		
		JPanel p1 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) p1.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		usernameWrap.add(p1);
		
		JTextPane usernameText = new JTextPane();
		usernameText.setFocusable(false);
		p1.add(usernameText);
		usernameText.setBackground(UIManager.getColor("Button.background"));
		usernameText.setBorder(null);
		usernameText.setText("Username:        ");
		usernameText.setBounds(91, 30, 122, 20);
		
		usernameField = new JTextField();
		p1.add(usernameField);
		usernameField.setBounds(10, 30, 130, 20);
		usernameField.setColumns(20);
		
		JPanel p2 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) p2.getLayout();
		flowLayout_1.setAlignment(FlowLayout.RIGHT);
		usernameWrap.add(p2);
		
		JButton btnChangeUsername = new JButton("Change Username");
		p2.add(btnChangeUsername);
		btnChangeUsername.setBounds(83, 61, 130, 23);
		
		JPanel p3 = new JPanel();
		usernameWrap.add(p3);
		
		JTextPane userNameErrorText = new JTextPane();
		userNameErrorText.setVisible(false);
		userNameErrorText.setForeground(StyleGuide.errorText);
		userNameErrorText.setBackground(UIManager.getColor("Button.background"));
		userNameErrorText.setText("Name in use!");
		userNameErrorText.setFocusable(false);
		p3.add(userNameErrorText);
	}
	
	private void createPasswordPanel() {
		JPanel passwordWrap = new JPanel();
		passwordWrap.setBorder(new EmptyBorder(10, 0, 10, 0));
		passwordWrap.setBackground(UIManager.getColor("Button.background"));
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
		FlowLayout flowLayout_1 = (FlowLayout) p2.getLayout();
		flowLayout_1.setAlignment(FlowLayout.RIGHT);
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
		FlowLayout flowLayout_2 = (FlowLayout) p3.getLayout();
		flowLayout_2.setAlignment(FlowLayout.RIGHT);
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
		FlowLayout flowLayout_3 = (FlowLayout) p4.getLayout();
		flowLayout_3.setAlignment(FlowLayout.RIGHT);
		passwordWrap.add(p4);
		
		JButton btnChangePassword = new JButton("Change Password");
		p4.add(btnChangePassword);
		btnChangePassword.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnChangePassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnChangePassword.setBounds(83, 187, 130, 23);
		
		JPanel p5 = new JPanel();
		JTextPane passwordErrorText = new JTextPane();
		passwordErrorText = new JTextPane();
		passwordErrorText.setForeground(StyleGuide.errorText);
		passwordErrorText.setBackground(UIManager.getColor("Button.background"));
		passwordErrorText.setText("Error! Password Incorrect or duplicates do not match!");
		passwordErrorText.setFocusable(false);
		passwordErrorText.setVisible(false);
		p5.add(passwordErrorText);
		passwordWrap.add(p5);
	}
	
	private void createNamePanel() {
		JPanel nameWrap = new JPanel();
		nameWrap.setBorder(new EmptyBorder(10, 0, 10, 0));
		nameWrap.setBackground(UIManager.getColor("Button.background"));
		formatPanel.add(nameWrap);
		nameWrap.setLayout(new BoxLayout(nameWrap, BoxLayout.Y_AXIS));
		
		JPanel p1 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) p1.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		JTextPane firstNameText = new JTextPane();
		firstNameText.setFocusable(false);
		firstNameText.setBackground(UIManager.getColor("Button.background"));
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
		FlowLayout flowLayout_1 = (FlowLayout) p2.getLayout();
		flowLayout_1.setAlignment(FlowLayout.RIGHT);
		JTextPane lastNameText = new JTextPane();
		lastNameText.setFocusable(false);
		lastNameText.setBackground(UIManager.getColor("Button.background"));
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
		FlowLayout fl_p3 = (FlowLayout) p3.getLayout();
		fl_p3.setAlignment(FlowLayout.RIGHT);
		nameWrap.add(p3);
		
		JButton btnChangeName = new JButton("Edit Full Name");
		p3.add(btnChangeName);
		btnChangeName.setBounds(83, 61, 130, 23);
	}
	
	private void createEmailPanel() {	
		JPanel emailWrap = new JPanel();
		emailWrap.setBorder(new EmptyBorder(10, 0, 10, 0));
		emailWrap.setBackground(UIManager.getColor("Button.background"));
		formatPanel.add(emailWrap);
		emailWrap.setLayout(new BoxLayout(emailWrap, BoxLayout.Y_AXIS));
		
		JPanel p1 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) p1.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		emailWrap.add(p1);
		
		JTextPane emailText = new JTextPane();
		emailText.setFocusable(false);
		p1.add(emailText);
		emailText.setBackground(UIManager.getColor("Button.background"));
		emailText.setBorder(null);
		emailText.setText("Email:            ");
		emailText.setBounds(91, 30, 122, 20);
		
		emailField = new JTextField();
		p1.add(emailField);
		emailField.setBounds(10, 30, 130, 20);
		emailField.setColumns(20);
		
		JPanel p2 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) p2.getLayout();
		flowLayout_1.setAlignment(FlowLayout.RIGHT);
		emailWrap.add(p2);
		
		JButton btnChangeEmail = new JButton("Change Email");
		p2.add(btnChangeEmail);
		btnChangeEmail.setBounds(83, 61, 130, 23);
	}
}
