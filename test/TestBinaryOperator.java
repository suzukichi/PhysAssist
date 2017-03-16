package test;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.logging.Level;
import java.util.logging.Logger;

import logic.BinaryOperator;
import logic.Term;
import logic.Variable;

/*
 * TestBinaryOperator.java
 * 
 * Test class that tests the BinaryOperator class.
 * 
 * @author Kyle Ringler
 */

public class TestBinaryOperator {
	private static final Logger LOGGER = Logger.getLogger(TestAST.class.getName());
	private BinaryOperator binOp;

	@Test public void testComputeAdd()
	{
		binOp = new BinaryOperator("+");
		Term t1 = new Variable(5.0);
		Term t2 = new Variable(2.0);
		testCompute(t1, t2, 7.0);
	}
	
	@Test public void testComputeSubtract()
	{
		binOp = new BinaryOperator("-");
		Term t1 = new Variable(2.0);
		Term t2 = new Variable(5.0);
		testCompute(t1, t2, -3.0);
	}
	
	@Test public void testComputeMultiply()
	{
		binOp = new BinaryOperator("*");
		Term t1 = new Variable(5.0);
		Term t2 = new Variable(2.0);
		testCompute(t1, t2, 10.0);
	}
	
	@Test public void testComputeDivide()
	{
		binOp = new BinaryOperator("/");
		Term t1 = new Variable(6.0);
		Term t2 = new Variable(2.0);
		testCompute(t1, t2, 3.0);
	}
	
	@Test public void testComputeDivideByZero()
	{
		binOp = new BinaryOperator("/");
		Term t1 = new Variable(6.0);
		Term t2 = new Variable(0.0);
		try 
		{
			binOp.perform(t1, t2);
			assertTrue(false);
		} 
		catch (Exception e) 
		{
			LOGGER.log(Level.FINE, e.toString(), e);
			assertTrue(true);
		}
	}
	
	@Test public void testComputePow()
	{
		binOp = new BinaryOperator("^");
		Term t1 = new Variable(4.0);
		Term t2 = new Variable(0.5);
		testCompute(t1, t2, 2.0);
	}
	
	@Test public void testComputeInvalidOperator()
	{
		binOp = new BinaryOperator("?");
		Term t1 = new Variable(5.0);
		Term t2 = new Variable(2.0);
		try 
		{
			binOp.perform(t1, t2);
			assertTrue(false);
		} 
		catch (Exception e) 
		{
			LOGGER.log(Level.FINE, e.toString(), e);
			assertTrue(true);
		}
	}
	
	private void testCompute(Term t1, Term t2, double expected)
	{
		Term result = null;
		try 
		{
			result = binOp.perform(t1, t2);
		} 
		catch (Exception e) 
		{
			LOGGER.log(Level.FINE, e.toString(), e);
		}
		try 
		{
			if (result != null)
			{
				assertEquals(expected, result.getValue(), 0);
			}
		} 
		catch (Exception e) 
		{
			LOGGER.log(Level.FINE, e.toString(), e);
		}
	}
}