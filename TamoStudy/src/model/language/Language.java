package model.language;

public abstract class Language {
	
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
