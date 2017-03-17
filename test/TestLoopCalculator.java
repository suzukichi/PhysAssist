//loop test for calculator

package test;
import org.junit.Test;
import static org.junit.Assert.*; 
import logic.Calculator;
public class TestLoopCalculator {
	@Test
	public void loopNever(){
		Calculator C = new Calculator();
		int i = C.initButtons(0);
		assertEquals(0,i,0);
	}
	@Test
	public void loopOnce(){
		Calculator C = new Calculator();
		int i = C.initButtons(1);
		assertEquals(1,i,0);
	}
	@Test
	public void loopNhalf(){
		Calculator C = new Calculator();
		int i = C.initButtons(15);
		assertEquals(15,i,0);
	}
	@Test
	public void loopNTimes(){
		Calculator C = new Calculator();
		int i = C.initButtons(30);
		assertEquals(30,i,0);
	}
}
