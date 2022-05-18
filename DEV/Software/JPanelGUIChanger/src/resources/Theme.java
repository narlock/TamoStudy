package resources;

import java.awt.Color;
import java.awt.Font;

public class Theme {
	
	/**
	 * Theme attributes
	 */
	public Color mainColor;
	public Color subColor;
	public Color layerColor;
	public Color textColor;
	public Color layerTextColor;
	public Font fontPlainReg;
	public Font fontBoldReg;
	
	public String type;
	
	public Theme(int indicator) {
		//Dark Mode
		if(indicator == 0) {
			mainColor = new Color(64,64,64); 
			subColor = new Color(78,78,78);
			layerColor = new Color(108, 108, 108);
			textColor = Color.WHITE;
			layerTextColor = new Color(153,153,153);
			fontPlainReg = new Font("Tahoma", Font.PLAIN, 24);
			fontBoldReg = new Font("Tahoma", Font.BOLD, 24);
			type = "Dark";
		}
		//Light Mode
		else if(indicator == 1) {
			mainColor = new Color(220,220,220); 
			subColor = new Color(240,240,240);
			layerColor = Color.WHITE;
			textColor = new Color(64,64,64); 
			layerTextColor = Color.BLACK;
			fontPlainReg = new Font("Tahoma", Font.PLAIN, 24);
			fontBoldReg = new Font("Tahoma", Font.BOLD, 24);
			type = "Light";
		}
		//Classic Red
		else if(indicator == 2) {
			mainColor = new Color(255,143,143); 
			subColor = new Color(255,161,161);
			layerColor = new Color(255,120,120);
			textColor = Color.BLACK; 
			layerTextColor = new Color(64,64,64); 
			fontPlainReg = new Font("Tahoma", Font.PLAIN, 24);
			fontBoldReg = new Font("Tahoma", Font.BOLD, 24);
			type = "Red";
		}
		//Classic Blue
		else if(indicator == 3) {
			mainColor = new Color(143,143,255); 
			subColor = new Color(161,161,255);
			layerColor = new Color(120,120,255);
			textColor = Color.BLACK; 
			layerTextColor = new Color(64,64,64); 
			fontPlainReg = new Font("Tahoma", Font.PLAIN, 24);
			fontBoldReg = new Font("Tahoma", Font.BOLD, 24);
			type = "Blue";
		}
		//Classic Green
		else if(indicator == 4) {
			mainColor = new Color(143,255,143); 
			subColor = new Color(161,255,161);
			layerColor = new Color(120,255,120);
			textColor = Color.BLACK; 
			layerTextColor = new Color(64,64,64); 
			fontPlainReg = new Font("Tahoma", Font.PLAIN, 24);
			fontBoldReg = new Font("Tahoma", Font.BOLD, 24);
			type = "Green";
		}
		//Classic Yellow
		else if(indicator == 5) {
			mainColor = new Color(255,225,143); 
			subColor = new Color(255,255,161);
			layerColor = new Color(255,255,120);
			textColor = Color.BLACK; 
			layerTextColor = new Color(64,64,64); 
			fontPlainReg = new Font("Tahoma", Font.PLAIN, 24);
			fontBoldReg = new Font("Tahoma", Font.BOLD, 24);
			type = "Yellow";
		}	
		//Classic Orange
		else if(indicator == 6) {
			mainColor = new Color(255,219,143); 
			subColor = new Color(255,219,161);
			layerColor = new Color(255,219,120);
			textColor = Color.BLACK; 
			layerTextColor = new Color(64,64,64); 
			fontPlainReg = new Font("Tahoma", Font.PLAIN, 24);
			fontBoldReg = new Font("Tahoma", Font.BOLD, 24);
			type = "Orange";
		}
		//Classic Purple
		else if(indicator == 7) {
			mainColor = new Color(236,143,255); 
			subColor = new Color(236,161,255);
			layerColor = new Color(236,120,255);
			textColor = Color.BLACK; 
			layerTextColor = new Color(64,64,64); 
			fontPlainReg = new Font("Tahoma", Font.PLAIN, 24);
			fontBoldReg = new Font("Tahoma", Font.BOLD, 24);
			type = "Purple";
		}	
	}
	
	public boolean checkEqualityWith(Theme other) {
		return this.mainColor.equals(other.mainColor);
	}
}
