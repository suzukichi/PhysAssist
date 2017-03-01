package logic;

public class BinaryOperator extends Operator
{
	private String value;
	
	public BinaryOperator(String value)
	{
		if (isBinaryOperator(value))
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
		return new Variable(result);
	}
	
	public String toString() {
		return value.toString();
	}
	
	public static boolean isBinaryOperator(String value) { // can move to Operator class if we choose to implement more ops...
		if ("*".equals(value) || "/".equals(value) || "+".equals(value) || "-".equals(value) || "^".equals(value)) {
			return true;
		}
		return false;
	}
	
}