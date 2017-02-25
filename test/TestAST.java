package test;
import org.junit.Test;
import static org.junit.Assert.*;
import logic.AST;

public class TestAST {
	private AST ast;
		
	@Test public void TestASTBuildTreeConstant()
	{
		String constant = "c";
		try {
			ast = new AST(constant);
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals(constant, ast.toString());
		
	}
	
	@Test
	public void TestASTBuildTreeVariable() {
		String variable = "5.0";
		try {
			ast = new AST(variable);
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals(variable, ast.toString());
	}
	
	@Test
	public void TestASTBuildTreeBranchSimple() {
		String tree = "+ 3 5";
		String expected = "3.0 + 5.0";
		try {
			ast = new AST(tree);
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals(expected, ast.toString());
	}

	
	@Test
	public void TestASTBuildTreeBranchComplex() {
		String tree = "* 3 + 5 / f 100";
		String expected = "3.0 * 5.0 + f / 100.0";
		try {
			ast = new AST(tree);
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals(expected, ast.toString());
	}
	
	@Test
	public void TestASTBuildTreeBranchNightmare() {
		String tree = "- * 3 + 4 / c 5 + * 6 + 7 / d 8 * 9 + 10 / e 11";
		String expected = "3.0 * 4.0 + c / 5.0 - 6.0 * 7.0 + d / 8.0 + 9.0 * 10.0 + e / 11.0";
		try {
			ast = new AST(tree);
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals(expected, ast.toString());
	}
	
	@Test
	public void TestASTBuildTreeElseDoneAndToStringNull() {
		String tree = "";
		String expected = "";
		try {
			ast = new AST(tree);
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals(expected, ast.toString());
	}
	
	@Test
	public void TestASTBuildTreeElseException() {
		String tree = "$$$";
		try {
			ast = new AST(tree);
			assertFalse(true);
		} catch (Exception e) {
			assertTrue(true);
		}
	}
	
}