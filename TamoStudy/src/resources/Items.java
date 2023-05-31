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
	
	public static String getFoodDescriptionByIndicator(int indicator) {
		switch(indicator) {
		case 0:
			return "<html>A traditional Japanese snack<br>made of seasoned rice shaped<br>into a ball or triangle,<br>often with a filling, and<br>wrapped in seaweed.<br><br>Restores 1 hunger point.</html>";
		case 1:
			return "<html>A dish featuring cooked<br>chicken served with a<br>variety of sides and<br>accompaniments.<br><br>Restores 3 hunger points.</html>";
		case 2:
			return "<html>A rich and creamy dessert<br>made with a crust of<br>crushed biscuits or pastry,<br>filled with a smooth mixture<br>of cream cheese and sugar.<br><br>Restores 8 hunger points.</html>";
		}
		throw new RuntimeException("Unknown indicator provided to getFoodDescriptionByIndicator");
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
	
	public static String getBackgroundDescriptionByIndicator(int indicator) {
		switch(indicator) {
		case 0:
			return "Bedroom Description";
		case 1:
			return "Sofa Description";
		case 2:
			return "Starlight Description";
		case 3:
			return "Night out Description";
		case 4:
			return "Enigma Description";
		}
		throw new RuntimeException("Unknown indicator provided to getBackgroundDescriptionByIndicator");
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
	
	public static String getBorderDescriptionByIndicator(int indicator) {
		switch(indicator) {
		case 0:
			return "Black Description";
		case 1:
			return "Gold Description";
		case 2:
			return "Red Description";
		case 3:
			return "Mint Description";
		case 4:
			return "Purple Description";
		case 5:
			return "Blue Description";
		case 6:
			return "Strawberry Lemonade Description";
		}
		throw new RuntimeException("Unknown indicator provided to getBorderDescriptionByIndicator");
	}
}
