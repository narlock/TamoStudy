package model.language;

public abstract class Language {
	/*
	 * ##################################
	 * ##################################
	 * WELCOME GUI TEXT
	 * ##################################
	 * ##################################
	 */
	public String createdByText;
	public String localStudyText;
	public String onlineStudyText;
	public String unableSearchUpdatesText;
	public String updateAvailableDownloadText;
	
	/*
	 * ##################################
	 * ##################################
	 * CHANGE GLOBAL SETTINGS TEXT
	 * ##################################
	 * ##################################
	 */
	public String globalSettingsText;
	
	/*
	 * ##################################
	 * ##################################
	 * PROFILE CREATION / SOME SETTINGS / SELECTION TEXT
	 * ##################################
	 * ##################################
	 */
	public String noProfilesText;
	public String welcomeBackText;
	public String createNewProfileText;
	public String importProfileText;
	public String chooseProfileText;
	public String loadProfileAutomaticallyText;
	public String loadProfileText;
	public String deleteProfileText;
	public String invalidProfileFileText;
	public String confirmDeleteProfileText;
	public String areYouSureText;
	public String createProfileText;
	public String usernameText;
	public String tamoNameText;
	
	public String languageText;
	public String englishText;
	public String spanishText;
	public String hindiText; // macOS Only
	public String portugueseText;
	public String japaneseText; // macOS Only
	public String germanText;
	public String frenchText;
	public String turkishText;
	public String mandarinChineseText; // macOS Only
	public String dutchText;
	public String koreanText; // macOS Only
	public String russianText;
	public String hungarianText;
	public String romanianText;
	
	public String difficultyText;
	public String peacefulText;
	public String challengingText;
	public String ironManText;
	
	public String focusModeText;
	public String pomodoroText;
	public String customCountdownText;
	public String fiveMinIntervalCountdownText;
	public String stopwatchText;
	
	public String resetDefaultProfileText;
	public String updateNotificationsText;
	public String defaultProfileReset;
	
	public String createText;
	public String cancelText;
	public String mustEnterValidNameText;
	public String settingsSavedText;
	
	/*
	 * ##################################
	 * ##################################
	 * MAIN GUI TEXT
	 * ##################################
	 * ##################################
	 */
	public String menuButtonText;
	public String dashboardStateButtonText;
	public String focusStateButtonText;
	public String shopStateButtonText;
	public String inventoryStateButtonText;
	public String statisticsStateButtonText;
	public String achievementsStateButtonText;
	public String settingsStateButtonText;
	public String aboutStateButton;
	
	/*
	 * ##################################
	 * ##################################
	 * DASHBOARD STATE TEXT
	 * ##################################
	 * ##################################
	 */
	public String todaysFocusText;
	public String monthFocusText;
	public String totalFocusText;
	public String levelText;
	public String hoursText;
	
	/*
	 * ##################################
	 * ##################################
	 * FOCUS STATE TEXT
	 * ##################################
	 * ##################################
	 */
	public String pomoNumberOfSessionsText;
	public String pomoSessionLengthText;
	public String pomoBreakLengthText;
	public String minutesText;
	public String secondsText;
	public String durationText;
	public String letsFocusText;
	public String focusingText;
	public String startFocusText;
	public String breakFocusText;
	public String youFocusedForText;
	public String minutesAndText;
	public String secondsPeriodText;
	public String focusBrokeText;
	public String focusText;
	public String breakText;
	public String focusCompleteText;
	
	/*
	 * ##################################
	 * ##################################
	 * ITEMS TEXT
	 * ##################################
	 * ##################################
	 */
	public String onigiriText;
	public String chickenPlateText;
	public String cheesecakeText;
	public String onigiriDescriptionText;
	public String chickenPlateDescriptionText;
	public String cheesecakeDescriptionText;
	
	public String bedroomText;
	public String sofaText;
	public String sunriseText;
	public String nightOutText;
	public String enigmaText;
	public String bedroomDescriptionText;
	public String sofaDescriptionText;
	public String sunriseDescriptionText;
	public String nightOutDescriptionText;
	public String enigmaDescriptionText;
	
	public String blackText;
	public String goldText;
	public String redText;
	public String mintText;
	public String purpleText;
	public String blueText;
	public String strawberryLemonadeText;
	
	public String solidBackgroundText;
	public String gradientBackgroundText;
	public String rareBackgroundText;
	
	/*
	 * ##################################
	 * ##################################
	 * SETTINGS STATE TEXT
	 * ##################################
	 * ##################################
	 */
	public String timerAlarmText;
	public String noTimerAlarmText;
	public String softAlarmText;
	public String traditionalAlarmText;
	public String pacAlarmText;
	public String calmAlarmText;
	public String bellAlarmText;
	public String guiSizeText;
	public String notificationsText;
	public String discordRPCText;
	public String exitMessageText;
	public String onText;
	public String offText;
	public String saveText;
	public String resetText;
	
	public static Language getLanguageFromBox(int index) {
		Language language;
		
		switch(index) {
		case 0:
			language = new EnglishLanguage();
			return language;
		default:
			language = new EnglishLanguage();
			return language;
		}
	}
	
	public static int getIndexFromLanguage(Language language) {
		if(language instanceof EnglishLanguage) {
			return 0;
		}
		return 0;
	}
	
	public static Language getLanguage(String languageString) {
		Language language;
		
		switch(languageString) {
		case "ENG":
			language = new EnglishLanguage();
			return language;
		default:
			language = new EnglishLanguage();
			return language;
		}
	}
	
	@Override
	public String toString() {
		if(this instanceof EnglishLanguage) {
			return "ENG";
		}
		return "ENG";
	}
}
