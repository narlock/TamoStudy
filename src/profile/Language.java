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
 * Japanese: Marie
 * Dutch: Currently no translator
 * French: Marie
 * Chinese: Currently no translator
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
	private String[] japaneseText = {
			"INVALID_KEY_TEXT",
			"ようこそ",
			"レベル",
			"フォーカスを始める",
			"フォカスを止める",
			"統計",
			"食料品店",
			"バックグラウンドストア",
			"設定",
			"ログアウト",
			"おめでとうございます！",
			"セッション完成",
			"",
			"分",
			"秒フォーカスしました。",
			"今度かもしれない…",
			"フォーカスセッション中断",
			"時間集計",
			"セッション時間集計",
			"ユーザー",
			"入会年月日",
			"アチーブメント",
			"空腹",
			"フォーカスに戻る",
			"購入できない",
			"お金不足",
			"食料品店に入れない",
			"タモが満腹している！",
			"",
			"タモトークンで購入する",
			"バックグラウンド色を変更する",
			"フォーカスモードを変更する",
			"5分間隔カウントダウン",
			"間隔カウントダウンを決まる",
			"言語を変更する",
			"音",
			"オフ",
			"オン",
			"ログアウト中",
			"本当ですか？",
			"OK",
			"キャンセル",
			"はい",
			"いいえ",
	};
	
	private String[] dutchText = {
			"INVALID_KEY_TEXT",
			"Welkom",
			"Niveau",
			"Start Focus",
			"Pauzeer Focus",
			"Statistieken",
			"Winkel Voeding",
			"Winkel Achtergrond",
			"Opties",
			"Uitloggen",
			"Gefeliciteerd!",
			"Sessie Voltooid",
			"Je hebt je voor",
			"minu(u)t(en) en",
			"second(en) gefocust",
			"Volgende keer misschien...",
			"Sessie Focus onderbroken",
			"Totaal aantal uren",
			"Totaal aantal uren in sessie",
			"Gebruiker",
			"Lid sinds",
			"Prestaties",
			"Honger",
			"Terug naar Focus",
			"Kan aankoop niet voltooien",
			"Je hebt niet genoeg Tamo Tokens",
			"Kan niet binnen in winkel",
			"Jouw Tamo zit vol!",
			"Koop voor",
			"Tamo Tokens",
			"Verander achtergrondkleur",
			"Focusmode wijzigen",
			"Aftellen met 5 intervallen",
			"Aftellen met aangepaste intervallen",
			"Kies je taal",
			"Geluiden",
			"Uit",
			"Aan",
			"Aan het uitloggen...",
			"Ben je zeker? ",
			"OK",
			"Annuleer",
			"Ja",
			"Nee",
	};
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
	private String[] japaneseAhmTitle = {
			"始め",
			"あなたを何も止められない！",
			"ネバー・ギブ・アップ！",
			"カストマイザー１",
			"カストマイザー2",
			"始めから",
			"タモフル",
			"タモラブ",
			"献身１",
			"献身2",
			"献身的な人"
	};
	private String[] dutchAhmTitle = {
			"Het Begin",
			"Niets houdt je tegen! ",
			"Geef Nooit op!",
			"Aanpasser 1",
			"Aanpasser 2",
			"Vanaf het begin",
			"Tamo vol",
			"Tamo Liefde",
			"Toewijding 1",
			"Toewijding 2",
			"Toegewijd"
	};
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
	private String[] englishAhmDesc = {
		"Reach total focus time of 3 hours",
		"Reach total focus time of 1 day",
		"Reach total focus time of 7 days",
		"Change your background color",
		"Change your Tamo's background",
		"Updated profile from a version before beta",
		"Entering the food shop when Tamo is full",
		"Achieve maximum Tamo happiness",
		"Log into TamoStudy consecutively for 7 days",
		"Log into TamoStudy consecutively for 14 days",
		"Log into TamoStudy consecutively for 30 days"
	};
	private String[] spanishAhmDesc = {
		"Alcance tiempo total de concentración de 3 horas",
		"Alcance tiempo total de concentración de 1 día",
		"Alcance tiempo total de concentración de 7 días",
		"Cambia el color del fondo",
		"Cambia el fondo del Tamo",
		"Se ha actualizado el perfil de una versión anterior a la beta",
		"Entra en el supermercado candy Tamo está lleno",
		"Logra la máxima felicidad de Tamo",
		"Inicie sesión en TamoStudy consecutivamente para 7 días",
		"Inicie sesión en TamoStudy consecutivamente para 14 días",
		"Inicie sesión en TamoStudy consecutivamente para 30 días"
	};
	private String[] portugueseAhmDesc = {
		"Completou 3 horas totais de foco",
		"Completou um dia inteiro de foco",
		"Completou 7 dias inteiros de foco",
		"Mudou a cor do plano de fundo",
		"Mudou o plano de fundo do seu Tamo",
		"Atualizou o perfil de uma versão anterior a beta",
		"Entrou na Loja de Comida quando o Tamo estava cheio",
		"Seu Tamo ficou no máximo da felicidade",
		"Fez login por 7 dias seguidos",
		"Fez login por 14 dias seguidos",
		"Fez login por 30 dias seguidos"
	};
	private String[] germanAhmDesc = {
		"Gesamtfokuszeit von 3 Stunden erreicht",
		"Gesamtfokuszeit von 1 Tag erreicht",
		"Gesamtfokuszeit von 7 Tagen erreicht",
		"Ändere deine Backgroundfarbe",
		"Ändere deinen Tamo-Background",
		"Profil von einer früheren beta Version upgedated",
		"Betreten des Markts, wenn Tamo satt ist",
		"Erreiche maximales Tamo-Glück",
		"Logge dich in TamoStudy für 7 Tage hintereinander ein",
		"Logge dich in TamoStudy für 14 Tage hintereinander ein",
		"Logge dich in TamoStudy für 30 Tage hintereinander ein"
	};
	private String[] japaneseAhmDesc = {
		"-フォーカス時間を集計３時間に達する",
		"フォーカス時間を集計1日間に達する",
		"フォーカス時間を集計７日間に達する",
		"バックグラウンド色を変更する",
		"タモのバックグラウンドを変更する",
		"ベター以前のバージョンからプロファイルを更新する",
		"タモが満腹している間に食料品店に行く",
		"タモの幸せを最高のレベルに達する",
		"7日連続タモスタディにログインする",
		"１４日連続タモスタディにログインする",
		"３０日連続タモスタディにログインする"
	};
	private String[] dutchAhmDesc = {
		"Bereik een totale Focustijd van 3 uur",
		"Bereik een totale Focustijd van 1 dag",
		"Bereik een totale Focustijd van 7 dagen",
		"Verander je achtergrondkleur",
		"Verander Tamo's achtergrond",
		"Update een profiel van een versie voor beta",
		"Voeding winkel binnengaan wanneer Tamo vol zit",
		"Bereik maximaal Tamo-geluk",
		"Log achtereenvolgens in op TamoStudy voor 7 dagen",
		"Log achtereenvolgens in op TamoStudy voor 14 dagen",
		"Log achtereenvolgens in op TamoStudy voor 30 dagen"
	};
	private String[] frenchAhmDesc = {
		"Atteignez une concentration totale de 3 heures",
		"Atteignez une concentration totale de 1 jour",
		"Atteignez une concentration totale de 7 jours",
		"Changez la couleur d'arrière-plan",
		"Changez l'arrière-plan de votre Tamo",
		"Profil mis à jour à partir d'une version antérieure à bêta",
		"Allez dans le magasin d'alimentation lorsque votre Tamo est plein",
		"Atteignez le niveau maximal du bonheur de votre Tamo",
		"Connectez-vous à TamoStudy 7 jours d'affilée",
		"Connectez-vous à TamoStudy 14 jours d'affilée",
		"Connectez-vous à TamoStudy 30 jours d'affilée"
	};
	
	
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
	
	public String getAhmTitle(int num) {
		if(lang == 0)
			return englishAhmTitle[num];
		if(lang == 1)
			return spanishAhmTitle[num];
		if(lang == 2)
			return portugueseAhmTitle[num];
		if(lang == 3)
			return germanAhmTitle[num];
		if(lang == 4)
			return japaneseAhmTitle[num];
		if(lang == 5)
			return dutchAhmTitle[num];
		if(lang == 6)
			return frenchAhmTitle[num];
		
		return null;
	}
	
	public String getAhmDesc(int num) {
		if(lang == 0)
			return englishAhmDesc[num];
		if(lang == 1)
			return spanishAhmDesc[num];
		if(lang == 2)
			return portugueseAhmDesc[num];
		if(lang == 3)
			return germanAhmDesc[num];
		if(lang == 4)
			return japaneseAhmDesc[num];
		if(lang == 5)
			return dutchAhmDesc[num];
		if(lang == 6)
			return frenchAhmDesc[num];
		
		return null;
	}
	
}
