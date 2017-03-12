package logic;

public class Constant implements Term {
	private String symbol;
	private double value;

	public Constant(String symbol)
	{
		this.symbol = symbol;
	}

	public double getValue()
	{
		//db lookup for constant name
		String valueString = "";
		String[] p_getConstantValue = {
		          DB.T_S, valueString,
		       };

		String q_getConstantValue = "SELECT `value`, FROM `constants` WHERE `symbol` = " + this.symbol;
		(new DB()).query(q_getConstantValue, p_getConstantValue);
		return normalizeValue(valueString);
	}
	
	private double normalizeValue(String valueString) 
	{
		String[] halves = valueString.split("E");
		if (halves.length == 2) {
			this.value = (checkNegative(halves[0])) * Math.pow(10, checkNegative(halves[1]));
		}
		else {
			this.value = checkNegative(halves[0]);
		}
		return value;
	}
	
	private double checkNegative(String string) {
		if ('-' == string.charAt(0))
		{
			return (0 - Double.parseDouble(string.substring(1, string.length())));
		}
		else {
			return Double.parseDouble(string);
		}
	}

	public String getName() {
		return symbol;
	}

	public String toString() {
		return symbol;
	}
}
