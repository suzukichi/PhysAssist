package test;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.Test;
import logic.Equation;
import logic.Term;
import logic.Variable;

/*
 * TestEquation.java
 * 
 * Test class that tests the Equation class.
 * 
 * @author Arianna Olson
 */
public class TestEquation {
	private static final Logger LOGGER = Logger.getLogger(TestAST.class.getName());
	private Equation equation;

	@Test public void TestEquationSolve()
	{
		String equationName = "Newton's Second Law of Motion";
		Term solveFor = new Variable("F", 0.0);
		ArrayList<Term> terms = new ArrayList<Term>();
		terms.add(new Variable("m", 9.0));
		terms.add(new Variable("a", 5.0));
		equation = new Equation(equationName);
		try {
			assertEquals(45.0, (equation.solve(solveFor, terms)).getValue(), 0.01);
		} catch (Exception e) {
			LOGGER.log(Level.FINE, e.toString(), e);
		}
	}
	
	@Test public void TestEquationGetView()
	{
		String equationName = "Newton's Second Law of Motion";
		String expectedView = "F = ma";
		
		Equation eq = new Equation(equationName);
		assertEquals(expectedView, eq.getView());
	}
	
	@Test public void TestEquationGetDescription()
	{
		String equationName = "Newton's Second Law of Motion";
		String expectedDescription = "The force (F) acting on an object is equal to the mass (m) of an object times its acceleration (a).";
		
		Equation eq = new Equation(equationName);
		assertEquals(expectedDescription, eq.getDescription());
	}
	
	@Test public void TestEquationGetHistory()
	{
		String equationName = "Newton's Second Law of Motion";
		String expectedHistory = "Isaac Newton's laws of motion were first set down in his Principia Mathematica Philosophiae Naturalis in 1687.";
		
		Equation eq = new Equation(equationName);
		assertEquals(expectedHistory, eq.getHistory());
	}
}