package test;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.logging.Level;
import java.util.logging.Logger;

import logic.UnaryOperator;
import logic.Term;
import logic.Variable;

/*
 * TestUnaryOperator.java
 * 
 * Test class that tests the UnaryOperator class.
 * 
 * @author Kyle Ringler
 */

public class TestUnaryOperator {
	private static final Logger LOGGER = Logger.getLogger(TestAST.class.getName());
	private UnaryOperator unOp;

	@Test public void testComputeSin()
	{
		unOp = new UnaryOperator("sin");
		Term t1 = new Variable(Math.PI);
		testCompute(t1, 0.0);
	}
	
	
	@Test public void testComputeCos()
	{
		unOp = new UnaryOperator("cos");
		Term t1 = new Variable(Math.PI);
		testCompute(t1, -1.0);
	}
	
	
	@Test public void testComputeTan()
	{
		unOp = new UnaryOperator("tan");
		Term t1 = new Variable(Math.PI / 4.0);
		testCompute(t1, 1.0);
	}

	
	@Test public void testComputeLog()
	{
		unOp = new UnaryOperator("log");
		Term t1 = new Variable(100.0);
		testCompute(t1, 2.0);
	}
	
	@Test public void testComputeLn()
	{
		unOp = new UnaryOperator("ln");
		Term t1 = new Variable(1.0);
		testCompute(t1, 0.0);
	}
	
	@Test public void testComputeAbs()
	{
		unOp = new UnaryOperator("abs");
		Term t1 = new Variable(-1.0);
		testCompute(t1, 1.0);
	}
	
	@Test public void testComputeDeg()
	{
		unOp = new UnaryOperator("deg");
		Term t1 = new Variable(180.0);
		testCompute(t1, Math.PI);
	}
	
	@Test public void testComputeInvalidOperator()
	{
		unOp = new UnaryOperator("?");
		Term t1 = new Variable(5.0);
		try 
		{
			unOp.perform(t1);
			assertTrue(false);
		} 
		catch (Exception e) 
		{
			LOGGER.log(Level.FINE, e.toString(), e);
			assertTrue(true);
		}
	}
	
	private void testCompute(Term t1, double expected)
	{
		Term result = null;
		try 
		{
			result = unOp.perform(t1);
		} 
		catch (Exception e) 
		{
			LOGGER.log(Level.FINE, e.toString(), e);
		}
		try 
		{
			if (result != null)
			{
				assertEquals(expected, result.getValue(), 0.00001);
			}
		}
		catch (Exception e) 
		{
			LOGGER.log(Level.FINE, e.toString(), e);
		}
	}
}