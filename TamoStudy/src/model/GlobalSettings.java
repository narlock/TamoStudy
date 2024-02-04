package model;

import model.language.EnglishLanguage;
import model.language.Language;

/**
 * GlobalSettings
 * 
 * @author narlock
 *
 * @brief Global Settings for the TamoStudy Welcome Screen.
 * An instance of this object will be stored for the user to
 * create preferences for the welcome screen.
 * 
 * The user will be able to change the welcome screen's
 * language to their preference, allow to receive update
 * notifications for TamoStudy or not, and finally, choose
 * to load a default profile if they do not want to go
 * through the local profile loader.
 */
public class GlobalSettings {
	
	/**
	 * Language : see model.language
	 */
	private Language language;
	
	/**
	 * Default Local Profile : Long representing the index in profiles.json
	 */
	private long defaultLocalProfile;
	
	/*
	 * Receive Update Notifications : Allows user to be promptly notified of updates.
	 */
	private Boolean receiveUpdateNotifications;
	
	public GlobalSettings() {
		this.language = new EnglishLanguage();
		this.defaultLocalProfile = -1;
		this.receiveUpdateNotifications = true;
	}

	public GlobalSettings(Language language, long defaultLocalProfile, Boolean receiveUpdateNotifications) {
		super();
		this.language = language;
		this.defaultLocalProfile = defaultLocalProfile;
		this.receiveUpdateNotifications = receiveUpdateNotifications;
	}

	public Language getLanguage() {
		return language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

	public long getDefaultLocalProfile() {
		return defaultLocalProfile;
	}

	public void setDefaultLocalProfile(long defaultLocalProfile) {
		this.defaultLocalProfile = defaultLocalProfile;
	}

	public Boolean getReceiveUpdateNotifications() {
		return receiveUpdateNotifications;
	}

	public void setReceiveUpdateNotifications(Boolean receiveUpdateNotifications) {
		this.receiveUpdateNotifications = receiveUpdateNotifications;
	}

	@Override
	public String toString() {
		return "GlobalSettings [language=" + language + ", defaultLocalProfile=" + defaultLocalProfile
				+ ", receiveUpdateNotifications=" + receiveUpdateNotifications + "]";
	}

}
