package guis;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
public class CreateAccount extends Page {
JPanel usernamePanel; 
	public CreateAccount() {
	   this.locationName = "Sign Up";
	   this.createHeader();
	   
	   JPanel registrationPage = new JPanel();
	   this.contentPanel.add(registrationPage);
	   
	   usernamePanel = new JPanel();
	   registrationPage.add(usernamePanel);
	   usernamePanel.add(new JLabel("Choose a fun, family friendly username: "));

	   JPanel passwordPanel = new JPanel();
	   registrationPage.add(passwordPanel);
	   usernamePanel.add(new JLabel("Enter password: "));

	   JButton submit = new JButton("Register");
	   
	   JButton back = new JButton("");
	}

}
