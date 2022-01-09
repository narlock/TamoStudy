package profile;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * 
 * @author Anthony Narlock
 * @description Achievements for profile
 *
 */

public class Achievements {
	private final int ACHIEVEMENT_COUNT = 8;
	
	//Title of Achievement
	private String[] title = 
		{"The Beginning",
		"Nothing can stop you!",
		"Never give up!",
		"Customizer 1",
		"Customizer 2",
		"From the beginning",
		"Tamo full",
		"Tamo Love",
		"Dedication 1",
		"Dedication 2",
		"Dedicated"}; 
	//Description of Achievement
	private String[] desc = 
		{"Reach Total focus time of 3 hours",
		"Reach Total focus time of 1 day",
		"Reach Total focus time of 7 days",
		"Change your background color",
		"Change your Tamo's background",
		"Updated profile from a version before beta",
		"Entering the food shop when Tamo is full",
		"Achieve maximum Tamo happiness",
		"Log into TamoStudy consecutively for 7 days",
		"Log into TamoStudy consecutively for 14 days",
		"Log into TamoStudy consecutively for 30 days"};
	
	//Indicator of Achievement
	private int[] indicator;
	private String[] stringIndicator;
	private String ahmString;
	
	/*
	 * New Profile: Achievements will not be filled in
	 */
	public Achievements() {
		this.indicator = new int[ACHIEVEMENT_COUNT];
		this.stringIndicator = new String[ACHIEVEMENT_COUNT];
		
		this.ahmString = "00000000";
		
		updateAchievements();
	}
	
	/*
	 * Loaded Profile: Achievements will be updated
	 */
	public Achievements(String aline) {
		this.ahmString = aline;
		
		this.indicator = new int[ACHIEVEMENT_COUNT];
		this.stringIndicator = new String[ACHIEVEMENT_COUNT];

		updateAchievements(aline);
	}

	public void updateAchievements() {
		for(int i = 0; i < indicator.length; i++) {
			this.indicator[i] = 0;
		}
		
		for(int i = 0; i < indicator.length; i++) {
			this.stringIndicator[i] = "0";
		}
		
	}
	
	public void updateAchievements(String aline) {
		/*
		 * Program will split the String into substring for recognition
		 * Then will set the achievements according to their values
		 * 
		 * Ex: 10101010
		 * This maps to the profile having achievements 0,3,5, and 7
		 */
		
		for(int i = 0; i < indicator.length; i++) {
			stringIndicator[i] = ahmString.substring(i,i+1);
			//System.out.println("stringIndicator[" + i + "] = " + stringIndicator[i] );
		}
		 
		for(int i = 0; i < indicator.length; i++) {
			this.indicator[i] = Integer.parseInt(stringIndicator[i]);
		}
	}
	
	public String getTitle(int index) {
		return this.title[index];
	}
	
	public String getDesc(int index) {
		return this.desc[index];
	}
	
	public void setAchievementIndicator(int ahm) {
		this.indicator[ahm] = 1;
		this.stringIndicator[ahm] = "1";
		this.ahmString = String.join("", stringIndicator);
		runDebug();
	}
	
	public void setIndicator(int index, int value) {
		this.indicator[index] = value;
		updateIndicatorString();
	}
	
	public int getIndicator(int index) {
		return this.indicator[index];
	}
	
	public String getAhmString() {
		return this.ahmString;
	}
	
	public void runDebug() {
		System.out.println("RUNNING ACHIEVEMENTS DEBUG:"
				+ "\nIndicator = ");
		for(int i = 0; i < indicator.length; i++) {
			System.out.print(this.indicator[i]);
		}
		
		System.out.println("stringIndicator = ");
		
		for(int i = 0; i < indicator.length; i++) {
			System.out.print(this.stringIndicator[i]);
		}
		
		System.out.println("ahmString = " + ahmString);
	}
	
	
	public void updateIndicatorString() {
		System.out.println("DEBUG: AHMSTRING BEFORE: " + ahmString);
		//Update ahmString
		this.ahmString = Arrays.stream(indicator).mapToObj(String::valueOf).collect(Collectors.joining(""));
		
		System.out.println("DEBUG: AHMSTRING AFTER: " + ahmString);
	}
	
	
}
