package guis;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class Notification extends Page {

	JPanel usernamePanel; 
	private JTextField emailField;
	private JPasswordField passwordField;
	private JPasswordField passwordField1;
	private JPasswordField passwordField2;
	public JPanel bodyPanel;
	public JPanel formatPanel;
	
	public long postID;
	
	public transient logic.Post post;
	
	/**
	 * Create the panel.
	 */
	public Notification() {
	   this.locationName = "Post";
	   this.createHeader();
	   
	   post = new logic.Post(postID);
	   
	   bodyPanel = new JPanel();
	   GridBagLayout gbl_bodyPanel = new GridBagLayout();
	   this.contentPanel.add(bodyPanel);
	   bodyPanel.setLayout(gbl_bodyPanel);
	   
	   formatPanel = new JPanel();
	   formatPanel.setLayout(new BoxLayout(formatPanel, BoxLayout.Y_AXIS));
	   GridBagConstraints gbc_formatPanel = new GridBagConstraints();
	   gbc_formatPanel.gridx = 0;
	   bodyPanel.add(formatPanel, gbc_formatPanel);
	   this.createPostPanel();
	}
	
	private void createPostPanel() {
		JPanel postWrap = new JPanel();
		postWrap.setBorder(new EmptyBorder(10, 0, 10, 0));
		postWrap.setBackground(UIManager.getColor("Button.background"));
		formatPanel.add(postWrap);
		postWrap.setLayout(new BoxLayout(postWrap, BoxLayout.Y_AXIS));
		
		JPanel p2 = new JPanel();
		postWrap.add(p2);
		
		JTextArea descriptionText = new JTextArea();
		descriptionText.setLineWrap(true);
		descriptionText.setFont(new Font("DialogInput", Font.PLAIN, 13));
		descriptionText.setColumns(30);
		descriptionText.setRows(15);
		descriptionText.setWrapStyleWord(true);
		descriptionText.setBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0), 2, true), new EmptyBorder(5, 5, 5, 5)));
		p2.add(descriptionText);
	}
}
