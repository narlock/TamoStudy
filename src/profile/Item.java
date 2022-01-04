package profile;

/**
 * 
 * @author Anthony Narlock
 * @desc Inventory for profile
 *
 */

public class Item {
	private String name;
	private int indicator;
	
	public Item(String name, int indicator) {
		this.name = name;
		this.indicator = indicator;
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
