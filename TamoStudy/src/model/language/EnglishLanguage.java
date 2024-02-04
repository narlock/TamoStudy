package model.language;

/**
 * 
 * @author narlock
 * @translator narlock
 * 
 * TRANSLATOR STEPS:
 * 1. Rename the file to YourLanguage.java 
 * 		- Where 'Your' is replaced with your language, for example, 'English' would make the file EnglishStrategy.java
 * 2. Rename 'EnglishLanguage' on line 25 to YourLanguage
 * 		- Where 'Your' is replaced with your language, for example, 'English' would make the class name EnglishLanguage
 * 3. Replace all of the text after each assignment (equals sign '=') for each line with the proper translation.
 * 		- For the `<html>` ones, keep the beginning and ending html tags, and add a `<br>` tag after roughly every 25-30
 * 		characters. The EnglishLanguage file provides plenty of examples for each. Complete words, do not cut in the middle.
 * 		- For context, the html tag represents that the text is going to be used as a HTML element. The br element represents
 * 		a 'break line' (where to tell the text to go to the next line)
 * 			- For example, if I wrote `<html>Hello<br>World</html> the text would appear in a JLabel like:
 * 					Hello
 * 					World
 * 4. Replace the @translator tag on line 6 with your alias.
 *
 */
public class EnglishLanguage extends Language {
	public EnglishLanguage() {
		/*
		 * ##################################
		 * ##################################
		 * WELCOME GUI TEXT
		 * ##################################
		 * ##################################
		 */
		createdByText = "Created by";
		localStudyText = "Local Study";
		onlineStudyText = "Online Study";
		unableSearchUpdatesText = "Unable to search for updates. Not connected to the Internet.";
		updateAvailableDownloadText = "is now available. Click here to download!"; // VER ... {}
		globalSettingsText = "Global Settings";
		
		/*
		 * ##################################
		 * ##################################
		 * MAIN GUI TEXT
		 * ##################################
		 * ##################################
		 */
		areYouSureYouWantToExitText = "Are you sure you want to exit?";
		dontShowThisMessageAgainText = "Don't show this message again";
		exitTamoStudyText = "Exit TamoStudy?";
		deathText1 = "who did not receive the care it required, has sadly passed away.";
		deathText2 = "Progress for this Tamo will be saved in Tamo History.";
		newTamoNameText = "New Tamo Name";
		/*
		 * ##################################
		 * ##################################
		 * PROFILE CREATION / SELECTION TEXT
		 * ##################################
		 * ##################################
		 */
		noProfilesText = "No local profiles were found.";
		welcomeBackText = "Welcome back to TamoStudy!";
		createNewProfileText = "Create New Profile";
		importProfileText = "Import Profile from Beta 4.2";
		chooseProfileText = "Choose Profile";
		loadProfileAutomaticallyText = "Load Profile Automatically";
		loadProfileText = "Load Profile";
		deleteProfileText = "Delete Profile";
		invalidProfileFileText = "Invalid Beta v4.2 Profile";
		confirmDeleteProfileText = "Confirm deletion of profile";
		areYouSureText = "Are you sure?";
		createProfileText = "Create TamoStudy Profile";
		usernameText = "Username";
		tamoNameText = "Tamo Name";
		
		languageText = "Language";
		// Like the language...
		englishText = "English";
		spanishText = "Spanish";
		hindiText = "Hindi";
		portugueseText = "Portuguese";
		japaneseText = "Japanese";
		germanText = "German";
		frenchText = "French";
		turkishText = "Turkish";
		mandarinChineseText = "Mandarin Chinese";
		dutchText = "Dutch";
		koreanText = "Korean";
		russianText = "Russian";
		hungarianText = "Hungarian";
		romanianText = "Romanian";
		
		difficultyText = "Difficulty";
		peacefulText = "Peaceful";
		challengingText = "Challenging";
		ironManText = "Iron Man";
		
		focusModeText = "Focus Mode";
		pomodoroText = "Pomodoro";
		customCountdownText = "Custom Countdown";
		fiveMinIntervalCountdownText = "5-Min Interval Countdown";
		stopwatchText = "Stopwatch";
		
		resetDefaultProfileText = "Reset Default Profile";
		updateNotificationsText = "Update Notifications";
		defaultProfileReset = "Default Profile Reset";
		
		createText = "Create";
		cancelText = "Cancel";
		mustEnterValidNameText = "Must enter a valid name!";
		settingsSavedText = "Settings Saved";
		
		/*
		 * ##################################
		 * ##################################
		 * MAIN GUI TEXT
		 * ##################################
		 * ##################################
		 */
		menuButtonText = "Menu";
		dashboardStateButtonText = "Dashboard";
		focusStateButtonText = "Focus";
		shopStateButtonText = "Shop";
		inventoryStateButtonText = "Inventory";
		statisticsStateButtonText = "Statistics";
		achievementsStateButtonText = "Achievements";
		settingsStateButtonText = "Settings";
		tamoHistoryText = "Tamo History";
		aboutStateButton = "About";
		
		/*
		 * ##################################
		 * ##################################
		 * DASHBOARD STATE TEXT
		 * ##################################
		 * ##################################
		 */
		todaysFocusText = "Today's Focus";
		monthFocusText = "Month Focus";
		totalFocusText = "Total Focus";
		levelText = "Level";
		hoursText = "hrs";
		
		/*
		 * ##################################
		 * ##################################
		 * FOCUS STATE TEXT
		 * ##################################
		 * ##################################
		 */
		pomoNumberOfSessionsText = "No. Of Sessions";
		pomoSessionLengthText = "Session Length";
		pomoBreakLengthText = "Break Length";
		minutesText = "Minutes";
		secondsText = "Seconds";
		durationText = "Duration";
		letsFocusText = "Lets Focus!";
		focusingText = "Focusing!";
		startFocusText = "Start Focus";
		breakFocusText = "Break Focus";
		pauseFocusText = "Pause Focus";
		resumeFocusText = "Resume Focus";
		youFocusedForText = "You focused for";
		minutesAndText = "minutes and";
		secondsPeriodText = "seconds.";
		focusBrokeText = "Focus Broke";
		focusText = "Focus";
		breakText = "Break";
		focusCompleteText = "Focus Complete";
		breakOverText = "Break is over. Time to get back to focus!";
		
		/*
		 * ##################################
		 * ##################################
		 * ITEMS TEXT
		 * ##################################
		 * ##################################
		 */
		onigiriText = "Onigiri";
		chickenPlateText = "Chicken Plate";
		cheesecakeText = "Cheesecake";
		onigiriDescriptionText = "<html>A traditional Japanese snack<br>made of seasoned rice shaped<br>into a ball or triangle,<br>often with a filling, and<br>wrapped in seaweed.<br><br>Restores 1 hunger point.</html>";
		chickenPlateDescriptionText = "<html>A dish featuring cooked<br>chicken served with a<br>variety of sides and<br>accompaniments.<br><br>Restores 3 hunger points.</html>";
		cheesecakeDescriptionText = "<html>A rich and creamy dessert<br>made with a crust of<br>crushed biscuits or pastry,<br>filled with a smooth mixture<br>of cream cheese and sugar.<br><br>Restores 8 hunger points.</html>";
		
		bedroomText = "Bedroom";
		sofaText = "Sofa";
		sunriseText = "Sunrise";
		nightOutText = "Night Out";
		enigmaText = "Enigma";
		cozyNightText = "Cozy Night";
		studyTimeText = "Study Time";
		pleasantBridgeText = "Pleasant Bridge";
		wisteriaText = "Wisteria";
		moonText = "Moon";
		
		bedroomDescriptionText = "<html>A serene bedroom backdrop<br>with a cozy bed placed beneath<br>a large window, inviting<br>ample natural light and<br>a view of the outside world.</html>";
		sofaDescriptionText = "<html>A chill room adorned with<br>a stylish red sofa, creating<br>a focal point of comfort and<br>elegance within a pleasant<br>and inviting ambiance.</html>";
		sunriseDescriptionText = "<html>A breathtaking background<br>capturing the beauty of a<br>sunrise as the sun gracefully<br>emerges on the horizon.</html>";
		nightOutDescriptionText = "<html>An atomospheric street<br>exuding a perfect blend of<br>warmth and chill vibes on<br>a delightful night out.</html>";
		enigmaDescriptionText = "<html>An enigmatic backdrop<br>enveloped in an aura of<br>mystery, painted with deep<br>hues of red, maroon, and gray.</html>";
		cozyNightDescriptionText = "<html>A serene night-time setting with a snug bed adorned with a cuddly teddy bear, radiating warmth and comforting vibes, perfect for peaceful slumber.";
		studyTimeDescriptionText = "<html>An ideal study haven awaits with<br>a grand wooden desk, a radiant<br>lamp illuminating rows of books<br>on a sizable bookshelf, fostering<br>an environment conducive to<br>focused learning.</html>";
		pleasantBridgeDescriptionText = "<html>A serene forest scene unfolds,<br>showcasing a picturesque Japanese<br>bridge gracefully arched over a<br>tranquil river, enveloped by the<br>soothing embrace of nature's<br>beauty.</html>";
		wisteriaDescriptionText = "<html>In a dreamy scene, enchanting<br>wisteria trees flourish, their<br>cascading purple blooms swaying<br>gently as autumn leaves gracefully<br>descend, painting a picturesque<br>moment in nature.</html>";
		moonDescriptionText = "<html>As dawn breaks, a breathtaking<br>spectacle unfolds - a magnificent<br>blue moon hovers in the sky, its<br>radiant beams painting the world<br>in hues of gold and azure, a<br>celestial harmony of sunrise and<br>lunar magic.</html>";
		
		blackText = "Black";
		goldText = "Gold";
		redText = "Red";
		mintText = "Mint";
		purpleText = "Purple";
		blueText = "Blue";
		strawberryLemonadeText = "Strawberry Lemonade";
		sunsetText = "Sunset";
		tealText = "Teal";
		codeText = "Code";
		
		solidBackgroundText = "Solid Background";
		gradientBackgroundText = "Gradient Background";
		rareBackgroundText = "Rare Background";
		themedBackgroundText = "Themed Background";
		
		/*
		 * ##################################
		 * ##################################
		 * SHOP TEXT
		 * ##################################
		 * ##################################
		 */
		selectShopText = "Select Shop";
		foodText = "Food";
		backgroundsText = "Backgrounds";
		bordersText = "Borders";
		yourFoodInventoryIsFullText = "Your Food Inventory is full!";
		confirmPurchaseOfText = "Confirm purchase of";
		notEnoughTamoTokensText = "Not enough Tamo tokens to complete purchase.";
		
		/*
		 * ##################################
		 * ##################################
		 * INVENTORY TEXT
		 * ##################################
		 * ##################################
		 */
		inventoryText = "Inventory";
		feedTamoText = "Feed Tamo";
		setBackgroundText = "Set Background";
		setBorderText = "Set Border";
		welcomeToTheShopText = "Welcome to the shop. What can I help you find?";
		hereAreOurFoodOptionsText = "Here are our food options!";
		whatBackgroundsCanIHelpFindText = "What background can I help you find?";
		whatBordersCanIHelpFindText = "What borders can I help you find?";
		letsCustomizeFocusTimerText = "Let's customize the focus timer!";
		
		/*
		 * ##################################
		 * ##################################
		 * ACHIEVEMENTS STATE TEXT
		 * ##################################
		 * ##################################
		 */
		hoursOnText = "hours on";
		
		/*
		 * ##################################
		 * ##################################
		 * ACHIEVEMENTS STATE TEXT
		 * ##################################
		 * ##################################
		 */
		theBeginningText = "The Beginning";
		theBeginningDescText = "Achieve total focus time of 24 hours.";
		nothingCanStopUsText = "Nothing can stop us!";
		nothingCanStopUsDescText = "Achieve total focus time of 72 hours";
		neverGiveUpText = "Never give up!";
		neverGiveUpDescText = "Achieve total focus time of 240 hours";
		focusAscensionText = "Focus Ascension";
		focusAscensionDescText = "Achieve total focus time of 1200 hours";
		cosmeticsText = "Cosmetics";
		cosmeticsDescText = "Purchase and change your Tamo's border.";
		sceneryChangeText = "Scenery Change";
		sceneryChangeDescText = "Purchase and change your Tamo's background.";
		fromTheBeginningText = "From the Beginning";
		fromTheBeginningDescText = "Updated profile from previous TamoStudy Release.";
		tamoFullText = "Tamo Full";
		tamoFullDescText = "Achieve maximum Tamo hunger.";
		tamoLoveText = "Tamo Love";
		tamoLoveDescText = "Achieve maximum Tamo happiness.";
		dedicatedText = "Dedicated";
		dedicatedDescText = "Focus for 1+ hours for 3 days consecutively.";
		buildingConsistencyText = "Building Consistency";
		buildingConsistencyDescText = "Focus for 1+ hours for 7 days consecutively.";
		tamoScholarText = "Tamo Scholar";
		tamoScholarDescText = "Focus for 1+ hours for 30 days consecutively.";
		
		/*
		 * ##################################
		 * ##################################
		 * SETTINGS STATE TEXT
		 * ##################################
		 * ##################################
		 */
		timerAlarmText = "Timer Alarm";
		noTimerAlarmText = "None";
		softAlarmText = "Soft Alarm";
		traditionalAlarmText = "Traditional Alarm";
		pacAlarmText = "Pac Alarm";
		calmAlarmText = "Calm Alarm";
		bellAlarmText = "Bell Alarm";
		guiSizeText = "Interface Size";
		notificationsText = "Notifications";
		discordRPCText = "Discord RPC";
		exitMessageText = "Exit Message";
		onText = "ON";
		offText = "OFF";
		saveText = "Save";
		resetText = "Reset";
		
		/*
		 * ##################################
		 * ##################################
		 * ABOUT STATE TEXT
		 * ##################################
		 * ##################################
		 */
		aboutTamoStudyText = "<html>TamoStudy is a work and study timer designed to enhance<br>productivity, incorporating an enjoyable virtual pet to<br>motivate users to concentrate on their tasks.</html>";
	}
}
