package model;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.ImageIcon;

import components.border.BubbleBorder;
import resources.Theme;

import static resources.Constants.*;

public class GuiSize {
	private int index;
	
	/*
	 * ##################################
	 * ##################################
	 * GUI ATTRIBUTES
	 * ##################################
	 * ##################################
	 */
	public Dimension frameSize;
	public Font sideButtonFont;
	public Font topMenuFont;
	public ImageIcon topMenuImageIcon;
	public ImageIcon tamoTokenImageIcon;
	
	/*
	 * ##################################
	 * ##################################
	 * SETTINGS ATTRIBUTES
	 * ##################################
	 * ##################################
	 */
	public Font messageLabelFont;
	public Font settingLabelFont;
	public Font settingsChoiceFont;
	public Font settingsChoiceBoldFont;
	public BubbleBorder settingsPanelBorder;
	public int settingsHorizontalDifference;
	public int settingsVerticalDifference;
	
	public GuiSize(int size) {
		switch(size) {
		case -1:
			// Small
			index = -1;
			
			frameSize = GUI_FRAME_SIZE_SMALL;
			sideButtonFont = SIDE_BUTTON_FONT_SMALL;
			topMenuFont = TOP_MENU_FONT_SMALL;
			topMenuImageIcon = TOP_MENU_IMAGE_ICON_SMALL;
			tamoTokenImageIcon = TAMO_TOKEN_IMAGE_ICON_SMALL;
			
			// TODO
			// TODO
			settingsPanelBorder = Theme.subBorder(-1);
			break;
		case 0:
			// Medium-Small
			index = 0;
			
			frameSize = GUI_FRAME_SIZE_MEDIUM_SMALL;
			sideButtonFont = SIDE_BUTTON_FONT_MEDIUM_SMALL;
			topMenuFont = TOP_MENU_FONT_MEDIUM_SMALL;
			topMenuImageIcon = TOP_MENU_IMAGE_ICON_MEDIUM_SMALL;
			tamoTokenImageIcon = TAMO_TOKEN_IMAGE_ICON_MEDIUM_SMALL;
			
			// TODO
			// TODO
			settingsPanelBorder = Theme.subBorder(0);
			break;
		case 1:
			// Medium
			index = 1;
			
			frameSize = GUI_FRAME_SIZE_MEDIUM;
			sideButtonFont = SIDE_BUTTON_FONT_MEDIUM;
			topMenuFont = TOP_MENU_FONT_MEDIUM;
			topMenuImageIcon = TOP_MENU_IMAGE_ICON_MEDIUM;
			tamoTokenImageIcon = TAMO_TOKEN_IMAGE_ICON_MEDIUM;
			
			messageLabelFont = SETTINGS_MESSAGE_LABEL_FONT_MEDIUM;
			settingLabelFont = SETTINGS_SETTING_LABEL_FONT_MEDIUM;
			settingsChoiceFont = SETTINGS_CHOICE_FONT_MEDIUM;
			settingsChoiceBoldFont = SETTINGS_CHOICE_FONT_BOLD_MEDIUM;
			settingsPanelBorder = Theme.subBorder(1);
			settingsHorizontalDifference = SETTINGS_HORIZONTAL_COMPONENT_DIFFERENCE_MEDIUM;
			settingsVerticalDifference = SETTINGS_VERTICAL_COMPONENT_DIFFERENCE_MEDIUM;
			break;
		case 2:
			index = 2;
			
			frameSize = GUI_FRAME_SIZE_MEDIUM_LARGE;
			sideButtonFont = SIDE_BUTTON_FONT_MEDIUM_LARGE;
			topMenuFont = TOP_MENU_FONT_MEDIUM_LARGE;
			topMenuImageIcon = TOP_MENU_IMAGE_ICON_MEDIUM_LARGE;
			tamoTokenImageIcon = TAMO_TOKEN_IMAGE_ICON_MEDIUM_LARGE;
			
			// TODO
			// TODO
			settingsPanelBorder = Theme.subBorder(2);
			break;
		case 3:
			index = 3;
			
			frameSize = GUI_FRAME_SIZE_LARGE;
			sideButtonFont = SIDE_BUTTON_FONT_LARGE;
			topMenuFont = TOP_MENU_FONT_LARGE;
			topMenuImageIcon = TOP_MENU_IMAGE_ICON_LARGE;
			tamoTokenImageIcon = TAMO_TOKEN_IMAGE_ICON_MEDIUM_LARGE;
			
			// TODO
			// TODO
			settingsPanelBorder = Theme.subBorder(3);
			break;
		default:
			// Medium
			index = 1;
			
			frameSize = GUI_FRAME_SIZE_MEDIUM;
			sideButtonFont = SIDE_BUTTON_FONT_MEDIUM;
			topMenuFont = TOP_MENU_FONT_MEDIUM;
			topMenuImageIcon = TOP_MENU_IMAGE_ICON_MEDIUM;
			tamoTokenImageIcon = TAMO_TOKEN_IMAGE_ICON_MEDIUM;
			
			// TODO
			// TODO
			settingsPanelBorder = Theme.subBorder(1);
			break;
		}
	}
	
