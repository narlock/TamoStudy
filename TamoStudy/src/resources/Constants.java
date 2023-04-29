package resources;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.ImageIcon;

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
	
	// Medium (1, Default) Component Sizes
	public static final Dimension GUI_FRAME_SIZE_MEDIUM = new Dimension(800, 600);
	public static final Font SIDE_BUTTON_FONT_MEDIUM = new Font("Arial", Font.BOLD, 16);
	public static final Font TOP_MENU_FONT_MEDIUM = SIDE_BUTTON_FONT_MEDIUM;
	public static final ImageIcon TOP_MENU_IMAGE_ICON_SMALL = new ImageIcon(Constants.class.getClassLoader().getResource("TOP_MENU_SMALL.png")); // 16 x 16
	public static final ImageIcon TAMO_TOKEN_IMAGE_ICON_SMALL = new ImageIcon(Constants.class.getClassLoader().getResource("TAMO_TOKEN_SMALL.png"));
	
	// Medium-Small (0) Component Sizes (Medium / 1.5)
	public static final Dimension GUI_FRAME_SIZE_MEDIUM_SMALL = new Dimension(533, 400);
	public static final Font SIDE_BUTTON_FONT_MEDIUM_SMALL = new Font("Arial", Font.BOLD, 11);
	public static final Font TOP_MENU_FONT_MEDIUM_SMALL = SIDE_BUTTON_FONT_MEDIUM_SMALL;
	public static final ImageIcon TOP_MENU_IMAGE_ICON_MEDIUM_SMALL = new ImageIcon(Constants.class.getClassLoader().getResource("TOP_MENU_MEDIUM_SMALL.png")); // 21 x 21
	public static final ImageIcon TAMO_TOKEN_IMAGE_ICON_MEDIUM_SMALL = new ImageIcon(Constants.class.getClassLoader().getResource("TAMO_TOKEN_MEDIUM_SMALL.png"));
	
	// Small (-1) Component Sizes (Medium / 2)
	public static final Dimension GUI_FRAME_SIZE_SMALL = new Dimension(400, 300);
	public static final Font SIDE_BUTTON_FONT_SMALL = new Font("Arial", Font.BOLD, 8);
	public static final Font TOP_MENU_FONT_SMALL = SIDE_BUTTON_FONT_SMALL;
	public static final ImageIcon TOP_MENU_IMAGE_ICON_MEDIUM = new ImageIcon(Constants.class.getClassLoader().getResource("TOP_MENU_MEDIUM.png")); // 32 x 32
	public static final ImageIcon TAMO_TOKEN_IMAGE_ICON_MEDIUM = new ImageIcon(Constants.class.getClassLoader().getResource("TAMO_TOKEN_MEDIUM.png"));
	
	// Medium-Large (2) Component Sizes (Medium * 1.5)
	public static final Dimension GUI_FRAME_SIZE_MEDIUM_LARGE = new Dimension(1200, 900);
	public static final Font SIDE_BUTTON_FONT_MEDIUM_LARGE = new Font("Arial", Font.BOLD, 24);
	public static final Font TOP_MENU_FONT_MEDIUM_LARGE = SIDE_BUTTON_FONT_MEDIUM_LARGE;
	public static final ImageIcon TOP_MENU_IMAGE_ICON_MEDIUM_LARGE = new ImageIcon(Constants.class.getClassLoader().getResource("TOP_MENU_MEDIUM_LARGE.png")); // 43 x 43
	public static final ImageIcon TAMO_TOKEN_IMAGE_ICON_MEDIUM_LARGE = new ImageIcon(Constants.class.getClassLoader().getResource("TAMO_TOKEN_MEDIUM_LARGE.png"));
	
	// Large (3) Component Sizes (Medium * 2)
	public static final Dimension GUI_FRAME_SIZE_LARGE = new Dimension(1600, 1200);
	public static final Font SIDE_BUTTON_FONT_LARGE = new Font("Arial", Font.BOLD, 32);
	public static final Font TOP_MENU_FONT_LARGE = SIDE_BUTTON_FONT_LARGE;
	public static final ImageIcon TOP_MENU_IMAGE_ICON_LARGE = new ImageIcon(Constants.class.getClassLoader().getResource("TOP_MENU_LARGE.png")); // 64 x 64
	public static final ImageIcon TAMO_TOKEN_IMAGE_ICON_LARGE = new ImageIcon(Constants.class.getClassLoader().getResource("TAMO_TOKEN_LARGE.png"));

	/*
	 * ##################################
	 * ##################################
	 * SETTINGS STATE CONSTANTS
	 * ##################################
	 * ##################################
	 */
	
	// Medium (1, Default) Component Sizes
	public static final Font SETTINGS_MESSAGE_LABEL_FONT_MEDIUM = new Font("Arial", Font.BOLD, 24);
	public static final Font SETTINGS_SETTING_LABEL_FONT_MEDIUM = new Font("Arial", Font.BOLD, 16);
	
	// Medium-Small (0) Component Sizes (Medium / 1.5)
	
	// Small (-1) Component Sizes (Medium / 2)
	
	// Medium-Large (2) Component Sizes (Medium * 1.5)
	
	// Large (3) Component Sizes (Medium * 2)
}
