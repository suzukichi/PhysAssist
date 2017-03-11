package logic;

import java.util.ArrayList;

public class Equation {
  private String name;
  private int id;
  private String view;
  private String description;
  private String history;
  private ArrayList<Term> terms;
  
  public Equation(String name) {
    this.name = name;
  }

	
	public Equation(String name)
	{
		this.name = name;
		getEquation();
	}
	
	public void getEquation()
	{
		String[] p_getEquation = {
		          DB.T_I, String.valueOf(this.id),
		          DB.T_S, this.view,
		          DB.T_S, this.description,
		          DB.T_S, this.history 
		       };

		String q_getEquation = "SELECT `id`, `view`, `description`, `history`, FROM `equation` WHERE `name` = " + this.name;
        (new DB()).query(q_getEquation, p_getEquation);
	}
	
	public String getView()
	{
		return view;
	}
	
	public String getDescription()
	{
		return description;
	}
	
	public String getHistory()
	{
		return history;
	}
	
	public Term solve(Term target, ArrayList<Term> terms) throws Exception
	{
		String ast = getAST(target);
		for (int i = 0; i < terms.size(); i++)
		{
			String[] halves = ast.split((terms.get(i)).getName());
			if (halves.length == 2)
			{
				ast = halves[0] + (terms.get(i)).getValue() + halves[1];
			}
			else
			{
				throw new Exception("Invalid ast string.");
			}
		}
		AST equation = new AST(ast);
		return equation.compute();
	}
	
	private String getAST(Term term) throws Exception
	{
		String ast = "";
		String[] p_getAST = {
		          DB.T_S, ast 
		       };

		String q_getAST = "SELECT `ast` FROM `ast` WHERE `eqid` = " + this.id + ", `term` = " + term;
        (new DB()).query(q_getAST, p_getAST);
        return ast;
	}
}
