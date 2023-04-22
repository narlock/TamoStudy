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
	
	

}
