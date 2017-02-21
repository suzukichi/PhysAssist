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
    
    public Post(int postID) {
    	this.postID = postID;
    	// TODO: get text and title from db.
    }
    
    public void save() {
    	// TODO: save post in db and set the postid
    }
}
