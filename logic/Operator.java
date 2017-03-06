package logic;

public abstract class Operator {

	protected String value;

	public String toString()
	{
		return value;
	}

	public static boolean isUnaryOperator(String value) 
	{
		if ("sin".equals(value) || "sinh".equals(value) || "asin".equals(value)
				|| "cos".equals(value) || "cosh".equals(value) || "acos".equals(value)
				|| "tan".equals(value) || "tanh".equals(value) || "atan".equals(value)
				|| "log".equals(value) || "ln".equals(value) || "abs".equals(value) || "deg".equals(value)) 
		{
			return true;
		}
		return false;
	}

	public static boolean isBinaryOperator(String value) 
	{
		if ("*".equals(value) || "/".equals(value) || "+".equals(value) || "-".equals(value) || "^".equals(value)) 
		{
			return true;
		}
		return false;
	}
}
