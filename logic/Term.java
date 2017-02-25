package logic;

public class Term 
{
	protected double value;
	private String name, unit, description, symbol;
	
	
	public Term()
	{
		value = 0;
		name = "";
		unit = "";
		description = "";
		symbol = "";
	}
	
	public Term(double value)
	{
		this.value = value;
		name = "";
		unit = "";
		description = "";
		symbol = "";
	}
	
	public Term(double value, String name, String unit, String description, String symbol)
	{
		this.value = value;
		this.unit = unit;
		this.description = description;
		this.name = name;
		this.symbol = symbol;
	}
	
	public double getValue()
	{
		return value;
	}
	
	public String toString()
	{
		if (name.equals(""))
		{
			return Double.toString(value);
		}
		return name;
	}
}