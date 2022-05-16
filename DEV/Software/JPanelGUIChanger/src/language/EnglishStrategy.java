package language;

public class EnglishStrategy extends LanguageStrategy {
	
	public EnglishStrategy() {
		String engText[] = {
			"MENU",
			"Welcome, ",
			"Title Card",
			"Focus",
			"Shop",
			"Themes",
			"Inventory",
			"Statistics",
			"Achievements",
			"Settings",
			"About"
		};
		this.text = engText;
		
		String engTitleText[] = {
			"Never give up!!!"
		};
		this.titleText = engTitleText;
	
	}
}
