package model.profile;

import java.util.Random;

import util.Utils;

public class Tamo {

	private String name;
	
	private long time;
	
	private long type;
	
	private String birthDateString;
	
	private String passDateString;
	
	private long happy;
	
	private long hunger;
	
	/**
	 * Tamo(name)
	 * @brief Constructor for new profile Tamo
	 */
	public Tamo(String name) {
		super();
		this.time = 0;
		this.name = name;
		this.type = generateRandomTamoType();
		this.birthDateString = Utils.todayAsString();
		this.passDateString = null;
		this.happy = 5;
		this.hunger = 5;
	}
	
	/**
	 * Tamo(name, type, birthDateString, passDateString)
	 * @brief Constructor for deceased Tamo
	 */
	public Tamo(String name, long time, long type, String birthDateString, String passDateString) {
		super();
		this.name = name;
		this.time = time;
		this.type = type;
		this.birthDateString = birthDateString;
		this.passDateString = passDateString;
	}

	/**
	 * Tamo(name, type, birthDateString, happy, hunger)
	 * @brief Constructor for loading Tamo
	 */
	public Tamo(String name, long time, long type, String birthDateString, long happy, long hunger) {
		super();
		this.name = name;
		this.time = time;
		this.type = type;
		this.birthDateString = birthDateString;
		this.passDateString = null;
		this.happy = happy;
		this.hunger = hunger;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}

	public long getType() {
		return type;
	}

	public void setType(long type) {
		this.type = type;
	}

	public String getBirthDateString() {
		return birthDateString;
	}

	public void setBirthDateString(String birthDateString) {
		this.birthDateString = birthDateString;
	}

	public String getPassDateString() {
		return passDateString;
	}

	public void setPassDateString(String passDateString) {
		this.passDateString = passDateString;
	}

	public long getHappy() {
		return happy;
	}

	public void setHappy(long happy) {
		this.happy = happy;
	}

	public long getHunger() {
		return hunger;
	}

	public void setHunger(long hunger) {
		this.hunger = hunger;
	}
	
	private long generateRandomTamoType() {
		int max = 10;
		int min = 1;
		Random random = new Random();
        return random.nextInt(max - min + 1) + min;
	}
	
	private int getLevelFromTime() {
		// TODO
		return 10;
	}
}
