package profile;

import java.text.SimpleDateFormat;
import java.util.Date;

import language.EnglishStrategy;
import language.LanguageStrategy;

/**
 * @author: Anthony Narlock
 * @description: Profile Object class
 */

public class Profile {
	private SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	
	//Immutable
	private String username;
	private Date joinDate;
		private String joinDateString;
	
	//Mutable
	private Date lastLoginDate;
		private String lastLoginDateString;
	private Date newLoginDate;
		private String newLoginDateString;
	
	private int tamoTokens;
	private int totalTime;
	private int bgIndicator;
	private int themeIndicator;
	private int strikes;
	
	private Tamo tamo;
	private LanguageStrategy lang;
	private Achievements ahm;
	private Settings settings;
	
	public Profile() {
		this.lang = new EnglishStrategy();
	}
	
	public LanguageStrategy getLanguage() {
		/*
		 * We can access the language text
		 * we are looking for with simply
		 * profile.getLanguage().<our Text array>[indicator];
		 */
		return lang;
	}
	
}
