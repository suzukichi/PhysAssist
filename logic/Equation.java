package logic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Equation {
	private String name;
	private int id;
	private String view;
	private String description;
	private String history;

	public Equation(String name)
	{
		this.name = name;
		getEquation();
	}

	private void getEquation()
	{
		String[] p_getEquation = {
		          DB.T_S, name
		       };

		String q_getEquation = "SELECT `id`, `view`, `description`, `history`, FROM `equations` WHERE `name` = ?";
		ArrayList<HashMap<String, String>> rows = (DB.getInstance()).query(q_getEquation, p_getEquation);
		
		for (HashMap<String, String> row : rows) 
		{
			this.id = Integer.parseInt(row.get("id"));
			this.view = row.get("view");
			this.description = row.get("description");
			this.history = row.get("history");
		}
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

	public Term solve(Term target, List<Term> terms) throws Exception
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
				throw new IllegalArgumentException("Invalid ast string.");
			}
		}
		AST equation = new AST(ast);
		return equation.compute();
	}

	private String getAST(Term term) throws IllegalArgumentException
	{
		String ast = "";
		String[] pGetAST = {
				  DB.T_I, String.valueOf(id),
		          DB.T_S, term.getName()
		       };

		String qGetAST = "SELECT `ast` FROM `ast` WHERE `eqid` = ?, `term` = ?";
		ArrayList<HashMap<String, String>> rows = (DB.getInstance()).query(qGetAST, pGetAST);
		
		for (HashMap<String, String> row : rows) 
		{
			ast = row.get("view");
		}
		if ("".equals(ast))
		{
			throw new IllegalArgumentException("Invalid ast string.");
		}
        return ast;
	}
}
