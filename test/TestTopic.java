package test;
/*
 * @author diana
 */
import static org.junit.Assert.*;
import org.junit.Test;

import logic.Equation;
import logic.Topic;

public class TestTopic {
	@Test
	public void testTopicConstructor() {
		String title = "My new topic";
		String description = "Is super cool";
		Topic t = new Topic(0L, title, description);
		
		assertEquals(title, t.getTitle());
		assertEquals(description, t.getText());
	}

	@Test(expected=IllegalArgumentException.class)
	public void testTopicConstructorBadTitle() {
		String description = "Is super cool";
		new Topic(0L, "", description);
		// This test should fail, since the constructor throws an exception.
		assertTrue(true);
	}
	
	/* Equations have changed! TODO: use real constructor
	@Test
	public void testAddEquation() {
		String title = "Equation Test Topic";
		String description = "my test topic info";
		Topic t = new Topic(title, description);
		assertEquals(0, t.equations.size());
		
		t.addEquation(new Equation());
		assertEquals(1, t.equations.size());
	}
	*/
	
	/**
	 * NOTICE:
	 * The following tests should not be run outside of a development environment.
	 * Since we do not have a testing environment separate from the live system, we only have one DB,
	 * we should refrain from running the following tests while non-team-members are viewing the system.
	 */
	
	@Test
	public void testSaveTopic() {
		String title = "Real topics";
		String description = "This is a real topic that will go into the db, really.";
		Topic t = new Topic(0L, title, description);
		
		assertTrue(t.getTopicID() == 0);

		t.save();
		assertTrue(t.getTopicID() > 0);
		t.delete();
	}

	@Test
	public void testReviseTopic() {
		String title = "Real topics";
		String description = "This is a real topic that will go into the db, really. And be edited.";
		Topic t = new Topic(0L, title, description);

		t.save();
		Long revision1 = t.getRevisionID();
		
		t.setTitle("Real topic");
		
		t.save();
		assertTrue(revision1 < t.getRevisionID());
		t.delete();
	}

	@Test
	public void testCreateFromDBTopic() {
		String title = "First title";
		String description = "ayylmao";
		Topic t = new Topic(0L, title, description);

		t.save();
		
		Topic t2 = new Topic(t.getTopicID());
		assertEquals(t.getTitle(), t2.getTitle());
		t.delete();
   }
	
}
