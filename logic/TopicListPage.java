package logic;
/*
 * CategoryPage.java
 * 
 * 
 * 
 * @author Kyle Ringler
 * Created Feb 13, 2017
 */

import java.util.List;

import guis.MainWindow;

public class TopicListPage extends Page {

  private guis.Topics categoryList;
  private guis.Topics topicList;
  private List<Topic> topics;
  private int catCursor;
  private int topicCursor;
  private long parentID;
  
  
  
  public TopicListPage(MainWindow view){
	  //topicController = new TopicPage(view);
	  catCursor = 0;
	  topicCursor = 0;
	  initView(view);
  }
  
  
  @Override
  public void display() {
    //update title
  }
  
   public void initView(MainWindow view){
	  categoryList = new guis.Topics();
	  categoryList.addController(this);
	  view.add(categoryList, "categories");
	  
	  topicList = new guis.Topics();
	  view.add(topicList, "topics");
   }

   public void updateCategoryList(){
	   String[] buttons = {"N/A", "N/A", "N/A"};
	   String[] IDs = {"","",""};
	   parentID = 0;
	   topics = Lists.getTopicList(parentID);
	   for(int i = catCursor; i < topics.size() && i < 3; i++) {
		   buttons[i] = topics.get(i).getTitle();
		   IDs[i] = Long.toString(topics.get(i).getTopicID());
	   }
	   categoryList.updateButtons(buttons, IDs);
   }
   
   public void initCatPage(){
	   catCursor = 0;
	   updateCategoryList();
   }
   
   public void initTopicPage(long parentID){
	   this.parentID = parentID;
	   topicCursor = 0;
	   updateTopicList();
   }

   public void updateTopicList(){
	   String[] buttons = {"N/A", "N/A", "N/A"};
	   String[] IDs = {"","",""};
	   topics = Lists.getTopicList(parentID);
	   for(int i = topicCursor; i < topics.size() && i < 3; i++) {
		   buttons[i] = topics.get(i).getTitle();
		   IDs[i] = Long.toString(topics.get(i).getTopicID());
	   }
	   topicList.updateButtons(buttons, IDs);
   }
}
