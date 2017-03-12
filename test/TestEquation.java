package test;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;
import logic.Equation;
import logic.Term;
import logic.Variable;

public class TestEquation {
	private Equation equation;

	@Test public void TestEquationSolve()
	{
		String equationName = "Eqn Name";
		Term solveFor = new Variable("Term", 0.0);
		ArrayList<Term> terms = new ArrayList<Term>();
		terms.add(new Variable("Term1", 90.0));
		terms.add(new Variable("Term2", 1.0));
		terms.add(new Variable("Term3", 0.0));
		equation = new Equation(equationName);
		try {
			assertEquals(Math.PI / 2, (equation.solve(solveFor, terms)).getValue(), 0.01);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}