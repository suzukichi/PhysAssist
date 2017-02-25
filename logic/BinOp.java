package logic;

public class BinOp
{
	private Character value;
	
	public BinOp(Character value)
	{
		if (isBinOperator(value))
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
			case '+': 
				result = left + right;
				break;
			case '-':
				result = left - right;
				break;
			case '*':
				result = left * right;
				break;
			case '/':
				result = left / right;
				break;
			default:
				throw new Exception("Operation could not be performed");
		}
		return new Variable(result);
	}
	
	public String getValue() {
		return value.toString();
	}
	
	public static boolean isBinOperator(Character value) { // can move to Operator class if we choose to implement more ops...
		if (value == '*' || value == '/' || value == '+' || value == '-') {
			return true;
		}
		return false;
	}
	
}