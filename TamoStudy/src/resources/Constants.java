package resources;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;

import components.border.BubbleBorder;

public class Constants {
	
	public static ImageResourceHandler imageResourceHandler = new ImageResourceHandler();

	/*
	 * ##################################
	 * ##################################
	 * GENERAL CONSTANTS
	 * ##################################
	 * ##################################
	 */
	public static final String version = "v1.0.0";
	
	/*
	 * ##################################
	 * ##################################
	 * GUI CONSTANTS
	 * ##################################
	 * ##################################
	 */
	
	public static final Dimension GUI_FRAME_SIZE = new Dimension(800, 600);
	public static final Font SIDE_BUTTON_FONT = new Font("Arial", Font.BOLD, 16);
	public static final Font TOP_MENU_FONT = SIDE_BUTTON_FONT;
	public static final ImageIcon TOP_MENU_IMAGE_ICON = new ImageIcon(Constants.class.getClassLoader().getResource("TOP_MENU.png")); // 32 x 32
	public static final ImageIcon TAMO_TOKEN_IMAGE_ICON = new ImageIcon(Constants.class.getClassLoader().getResource("TAMO_TOKEN.png"));
	public static final int BUTTON_BORDER_RADIUS = 15;
	
	/*
	 * ##################################
	 * ##################################
	 * DASHBOARD STATE CONSTANTS
	 * ##################################
	 * ##################################
	 */
	
	public static final ImageIcon TAMOSTUDY_LOGO_IMAGE = new ImageIcon(Constants.class.getClassLoader().getResource("TAMOSTUDY_LOGO_IMAGE.gif"));
	public static final Font STATISTICS_INFO_FONT = new Font("Arial", Font.PLAIN, 16);
	public static final Font STATISTICS_INFO_FONT_BOLD = new Font("Arial", Font.BOLD, 16);
	public static final Font VERSION_FONT = new Font("Arial", Font.BOLD, 10);
	public static final Dimension TAMO_GRAPHICS_PANEL_DIMENSION = new Dimension(215, 315);
	public static final Integer BACKGROUND_IMAGE_OFFSET = 8;
//	public static final 
	
	
	/*
	 * ##################################
	 * ##################################
	 * SETTINGS STATE CONSTANTS
	 * ##################################
	 * ##################################
	 */

	public static final Font SETTINGS_MESSAGE_LABEL_FONT = new Font("Arial", Font.BOLD, 24);
	public static final Font SETTINGS_SETTING_LABEL_FONT = new Font("Arial", Font.BOLD, 16);
	public static final Font SETTINGS_CHOICE_FONT = new Font("Arial", Font.PLAIN, 12);
	public static final Font SETTINGS_CHOICE_FONT_BOLD = new Font("Arial", Font.BOLD, 12);
	public static final int SETTINGS_HORIZONTAL_COMPONENT_DIFFERENCE = 20;
	public static final int SETTINGS_VERTICAL_COMPONENT_DIFFERENCE = 10;
	public static final ImageIcon MINUS_BUTTON_IMAGE_ICON = new ImageIcon(Constants.class.getClassLoader().getResource("MINUS.png"));
	public static final ImageIcon ADD_BUTTON_IMAGE_ICON = new ImageIcon(Constants.class.getClassLoader().getResource("ADD.png"));

}
