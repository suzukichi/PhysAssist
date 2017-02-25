package logic;

public class Constant implements Term {
	private String name;
	
	public Constant(String name)
	{
		this.name = name;
	}
	
	public double getValue()
	{
		//db lookup for constant name
		return 0;
	}
	
	public String toString() {
		return name;
	}
}
