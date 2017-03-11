package logic;

public class Variable implements Term
{
	private double value;
	private String name;
	
	public Variable(double value)
	{
		this.value = value;
	}
	
	public Variable(String name, double value)
	{
		this.value = value;
		this.name = name;
	}

	public void setValue(double value)
	{
		this.value = value;
	}

	public double getValue()
	{
		return value;
	}
	
	public String getName()
	{
		return name;
	}

	public String toString() {
		return Double.toString(value);
	}
}