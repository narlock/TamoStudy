package language;

public class GermanStrategy extends LanguageStrategy {
	
	/**
	 * @author Anthony Narlock (narlock)
	 * @translator Boba
	 */
	
	public GermanStrategy() {
		String engText[] = {
			"MENÜ",
			"Willkommen, ",
			"Titelkarte",
			"Fokus",
			"Shop",
			"Themes",
			"Inventar",
			"Statistiken",
			"Erfolge",
			"Einstellungen",
			"Über",
			"Erfolg freigeschalten"
		};
		this.text = engText;
		
		String engTitleText[] = {
			"Never give up!!"
		};
		this.titleText = engTitleText;
	
		String engFocusText[] = {
			"Level",
			"# von Sessions",
			"Sessiondauer",
			"Pausendauer",
			"Start Fokus",
			"Pause Fokus",
			"Session vollendet",
			"Session Fokus gebrochen",
			"Du warst fokussiert für",
			"Minute(n) und",
			"Sekunde(n)",
			"Konzentriere dich!",
			"Pause"
		};
		this.focusText = engFocusText;
		
		String engShopText[] = {
			"Markt",
			"Backgrounds",
			"Hallo! Ich bin Kath.",
			"Willkommen im Shop!",
			"Kaufen",
			"Nicht genug Tamo Münzen",
			"Dein Tamo ist satt!",
			"Bist du dir sicher?",
			"für",
			"Tamo Münzen?",
			"und",
			"Gibt es etwas",
			"womit ich dir behilflich sein kann?",
			"JA",
			"NEIN",
			"Du hast schon diesen Artikel!"
		};
		this.shopText = engShopText;
		
		String[] engThemeText = {
			"Dunkler Modus",
			"Heller Modus",
			"Klassisches Rot",
			"Klassisches Blau",
			"Klassisches Grün",
			"Klassisches Gelb",
			"Klassisches Orange",
			"Klassisches Lila",
			"Themes",
			"Wähle",
			"Klassische Themes",
			"Theme wurde geändert zu ",
		};
		this.themesText = engThemeText;
		
		String[] engInvText = {
			"Inventar leer",
			"Wähle",
			"Background geändert!",
			"Inventar"
		};
		this.inventoryText = engInvText;
		
		String[] engStatsText = {
			"Statistiken",
			"Nutzername",
			"Beitrrittsdatum",
			"Gesamtfokuszeit",
			"Erfolge freigeschaltet",
			"Tamo Level"
		};
		this.statsText = engStatsText;
		
		String[] engAhmTitle = {
			"Der Anfang!",
			"Nichts kann dich aufhalten!",
			"Never give up!",
			"Fokusanstieg",
			"Customizer 1",
			"Customizer 2",
			"Von Anfang an",
			"Tamo satt",
			"Tamo-Liebe",
			"Erfolg 10",
			"Erfolg 11",
			"Erfolg 12"
		};
		this.ahmTitle = engAhmTitle;
		
		String[] engAhmText = {
			"Gesamtfokuszeit erreicht von<br>3 Stunden",
			"Gesamtfokuszeit erreicht von<br>1 Tag",
			"Gesamtfokuszeit erreicht von<br>7 Tagen",
			"Gesamtfokuszeit erreicht von<br>30 Tagen",
			"Ändere TamoStudys Theme!",
			"Ändere deinen Tamo<br>Background",
			"Profil von einer früheren<br>TamoStudy Version geupdatet",
			"Maximalen Tamo-Hunger erreicht",
			"Maximale Tamo-Freude erreicht",
			"Wir wissen nicht viel von diesem Erfolg",
			"Wir wissen nicht viel von diesem Erfolg",
			"Wir wissen nicht viel von diesem Erfolg"
		};
		this.ahmText = engAhmText;
		
		String[] engSettingsText = {
			"Fokus Modus ändern",
			"Sprache ändern",
			"Schwierigkeitsgrad ändern",
			"Alarm Sound",
			"Benutzerdefinierter Intervall Countdown",
			"5-Intervall-Countdown",
			"Pomodoro Modus",
			"Stoppuhr Modus",
			"Englisch",
			"Spanisch",
			"Portugiesisch",
			"Deutsch",
			"Französisch",
			"Holländisch",
			"Türkisch",
			"Irisch",
			"Hindi",
			"Japanisch",
			"Chinese",
			"Einfach",
			"Schwierig",
			"AUS",
			"AN",
			"Schwacher Alarm",
			"Trad-Alarm",
			"Pac-Alarm",
			"Änderungen speichern",
			"Änderungen gespeichert!",
			"Du hast ungesicherte Änderungen.",
			"Erfolgs-Notifications",
			"Kein Ton"
		};
		this.settingsText = engSettingsText;
		
		String[] engAboutText = {
			"TamoStudy ist ein Produktivitäts-,",
			"Arbeits- und Fokus-Timer, der",
			"ein virtuelles Haustier anwendet",
			"um dich zum konzentrierten Arbeiten zu motivieren!",
			"Entwickelt von: ",
			"Anthony Narlock"
		};
		this.aboutText = engAboutText;
		
		String[] engDeathText = {
			"Tamo Tod",
			"Dein Tamo bekam nicht die benötigte Zuwendung und ist gestorben",
			"Deine Statistiken deines vorherigen Tamos werden zurückgesetzt",
			"Gib den neuen Tamo-Namen ein: "
		};
		this.deathText = engDeathText;	
	}
	
	@Override
	public void printCurrentLanguage() {
		System.out.println("German");
	}
}
