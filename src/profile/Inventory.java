package profile;

import java.util.ArrayList;

/**
 * 
 * @author Anthony Narlock
 * @desc Inventory for profile
 *
 */

public class Inventory {
	private final int MAX_INVENTORY_COUNT = 11;
	
	private int[] indicator;
	private String[] stringIndicator;
	private String invString;
	private ArrayList<Item> items;
	
	private String[] itemIndicator = 
		{"redBg","blueBg","greenBg","orangeBg","purpleBg","yellowBg","greyBg"
				,"bg1","bg2","bg3","bg4","bg5"
		};
	
	/*
	 * Default constructor - first time
	 */
	public Inventory() {
		this.invString = "-1";
	}
	
	public Inventory(String aline) {
		this.invString = aline;
		updateItemList();
	}
	
	/*
	 * UpdateItemList updates the arraylist
	 * to contain the property item contents
	 */
	public void updateItemList() {
		if(this.invString.equals("-1")) {
			//Do nothing - no inventory
		} else {
			char[] ch = this.invString.toCharArray();
			for(int i = 0; i < ch.length; i++) {
				int num = Integer.parseInt(String.valueOf(ch[i])); //Converts char to int
				items.add(new Item(itemIndicator[num], num)); //Adds item with associated (name, indicator)
			}
		}
	}
	
	/*
	 * Add Item to inventory
	 * Adds to arraylist, updates string
	 */
	public void addItem(int indicator) {
		if(this.invString.equals("-1")) {
			this.invString = Integer.toString(indicator);
			items.add(new Item(itemIndicator[indicator], indicator));
		} else {
			this.invString = this.invString + indicator; //appends to end
			items.add(new Item(itemIndicator[indicator], indicator));
		}
	}
}
