package test;
import org.junit.Test;
import static org.junit.Assert.*;
import logic.BinOp;
import logic.Term;

public class TestBinOp {
	private BinOp binOp;
	
	public TestBinOp()
	{
	}
	
	@Test public void testComputeAdd()
	{
		binOp = new BinOp("+");
		Term t1 = new Term(5.0);
		Term t2 = new Term(2.0);
		Term result = null;
		try {
			result = binOp.perform(t1, t2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(7.0, result.getValue(), 0);
	}
	
	@Test public void testComputeDivide()
	{
		binOp = new BinOp("/");
		Term t1 = new Term(6.0);
		Term t2 = new Term(2.0);
		Term result = null;
		try {
			result = binOp.perform(t1, t2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(3.0, result.getValue(), 0);
	}
}