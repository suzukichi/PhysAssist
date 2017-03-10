package logic;
/*
 * TopicPage.java
 * 
 * 
 * 
 * @author Kyle Ringler
 * Created Feb 13, 2017
 */

public class TopicPage extends Page {

  private Topic topic;
  
  public TopicPage(String name, Topic topic) {
    super(name);
    this.topic = topic;
  }
    
  public void display() {
      
  }
}