	public void changeSize(int size) {
		switch(size) {
		case -1:
			// Small
			index = -1;
			
			frameSize = GUI_FRAME_SIZE_SMALL;
			sideButtonFont = SIDE_BUTTON_FONT_SMALL;
			topMenuFont = TOP_MENU_FONT_SMALL;
			topMenuImageIcon = TOP_MENU_IMAGE_ICON_SMALL;
			tamoTokenImageIcon = TAMO_TOKEN_IMAGE_ICON_SMALL;
			break;
		case 0:
			// Medium-Small
			index = 0;
			
			frameSize = GUI_FRAME_SIZE_MEDIUM_SMALL;
			sideButtonFont = SIDE_BUTTON_FONT_MEDIUM_SMALL;
			topMenuFont = TOP_MENU_FONT_MEDIUM_SMALL;
			topMenuImageIcon = TOP_MENU_IMAGE_ICON_MEDIUM_SMALL;
			tamoTokenImageIcon = TAMO_TOKEN_IMAGE_ICON_MEDIUM_SMALL;
			break;
		case 1:
			// Medium
			index = 1;
			
			frameSize = GUI_FRAME_SIZE_MEDIUM;
			sideButtonFont = SIDE_BUTTON_FONT_MEDIUM;
			topMenuFont = TOP_MENU_FONT_MEDIUM;
			topMenuImageIcon = TOP_MENU_IMAGE_ICON_MEDIUM;
			tamoTokenImageIcon = TAMO_TOKEN_IMAGE_ICON_MEDIUM;
			break;
		case 2:
			index = 2;
			
			frameSize = GUI_FRAME_SIZE_MEDIUM_LARGE;
			sideButtonFont = SIDE_BUTTON_FONT_MEDIUM_LARGE;
			topMenuFont = TOP_MENU_FONT_MEDIUM_LARGE;
			topMenuImageIcon = TOP_MENU_IMAGE_ICON_MEDIUM_LARGE;
			tamoTokenImageIcon = TAMO_TOKEN_IMAGE_ICON_MEDIUM_LARGE;
			break;
		case 3:
			index = 3;
			
			frameSize = GUI_FRAME_SIZE_LARGE;
			sideButtonFont = SIDE_BUTTON_FONT_LARGE;
			topMenuFont = TOP_MENU_FONT_LARGE;
			topMenuImageIcon = TOP_MENU_IMAGE_ICON_LARGE;
			tamoTokenImageIcon = TAMO_TOKEN_IMAGE_ICON_MEDIUM_LARGE;
			break;
		default:
			// Medium
			index = 1;
			
			frameSize = GUI_FRAME_SIZE_MEDIUM;
			sideButtonFont = SIDE_BUTTON_FONT_MEDIUM;
			topMenuFont = TOP_MENU_FONT_MEDIUM;
			topMenuImageIcon = TOP_MENU_IMAGE_ICON_MEDIUM;
			tamoTokenImageIcon = TAMO_TOKEN_IMAGE_ICON_MEDIUM;
			break;
		}
	}
	
	public static GuiSize smallGui() {
		return new GuiSize(-1);
	}
	
	public static GuiSize mediumSmallGui() {
		return new GuiSize(0);
	}
	
	public static GuiSize mediumGui() {
		return new GuiSize(1);
	}
	
	public static GuiSize mediumLargeGui() {
		return new GuiSize(2);
	}
	
	public static GuiSize largeGui() {
		return new GuiSize(3);
	}
	
}
