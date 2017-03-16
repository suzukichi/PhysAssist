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

  public guis.Topics categoryList;
  public guis.Topics topicList;
  public List<Topic> topics;
  public int catCursor;
  public int topicCursor;
  //public TopicPage topicController;
  public long parentID;
  
  
  
  public TopicListPage(MainWindow view){
	  //topicController = new TopicPage(view);
	  catCursor = 0;
	  topicCursor = 0;
	  initView(view);
  }
  
  
  
  public void display() {
    //update title
  }
  
   public void initView(MainWindow view){
	  categoryList = new guis.Topics();
	  view.add(categoryList, "categories");
   }

   public void updateCategoryList(){
	   String[] buttons = {"N/A", "N/A", "N/A"};
	   parentID = 0;
	   topics = Lists.getTopicList(parentID);
	   for(int i = catCursor; i < topics.size() && i < 3; i++)
		   buttons[i] = topics.get(i).title;
	   categoryList.updateButtons(buttons);
   }
   
   public void initCatPage(){
	   catCursor = 0;
   }
   
   public void initTopicPage(){
	   catCursor = 0;
   }

   public void updateTopicList(){
	   parentID = 0;
	   Lists.getTopicList(parentID);
   }
}
