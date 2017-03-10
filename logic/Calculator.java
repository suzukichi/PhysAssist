package logic;
/*Shiv Sulkar*/

import java.awt.*;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.swing.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class Calculator extends JFrame implements ActionListener {
    
    JPanel[] rows = new JPanel[7];
    JButton[] buttons = new JButton[24];
    String[] buttonNames = { "(",   ")",   "^",   "C",
    		                 "sin", "cos", "tan", "/",
    		                 "7",   "8",   "9",   "x",
    		                 "4",   "5",   "6",   "-",
    		                 "3",   "2",   "1",   "+",
    		                 "0",   ".",   "-",   "="};
    Dimension buttonDim = new Dimension(50,50);
    //Dimension screenDim = new Dimension(50,50);
    JTextArea display = new JTextArea(10,30);
    Font font = new Font("Times new Roman", Font.BOLD, 14);
    String expression = ""; 
    
    public Calculator() {
        super("Calculator");
        setDesign();
        setSize(400, 700);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        GridLayout grid = new GridLayout(10,10);
        setLayout(grid);   
        
        FlowLayout f1 = new FlowLayout(FlowLayout.CENTER);
        FlowLayout f2 = new FlowLayout(FlowLayout.CENTER,1,1);
        
        for(int i = 0; i < rows.length; i++){
            rows[i] = new JPanel();
            rows[i].setBackground(new Color(200, 0, 0));
        }
        rows[0].setLayout(f1);
        for(int i = 1; i < rows.length; i++){
            rows[i].setLayout(f2);
        }
        
        for(int i = 0; i < buttons.length; i++) {
            buttons[i] = new JButton();
            buttons[i].setText(buttonNames[i]);
            buttons[i].setFont(font);
            buttons[i].addActionListener(this);
            buttons[i].setBackground(new Color(200, 50, 40));
        }
        
        display.setFont(font);
        display.setEditable(false);
        //display.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        //display.setPreferredSize(screenDim);
        for(int i = 0; i < buttons.length; i++){
            buttons[i].setPreferredSize(buttonDim);
        }
        rows[0].add(display);
        add(rows[0]);
        
        for(int i = 0; i < 4; i++)
            rows[1].add(buttons[i]);
        add(rows[1]);
        
        for(int i = 4; i < 8; i++)
            rows[2].add(buttons[i]);
        add(rows[2]);
        
        for(int i = 8; i < 12; i++)
            rows[3].add(buttons[i]);
        add(rows[3]);
        
        for(int i = 12; i < 16; i++)
            rows[4].add(buttons[i]);
        add(rows[4]);
        
        for(int i = 16; i < 20; i++)
            rows[5].add(buttons[i]);
        add(rows[5]);
        
        for(int i = 20; i < 24; i++)
            rows[6].add(buttons[i]);
        add(rows[6]);
        
        setVisible(true);
    }
    
    public void clear() {
    	try {
    		display.setText("");
    		expression = "";
    	} 
    	catch(NullPointerException e) {  
    	}	
    }
    
    public void getResult() {
		ScriptEngine engine = new ScriptEngineManager().getEngineByExtension("js");
		 try {
			 double result = Double.parseDouble((engine.eval(expression).toString()));
			 display.setText(Double.toString(result));
			 expression = "";
	     }
		 catch (ScriptException e) {
			 display.setText("error");
			 expression = "";
	     }
    }
    
    public final void setDesign() {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } 
        catch(Exception e) {   
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
    	 if(ae.getSource() == buttons[0]){
             display.append(buttonNames[0]);
             expression = expression+buttonNames[0];
    	 }
    	 else if(ae.getSource() == buttons[1]){
             display.append(buttonNames[1]);
             expression = expression+buttonNames[1];
    	 }
    	 else if(ae.getSource() == buttons[2]){
    		 display.append(buttonNames[2]);
             expression = expression+buttonNames[2];
    	 }
    	 else if(ae.getSource() == buttons[3]){
             this.clear();
    	 }
    	 else if(ae.getSource() == buttons[4]){
             display.append("Math."+buttonNames[4]+"(");
             expression = expression+"Math."+buttonNames[4]+"(";
    	 }
    	 else if(ae.getSource() == buttons[5]){
             display.append("Math."+buttonNames[5]+"(");
             expression = expression+"Math."+buttonNames[5]+"(";
    	 }
    	 else if(ae.getSource() == buttons[6]){
             display.append("Math."+buttonNames[6]+"(");
             expression = expression+"Math."+buttonNames[6]+"(";
    	 }
    	 else if(ae.getSource() == buttons[7]){
             display.append(buttonNames[7]);
             expression = expression+buttonNames[7];
    	 }
    	 else if(ae.getSource() == buttons[8]){
             display.append(buttonNames[8]);
             expression = expression+buttonNames[8];
    	 }
    	 else if(ae.getSource() == buttons[9]){
             display.append(buttonNames[9]);
             expression = expression+buttonNames[9];
    	 }
    	 else if(ae.getSource() == buttons[10]){
             display.append(buttonNames[10]);
             expression = expression+buttonNames[10];
    	 }
    	 else if(ae.getSource() == buttons[11]){
             display.append(buttonNames[11]);
             expression = expression+"*";
    	 }
    	 else if(ae.getSource() == buttons[12]){
             display.append(buttonNames[12]);
             expression = expression+buttonNames[12];
    	 }
    	 else if(ae.getSource() == buttons[13]){
             display.append(buttonNames[13]);
             expression = expression+buttonNames[13];
    	 }
    	 else if(ae.getSource() == buttons[14]){
             display.append(buttonNames[14]);
             expression = expression+buttonNames[14];
    	 }
    	 else if(ae.getSource() == buttons[15]){
             display.append(buttonNames[15]);
             expression = expression+buttonNames[15];
    	 }
    	 else if(ae.getSource() == buttons[16]){
             display.append(buttonNames[16]);
             expression = expression+buttonNames[16];
    	 }
    	 else if(ae.getSource() == buttons[17]){
             display.append(buttonNames[17]);
             expression = expression+buttonNames[17];
    	 }
    	 else if(ae.getSource() == buttons[18]){
             display.append(buttonNames[18]);
             expression = expression+buttonNames[18];
    	 }
    	 else if(ae.getSource() == buttons[19]){
             display.append(buttonNames[19]);
             expression = expression+buttonNames[19];
    	 }
    	 else if(ae.getSource() == buttons[20]){
             display.append(buttonNames[20]);
             expression = expression+buttonNames[20];
    	 }
    	 else if(ae.getSource() == buttons[21]){
             display.append(buttonNames[21]);
             expression = expression+buttonNames[21];
    	 }
    	 else if(ae.getSource() == buttons[22]){
             display.append(buttonNames[22]);
             expression = expression+buttonNames[22];
    	 }
    	 else if(ae.getSource() == buttons[23]){
             if(!expression.isEmpty()){
            	 getResult();
             }
    	 }
    }
    
    public static void main(String[] args) {
        @SuppressWarnings("unused")
		Calculator c = new Calculator();
    }
}
