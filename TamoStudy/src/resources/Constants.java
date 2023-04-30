package resources;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.ImageIcon;

import components.border.BubbleBorder;

public class Constants {

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

	// Medium-Small (0) Component Sizes (Medium / 1.5)
	public static final Dimension GUI_FRAME_SIZE_SMALL = new Dimension(533, 400);
	public static final Font SIDE_BUTTON_FONT_SMALL = new Font("Arial", Font.BOLD, 11);
	public static final Font TOP_MENU_FONT_SMALL = SIDE_BUTTON_FONT_SMALL;
	public static final ImageIcon TOP_MENU_IMAGE_ICON_SMALL = new ImageIcon(Constants.class.getClassLoader().getResource("TOP_MENU_SMALL.png")); // 21 x 21
	public static final ImageIcon TAMO_TOKEN_IMAGE_ICON_SMALL = new ImageIcon(Constants.class.getClassLoader().getResource("TAMO_TOKEN_SMALL.png"));
	public static final int BUTTON_BORDER_RADIUS_SMALL = 10;
	
	// Medium (1, Default) Component Sizes
	public static final Dimension GUI_FRAME_SIZE_MEDIUM = new Dimension(800, 600);
	public static final Font SIDE_BUTTON_FONT_MEDIUM = new Font("Arial", Font.BOLD, 16);
	public static final Font TOP_MENU_FONT_MEDIUM = SIDE_BUTTON_FONT_MEDIUM;
	public static final ImageIcon TOP_MENU_IMAGE_ICON_MEDIUM = new ImageIcon(Constants.class.getClassLoader().getResource("TOP_MENU_MEDIUM.png")); // 32 x 32
	public static final ImageIcon TAMO_TOKEN_IMAGE_ICON_MEDIUM = new ImageIcon(Constants.class.getClassLoader().getResource("TAMO_TOKEN_MEDIUM.png"));
	public static final int BUTTON_BORDER_RADIUS_MEDIUM = 15;
	
	// Medium-Large (2) Component Sizes (Medium * 1.5)
	public static final Dimension GUI_FRAME_SIZE_LARGE = new Dimension(1200, 900);
	public static final Font SIDE_BUTTON_FONT_LARGE = new Font("Arial", Font.BOLD, 24);
	public static final Font TOP_MENU_FONT_LARGE = SIDE_BUTTON_FONT_LARGE;
	public static final ImageIcon TOP_MENU_IMAGE_ICON_LARGE = new ImageIcon(Constants.class.getClassLoader().getResource("TOP_MENU_LARGE.png")); // 43 x 43
	public static final ImageIcon TAMO_TOKEN_IMAGE_ICON_LARGE = new ImageIcon(Constants.class.getClassLoader().getResource("TAMO_TOKEN_LARGE.png"));
	public static final int BUTTON_BORDER_RADIUS_LARGE = 23;
	
	/*
	 * ##################################
	 * ##################################
	 * SETTINGS STATE CONSTANTS
	 * ##################################
	 * ##################################
	 */
	
	// Medium-Small (0) Component Sizes (Medium / 1.5)
	public static final Font SETTINGS_MESSAGE_LABEL_FONT_SMALL = new Font("Arial", Font.BOLD, 16);
	public static final Font SETTINGS_SETTING_LABEL_FONT_SMALL = new Font("Arial", Font.BOLD, 8);
	public static final Font SETTINGS_CHOICE_FONT_SMALL = new Font("Arial", Font.PLAIN, 8);
	public static final Font SETTINGS_CHOICE_FONT_BOLD_SMALL = new Font("Arial", Font.BOLD, 8);
	public static final int SETTINGS_HORIZONTAL_COMPONENT_DIFFERENCE_SMALL = 13;
	public static final int SETTINGS_VERTICAL_COMPONENT_DIFFERENCE_SMALL = 3;
	public static final ImageIcon MINUS_BUTTON_IMAGE_ICON_SMALL = new ImageIcon(Constants.class.getClassLoader().getResource("MINUS_SMALL.png"));
	public static final ImageIcon ADD_BUTTON_IMAGE_ICON_SMALL = new ImageIcon(Constants.class.getClassLoader().getResource("ADD_SMALL.png"));
	
	// Medium (1, Default) Component Sizes
	public static final Font SETTINGS_MESSAGE_LABEL_FONT_MEDIUM = new Font("Arial", Font.BOLD, 24);
	public static final Font SETTINGS_SETTING_LABEL_FONT_MEDIUM = new Font("Arial", Font.BOLD, 16);
	public static final Font SETTINGS_CHOICE_FONT_MEDIUM = new Font("Arial", Font.PLAIN, 12);
	public static final Font SETTINGS_CHOICE_FONT_BOLD_MEDIUM = new Font("Arial", Font.BOLD, 12);
	public static final int SETTINGS_HORIZONTAL_COMPONENT_DIFFERENCE_MEDIUM = 20;
	public static final int SETTINGS_VERTICAL_COMPONENT_DIFFERENCE_MEDIUM = 10;
	public static final ImageIcon MINUS_BUTTON_IMAGE_ICON_MEDIUM = new ImageIcon(Constants.class.getClassLoader().getResource("MINUS_MEDIUM.png"));
	public static final ImageIcon ADD_BUTTON_IMAGE_ICON_MEDIUM = new ImageIcon(Constants.class.getClassLoader().getResource("ADD_MEDIUM.png"));
	
	// Medium-Large (2) Component Sizes (Medium * 1.5)
	public static final Font SETTINGS_MESSAGE_LABEL_FONT_LARGE = new Font("Arial", Font.BOLD, 36);
	public static final Font SETTINGS_SETTING_LABEL_FONT_LARGE = new Font("Arial", Font.BOLD, 24);
	public static final Font SETTINGS_CHOICE_FONT_LARGE = new Font("Arial", Font.PLAIN, 18);
	public static final Font SETTINGS_CHOICE_FONT_BOLD_LARGE = new Font("Arial", Font.BOLD, 18);
	public static final int SETTINGS_HORIZONTAL_COMPONENT_DIFFERENCE_LARGE = 30;
	public static final int SETTINGS_VERTICAL_COMPONENT_DIFFERENCE_LARGE = 15;
	public static final ImageIcon MINUS_BUTTON_IMAGE_ICON_LARGE = new ImageIcon(Constants.class.getClassLoader().getResource("MINUS_LARGE.png"));
	public static final ImageIcon ADD_BUTTON_IMAGE_ICON_LARGE = new ImageIcon(Constants.class.getClassLoader().getResource("ADD_LARGE.png"));
	
}
