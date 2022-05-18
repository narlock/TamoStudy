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
			"Never give up!!"
		};
		this.titleText = engTitleText;
	
		String engFocusText[] = {
			"Level",
			"# Of Sessions",
			"Session Length",
			"Break Length",
			"Start Focus",
			"Break Focus",
			"Session Completed",
			"Session Focus Broke",
			"You focused for",
			"minutes(s) and",
			"seconds(s)",
		};
		this.focusText = engFocusText;
		
		String engShopText[] = {
			"Food Shop",
			"Backgrounds",
			"Hello!",
			"Welcome to the shop!",
			"Purchase",
			"You don't have sufficient funds!",
			"Your Tamo is full!",
			"Are you sure?",
			"for",
			"TamoTokens?"
		};
		this.shopText = engShopText;
		
		String[] engThemeText = {
			"Dark Mode",
			"Light Mode",
			"Classic Red",
			"Classic Blue",
			"Classic Green",
			"Classic Yellow",
			"Classic Orange",
			"Classic Purple",
			"Themes",
			"Select",
			"Classic Themes",
			"Theme changed to ",
		};
		this.themesText = engThemeText;
		
		String[] engInvText = {
			"Inventory Empty",
			"Select"
		};
		this.inventoryText = engInvText;
		
		String[] engStatsText = {
			"Statistics",
			"Username",
			"Join Date",
			"Total Focus Hours",
			"Achievements Unlocked",
			"Tamo Level"
		};
		this.statsText = engStatsText;
		
		String[] engAhmTitle = {
			"The Beginning!",
			"Nothing can stop us!",
			"Never give up!",
			"Focus Ascension",
			"Customizer 1",
			"Customizer 2",
			"From the Beginning",
			"Tamo Full",
			"Tamo Love",
			"Achievement 10",
			"Achievement 11",
			"Achievement 12"
		};
		this.ahmTitle = engAhmTitle;
		
		String[] engAhmText = {
			"Reach total focus time of<br>3 hours",
			"Reach total focus time of<br>1 day",
			"Reach total focus time of<br>7 days",
			"Reach total focus time of<br>30 days",
			"Change TamoStudy's theme!",
			"Change your Tamo's<br>background",
			"Updated from a previous<br>TamoStudy version",
			"Achieve maximum Tamo hunger",
			"Achieve maximum Tamo happiness",
			"Achievement Text 10",
			"Achievement Text 11",
			"Achievement Text 12"
		};
		this.ahmText = engAhmText;
		
		String[] engSettingsText = {
			"Change Focus Mode",
			"Change Language",
			"Change Difficulty",
			"Sounds",
			"Custom Interval Countdown",
			"5-Interval Countdown",
			"Pomodoro Mode",
			"Stopwatch Mode",
			"English",
			"Spanish",
			"Portuguese",
			"German",
			"Japanese",
			"Dutch",
			"French",
			"Turkish",
			"Irish",
			"Hindi",
			"Chinese",
			"Peaceful",
			"Challenging",
			"OFF",
			"ON",
			"Soft Alarm",
			"Trad Alarm",
			"Pac Alarm",
			"Save Changes"
		};
		this.settingsText = engSettingsText;
		
	}
}
