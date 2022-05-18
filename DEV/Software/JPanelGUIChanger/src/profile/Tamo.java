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
}
