package resources;

import javax.swing.ImageIcon;

import model.GuiSize;

public class Items {
	public static String getFoodTitleByIndicator(int indicator) {
		switch(indicator) {
		case 0:
			return "Onigiri";
		case 1:
			return "Chicken Plate";
		case 2:
			return "Cheesecake";
		}
		throw new RuntimeException("Unknown indicator provided to getFoodTitleByIndicator");
	}
	
	public static ImageIcon getFoodIconByIndicator(int indicator) {
		switch(indicator) {
		case 0:
			return new ImageIcon(Items.class.getClassLoader().getResource("FOOD_1.png"));
		case 1:
			return new ImageIcon(Items.class.getClassLoader().getResource("FOOD_3.png"));
		case 2:
			return new ImageIcon(Items.class.getClassLoader().getResource("FOOD_10.png"));
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
	
	public static String getBackgroundTitleByIndicator(int indicator) {
		switch(indicator) {
		case 0:
			return "Bedroom";
		case 1:
			return "Sofa";
		case 2:
			return "Starlight";
		case 3:
			return "Night out";
		case 4:
			return "Enigma";
		}
		throw new RuntimeException("Unknown indicator provided to getBackgroundTitleByIndicator");
	}
	
	public static ImageIcon getBackgroundIconByIndicator(int indicator) {
		return new ImageIcon(Items.class.getClassLoader().getResource("BACKGROUND_" + indicator + "_SHOP.png"));
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
	
	public static String getBorderTitleByIndicator(int indicator) {
		switch(indicator) {
		case 0:
			return "Black";
		case 1:
			return "Gold";
		case 2:
			return "Red";
		case 3:
			return "Mint";
		case 4:
			return "Purple";
		case 5:
			return "Blue";
		case 6:
			return "Strawberry Lemonade";
		}
		throw new RuntimeException("Unknown indicator provided to getBorderTitleByIndicator");
	}
	
	public static ImageIcon getBorderIconByIndicator(int indicator) {
		switch(indicator) {
		case 0:
			return new ImageIcon(Items.class.getClassLoader().getResource("BORDER_BLACK_SHOP.png"));
		case 1:
			return new ImageIcon(Items.class.getClassLoader().getResource("BORDER_GOLD_SHOP.png"));
		case 2:
			return new ImageIcon(Items.class.getClassLoader().getResource("BORDER_RED_SHOP.png"));
		case 3:
			return new ImageIcon(Items.class.getClassLoader().getResource("BORDER_MINT_SHOP.png"));
		case 4:
			return new ImageIcon(Items.class.getClassLoader().getResource("BORDER_PURPLE_SHOP.png"));
		case 5:
			return new ImageIcon(Items.class.getClassLoader().getResource("BORDER_BLUE_SHOP.png"));
		case 6:
			return new ImageIcon(Items.class.getClassLoader().getResource("BORDER_STRAWLEMON_SHOP.png"));
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
}
