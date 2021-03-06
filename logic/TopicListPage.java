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
  private boolean testMode = false;
  
  public TopicListPage(){
	  // empty
  }
  
  public TopicListPage(MainWindow view){
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

   public int updateCategoryList(){
	   String[] buttons = {"N/A", "N/A", "N/A"};
	   String[] ids = {"","",""};
	   parentID = 0;
	   int iterator=0;
	   if(!testMode){
		   topics = Lists.getTopicList(parentID);
	   }
	   // Loop tested in test/TestLoopTopicPageList.java
	   for(int i = catCursor; i < topics.size() && i < 3; i++) {
		   if(!testMode){
			   buttons[i] = topics.get(i).getTitle();
			   ids[i] = Long.toString(topics.get(i).getTopicID());
		   }
		   iterator++;
	   }
	   if(!testMode){
		   categoryList.updateButtons(buttons, ids);
	   }
	   return iterator;
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
	   String[] ids = {"","",""};
	   topics = Lists.getTopicList(parentID);
	   for(int i = topicCursor; i < topics.size() && i < 3; i++) {
		   buttons[i] = topics.get(i).getTitle();
		   ids[i] = Long.toString(topics.get(i).getTopicID());
	   }
	   topicList.updateButtons(buttons, ids);
   }
   public void setTopics(List<Topic> topics){
	   this.topics = topics;
   }
   public void setCatCursor(int i){
	   this.catCursor=i;
   }
   public void setTestMode(boolean mode){
	   this.testMode = mode;
   }
}
