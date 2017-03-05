package logic;

public class BinaryOperator extends Operator
{
	
	public BinaryOperator(String value)
	{
			this.value = value;
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
				if (right == 0) 
				{
					throw new Exception("Divide by zero.");
				}
				result = left / right;
				break;
			case "^":
				result = Math.pow(left, right);
				break;
			default:
				throw new Exception("Operation could not be performed");
		}
		return new Variable(result);
	}
	
}