package guis;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

@SuppressWarnings("serial")
public class Reference extends Page {
	private JPanel bodyPanel;
	private JPanel formatPanel;
	
	
	/**
	 * Create the panel.
	 */
	public Reference() {
	   this.locationName = "Post";
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
	   this.createReferencePanel();
	}
	
	private void createReferencePanel() {
		JPanel postWrap = new JPanel();
		postWrap.setBorder(new EmptyBorder(10, 0, 10, 0));
		postWrap.setBackground(StyleGuide.background2);
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
