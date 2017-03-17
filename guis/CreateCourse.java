package guis;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class CreateCourse extends Page {
	JPanel usernamePanel; 
	private JTextField titleField;
	private JPanel bodyPanel;
	private JPanel formatPanel;
	
	public CreateCourse() {
	   this.locationName = "Create Class";
	   this.createHeader();
	   bodyPanel = new JPanel();
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
	   this.createCoursePanel();
	}
	
	private void createCoursePanel() {
		JPanel courseWrap = new JPanel();
		courseWrap.setBorder(new EmptyBorder(10, 0, 10, 0));
		courseWrap.setBackground(UIManager.getColor("Button.background"));
		formatPanel.add(courseWrap);
		courseWrap.setLayout(new BoxLayout(courseWrap, BoxLayout.Y_AXIS));
		
		JPanel p1 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) p1.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		JTextPane titleText = new JTextPane();
		titleText.setFocusable(false);
		p1.add(titleText);
		titleText.setBackground(UIManager.getColor("Button.background"));
		titleText.setText("Course Name: ");
		titleText.setBounds(91, 30, 122, 20);
		
		titleField = new JTextField();
		p1.add(titleField);
		titleField.setBounds(10, 30, 130, 20);
		titleField.setColumns(15);
		courseWrap.add(p1);
		
		JPanel p2 = new JPanel();
		courseWrap.add(p2);
		
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
		courseWrap.add(p3);
		
		JButton btnCreate = new JButton("Create Course");
		p3.add(btnCreate);
		btnCreate.setBounds(83, 61, 130, 23);
	}
}
