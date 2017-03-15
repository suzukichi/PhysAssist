package logic;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Post represents notifications posted by a classrooms teacher or contributor.
 *
 * Created: 2/12/16
 * Author: Chris Thibodeau - cathibod
 * Phys-Assist Project
 */

public class Post {
	public long postID;
    public long classroomID;
    public long authorID;
    public long publishTS;
    public long lastEditTS;
    public String title, text;

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

    	String q_getPost = "SELECT * FROM `posts` " + 
    	                   " WHERE `postid` = ?";
    	String[] p_getPost = {DB.T_I, String.valueOf(postID)};    	
    	
    	ArrayList<HashMap<String, String>> rows = (DB.getInstance()).query(q_getPost, p_getPost);
    	if (rows.size() == 0) {
    	   // Throw exception or something is probably better to do.
    	   return;
    	}

      HashMap<String, String> row = rows.get(0);
    	this.title = row.get("title");
    	this.text = row.get("text");
    	//this.classroomID = Integer.parseInt(row.get("classroomid"));
    }
    
    /**
     * Saves the post to the db.
     */
    public long save() {
       String setFields = "`title` = ?, `text` = ?, `classroomid` = ?";
       String classroomIDStr = String.valueOf(this.classroomID); 
       String[] p_savePost = {
          DB.T_S, this.title,
          DB.T_S, this.text,
          DB.T_I, classroomIDStr,
          DB.T_S, this.title,
          DB.T_S, this.text,
          DB.T_I, classroomIDStr,
          DB.T_I, String.valueOf(this.postID) 
       };

       String q_savePost = "INSERT INTO `posts` SET " + setFields +
                           " ON DUPLICATE KEY UPDATE " + setFields +
                           " WHERE `postid` = ?";
       // TODO: return latest updated index from the db and set it here
       this.postID = (DB.getInstance()).execute(q_savePost, p_savePost);
       
       return this.postID;
    }
    
    /*
     * Delete this post from the DB.
     */
    public void delete() {
      DB db = DB.getInstance();
      String q_deletePost = "DELETE FROM `posts` WHERE `postid` = ?";
      String[] params = {DB.T_I, String.valueOf(this.postID)};
      
      db.execute(q_deletePost, params);
   }
    
    public String toString() {
      return "   Post: " + title + ", " + text;
    }
}

