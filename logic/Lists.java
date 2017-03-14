package logic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
 * Lists.java
 * 
 * Builds lists of categories, topics, equations and groups.
 * 
 * @author Daniel Sabsay
 * Created March 13, 2017
 */

public class Lists {
  /*
   * Fetches all Category objects from DB (all Topic objects with parentid == 0)
   */
  public List<Category> getCategoryList() {
    List<Category> list = new ArrayList<Category>();
    DB db = new DB();
    long parentID = 0;
    
    String qGetTopicsForParent = "SELECT t.`topicid`, tr.`title` FROM `topics` t" +
        " JOIN `topic_revisions` tr USING (`topicid`)" + 
        " WHERE `parentid` = ?" + 
        " GROUP BY t.`topicid`" + 
        " ORDER BY tr.`revisionid` DESC";
    String[] pGetTopicsForParent = {DB.T_I, String.valueOf(parentID)};

    ArrayList<HashMap<String, String>> rows = db.query(qGetTopicsForParent, pGetTopicsForParent);
    
    System.out.println(rows);
    
    for (HashMap<String, String> row : rows) {
      list.add(new Category(Long.parseLong(row.get("topicid")), row.get("title")));
    }
    
    System.out.println(list);
    
    return list;
  }
  
  /*
   * Fetches all Topic objects from the DB with the given parentID.
   * Effectively, this is the list of topics that belong to the Category c, where c.topicID == parentID.
   */
  public List<Topic> getTopicList(long parentID) {
    List<Topic> list = new ArrayList<Topic>();
    DB db = new DB();
    
    String qGetTopicsForParent = "SELECT tr.`topicid`, tr.`title`, tr.`text`, tr.`authorid`," +
        " tr.`revisionid`, t.`parentid`, t.`creation_time`" +  
        " FROM `topic_revisions` tr" + 
        " JOIN `topics` t USING (`topicid`)" +
        " WHERE t.`parentid` = ? " +
        " ORDER BY `title` DESC";
    String[] pGetTopicsForParent = {DB.T_I, String.valueOf(parentID)};
    
    ArrayList<HashMap<String, String>> rows = db.query(qGetTopicsForParent, pGetTopicsForParent);
    
    System.out.println(rows);
    
    for (HashMap<String, String> row : rows) {
      list.add(new Topic(Long.parseLong(row.get("topicid")), parentID, row.get("title"),
          row.get("text"), Long.parseLong(row.get("authorid")), Long.parseLong(row.get("revisionid")),
          Long.parseLong(row.get("creation_time"))));
    }
    
    System.out.println(list);
    
    return list;
  }
  
  //TODO
  public List<Equation> getEquationList(long topicID) {
    List<Equation> list = new ArrayList<Equation>();
    DB db = new DB();
    
    /*
    String qGetEquationsForTopic = "SELECT t.`topicid`, tr.`title` FROM `topics` t" +
        " JOIN `topic_revisions` tr USING (`topicid`)" + 
        " WHERE `parentid` = ?" + 
        " GROUP BY t.`topicid`" + 
        " ORDER BY tr.`revisionid` DESC";
        */
    
    /*
    String qGetEquationsForTopic = "SELECT * FROM `equations` " + 
        " WHERE `parentID` = ?";
        */
    String qGetEquationsForTopic = "SELECT * FROM `equations` ";

    
    String[] pGetEquationsForTopic = {DB.T_I, String.valueOf(topicID)};

    ArrayList<HashMap<String, String>> rows = db.query(qGetEquationsForTopic, pGetEquationsForTopic);
    
    System.out.println(rows);
    
    return null;
  }
  
  //TODO
  public List<Course> getCourseList(long userID) {
    List<Course> list = new ArrayList<Course>();
    DB db = new DB();
    
    // get list of courseID's
    /*
    String qGetTopicsForParent = "SELECT t.`courseid` FROM `students` t" +
        " WHERE `userid` = ?";
        */

    String qGetTopicsForParent = "SELECT * FROM `students` t" +
        " WHERE `userid` = ?";
    
    String[] pGetTopicsForParent = {DB.T_I, String.valueOf(userID)};

    ArrayList<HashMap<String, String>> rows = db.query(qGetTopicsForParent, pGetTopicsForParent);
    
    System.out.println(rows);
    
    return null;
  }
  
  public static void main(String[] args) {
    Lists l = new Lists();
    l.getCourseList(1);
  }
}
