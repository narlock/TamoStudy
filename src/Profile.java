/**
 * @author: Anthony Narlock
 * @description: Profile Object class
 */

import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Profile {
	/*
	 * Attributes of Profile
	 * 
	 * Contains a Tamo class Object
	 * Contains a Language class Object
	 */
	
	private String username;
	private String password;
	
	private Date join_date;
	private Date last_login_date;
	private Date new_login_date;
	private SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	private String dateString;
	private String lastLoginString;
	private String newLoginString;
	
	private Tamo tamo;
	private int money;
	private int totalTime;
	private int currentBackground;
	private String guiColor;
	
	private int warnings;
	
	private int language_indicator;
	private Language lang;
	
	/*
	 * Default Constructor
	 * 
	 * Sets all attributes to null, zero, or defaults
	 */
	public Profile() {
		this.username = "null";
		this.password = "null";
		this.tamo = new Tamo();
		
		this.join_date = new Date();
		this.dateString = formatter.format(join_date);
		
		this.totalTime = 0;
		this.money = -1;
		
		this.last_login_date = new Date();
		this.lastLoginString = formatter.format(last_login_date);
		this.currentBackground = 0;
		
		this.guiColor = "blue";
		
		this.warnings = 0;
		this.language_indicator = 0;
		this.lang = new Language(0);
	}
	
	/*
	 * Old Constructor
	 * 
	 * This constructor was used before TamoStudy implemented Language
	 * Is used now for debugging, since the language automatically is set to English
	 */
	public Profile(String username, String password, String tamoName) {
		this.username = username;
		this.password = password;
		this.tamo = new Tamo(tamoName);
		
		this.join_date = new Date();
		this.dateString = formatter.format(join_date);
		
		this.totalTime = 0;
		
		this.money = 0;
		
		this.last_login_date = new Date();
		this.lastLoginString = formatter.format(last_login_date);
		this.currentBackground = 0;
		
		this.guiColor = "default";
		
		this.warnings = 0;
		
		this.language_indicator = 0;
		this.lang = new Language(0);
	}
	/*
	 * Main New Profile Constructor
	 * 
	 * The constructor that is used when a new profile is created
	 * Sets attributes of the profile accordingly
	 */
	public Profile(String username, String tamoName, int lang) {
		this.username = username;
		this.tamo = new Tamo(tamoName);
		
		this.join_date = new Date();
		this.dateString = formatter.format(join_date);
		
		this.totalTime = 0;
		
		this.money = 0;
		
		this.last_login_date = new Date();
		this.lastLoginString = formatter.format(last_login_date);
		this.currentBackground = 0;
		
		this.guiColor = "default";
		
		this.warnings = 0;
		
		this.language_indicator = lang;
		this.lang = new Language(lang);
	}
	
	
	/*
	 * Main Load Profile Constructor
	 * 
	 * The constructor that is used when a profile is being loaded
	 * Sets attributes of the profile accordingly
	 */
	public Profile(String username, String dateString, int totalTime, int money, Tamo tamo, String lastLoginString, int currentBackground, String guiColor, int lang) {
		this.username = username;
		this.dateString = dateString;
		this.money = money;
		this.totalTime = totalTime;
		
		this.tamo = tamo;
		
		this.lastLoginString = lastLoginString;
		
		this.new_login_date = new Date();
		this.newLoginString = formatter.format(new_login_date);
		
		this.currentBackground = currentBackground;
		
		this.guiColor = guiColor;
		
		this.language_indicator = lang;
		this.lang = new Language(lang);
	}

	/*
	 * Mutators and Accessor methods for profile attributes
	 */
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getJoin_date() {
		return join_date;
	}

	public Tamo getTamo() {
		return tamo;
	}

	public void setTamo(Tamo tamo) {
		this.tamo = tamo;
	}

	public String getJoinDate() {
		return dateString;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}
	
	public int getTotalTime(int minutes, int seconds) {	
		//Convert tempMin to seconds
		int convertedSeconds = minutes * 60;
		
		this.totalTime = this.totalTime + convertedSeconds;
		
		//Returns totalTimeInSession (in seconds)
		return totalTime;
	}
	public int getTotalTime() {
		return totalTime;
	}
	
	public void setTotalTime(int totalTime) {
		this.totalTime = totalTime;
	}

	public String getLastLoginString() {
		return lastLoginString;
	}

	public void setLastLoginString(String lastLoginString) {
		this.lastLoginString = lastLoginString;
	}

	public Date getLast_login_date() {
		return last_login_date;
	}

	public void setLast_login_date(Date last_login_date) {
		this.last_login_date = last_login_date;
	}

	public int getCurrentBackground() {
		return currentBackground;
	}

	public void setCurrentBackground(int currentBackground) {
		this.currentBackground = currentBackground;
	}

	public String getNewLoginString() {
		return newLoginString;
	}

	public void setNewLoginString(String newLoginString) {
		this.newLoginString = newLoginString;
	}
	
	public Date getNew_login_date() {
		return new_login_date;
	}
 
	public String getGuiColor() {
		return guiColor;
	}

	public void setGuiColor(String guiColor) {
		this.guiColor = guiColor;
	}

	public int getWarnings() {
		return warnings;
	}

	public void setWarnings(int warnings) {
		this.warnings = warnings;
	}

	public int getLanguageIndicator() {
		return language_indicator;
	}

	public void setLanguageIndicator(int language_indicator) {
		this.language_indicator = language_indicator;
	}
	
	public Language getLanguage() {
		return lang;
	}
	
	public Color getColor() {
		if(this.guiColor.equals("default"))
			return new Color(255,161,161);
		if(this.guiColor.equals("blue"))
			return new Color(161,161,255);
		if(this.guiColor.equals("green"))
			return new Color(161,255,161);
		if(this.guiColor.equals("orange"))
			return new Color(255,219,161);
		if(this.guiColor.equals("purple"))
			return new Color(236,161,255);
		if(this.guiColor.equals("yellow"))
			return new Color(255,255,161);
		if(this.guiColor.equals("grey"))
			return new Color(161,161,161);
		
		return new Color(255,161,161);
	}
}
