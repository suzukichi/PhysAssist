package test;
/*
 * @author diana
 */
import static org.junit.Assert.*;
import org.junit.Test;

import logic.Equation;
import logic.Topic;

public class TestTopic {
	/* TODO: Add test topic to DB and teardown at end of test.*/
	
	@Test
	public void testTopicConstructor() {
		String title = "My new topic";
		String description = "Is super cool";
		Topic t = new Topic(title, description);
		
		assertEquals(title, t.title);
		assertEquals(description, t.text);
	}

	@Test(expected=IllegalArgumentException.class)
	public void testTopicConstructorBadTitle() {
		String description = "Is super cool";
		new Topic("", description);
		// This test should fail, since the constructor throws an exception.
		assert(true);
	}
	
	@Test
	public void testAddEquation() {
		String title = "Equation Test Topic";
		String description = "my test topic info";
		Topic t = new Topic(title, description);
		assertEquals(0, t.equations.size());
		
		t.addEquation(new Equation());
		assertEquals(1, t.equations.size());
	}
	
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
		Topic t = new Topic(title, description);
		
		assertTrue(t.topicID == 0);

		t.save();
		assertTrue(t.topicID > 0);
	}

	//@Test
	public void testReviseTopic() {
		String title = "Real topics";
		String description = "This is a real topic that will go into the db, really.";
		Topic t = new Topic(title, description);

		t.save();
		Long revision1 = t.revisionID;
		
		t.title = "Real topic";
		
		t.save();
		assertTrue(revision1 < t.revisionID);
	}
	
}
