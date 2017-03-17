//loop test for AST

package test;
import org.junit.Test;

import static org.junit.Assert.*; 
import logic.AST;
public class TestLoopASTBuildTree 
{	
	private final String TESTSTRING = "Hello";
	
	@Test
	public void loopTest1()
	{
		AST a = new AST(" ");
		String root = a.toString();
		assertEquals("",root);
	}
	
	@Test
	public void loopTest2()
	{
		AST a = new AST(TESTSTRING);
		String root = a.toString();
		assertEquals(TESTSTRING,root);
	}
	
	@Test
	public void loopTest3()
	{
		AST a = new AST("Hello World");
		String root = a.toString();
		assertEquals(TESTSTRING,root);
	}
	
	@Test
	public void loopTest4()
	{
		AST a = new AST("");
		String root = a.toString();
		assertEquals("",root);
	}
}