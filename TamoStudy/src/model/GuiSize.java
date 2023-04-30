package model;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.ImageIcon;

import components.border.BubbleBorder;
import resources.Theme;

import static resources.Constants.*;

public class GuiSize {
	public int index;
	
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
	public int buttonBorderRadius;
	
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
	public ImageIcon minusImageIcon;
	public ImageIcon addImageIcon;
	
	public GuiSize(int size) {
		switch(size) {
		case 0:
			// Small
			index = 0;
			
			frameSize = GUI_FRAME_SIZE_SMALL;
			sideButtonFont = SIDE_BUTTON_FONT_SMALL;
			topMenuFont = TOP_MENU_FONT_SMALL;
			topMenuImageIcon = TOP_MENU_IMAGE_ICON_SMALL;
			tamoTokenImageIcon = TAMO_TOKEN_IMAGE_ICON_SMALL;
			buttonBorderRadius = BUTTON_BORDER_RADIUS_SMALL;
			
			messageLabelFont = SETTINGS_MESSAGE_LABEL_FONT_SMALL;
			settingLabelFont = SETTINGS_SETTING_LABEL_FONT_SMALL;
			settingsChoiceFont = SETTINGS_CHOICE_FONT_SMALL;
			settingsChoiceBoldFont = SETTINGS_CHOICE_FONT_BOLD_SMALL;
			settingsPanelBorder = Theme.subBorder(0);
			settingsHorizontalDifference = SETTINGS_HORIZONTAL_COMPONENT_DIFFERENCE_SMALL;
			settingsVerticalDifference = SETTINGS_VERTICAL_COMPONENT_DIFFERENCE_SMALL;
			minusImageIcon = MINUS_BUTTON_IMAGE_ICON_SMALL;
			addImageIcon = ADD_BUTTON_IMAGE_ICON_SMALL;
			break;
		case 2:
			// Large
			index = 2;
			
			frameSize = GUI_FRAME_SIZE_LARGE;
			sideButtonFont = SIDE_BUTTON_FONT_LARGE;
			topMenuFont = TOP_MENU_FONT_LARGE;
			topMenuImageIcon = TOP_MENU_IMAGE_ICON_LARGE;
			tamoTokenImageIcon = TAMO_TOKEN_IMAGE_ICON_LARGE;
			buttonBorderRadius = BUTTON_BORDER_RADIUS_LARGE;
			
			messageLabelFont = SETTINGS_MESSAGE_LABEL_FONT_LARGE;
			settingLabelFont = SETTINGS_SETTING_LABEL_FONT_LARGE;
			settingsChoiceFont = SETTINGS_CHOICE_FONT_LARGE;
			settingsChoiceBoldFont = SETTINGS_CHOICE_FONT_BOLD_LARGE;
			settingsPanelBorder = Theme.subBorder(2);
			settingsHorizontalDifference = SETTINGS_HORIZONTAL_COMPONENT_DIFFERENCE_LARGE;
			settingsVerticalDifference = SETTINGS_VERTICAL_COMPONENT_DIFFERENCE_LARGE;
			minusImageIcon = MINUS_BUTTON_IMAGE_ICON_LARGE;
			addImageIcon = ADD_BUTTON_IMAGE_ICON_LARGE;
			break;
		case 1:
		default:
			// Medium
			index = 1;
			
			frameSize = GUI_FRAME_SIZE_MEDIUM;
			sideButtonFont = SIDE_BUTTON_FONT_MEDIUM;
			topMenuFont = TOP_MENU_FONT_MEDIUM;
			topMenuImageIcon = TOP_MENU_IMAGE_ICON_MEDIUM;
			tamoTokenImageIcon = TAMO_TOKEN_IMAGE_ICON_MEDIUM;
			buttonBorderRadius = BUTTON_BORDER_RADIUS_MEDIUM;
			
			messageLabelFont = SETTINGS_MESSAGE_LABEL_FONT_MEDIUM;
			settingLabelFont = SETTINGS_SETTING_LABEL_FONT_MEDIUM;
			settingsChoiceFont = SETTINGS_CHOICE_FONT_MEDIUM;
			settingsChoiceBoldFont = SETTINGS_CHOICE_FONT_BOLD_MEDIUM;
			settingsPanelBorder = Theme.subBorder(1);
			settingsHorizontalDifference = SETTINGS_HORIZONTAL_COMPONENT_DIFFERENCE_MEDIUM;
			settingsVerticalDifference = SETTINGS_VERTICAL_COMPONENT_DIFFERENCE_MEDIUM;
			minusImageIcon = MINUS_BUTTON_IMAGE_ICON_MEDIUM;
			addImageIcon = ADD_BUTTON_IMAGE_ICON_MEDIUM;
			break;
		}
	}
	
