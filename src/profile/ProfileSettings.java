package profile;

/**
 * 
 * @author Anthony
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
	private int languageIndicator;
	
	/*
	 * Enable Sounds: Session over sound, background sounds
	 * These will be JToggleButton
	 * When enabled, sound will be enabled, vice versa
	 */
	private int sessionSounds;
	private int backgroundSounds;
	
	/*
	 * Default Profile Settings
	 * Focus Mode: 0
	 * Language: set languageIndicator on creation
	 * Sounds: Disabled
	 */
	public ProfileSettings(int languageIndicator) {
		this.focusMode = 0;
		this.languageIndicator = languageIndicator;
		this.sessionSounds = 0;
		this.backgroundSounds = 0;
	}
	
	/*
	 * Loaded Profile Settings
	 * All attributes are set
	 */
	public ProfileSettings(int focusMode, int languageIndicator, int sessionSounds, int backgroundSounds) {
		this.focusMode = focusMode;
		this.languageIndicator = languageIndicator;
		this.sessionSounds = sessionSounds;
		this.backgroundSounds = backgroundSounds;
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

	public int getLanguageIndicator() {
		return languageIndicator;
	}

	public void setLanguageIndicator(int languageIndicator) {
		this.languageIndicator = languageIndicator;
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
	
}
