package profile;
/*
 * @author Anthony Narlock
 * This Language class defines what each type of Langauge will outline
 * 
 * Each profile will be assigned an integer value that will determine their language
 * The language can be modified afterwards.
 * 
 * Language Credits:
 * English: myself (Anthony Narlock)
 * Spanish: oodsofnoodles
 * Portuguese: kathflowers
 * German: boba
 * Japanese: kathflowers
 * Dutch: Britt
 * French: Marie
 */

public class Language {

	private final int INDEX = 50;
	private int lang;
	
	/*
	 * Basic Text Arrays
	 * These contain the basic messages that will appear on each of the screens
	 */
	
	private String[] englishText = {
			"INVALID_KEY_TEXT",
			"Welcome",
			"Level",
			"Start Focus",
			"Break Focus",
			"Statistics",
			"Food Store",
			"Background Store",
			"Options",
			"Logout",
			"Congratulations!",
			"Session Completed",
			"You focused for",
			"minutes(s) and",
			"seconds(s)",
			"Maybe next time...",
			"Session Focus Broke",
			"Total Hours",
			"Total Hours in Session",
			"User",
			"Join Date",
			"Achievements",
			"Hunger",
			"Return To Focus",
			"Can't Complete Purchase",
			"You don't have sufficient funds",
			"Can't enter food store",
			"Your Tamo is full!",
			"Purchase for",
			"TamoTokens",
			"Change Background Color",
			"Change Focus Mode",
			"5-Minute Countdown",
			"Custom Countdown",
			"Change Language",
			"Sounds",
			"Off",
			"On",
			"Logging out...",
			"Are you sure?",
			"OK",
			"Cancel",
			"Yes",
			"No",
			
	};	
	private String[] spanishText = {
			"INVALID_KEY_TEXT",
			"Bienvenido",
			"Nivel",
			"Empieza la Concentración",
			"Pare la Concentración",
			"Estadística",
			"Supermercado",
			"Tienda de Fondos",
			"Opciones",
			"Logout",
			"Felicidades!",
			"Sesión completada",
			"Se ha concentrado para",
			"minuto(s) y",
			"segundo(s)",
			"A lo mejor la próxima vez...",
			"Sesión de Concentración Interrumpida",
			"Horas Totales",
			"Horas Totales en Sesión",
			"Usuario",
			"Fecha de Entrada",
			"Exitos",
			"Hambre",
			"Regresa a Concentración",
			"No se puede completar la compra",
			"No tienes fondos suficientes",
			"No se puede entrar en el supermercado",
			"Tu Tamo está lleno!",
			"Compra por",
			"TamoTokens",
			"Cambia el color del fondo",
			"Cambia el modo de concentración",
			"Cuenta atrás de intervalo de 5 minutos",
			"Cuenta atrás de intervalo de minutos personalizados",
			"Cambia idioma",
			"Sonidos",
			"Apagado",
			"Prendido",
			"Saliendo del sesión...",
			"Está segura?",
			"Sí",
			"Cancela",
			"Sí",
			"No",
			
	};
	private String[] portugueseText = {
			"INVALID_KEY_TEXT",
			"Bem Vindo",
			"Nível",
			"Iniciar foco",
			"Interromper foco",
			"Estatística",
			"Loja de Comidas",
			"Loja de Background",
			"Opções",
			"Sair",
			"Parabéns!",
			"Sessão encerrada",
			"Você manteve o foco por",
			"minuto(s) e",
			"segundo(s)",
			"Talvez na próxima...",
			"Sessão de foco interrompida",
			"Horas totais de focos",
			"Horas totais em sessões",
			"Usuário",
			"Ingressou em",
			"Conquistas",
			"Fome",
			"Retornar ao foco",
			"Não foi possível concluir a compra",
			"Você não tem TamoTokens suficientes",
			"Você não precisa comprar comida agora",
			"Seu Tamo não está com fome!",
			"Compre por",
			"TamoTokens",
			"Mudar cor de fundo",
			"Mudar modo de foco",
			"Intervalo de 5 minutos",
			"Personalizar timer de intervalo",
			"Mundar idioma",
			"Sons",
			"Desligado",
			"Ligado",
			"Fazendo logoff...",
			"Você tem certeza?",
			"OK",
			"Cancelar",
			"Sim",
			"Não",
			
	};
	private String[] germanText = {
			"INVALID_KEY_TEXT",
			"Willkommen",
			"Level",
			"Beginn Fokus",
			"Pause Fokus",
			"Statistiken",
			"Markt",
			"Background Store",
			"Optionen",
			"Logout",
			"Glückwunsch!",
			"Session beendet",
			"Du hast dich für",
			"minute(n) und",
			"sekunde(n) fokussiert",
			"Vielleicht nächstes Mal...",
			"Session-Fokus abgebrochen",
			"Gesamtzeit",
			"Gesamtzeit in Session",
			"Benutzer",
			"Beitrittsdatum",
			"Erfolge",
			"Hunger",
			"Zurück zum Fokus",
			"Kauf kann nicht beendet werden",
			"Nicht genug Tamo Münzen",
			"Betreten des Markts nicht möglich",
			"Dein Tamo ist satt!",
			"Kauf von",
			"Tamo Münzen",
			"Backgroundfarbe ändern",
			"Fokusmodus ändern",
			"5-Intervall-Countdown",
			"Benutzerdefinierter Intervall-Countdown",
			"Sprache ändern",
			"Sounds",
			"Aus",
			"An",
			"Ausloggen...",
			"Bist du dir sicher?",
			"OK",
			"Abbrechen",
			"Ja",
			"No",
			
	};
	private String[] japaneseText;
	private String[] dutchText;
	private String[] frenchText = {
			"INVALID_KEY_TEXT",
			"Bienvenue",
			"Niveau",
			"Commencer la concentration",
			"Arrêter la concentration",
			"Statistiques",
			"Magasin d'alimentation",
			"Magasin d'arrière-plan",
			"Options",
			"Déconnexion",
			"Félicitations !",
			"Session complétée",
			"Vous vous êtes concentré(e) pendant",
			"minute(s) et",
			"seconde(s)",
			"La prochaine fois peut-être...",
			"Concentration interrompue",
			"Total d’heures",
			"Total d’heures en session",
			"Utilisateur",
			"Date d’inscription",
			"Succès",
			"Faim",
			"Retourner à la concentration",
			"Impossible d’effectuer l’achat",
			"Fonds insuffisants",
			"Impossible d'entrer dans le magasin d’alimentation",
			"Votre Tamo est plein !",
			"Acheter pour",
			"JetonsTamo",
			"Changer la couleur d'arrière-plan",
			"Changer le mode de concentration",
			"Minuteur d'intervalle 5mn",
			"Personnaliser le minuteur d'intervalle",
			"Changer la langue",
			"Son",
			"Désactivé",
			"Activé",
			"Déconnexion",
			"Êtes-vous sûr(e) ?",
			"OK",
			"Annuler",
			"Oui",
			"Non",
			
	};
	
