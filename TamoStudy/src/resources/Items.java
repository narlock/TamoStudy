package resources;

import javax.swing.ImageIcon;

import model.GuiSize;
import model.language.Language;

public class Items {
	public static String getFoodTitleByIndicator(int indicator, Language language) {
		switch(indicator) {
		case 0:
			return language.onigiriText;
		case 1:
			return language.chickenPlateText;
		case 2:
			return language.cheesecakeText;
		}
		throw new RuntimeException("Unknown indicator provided to getFoodTitleByIndicator");
	}
	
	public static int getFoodHungerByIndicator(int indicator) {
		switch(indicator) {
		case 0:
			return 1;
		case 1:
			return 3;
		case 2:
			return 8;
		}
		throw new RuntimeException("Unknown indicator provided to getFoodHungerByIndicator");
	}
	
	public static ImageIcon getFoodIconByIndicator(int indicator, GuiSize guiSize) {
		switch(indicator) {
		case 0:
			return guiSize.scaleImageIcon(new ImageIcon(Items.class.getClassLoader().getResource("FOOD_1.png")));
		case 1:
			return guiSize.scaleImageIcon(new ImageIcon(Items.class.getClassLoader().getResource("FOOD_3.png")));
		case 2:
			return guiSize.scaleImageIcon(new ImageIcon(Items.class.getClassLoader().getResource("FOOD_10.png")));
		}
		throw new RuntimeException("Unknown indicator provided to getFoodIconByIndicator");
	}
	
	public static ImageIcon getFoodInvIconByIndicator(int indicator, GuiSize guiSize) {
		switch(indicator) {
		case 0:
			return guiSize.scaleImageIcon(new ImageIcon(Items.class.getClassLoader().getResource("FOOD_1_INV.png")));
		case 1:
			return guiSize.scaleImageIcon(new ImageIcon(Items.class.getClassLoader().getResource("FOOD_3_INV.png")));
		case 2:
			return guiSize.scaleImageIcon(new ImageIcon(Items.class.getClassLoader().getResource("FOOD_10_INV.png")));
		}
		throw new RuntimeException("Unknown indicator provided to getFoodIconByIndicator");
	}
	
	public static int getFoodPriceByIndicator(int indicator) {
		switch(indicator) {
		case 0:
			return 100;
		case 1:
			return 200;
		case 2:
			return 800;
		}
		throw new RuntimeException("Unknown indicator provided to getFoodPriceByIndicator");
	}
	
	public static String getFoodDescriptionByIndicator(int indicator, Language language) {
		switch(indicator) {
		case 0:
			return language.onigiriDescriptionText;
		case 1:
			return language.chickenPlateDescriptionText;
		case 2:
			return language.cheesecakeDescriptionText;
		}
		throw new RuntimeException("Unknown indicator provided to getFoodDescriptionByIndicator");
	}
	
	public static String getBackgroundTitleByIndicator(int indicator, Language language) {
		switch(indicator) {
		case 0:
			return language.bedroomText;
		case 1:
			return language.sofaText;
		case 2:
			return language.sunriseText;
		case 3:
			return language.nightOutText;
		case 4:
			return language.enigmaText;
		}
		throw new RuntimeException("Unknown indicator provided to getBackgroundTitleByIndicator");
	}
	
	public static ImageIcon getBackgroundIconByIndicator(int indicator, GuiSize guiSize) {
		return guiSize.scaleImageIcon(new ImageIcon(Items.class.getClassLoader().getResource("BACKGROUND_" + indicator + "_SHOP.png")));
	}
	
	public static ImageIcon getBackgroundInvIconByIndicator(int indicator, GuiSize guiSize) {
		return guiSize.scaleImageIcon(new ImageIcon(Items.class.getClassLoader().getResource("BACKGROUND_" + indicator + "_INV.png")));
	}
	
	public static int getBackgroundPriceByIndicator(int indicator) {
		switch(indicator) {
		case 0:
		case 1:
		case 2:
		case 3:
		case 4:
			return 1000;
		}
		throw new RuntimeException("Unknown indicator provided to getBackgroundPriceByIndicator");
	}
	
