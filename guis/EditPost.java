package guis;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

@SuppressWarnings("serial")
public class EditPost extends Page {

	JPanel usernamePanel; 
	private JTextField titleField;
	private JPanel bodyPanel;
	private JPanel formatPanel;
	
	/**
	 * Create the panel.
	 */
	public EditPost() {
	   this.locationName = "Edit Post";
	   this.createHeader();
	   
	   bodyPanel = new JPanel();
	   GridBagLayout gblbodyPanel = new GridBagLayout();
	   this.contentPanel.add(bodyPanel);
	   bodyPanel.setLayout(gblbodyPanel);
	   
	   formatPanel = new JPanel();
	   formatPanel.setLayout(new BoxLayout(formatPanel, BoxLayout.Y_AXIS));
	   GridBagConstraints gbcformatPanel = new GridBagConstraints();
	   gbcformatPanel.gridx = 0;
	   bodyPanel.add(formatPanel, gbcformatPanel);
	   this.createPostPanel();
	}
	
	private void createPostPanel() {
		JPanel postWrap = new JPanel();
		postWrap.setBorder(new EmptyBorder(10, 0, 10, 0));
		postWrap.setBackground(StyleGuide.background2);
		formatPanel.add(postWrap);
		postWrap.setLayout(new BoxLayout(postWrap, BoxLayout.Y_AXIS));
		
		JPanel p1 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) p1.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		JTextPane titleText = new JTextPane();
		titleText.setFocusable(false);
		p1.add(titleText);
		titleText.setBackground(StyleGuide.background2);
		titleText.setText("Title:  ");
		titleText.setBounds(91, 30, 122, 20);
		
		titleField = new JTextField();
		p1.add(titleField);
		titleField.setBounds(10, 30, 130, 20);
		titleField.setColumns(15);
		postWrap.add(p1);
		
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
		
		JPanel p3 = new JPanel();
		flowLayout = (FlowLayout) p3.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		postWrap.add(p3);
		
		JButton btnCreate = new JButton("Create Post");
		p3.add(btnCreate);
		btnCreate.setBounds(83, 61, 130, 23);
	}
}
