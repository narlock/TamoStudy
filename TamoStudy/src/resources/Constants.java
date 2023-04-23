package resources;

import java.awt.Dimension;
import java.awt.Font;

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

	// Medium-Small (0) Component Sizes (Medium / 1.5)
	public static final Dimension GUI_FRAME_SIZE_MEDIUM_SMALL = new Dimension(533, 400);
	public static final Font SIDE_BUTTON_FONT_MEDIUM_SMALL = new Font("Arial", Font.BOLD, 11);
	public static final Font TOP_MENU_FONT_MEDIUM_SMALL = SIDE_BUTTON_FONT_MEDIUM_SMALL;
	
	// Small (-1) Component Sizes (Medium / 2)
	public static final Dimension GUI_FRAME_SIZE_SMALL = new Dimension(400, 300);
	public static final Font SIDE_BUTTON_FONT_SMALL = new Font("Arial", Font.BOLD, 8);
	public static final Font TOP_MENU_FONT_SMALL = SIDE_BUTTON_FONT_SMALL;
	
	// Medium-Large (2) Component Sizes (Medium * 1.5)
	public static final Dimension GUI_FRAME_SIZE_MEDIUM_LARGE = new Dimension(1200, 900);
	public static final Font SIDE_BUTTON_FONT_MEDIUM_LARGE = new Font("Arial", Font.BOLD, 24);
	public static final Font TOP_MENU_FONT_MEDIUM_LARGE = SIDE_BUTTON_FONT_MEDIUM_LARGE;
	
	// Large (3) Component Sizes (Medium * 2)
	public static final Dimension GUI_FRAME_SIZE_LARGE = new Dimension(1600, 1200);
	public static final Font SIDE_BUTTON_FONT_LARGE = new Font("Arial", Font.BOLD, 32);
	public static final Font TOP_MENU_FONT_LARGE = SIDE_BUTTON_FONT_LARGE;
}
