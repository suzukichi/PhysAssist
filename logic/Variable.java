package logic;

public class Variable implements Term
{
	private double value;
	
	public Variable(double value)
	{
		this.value = value;
	}
	
	public void setValue(double value)
	{
		this.value = value;
	}
	
	public double getValue()
	{
		return value;
	}
	
	public String toString() {
		return Double.toString(value);
	}
}