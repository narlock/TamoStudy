package resources;

import java.awt.Color;
import java.awt.Font;

/**
 * @author Anthony Narlock (narlock)
 * Theme, contains information about the Colors for current Theme
 */

public class Theme {
	
	/**
	 * Theme attributes
	 */
	public Color mainColor;
	public Color subColor;
	public Color layerColor;
	public Color textColor;
	public Color layerTextColor;
	
	public final Font fontPlainReg = new Font("Arial", Font.PLAIN, 24);
	public final Font fontBoldReg = new Font("Arial", Font.BOLD, 24);
	public final Font fontBoldRegSmall = new Font("Arial", Font.BOLD, 18);
	public final Font fontBoldRegLarge = new Font("Arial", Font.BOLD, 60);
	
	public String type;
	
	public Theme(int indicator) {
		switch (indicator) {
		  case 0:
		    mainColor = new Color(64,64,64); 
		    subColor = new Color(78,78,78);
		    layerColor = new Color(108, 108, 108);
		    textColor = Color.WHITE;
		    layerTextColor = new Color(153,153,153);
		    type = "Dark";
		    break;
		  case 1:
		    mainColor = new Color(220,220,220); 
		    subColor = new Color(240,240,240);
		    layerColor = Color.WHITE;
		    textColor = new Color(64,64,64); 
		    layerTextColor = Color.BLACK;
		    type = "Light";
		    break;
		  case 2:
		    mainColor = new Color(255,143,143); 
		    subColor = new Color(255,161,161);
		    layerColor = new Color(255,120,120);
		    textColor = Color.BLACK; 
		    layerTextColor = new Color(64,64,64); 
		    type = "Red";
		    break;
		  case 3:
		    mainColor = new Color(143,143,255); 
		    subColor = new Color(161,161,255);
		    layerColor = new Color(120,120,255);
		    textColor = Color.BLACK; 
		    layerTextColor = new Color(64,64,64); 
		    type = "Blue";
		    break;
		  case 4:
		    mainColor = new Color(143,255,143); 
		    subColor = new Color(161,255,161);
		    layerColor = new Color(120,255,120);
		    textColor = Color.BLACK; 
		    layerTextColor = new Color(64,64,64); 
		    type = "Green";
		    break;
		  case 5:
		    mainColor = new Color(255,225,143); 
		    subColor = new Color(255,255,161);
		    layerColor = new Color(255,255,120);
		    textColor = Color.BLACK; 
		    layerTextColor = new Color(64,64,64); 
		    type = "Yellow";
		    break;
		  case 6:
		    mainColor = new Color(255,219,143); 
		    subColor = new Color(255,219,161);
		    layerColor = new Color(255,219,120);
		    textColor = Color.BLACK; 
		    layerTextColor = new Color(64,64,64); 
		    type = "Orange";
		    break;
		  case 7:
		    mainColor = new Color(236,143,255); 
		    subColor = new Color(236,161,255);
		    layerColor = new Color(236,120,255);
		    textColor = Color.BLACK; 
		    layerTextColor = new Color(64,64,64); 
		    type = "Purple";
		    break;
		  default:
		    mainColor = new Color(64,64,64); 
		    subColor = new Color(78,78,78);
		    layerColor = new Color(108, 108, 108);
		    textColor = Color.WHITE;
		    layerTextColor = new Color(153,153,153);
		    type = "Dark";
		    break;
		}
	}
	
	public boolean checkEqualityWith(Theme other) {
		return this.mainColor.equals(other.mainColor);
	}
}