	public static String getBackgroundDescriptionByIndicator(int indicator, Language language) {
		switch(indicator) {
		case 0:
			return language.bedroomDescriptionText;
		case 1:
			return language.sofaDescriptionText;
		case 2:
			return language.sunriseDescriptionText;
		case 3:
			return language.nightOutDescriptionText;
		case 4:
			return language.enigmaDescriptionText;
		}
		throw new RuntimeException("Unknown indicator provided to getBackgroundDescriptionByIndicator");
	}
	
	public static String getBorderTitleByIndicator(int indicator, Language language) {
		switch(indicator) {
		case 0:
			return language.blackText;
		case 1:
			return language.goldText;
		case 2:
			return language.redText;
		case 3:
			return language.mintText;
		case 4:
			return language.purpleText;
		case 5:
			return language.blueText;
		case 6:
			return language.strawberryLemonadeText;
		}
		throw new RuntimeException("Unknown indicator provided to getBorderTitleByIndicator");
	}
	
	public static ImageIcon getBorderIconByIndicator(int indicator, GuiSize guiSize) {
		switch(indicator) {
		case 0:
			return guiSize.scaleImageIcon(new ImageIcon(Items.class.getClassLoader().getResource("BORDER_BLACK_SHOP.png")));
		case 1:
			return guiSize.scaleImageIcon(new ImageIcon(Items.class.getClassLoader().getResource("BORDER_GOLD_SHOP.png")));
		case 2:
			return guiSize.scaleImageIcon(new ImageIcon(Items.class.getClassLoader().getResource("BORDER_RED_SHOP.png")));
		case 3:
			return guiSize.scaleImageIcon(new ImageIcon(Items.class.getClassLoader().getResource("BORDER_MINT_SHOP.png")));
		case 4:
			return guiSize.scaleImageIcon(new ImageIcon(Items.class.getClassLoader().getResource("BORDER_PURPLE_SHOP.png")));
		case 5:
			return guiSize.scaleImageIcon(new ImageIcon(Items.class.getClassLoader().getResource("BORDER_BLUE_SHOP.png")));
		case 6:
			return guiSize.scaleImageIcon(new ImageIcon(Items.class.getClassLoader().getResource("BORDER_STRAWLEMON_SHOP.png")));
		}
		throw new RuntimeException("Unknown indicator provided to getBorderIconByIndicator");
	}
	
	public static ImageIcon getBorderInvIconByIndicator(int indicator, GuiSize guiSize) {
		switch(indicator) {
		case 0:
			return guiSize.scaleImageIcon(new ImageIcon(Items.class.getClassLoader().getResource("BORDER_BLACK_INV.png")));
		case 1:
			return guiSize.scaleImageIcon(new ImageIcon(Items.class.getClassLoader().getResource("BORDER_GOLD_INV.png")));
		case 2:
			return guiSize.scaleImageIcon(new ImageIcon(Items.class.getClassLoader().getResource("BORDER_RED_INV.png")));
		case 3:
			return guiSize.scaleImageIcon(new ImageIcon(Items.class.getClassLoader().getResource("BORDER_MINT_INV.png")));
		case 4:
			return guiSize.scaleImageIcon(new ImageIcon(Items.class.getClassLoader().getResource("BORDER_PURPLE_INV.png")));
		case 5:
			return guiSize.scaleImageIcon(new ImageIcon(Items.class.getClassLoader().getResource("BORDER_BLUE_INV.png")));
		case 6:
			return guiSize.scaleImageIcon(new ImageIcon(Items.class.getClassLoader().getResource("BORDER_STRAWLEMON_INV.png")));
		}
		throw new RuntimeException("Unknown indicator provided to getBorderIconByIndicator");
	}
	
	public static int getBorderPriceByIndicator(int indicator) {
		switch(indicator) {
		case 0:
		case 1:
		case 2:
		case 3:
		case 4:
		case 5:
			return 750;
		case 6:
			return 1250;
		}
		throw new RuntimeException("Unknown indicator provided to getBorderPriceByIndicator");
	}
	
	public static String getBorderDescriptionByIndicator(int indicator, Language language) {
		switch(indicator) {
		case 0:
			return language.solidBackgroundText;
		case 1:
			return language.solidBackgroundText;
		case 2:
			return language.solidBackgroundText;
		case 3:
			return language.solidBackgroundText;
		case 4:
			return language.solidBackgroundText;
		case 5:
			return language.solidBackgroundText;
		case 6:
			return language.gradientBackgroundText;
		}
		throw new RuntimeException("Unknown indicator provided to getBorderDescriptionByIndicator");
	}
}
