package guis;

import java.awt.Image;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;

import logic.DB;
import logic.Topic;

public class Topics extends Page{
   // what
	private JTextField txtPepe;
	private HashMap<String, Long> buttons;
	private JButton item1Button, item2Button, item3Button;
	private JLabel upButton, downButton;

	List topics;
	String categoryTitle;
	Long parentID;
	
	public Topics() {
	   if (this.parentID > 0) {
	      Topic parent = new Topic(this.parentID);
	      this.categoryTitle = parent.title;
	   } else {
	      this.categoryTitle = "Topics";
	   }

	   // TODO: replace this with the category name
	   topics = this.getTopics();
	   this.locationName = this.categoryTitle;
	   this.createHeader();
		
		upButton = new JLabel("");
		upButton.setBounds(394, 0, 56, 56);
		upButton.setToolTipText("Up");
		upButton.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		ImageIcon icon = new ImageIcon(Home.class.getResource("/images/upIcon.png"));
		Image image = icon.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
		icon = new ImageIcon(image);
		upButton.setIcon(icon);
		this.contentPanel.add(upButton);
		
		downButton = new JLabel("");
		downButton.setBounds(394, 188, 56, 56);
		
		downButton.setToolTipText("Down");
		downButton.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		ImageIcon icon2 = new ImageIcon(Home.class.getResource("/images/downIcon.png"));
		Image image2 = icon2.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
		icon2 = new ImageIcon(image2);
		downButton.setIcon(icon2);
		this.contentPanel.add(downButton);
		
		item1Button = new JButton("");
		item1Button.setBounds(148, 38, 89, 23);
		this.contentPanel.add(item1Button);
		
		item2Button = new JButton("");
		item2Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		item2Button.setBounds(148, 100, 89, 23);
		this.contentPanel.add(item2Button);
		
		item3Button = new JButton("");
		item3Button.setBounds(148, 159, 89, 23);
		this.contentPanel.add(item3Button);
		
		buttons = new HashMap<String, Long>();
	}
	
	private List getTopics() {
	   List ts = new List();
	   DB db = new DB();

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
	}
	

	public void updateButtons(String[] titles, int index){
		item1Button.setText(titles[0]);
		item2Button.setText(titles[1]);
		item3Button.setText(titles[2]);
	}
	/**public void addTopicController(logic.CategoryList controller) {
		item1Button.addMouseListener(controller);
		item2Button.addMouseListener(controller);
		item3Button.addMouseListener(controller);
	}
	
	public void addUpDownController(logic.TopicList controller) {
		//upButton.addMouseListener(controller);
		//downButton.addMouseListener(controller);
	}
*/
}
