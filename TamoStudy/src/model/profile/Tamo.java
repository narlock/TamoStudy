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
	
	private long strikes;
	
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
		this.setStrikes(0);
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
	public Tamo(String name, long time, long type, String birthDateString, long happy, long hunger, long strikes) {
		super();
		this.name = name;
		this.time = time;
		this.type = type;
		this.birthDateString = birthDateString;
		this.passDateString = null;
		this.happy = happy;
		this.hunger = hunger;
		this.setStrikes(strikes);
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
	
	public long getStrikes() {
		return strikes;
	}

	public void setStrikes(long strikes) {
		this.strikes = strikes;
	}
	
	@Override
	public String toString() {
		return "Tamo [name=" + name + ", time=" + time + ", type=" + type + ", birthDateString=" + birthDateString
				+ ", passDateString=" + passDateString + ", happy=" + happy + ", hunger=" + hunger + ", strikes="
				+ strikes + "]";
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

	/**
	 * @return status
	 * @brief Based off of happy and hunger, the status of the
	 * Tamo will be determined. If focused, then will be in focus.
	 * 
	 * If focused is true, return FOCUS
	 * If happy is 3 or below, return SAD
	 * If hunger is 3 or below, return HUNGRY
	 * If happy is 7 or above, return HAPPY
	 * Otherwise, return NORMAL
	 */
	public String getStatus(boolean focused) {
		
		// Get Status String
		if(focused) {
			return "FOCUS";
		}
		
		if(happy <= 3) {
			return "SAD";
		}
		
		if(hunger <= 3) {
			return "HUNGRY";
		}
		
		if(happy >= 7) {
			return "HAPPY";
		}
		
		return "NORMAL";
	}
	
	// Every 24 hours studied, a new level is earned
	public int getLevel() {
		return (int) time / 86400;
	}
	
	public int levelProgress() {
		int level = getLevel();
	    double secondsToNextLevel = (level + 1) * 86400 - time;
	    double progressToNextLevel = ((86400 - secondsToNextLevel) / 86400) * 100;
	    return (int) progressToNextLevel;
	}

}
