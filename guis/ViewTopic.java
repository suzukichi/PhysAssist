package guis;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.util.HashMap;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class ViewTopic extends Page {
	public JPanel bodyPanel;
	public JPanel formatPanel;
	private String categoryTitle;
	private Long topicID;
	private Long equationID;
	private JPanel innerp1;
	private JPanel innerp2;
	private JLabel referenceButton;
	private JLabel equationsButton;
	/**
	 * Create the panel.
	 */
	public ViewTopic() {
	   this.locationName = "Topic";
	   this.createHeader();
	   
	   this.equationID = (long) -1;
	   if (this.equationID >= 0) {
		      logic.Topic topic = new logic.Topic(this.topicID);
		      //this.locationName = topic.title;
	   } 
	   //courses = logic.Lists.getCourseList(userID);
	   
	   
	   bodyPanel = new JPanel();
	   GridBagLayout gblBodyPanel = new GridBagLayout();
	   gblBodyPanel.rowWeights = new double[]{0.0};
	   gblBodyPanel.columnWeights = new double[]{1.0};
	   bodyPanel.setLayout(gblBodyPanel);
	   
	   formatPanel = new JPanel();
	   formatPanel.setBorder(null);
	   formatPanel.setLayout(new BoxLayout(formatPanel, BoxLayout.Y_AXIS));
	   GridBagConstraints gbcFormatPanel = new GridBagConstraints();
	   gbcFormatPanel.insets = new Insets(0, 0, 5, 0);
	   gbcFormatPanel.gridy = 0;
	   gbcFormatPanel.gridx = 0;
	   bodyPanel.add(formatPanel, gbcFormatPanel);
	   
	   
	   this.createListPanel();
	}
	
	private void createListPanel() {
		
		innerp1 = new JPanel();
		innerp1.setBorder(null);
		formatPanel.add(innerp1);
		
		referenceButton = new JLabel("");
		referenceButton.setToolTipText("Click to see Topic Info\r\n");
		ImageIcon refIcon = new ImageIcon(Home.class.getResource("/images/referenceIcon.png"));
		Image refImage = refIcon.getImage().getScaledInstance(400, 100, Image.SCALE_DEFAULT);
		refIcon = new ImageIcon(refImage);
		referenceButton.setIcon(refIcon);
		referenceButton.setBorder(new CompoundBorder(new EmptyBorder(10, 0, 10, 0), new LineBorder(new Color(0, 0, 0), 2, true)));
		innerp1.add(referenceButton);
		
		innerp2 = new JPanel();
		innerp2.setToolTipText("Click to see associated equations");
		innerp2.setBorder(null);
		formatPanel.add(innerp2);
		
		equationsButton = new JLabel("");
		ImageIcon eqIcon = new ImageIcon(Home.class.getResource("/images/equationIcon.png"));
		Image eqImage = eqIcon.getImage().getScaledInstance(400, 100, Image.SCALE_DEFAULT);
		eqIcon = new ImageIcon(eqImage);
		equationsButton.setIcon(eqIcon);
		equationsButton.setBorder(new CompoundBorder(new EmptyBorder(10, 0, 10, 0), new LineBorder(new Color(0, 0, 0), 2, true)));
		innerp2.add(equationsButton);
	}
}
