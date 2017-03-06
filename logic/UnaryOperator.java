package logic;

public class UnaryOperator extends Operator {

	public UnaryOperator(String value) 
	{
		this.value = value;
	}

	public Term perform(Term left) throws Exception 
	{
		double l = left.getValue();
		double result = 0;
		switch (value) 
		{
			case "sin":
				result = Math.sin(l);
				break;
			case "sinh":
			    result = Math.sinh(l);
			    break;
			case "asin":
			    result = Math.asin(l);
			    break;
			case "cos":
				result = Math.cos(l);
				break;
			case "cosh":
			    result = Math.cosh(l);
			    break;
			case "acos":
				result = Math.acos(l);
				break;
			case "tan":
				result = Math.tan(l);
				break;
			case "tanh":
				result = Math.tanh(l);
				break;
			case "atan":
				result = Math.atan(l);
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
				throw new Exception("Unary Operator " + value + " could not be performed.");
		}
		return new Variable(result);
	}
}
