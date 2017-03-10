package logic;
/*
 * EquationPage.java
 * 
 * 
 * 
 * @author Kyle Ringler
 * Created Feb 13, 2017
 */

public class EquationPage extends Page {

   private Topic topic;
   private Equation equation;
   
   public EquationPage(String name, Topic topic, Equation eq) {
     super(name);
     this.topic = topic;
     this.equation = eq;
   }
   
   public void display() {
     
   }
}
