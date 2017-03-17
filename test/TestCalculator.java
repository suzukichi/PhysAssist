/*Shiv Sulkar tests for Calculator.java*/

package test;
import org.junit.Test;

import static org.junit.Assert.*; 
import logic.Calculator;
public class TestCalculator {
	@Test
	public void testAddition(){
		Calculator c = new Calculator();
		c.setExpression("1+2");
		Double a = c.getResult();
		assertEquals(3,a,0);
	}
	
	@Test
	public void testTrigRadians(){
		Calculator c = new Calculator();
		c.setExpression("Math.sin(90)");
		Double a = c.getResult();
		assertEquals(.8939966636005579,a,0);
	}
	
	@Test
	public void testDivision(){
		Calculator c = new Calculator();
		c.setExpression("1/2");
		Double a = c.getResult();
		assertEquals(.5,a,0);
	}
	
	@Test
	public void testSubtraction(){
		Calculator c = new Calculator();
		c.setExpression("1-2");
		Double a = c.getResult();
		assertEquals(-1,a,0);
	}
	
	@Test
	public void testPow(){
		Calculator c = new Calculator();
		c.setExpression("Math.pow(1,0)");
		Double a = c.getResult();
		assertEquals(1,a,0);
	}
}
