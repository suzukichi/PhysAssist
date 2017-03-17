//shiv
package test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import logic.TopicListPage;
import logic.Topic;
import org.junit.Test;

public class TestLoopTopicPageList {
	@Test
	public void testLoopNever(){
		TopicListPage t = new TopicListPage();
		t.setTestMode(true);
		List<Topic> topics = new ArrayList<>();
		t.setTopics(topics);
		int i = t.updateCategoryList();
		assertEquals(0,i,0);
	}
	@Test
	public void testLoopOverThree(){
		TopicListPage t = new TopicListPage();
		t.setTestMode(true);
		t.setCatCursor(3);
		List<Topic> topics = new ArrayList<>();
		Topic tpc1 = new Topic((long)1,"aaaa","aa");
		Topic tpc2 = new Topic((long)2,"aaaa","aa");
		Topic tpc3 = new Topic((long)3,"aaaa","aa");
		Topic tpc4 = new Topic((long)3,"aaaa","aa");
		topics.add(tpc1);
		topics.add(tpc2);
		topics.add(tpc3);
		topics.add(tpc4);
		t.setTopics(topics);
		int i = t.updateCategoryList();
		assertEquals(0,i,0);
	}
	@Test
	public void testLoopOverFour(){
		TopicListPage t = new TopicListPage();
		t.setTestMode(true);
		List<Topic> topics = new ArrayList<>();
		Topic tpc1 = new Topic((long)1,"aaaa","aa");
		Topic tpc2 = new Topic((long)2,"aaaa","aa");
		Topic tpc3 = new Topic((long)3,"aaaa","aa");
		Topic tpc4 = new Topic((long)4,"aaaa","aa");
		topics.add(tpc1);
		topics.add(tpc2);
		topics.add(tpc3);
		topics.add(tpc4);
		t.setCatCursor(4);
		t.setTopics(topics);
		int i = t.updateCategoryList();
		assertEquals(0,i,0);
	}
	@Test
	public void testLoopOverTwo(){
		TopicListPage t = new TopicListPage();
		t.setTestMode(true);
		List<Topic> topics = new ArrayList<>();
		Topic tpc1 = new Topic((long)1,"aaaa","aa");
		Topic tpc2 = new Topic((long)2,"aaaa","aa");
		Topic tpc3 = new Topic((long)3,"aaaa","aa");
		Topic tpc4 = new Topic((long)4,"aaaa","aa");
		topics.add(tpc1);
		topics.add(tpc2);
		topics.add(tpc3);
		topics.add(tpc4);
		t.setCatCursor(2);
		t.setTopics(topics);
		int i = t.updateCategoryList();
		assertEquals(1,i,0);
	}
	@Test
	public void testLoopAtThree(){
		TopicListPage t = new TopicListPage();
		t.setTestMode(true);
		List<Topic> topics = new ArrayList<>();
		Topic tpc1 = new Topic((long)1,"aaaa","aa");
		Topic tpc2 = new Topic((long)2,"aaaa","aa");
		Topic tpc3 = new Topic((long)3,"aaaa","aa");
		Topic tpc4 = new Topic((long)4,"aaaa","aa");
		topics.add(tpc1);
		topics.add(tpc2);
		topics.add(tpc3);
		topics.add(tpc4);
		t.setCatCursor(0);
		t.setTopics(topics);
		int i = t.updateCategoryList();
		assertEquals(3,i,0);
	}
}
