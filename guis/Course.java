package guis;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;

@SuppressWarnings("serial")
public class Course extends Page {
	private JButton item1Button; 
	private JButton item2Button;
	private JButton item3Button;
	private JLabel upButton;
	private JLabel downButton;
	private JPanel main;
	private JPanel p1;
	private JPanel p2;

	private JPanel bodyPanel;
	private JPanel formatPanel;
	String categoryTitle;
	Long courseID;
	private JPanel innerp1;
	private JPanel innerp2;
	private JPanel innerp3;
	
	public Course() {

	   this.locationName = this.categoryTitle;
	   this.createHeader();
	   
	   main = new JPanel();
	   this.contentPanel.add(main);
	   main.setLayout(new BorderLayout(0, 0));
	   
	   
	   bodyPanel = new JPanel();
	   GridBagLayout gblBodyPanel = new GridBagLayout();
	   gblBodyPanel.rowWeights = new double[]{0.0};
	   gblBodyPanel.columnWeights = new double[]{1.0};
	   main.add(bodyPanel);
	   bodyPanel.setLayout(gblBodyPanel);
	   
	   formatPanel = new JPanel();
	   formatPanel.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
	   formatPanel.setLayout(new BoxLayout(formatPanel, BoxLayout.Y_AXIS));
	   GridBagConstraints gbcFormatPanel = new GridBagConstraints();
	   gbcFormatPanel.insets = new Insets(0, 0, 5, 0);
	   gbcFormatPanel.gridy = 0;
	   gbcFormatPanel.gridx = 0;
	   bodyPanel.add(formatPanel, gbcFormatPanel);
	   
	   
	   this.createListPanel();
	   this.addButtons();
	}
	
	private void createListPanel() {
		
		innerp1 = new JPanel();
		formatPanel.add(innerp1);
		
		item1Button = new JButton("");
		item1Button.setPreferredSize(new Dimension(250, 25));
		innerp1.add(item1Button);
		item1Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		item1Button.setName("1");
		item1Button.setBounds(148, 38, 89, 23);
		
		innerp2 = new JPanel();
		formatPanel.add(innerp2);
		
		item2Button = new JButton("");
		item2Button.setPreferredSize(new Dimension(250, 25));
		innerp2.add(item2Button);
		item2Button.setToolTipText("");
		item2Button.setName("2");
		item2Button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				event.getSource();
			}
		});
		item2Button.setBounds(148, 100, 89, 23);
		
		innerp3 = new JPanel();
		formatPanel.add(innerp3);
		
		item3Button = new JButton("");
		item3Button.setPreferredSize(new Dimension(250, 25));
		innerp3.add(item3Button);
		item3Button.setName("3");
		item3Button.setBounds(148, 159, 89, 23);
	}
	
	private void addButtons() {
		p1 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) p1.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		main.add(p1, BorderLayout.NORTH);
		upButton = new JLabel("");
		upButton.setBounds(394, 0, 56, 56);
		upButton.setToolTipText("Up");
		upButton.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		ImageIcon icon = new ImageIcon(Home.class.getResource("/images/upIcon.png"));
		Image image = icon.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
		icon = new ImageIcon(image);
		upButton.setIcon(icon);
		p1.add(upButton);
		
		p2 = new JPanel();
		flowLayout = (FlowLayout) p2.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
	    main.add(p2, BorderLayout.SOUTH);
		downButton = new JLabel("");
		downButton.setBounds(394, 188, 56, 56);
		
		downButton.setToolTipText("Down");
		downButton.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		ImageIcon icon2 = new ImageIcon(Home.class.getResource("/images/downIcon.png"));
		Image image2 = icon2.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
		icon2 = new ImageIcon(image2);
		downButton.setIcon(icon2);
		p2.add(downButton);
	}


	public void updateButtons(String[] titles){
		item1Button.setText(titles[0]);
		item2Button.setText(titles[1]);
		item3Button.setText(titles[2]);
	}
}
