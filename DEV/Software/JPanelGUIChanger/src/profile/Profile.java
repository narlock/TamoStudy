package profile;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import language.EnglishStrategy;
import language.LanguageStrategy;
import resources.Theme;

/**
 * @author Anthony Narlock (narlock)
 * @description: Profile Object class
 */

public class Profile {
	private SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	
	//The file that we will write to
	//More convenient to just store the file with the profile
	//This way we don't need to pass both and we can just
	//rewrite profile file inside of the profile file
	//TODO
	private File file;
	
	//Immutable
	private String username;				//Username field
	private Date joinDate;					//User's join date
		private String joinDateString;
	
	//Mutable
	private Date lastLoginDate;				//Previous Login Date
		private String lastLoginDateString;
	private Date newLoginDate;				//Newly generated login date
		private String newLoginDateString;	//used to compare days since login
	
	private int tamoTokens;					//amount of Tamo Tokens
	private int totalTime;					//amount of total focus time
	private int bgIndicator;				//background Integer indicator
	private int themeIndicator;				//theme Integer indicator
	private int strikes;					//profile strikes
	
	private Tamo tamo;						//user's Tamo
	
	private LanguageStrategy lang;			//user's language
	private int languageIndicator;
	
	private String ahmString; 				
											// ahmString is a String that will be flagged depending
											// on what achievements have been earned/not earned.
											// Like a light switch, this string could look like
											// "110010100110", where each digit is an achievement.
											// 0 means it has not been achieved,
											// 1 means it has been achieved.
	private Settings settings;
	
	//Default [TESTING] Constructor
	public Profile() {
		this.username = "Anthony";
		this.joinDateString = "2020-01-31";
		this.tamoTokens = 5000;
		this.totalTime = 12345678;
		this.bgIndicator = 0;
		this.themeIndicator = 0;
		this.strikes = 0;
		this.tamo = new Tamo("Lisa");
		this.languageIndicator = 0;
		this.lang = setLanguageStrategy(languageIndicator);
		this.ahmString = "110010100000000";
		this.settings = new Settings();
	}
	
	//New Profile Constructor - Created by initial 'Welcome' interface
	public Profile(String username, String tamoName, int languageIndicator, int difficulty) {
		//TODO
	}
	
	//Load Profile Constructor
	public Profile(
			String username,
			String joinDateString,
			String lastLoginDateString,
			int tamoTokens,
			int totalTime,
			int bgIndicator,
			int themeIndicator,
			int strikes,
			String tamoName,
			int tamoHappiness,
			int tamoHunger,
			int tamoId,
			int languageIndicator,
			String ahmString
		) {
		
		this.username = username;
		this.joinDateString = joinDateString;
		this.lastLoginDateString = lastLoginDateString;
		
		//TODO
		//Modify the dates accordingly
		
		this.tamoTokens = tamoTokens;
		this.totalTime = totalTime;
		this.bgIndicator = bgIndicator;
		this.themeIndicator = themeIndicator;
		this.strikes = strikes;
		
		this.tamo = new Tamo(tamoName, tamoHappiness, tamoHunger, tamoId);
		this.languageIndicator = languageIndicator;
		this.lang = setLanguageStrategy(languageIndicator);
		
		this.ahmString = ahmString;
	}
	
	//TODO method to update the file
	public void updateFile() {
		//TODO Will write to the file and update its contents
	}
	
	//Getter/Setter Methods

	public String getUsername() {
		return username;
	}

	public String getJoinDateString() {
		return joinDateString;
	}

	public String getLastLoginDateString() {
		return lastLoginDateString;
	}

	public String getNewLoginDateString() {
		return newLoginDateString;
	}

	public void setNewLoginDateString(String newLoginDateString) {
		this.newLoginDateString = newLoginDateString;
	}

	public int getTamoTokens() {
		return tamoTokens;
	}

	public void setTamoTokens(int tamoTokens) {
		this.tamoTokens = tamoTokens;
	}

	public int getTotalTime() {
		return totalTime;
	}

	public void setTotalTime(int totalTime) {
		this.totalTime = totalTime;
	}

	public int getBgIndicator() {
		return bgIndicator;
	}

	public void setBgIndicator(int bgIndicator) {
		this.bgIndicator = bgIndicator;
	}

	public int getStrikes() {
		return strikes;
	}

	public void setStrikes(int strikes) {
		this.strikes = strikes;
	}

	public Tamo getTamo() {
		return tamo;
	}
	
	public LanguageStrategy setLanguageStrategy(int languageIndicator) {
		//English
		if(languageIndicator == 0)
			return new EnglishStrategy();
		else
			return new EnglishStrategy();
	}
	
	public LanguageStrategy getLanguage() {
		/*
		 * We can access the language text
		 * we are looking for with simply
		 * profile.getLanguage().<our Text array>[indicator];
		 */
		return lang;
	}
	
	/**
	 * getThemeIndicator
	 * @return a new Theme object with respective indicator
	 */
	public Theme getThemeIndicator() {
		return new Theme(themeIndicator);
	}
	
	public void setThemeIndicator(int themeIndicator) {
		this.themeIndicator = themeIndicator;
	}

	public String getAhmString() {
		return ahmString;
	}

	public void setAhmString(String ahmString) {
		this.ahmString = ahmString;
	}

	public Settings getSettings() {
		return settings;
	}
	
	/**
	 * getTamoLevel
	 * @return the Tamo level
	 */
	public int getTamoLevel() {
		return (totalTime / 86400);
	}
	
	/**
	 * getTotalFocusHours
	 * @return totalTime in hours
	 */
	public double getTotalFocusHours() {
		double totalHours = totalTime * 0.000277778;
		totalHours = Math.round(totalHours * 100.0) / 100.0;
		return totalHours;
	}
	
}
