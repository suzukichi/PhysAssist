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
		case "cos":
			result = Math.cos(l);
			break;
		case "tan":
			result = Math.tan(l);
			break;
		case "log": // add ln with Math.log(l) .. add to BinOp class and Operator static isBinaryOperator
			result = Math.log10(l);
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
