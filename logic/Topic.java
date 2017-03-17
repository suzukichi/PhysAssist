package logic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Topic {
	private long topicID;
	private String title;
	private String text;
	private long authorID; 
	private long revisionID;
	private long parentTopicID;
	private long creationTime;
	
	private List<Equation> equations;
	
	public Topic(long topicID) {
	   DB db = DB.getInstance();
	   
      String qgetTopic = "SELECT tr.`topicid`, tr.`title`, tr.`text`, tr.`authorid`, tr.`revisionid`," + 
                                " t.`parentid`, t.`creation_time`" +  
                          " FROM `topic_revisions` tr" + 
                          " JOIN `topics` t USING (`topicid`)" +
                          " WHERE `topicid` = ?" + 
                          " ORDER BY `revisionid` DESC" + 
                          " LIMIT 1";
      String[] pgetTopic = {DB.T_I, String.valueOf(topicID)};
      HashMap<String, String> row = db.query(qgetTopic, pgetTopic).get(0);
      
      this.topicID = topicID;
      this.title = row.get("title");
      this.text = row.get("text");
      this.authorID = Long.valueOf(row.get("authorid"));
      this.revisionID = Long.valueOf(row.get("revisionid"));
      this.parentTopicID = Long.valueOf(row.get("parentid"));
      this.creationTime = Long.valueOf(row.get("creation_time"));
     
      this.equations = new ArrayList<>();
	}
	
	public Topic(long topicID, long parentTopicID, String title, String text, long authorID,
	    long revisionID, long creationTime) {
	  this.topicID = topicID;
	  this.parentTopicID = parentTopicID;
	  this.title = title;
	  this.text = text;
	  this.authorID = authorID;
	  this.revisionID = revisionID;
	  this.creationTime = creationTime;
	}

  public Topic(Long userid, String title, String text) {
		if (title.length() < 1) {
			throw new IllegalArgumentException("Topic titles must be more than one character long.");
		}

		this.topicID = 0;
		this.title = title;
		this.text = text;
		this.creationTime = System.currentTimeMillis() / 1000L;
		
		this.authorID = userid;
		this.equations = new ArrayList<>();
	}

	public void addEquation(Equation equation) {
		equations.add(equation);
	}
	
	public void save() {
	   DB db = DB.getInstance();
       List<HashMap<String, String>> rows; 
	   String qsaveTopic = "INSERT IGNORE INTO `topics`" +
	                        "SET `parentid` = ?, " +
                               "`topicid` = ?, " +
                               "`creation_time` = ? " + 
	                        "ON DUPLICATE KEY UPDATE " +
	                            "`parentid` = ? ";

	   String[] psaveTopic = {
	      DB.T_I, String.valueOf(this.parentTopicID),
	      DB.T_I, this.topicID > 0 ? String.valueOf(this.topicID) : null,
	      DB.T_I, String.valueOf(this.creationTime), 
	      DB.T_I, String.valueOf(this.parentTopicID),
	   };

	   if (this.topicID <= 0) {
	      String qgetTopicID = "SELECT `topicid` FROM `topics` " + 
	                            "WHERE `creation_time` = ?";
	      String[] pgetTopicID = {DB.T_I, String.valueOf(this.creationTime)};
	      
	      rows = db.query(qgetTopicID, pgetTopicID); 
	      this.topicID = Long.valueOf(rows.get(0).get("topicid"));
	   }

	   String qsaveTopicRevision = "INSERT INTO `topic_revisions` " +
                                   "SET `topicid` = ?, " + 
                                       "`title` = ?, " + 
                                       "`text` = ?, " +
                                       "`authorid` = ?";
	   String[] psaveTopicRevision = {
	      DB.T_I, String.valueOf(this.topicID),
	      DB.T_S, this.title,
	      DB.T_S, this.text,
	      DB.T_I, String.valueOf(this.authorID)
	   };
	   
	   db.execute(qsaveTopicRevision, psaveTopicRevision);
	   
	   // Update revisionid to be the new revisionid.
      String qGetRevisionID = "SELECT `revisionid` " + 
                               "FROM `topic_revisions` " + 
                               "WHERE `topicid` = ? " + 
                               "ORDER BY `revisionid` DESC "; 
      String[] pGetRevisionID = {DB.T_I, String.valueOf(this.topicID)};
      rows = db.query(qGetRevisionID, pGetRevisionID); 
      this.revisionID = Long.valueOf(rows.get(0).get("revisionid"));
	}

	public void delete() {
	   DB db = DB.getInstance();
	   String qdeleteTopic = "DELETE FROM `topics` WHERE `topicid` = ?";
	   String[] params = {DB.T_I, String.valueOf(this.topicID)};
	   String qdeleteTopicRevisions = "DELETE FROM `topic_revisions` WHERE `topicid` = ?";
	   
	   db.execute(qdeleteTopic, params);
	   db.execute(qdeleteTopicRevisions, params);
	}
	
	@Override
	public String toString() {
	    return "Topic: " + Long.toString(this.topicID) + ", " + this.title + ", " + this.text;
	}

	public String getTitle() {
		return this.title;
	}

	public String getText() {
		return this.text;
	}

	public long getTopicID() {
		return this.topicID;
	}

	public long getRevisionID() {
		return this.revisionID;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	
}
