/*Shiv Sulkar Calculator Class*/

package logic;
import java.awt.*;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.swing.*;
import java.awt.event.*;
import java.util.logging.*;

@SuppressWarnings("serial")
public class Calculator extends JFrame implements ActionListener {
    
	private boolean rad = true;  
    private String expression = ""; 
    private boolean resultShown=false;
    private JPanel[] rows = new JPanel[7];
    private String[] buttonNames = {   "(",   ")",   "pow", "sqt",   "C",
    		                 "sin", "cos", "tan",   "/", "var",
    		                   "7",   "8",   "9",   "*",  "PI",
    		                   "4",   "5",   "6",   "-",  "deg",
    		                   "3",   "2",   "1",   "+",  "tmp",
    		                   "0",   ".",   "-",   ",",  "="};
    private JButton[] buttons = new JButton[buttonNames.length];
    private Dimension buttonDim = new Dimension(60,50);
    private JTextArea display = new JTextArea(10,30);
    private Font f = new Font("Times new Roman", Font.BOLD, 14);
    private FlowLayout f1 = new FlowLayout(FlowLayout.CENTER);
    private FlowLayout f2 = new FlowLayout(FlowLayout.CENTER,1,1);
	
    public Calculator() {
    	super("Calculator");
    	initCalcFrame();
        display.setFont(f);
        display.setEditable(false);
        initButtons(buttonNames.length);
        setVisible(true);
    }
    
    public int initButtons(int bSize){
    	int i;
    	int r=0;
    	rows[0] = new JPanel();
        rows[0].setBackground(new Color(200, 0, 0));
        rows[0].setLayout(f1);
        rows[0].add(display);
        add(rows[0]);
    	// Loop tested in test/TestLoopCalculator.java
        for(i=0; i < bSize; i++){
        	if(i%5==0){
        		r++;
        		rows[r] = new JPanel();
                rows[r].setBackground(new Color(200, 0, 0));
        	}
        	initButtonsHelper(r,i);
        }
        add(rows[1]);
        add(rows[2]);
        add(rows[3]);
        add(rows[4]);
        add(rows[5]);
        add(rows[6]);
        return i;
    }   
    
    public void initButtonsHelper(int r, int i){
    	rows[r].setLayout(f2);
    	buttons[i] = new JButton();
    	buttons[i].setPreferredSize(buttonDim);
        buttons[i].setText(buttonNames[i]);
        buttons[i].setFont(f);
        buttons[i].addActionListener(this);
        buttons[i].setBackground(new Color(200, 50, 40));
    	rows[r].add(buttons[i]);
    }
    
    public void initCalcFrame(){
        setDesign();
        setSize(400, 700);
        setBounds(0,0,500,700);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        GridLayout grid = new GridLayout(7,5);
        setLayout(grid);   
    }
    
    public void clear() {
    	Logger log = Logger.getLogger("clear");
    	try {
    		display.setText("");
    		expression = "";
    	} 
    	catch(NullPointerException e) { 
    		log.log(Level.FINE, "setText is not present", e);
    	}	
    }
    
    public double getResult() {
    	Logger log = Logger.getLogger("results");
    	double result = 0;
		ScriptEngine engine = new ScriptEngineManager().getEngineByExtension("js");
		 try {
			 result = Double.parseDouble(engine.eval(expression).toString());
			 display.setText(Double.toString(result));
			 expression = "";
			 
	     }
		 catch (ScriptException e) {
			 display.setText("error");
			 expression = "";
			 log.log(Level.FINE, "Illegal operations", e);
	     }
		 resultShown=true;
		 return result;
    }
    
    public final void setDesign() {
    	Logger log = Logger.getLogger("design");
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } 
        catch(Exception e) {
        	log.log(Level.FINE, "look and feel not available", e);
        }
    }
    
    public int iTrig(ActionEvent ae){
    	int out = 0;
    	if(ae.getSource()==buttons[5]){
    		out = 5;
    	}
    	if(ae.getSource()==buttons[6]){
    		out = 6;
    	}
        if(ae.getSource()==buttons[7]){
    		out = 7;
    	}
    	return out;
    }
    
    public void getTrig(ActionEvent ae){
    	int i = iTrig(ae);
   		display.append(buttonNames[i]+"(");
   		if(rad){
   			expression = expression+"Math."+buttonNames[i]+"(";
   		}
   		else{
    		expression = expression+"Math."+buttonNames[i]+"("+"(1/(180/Math.PI))*";
    	}
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
    	if(resultShown){
    		this.clear();
    		resultShown=false;
    	}
    	if(ae.getSource()==buttons[2]){
    		display.append("pow(");
    		expression = expression+"Math.pow(";
    	}
    	else if(ae.getSource()==buttons[3]){
    		display.append("sqrt(");
    		expression = expression+"Math.sqrt(";
    	}
    	else if(ae.getSource()==buttons[4]){
    		this.clear();
    	}
    	else if(iTrig(ae)!=0){
    		getTrig(ae);
    	}
    	else if(ae.getSource()==buttons[14]){
    		display.append("PI");
    		expression = expression+"Math.PI";
    	}
    	else if(ae.getSource()==buttons[19]){
    		radSwitch();
    	}
    	else if(ae.getSource() == buttons[29]){
            if(!expression.isEmpty()){
            	getResult();
            }
    	}
    	else{
    		anyOtherButton(((JButton)ae.getSource()).getText());
    	}
    }
    
    public void radSwitch(){
    	if(rad){
			buttons[19].setBackground(new Color(0,200,0));
			rad=false;
		}
		else{
			buttons[19].setBackground(new Color(200, 50, 40));
			rad=true;
		}
    }
    // Loop tested in test/TestLoopCalculatorOther.java
    public int anyOtherButton(String ae){
    	int i;
    	for(i = 0; i<buttonNames.length;i++){
			if(buttonNames[i].equals(ae)){
				display.append(buttonNames[i]);
				expression = expression+buttonNames[i];
				return i;
			}
		}
    	return i;
    }
    
    public String getExpression(){
    	return expression;
    }
    
    public void setExpression(String e){
    	expression = e;
    }
    public void setButtonNames(String[] names){
    	buttonNames = names;
    }
}
