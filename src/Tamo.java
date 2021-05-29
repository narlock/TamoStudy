/**
 * @author: Anthony Narlock
 * @description: Tamo Object class
 */

import java.util.concurrent.ThreadLocalRandom;

public class Tamo {
	private String name;
	private int level;
	private int experience;
	private int happiness;
	private int hunger;
	private int id;
	
	/*
	 * Default Constructor
	 * 
	 * Yields default attributes
	 */
	public Tamo() {
		this.name = "null";
		this.level = -1;
		this.experience = -1;
		this.happiness = -1;
		this.hunger = -1;
		this.id = 0;
	}
	
	/*
	 * New Tamo Constructor
	 * 
	 * Yields default attributes, but name is set
	 */
	public Tamo(String name) {
		this.name = name;
		this.level = 0;
		this.experience = 0;
		this.happiness = 5;
		this.hunger = 5;
		
		//TODO: Random ID
		this.id = ThreadLocalRandom.current().nextInt(1, 3 + 1);
	}
	
	/*
	 * Old Load Tamo constructor
	 * 
	 * Yields previously stored attributes
	 */
	public Tamo(String name, int level, int happiness, int hunger) {
		this.name = name;
		this.level = level;
		this.happiness = happiness;
		this.hunger = hunger;
		this.id = 0;
	}
	
	/*
	 * Load Tamo constructor
	 * 
	 * Yields previously stored attributes
	 */
	public Tamo(String name, int level, int happiness, int hunger, int id) {
		this.name = name;
		this.level = level;
		this.happiness = happiness;
		this.hunger = hunger;
		this.id = id;
	}

	//getters
	public String getName() {
		return name;
	}
	
	public int getLevel() {
		return level;
	}
	
	public int getHappiness() {
		return happiness;
	}
	
	public int getHunger() {
		return hunger;
	}
	
	//setters
	public void setHappiness(int happiness) {
		this.happiness = happiness;
	}
	
	public void setHunger(int hunger) {
		this.hunger = hunger;
	}
	
	//increment levels and decrement
	public void incrementHappiness() {
		if(this.happiness >= 0 && this.happiness < 10) {
			this.happiness = happiness++;
		} else {
			//Happiness level will not change because max already reached...
		}
		
	}
	
	public void incrementHunger() {
		if(this.hunger >= 0 && this.hunger < 10) {
			this.hunger = hunger++;
		} else {
			//hunger level will not change because max already reached...
		}
	}
	
	public void decrementHappiness() {
		if(this.happiness > 0 && this.happiness <= 10) {
			this.happiness = happiness--;
		} else {
			//happy level already lowest... 
		}
	}
	
	public void decrementHunger() {
		if(this.hunger > 0 && this.hunger <= 10) {
			this.hunger = hunger--;
		} else {
			//happy level already lowest... 
		}
	}
	
	public String tamoInfo() {
		return name + "," + level + "," + happiness + "," + hunger;
	}
	
	@Override
	public String toString() {
		return
				"Name: " + name +
				"\nLevel: " + level +
				"\nHappiness: " + happiness +
				"\nHunger: " + hunger;
	}

	public void setName(String tamoName) {
		this.name = tamoName;
		
	}

	public void setLevel(int i) {
		this.level = i;
		
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
