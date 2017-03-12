package logic;

import java.util.ArrayList;
import java.util.HashMap;

public class Topic {
	public long topicID;
	public String title, text;
	public long authorID, revisionID;
	public long parentTopicID;
	private long creationTime;
	
	public ArrayList<Equation> equations;
	public ArrayList<Quiz> quizzes;
	
	public Topic(long topicID) {
	   DB db = new DB();
	   
      String q_getTopic = "SELECT tr.`topicid`, tr.`title`, tr.`text`, tr.`authorid`, tr.`revisionid`," + 
                                " t.`parentid`, t.`creation_time`" +  
                          " FROM `topic_revisions` tr" + 
                          " JOIN `topics` t USING (`topicid`)" +
                          " WHERE `topicid` = ?" + 
                          " ORDER BY `revisionid` DESC" + 
                          " LIMIT 1";
      String[] p_getTopic = {DB.T_I, String.valueOf(topicID)};
      HashMap<String, String> row = db.query(q_getTopic, p_getTopic).get(0);
      
      this.topicID = topicID;
      this.title = row.get("title");
      this.text = row.get("text");
      this.authorID = Long.valueOf((row.get("authorid")));
      this.revisionID = Long.valueOf((row.get("revisionid")));
      this.parentTopicID = Long.valueOf((row.get("parentid")));
      this.creationTime = Long.valueOf((row.get("creation_time")));
     
      // TODO: create Equations.
		this.equations = new ArrayList<Equation>();
		this.quizzes = new ArrayList<Quiz>();
	}
	
	public Topic(String title, String text) throws IllegalArgumentException {
		if (title.length() < 1) {
			throw new IllegalArgumentException("Topic titles must be more than one character long.");
		}

		this.topicID = 0;
		this.title = title;
		this.text = text;
		this.creationTime = System.currentTimeMillis() / 1000L;
		
		// TODO, figure out what to use here, maybe pass a userid as a param?
		this.authorID = 0L;
		this.equations = new ArrayList<Equation>();
		this.quizzes = new ArrayList<Quiz>();
	}

	public void addEquation(Equation equation) {
		equations.add(equation);
	}
	
	public void save() {
	   DB db = new DB();
      ArrayList<HashMap<String, String>> rows; 
	   String q_saveTopic = "INSERT IGNORE INTO `topics`" +
	                        "SET `parentid` = ?, " +
                               "`topicid` = ?, " +
                               "`creation_time` = ? " + 
	                        "ON DUPLICATE KEY UPDATE " +
	                            "`parentid` = ? ";

	   String[] p_saveTopic = {
	      DB.T_I, String.valueOf(this.parentTopicID),
	      DB.T_I, this.topicID > 0 ? String.valueOf(this.topicID) : null,
	      DB.T_I, String.valueOf(this.creationTime), 
	      DB.T_I, String.valueOf(this.parentTopicID),
	   };

	   int insertedRows = db.execute(q_saveTopic, p_saveTopic);
	   if (insertedRows != 1) {
	      System.out.println(insertedRows + " rows were inserted!");
	   }

	   if (this.topicID <= 0) {
	      String q_getTopicID = "SELECT `topicid` FROM `topics` " + 
	                            "WHERE `creation_time` = ?";
	      String[] p_getTopicID = {DB.T_I, String.valueOf(this.creationTime)};
	      
	      rows = db.query(q_getTopicID, p_getTopicID); 
	      this.topicID = Long.valueOf(rows.get(0).get("topicid"));
	   }

	   String q_saveTopicRevision = "INSERT INTO `topic_revisions` " +
                                   "SET `topicid` = ?, " + 
                                       "`title` = ?, " + 
                                       "`text` = ?, " +
                                       "`authorid` = ?";
	   String[] p_saveTopicRevision = {
	      DB.T_I, String.valueOf(this.topicID),
	      DB.T_S, this.title,
	      DB.T_S, this.text,
	      DB.T_I, String.valueOf(this.authorID)
	   };
	   
	   db.execute(q_saveTopicRevision, p_saveTopicRevision);
	   
	   // Update revisionid to be the new revisionid.
      String q_getRevisionID = "SELECT `revisionid` " + 
                               "FROM `topic_revisions` " + 
                               "WHERE `topicid` = ? " + 
                               "ORDER BY `revisionid` DESC "; 
      String[] p_getRevisionID = {DB.T_I, String.valueOf(this.topicID)};
      rows = db.query(q_getRevisionID, p_getRevisionID); 
      this.revisionID = Long.valueOf(rows.get(0).get("revisionid"));
	   
	   // TODO: save updated equations list
	}

	public void delete() {
	   DB db = new DB();
	   String q_deleteTopic = "DELETE FROM `topics` WHERE `topicid` = ?";
	   String[] params = {DB.T_I, String.valueOf(this.topicID)};
	   String q_deleteTopicRevisions = "DELETE FROM `topic_revisions` WHERE `topicid` = ?";
	   
	   db.execute(q_deleteTopic, params);
	   db.execute(q_deleteTopicRevisions, params);
	}
	
}
