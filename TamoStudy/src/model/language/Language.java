package model.language;

public abstract class Language {
	
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
