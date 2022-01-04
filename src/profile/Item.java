package profile;

import java.util.HashMap;

/**
 * 
 * @author Anthony Narlock
 * @desc Inventory for profile
 *
 */

public class Item {
	private String name;
	private int indicator;
	
	@SuppressWarnings("serial")
	private final HashMap<String, Integer> dictionary = new HashMap<String, Integer>()
			{{
				put("0",0); 
				put("1",1); 
				put("2",2); 
				put("3",3); 
				put("4",4); 
				put("5",5); 
				put("6",6); 
				put("7",7); 
				put("8",8); 
				put("9",9);
				put("a",10); 
				put("b",11); 
				put("c",12); 
				put("d",13);
			}};
	
	public Item(String name, String indicator) {
		this.name = name;
		this.indicator = dictionary.get(indicator);
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getIndicator() {
		return indicator;
	}
	public void setIndicator(int indicator) {
		this.indicator = indicator;
	}
	
	
}
