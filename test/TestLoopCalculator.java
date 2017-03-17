//shivsulkar

package test;
import org.junit.Test;
import static org.junit.Assert.*; 
import logic.Calculator;
public class TestLoopCalculator {
	@Test
	public void testLoopNever(){
		Calculator c = new Calculator();
		int i = c.initButtons(0);
		assertEquals(0,i,0);
	}
	@Test
	public void testLoopOnce(){
		Calculator c = new Calculator();
		int i = c.initButtons(1);
		assertEquals(1,i,0);
	}
	@Test
	public void testLoopNhalf(){
		Calculator c = new Calculator();
		int i = c.initButtons(15);
		assertEquals(15,i,0);
	}
	@Test
	public void testLoopNTimes(){
		Calculator c = new Calculator();
		int i = c.initButtons(30);
		assertEquals(30,i,0);
	}
}