	/*
	 * Achievement Text Title Arrays
	 * These arrays contain the titles and descriptions of the achievements
	 */
	
	private String[] englishAhmTitle = {
			"The Beginning",
			"Nothing can stop you!",
			"Never give up!",
			"Customizer 1",
			"Customizer 2",
			"From the beginning",
			"Tamo full",
			"Tamo Love",
			"Dedication 1",
			"Dedication 2",
			"Dedicated"
	};
	private String[] spanishAhmTitle = {
			"El Cominezo",
			"Nada puede detenerle!",
			"Nunca se rinda!",
			"Personalizador 1",
			"Personalizador 2",
			"Del Principio",
			"Tamo lleno",
			"Amor del Tamo",
			"Dedicación 1",
			"Dedicación 2",
			"Dedicado"
	};
	private String[] portugueseAhmTitle = {
			"O Início",
			"Nada pode parar você!",
			"Nunca desista!",
			"Personalizado 1",
			"Personalizado 2",
			"Desde o começo",
			"Tamo no máximo",
			"Tamo Love",
			"Dedicação 1",
			"Dedicação 2",
			"Dedicado"
	};
	private String[] germanAhmTitle = {
			"Der Anfang",
			"Nichts kann dich aufhalten!",
			"Gib niemals auf!",
			"Customizer 1",
			"Customizer 2",
			"Von Anfang an",
			"Tamo satt",
			"Tamo Liebe",
			"Widmung 1",
			"Widmung 2",
			"Gewidmet"
	};
	private String[] japaneseAhmTitle;
	private String[] dutchAhmTitle;
	private String[] frenchAhmTitle = {
			"Le commencement",
			"Rien ne peut vous arrêter !",
			"N'abandonnez jamais !",
			"Personnalisateur 1",
			"Personnalisateur 2",
			"Depuis le début",
			"Tamo plein",
			"Amour de Tamo",
			"Dévouement 1",
			"Dévouement 2",
			"Dévoué"
	};

	/*
	 * Achievement Description Arrays
	 */
	//TODO
	
	
	public Language() {
		this.lang = 0;
	}
	
	public Language(int lang) {
		this.lang = lang;
	}
	
	public void setIndicator(int newLang) {
		this.lang = newLang;
	}
	
	public int getIndicator() {
		return lang;
	}
	
	/*
	 * getText(int num) is a method that will return a string of text in the preferred language
	 * the num parameter indicates the message number that will be returned.
	 */
	
	public String getText(int num) {
		if(lang == 0)
			return englishText[num];
		if(lang == 1)
			return spanishText[num];
		if(lang == 2)
			return portugueseText[num];
		if(lang == 3)
			return germanText[num];
		if(lang == 4)
			return japaneseText[num];
		if(lang == 5)
			return dutchText[num];
		if(lang == 6)
			return frenchText[num];
		
		return null;
	}
	
}
