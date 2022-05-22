package profile;

/**
 * @author Anthony Narlock (narlock)
 * Profile Settings class. Contains changeable settings
 */

public class Settings {
	private int focusMode;					//0 for 5 min Interval
											//1 for Custom interval
											//2 for Pomodoro
											//3 for Stopwatch
	
	private int sessionSoundIndicator;		//0 for None
											//1 for Soft Alarm
											//2 for Trad Alarm
											//3 for Pac Alarm
	
	private int backgroundSoundIndicator;	//0 for None
											//1 for Rain sounds
											//2 for Fireplace sounds
											//TODO more?
	
	private int difficulty;					//0 for Peaceful
											//1 for Challenging
	
	private int showAhmNotifications;		//0 for NO
											//1 for YES
	
	//Default constructor; default settings
	public Settings(int difficulty) {
		this.focusMode = 0;
		this.sessionSoundIndicator = 0;
		this.backgroundSoundIndicator = 0;
		this.difficulty = difficulty;
		this.showAhmNotifications = 1;
	}
	
	//Load constructor
	public Settings(int focusMode, 
			int sessionSoundIndicator, 
			int backgroundSoundIndicator,
			int difficulty,
			int showAhmNotifications) {
		this.focusMode = focusMode;
		this.sessionSoundIndicator = sessionSoundIndicator;
		this.backgroundSoundIndicator = backgroundSoundIndicator;
		this.difficulty = difficulty;
		this.showAhmNotifications = showAhmNotifications;
	}

	public int getFocusMode() {
		return focusMode;
	}

	public void setFocusMode(int focusMode) {
		this.focusMode = focusMode;
	}

	public int getSessionSoundIndicator() {
		return sessionSoundIndicator;
	}

	public void setSessionSoundIndicator(int sessionSoundIndicator) {
		this.sessionSoundIndicator = sessionSoundIndicator;
	}

	public int getBackgroundSoundIndicator() {
		return backgroundSoundIndicator;
	}

	public void setBackgroundSoundIndicator(int backgroundSoundIndicator) {
		this.backgroundSoundIndicator = backgroundSoundIndicator;
	}

	public int getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(int difficulty) {
		this.difficulty = difficulty;
	}

	public int getShowAhmNotifications() {
		return showAhmNotifications;
	}

	public void setShowAhmNotifications(int showAhmNotifications) {
		this.showAhmNotifications = showAhmNotifications;
	}
	
	public String getSoundPath() {
		if(sessionSoundIndicator == 1)
			return "SOFT_ALARM.wav";
		if(sessionSoundIndicator == 2)
			return "TRAD_ALARM.wav";
		if(sessionSoundIndicator == 3)
			return "PAC_ALARM.wav";
		
		//This should never happen
		return null;
	}
}
