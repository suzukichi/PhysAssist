package guis;

import java.awt.Color;

import javax.swing.UIManager;

public final class StyleGuide {
	static Color headerMain = Color.decode("#F44336");
	static Color contentBackground = Color.decode("#FAFAFA");
	static Color background = Color.decode("#BDBDBD");
	static Color background2 = UIManager.getColor("Button.background");

	// Text colors:
	static Color header1 = Color.decode("#FFFFFF");
	static Color errorText = Color.decode("#FF0000");
   private StyleGuide() {
	   //not called
   }

}
