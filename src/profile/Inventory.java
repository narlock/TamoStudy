package profile;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 
 * @author Anthony Narlock
 * @desc Inventory for profile
 *
 */

public class Inventory {
	
	private String invString;
	private ArrayList<Item> items;
	
	@SuppressWarnings("serial")
	private final HashMap<String, String> dictionaryName = new HashMap<String, String>()
	{{
		put("0","redBg"); 
		put("1","blueBg"); 
		put("2","greenBg"); 
		put("3","orangeBg"); 
		put("4","purpleBg"); 
		put("5","yellowBg"); 
		put("6","greyBg"); 
		put("7","bg1"); 
		put("8","bg2"); 
		put("9","bg3");
		put("a","bg4");
		put("b","bg5"); 
	}};
	/*
	 * Default constructor - first time
	 */
	public Inventory() {
		this.invString = "-";
		this.items = new ArrayList<Item>();
	}
	
	public Inventory(String aline) {
		this.invString = aline;
		this.items = new ArrayList<Item>();
		updateItemList();
	}
	
	/*
	 * UpdateItemList updates the arraylist
	 * to contain the property item contents
	 */
	public void updateItemList() {
		if(this.invString.equals("-")) {
			//Do nothing - no inventory
		} else {
			String[] ch = this.invString.split("");
			for (String value : ch) {
				items.add(new Item(dictionaryName.get(value), value));
			}
		}
	}
	
	/*
	 * Add Item to inventory
	 * Adds to arraylist, updates string
	 */
	public void addItem(String indicator) {
		if(this.invString.equals("-")) {
			this.invString = indicator;
			items.add(new Item(dictionaryName.get(indicator), indicator));
		} else {
			this.invString = this.invString + indicator; //appends to end
			items.add(new Item(dictionaryName.get(indicator), indicator));
		}
	}
	
	public ArrayList<Item> getItemList() {
		return items;
	}
	
	public String getInvString() {
		return invString;
	}
	
	public void setInvString(String str) {
		this.invString = str;
	}
}
