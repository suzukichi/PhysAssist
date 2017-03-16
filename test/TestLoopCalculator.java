//loop test for calculator

package test;
import org.junit.Test;
import static org.junit.Assert.*; 
import logic.Calculator;
public class TestLoopCalculator {
	@Test
	public void LoopNever(){
		Calculator C = new Calculator();
		int i = C.initButtons(0);
		assertEquals(0,i,0);
	}
	@Test
	public void LoopOnce(){
		Calculator C = new Calculator();
		int i = C.initButtons(1);
		assertEquals(1,i,0);
	}
	@Test
	public void LoopNhalf(){
		Calculator C = new Calculator();
		int i = C.initButtons(15);
		assertEquals(15,i,0);
	}
	@Test
	public void LoopNTimes(){
		Calculator C = new Calculator();
		int i = C.initButtons(30);
		assertEquals(30,i,0);
	}
}
