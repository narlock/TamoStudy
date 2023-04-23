package resources;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

import components.border.BubbleBorder;

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
	public Color altTextColor;
	
	public final Font fontPlainReg = new Font("Arial", Font.PLAIN, 24);
	public final Font fontBoldReg = new Font("Arial", Font.BOLD, 24);
	public final Font fontBoldRegSmall = new Font("Arial", Font.BOLD, 18);
	public final Font fontBoldRegLarge = new Font("Arial", Font.BOLD, 60);
	
	public String type;
	
	public Theme(int indicator) {
		
		//TODO need to add
		// altTextColor to other themes
		
		switch (indicator) {
		  case 0:
		    mainColor = new Color(64,64,64); 
		    subColor = new Color(78,78,78);
		    layerColor = new Color(108, 108, 108);
		    textColor = Color.WHITE;
		    layerTextColor = new Color(153,153,153);
		    altTextColor = new Color(87, 87, 87);
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
	
	public static final Theme DARK = new Theme(0);
	
	public boolean checkEqualityWith(Theme other) {
		return this.mainColor.equals(other.mainColor);
	}
	
	public static final BubbleBorder SUB_BORDER = new BubbleBorder(Color.WHITE, 2, 15, 0);
	
	public static final Color PRIMARY = new Color(41, 128, 185);
	public static final Color PRIMARY_ALT = new Color(29, 89, 130);
	public static final BubbleBorder PRIMARY_BORDER = new BubbleBorder(PRIMARY, 0, 15, 0);
	
	public static final Color PRIMARY_DISABLED = new Color(164, 189, 206);
	public static final BubbleBorder PRIMARY_DISABLED_BORDER = new BubbleBorder(PRIMARY_DISABLED, 0, 15, 0);
	
	public static final Color SECONDARY = new Color(128, 128, 128);
	public static final Color SECONDARY_ALT = new Color(96, 96, 96);
	public static final BubbleBorder SECONDARY_BORDER = new BubbleBorder(SECONDARY, 0, 15, 0);
	
	public static final Color SUCCESS = new Color(40, 167, 69);
	public static final Color SUCCESS_ALT = new Color(24, 99, 42);
	public static final BubbleBorder SUCCESS_BORDER = new BubbleBorder(SUCCESS, 0, 15, 0);
	
	public static final Color DANGER = new Color(220,53,69);
	public static final Color DANGER_ALT = new Color(148, 35, 46);
	public static final BubbleBorder DANGER_BORDER = new BubbleBorder(DANGER, 0, 15, 0);
	
	public static void primaryVisualButton(JButton button) {
		button.setEnabled(true);
		button.setOpaque(true);
		button.setBorder(PRIMARY_BORDER);
		button.setBackground(PRIMARY);
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Arial", Font.BOLD, 18));
		
		button.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {}
			@Override
			public void mousePressed(MouseEvent e) {}
			@Override
			public void mouseReleased(MouseEvent e) {}

			@Override
			public void mouseEntered(MouseEvent e) {
				button.setBackground(Theme.PRIMARY_ALT);
				button.setForeground(new Color(191, 191, 191));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				button.setBackground(Theme.PRIMARY);
				button.setForeground(Color.WHITE);
			}
			
		});
	}
	
	public static void primaryDisabledVisualButton(JButton button) {
		button.setEnabled(false);
		button.setOpaque(true);
		button.setBorder(PRIMARY_DISABLED_BORDER);
		button.setBackground(PRIMARY_DISABLED);
		button.setForeground(new Color(164, 189, 206));
		button.setFont(new Font("Arial", Font.BOLD, 18));
	}
	
	public static void secondaryVisualButton(JButton button) {
		button.setEnabled(true);
		button.setOpaque(true);
		button.setBorder(SECONDARY_BORDER);
		button.setBackground(SECONDARY);
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Arial", Font.BOLD, 18));
		
		button.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {}
			@Override
			public void mousePressed(MouseEvent e) {}
			@Override
			public void mouseReleased(MouseEvent e) {}

			@Override
			public void mouseEntered(MouseEvent e) {
				button.setBackground(Theme.SECONDARY_ALT);
				button.setForeground(new Color(191, 191, 191));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				button.setBackground(Theme.SECONDARY);
				button.setForeground(Color.WHITE);
			}
			
		});
	}
	
	public static void successVisualButton(JButton button) {
		button.setEnabled(true);
		button.setOpaque(true);
		button.setBorder(SUCCESS_BORDER);
		button.setBackground(SUCCESS);
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Arial", Font.BOLD, 18));
		
		button.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {}
			@Override
			public void mousePressed(MouseEvent e) {}
			@Override
			public void mouseReleased(MouseEvent e) {}

			@Override
			public void mouseEntered(MouseEvent e) {
				button.setBackground(Theme.SUCCESS_ALT);
				button.setForeground(new Color(191, 191, 191));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				button.setBackground(Theme.SUCCESS);
				button.setForeground(Color.WHITE);
			}
			
		});
	}
	
	public static void dangerVisualButton(JButton button) {
		button.setEnabled(true);
		button.setOpaque(true);
		button.setBorder(DANGER_BORDER);
		button.setBackground(DANGER);
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Arial", Font.BOLD, 18));
		
		button.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {}
			@Override
			public void mousePressed(MouseEvent e) {}
			@Override
			public void mouseReleased(MouseEvent e) {}

			@Override
			public void mouseEntered(MouseEvent e) {
				button.setBackground(Theme.DANGER_ALT);
				button.setForeground(new Color(191, 191, 191));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				button.setBackground(Theme.DANGER);
				button.setForeground(Color.WHITE);
			}
			
		});
	}
	
	public void buttonLayerEnterEffect(JButton button) {
		button.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {}
			@Override
			public void mousePressed(MouseEvent e) {}
			@Override
			public void mouseReleased(MouseEvent e) {}

			@Override
			public void mouseEntered(MouseEvent e) {
				if(button.isEnabled()) {
					button.setForeground(layerTextColor);
				}
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if(button.isEnabled()) {
					button.setForeground(textColor);
				}
				
			}
			
		});
	}
	
	public static void labelButton(JButton button) {
		button.setOpaque(false);
		button.setFocusPainted(false);
		button.setBorderPainted(false);
	}
}
