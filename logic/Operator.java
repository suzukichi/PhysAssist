package logic;

public abstract class Operator {
  
  protected String value;

  public abstract String toString();
  
  public static boolean isUnaryOperator(String value) { // can move to Operator class if we choose to implement more ops...
      if (value == "sin" || value == "cos" || value == "tan" || value == "log" || value == "abs") {
          return true;
      }
      return false;
  }
  
  public static boolean isBinaryOperator(String value) { // can move to Operator class if we choose to implement more ops...
    if ("*".equals(value) || "/".equals(value) || "+".equals(value) || "-".equals(value) || "^".equals(value)) {
        return true;
    }
    return false;
}
}
