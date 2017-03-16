package logic;

public class UnaryOperator extends Operator {

	public UnaryOperator(String value) 
	{
		this.value = value;
	}

	public Term perform(Term left) throws IllegalArgumentException 
	{
		double l = left.getValue();
		double result;
		switch (value) 
		{
			case "sin":
				result = Math.sin(l);
				break;
			case "cos":
				result = Math.cos(l);
				break;
			case "tan":
				result = Math.tan(l);
				break;
			case "log":
				result = Math.log10(l);
				break;
			case "ln":
				result = Math.log(l);
				break;
			case "abs":
				result = Math.abs(l);
				break;
			case "deg":
				result = Math.toRadians(l);
				break;
			default:
				throw new IllegalArgumentException("Unary Operator " + value + " could not be performed.");
		}
		return new Variable(result);
	}
}
