package logic;

public class Constant implements Term { //write DB lookup with scientific notation conversion and e and pi stuff
	private String symbol;
	private double value;

	public Constant(String symbol)
	{
		this.symbol = symbol;
	}

	@Override
	public double getValue()
	{
		//db lookup for constant name
		String valueString = "";
		String[] pGetConstantValue = {
		          DB.T_S, valueString,
		       };

		String qGetConstantValue = "SELECT `value`, FROM `constants` WHERE `symbol` = " + this.symbol;
		new DB().query(qGetConstantValue, pGetConstantValue);
		return checkNegative(valueString);
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

	@Override
	public String getName() {
		return symbol;
	}

	@Override
	public String toString() {
		return symbol;
	}
}
