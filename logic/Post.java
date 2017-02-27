package logic;

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
    public String title, text;

    public Post(String title, String text) {
    	this.title = title;
    	this.text = text;
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
    	String[] p_getPost = {String.valueOf(postID)};    	
    	
    	HashMap<String, String> row = (new DB()).query(q_getPost, p_getPost).get(0);
    	this.title = row.get("title");
    	this.text = row.get("text");
    	this.classroomID = Integer.parseInt(row.get("classroomid"));
    }
    
    /**
     * Saves the post to the db.
     */
    public long save() {
       String setFields = "`title` = '?', `text` = ?, `classroomid` = ?";
       String classroomIDStr = String.valueOf(this.classroomID); 
       String[] p_savePost = {
          this.title,
          this.text,
          classroomIDStr,
          this.title,
          this.text,
          classroomIDStr,
          String.valueOf(this.postID) 
       };

       String q_savePost = "INSERT INTO `posts` SET " + setFields +
                           " ON DUPLICATE KEY UPDATE " + setFields +
                           " WHERE `postid` = ?";
       (new DB()).query(q_savePost, p_savePost);
       
       // This may not be set here...
       // TODO: return latest updated index from the db and set it here
       return this.postID;
    }
}

