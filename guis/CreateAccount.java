package guis;

import java.awt.CardLayout;
import java.awt.Color;
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
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
@SuppressWarnings("serial")
public class CreateAccount extends Page {
	JPanel usernamePanel; 
	private JTextField usernameField;
	private JTextField firstNameField;
	private JTextField lastNameField;
	private JTextField emailField;
	private JPasswordField passwordField;
	private JPasswordField passwordField1;
	private JPanel bodyPanel;
	private JPanel formatPanel;
	private JTextPane userNameErrorText;
	private JTextPane emailErrorText;
	
	private transient logic.LoginPage controller;

	public CreateAccount() {
		
	   this.locationName = "Sign Up";
	   this.createHeader();
	   
	   
	   bodyPanel = new JPanel();
	   this.contentPanel.add(bodyPanel);
	   GridBagLayout gblBodyPanel = new GridBagLayout();
	   gblBodyPanel.rowWeights = new double[]{0.0};
	   gblBodyPanel.columnWeights = new double[]{1.0};
	   bodyPanel.setLayout(gblBodyPanel);
	   
	   formatPanel = new JPanel();
	   formatPanel.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
	   formatPanel.setLayout(new BoxLayout(formatPanel, BoxLayout.Y_AXIS));
	   GridBagConstraints gbcFormatPanel = new GridBagConstraints();
	   gbcFormatPanel.insets = new Insets(0, 0, 5, 0);
	   gbcFormatPanel.gridy = 0;
	   gbcFormatPanel.gridx = 0;
	   bodyPanel.add(formatPanel, gbcFormatPanel);
	   this.createAccountPanel();
	}
	
	private void createAccountPanel() {
		JPanel p1 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) p1.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
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
		userNameErrorText.setBackground(StyleGuide.background2);
		userNameErrorText.setText("Name in use!");
		userNameErrorText.setFocusable(false);
		p2.add(userNameErrorText);
		formatPanel.add(p2);
		
		JPanel p3 = new JPanel();
		formatPanel.add(p3);
		FlowLayout flowLayout1 = (FlowLayout) p3.getLayout();
		flowLayout1.setAlignment(FlowLayout.RIGHT);
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
		flowLayout1 = (FlowLayout) reEnterPanel.getLayout();
		flowLayout1.setAlignment(FlowLayout.RIGHT);
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
		flowLayout1 = (FlowLayout) p4.getLayout();
		flowLayout1.setAlignment(FlowLayout.RIGHT);
		formatPanel.add(p4);
		
		JTextPane emailText = new JTextPane();
		emailText.setFocusable(false);
		p4.add(emailText);
		emailText.setBackground(UIManager.getColor(StyleGuide.background2));
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
		emailErrorText.setBackground(UIManager.getColor(StyleGuide.background2));
		emailErrorText.setText("Email in use!");
		emailErrorText.setFocusable(false);
		emailErrorPanel.add(emailErrorText);
		
		JPanel p5 = new JPanel();
		flowLayout1 = (FlowLayout) p5.getLayout();
		flowLayout1.setAlignment(FlowLayout.RIGHT);
		JTextPane firstNameText = new JTextPane();
		firstNameText.setFocusable(false);
		firstNameText.setBackground(UIManager.getColor(StyleGuide.background2));
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
		flowLayout1 = (FlowLayout) p6.getLayout();
		flowLayout1.setAlignment(FlowLayout.RIGHT);
		JTextPane lastNameText = new JTextPane();
		lastNameText.setFocusable(false);
		lastNameText.setBackground(UIManager.getColor(StyleGuide.background2));
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
		FlowLayout flowLayout2 = (FlowLayout) p7.getLayout();
		flowLayout2.setAlignment(FlowLayout.RIGHT);
		formatPanel.add(p7);
		
		JButton btnCreate = new JButton("Create Account");
		btnCreate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				validate(e);
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
