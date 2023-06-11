package resources;

import java.awt.Color;
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
	public static final int ACHIEVEMENT_COUNT = 12;
	
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
	public static final ImageIcon HEART_IMAGE_ICON = new ImageIcon(Constants.class.getClassLoader().getResource("HEART.png"));
	public static final ImageIcon ONIGIRI_IMAGE_ICON = new ImageIcon(Constants.class.getClassLoader().getResource("ONIGIRI.png"));
	
	/*
	 * ##################################
	 * ##################################
	 * FOCUS / TIMER STATE CONSTANTS
	 * ##################################
	 * ##################################
	 */
	public static final Font TIMER_FONT = new Font("Arial", Font.BOLD, 96);
	public static final Font SUB_TEXT_FONT = new Font("Arial", Font.BOLD, 25);
	public static final BubbleBorder TIMER_BORDER = new BubbleBorder(Color.WHITE, 6, 20, 10, true);
	
	/*
	 * ##################################
	 * ##################################
	 * SHOP CONSTANTS
	 * ##################################
	 * ##################################
	 */
	public static final Font KATH_MESSAGE_FONT = new Font("Arial", Font.PLAIN, 12);
	public static final Dimension KATH_SHOP_DIMENSION = new Dimension(400, 267);
	public static final Integer KATH_IMAGE_OFFSET = 40;
	public static final Dimension KATH_MSG_DIMENSION = new Dimension(400, 130);
	public static final ImageIcon LEFT_ARROW_ICON = new ImageIcon(Constants.class.getClassLoader().getResource("ARROW_LEFT.png"));
	public static final ImageIcon RIGHT_ARROW_ICON = new ImageIcon(Constants.class.getClassLoader().getResource("ARROW_RIGHT.png"));
	
	/*
	 * ##################################
	 * ##################################
	 * INVENTORY CONSTANTS
	 * ##################################
	 * ##################################
	 */
	public static final Dimension ITEM_MENU_DIMENSION = new Dimension(32, 32);
	
	/*
	 * ##################################
	 * ##################################
	 * STATISTICS CONSTANTS
	 * ##################################
	 * ##################################
	 */
	public static final Dimension HOURS_IN_PAST_DIMENSION = new Dimension(540, 150);
	public static final ImageIcon GRAY_ICON = new ImageIcon(Constants.class.getClassLoader().getResource("GRAY.png"));
	public static final ImageIcon GREEN_1_ICON = new ImageIcon(Constants.class.getClassLoader().getResource("GREEN_1.png"));
	public static final ImageIcon GREEN_2_ICON = new ImageIcon(Constants.class.getClassLoader().getResource("GREEN_2.png"));
	public static final ImageIcon GREEN_3_ICON = new ImageIcon(Constants.class.getClassLoader().getResource("GREEN_3.png"));
	public static final ImageIcon GREEN_4_ICON = new ImageIcon(Constants.class.getClassLoader().getResource("GREEN_4.png"));
	
	/*
	 * ##################################
	 * ##################################
	 * ACHIEVEMENTS CONSTANTS
	 * ##################################
	 * ##################################
	 */
	public static final Font ACHIEVEMENT_TITLE_LABEL_FONT = new Font("Arial", Font.BOLD, 20);
	public static final Font ACHIEVEMENT_DESCRIPTION_LABEL_FONT = new Font("Arial", Font.PLAIN, 12);
	public static final Dimension ACHIEVEMENT_SCROLL_PANE_DIMENSION = new Dimension(400, 500);
	
	/*
	 * ##################################
	 * ##################################
	 * SETTINGS STATE CONSTANTS
	 * ##################################
	 * ##################################
	 */
	public static final ImageIcon DARK_MODE_ICON = new ImageIcon(Constants.class.getClassLoader().getResource("DARK_MODE.png"));
	public static final ImageIcon LIGHT_MODE_ICON = new ImageIcon(Constants.class.getClassLoader().getResource("SUN_MODE.png"));
	public static final Font SETTINGS_MESSAGE_LABEL_FONT = new Font("Arial", Font.BOLD, 24);
	public static final Font SETTINGS_SETTING_LABEL_FONT = new Font("Arial", Font.BOLD, 16);
	public static final Font SETTINGS_CHOICE_FONT = new Font("Arial", Font.PLAIN, 12);
	public static final Font SETTINGS_CHOICE_FONT_BOLD = new Font("Arial", Font.BOLD, 12);
	public static final int SETTINGS_HORIZONTAL_COMPONENT_DIFFERENCE = 20;
	public static final int SETTINGS_VERTICAL_COMPONENT_DIFFERENCE = 10;
	public static final ImageIcon MINUS_BUTTON_IMAGE_ICON = new ImageIcon(Constants.class.getClassLoader().getResource("MINUS.png"));
	public static final ImageIcon ADD_BUTTON_IMAGE_ICON = new ImageIcon(Constants.class.getClassLoader().getResource("ADD.png"));

}
