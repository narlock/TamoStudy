package tamostudy;

import java.awt.GridLayout;
import java.io.File;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

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
	private boolean firstDay;				//Indicates first day of account
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
	
	//New Profile Constructor - Created by initial 'Welcome' interface
	public Profile(File file, String username, String tamoName, int languageIndicator, int difficulty) {
		this.file = file;
		this.username = username;
		this.joinDate = new Date();
		this.joinDateString = formatter.format(joinDate);
		this.tamoTokens = 0;
		this.totalTime = 0;
		this.bgIndicator = 0;
		this.themeIndicator = 0;
		this.strikes = 0;
		this.tamo = new Tamo(tamoName);
		this.languageIndicator = languageIndicator;
		this.ahmString = "000000000000";
		this.invString = "0";
		this.settings = new Settings(difficulty);
		
		//Date stuff
		this.firstDay = true;
		this.lastLoginDate = new Date(); //Upon first login, this will be the last login
		
		//On a new profile, they will be the same!
		this.lastLoginDateString = formatter.format(lastLoginDate);
		this.newLoginDateString = formatter.format(lastLoginDate);
	}
	
	
	//Load Profile Constructor
	public Profile(
			File file,
			String username,
			String joinDateString,
			String lastLoginDateString,
			int tamoTokens,
			int totalTime,
			int bgIndicator,
			int themeIndicator,
			int strikes,
			Tamo tamo,
			int languageIndicator,
			String ahmString,
			String invString,
			Settings settings
		) {
		this.file = file;
		
		this.username = username;
		this.joinDateString = joinDateString;
		this.lastLoginDateString = lastLoginDateString;
		
		this.tamoTokens = tamoTokens;
		this.totalTime = totalTime;
		this.bgIndicator = bgIndicator;
		this.themeIndicator = themeIndicator;
		this.strikes = strikes;
		
		this.tamo = tamo;
		this.languageIndicator = languageIndicator;
		
		this.ahmString = ahmString;
		this.invString = invString;
		
		this.settings = settings;
		
		//TODO
		//Modify the dates accordingly
		this.firstDay = false;
		this.newLoginDate = new Date();
		this.newLoginDateString = formatter.format(newLoginDate);
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
	
	
	public int getLanguageIndicator() {
		return languageIndicator;
	}
	
	public void setLanguageIndicator(int languageIndicator) {
		this.languageIndicator = languageIndicator;
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

	public String getInvString() {
		return invString;
	}

	public void setInvString(String invString) {
		this.invString = invString;
	}

	public Settings getSettings() {
		return settings;
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
				"\ninvString: " + invString +
				"\nSettings/focusMode: " + settings.getFocusMode() +
				"\nSettings/sessionSoundIndicator: " + settings.getSessionSoundIndicator() +
				"\nSettings/backgroundSoundIndicator: " + settings.getBackgroundSoundIndicator() +
				"\nSettings/difficulty: " + settings.getDifficulty() +
				"\n========================="
				);
	}
	
	public File getFile() {
		return file;
	}

	/**
	 * toString
	 * This will return the string needed on file input
	 */
	@Override
	public String toString() {
		return "b4.0," + username + "," + joinDateString + "," + lastLoginDateString + ","
			+ tamoTokens + "," + totalTime + "," + bgIndicator + "," + themeIndicator + ","
			+ strikes + "," + tamo.getName() + "," + tamo.getHappiness() + ","
			+ tamo.getHunger() + "," + tamo.getId() + "," + languageIndicator + ","
			+ ahmString + "," + invString + "," + settings.getFocusMode() + ","
			+ settings.getSessionSoundIndicator() + "," + settings.getBackgroundSoundIndicator() + ","
			+ settings.getDifficulty() + "," + settings.getShowAhmNotifications();
	}
	
}
