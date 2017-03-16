package test;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.logging.Level;
import java.util.logging.Logger;

import logic.AST;
import logic.Term;

/*
 * TestAST.java
 * 
 * Test class that tests the AST class.
 * 
 * @author Arianna Olson
 */

public class TestAST {
	private AST ast;
	private static final Logger LOGGER = Logger.getLogger(TestAST.class.getName());

	/*
	 * Integration test: Operator.java, Term.java
	 */
	@Test public void testASTBuildTreeConstant()
	{
		String constant = "c";
		try {
			ast = new AST(constant);
		} catch (Exception e) {
			LOGGER.log(Level.FINE, e.toString(), e);
		}
		assertEquals(constant, ast.toString());
	}

	/*
	 * Integration test: Operator.java, Term.java
	 */
	@Test
	public void testASTBuildTreeVariable() {
		String variable = "5.0";
		try {
			ast = new AST(variable);
		} catch (Exception e) {
			LOGGER.log(Level.FINE, e.toString(), e);
		}
		assertEquals(variable, ast.toString());
	}

	/*
	 * Integration test: Operator.java, Term.java
	 */
	@Test
	public void testASTBuildTreeUnaryBranchSimple() 
	{
		String tree = "deg 180";
		String expected = "deg 180.0";
		testASTBuild(tree, expected);
	}

	/*
	 * Integration test: Operator.java, Term.java
	 */
	@Test
	public void testASTBuildTreeUnaryBranchComplex() 
	{
		String tree = "cos log 180";
		String expected = "cos log 180.0";
		testASTBuild(tree, expected);
	}

	/*
	 * Integration test: Operator.java, Term.java
	 */
	@Test
	public void testASTBuildTreeUnaryBranchNightmare() 
	{
		String tree = "cos log sin tan log cos deg tan cos abs abs abs cos sin deg -3";
		String expected = "cos log sin tan log cos deg tan cos abs abs abs cos sin deg -3.0";
		testASTBuild(tree, expected);
	}

	/*
	 * Integration test: Operator.java, Term.java
	 */
	@Test
	public void testASTBuildTreeBinaryBranchSimple() 
	{
		String tree = "+ 3 5";
		String expected = "3.0 + 5.0";
		testASTBuild(tree, expected);
	}

	/*
	 * Integration test: Operator.java, Term.java
	 */
	@Test
	public void testASTBuildTreeBinaryBranchComplex() {
		String tree = "* 3 + 5 / f 100";
		String expected = "3.0 * 5.0 + f / 100.0";
		testASTBuild(tree, expected);
	}

	/*
	 * Integration test: Operator.java, Term.java
	 */
	@Test
	public void testASTBuildTreeBinaryBranchNightmare() 
	{
		String tree = "- * 3 + 4 / c 5 + * 6 + 7 / d 8 * 9 + 10 / e 11";
		String expected = "3.0 * 4.0 + c / 5.0 - 6.0 * 7.0 + d / 8.0 + 9.0 * 10.0 + e / 11.0";
		testASTBuild(tree, expected);
	}

	/*
	 * Integration test: Operator.java, Term.java
	 */
	@Test
	public void testASTBuildTreeMixedBranchSimple()
	{
		String tree = "sin * 5 3";
		String expected = "sin 5.0 * 3.0";
		testASTBuild(tree, expected);
	}

	/*
	 * Integration test: Operator.java, Term.java
	 */
	@Test
	public void testASTBuildTreeMixedBranchComplex()
	{
		String tree = "* tan 5 deg / -3 10";
		String expected = "tan 5.0 * deg -3.0 / 10.0";
		testASTBuild(tree, expected);
	}

	/*
	 * Integration test: Operator.java, Term.java
	 */
	@Test
	public void testASTBuildTreeMixedBranchNightmare()
	{
		String tree = "sin - * 3 + cos sin deg log c ^ c 5 + * abs 5 + 7 / d deg 50 * 9 + log -4.33 / e 11";
		String expected = "sin 3.0 * cos sin deg log c + c ^ 5.0 - abs 5.0 * 7.0 + d / deg 50.0 + 9.0 * log -4.33 + e / 11.0";
		testASTBuild(tree, expected);
	}

	/*
	 * Integration test: Operator.java, Term.java
	 */
	@Test
	public void testASTBuildTreeElseDoneAndToEmptyTree() {
		String tree = "";
		String expected = "";
		testASTBuild(tree, expected);
	}
	
	private void testASTBuild(String tree, String expected)
	{
		try 
		{
			ast = new AST(tree);
		} 
		catch (Exception e) 
		{
			LOGGER.log(Level.FINE, e.toString(), e);
		}
		assertEquals(expected, ast.toString());
	}

