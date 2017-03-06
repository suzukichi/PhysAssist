package test;
import org.junit.Test;
import static org.junit.Assert.*;
import logic.BinaryOperator;
import logic.Term;
import logic.Variable;

public class TestBinaryOperator {
	private BinaryOperator binOp;

	@Test public void testComputeAdd()
	{
		binOp = new BinaryOperator("+");
		Term t1 = new Variable(5.0);
		Term t2 = new Variable(2.0);
		Term result = null;
		try 
		{
			result = binOp.perform(t1, t2);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		assertEquals(7.0, result.getValue(), 0);
	}
	
	@Test public void testComputeSubtract()
	{
		binOp = new BinaryOperator("-");
		Term t1 = new Variable(2.0);
		Term t2 = new Variable(5.0);
		Term result = null;
		try 
		{
			result = binOp.perform(t1, t2);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		assertEquals(-3.0, result.getValue(), 0);
	}
	
	@Test public void testComputeMultiply()
	{
		binOp = new BinaryOperator("*");
		Term t1 = new Variable(5.0);
		Term t2 = new Variable(2.0);
		Term result = null;
		try 
		{
			result = binOp.perform(t1, t2);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		assertEquals(10.0, result.getValue(), 0);
	}
	
	@Test public void testComputeDivide()
	{
		binOp = new BinaryOperator("/");
		Term t1 = new Variable(6.0);
		Term t2 = new Variable(2.0);
		Term result = null;
		try 
		{
			result = binOp.perform(t1, t2);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		assertEquals(3.0, result.getValue(), 0);
	}
	
	@Test public void testComputeDivideByZero()
	{
		binOp = new BinaryOperator("/");
		Term t1 = new Variable(6.0);
		Term t2 = new Variable(0.0);
		Term result = null;
		try 
		{
			result = binOp.perform(t1, t2);
			assertTrue(false);
		} 
		catch (Exception e) 
		{
			assertTrue(true);
		}
	}
	
	@Test public void testComputePow()
	{
		binOp = new BinaryOperator("^");
		Term t1 = new Variable(4.0);
		Term t2 = new Variable(0.5);
		Term result = null;
		try 
		{
			result = binOp.perform(t1, t2);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		assertEquals(2.0, result.getValue(), 0);
	}
	
	@Test public void testComputeInvalidOperator()
	{
		binOp = new BinaryOperator("?");
		Term t1 = new Variable(5.0);
		Term t2 = new Variable(2.0);
		Term result = null;
		try 
		{
			result = binOp.perform(t1, t2);
			assertTrue(false);
		} 
		catch (Exception e) 
		{
			assertTrue(true);
		}
	}
}