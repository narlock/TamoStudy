package model.language;

/**
 * 
 * @author narlock
 * @translator britthubs
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
public class DutchLanguage extends Language {
	public DutchLanguage() {
		/*
		 * ##################################
		 * ##################################
		 * WELCOME GUI TEXT
		 * ##################################
		 * ##################################
		 */
		createdByText = "Gemaakt door";
		localStudyText = "Lokaal Studeren";
		onlineStudyText = "Online Studeren";
		unableSearchUpdatesText = "Kan niet zoeken naar updates. Niet verbonden met het internet.";
		updateAvailableDownloadText = "is nu beschikbaar. Klik hier om te downloaden!"; // VER ... {}
		
		/*
		 * ##################################
		 * ##################################
		 * MAIN GUI TEXT
		 * ##################################
		 * ##################################
		 */
		areYouSureYouWantToExitText = "Ben je zeker dat je wil stoppen?";
		dontShowThisMessageAgainText = "Toon dit bericht niet opnieuw";
		exitTamoStudyText = "TamoStudy afsluiten?";
		deathText1 = "die de nodige zorg niet heeft gekregen, is helaas overleden.";
		deathText2 = "Vooruitgang van deze Tamo zal worden opgeslaan in de Tamo Geschiedenis.";
		newTamoNameText = "Nieuwe Tamo Naam";
		/*
		 * ##################################
		 * ##################################
		 * PROFILE CREATION / SELECTION TEXT
		 * ##################################
		 * ##################################
		 */
		noProfilesText = "Er werden geen lokale profielen gevonden.";
		welcomeBackText = "Welkom terug bij TamoStudy!";
		createNewProfileText = "Maak Nieuw Profiel Aan";
		importProfileText = "Importeer Profiel van Beta 4.2";
		chooseProfileText = "Kies Profiel";
		loadProfileAutomaticallyText = "Laad Profiel Automatisch";
		loadProfileText = "Laad Profiel";
		deleteProfileText = "Verwijder Profiel";
		invalidProfileFileText = "Ongeldig Beta v4.2 Profiel";
		confirmDeleteProfileText = "Bevestig verwijdering van profiel";
		areYouSureText = "Ben je zeker?";
		createProfileText = "Maak Nieuw TamoStudy Profiel Aan";
		usernameText = "Gebruikersnaam";
		tamoNameText = "Tamo Naam";
		
		languageText = "Taal";
		// Like the language...
		englishText = "Engels";
		spanishText = "Spaans";
		hindiText = "Hindi";
		portugueseText = "Portugees";
		japaneseText = "Japans";
		germanText = "Duits";
		frenchText = "Frans";
		turkishText = "Turks";
		mandarinChineseText = "Mandarijns Chinees";
		dutchText = "Nederlands";
		koreanText = "Koreaans";
		russianText = "Russisch";
		hungarianText = "Hongaars";
		romanianText = "Roemeens";
		
		difficultyText = "Moeilijkheid";
		peacefulText = "Rustig";
		challengingText = "Uitdagend";
		ironManText = "Iron Man";
		
		focusModeText = "Focus Modus";
		pomodoroText = "Pomodoro";
		customCountdownText = "Aangepaste Countdown";
		fiveMinIntervalCountdownText = "5-Min Interval Countdown";
		stopwatchText = "Stopwatch";
		
		resetDefaultProfileText = "Herstel Standaard Profiel";
		updateNotificationsText = "Update Meldingen";
		defaultProfileReset = "Standaard Profiel Reset";
		
		createText = "Creëer";
		cancelText = "Annuleer";
		mustEnterValidNameText = "Voer een geldige naam in!";
		settingsSavedText = "Instellingen Opgeslaan";
		
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
		shopStateButtonText = "Winkel";
		inventoryStateButtonText = "Inventaris";
		statisticsStateButtonText = "Statistieken";
		achievementsStateButtonText = "Prestaties";
		settingsStateButtonText = "Instellingen";
		tamoHistoryText = "Tamo Geschiedenis";
		aboutStateButton = "Over";
		
		/*
		 * ##################################
		 * ##################################
		 * DASHBOARD STATE TEXT
		 * ##################################
		 * ##################################
		 */
		todaysFocusText = "Focus Van Vandaag";
		monthFocusText = "Maandelijkse Focus";
		totalFocusText = "Totale Focus";
		levelText = "Level";
		hoursText = "uren";
		
		/*
		 * ##################################
		 * ##################################
		 * FOCUS STATE TEXT
		 * ##################################
		 * ##################################
		 */
		pomoNumberOfSessionsText = "Aantal sessies";
		pomoSessionLengthText = "Duur van de Sessie";
		pomoBreakLengthText = "Duur van de Pauze";
		minutesText = "Minuten";
		secondsText = "Seconden";
		durationText = "Duur";
		letsFocusText = "Laten we Focussen!";
		focusingText = "Aan het focussen!";
		startFocusText = "Start Focus";
		breakFocusText = "Onderbreek Focus";
		pauseFocusText = "Pauzeer Focus";
		resumeFocusText = "Hervat Focus";
		youFocusedForText = "Je was gefocuust voor";
		minutesAndText = "minuten en";
		secondsPeriodText = "seconden.";
		focusBrokeText = "Focus Onderbroken";
		focusText = "Focus";
		breakText = "Afbreken";
		focusCompleteText = "Focus Compleet";
		breakOverText = "Pauze is gedaan. Tijd om weer te focussen!";
		
		/*
		 * ##################################
		 * ##################################
		 * ITEMS TEXT
		 * ##################################
		 * ##################################
		 */
		onigiriText = "Onigiri";
		chickenPlateText = "Bordje Kip";
		cheesecakeText = "Kaastaart";
		onigiriDescriptionText = "<html>Een traditionele Japanse snack<br>gemaakt van gekruide rijst<br>in de vorm van een bol of driehoek,<br>vaak met een vulling<br>en omwikkeld in zeewier.<br><br>Herstelt 1 hongerpunt.</html>";
		chickenPlateDescriptionText = "<html>Een bord met gebakken<br>kip geserveerd met<br>een variatie aan gerechten en<br>bijgerechten.<br><br>Herstelt 3 hongerpunten.</html>";
		cheesecakeDescriptionText = "<html>Een rijk en romig dessert<br>gemaakt met een korst van<br>verkruimelde koekjes of bladerdeeg,<br>gevuld met een gladde mix van<br>roomkaas en suiker.<br><br>Herstelt 8 hongerpunten.</html>";
		
		bedroomText = "Slaapkamer";
		sofaText = "Bank";
		sunriseText = "Zonsopkomst";
		nightOutText = "Avondje Uit";
		enigmaText = "Mysterie";
		cozyNightText = "Gezellige Avond";
		studyTimeText = "Studeertijd";
		pleasantBridgeText = "Aangename Brug";
		wisteriaText = "Blauweregen";
		moonText = "Maan";
		
		bedroomDescriptionText = "<html>Een serene slaapkamer achtergrond<br>met een gezellig bed onder<br>een groot raam dat<br>natuurlijk licht binnenlaat met<br>uitzicht op de buitenwereld.</html>";
		sofaDescriptionText = "<html>Een rustige kamer versierd met<br>een stijlvolle rode bank<br>en als aandachtspunten comfort en<br>elegantie gepaard met een aangename<br>en uitnodigende sfeer.</html>";
		sunriseDescriptionText = "<html>Een adembenemende achtergrond<br>die de schoonheid van de zonsopkomst<br>vastlegt wanneer de zon gracieus<br>aan de horizon verschijnt.</html>";
		nightOutDescriptionText = "<html>Een atmosferische straat<br>die een perfecte mix van<br>warmte en rust uitstraalt tijdens<br>een heerlijk avondje uit.</html>";
		enigmaDescriptionText = "<htmlEen raadselachtige achtergrond<br>omhuld in een aura van<br>mysterie, gekleurd met diepe<br>tinten rood, kastanjebruin en grijs.</html>";
		cozyNightDescriptionText = "<html>Een serene nachtsetting met een comfortabel bed<br>uitgerust met een schattige knuffelbeer<br>die warmte en een comfortabele sfeer uitstraalt,<br>perfect voor een rustig dutje.";
		studyTimeDescriptionText = "<html>Een ideaal studieplekje wacht op je<br>met een groot houten bureau en een stralende<br>lamp die rijen aan boeken verlicht<br>op een omvangrijke boekenkast,<br>een omgeving die focus uitnodigt.</html>";
		pleasantBridgeDescriptionText = "<html>Een serene beboste scène onthult<br>een prachtige Japanse brug die<br>gracieus buigt over een rustige rivier,<br>omringd door een verzachtende<br>omgeving met de schoonheid van de natuur.</html>";
		wisteriaDescriptionText = "<html>In een dromerige scène, bloeien betoverende<br>Blauweregen bomen, hun<br>cascaderende paarse bloesems schommelen<br>zachtjes als de herfstbladeren gracieus<br>naar beneden dwarrelen<br>en een prachtig moment in de<br>natuur vastleggen.</html>";
		moonDescriptionText = "<html>Als de ochtendgloren aanbreekt, ontvouwt<br>zich een prachtig spektakel- een<br>schitterende blauwe maan hangt in de lucht<br>en beschildert de wereld in tinten goud<br>en azuurblauw met haar heldere stralen,<br>een hemelse harmonie tussen<br>zonsopkomst en lunaire magie.</html>";
		
		blackText = "Zwart";
		goldText = "Goud";
		redText = "Rood";
		mintText = "Munt";
		purpleText = "Paars";
		blueText = "Blauw";
		strawberryLemonadeText = "Aardbei Limonade";
		sunsetText = "Zonsondergang";
		tealText = "Appelblauwzeegroen";
		codeText = "Code";
		
		solidBackgroundText = "Egale Achtergrond";
		gradientBackgroundText = "Gradiënt Achtergrond";
		rareBackgroundText = "Zeldzame Achtergrond";
		themedBackgroundText = "Thema Achtergrond";
		
		/*
		 * ##################################
		 * ##################################
		 * SHOP TEXT
		 * ##################################
		 * ##################################
		 */
		selectShopText = "Selecteer Winkel";
		foodText = "Voeding";
		backgroundsText = "Achtergronden";
		bordersText = "Boorden";
		yourFoodInventoryIsFullText = "Je voedingsinventaris is vol!";
		confirmPurchaseOfText = "Bevestig aankoop van";
		notEnoughTamoTokensText = "Niet genoeg Tamo tokens om de aankoop te vervolledigen.";
		
		/*
		 * ##################################
		 * ##################################
		 * INVENTORY TEXT
		 * ##################################
		 * ##################################
		 */
		inventoryText = "Inventaris";
		feedTamoText = "Geef Tamo te eten";
		setBackgroundText = "Stel Achtergrond In";
		setBorderText = "Stel Boord In";
		welcomeToTheShopText = "Welkom in de winkel. Waar kan ik je mee helpen?";
		hereAreOurFoodOptionsText = "Hier zijn onze voeding opties!";
		whatBackgroundsCanIHelpFindText = "Welke achtergrond kan ik je helpen zoeken?";
		whatBordersCanIHelpFindText = "Welke boord kan ik je helpen zoeken?";
		letsCustomizeFocusTimerText = "Laten we de focus timer aanpassen!";
		
		/*
		 * ##################################
		 * ##################################
		 * ACHIEVEMENTS STATE TEXT
		 * ##################################
		 * ##################################
		 */
		hoursOnText = "uren aan";
		
		/*
		 * ##################################
		 * ##################################
		 * ACHIEVEMENTS STATE TEXT
		 * ##################################
		 * ##################################
		 */
		theBeginningText = "Het Begin";
		theBeginningDescText = "Behaal totale focus tijd van 24 uur.";
		nothingCanStopUsText = "Niets kan ons tegenhouden!";
		nothingCanStopUsDescText = "Behaal totale focus tijd van 72 uur";
		neverGiveUpText = "Geef nooit op!";
		neverGiveUpDescText = "Behaal totale focus van 240 uur";
		focusAscensionText = "Focus stijging";
		focusAscensionDescText = "Behaal totale focus tijd van 1200 hours";
		cosmeticsText = "Cosmetica";
		cosmeticsDescText = "Koop en pas de boord van jouw Tamo aan.";
		sceneryChangeText = "Verandering van omgeving";
		sceneryChangeDescText = "Koop en pas de achtergrond van jouw Tamo aan.";
		fromTheBeginningText = "Vanaf het Begin";
		fromTheBeginningDescText = "Update profiel van vorige TamoStudy Release.";
		tamoFullText = "Tamo Vol";
		tamoFullDescText = "Behaal maximale Tamo honger.";
		tamoLoveText = "Tamo Liefde";
		tamoLoveDescText = "Behaal maximaal Tamo geluk.";
		dedicatedText = "Toewijding";
		dedicatedDescText = "Focus voor 1+ uren in 3 achtereenvolgende dagen.";
		buildingConsistencyText = "Bouw Consistentie Op";
		buildingConsistencyDescText = "Focus voor 1+ uren in 7 achtereenvolgende dagen.";
		tamoScholarText = "Tamo Geleerde";
		tamoScholarDescText = "Focus voor 1+ uren in 30 achtereenvolgende dagen.";
		
		/*
		 * ##################################
		 * ##################################
		 * SETTINGS STATE TEXT
		 * ##################################
		 * ##################################
		 */
		timerAlarmText = "Timer Alarm";
		noTimerAlarmText = "Geen";
		softAlarmText = "Zacht Alarm";
		traditionalAlarmText = "Traditioneel Alarm";
		pacAlarmText = "Pac Alarm";
		calmAlarmText = "Kalm Alarm";
		bellAlarmText = "Bel Alarm";
		guiSizeText = "Interface Grootte";
		notificationsText = "Meldingen";
		discordRPCText = "Discord RPC";
		exitMessageText = "Uitgang Bericht";
		onText = "AAN";
		offText = "UIT";
		saveText = "Opslaan";
		resetText = "Reset";
		
		/*
		 * ##################################
		 * ##################################
		 * ABOUT STATE TEXT
		 * ##################################
		 * ##################################
		 */
		aboutTamoStudyText = "<html>TamoStudy is een werk- en studeertimer ontwikkeld om<br>productiviteit te verbeteren, met implementatie van een aangenaam<br>virtueel huisdiertje om gebruikers te<br>motiveren zich te concentreren op hun taken.</html>";
	}
}
