//loop test for calculator

package test;
import org.junit.Test;
import static org.junit.Assert.*; 
import logic.Calculator;
public class TestLoopCalculatorOther {
	@Test
	public void testLoopNever(){
		String[] names = {};
		Calculator c = new Calculator();
		c.setButtonNames(names);
		int i = c.anyOtherButton("");
		assertEquals(0,i,0);
	}
	
	@Test
	public void testLoopOnce(){
		String[] names = {"1","2"};
		Calculator c = new Calculator();
		c.setButtonNames(names);
		int i = c.anyOtherButton("2");
		assertEquals(1,i,0);
	}
	@Test
	public void testLoopOnceMore(){
		String[] names = {"1","2"};
		Calculator c = new Calculator();
		c.setButtonNames(names);
		int i = c.anyOtherButton("2");
		assertEquals(1,i,0);
	}
	@Test
	public void testLoopEntireArray(){
		String[] names = {"1","2","3"};
		Calculator c = new Calculator();
		c.setButtonNames(names);
		int i = c.anyOtherButton("3");
		assertEquals(2,i,0);
	}
	@Test
	public void testLoopNotInArray(){
		String[] names = {"1","2","3","4"};
		Calculator c = new Calculator();
		c.setButtonNames(names);
		int i = c.anyOtherButton("");
		assertEquals(4,i,0);
	}
}
