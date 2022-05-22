package language;

public class HindiStrategy extends LanguageStrategy {
	
	/**
	 * @author Anthony Narlock (narlock)
	 * @translator Anthony Narlock
	 */
	
	public HindiStrategy() {
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
			"About",
			"Achievement Unlocked"
		};
		this.text = engText;
		
		String engTitleText[] = {
			"कभी हार मत मानो!"
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
			"Let's Focus!",
			"Break"
		};
		this.focusText = engFocusText;
		
		String engShopText[] = {
			"Food Shop",
			"Backgrounds",
			"Hello! I am Kath.",
			"Welcome to the shop!",
			"Purchase",
			"You don't have sufficient funds!",
			"Your Tamo is full!",
			"Are you sure?",
			"for",
			"TamoTokens?",
			"and",
			"Is there anything",
			"I can help you with?",
			"YES",
			"NO",
			"You already own this item!"
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
			"Select",
			"Background changed!",
			"Inventory"
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
			"We don't know much about this achievement",
			"We don't know much about this achievement",
			"We don't know much about this achievement"
		};
		this.ahmText = engAhmText;
		
		String[] engSettingsText = {
			"Change Focus Mode",
			"Change Language",
			"Change Difficulty",
			"Alarm Sound",
			"Custom Interval Countdown",
			"5-Interval Countdown",
			"Pomodoro Mode",
			"Stopwatch Mode",
			"English",
			"Spanish",
			"Portuguese",
			"German",
			"French",
			"Dutch",
			"Turkish",
			"Irish",
			"Hindi",
			"Japanese",
			"Chinese",
			"Peaceful",
			"Challenging",
			"OFF",
			"ON",
			"Soft Alarm",
			"Trad Alarm",
			"Pac Alarm",
			"Save Changes",
			"Changes Saved!",
			"You have unsaved changes.",
			"Achievement Notifications",
			"No Sound"
		};
		this.settingsText = engSettingsText;
		
		String[] engAboutText = {
			"TamoStudy is a productivity",
			"work and focus timer that",
			"implements a virtual pet to",
			"help you stay driven to focus!",
			"Developed by: ",
			"Anthony Narlock"
		};
		this.aboutText = engAboutText;
		
		String[] engDeathText = {
			"Tamo Death",
			"Your Tamo didn't receive the care it needed and has passed",
			"Your statistics for your previous Tamo will be reset",
			"Enter new Tamo name: "
		};
		this.deathText = engDeathText;
	}
	
	@Override
	public void printCurrentLanguage() {
		System.out.println("Hindi");
	}
}
