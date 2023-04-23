package model.profile;

import model.language.Language;

public class ProfileSettings {
	
	private Language language;
	
	private long focusMode;
	
	private long difficulty;
	
	private long timerAlarm;
	
	private long guiSize;
	
	private Boolean receiveNotifications;
	
	private Boolean enableDiscordRPC;
	
	private Boolean showProgramCloseMessage;
	
	/**
	 * New Profile Settings
	 * @param language
	 * @param focusMode
	 * @param difficulty
	 */
	public ProfileSettings(Language language, long focusMode, long difficulty) {
		super();
		this.language = language;
		this.focusMode = focusMode;
		this.difficulty = difficulty;
		this.timerAlarm = 0;
		this.guiSize = 1;
		this.receiveNotifications = true;
		this.enableDiscordRPC = false;
		this.showProgramCloseMessage = true;
	}

	/**
	 * Load Profile Settings
	 * @param language
	 * @param focusMode
	 * @param difficulty
	 * @param timerAlarm
	 * @param guiSize
	 * @param receiveNotifications
	 * @param enableDiscordRPC
	 * @param showProgramCloseMessage
	 */
	public ProfileSettings(Language language, long focusMode, long difficulty, long timerAlarm, long guiSize,
			Boolean receiveNotifications, Boolean enableDiscordRPC, Boolean showProgramCloseMessage) {
		super();
		this.language = language;
		this.focusMode = focusMode;
		this.difficulty = difficulty;
		this.timerAlarm = timerAlarm;
		this.guiSize = guiSize;
		this.receiveNotifications = receiveNotifications;
		this.enableDiscordRPC = enableDiscordRPC;
		this.showProgramCloseMessage = showProgramCloseMessage;
	}
	
	/**
	 * Convert Profile Settings
	 * @param languageIndicator
	 * @param focusMode
	 * @param sessionSoundIndicator
	 * @param difficulty
	 * @param showAhmNotifications
	 */
	public ProfileSettings(long languageIndicator, long focusMode, long sessionSoundIndicator, long difficulty,
			boolean showAhmNotifications) {
		this.language = Language.getLanguageFromBox((int) languageIndicator);
		this.focusMode = convertNewFocusMode((int) focusMode);
		this.difficulty = difficulty;
		this.timerAlarm = sessionSoundIndicator;
		this.guiSize = 1;
		this.receiveNotifications = showAhmNotifications;
		this.enableDiscordRPC = false;
		this.showProgramCloseMessage = true;
	}

	private long convertNewFocusMode(int oldFocusMode) {
		switch(oldFocusMode) {
		case 0:
			return 1;
		case 1:
			return 2;
		case 2:
			return 0;
		default:
			return 0;
		}
	}

	public Language getLanguage() {
		return language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

	public long getFocusMode() {
		return focusMode;
	}

	public void setFocusMode(long focusMode) {
		this.focusMode = focusMode;
	}

	public long getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(long difficulty) {
		this.difficulty = difficulty;
	}

	public long getTimerAlarm() {
		return timerAlarm;
	}

	public void setTimerAlarm(long timerAlarm) {
		this.timerAlarm = timerAlarm;
	}

	public long getGuiSize() {
		return guiSize;
	}

	public void setGuiSize(long guiSize) {
		this.guiSize = guiSize;
	}

	public Boolean getReceiveNotifications() {
		return receiveNotifications;
	}

	public void setReceiveNotifications(Boolean receiveNotifications) {
		this.receiveNotifications = receiveNotifications;
	}

	public Boolean getEnableDiscordRPC() {
		return enableDiscordRPC;
	}

	public void setEnableDiscordRPC(Boolean enableDiscordRPC) {
		this.enableDiscordRPC = enableDiscordRPC;
	}

	public Boolean getShowProgramCloseMessage() {
		return showProgramCloseMessage;
	}

	public void setShowProgramCloseMessage(Boolean showProgramCloseMessage) {
		this.showProgramCloseMessage = showProgramCloseMessage;
	}

	@Override
	public String toString() {
		return "ProfileSettings [language=" + language + ", focusMode=" + focusMode + ", difficulty=" + difficulty
				+ ", timerAlarm=" + timerAlarm + ", guiSize=" + guiSize + ", receiveNotifications="
				+ receiveNotifications + ", enableDiscordRPC=" + enableDiscordRPC + ", showProgramCloseMessage="
				+ showProgramCloseMessage + "]";
	}
	
	

}
