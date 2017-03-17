/*Shiv Sulkar tests for Calculator.java*/

package test;
import org.junit.Test;
import static org.junit.Assert.*; 
import logic.Calculator;
public class TestCalculatorClear {	
	@Test
	public void testClearNoInput(){
		Calculator c = new Calculator();
		c.clear();
		assertEquals("",c.getExpression());
	}
	
	@Test
	public void testClearWithInput(){
		Calculator c = new Calculator();
		c.setExpression("Math.pow(1,0)");
		c.clear();
		assertEquals("",c.getExpression());
	}
}
