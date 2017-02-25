package logic;

public class BinOp
{
	private String value;
	
	public BinOp(String value)
	{
		if (value == "*" || value == "/" || value == "+" || value == "-")
		{
			this.value = value;
		}
		else
		{
			throw new IllegalArgumentException("Invalid operation");
		}
	}
	
	public Term perform(Term l, Term r) throws Exception
	{
		double left = l.getValue();
		double right = r.getValue();
		double result = 0;
		switch (value)
		{
			case "+": 
				result = left + right;
				break;
			case "-":
				result = left - right;
				break;
			case "*":
				result = left * right;
				break;
			case "/":
				result = left / right;
				break;
			default:
				throw new Exception("Operation could not be performed");
		}
		return new Term(result);
	}
	
	public String getValue() {
		return value;
	}
	
}