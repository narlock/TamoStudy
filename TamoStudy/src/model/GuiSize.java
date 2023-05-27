package model;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.Border;

import components.border.BubbleBorder;
import resources.Debug;
import resources.ImageResourceHandler;
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
	 * DASHBOARD ATTRIBUTES
	 * ##################################
	 * ##################################
	 */
	public Font statisticsInfoFont;
	public Font statisticsInfoFontBold;
	public Font versionFont;
	public Dimension tamoGraphicsPanelDimension;
	public int backgroundImageOffset;
	public ImageIcon heartImageIcon;
	public ImageIcon onigiriImageIcon;
	
	/*
	 * ##################################
	 * ##################################
	 * FOCUS / TIMER STATE CONSTANTS
	 * ##################################
	 * ##################################
	 */
	public Font timerFont;
	public Font subTextFont;
	public BubbleBorder timerBorder;
	
	/*
	 * ##################################
	 * ##################################
	 * SHOP STATE CONSTANTS
	 * ##################################
	 * ##################################
	 */
	public Dimension kathShopDimension;
	public BubbleBorder messageBorder;
	public int kathImageOffset;
	public Font kathMessageFont;
	public Dimension kathMsgDimension;
	
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
		double scale = getScaleFromSize(size);
		index = size;
		
		frameSize = scaleDimension(GUI_FRAME_SIZE, scale);
		sideButtonFont = scaleFont(SIDE_BUTTON_FONT, scale);
		topMenuFont = scaleFont(TOP_MENU_FONT, scale);
		topMenuImageIcon = scaleImageIcon(TOP_MENU_IMAGE_ICON, scale);
		tamoTokenImageIcon = scaleImageIcon(TAMO_TOKEN_IMAGE_ICON, scale);
		buttonBorderRadius = scaleInteger(BUTTON_BORDER_RADIUS, scale);
		
		statisticsInfoFont = scaleFont(STATISTICS_INFO_FONT, scale);
		statisticsInfoFontBold = scaleFont(STATISTICS_INFO_FONT_BOLD, scale); 
		versionFont = scaleFont(VERSION_FONT, scale);
		tamoGraphicsPanelDimension = scaleDimension(TAMO_GRAPHICS_PANEL_DIMENSION, scale);
		backgroundImageOffset = scaleInteger(BACKGROUND_IMAGE_OFFSET, scale);
		heartImageIcon = scaleImageIcon(HEART_IMAGE_ICON, scale * (3.0 / 5.0) );
		onigiriImageIcon = scaleImageIcon(ONIGIRI_IMAGE_ICON, scale * (3.0 / 5.0) );
		
		timerFont = scaleFont(TIMER_FONT, scale);
		subTextFont = scaleFont(SUB_TEXT_FONT, scale);
		timerBorder = scaleBubbleBorder(TIMER_BORDER, scale);
		
		kathShopDimension = scaleDimension(KATH_SHOP_DIMENSION, scale);
		messageBorder = scaleBubbleBorder(new BubbleBorder(Color.BLACK, 3, 10, 0), scale);
		kathImageOffset = scaleInteger(KATH_IMAGE_OFFSET, scale);
		kathMessageFont = scaleFont(KATH_MESSAGE_FONT, scale);
		kathMsgDimension = scaleDimension(KATH_MSG_DIMENSION, scale);
		
		messageLabelFont = scaleFont(SETTINGS_MESSAGE_LABEL_FONT, scale);
		settingLabelFont = scaleFont(SETTINGS_SETTING_LABEL_FONT, scale);
		settingsChoiceFont = scaleFont(SETTINGS_CHOICE_FONT, scale);
		settingsChoiceBoldFont = scaleFont(SETTINGS_CHOICE_FONT_BOLD, scale);
		settingsPanelBorder = scaleBubbleBorder(Theme.subBorder, scale);
		settingsHorizontalDifference = scaleInteger(SETTINGS_HORIZONTAL_COMPONENT_DIFFERENCE, scale);
		settingsVerticalDifference = scaleInteger(SETTINGS_VERTICAL_COMPONENT_DIFFERENCE, scale);
		minusImageIcon = scaleImageIcon(MINUS_BUTTON_IMAGE_ICON, scale);
		addImageIcon = scaleImageIcon(ADD_BUTTON_IMAGE_ICON, scale);
	}
	
	public double getScaleFromSize(int size) {
		if(size == 0) {
			return (2.0 / 3.0);
		} else if(size == 2) {
			return 1.5;
		}
		return 1;
	}
	
	public static double getScaleFromIndex(int size) {
		if(size == 0) {
			return (2.0 / 3.0);
		} else if(size == 2) {
			return 1.5;
		}
		return 1;
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
	
	/*
	 * ##################################
	 * ##################################
	 * TAMOSTUDY GRAPHICS ATTRIBUTES
	 * ##################################
	 * ##################################
	 */
	
	public Image getTamoImage(int indicator, String status) {
		double scale = getScaleFromSize(index);
		ImageResourceHandler imageResourceHandler = new ImageResourceHandler();
		Image tamoImage = imageResourceHandler.readImageFromUrl("TAMO_" + status + "_" + indicator + ".png");
		Debug.info("GuiSize.getTamoImage", "tamoImage = " + tamoImage + ", index = " + index);
		return scaleImage(tamoImage, scale);
	}
	
	public Image getBackgroundImage(long indicator) {
		double scale = getScaleFromSize(index);
		ImageResourceHandler imageResourceHandler = new ImageResourceHandler();
		Image backgroundImage = imageResourceHandler.readImageFromUrl("BACKGROUND_" + indicator + ".png");
		return scaleImage(backgroundImage, scale);
	}
	
	public Image getBorderImage(long indicator) {
		double scale = getScaleFromSize(index);
		ImageResourceHandler imageResourceHandler = new ImageResourceHandler();
		String indicatorName = getBorderNameByIndicator(indicator);
		Image borderImage = imageResourceHandler.readImageFromUrl("BORDER_" + indicatorName + ".png");
		return scaleImage(borderImage, scale);
	}
	
	public ImageIcon getTamoStudyLogoImage() {
		if(index == 0) {
			// Small Image
			return new ImageIcon(getClass().getClassLoader().getResource("TAMOSTUDY_LOGO_IMAGE_SMALL.gif"));
		} else if(index == 2) {
			// Large Image
			return new ImageIcon(getClass().getClassLoader().getResource("TAMOSTUDY_LOGO_IMAGE_LARGE.gif"));
		} else {
			// Medium Image
			return new ImageIcon(getClass().getClassLoader().getResource("TAMOSTUDY_LOGO_IMAGE.gif"));
		}
	}
	
	/*
	 * ##################################
	 * ##################################
	 * SHOP GRAPHICS ATTRIBUTES
	 * ##################################
	 * ##################################
	 */
	public Image getKathImage(long indicator) {
		double scale = getScaleFromSize(index);
		ImageResourceHandler imageResourceHandler = new ImageResourceHandler();
		String indicatorName = indicator == 0 ? "SHOP" : "MSG";
		Image borderImage = imageResourceHandler.readImageFromUrl("KATH_" + indicatorName + ".png");
		return scaleImage(borderImage, scale);
	}
	
	/*
	 * ##################################
	 * ##################################
	 * SCALING METHODS
	 * ##################################
	 * ##################################
	 * 
	 * For scaling to LARGE gui, scale = 1.5
	 * For scaling to SMALL gui, scale = (2/3)
	 */
	public Dimension scaleDimension(Dimension originalDimension, double scale) {
	    if(scale == 1) { return originalDimension; }
		
		int scaledWidth = (int) (originalDimension.getWidth() * scale);
	    int scaledHeight = (int) (originalDimension.getHeight() * scale);
	    return new Dimension(scaledWidth, scaledHeight);
	}
	
	public static Dimension scaleDimension(Dimension originalDimension, GuiSize guiSize) {
		double scale = getScaleFromIndex(guiSize.index);
		if(scale == 1) { return originalDimension; }
		
		int scaledWidth = (int) (originalDimension.getWidth() * scale);
	    int scaledHeight = (int) (originalDimension.getHeight() * scale);
	    return new Dimension(scaledWidth, scaledHeight);
	}
	
	public Font scaleFont(Font originalFont, double scale) {
	    if(scale == 1) { return originalFont; }
		
		int scaledSize = (int) (originalFont.getSize() * scale);
	    Font scaledFont = originalFont.deriveFont((float) scaledSize);
	    return scaledFont;
	}
	
	public static Font scaleFont(Font originalFont, GuiSize guiSize) {
		double scale = getScaleFromIndex(guiSize.index);
		if(scale == 1) { return originalFont; }
		
		int scaledSize = (int) (originalFont.getSize() * scale);
	    Font scaledFont = originalFont.deriveFont((float) scaledSize);
	    return scaledFont;
	}
	
	public BubbleBorder scaleBubbleBorder(BubbleBorder originalBubbleBorder, double scale) {
	    if(scale == 1) { return originalBubbleBorder; }
		
		int scaledThickness = (int) Math.round(originalBubbleBorder.thickness * scale);
	    int scaledRadii = (int) Math.round(originalBubbleBorder.radii * scale);
	    int scaledPointerSize = (int) Math.round(originalBubbleBorder.pointerSize * scale);

	    BubbleBorder scaledBubbleBorder = new BubbleBorder(
	            originalBubbleBorder.color,
	            scaledThickness,
	            scaledRadii,
	            scaledPointerSize,
	            originalBubbleBorder.left);

	    return scaledBubbleBorder;
	}
	
	public static BubbleBorder scaleBubbleBorder(BubbleBorder originalBubbleBorder, GuiSize guiSize) {
		double scale = getScaleFromIndex(guiSize.index);
		if(scale == 1) { return originalBubbleBorder; }
		
		int scaledThickness = (int) Math.round(originalBubbleBorder.thickness * scale);
	    int scaledRadii = (int) Math.round(originalBubbleBorder.radii * scale);
	    int scaledPointerSize = (int) Math.round(originalBubbleBorder.pointerSize * scale);

	    BubbleBorder scaledBubbleBorder = new BubbleBorder(
	            originalBubbleBorder.color,
	            scaledThickness,
	            scaledRadii,
	            scaledPointerSize,
	            originalBubbleBorder.left);

	    return scaledBubbleBorder;
	}
	
	public ImageIcon scaleImageIcon(ImageIcon originalIcon, double scale) {
		if(scale == 1) { return originalIcon; }
		
	    Image originalImage = originalIcon.getImage();
	    Image scaledImage = scaleImage(originalImage, scale);
	    ImageIcon scaledIcon = new ImageIcon(scaledImage);
	    return scaledIcon;
	}
	
	public static ImageIcon scaleImageIcon(ImageIcon originalIcon, GuiSize guiSize) {
		double scale = getScaleFromIndex(guiSize.index);
		if(scale == 1) { return originalIcon; }
		
	    Image originalImage = originalIcon.getImage();
	    Image scaledImage = scaleImage(originalImage, guiSize);
	    ImageIcon scaledIcon = new ImageIcon(scaledImage);
	    return scaledIcon;
	}

	public Image scaleImage(Image originalImage, double scale) {
		if(scale == 1) { return originalImage; }
		
	    int scaledWidth = (int) (originalImage.getWidth(null) * scale);
	    int scaledHeight = (int) (originalImage.getHeight(null) * scale);
	    Image scaledImage = originalImage.getScaledInstance(scaledWidth, scaledHeight, Image.SCALE_SMOOTH);
	    return scaledImage;
	}
	
	public static Image scaleImage(Image originalImage, GuiSize guiSize) {
		double scale = getScaleFromIndex(guiSize.index);
		if(scale == 1) { return originalImage; }
		
	    int scaledWidth = (int) (originalImage.getWidth(null) * scale);
	    int scaledHeight = (int) (originalImage.getHeight(null) * scale);
	    Image scaledImage = originalImage.getScaledInstance(scaledWidth, scaledHeight, Image.SCALE_SMOOTH);
	    return scaledImage;
	}

	public int scaleInteger(int originalInteger, double scale) {
		if(scale == 1) { return originalInteger; }
	    return (int) (originalInteger * scale);
	}
	
	public static int scaleInteger(int originalInteger, GuiSize guiSize) {
		double scale = getScaleFromIndex(guiSize.index);
		if(scale == 1) { return originalInteger; }
	    return (int) (originalInteger * scale);
	}
	
	public JButton scaleSuccessJButton(JButton originalButton, double scale) {
		BubbleBorder border = scaleBubbleBorder(Theme.SUCCESS_BORDER, scale);
		Color backgroundColor = originalButton.getBackground();
		Font font = scaleFont(originalButton.getFont(), scale);
		
		JButton button = new JButton(originalButton.getText());
		primarySuccessButton(button, border, backgroundColor, font);
		return button;
	}
	
	public JButton scaleDangerJButton(JButton originalButton, double scale) {
		BubbleBorder border = scaleBubbleBorder(Theme.DANGER_BORDER, scale);
		Color backgroundColor = originalButton.getBackground();
		Font font = scaleFont(originalButton.getFont(), scale);
		
		JButton button = new JButton(originalButton.getText());
		primaryDangerButton(button, border, backgroundColor, font);
		return button;
	}
	
	/*
	 * ##################################
	 * ##################################
	 * HELPER METHODS
	 * ##################################
	 * ##################################
	 */
	public String getBorderNameByIndicator(long indicator) {
		switch((int) indicator) {
		case 1:
			return "GOLD";
		case 2:
			return "RED";
		case 3:
			return "MINT";
		case 4:
			return "PURPLE";
		case 5:
			return "BLUE";
		case 0:
		default:
			return "BLACK";
		}
	}

	public void primarySuccessButton(JButton button, 
			Border border, 
			Color backgroundColor, 
			Font font
		) {
		button.setEnabled(true);
		button.setOpaque(true);
		button.setBorder(border);
		button.setBackground(backgroundColor);
		button.setForeground(Color.WHITE);
		button.setFont(font);
		
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
					button.setBackground(Theme.SUCCESS_ALT);
					button.setForeground(new Color(191, 191, 191));
				}
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if(button.isEnabled()) {
					button.setBackground(Theme.SUCCESS);
					button.setForeground(Color.WHITE);
				}
			}
			
		});
	}
	
	public void primaryDangerButton(JButton button, 
			Border border, 
			Color backgroundColor, 
			Font font
		) {
		button.setEnabled(true);
		button.setOpaque(true);
		button.setBorder(border);
		button.setBackground(backgroundColor);
		button.setForeground(Color.WHITE);
		button.setFont(font);
		
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
					button.setBackground(Theme.DANGER_ALT);
					button.setForeground(new Color(191, 191, 191));
				}
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if(button.isEnabled()) {
					button.setBackground(Theme.DANGER);
					button.setForeground(Color.WHITE);
				}
			}
			
		});
	}
}
