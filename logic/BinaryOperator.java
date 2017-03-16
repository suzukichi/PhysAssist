package logic;

public class BinaryOperator extends Operator
{
	
	public BinaryOperator(String value)
	{
			this.value = value;
	}
	
	public Term perform(Term l, Term r) throws IllegalArgumentException, ArithmeticException
	{
		double left = l.getValue();
		double right = r.getValue();
		double result;
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
				if ((int)(Math.ceil(right)) == 0) 
					throw new ArithmeticException("Divide by zero.");
				result = left / right;
				break;
			case "^":
				result = Math.pow(left, right);
				break;
			default:
				throw new IllegalArgumentException("Operation could not be performed");
		}
		return new Variable(result);
	}
	
}