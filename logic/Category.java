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
  public String title;
  
  public Category(long categoryID) {
    DB db = new DB();
    
    String q_getTopic = "SELECT tr.`topicid`, tr.`title`" +  
                       " FROM `topic_revisions` tr" + 
                       " JOIN `topics` t USING (`topicid`)" +
                       " WHERE `topicid` = ?" + 
                       " ORDER BY `revisionid` DESC" + 
                       " LIMIT 1";
   String[] p_getTopic = {DB.T_I, String.valueOf(categoryID)};
   HashMap<String, String> row = db.query(q_getTopic, p_getTopic).get(0);
   
   this.categoryID = categoryID;
   this.title = row.get("title");
  }
  
  public Category(long categoryID, String title) {
    this.categoryID = categoryID;
    this.title = title;
  }
  
  public String toString() {
    return "Category: " + Long.toString(this.categoryID) + ", " + this.title;
  }
  
}
