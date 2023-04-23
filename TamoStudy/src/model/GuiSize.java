package model;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.ImageIcon;

import static resources.Constants.*;

public class GuiSize {
	private Dimension frameSize;
	private Font sideButtonFont;
	private Font topMenuFont;
	private ImageIcon topMenuImageIcon;
	
	public GuiSize(int size) {
		switch(size) {
		case -1:
			// Small
			frameSize = GUI_FRAME_SIZE_SMALL;
			sideButtonFont = SIDE_BUTTON_FONT_SMALL;
			topMenuFont = TOP_MENU_FONT_SMALL;
			topMenuImageIcon = TOP_MENU_IMAGE_ICON_SMALL;
			break;
		case 0:
			// Medium-Small
			frameSize = GUI_FRAME_SIZE_MEDIUM_SMALL;
			sideButtonFont = SIDE_BUTTON_FONT_MEDIUM_SMALL;
			topMenuFont = TOP_MENU_FONT_MEDIUM_SMALL;
			topMenuImageIcon = TOP_MENU_IMAGE_ICON_MEDIUM_SMALL;
			break;
		case 1:
			// Medium
			frameSize = GUI_FRAME_SIZE_MEDIUM;
			sideButtonFont = SIDE_BUTTON_FONT_MEDIUM;
			topMenuFont = TOP_MENU_FONT_MEDIUM;
			topMenuImageIcon = TOP_MENU_IMAGE_ICON_MEDIUM;
			break;
		case 2:
			frameSize = GUI_FRAME_SIZE_MEDIUM_LARGE;
			sideButtonFont = SIDE_BUTTON_FONT_MEDIUM_LARGE;
			topMenuFont = TOP_MENU_FONT_MEDIUM_LARGE;
			topMenuImageIcon = TOP_MENU_IMAGE_ICON_MEDIUM_LARGE;
			break;
		case 3:
			frameSize = GUI_FRAME_SIZE_LARGE;
			sideButtonFont = SIDE_BUTTON_FONT_LARGE;
			topMenuFont = TOP_MENU_FONT_LARGE;
			topMenuImageIcon = TOP_MENU_IMAGE_ICON_LARGE;
			break;
		default:
			// Medium
			frameSize = GUI_FRAME_SIZE_MEDIUM;
			sideButtonFont = SIDE_BUTTON_FONT_MEDIUM;
			topMenuFont = TOP_MENU_FONT_MEDIUM;
			break;
		}
	}
	
	public void changeSize(int size) {
		switch(size) {
		case -1:
			// Small
			frameSize = GUI_FRAME_SIZE_SMALL;
			sideButtonFont = SIDE_BUTTON_FONT_SMALL;
			topMenuFont = TOP_MENU_FONT_SMALL;
			topMenuImageIcon = TOP_MENU_IMAGE_ICON_SMALL;
			break;
		case 0:
			// Medium-Small
			frameSize = GUI_FRAME_SIZE_MEDIUM_SMALL;
			sideButtonFont = SIDE_BUTTON_FONT_MEDIUM_SMALL;
			topMenuFont = TOP_MENU_FONT_MEDIUM_SMALL;
			topMenuImageIcon = TOP_MENU_IMAGE_ICON_MEDIUM_SMALL;
			break;
		case 1:
			// Medium
			frameSize = GUI_FRAME_SIZE_MEDIUM;
			sideButtonFont = SIDE_BUTTON_FONT_MEDIUM;
			topMenuFont = TOP_MENU_FONT_MEDIUM;
			topMenuImageIcon = TOP_MENU_IMAGE_ICON_MEDIUM;
			break;
		case 2:
			frameSize = GUI_FRAME_SIZE_MEDIUM_LARGE;
			sideButtonFont = SIDE_BUTTON_FONT_MEDIUM_LARGE;
			topMenuFont = TOP_MENU_FONT_MEDIUM_LARGE;
			topMenuImageIcon = TOP_MENU_IMAGE_ICON_MEDIUM_LARGE;
			break;
		case 3:
			frameSize = GUI_FRAME_SIZE_LARGE;
			sideButtonFont = SIDE_BUTTON_FONT_LARGE;
			topMenuFont = TOP_MENU_FONT_LARGE;
			topMenuImageIcon = TOP_MENU_IMAGE_ICON_LARGE;
			break;
		default:
			// Medium
			frameSize = GUI_FRAME_SIZE_MEDIUM;
			sideButtonFont = SIDE_BUTTON_FONT_MEDIUM;
			topMenuFont = TOP_MENU_FONT_MEDIUM;
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

	public Dimension getFrameSize() {
		return frameSize;
	}

	public Font getSideButtonFont() {
		return sideButtonFont;
	}

	public Font getTopMenuFont() {
		return topMenuFont;
	}

	public ImageIcon getTopMenuImageIcon() {
		return topMenuImageIcon;
	}

	public void setTopMenuImageIcon(ImageIcon topMenuImageIcon) {
		this.topMenuImageIcon = topMenuImageIcon;
	}
}
