package State;

import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.*;

import java.io.*;
import javax.imageio.*;
import java.net.*;

/**
 * @author Anthony Narlock
 * TitleStrategy
 * 
 * This is a concrete StateStrategy which is a JPanel
 * that will display the user interface for Title Card
 */

public class TitleStrategy extends StateStrategy {
	//Hero image
	private ImageIcon heroImage = new ImageIcon(getClass().getClassLoader().getResource("TITLE_SMALL.gif")); //Import image;
	
	@Override
	public void setPanel() {
		//Set the background color
		this.setBackground(new Color(78,78,78));
	}

	@Override
	public void setActions() {
		// TODO Auto-generated method stub
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		
		//Draw the main hero image
		heroImage.paintIcon(this, g, 200, 100);
		
		//Never give up text drawing
		g.setFont(new Font("Tahoma", Font.BOLD, 16));
		g.setColor(new Color(153,153,153));
		g.drawString("Never give up!", 333, 500);
	}
	
	

}
