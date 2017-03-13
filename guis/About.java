package guis;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.UIManager;
import java.awt.SystemColor;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

public class About extends Page {
   protected String locationName = "About";

	/**
	 * Create the panel.
	 */
	public About() {
		this.createHeader();
		
		JLabel systemName = new JLabel("");
		ImageIcon systemNameIcon = new ImageIcon(Home.class.getResource("/images/titleIcon.png"));
		Image systemNameImage = systemNameIcon.getImage().getScaledInstance(450, 110, Image.SCALE_DEFAULT);
		systemNameIcon = new ImageIcon(systemNameImage);
		systemName.setIcon(systemNameIcon);
		contentPanel.add(systemName, BorderLayout.CENTER);

		String systemDescription = "PhysAssist is a comprehensive physics learning tool." + 
       " The purpose of this program is to help the user understand intricate lessons by" + 
       " minimizing time spent on browsing for explanations. The indexed equations also spare" + 
       " the user from having to repeatedly type in constants into their calculators which allows them to" + 
       " focus more time on understanding the concepts. The PhysAssist team is highly invested in the success" + 
       " of this program and will be working diligently to bring PhysAssist into fruition.";
		JTextArea systemDescriptionTextbox = new JTextArea(systemDescription);
		systemDescriptionTextbox.setLineWrap(true);
		systemDescriptionTextbox.setWrapStyleWord(true);
		systemDescriptionTextbox.setSize(new Dimension(500, 400));
		systemDescriptionTextbox.setPreferredSize(new Dimension(500, 400));
		systemDescriptionTextbox.setColumns(10);
		systemDescriptionTextbox.setRows(10);
		contentPanel.add(systemDescriptionTextbox);
	}
}