	/*
	 * Integration test: Operator.java, Term.java
	 */
	@Test
	public void testASTBuildTreeElseException() {
		String tree = "$$$";
		try {
			ast = new AST(tree);
			assertFalse(true);
		} catch (Exception e) {
			LOGGER.log(Level.FINE, e.toString(), e);
			assertTrue(true);
		}
	}

	/*
	 * Integration test: Operator.java, Term.java
	 */
	@Test
	public void testASTComputeEmptyTree()
	{
		String tree = "";
		Term expected = null;
		try {
			ast = new AST(tree);
		} catch (Exception e) {
			LOGGER.log(Level.FINE, e.toString(), e);
		}
		try {
			assertEquals(expected, ast.compute());
		} catch (Exception e) {
			LOGGER.log(Level.FINE, e.toString(), e);
			assertTrue(false);
		}
	}

	// add a test for constant when database is working
	/*
	 * Integration test: Operator.java, Term.java
	 */
	@Test
	public void testASTComputeVariable()
	{
		String tree = "5";
		double expected = 5.0;
		testASTCompute(tree, expected);
	}

	/*
	 * Integration test: Operator.java, Term.java
	 */
	@Test
	public void testASTComputeUnaryBranchSimple()
	{
		String tree = "sin 0";
		double expected = 0.0;
		testASTCompute(tree, expected);
	}

	/*
	 * Integration test: Operator.java, Term.java
	 */
	@Test
	public void testASTComputeUnaryBranchComplex()
	{
		String tree = "sin deg 180";
		double expected = 0.0;
		testASTCompute(tree, expected);
	}

	/*
	 * Integration test: Operator.java, Term.java
	 */
	@Test
	public void testASTComputeUnaryBranchNightmare()
	{
		String tree = "cos sin tan log cos deg tan cos abs abs abs cos sin deg -3";
		double expected = 1.0;
		testASTCompute(tree, expected);
	}

	/*
	 * Integration test: Operator.java, Term.java
	 */
	@Test
	public void testASTComputeBinaryBranchSimple()
	{
		String tree = "+ 3 5";
		double expected = 8.0;
		testASTCompute(tree, expected);
	}

	/*
	 * Integration test: Operator.java, Term.java
	 */
	@Test
	public void testASTComputeBinaryBranchComplex() // adjust when constants have values
	{
		String tree = "* 3 + 5 / f 100";
		double expected = 15.0;
		testASTCompute(tree, expected);
	}

	/*
	 * Integration test: Operator.java, Term.java
	 */
	@Test
	public void testASTComputeBinaryBranchNightmare() // adjust when constants have values
	{
		String tree = "- * 3 + 4 / c 5 + * 6 + 7 / d 8 * 9 + 10 / e 11";
		double expected = -120.0;
		testASTCompute(tree, expected);
	}

	/*
	 * Integration test: Operator.java, Term.java
	 */
	@Test
	public void testASTComputeBinaryBranchDivideByZero()
	{
		String tree = "/ 5 0";
		try {
			ast = new AST(tree);
		} catch (Exception e) {
			LOGGER.log(Level.FINE, e.toString(), e);
		}
		try {
			ast.compute();
			assertTrue(false);
		} catch (Exception e) {
			LOGGER.log(Level.FINE, e.toString(), e);
			assertTrue(true);
		}
	}

	/*
	 * Integration test: Operator.java, Term.java
	 */
	@Test
	public void testASTComputeMixedBranchSimple()
	{
		String tree = "sin * 5 3";
		double expected = 0.65028;
		testASTCompute(tree, expected);
	}

	/*
	 * Integration test: Operator.java, Term.java
	 */
	@Test
	public void testASTComputeMixedBranchComplex()
	{
		String tree = "* tan 5 deg / -3 10";
		double expected = 0.0177;
		testASTCompute(tree, expected);
	}

	/*
	 * Integration test: Operator.java, Term.java
	 */
	@Test
	public void testASTComputeMixedBranchNightmare() // adjust when constants have values - database set up
	{
		String tree = "sin - * 3 + cos sin deg tan abs c ^ c 5 + * abs 5 + 7 / d deg 50 * 9 + log abs -4.33 / e 11";
		double expected = -0.0292;
		testASTCompute(tree, expected);
	}
	
	private void testASTCompute(String tree, double expected)
	{
		try 
		{
			ast = new AST(tree);
		} 
		catch (Exception e) 
		{
			LOGGER.log(Level.FINE, e.toString(), e);
		}
		try 
		{
			assertEquals(expected, ast.compute().getValue(), 0.001);
		} 
		catch (Exception e) 
		{
			LOGGER.log(Level.FINE, e.toString(), e);
			assertTrue(false);
		}
	}

}