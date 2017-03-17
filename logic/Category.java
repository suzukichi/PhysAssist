package logic;

import java.util.HashMap;

/*
 * Category.java
 * 
 * Category. Like a Topic, but merely represents a list of Topics.
 * 
 * @author Daniel Sabsay
 * Created March 13, 2017
 */

public class Category {
  private long categoryID;
  private String title;
  
  public Category(long categoryID) {
    DB db = DB.getInstance();
    
    String qgetTopic = "SELECT tr.`topicid`, tr.`title`" +  
                       " FROM `topic_revisions` tr" + 
                       " JOIN `topics` t USING (`topicid`)" +
                       " WHERE `topicid` = ?" + 
                       " ORDER BY `revisionid` DESC" + 
                       " LIMIT 1";
   String[] pgetTopic = {DB.T_I, String.valueOf(categoryID)};
   HashMap<String, String> row = db.query(qgetTopic, pgetTopic).get(0);
   
   this.categoryID = categoryID;
   this.title = row.get("title");
  }
  
  public Category(long categoryID, String title) {
    this.categoryID = categoryID;
    this.title = title;
  }
  
  @Override
  public String toString() {
    return "Category: " + Long.toString(this.categoryID) + ", " + this.title;
  }
  
}
