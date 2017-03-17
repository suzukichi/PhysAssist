package logic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

/**
 * Post represents notifications posted by a classrooms teacher or contributor.
 *
 * Created: 2/12/16
 * Author: Chris Thibodeau - cathibod
 * Phys-Assist Project
 */

public class Post {
	private long postID;
    private long classroomID;
    private long authorID;
    private long publishTS;
    private long lastEditTS;
    private String title, text;

    public Post(String title, String text, long courseID) {
      this.title = title;
      this.text = text;
      this.publishTS = System.currentTimeMillis() / 1000L;
      this.classroomID = courseID;
    }
    
    public Post(String title, String text) {
    	this.title = title;
    	this.text = text;
        this.publishTS = System.currentTimeMillis() / 1000L;
    	this.lastEditTS = publishTS;
    }
    
    /**
     * Creates post from the database
     * 
     * @param postID
     */
    public Post(long postID) {
    	this.postID = postID;

    	String qgetPost = "SELECT * FROM `posts` " + 
    	                   " WHERE `postid` = ?";
    	String[] pgetPost = {DB.T_I, String.valueOf(postID)};    	
    	
    	List<HashMap<String, String>> rows = (DB.getInstance()).query(qgetPost, pgetPost);
    	if (rows.size() == 0) {
    	   throw new IllegalArgumentException("Rows.size() == 0)");
    	}

      HashMap<String, String> row = rows.get(0);
    	this.title = row.get("title");
    	this.text = row.get("text");
    	//TODO finish filling in attributes
    	//this.classroomID = Integer.parseInt(row.get("classroomid"));
    }
    
    /**
     * Saves the post to the db.
     */
    public long save() {
       String setFields = "`title` = ?, `text` = ?, `classroomid` = ?, `postid` = ?";
       String classroomIDStr = String.valueOf(this.classroomID); 
       String[] pSavePost = {
          DB.T_S, this.title,
          DB.T_S, this.text,
          DB.T_I, classroomIDStr,
          DB.T_I, String.valueOf(this.postID), 

          DB.T_S, this.title,
          DB.T_S, this.text,
          DB.T_I, classroomIDStr,
          DB.T_I, String.valueOf(this.postID) 
       };

       String qSavePost = "INSERT INTO `posts` SET " + setFields +
                          " ON DUPLICATE KEY UPDATE " + setFields;
       DB.getInstance().execute(qSavePost, pSavePost);

       if (this.postID <= 0) {
          String qGetPostid = "SELECT `postid`" +
                              " FROM `posts`" + 
                              " WHERE `title` = ? AND `classroomid` = ?" + 
                              " ORDER BY `postid` DESC " +
                              " LIMIT 1";
          String[] pGetPostid = {
             DB.T_S, this.title,
             DB.T_I, classroomIDStr
          };

          this.postID = Long.valueOf(DB.getInstance().query(qGetPostid, pGetPostid).get(0).get("postid"));
       }

       return this.postID;
    }
    
    /*
     * Delete this post from the DB.
     */
    public void delete() {
      DB db = DB.getInstance();
      String qDeletePost = "DELETE FROM `posts` WHERE `postid` = ?";
      String[] params = {DB.T_I, String.valueOf(this.postID)};
      
      db.execute(qDeletePost, params);
   }
    
    @Override
    public String toString() {
      return "   Post: " + title + ", " + text;
    }
    
    @Override
    public int hashCode() {
      return Objects.hash(postID, classroomID, authorID, publishTS, lastEditTS, title, text);
    }
    
    @Override
    public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      }
      if (obj == null) {
        return false;
      }
      if (getClass() != obj.getClass()) {
        return false;
      }
      Post other = (Post) obj;
      
      boolean firstComp = Objects.equals(this.postID, other.postID) &&
      		  Objects.equals(this.classroomID, other.classroomID) &&
      		  Objects.equals(this.authorID, other.authorID);
      boolean secondComp = Objects.equals(this.publishTS, other.publishTS) &&
              Objects.equals(this.lastEditTS, other.lastEditTS) &&
              Objects.equals(this.title, other.title);
      
      
      return firstComp && secondComp && Objects.equals(this.text, this.text);
    }

	public String getTitle() {
		return this.title;
	}
	
	public void setTitle(String title)
	{
		this.title = title;
	}

	public String getText() {
		return this.text;
	}

	public long getPostID() {
		return this.postID;
	}
}

