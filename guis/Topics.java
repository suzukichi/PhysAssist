package guis;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;

import logic.DB;
import logic.Topic;
import java.awt.Insets;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Dimension;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class Topics extends Page {
	private HashMap<String, Long> buttons;
	private JButton item1Button, item2Button, item3Button;
	private JLabel upButton, downButton;
	private JPanel main;
	private JPanel p1;
	private JPanel p2;

	public JPanel bodyPanel;
	public JPanel formatPanel;
	java.util.List<logic.Topic> topics;
	String categoryTitle;
	Long parentID;
	private JPanel innerp1;
	private JPanel innerp2;
	private JPanel innerp3;
	
	public Topics() {
	   if (this.parentID == null) {
	      this.parentID = 0L;
	   }
	   
	   if (this.parentID > 0) {
	      Topic parent = new Topic(this.parentID);
	      this.categoryTitle = parent.title;
	   } else {
	      this.categoryTitle = "Topics";
	   }

	   // TODO: replace this with the category name
	   //topics = logic.Lists.getTopicList(this.parentID);
	   this.locationName = this.categoryTitle;
	   this.createHeader();
	   
	   main = new JPanel();
	   this.contentPanel.add(main);
	   main.setLayout(new BorderLayout(0, 0));
	   
	   
	   bodyPanel = new JPanel();
	   GridBagLayout gbl_bodyPanel = new GridBagLayout();
	   gbl_bodyPanel.rowWeights = new double[]{0.0};
	   gbl_bodyPanel.columnWeights = new double[]{1.0};
	   main.add(bodyPanel);
	   bodyPanel.setLayout(gbl_bodyPanel);
	   
	   formatPanel = new JPanel();
	   formatPanel.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
	   formatPanel.setLayout(new BoxLayout(formatPanel, BoxLayout.Y_AXIS));
	   GridBagConstraints gbc_formatPanel = new GridBagConstraints();
	   gbc_formatPanel.insets = new Insets(0, 0, 5, 0);
	   gbc_formatPanel.gridy = 0;
	   gbc_formatPanel.gridx = 0;
	   bodyPanel.add(formatPanel, gbc_formatPanel);
	   
	   
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
			public void actionPerformed(ActionEvent e) {
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
		FlowLayout flowLayout_1 = (FlowLayout) p2.getLayout();
		flowLayout_1.setAlignment(FlowLayout.RIGHT);
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
	
	/**private List getTopics() {
	   List ts = new List();
	   DB db = DB.getInstance();

	   String qGetTopicsForParent = "SELECT t.`topicid`, tr.`title` FROM `topics` t" +
	                                " JOIN `topic_revisions` tr USING (`topicid`)" + 
	                                " WHERE `parentid` = ?" + 
	                                " GROUP BY t.`topicid`" + 
	                                " ORDER BY tr.`revisionid` DESC";
	   String[] pGetTopicsForParent = {DB.T_I, String.valueOf(this.parentID)};

	   ArrayList<HashMap<String, String>> rows = db.query(qGetTopicsForParent, pGetTopicsForParent);
	   if (rows.isEmpty()) {
	      // Say there are no topics under this category 
	   }
	   
	   return ts;
	}*/
	

	public void updateButtons(String[] titles){
		item1Button.setText(titles[0]);
		item2Button.setText(titles[1]);
		item3Button.setText(titles[2]);
	}
}
