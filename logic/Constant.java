package logic;

import java.util.HashMap;
import java.util.List;

public class Constant implements Term 
{
	private String symbol;

	public Constant(String symbol)
	{
		this.symbol = symbol;
	}

	@Override
	public double getValue()
	{
		String valueString = "";
		String[] pGetConstantValue = {
		          DB.T_S, symbol,
		       };

		String qGetConstantValue = "SELECT `value`, FROM `constants` WHERE `symbol` = ?";
		List<HashMap<String, String>> rows = DB.getInstance().query(qGetConstantValue, pGetConstantValue);
		
		for (HashMap<String, String> row : rows) 
		{
			valueString = row.get("value");
		}
		
		return checkNegative(valueString);
	}
	
	private double checkNegative(String string) 
	{
		if ('-' == string.charAt(0))
		{
			return 0 - Double.parseDouble(string.substring(1, string.length()));
		}
		else 
		{
			return Double.parseDouble(string);
		}
	}

	@Override
	public String getName() 
	{
		return symbol;
	}

	@Override
	public String toString() 
	{
		return symbol;
	}
}
