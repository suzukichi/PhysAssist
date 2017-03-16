package test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import logic.Equation;
import logic.Term;
import logic.Variable;

/*
 * TestEquation.java
 * 
 * Test class that tests the Equation class.
 * Integration Testing: Equation.java, DB.java, Term.java, Variable.java, AST.java
 * 
 * @author Arianna Olson
 */
public class TestEquation {
   private Equation equation;
   private static final long EQUATION_1 = 1;

   /*
    * Integration test: Equation.java, DB.java, Variable.java, Term.java,
    * AST.java
    */
   @Test
   public void TestEquationSolve() throws Exception {
      String equationName = "Newton's Second Law of Motion";
      Term solveFor = new Variable("F", 0.0);
      ArrayList<Term> terms = new ArrayList<Term>();
      terms.add(new Variable("m", 9.0));
      terms.add(new Variable("a", 5.0));
      equation = new Equation(EQUATION_1);
      assertEquals(42.0, (equation.solve(solveFor, terms)).getValue(), 0.01);
   }

   /*
    * Integration test: Equation.java, DB.java
    */
   @Test
   public void TestEquationGetView() {
      String equationName = "Newton's Second Law of Motion";
      String expectedView = "F = m * a";

      Equation eq = new Equation(EQUATION_1);
      assertEquals(expectedView, eq.getView());
   }

   @Test
   public void TestEquationGetDescription() {
      String equationName = "Newton's Second Law of Motion";
      String expectedDescription = "The force (F) acting on an object is equal to the mass (m) of an object times its acceleration (a).";

      Equation eq = new Equation(EQUATION_1);
      assertEquals(expectedDescription, eq.getDescription());
   }

   @Test
   public void TestEquationGetHistory() {
      String equationName = "Newton's Second Law of Motion";
      String expectedHistory = "Isaac Newton's laws of motion were first set down in his Principia Mathematica Philosophiae Naturalis in 1687.";

      Equation eq = new Equation(EQUATION_1);
      assertEquals(expectedHistory, eq.getHistory());
   }
}