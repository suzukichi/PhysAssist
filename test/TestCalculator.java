/*Shiv Sulkar tests for Calculator.java*/

package test;
import org.junit.Test;

import static org.junit.Assert.*; 
import logic.Calculator;
public class TestCalculator {
	@Test
	public void testAddition(){
		Calculator C = new Calculator();
		C.expression = "1+2";
		Double a = C.getResult();
		assertEquals(3,a,0);
	}
	
	@Test
	public void testTrigRadians(){
		Calculator C = new Calculator();
		C.expression = "Math.sin(90)";
		Double a = C.getResult();
		assertEquals(.8939966636005579,a,0);
	}
	
	@Test
	public void testDivision(){
		Calculator C = new Calculator();
		C.expression = "1/2";
		Double a = C.getResult();
		assertEquals(.5,a,0);
	}
	
	@Test
	public void testSubtraction(){
		Calculator C = new Calculator();
		C.expression = "1-2";
		Double a = C.getResult();
		assertEquals(-1,a,0);
	}
	
	@Test
	public void testPow(){
		Calculator C = new Calculator();
		C.expression = "Math.pow(1,0)";
		Double a = C.getResult();
		assertEquals(1,a,0);
	}
}
