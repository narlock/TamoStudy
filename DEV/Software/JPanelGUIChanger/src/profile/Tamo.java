package profile;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author Anthony Narlock (narlock)
 * Tamo Object Class
 */

public class Tamo {
	/**
	 * Tamo Attributes
	 */
	private String name;
	private int happiness, hunger, id;
	
	//Default constructor for testing
	public Tamo() {
		this.name = "Lisa";
		this.happiness = 5;
		this.hunger = 5;
		this.id = 0;
	}
	
	//New Tamo Constructor
	//Will only run when new profile is made
	public Tamo(String name) {
		this.name = name;
		this.happiness = 10;
		this.hunger = 5;
		this.id = ThreadLocalRandom.current().nextInt(1, 3 + 1);
	}
	
	//Load Tamo Constructor
	public Tamo(String name, int happiness, int hunger, int id) {
		this.name = name;
		this.happiness = happiness;
		this.hunger = hunger;
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHappiness() {
		return happiness;
	}

	public void setHappiness(int happiness) {
		this.happiness = happiness;
	}

	public int getHunger() {
		return hunger;
	}

	public void setHunger(int hunger) {
		this.hunger = hunger;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getImageUrl(int indicator) {
		/**
		 * The parameter 'indicator' is an integer
		 * that represents which mood the tamo is in.
		 * 0 -> normal (gif)
		 * 1 -> happy (gif)
		 * 2 -> sad (png)
		 * 3 -> hungry (png)
		 * 4 -> focus (png)
		 */
		
		switch (id) {
		case 0:
			//Alpha Tamo
			if(indicator == 0) { return "TAMO_NORMAL_0.png"; }
			if(indicator == 1) { return "TAMO_HAPPY_0.png"; }
			if(indicator == 2) { return "TAMO_SAD_0.png"; }
			if(indicator == 3) { return "TAMO_HUNGRY_0.png"; }
			if(indicator == 4) { return "TAMO_FOCUS_0.png"; }
		case 1:
			//Beta Tamo
			if(indicator == 0) { return "TAMO_NORMAL_1.gif"; }
			if(indicator == 1) { return "TAMO_HAPPY_1.gif"; }
			if(indicator == 2) { return "TAMO_SAD_1.png"; }
			if(indicator == 3) { return "TAMO_HUNGRY_1.png"; }
			if(indicator == 4) { return "TAMO_FOCUS_1.png"; }
		case 2:
			//Bee
			if(indicator == 0) { return "TAMO_NORMAL_2.gif"; }
			if(indicator == 1) { return "TAMO_HAPPY_2.gif"; }
			if(indicator == 2) { return "TAMO_SAD_2.png"; }
			if(indicator == 3) { return "TAMO_HUNGRY_2.png"; }
			if(indicator == 4) { return "TAMO_FOCUS_2.png"; }
		case 3:
			//Bear
			if(indicator == 0) { return "TAMO_NORMAL_3.gif"; }
			if(indicator == 1) { return "TAMO_HAPPY_3.gif"; }
			if(indicator == 2) { return "TAMO_SAD_3.png"; }
			if(indicator == 3) { return "TAMO_HUNGRY_3.png"; }
			if(indicator == 4) { return "TAMO_FOCUS_3.png"; }
		case 4:
			//Snake
			if(indicator == 0) { return "TAMO_NORMAL_4.gif"; }
			if(indicator == 1) { return "TAMO_HAPPY_4.gif"; }
			if(indicator == 2) { return "TAMO_SAD_4.png"; }
			if(indicator == 3) { return "TAMO_HUNGRY_4.png"; }
			if(indicator == 4) { return "TAMO_FOCUS_4.png"; }
		}
		
		//If none match, return null
		//This should never happen
		return null;
	}
}
