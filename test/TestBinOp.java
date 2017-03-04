package test;
import org.junit.Test;
import static org.junit.Assert.*;
import logic.BinaryOperator;
import logic.Term;
import logic.Variable;

public class TestBinOp {
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
	// add test cases covering all unary and binary operators. rename to TestBinaryOperator - add TestUnaryOperator
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
}