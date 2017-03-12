/*Shiv Sulkar tests for Calculator.java*/

package test;
import org.junit.Test;
import static org.junit.Assert.*; 
import logic.Calculator;
public class TestCalculatorClear {	
	@Test
	public void testClearNoInput(){
		Calculator C = new Calculator();
		C.clear();
		assertEquals("",C.expression);
	}
	
	@Test
	public void testClearWithInput(){
		Calculator C = new Calculator();
		C.expression = "Math.pow(1,0)";
		C.clear();
		assertEquals("",C.expression);
	}
}
