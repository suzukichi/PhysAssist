package test;
import org.junit.Test;
import static org.junit.Assert.*;
import logic.AST;
import logic.Term;

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
	public void TestASTBuildTreeUnaryBranchSimple() 
	{
		String tree = "deg 180";
		String expected = "deg 180.0";
		try {
			ast = new AST(tree);
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals(expected, ast.toString());
	}

	@Test
	public void TestASTBuildTreeUnaryBranchComplex() 
	{
		String tree = "cos log 180";
		String expected = "cos log 180.0";
		try {
			ast = new AST(tree);
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals(expected, ast.toString());
	}

	@Test
	public void TestASTBuildTreeUnaryBranchNightmare() 
	{
		String tree = "cos log sin tan log cos deg tan cos abs abs abs cos sin deg -3";
		String expected = "cos log sin tan log cos deg tan cos abs abs abs cos sin deg -3.0";
		try {
			ast = new AST(tree);
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals(expected, ast.toString());
	}

	@Test
	public void TestASTBuildTreeBinaryBranchSimple() 
	{
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
	public void TestASTBuildTreeBinaryBranchComplex() {
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
	public void TestASTBuildTreeBinaryBranchNightmare() 
	{
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
	public void TestASTBuildTreeMixedBranchSimple()
	{
		String tree = "sin * 5 3";
		String expected = "sin 5.0 * 3.0";
		try {
			ast = new AST(tree);
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals(expected, ast.toString());
	}

	@Test
	public void TestASTBuildTreeMixedBranchComplex()
	{
		String tree = "* tan 5 deg / -3 10";
		String expected = "tan 5.0 * deg -3.0 / 10.0";
		try {
			ast = new AST(tree);
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals(expected, ast.toString());
	}

	@Test
	public void TestASTBuildTreeMixedBranchNightmare()
	{
		String tree = "sin - * 3 + cos sin deg log c ^ c 5 + * abs 5 + 7 / d deg 50 * 9 + log -4.33 / e 11";
		String expected = "sin 3.0 * cos sin deg log c + c ^ 5.0 - abs 5.0 * 7.0 + d / deg 50.0 + 9.0 * log -4.33 + e / 11.0";
		try {
			ast = new AST(tree);
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals(expected, ast.toString());
	}

	@Test
	public void TestASTBuildTreeElseDoneAndToEmptyTree() {
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

	@Test
	public void TestASTComputeEmptyTree()
	{
		String tree = "";
		Term expected = null;
		try {
			ast = new AST(tree);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			assertEquals(expected, ast.compute());
		} catch (Exception e) {
			assertTrue(false);
		}
	}

	// add a test for constant when database is working
	@Test
	public void TestASTComputeVariable()
	{
		String tree = "5";
		double expected = 5.0;
		try {
			ast = new AST(tree);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			assertEquals(expected, ast.compute().getValue(), 0);
		} catch (Exception e) {
			assertTrue(false);
		}
	}

	@Test
	public void TestASTComputeUnaryBranchSimple()
	{
		String tree = "sin 0";
		double expected = 0.0;
		try {
			ast = new AST(tree);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			assertEquals(expected, ast.compute().getValue(), 0);
		} catch (Exception e) {
			assertTrue(false);
		}
	}

	@Test
	public void TestASTComputeUnaryBranchComplex()
	{
		String tree = "sin deg 180";
		double expected = 0.0;
		try {
			ast = new AST(tree);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			assertEquals(expected, ast.compute().getValue(), 0.001);
		} catch (Exception e) {
			assertTrue(false);
		}
	}

	@Test
	public void TestASTComputeUnaryBranchNightmare()
	{
		String tree = "cos sin tan log cos deg tan cos abs abs abs cos sin deg -3";
		double expected = 1.0;
		try {
			ast = new AST(tree);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			assertEquals(expected, ast.compute().getValue(), 0.001);
		} catch (Exception e) {
			assertTrue(false);
		}
	}

	@Test
	public void TestASTComputeBinaryBranchSimple()
	{
		String tree = "+ 3 5";
		double expected = 8.0;
		try {
			ast = new AST(tree);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			assertEquals(expected, ast.compute().getValue(), 0.001);
		} catch (Exception e) {
			assertTrue(false);
		}
	}

	@Test
	public void TestASTComputeBinaryBranchComplex() // adjust when constants have values
	{
		String tree = "* 3 + 5 / f 100";
		double expected = 15.0;
		try {
			ast = new AST(tree);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			assertEquals(expected, ast.compute().getValue(), 0.001);
		} catch (Exception e) {
			assertTrue(false);
		}
	}

	@Test
	public void TestASTComputeBinaryBranchNightmare() // adjust when constants have values
	{
		String tree = "- * 3 + 4 / c 5 + * 6 + 7 / d 8 * 9 + 10 / e 11";
		double expected = -120.0;
		try {
			ast = new AST(tree);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			assertEquals(expected, ast.compute().getValue(), 0.001);
		} catch (Exception e) {
			assertTrue(false);
		}
	}

	@Test
	public void TestASTComputeBinaryBranchDivideByZero()
	{
		String tree = "/ 5 0";
		try {
			ast = new AST(tree);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			ast.compute();
			assertTrue(false);
		} catch (Exception e) {
			assertTrue(true);
		}
	}

	@Test
	public void TestASTComputeMixedBranchSimple()
	{
		String tree = "sin * 5 3";
		double expected = 0.65028;
		try {
			ast = new AST(tree);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			assertEquals(expected, ast.compute().getValue(), 0.001);
		} catch (Exception e) {
			assertTrue(false);
		}
	}

	@Test
	public void TestASTComputeMixedBranchComplex()
	{
		String tree = "* tan 5 deg / -3 10";
		double expected = 0.0177;
		try {
			ast = new AST(tree);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			assertEquals(expected, ast.compute().getValue(), 0.001);
		} catch (Exception e) {
			assertTrue(false);
		}
	}

	@Test
	public void TestASTComputeMixedBranchNightmare() // adjust when constants have values - database set up
	{
		String tree = "sin - * 3 + cos sin deg tan abs c ^ c 5 + * abs 5 + 7 / d deg 50 * 9 + log abs -4.33 / e 11";
		double expected = -0.0292;
		try {
			ast = new AST(tree);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			assertEquals(expected, ast.compute().getValue(), 0.001);
		} catch (Exception e) {
			assertTrue(false);
		}
	}

}