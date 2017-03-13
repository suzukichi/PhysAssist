package logic;

public abstract class Operator {

	protected String value;

	@Override
	public String toString()
	{
		return value;
	}

	public static boolean isUnaryOperator(String value) 
	{
		switch (value)
		{
			case "sin":
			case "sinh":
			case "asin":
			case "cos":
			case "cosh":
			case "acos":
			case "tan":
			case "tanh":
			case "atan":
			case "log":
			case "ln":
			case "abs":
			case "deg":
				return true;
			default:
				return false;
				
		}
		/*if ("sin".equals(value) || "sinh".equals(value) || "asin".equals(value)
				|| "cos".equals(value) || "cosh".equals(value) || "acos".equals(value)
				|| "tan".equals(value) || "tanh".equals(value) || "atan".equals(value)
				|| "log".equals(value) || "ln".equals(value) || "abs".equals(value) || "deg".equals(value)) 
		{
			return true;
		}
		return false;*/
	}

	public static boolean isBinaryOperator(String value) 
	{
		switch(value)
		{
			case "atan":
			case "log":
			case "ln":
			case "abs":
			case "deg":
				return true;
			default:
				return false;
		}
		/*if ("*".equals(value) || "/".equals(value) || "+".equals(value) || "-".equals(value) || "^".equals(value)) 
		{
			return true;
		}
		return false;*/
	}
}
