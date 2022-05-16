package resources;

import java.awt.Color;
import java.awt.Font;

public class Theme {
	
	public Color mainColor;
	public Color subColor;
	public Color layerColor;
	public Color textColor;
	public Color layerTextColor;
	public Font fontPlainReg;
	public Font fontBoldReg;
	
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
		}
		//Light Mode
		else if(indicator == 1) {
			mainColor = new Color(64,64,64); 
			subColor = new Color(78,78,78);
			layerColor = new Color(108, 108, 108);
			textColor = Color.WHITE;
			layerTextColor = new Color(153,153,153);
			fontPlainReg = new Font("Tahoma", Font.PLAIN, 24);
			fontBoldReg = new Font("Tahoma", Font.BOLD, 24);
		}
		//Classic Red
		else if(indicator == 2) {
			
		}
		//Classic Blue
		else if(indicator == 3) {
					
		}
		//Classic Green
		else if(indicator == 4) {
			
		}
		//Classic Yellow
		else if(indicator == 5) {
			
		}	
	}
	
	//Default constructor - for testing
	public Theme() {
		subColor = new Color(78,78,78);
		layerColor = new Color(108, 108, 108);
		textColor = Color.WHITE;
		fontPlainReg = new Font("Tahoma", Font.PLAIN, 24);
		fontBoldReg = new Font("Tahoma", Font.BOLD, 24);
	}
}
