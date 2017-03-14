package guis;

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

public class Settings extends Page {
	private JTextField usernameField;
	private JPasswordField passwordField;
	private JPasswordField passwordField1;
	private JPasswordField passwordField2;

	/**
	 * Create the panel.
	 */
	public Settings() {
	   this.locationName = "Settings";
	   this.createHeader();
		
	   this.createUsernamePanel();
	   this.createPasswordPanel();
	}
	
	private void createUsernamePanel() {	
		JPanel usernameWrap = new JPanel();
		usernameWrap.setBackground(StyleGuide.contentBackground);
		this.contentPanel.add(usernameWrap);

		JTextPane usernameText = new JTextPane();
		usernameText.setBackground(UIManager.getColor("Button.background"));
		usernameText.setBorder(null);
		usernameText.setText("Username");
		usernameText.setBounds(91, 30, 122, 20);
		usernameWrap.add(usernameText);
		
		usernameField = new JTextField();
		usernameField.setBounds(10, 30, 130, 20);
		usernameWrap.add(usernameField);
		usernameField.setColumns(10);
		
		JButton btnChangeUsername = new JButton("Change Username");
		btnChangeUsername.setBounds(83, 61, 130, 23);
		usernameWrap.add(btnChangeUsername);
	}
	
	private void createPasswordPanel() {
		JPanel passwordWrap = new JPanel();
		passwordWrap.setBackground(StyleGuide.contentBackground);
		passwordWrap.setLayout(new BoxLayout(passwordWrap, BoxLayout.Y_AXIS));
		this.contentPanel.add(passwordWrap);
		
		JPanel p1 = new JPanel();
		passwordWrap.add(p1);
		JTextPane oldPassText = new JTextPane();
		oldPassText.setText("Enter Current Password: ");
		oldPassText.setBorder(null);
		oldPassText.setBackground(SystemColor.menu);
		oldPassText.setBounds(91, 92, 122, 20);
		p1.add(oldPassText);


		passwordField = new JPasswordField();
		passwordField.setBounds(10, 88, 130, 20);
		p1.add(passwordField);
		
		
		JPanel p2 = new JPanel();
		passwordWrap.add(p2);
		JTextPane txtpnEnterNewPassword = new JTextPane();
		txtpnEnterNewPassword.setText("Enter New Password: ");
		txtpnEnterNewPassword.setBorder(null);
		txtpnEnterNewPassword.setBackground(SystemColor.menu);
		txtpnEnterNewPassword.setBounds(91, 123, 122, 20);
		p2.add(txtpnEnterNewPassword);
		
		passwordField1 = new JPasswordField();
		passwordField1.setBounds(10, 150, 130, 20);
		p2.add(passwordField1);
		
		JPanel p3 = new JPanel();
		passwordWrap.add(p3);
		JTextPane txtpnReenterNewPassword = new JTextPane();
		txtpnReenterNewPassword.setText("Re-enter Password: ");
		txtpnReenterNewPassword.setBorder(null);
		txtpnReenterNewPassword.setBackground(SystemColor.menu);
		txtpnReenterNewPassword.setBounds(91, 154, 122, 20);
		p3.add(txtpnReenterNewPassword);

		passwordField2 = new JPasswordField();
		passwordField2.setBounds(10, 150, 130, 20);
		p3.add(passwordField2);

		JButton btnChangePassword = new JButton("Change Password");
		btnChangePassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnChangePassword.setBounds(83, 187, 130, 23);
		passwordWrap.add(btnChangePassword);
	}
}
