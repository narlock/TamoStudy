package profile;

/**
 * 
 * @author Anthony Narlock
 * @description ProfileSettings, the settings for Profile class
 *
 */

public class ProfileSettings {
	/*
	 * Attributes of ProfileSettings
	 * These contain all of the possible settings that the user can update.
	 */
	
	/*
	 * Focus Mode: Which style the timer is set to
	 * 0: 5 minute interval countdown timer (Default)
	 * 1: custom set interval countdown timer (old Default)
	 * 2: TODO- countUp timer
	 */
	private int focusMode;
	
	/*
	 * Language Indicator: integer that indicates which language use is using
	 * 0: English
	 * 1: Spanish
	 * 2: Portuguese
	 * 3: German
	 * 4: Japanese
	 * 5: Dutch
	 * 6: French
	 */
	private Language lang;
	
	/*
	 * Enable Sounds: Session over sound, background sounds
	 * These will be JToggleButton
	 * When enabled, sound will be enabled, vice versa
	 */
	private int sessionSounds;
	private int backgroundSounds;
	
	/*
	 * Difficulty
	 * 0: Peaceful - Tamo will never pass
	 * 1: Challenging - Tamo receives strikes and could pass
	 */
	private int difficulty;
	
	/*
	 * Default Profile Settings
	 * Focus Mode: 0
	 * Language: set languageIndicator on creation
	 * Sounds: Disabled
	 */
	public ProfileSettings(int languageIndicator, int difficulty) {
		this.focusMode = 0;
		this.lang = new Language(languageIndicator);
		this.sessionSounds = 0;
		this.backgroundSounds = 0;
		this.difficulty = difficulty;
	}
	
	/*
	 * Loaded Profile Settings
	 * All attributes are set
	 */
	public ProfileSettings(int focusMode, int languageIndicator, int sessionSounds, int backgroundSounds, int difficulty) {
		this.focusMode = focusMode;
		this.lang = new Language(languageIndicator);
		this.sessionSounds = sessionSounds;
		this.backgroundSounds = backgroundSounds;
		this.difficulty = difficulty;
	}
	
	/*
	 * Getters/Setters
	 */

	public int getFocusMode() {
		return focusMode;
	}

	public void setFocusMode(int focusMode) {
		this.focusMode = focusMode;
	}

	public Language getLang() {
		return lang;
	}

	public void setLang(Language lang) {
		this.lang = lang;
	}

	public int getSessionSounds() {
		return sessionSounds;
	}

	public void setSessionSounds(int sessionSounds) {
		this.sessionSounds = sessionSounds;
	}

	public int getBackgroundSounds() {
		return backgroundSounds;
	}

	public void setBackgroundSounds(int backgroundSounds) {
		this.backgroundSounds = backgroundSounds;
	}
	
	@Override
	public String toString() {
		String settingsInfo = focusMode + "," + lang.getIndicator() + "," + sessionSounds + "," + backgroundSounds + "," + difficulty;
		return settingsInfo;
	}

	public int getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(int difficulty) {
		this.difficulty = difficulty;
	}
	
}
