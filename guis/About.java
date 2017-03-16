package guis;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class About extends Page {

	/**
	 * Create the panel.
	 */
	public About() {
      this.locationName = "About";
		this.createHeader();
		//Not working, possibly not needed?
		//this.createBackButton();
		
		JPanel panel = new JPanel();
		this.contentPanel.add(panel);
		
		JLabel systemName = new JLabel("");
		ImageIcon systemNameIcon = new ImageIcon(Home.class.getResource("/images/titleIcon.png"));
		Image systemNameImage = systemNameIcon.getImage().getScaledInstance(450, 110, Image.SCALE_DEFAULT);
		systemNameIcon = new ImageIcon(systemNameImage);
		systemName.setIcon(systemNameIcon);
		panel.add(systemName);

		String systemDescription = "PhysAssist is a comprehensive physics learning tool." + 
       " The purpose of this program is to help the user understand intricate lessons by" + 
       " minimizing time spent on browsing for explanations.\nThe indexed equations also spare" + 
       " the user from having to repeatedly type in constants into their calculators which allows them to" + 
       " focus more time on understanding the concepts.\nThe PhysAssist team is highly invested in the success" + 
       " of this program and will be working diligently to bring PhysAssist into fruition.";
		JTextArea systemDescriptionTextArea = new JTextArea(systemDescription);
		systemDescriptionTextArea.setLineWrap(true);
		systemDescriptionTextArea.setWrapStyleWord(true);
		systemDescriptionTextArea.setSize(new Dimension(500, 400));
		systemDescriptionTextArea.setPreferredSize(new Dimension(400, 300));
		systemDescriptionTextArea.setColumns(10);
		systemDescriptionTextArea.setRows(10);
		systemDescriptionTextArea.setBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0), 2, true), new EmptyBorder(5, 5, 5, 5)));

		panel.add(systemDescriptionTextArea);
	}
}
