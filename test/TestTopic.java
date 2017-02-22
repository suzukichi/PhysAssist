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
		assertEquals(description, t.info);
	}

	@Test(expected=IllegalArgumentException.class)
	public void testTopicConstructorBadTitle() {
		String description = "Is super cool";
		Topic t = new Topic("", description);
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
}
