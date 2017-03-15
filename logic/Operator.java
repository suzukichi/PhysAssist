package logic;

import java.util.HashMap;
import java.util.Map;

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
			case "cos":
			case "tan":
			case "log":
			case "ln":
			case "abs":
			case "deg":
				return true;
			default:
				return false;				
		}
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
