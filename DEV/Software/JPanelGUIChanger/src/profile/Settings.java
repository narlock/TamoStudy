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
	
	//Default constructor; default settings
	public Settings() {
		this.focusMode = 1;
		this.sessionSoundIndicator = 0;
		this.backgroundSoundIndicator = 0;
		this.difficulty = 1;
	}
	
	//Load constructor
	public Settings(int focusMode, 
			int sessionSoundIndicator, 
			int backgroundSoundIndicator,
			int difficulty) {
		this.focusMode = focusMode;
		this.sessionSoundIndicator = sessionSoundIndicator;
		this.backgroundSoundIndicator = backgroundSoundIndicator;
		this.difficulty = difficulty;
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
}
