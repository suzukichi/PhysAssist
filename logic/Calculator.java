/*Shiv Sulkar Calculator Class*/

package logic;
import java.awt.*;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.swing.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class Calculator extends JFrame implements ActionListener {
    public boolean Radians = true;  
    public String expression = ""; 
    boolean resultShown=false;
    JPanel[] rows = new JPanel[7];
    String[] buttonNames = {   "(",   ")",   "pow", "sqt",   "C",
    		                 "sin", "cos", "tan",   "/", "var",
    		                   "7",   "8",   "9",   "*",  "PI",
    		                   "4",   "5",   "6",   "-",  "deg",
    		                   "3",   "2",   "1",   "+",  "B2",
    		                   "0",   ".",   "-",   ",",  "="};
    JButton[] buttons = new JButton[buttonNames.length];
    Dimension buttonDim = new Dimension(60,50);
    JTextArea display = new JTextArea(10,30);
    Font font = new Font("Times new Roman", Font.BOLD, 14);
    
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
        for(int i = 0; i < buttons.length; i++){
            buttons[i].setPreferredSize(buttonDim);
        }
        rows[0].add(display);
        add(rows[0]);
        
        for(int i = 0; i < 5; i++)
            rows[1].add(buttons[i]);
        add(rows[1]);
        
        for(int i = 5; i < 10; i++)
            rows[2].add(buttons[i]);
        add(rows[2]);
        
        for(int i = 10; i < 15; i++)
            rows[3].add(buttons[i]);
        add(rows[3]);
        
        for(int i = 15; i < 20; i++)
            rows[4].add(buttons[i]);
        add(rows[4]);
        
        for(int i = 20; i < 25; i++)
            rows[5].add(buttons[i]);
        add(rows[5]);
        
        for(int i = 25; i < 30; i++)
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
    
    public double getResult() {
    	double result = 0;
		ScriptEngine engine = new ScriptEngineManager().getEngineByExtension("js");
		 try {
			 result = Double.parseDouble((engine.eval(expression).toString()));
			 display.setText(Double.toString(result));
			 expression = "";
			 
	     }
		 catch (ScriptException e) {
			 display.setText("error");
			 expression = "";
	     }
		 resultShown=true;
		 return result;
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
    	if(resultShown==true){
    		this.clear();
    		resultShown=false;
    	}
    	if(ae.getSource()==buttons[2]){
    		display.append("pow(");
    		expression = expression+"Math.pow(";
    	}
    	else if(ae.getSource()==buttons[3]){
    		display.append("sqr(");
    		expression = expression+"Math.sqrt(";
    	}
    	else if(ae.getSource()==buttons[4]){
    		this.clear();
    	}
    	else if(ae.getSource()==buttons[5]){
    		display.append("sin(");
    		if(Radians==true){
    			expression = expression+"Math.sin(";
    		}
    		else{
    			expression = expression+"Math.sin((1/(180/Math.PI))*";
    		}
    	}
    	else if(ae.getSource()==buttons[6]){
    		display.append("cos(");
    		if(Radians==true){
    			expression = expression+"Math.cos(";
    		}
    		else{
    			expression = expression+"Math.cos((1/(180/Math.PI))*";
    		}
    	}
    	else if(ae.getSource()==buttons[7]){
    		display.append("tan(");
    		if(Radians==true){
    			expression = expression+"Math.tan(";
    		}
    		else{
    			expression = expression+"Math.tan((1/(180/Math.PI))*";
    		}
    	}
    	else if(ae.getSource()==buttons[14]){
    		display.append("PI");
    		expression = expression+"Math.PI";
    	}
    	else if(ae.getSource()==buttons[19]){
    		if(Radians==true){
    			buttons[19].setBackground(new Color(0,200,0));
    			Radians=false;
    		}
    		else{
    			buttons[19].setBackground(new Color(200, 50, 40));
    			Radians=true;
    		}
    	}
    	else if(ae.getSource() == buttons[29]){
            if(!expression.isEmpty()){
            	getResult();
            }
    	}
    	else{
    		for(int i = 0; i<buttons.length;i++){
    			if(ae.getSource()==buttons[i]){
    				display.append(buttonNames[i]);
    				expression = expression+buttonNames[i];
    				return;
    			}
    		}
    	}
    }
}
