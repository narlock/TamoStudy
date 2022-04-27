package State;

import java.awt.*;
import java.awt.image.BufferedImage;

import javax.swing.*;

import java.io.*;
import javax.imageio.*;
import java.net.*;

public class TitleStrategy extends StateStrategy {
	private ImageIcon heroImage = new ImageIcon(getClass().getClassLoader().getResource("TITLE_SMALL.gif")); //Import image;
	
	@Override
	public void setPanel() {
		this.setBackground(new Color(64,64,64));
		
	}

	@Override
	public void setActions() {
		// TODO Auto-generated method stub
		
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		
		heroImage.paintIcon(this, g, 200, 100);
		
		g.setFont(new Font("Tahoma", Font.BOLD, 16));
		g.setColor(new Color(153,153,153));
		g.drawString("Never give up!", 333, 500);
	}
	
	

}
