//loop test for calculator

package test;
import org.junit.Test;

import static org.junit.Assert.*; 
import logic.AST;
public class TestLoopASTBuildTree {
	/* not sure how this should be handled or even considered.
	@Test
	public void LoopTest1() throws Exception{
		AST a = new AST(null);
		String root = a.toString();
		assertEquals("",root);
	}*/
	
	@Test
	public void LoopTest2() throws IllegalArgumentException{
		AST a = new AST(" ");
		String root = a.toString();
		assertEquals("",root);
	}
	@Test
	public void LoopTest3() throws IllegalArgumentException{
		AST a = new AST("Hello");
		String root = a.toString();
		assertEquals("Hello",root);
	}
	@Test
	public void LoopTest4() throws IllegalArgumentException{
		AST a = new AST("Hello World");
		String root = a.toString();
		assertEquals("Hello",root);
	}
	@Test
	public void LoopTest5() throws IllegalArgumentException{
		AST a = new AST("");
		String root = a.toString();
		assertEquals("",root);
	}
}
