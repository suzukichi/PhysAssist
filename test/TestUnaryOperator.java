package test;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.logging.Level;
import java.util.logging.Logger;

import logic.UnaryOperator;
import logic.Term;
import logic.Variable;

public class TestUnaryOperator {
	private static final Logger LOGGER = Logger.getLogger(TestAST.class.getName());
	private UnaryOperator unOp;

	@Test public void testComputeSin()
	{
		unOp = new UnaryOperator("sin");
		Term t1 = new Variable(Math.PI);
		Term result = null;
		try 
		{
			result = unOp.perform(t1);
		} 
		catch (Exception e) 
		{
			LOGGER.log(Level.FINE, e.toString(), e);
			e.printStackTrace();
		}
		assertEquals(0.0, result.getValue(), 0.00001);
	}
	
	
	@Test public void testComputeCos()
	{
		unOp = new UnaryOperator("cos");
		Term t1 = new Variable(Math.PI);
		Term result = null;
		try 
		{
			result = unOp.perform(t1);
		} 
		catch (Exception e) 
		{
			LOGGER.log(Level.FINE, e.toString(), e);
			e.printStackTrace();
		}
		assertEquals(-1.0, result.getValue(), 0);
	}
	
	
	@Test public void testComputeTan()
	{
		unOp = new UnaryOperator("tan");
		Term t1 = new Variable(Math.PI / 4.0);
		Term result = null;
		try 
		{
			result = unOp.perform(t1);
		} 
		catch (Exception e) 
		{
			LOGGER.log(Level.FINE, e.toString(), e);
			e.printStackTrace();
		}
		assertEquals(1.0, result.getValue(), 0.00001);
	}

	
	@Test public void testComputeLog()
	{
		unOp = new UnaryOperator("log");
		Term t1 = new Variable(100.0);
		Term result = null;
		try 
		{
			result = unOp.perform(t1);
		} 
		catch (Exception e) 
		{
			LOGGER.log(Level.FINE, e.toString(), e);
			e.printStackTrace();
		}
		assertEquals(2.0, result.getValue(), 0);
	}
	
	@Test public void testComputeLn()
	{
		unOp = new UnaryOperator("ln");
		Term t1 = new Variable(1.0);
		Term result = null;
		try 
		{
			result = unOp.perform(t1);
		} 
		catch (Exception e) 
		{
			LOGGER.log(Level.FINE, e.toString(), e);
			e.printStackTrace();
		}
		assertEquals(0.0, result.getValue(), 0);
	}
	
	@Test public void testComputeAbs()
	{
		unOp = new UnaryOperator("abs");
		Term t1 = new Variable(-1.0);
		Term result = null;
		try 
		{
			result = unOp.perform(t1);
		} 
		catch (Exception e) 
		{
			LOGGER.log(Level.FINE, e.toString(), e);
			e.printStackTrace();
		}
		assertEquals(1.0, result.getValue(), 0);
	}
	
	@Test public void testComputeDeg()
	{
		unOp = new UnaryOperator("deg");
		Term t1 = new Variable(180.0);
		Term result = null;
		try 
		{
			result = unOp.perform(t1);
		} 
		catch (Exception e) 
		{
			LOGGER.log(Level.FINE, e.toString(), e);
			e.printStackTrace();
		}
		assertEquals(Math.PI, result.getValue(), 0.00001);
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
}