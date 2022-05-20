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
	private File file;						//the file associated with the profile
	private ProfileReaderWriter	rw;			//the reader writer for the profile
	
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
	
	private String invString;				//This is the inventory string. Similar to the achievementString
											//this is a string that will be separated to determine the items
											//in the inventory. The items will be turned into item panesl
											//and will be able to be selected/used in the inventory menu
											//each item has a string that corresponds to it
											//for example, the default background is "0".
	
	private Settings settings;
	
	//Default [TESTING] Constructor
	public Profile() {
		this.username = "Anthony";
		this.joinDateString = "2020-01-31";
		this.tamoTokens = 5000;
		this.totalTime = 0;
		this.bgIndicator = 0;
		this.themeIndicator = 0;
		this.strikes = 0;
		this.tamo = new Tamo("Lisa");
		this.languageIndicator = 0;
		this.lang = setLanguageStrategy(languageIndicator);
		this.ahmString = "110010100000000";
		this.invString = "01";
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
			String ahmString,
			String invString
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
		this.invString = invString;
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
		else {
			this.languageIndicator = 0;
			return new EnglishStrategy();
		}
	}
	
	public LanguageStrategy getLanguage() {
		/*
		 * We can access the language text
		 * we are looking for with simply
		 * profile.getLanguage().<our Text array>[indicator];
		 */
		return lang;
	}
	
	public int getLanguageIndicator() {
		return languageIndicator;
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
	
	public void getAchievement(int i) {
		//i represents the index of the achievement
		String[] achievements = ahmString.split("");
		achievements[i] = "1"; //the achievement has been gotten
		StringBuilder builder = new StringBuilder();
		for(String s : achievements) { builder.append(s); }
		ahmString = builder.toString();
	}
	
	public String getAhmIndicator(int i) {
		String[] achievements = ahmString.split("");
		return achievements[i];
	}

	public String getInvString() {
		return invString;
	}

	public void setInvString(String invString) {
		this.invString = invString;
	}
	
	public boolean containsItem(int indicator) {
		String stringIndicator = Integer.toString(indicator);
		String[] items = invString.split("");
		
		for(String item : items) {
			if(item.equals(stringIndicator))
				return true;
		}
		
		return false;
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
	
	public String getBgUrl() {
		if(bgIndicator == 0)
			return "BG_1.png";
		else if(bgIndicator == 1)
			return "BG_2.png";
		else if(bgIndicator == 2)
			return "BG_3.png";
		else if(bgIndicator == 3)
			return "BG_4.png";
		else if(bgIndicator == 4)
			return "BG_4.png";
		return null;
	}
	
	/**
	 * updateStudyStats
	 * @brief updates the study stats
	 * @param tempMin
	 * @param tempSec
	 */
	public void updateStudyStats(int min, int sec) {
		//Update time
		int totalSeconds = (min * 60) + sec;
		totalTime = totalTime + totalSeconds;
		
		//Update tokens
		//Every 3600 seconds, 50 Tamo tokens are earned
		//(72 seconds is 1 Tamo token)
		int earnedSessionTokens = ((50 * totalSeconds) / 3600);
		tamoTokens = tamoTokens + earnedSessionTokens;
		
		//Update tamo happiness
		int happinessEarned = 0;
		if(!(tamo.getHappiness() == 10)) {
			happinessEarned = (totalSeconds / 1800);
			if(tamo.getHappiness() + happinessEarned >= 10) { tamo.setHappiness(10); }
			else { tamo.setHappiness(tamo.getHappiness() + happinessEarned); }
		}
		
		//TODO Update the file
	}
	
	/**
	 * printInfo
	 * Prints the Profile Information
	 */
	public void printInfo() {
		System.out.println(
				"===PROFILE INFORMATION===" +
				"\nusername: " + username +
				"\njoinDate: " + joinDateString +
				"\nlastLoginDateString: " + lastLoginDateString +
				"\nnewLoginDateString: " + newLoginDateString +
				"\ntamoTokens: " + Integer.toString(tamoTokens) +
				"\ntotalTime: " + Integer.toString(totalTime) + 
				"\nbgIndicator: " + Integer.toString(bgIndicator) +
				"\nthemeIndicator: " + Integer.toString(themeIndicator) +
				"\nstrikes: " + Integer.toString(strikes) +
				"\nTamo/name: " + tamo.getName() + 
				"\nTamo/happiness: " + tamo.getHappiness() +
				"\nTamo/hunger: " + tamo.getHunger() + 
				"\nTamo/id: " + tamo.getId() +
				"\nlanguageIndicator: " + languageIndicator +
				"\nahmString: " + ahmString +
				"\nSettings/focusMode: " + settings.getFocusMode() +
				"\nSettings/sessionSoundIndicator: " + settings.getSessionSoundIndicator() +
				"\nSettings/backgroundSoundIndicator: " + settings.getBackgroundSoundIndicator() +
				"\nSettings/difficulty: " + settings.getDifficulty() +
				"\n========================="
				);
	}
	
}