	public void changeSize(int size) {
		switch(size) {
		case 0:
			// Small
			index = 0;
			
			frameSize = GUI_FRAME_SIZE_SMALL;
			sideButtonFont = SIDE_BUTTON_FONT_SMALL;
			topMenuFont = TOP_MENU_FONT_SMALL;
			topMenuImageIcon = TOP_MENU_IMAGE_ICON_SMALL;
			tamoTokenImageIcon = TAMO_TOKEN_IMAGE_ICON_SMALL;
			buttonBorderRadius = BUTTON_BORDER_RADIUS_SMALL;
			
			messageLabelFont = SETTINGS_MESSAGE_LABEL_FONT_SMALL;
			settingLabelFont = SETTINGS_SETTING_LABEL_FONT_SMALL;
			settingsChoiceFont = SETTINGS_CHOICE_FONT_SMALL;
			settingsChoiceBoldFont = SETTINGS_CHOICE_FONT_BOLD_SMALL;
			settingsPanelBorder = Theme.subBorder(0);
			settingsHorizontalDifference = SETTINGS_HORIZONTAL_COMPONENT_DIFFERENCE_SMALL;
			settingsVerticalDifference = SETTINGS_VERTICAL_COMPONENT_DIFFERENCE_SMALL;
			minusImageIcon = MINUS_BUTTON_IMAGE_ICON_SMALL;
			addImageIcon = ADD_BUTTON_IMAGE_ICON_SMALL;
			break;
		case 2:
			// Large
			index = 2;
			
			frameSize = GUI_FRAME_SIZE_LARGE;
			sideButtonFont = SIDE_BUTTON_FONT_LARGE;
			topMenuFont = TOP_MENU_FONT_LARGE;
			topMenuImageIcon = TOP_MENU_IMAGE_ICON_LARGE;
			tamoTokenImageIcon = TAMO_TOKEN_IMAGE_ICON_LARGE;
			buttonBorderRadius = BUTTON_BORDER_RADIUS_LARGE;
			
			messageLabelFont = SETTINGS_MESSAGE_LABEL_FONT_LARGE;
			settingLabelFont = SETTINGS_SETTING_LABEL_FONT_LARGE;
			settingsChoiceFont = SETTINGS_CHOICE_FONT_LARGE;
			settingsChoiceBoldFont = SETTINGS_CHOICE_FONT_BOLD_LARGE;
			settingsPanelBorder = Theme.subBorder(2);
			settingsHorizontalDifference = SETTINGS_HORIZONTAL_COMPONENT_DIFFERENCE_LARGE;
			settingsVerticalDifference = SETTINGS_VERTICAL_COMPONENT_DIFFERENCE_LARGE;
			minusImageIcon = MINUS_BUTTON_IMAGE_ICON_LARGE;
			addImageIcon = ADD_BUTTON_IMAGE_ICON_LARGE;
			break;
		case 1:
		default:
			// Medium
			index = 1;
			
			frameSize = GUI_FRAME_SIZE_MEDIUM;
			sideButtonFont = SIDE_BUTTON_FONT_MEDIUM;
			topMenuFont = TOP_MENU_FONT_MEDIUM;
			topMenuImageIcon = TOP_MENU_IMAGE_ICON_MEDIUM;
			tamoTokenImageIcon = TAMO_TOKEN_IMAGE_ICON_MEDIUM;
			buttonBorderRadius = BUTTON_BORDER_RADIUS_MEDIUM;
			
			messageLabelFont = SETTINGS_MESSAGE_LABEL_FONT_MEDIUM;
			settingLabelFont = SETTINGS_SETTING_LABEL_FONT_MEDIUM;
			settingsChoiceFont = SETTINGS_CHOICE_FONT_MEDIUM;
			settingsChoiceBoldFont = SETTINGS_CHOICE_FONT_BOLD_MEDIUM;
			settingsPanelBorder = Theme.subBorder(1);
			settingsHorizontalDifference = SETTINGS_HORIZONTAL_COMPONENT_DIFFERENCE_MEDIUM;
			settingsVerticalDifference = SETTINGS_VERTICAL_COMPONENT_DIFFERENCE_MEDIUM;
			minusImageIcon = MINUS_BUTTON_IMAGE_ICON_MEDIUM;
			addImageIcon = ADD_BUTTON_IMAGE_ICON_MEDIUM;
			break;
		}
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
	
}
