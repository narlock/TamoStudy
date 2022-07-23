package profile;

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

import language.ChineseStrategy;
import language.DutchStrategy;
import language.EnglishStrategy;
import language.FrenchStrategy;
import language.GermanStrategy;
import language.HindiStrategy;
import language.IrishStrategy;
import language.JapaneseStrategy;
import language.LanguageStrategy;
import language.PortugueseStrategy;
import language.SpanishStrategy;
import language.TurkishStrategy;
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
		this.joinDate = new Date();
		this.joinDateString = formatter.format(joinDate);
		this.tamoTokens = 5000;
		this.totalTime = 0;
		this.bgIndicator = 0;
		this.themeIndicator = 0;
		this.strikes = 3;
		this.tamo = new Tamo("Lisa");
		this.languageIndicator = 0;
		setLanguageStrategy(languageIndicator);
		this.ahmString = "000000000000";
		this.invString = "01";
		this.settings = new Settings(0);
		
		//On a new profile, they will be the same!
		this.lastLoginDateString = "2022-05-19";
		
		
		//Date
		this.firstDay = false;
		this.newLoginDate = new Date();
		this.newLoginDateString = formatter.format(newLoginDate);
		getDaysDifference();
	}
	
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
		setLanguageStrategy(languageIndicator);
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
		setLanguageStrategy(languageIndicator);
		
		this.ahmString = ahmString;
		this.invString = invString;
		
		this.settings = settings;
		
		//TODO
		//Modify the dates accordingly
		this.firstDay = false;
		this.newLoginDate = new Date();
		this.newLoginDateString = formatter.format(newLoginDate);
		getDaysDifference();
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
	
	public void setLanguageStrategy(int languageIndicator) {
		//English
		if(languageIndicator == 0) { this.lang = new EnglishStrategy(); }
		else if(languageIndicator == 1) { this.lang = new SpanishStrategy(); }
		else if(languageIndicator == 2) { this.lang = new PortugueseStrategy(); }
		else if(languageIndicator == 3) { this.lang = new GermanStrategy(); }
		else if(languageIndicator == 4) { this.lang = new FrenchStrategy(); }
		else if(languageIndicator == 5) { this.lang = new DutchStrategy(); }
		else if(languageIndicator == 6) { this.lang = new TurkishStrategy(); }
		else if(languageIndicator == 7) { this.lang = new IrishStrategy(); }
		else if(languageIndicator == 8) { this.lang = new HindiStrategy(); }
		else if(languageIndicator == 9) { this.lang = new JapaneseStrategy(); }
		else if(languageIndicator == 10) { this.lang = new ChineseStrategy(); }
		else {
			this.languageIndicator = 0;
			this.lang = new EnglishStrategy();
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
	
	public void setLanguageIndicator(int languageIndicator) {
		this.languageIndicator = languageIndicator;
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
		//System.out.println("[TAMOSTUDY] DEBUG AhmString Before: " + ahmString);
		//i represents the index of the achievement
		String[] achievements = ahmString.split("");
		achievements[i] = "1"; //the achievement has been gotten
		StringBuilder builder = new StringBuilder();
		for(String s : achievements) { builder.append(s); }
		ahmString = builder.toString();
		//System.out.println("[TAMOSTUDY] DEBUG AhmString Before: " + ahmString);
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
			return "BG_5.png";
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
	 * checkStrikeStatus
	 * @param daysDifference
	 * Applies strikes if the profile earned them
	 */
	public void checkStrikeStatus(long daysDifference) {
		//Update Happy/Hunger
		if(daysDifference == 1) {
			tamo.setHappiness(tamo.getHappiness() - 1);
			tamo.setHunger(tamo.getHunger() - 1);
		} else if(daysDifference >= 2 && daysDifference <= 3) {
			tamo.setHappiness(tamo.getHappiness() - 2);
			tamo.setHunger(tamo.getHunger() - 2);
		} else if(daysDifference >= 4 && daysDifference <= 7) {
			tamo.setHappiness(tamo.getHappiness() - 3);
			tamo.setHunger(tamo.getHunger() - 3);
		} else if(daysDifference >= 8 && daysDifference <= 30) {
			tamo.setHappiness(0);
			tamo.setHunger(0);
		}
		
		//Update Strikes
		int strikesApplied = 0;
		if(tamo.getHunger() < 2)
			strikesApplied++;
		
		if(tamo.getHappiness() < 2)
			strikesApplied++;
		
		strikes = strikes + strikesApplied;
		
		//Check if strikes is enough to cause Tamo Death
		if((strikes >= 3 || daysDifference > 30) && (settings.getDifficulty() == 1)) {
			tamoDeath();
		} else if(settings.getDifficulty() == 1) {
			System.out.println("[TAMOSTUDY/PROFILE] Applied Strikes=" + strikesApplied + ", Total=" + strikes);
		}
			
	}
	
	/**
	 * getDaysDifference
	 * Determines the difference in when the user previously
	 * logged in with the current date.
	 * 
	 * Calls checkStrikeStatus to apply strikes accordingly.
	 * Updates the lastLoginDateString
	 */
	public void getDaysDifference() {
		LocalDate start = null;
		LocalDate end = null;
		
		try {
			start = LocalDate.parse(lastLoginDateString);
			end = LocalDate.parse(newLoginDateString);
			System.out.println("[TAMOSTUDY/PROFILE] start="+start+", end="+end);
		} catch (Exception e) { e.printStackTrace(); }
		
		long diff = ChronoUnit.DAYS.between(start, end);
		System.out.println("[TAMOSTUDY/PROFILE] Difference is " + diff);
		
		checkStrikeStatus(diff);
		
		this.lastLoginDateString = newLoginDateString;
	}
	
	/**
	 * tamoDeath
	 * Resets Tamo and user starts with a new Tamo
	 * Stats are erased.
	 */
	public void tamoDeath() {
		//Create the Death Panel
		JPanel deathPanel = new JPanel();
			deathPanel.setLayout(new GridLayout(5,1));
		JLabel deathMessage = new JLabel(lang.deathText[1]);
		JLabel spaceLabel = new JLabel();
		JLabel infoMessage = new JLabel(lang.deathText[2]);
		JLabel newTamoMessage = new JLabel(lang.deathText[3]);
		JTextField newTamoNameField = new JTextField(10);
		
		deathPanel.add(deathMessage);
		deathPanel.add(infoMessage);
		deathPanel.add(spaceLabel);
		deathPanel.add(newTamoMessage);
		deathPanel.add(newTamoNameField);
		
		Object[] options = {"Reset"};
		
		int resultPane = JOptionPane.showOptionDialog(null, deathPanel, lang.deathText[0], JOptionPane.PLAIN_MESSAGE, JOptionPane.QUESTION_MESSAGE, new ImageIcon(getClass().getClassLoader().getResource("info.png")), options, options[0]);
		
		//User will be able to choose if they want to change the name of their Tamo
		if(resultPane == 0) {
			totalTime = 0;
			tamoTokens = 0;
			bgIndicator = 0;
			strikes = 0;
			tamo.setName(newTamoNameField.getText());
			tamo.setHappiness(5);
			tamo.setHunger(5);
			tamo.setId(ThreadLocalRandom.current().nextInt(1, 4 + 1));
			
			//TODO Update File
					
		} else if(resultPane == JOptionPane.CLOSED_OPTION) {
			totalTime = 0;
			tamoTokens = 0;
			bgIndicator = 0;
			strikes = 0;
			//Tamo's name will be the same
			tamo.setHappiness(5);
			tamo.setHunger(5);
			tamo.setId(ThreadLocalRandom.current().nextInt(1, 4 + 1));
			
			//TODO Update File
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