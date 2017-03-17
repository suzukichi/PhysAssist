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
  //public TopicPage topicController;
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
	  view.add(categoryList, "categories");
	  topicList = new guis.Topics();
	  view.add(topicList, "topics");
   }

   public void updateCategoryList(){
	   String[] buttons = {"N/A", "N/A", "N/A"};
	   parentID = 0;
	   topics = Lists.getTopicList(parentID);
	   for(int i = catCursor; i < topics.size() && i < 3; i++)
		   buttons[i] = topics.get(i).getTitle();
	   categoryList.updateButtons(buttons);
   }
   
   public void initCatPage(){
	   catCursor = 0;
	   updateCategoryList();
   }
   
   public void initTopicPage(){
	   catCursor = 0;
   }

   public void updateTopicList(){
	   parentID = 0;
	   Lists.getTopicList(parentID);
   }
}
