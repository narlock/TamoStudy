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
		this.happiness = 5;
		this.hunger = 5;
		this.id = ThreadLocalRandom.current().nextInt(1, 4 + 1);
	}
	
	//Load Tamo Constructor
	public Tamo(String name, int happiness, int hunger, int id) {
		this.name = name;
		this.happiness = happiness;
		this.hunger = hunger;
		this.id = id;
	}
	
	//Getters and Setters
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
	
	/**
	 * getImageUrl
	 * @param inFocus
	 * @return the correct image URL
	 */
	public String getImageUrl(boolean inFocus) {
		
		//Gets appropriate Tamo Image
		switch (id) {
		case 0:
			//Alpha Tamo
			if(inFocus) { return "TAMO_FOCUS_0.png"; }
			if(happiness <= 3) { return "TAMO_SAD_0.png"; }
			if(hunger <= 3) { return "TAMO_HUNGRY_0.png"; }
			if(happiness > 3 && happiness <= 6) { return "TAMO_NORMAL_0.png"; }
			if(happiness > 6) { return "TAMO_HAPPY_0.png"; }
		case 1:
			//Beta Tamo
			if(inFocus) { return "TAMO_FOCUS_1.png"; }
			if(happiness <= 3) { return "TAMO_SAD_1.png"; }
			if(hunger <= 3) { return "TAMO_HUNGRY_1.png"; }
			if(happiness > 3 && happiness <= 6) { return "TAMO_NORMAL_1.gif"; }
			if(happiness > 6) { return "TAMO_HAPPY_1.gif"; }
		case 2:
			//Bee
			if(inFocus) { return "TAMO_FOCUS_2.png"; }
			if(happiness <= 3) { return "TAMO_SAD_2.png"; }
			if(hunger <= 3) { return "TAMO_HUNGRY_2.png"; }
			if(happiness > 3 && happiness <= 6) { return "TAMO_NORMAL_2.gif"; }
			if(happiness > 6) { return "TAMO_HAPPY_2.gif"; }
		case 3:
			//Bear
			if(inFocus) { return "TAMO_FOCUS_3.png"; }
			if(happiness <= 3) { return "TAMO_SAD_3.png"; }
			if(hunger <= 3) { return "TAMO_HUNGRY_3.png"; }
			if(happiness > 3 && happiness <= 6) { return "TAMO_NORMAL_3.gif"; }
			if(happiness > 6) { return "TAMO_HAPPY_3.gif"; }
		case 4:
			//Snake
			if(inFocus) { return "TAMO_FOCUS_4.png"; }
			if(happiness <= 3) { return "TAMO_SAD_4.png"; }
			if(hunger <= 3) { return "TAMO_HUNGRY_4.png"; }
			if(happiness > 3 && happiness <= 6) { return "TAMO_NORMAL_4.gif"; }
			if(happiness > 6) { return "TAMO_HAPPY_4.gif"; }
		}
		
		//If none match, return null
		//This should never happen
		return null;
	}
}
