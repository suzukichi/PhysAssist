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

   private Lists() {

   }

   /*
    * Fetches all Category objects from DB (all Topic objects with parentid ==
    * 0)
    */
   public static List<Category> getCategoryList() {
      List<Category> list = new ArrayList<>();
      DB db = DB.getInstance();
      long parentID = 0;

      String qGetTopicsForParent = "SELECT t.`topicid`, tr.`title` FROM `topics` t"
         + " JOIN `topic_revisions` tr USING (`topicid`)"
         + " WHERE `parentid` = ?" + " GROUP BY t.`topicid`"
         + " ORDER BY tr.`revisionid` DESC";
      String[] pGetTopicsForParent = { DB.T_I, String.valueOf(parentID) };

      List<HashMap<String, String>> rows = db.query(qGetTopicsForParent,
         pGetTopicsForParent);

      System.out.println(rows);

      for (HashMap<String, String> row : rows) {
         // list.add(new Category(Long.parseLong(row.get("topicid")),
         // row.get("title")));
         list.add(new Category(Long.parseLong(row.get("topicid"))));
      }

      System.out.println(list);

      return list;
   }

   /*
    * Fetches all Topic objects from the DB with the given parentID.
    * Effectively, this is the list of topics that belong to the Category c,
    * where c.topicID == parentID.
    */
   public static List<Topic> getTopicList(long parentID) {
      List<Topic> list = new ArrayList<>();
      DB db = DB.getInstance();

      String qGetTopicsForParent = "SELECT tr.`topicid`, tr.`title`, tr.`text`, tr.`authorid`,"
         + " tr.`revisionid`, t.`parentid`, t.`creation_time`"
         + " FROM `topic_revisions` tr" + " JOIN `topics` t USING (`topicid`)"
         + " WHERE t.`parentid` = ? " + " ORDER BY `title` DESC";
      String[] pGetTopicsForParent = { DB.T_I, String.valueOf(parentID) };

      List<HashMap<String, String>> rows = db.query(qGetTopicsForParent,
         pGetTopicsForParent);

      System.out.println(rows);

      for (HashMap<String, String> row : rows) {
         list.add(new Topic(Long.parseLong(row.get("topicid")), parentID,
            row.get("title"), row.get("text"),
            Long.parseLong(row.get("authorid")),
            Long.parseLong(row.get("revisionid")),
            Long.parseLong(row.get("creation_time"))));
      }

      System.out.println(list);

      return list;
   }

   // TODO
   /*
    * Returns a list of Equation objects from the DB with the given topicID.
    */
   public static List<Equation> getEquationList(long topicID) {
      List<Equation> list = new ArrayList<>();
      DB db = DB.getInstance();

      // TODO Get "name" for all equations with given topicid
      String qGetEquationsForTopic = "SELECT `equationid` FROM `equations` " +
                                     " WHERE `topicid` = ?";

      String[] pGetEquationsForTopic = {DB.T_I, String.valueOf(topicID)};

      List<HashMap<String, String>> rows = db.query(qGetEquationsForTopic, pGetEquationsForTopic);

      for (HashMap<String, String> row : rows) {
         list.add(new Equation(Long.parseLong(row.get("equationid"))));
      }

      System.out.println(list);

      return list;
   }

   public static void main(String[] args) {
      System.out.println("get category list");
      Lists.getCategoryList();

      System.out.println("\nget topic list");
      Lists.getTopicList(1);

      System.out.println("\nget equation list");
      Lists.getEquationList(1);

      // makePost();

      /*
       * String q_getPost = "SELECT * FROM `posts` " + " WHERE `postid` = ?";
       * String[] p_getPost = {DB.T_I, String.valueOf(1)};
       * 
       * ArrayList<HashMap<String, String>> rows =
       * (DB.getInstance()).query(q_getPost, p_getPost); if (rows.size() == 0) {
       * // Throw exception or something is probably better to do.
       * System.out.println("no posts"); return; }
       * 
       * System.out.println(rows);
       */
   }
}
