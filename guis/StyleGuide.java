package guis;

import java.awt.Color;

import javax.swing.UIManager;

public final class StyleGuide {

   private StyleGuide() {
	   //not called
   }
   static Color headerMain = Color.decode("#F44336");
   static Color contentBackground = Color.decode("#FAFAFA");
   static Color background = Color.decode("#BDBDBD");
   static Color background2 = UIManager.getColor("Button.background");

   // Text colors:
   static Color header1 = Color.decode("#FFFFFF");
   static Color errorText = Color.decode("#FF0000");
}
