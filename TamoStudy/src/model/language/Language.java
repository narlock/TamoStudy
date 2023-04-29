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
	 * PROFILE CREATION / SELECTION TEXT
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
	
	public String createText;
	public String cancelText;
	public String mustEnterValidNameText;
	
	
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
