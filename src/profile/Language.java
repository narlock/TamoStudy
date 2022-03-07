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
 * Spanish: Marie
 * Portuguese: 
 * German: boba
 * Japanese: Marie
 * Dutch: 
 * French: Marie
 * Chinese: 
 * Turkish: Eno
 * Irish: Medkep
 */

public class Language {

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
	
	private String[] turkishText = {
			"INVALID_KEY_TEXT",
			"Hoş Geldin",
			"Seviye",
			"Odaklanmaya Başla",
			"Odaklanmayı Bitir",
			"İstatistikler",
			"Yiyecek Dükkanı",
			"Arka Plan Dükkanı",
			"Ayarlar",
			"Çıkış Yap",
			"Tebrikler!",
			"Oturum Tamamlandı",
			"",
			"dakika(s) ve",
			"saniye(s) boyunca odaklandın",
			"Bir sonraki sefere...",
			"Odaklanma sonlandırıldı",
			"Toplam Saat",
			"Toplam çalışma saati",
			"Kullanıcı",
			"Kayıt Tarihi",
			"Başarımlar",
			"Açlık",
			"Odaklanmaya Geri Dön",
			"Ödeme Yapılamadı",
			"Yetersiz Bakiye",
			"Yemek Dükkanına Girilemedi",
			"Tamo aç değil!",
			"",
			"TamoToken öde",
			"Arka Plan rengini değiştir",
			"Odaklanma ayarını değiştir",
			"5 aralıklı geri sayım",
			"Manuel Sayaç",
			"Dili Değiştir",
			"Sesler",
			"Kapalı",
			"Açık",
			"Çıkış Yapılıyor...",
			"Emin misin ?",
			"Tamam",
			"İptal",
			"Evet",
			"Hayır",
			
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
	private String[] turkishAhmTitle = {
			"Başlangıç",
			"Hiçbir şey seni durduramaz!",
			"Asla pes etme!",
			"Özelleştirme 1",
			"Özelleştirme 2",
			"Başlangıçtan İtibaren",
			"Tamo Tok",
			"Tamo'nun mutluluğu",
			"ithaf etme 1",
			"ithaf etme 2",
			"ithaf edilen"
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
	private String[] turkishAhmDesc = {
			"Toplamda 3 saat boyunca odaklan",
			"Toplamda 1 gün boyunca odaklan",
			"Toplamda 7 gün boyunca odaklan",
			"Arka plan rengini değiştir",
			"Tamo'nun arka planını değiştir",
			"Beta sürümünden önce güncellenen versiyon",
			"Tamo tokken yemek dükkanına gir",
			"Tamo'nun maksimum sevgisini kazan",
			"TamoStudy'e art arda 7 gün boyunca giriş yap",
			"TamoStudy'e art arda 14 gün boyunca giriş yap",
			"TamoStudy'e art arda 30 gün boyunca giriş yap"
		};
	
	/*
	 * 3.0 General Title Array
	 * 
	 * Guide:
	 * 
	 * [0] -> N/A
	 * [1] -> Profile
	 * [2] -> Statistics
	 * 		[3] -> Total Hours
	 * 		[4] -> Total Hours in Session
	 * 		[5] -> User
	 * 		[6] -> Join Date
	 * [7] -> Inventory
	 * 		[8] -> Use Item
	 * 		[9] -> Inventory Empty
	 * [10] -> Achievements
	 * 		[11] -> The beginning
	 * 			[12] -> Reach total focus time of 3 hours
	 * 		[13] -> Nothing can stop you!
	 * 			[14] -> Reach total focus time of 1 day
	 * 		[15] -> Never give up!
	 * 			[16] -> Reach total focus time of 7 days
	 * 		[17] -> Customizer 1
	 * 			[18] -> Change your background color
	 * 		[19] -> Customizer 2
	 * 			[20] -> Change your Tamo's background
	 * 		[21] -> From the beginning
	 * 			[22] -> Updated profile using Tamo profile updater
	 * 		[23] -> Tamo full
	 * 			[24] -> Entering the food shop when Tamo is full
	 * 		[25] -> Tamo Love
	 * 			[26] -> Achieve maximum Tamo happiness
	 * [27] -> Settings
	 * 		[28] -> Change Focus Mode
	 * 			[29] -> 5-Interval Countdown
	 * 			[30] -> Custom Interval Countdown
	 * 			[31] -> Pomodoro Mode
	 * 		[32] -> Change Language
	 * 		[33] -> Change Difficulty
	 * 			[34] -> Peaceful
	 * 			[35] -> Challenging
	 * 		[36] -> Sounds
	 * 			[37] -> ON
	 * 			[38] -> OFF
	 * [39] -> Food Store
	 * 		[40] -> Hunger
	 * 		[41] -> Tamo Tokens
	 * 		[42] -> Can't complete purchase
	 * 		[43] -> You don't have sufficient funds
	 * 		[44] -> Can't enter food store
	 * 		[45] -> Purchase for
	 * [46] -> Background Store
	 * 		[47] -> Change background color
	 * 		[48] -> Change Tamo background
	 * [49] -> Logout
	 * 		[50] -> Logging out...
	 * 		[51] -> Are you sure?
	 * [52] -> Welcome
	 * [53] -> Level
	 * [54] -> Start Focus
	 * [55] -> Break Focus
	 * [56] -> Return to Focus
	 * [57] -> Let's Focus!
	 * [58] -> # Of Sessions
	 * [59] -> Session Length
	 * [60] -> Break Length
	 * [61] -> Congratulations!
	 * [62] -> Session Completed
	 * 		[63] -> You focused for
	 * 		[64] -> minute(s) and
	 * 		[65] -> second(s)
	 * 		[66] -> Maybe next time...
	 * [67] -> Session Focus Broke
	 */
	
	//English: Anthony
	private String[] english = {
		"PLACEHOLDER",
		"Profile",
		"Statistics",
		"Total Hours",
		"Total Hours in Session",
		"User",
		"Join Date",
		"Inventory",
		"Use Item",
		"Inventory Empty",
		"Achievements",
		"The beginning",
		"Reach total focus time of 3 hours",
		"Nothing can stop you!",
		"Reach total focus time of 1 day",
		"Never give up!",
		"Reach total focus time of 7 days",
		"Customizer 1",
		"Change your background color",
		"Customizer 2",
		"Change your Tamo's background",
		"From the beginning",
		"Updated profile using Tamo profile updater",
		"Tamo full",
		"Entering the food shop when Tamo is full",
		"Tamo Love",
		"Achieve maximum Tamo happiness",
		"Settings",
		"Change Focus Mode",
		"5-Interval Countdown",
		"Custom Interval Countdown",
		"Pomodoro Mode",
		"Change Language",
		"Change Difficulty",
		"Peaceful",
		"Challenging",
		"Sounds",
		"ON",
		"OFF",
		"Food Store",
		"Hunger",
		"Tamo Tokens",
		"Can't complete purchase",
		"You don't have sufficient funds",
		"Can't enter food store",
		"Purchase for",
		"Background Store",
		"Change Background Color",
		"Change Tamo Background",
		"Logout",
		"Logging out...",
		"Are you sure?",
		"Welcome",
		"Level",
		"Start Focus",
		"Break Focus",
		"Return to Focus",
		"Let's Focus!",
		"# Of Sessions",
		"Session Length",
		"Break Length",
		"Congratulations!",
		"Session Completed",
		"You focused for",
		"minute(s) and",
		"second(s)",
		"Maybe next time...",
		"Session Focus Broke"
	};
	
	//Spanish
	private String[] spanish = {
		"PLACEHOLDER",
		"Perfil",
		"Estadísticas",
		"Horas totales",
		"Horas totales en sesión",
		"Usuario",
		"Fecha de entrada",
		"Inventario",
		"Usar artículo",
		"Inventario vacío",
		"Éxitos",
		"El comienzo",
		"Concéntrarse por un tiempo total de 3 horas",
		"¡Nada puede pararte!",
		"Concéntrarse por un tiempo total de 1 día",
		"¡Nunca abandona!",
		"Concéntrarse por un tiempo total de 7 días",
		"Personalizador 1",
		"Cambiar el color del fondo",
		"Personalizador 2",
		"Cambiar el fondo del Tamo",
		"Desde el comienzo",
		"Actualizar el perfil Tamo",
		"Tamo lleno",
		"Entrar al supermercado cuando el Tamo esta lleno",
		"Amor del Tamo",
		"Llegar al máximo de la felicidad del Tamo",
		"Ajustes",
		"Cambiar el modo de concentración",
		"Intervalo de 5 minutos",
		"Cuenta atrás personalizado",
		"Modo pomodoro",
		"Cambiar el idioma",
		"Cambiar la dificultad",
		"Tranquilo",
		"Desafiando",
		"Sonido",
		"Activado",
		"Desactivado",
		"Supermercado",
		"Hambre",
		"Fichas Tamo",
		"Imposible de completar la compra",
		"No tienes fondos suficientes",
		"No te puedes entrar al supermercado",
		"Comprar por",
		"Tienda de fondos",
		"Cambiar el color del fondo",
		"Cambiar el fondo del Tamo",
		"Salir",
		"Saliendo...",
		"Estás seguro",
		"Bienvenido",
		"Nivel",
		"Empiezar la concentración",
		"Parar la concentración",
		"Regresar a la concentración",
		"¡Concentremos nos!",
		"Número de sesiones",
		"Duración de la sesión",
		"Duración de la pausa",
		"¡Felicitaciones!",
		"Sesión completada",
		"Se concentró por",
		"minuto(s) y",
		"segundo(s)",
		"Quizás la próxima vez...",
		"Sesión interrumpida"	
	};
	
	//Portuguese
	private String[] portuguese = {
		"PLACEHOLDER",
		"Perfil",
		"Estatísticas",
		"Horas totais",
		"Horas totais em sessão",
		"Usuário",
		"Data de ingresso",
		"Inventário",
		"Usar item",
		"Seu inventário está vazio",
		"Conquistas",
		"O início",
		"Alcançou um total de 3 horas de foco",
		"Nada pode te parar!",
		"Alcançou um total de 1 dia de foco",
		"Nunca desista!",
		"Alcançou um total de 7 dias de foco",
		"Costumização 1",
		"Mude a cor de fundo",
		"Costumização 2",
		"Mude o fundo do seu Tamo",
		"Desde o início",
		"Atualizou seu perfil usando o Atualizador de Perfil Tamo",
		"O Tamo está cheio",
		"Entrando no Mercado quando o Tamo está cheio",
		"Tamo Love",
		"Seu Tamo aingiu o máximo de felicidade",
		"Configurações",
		"Mudar modo de foco",
		"Contagem regressiva com intevalo 5",
		"Contagem regressiva personalizada",
		"Modo Pomodoro",
		"Mudar idioma",
		"Mudar dificuldade",
		"Pacífico",
		"Desafiador",
		"Sons",
		"Ligado",
		"Desligado",
		"Mercado",
		"Fome",
		"Tamo Tokens",
		"Não foi possível concluir compra",
		"Você não tem Tamo Tokens o suficiente",
		"Não foi possível entrar no Mercado",
		"Adquirir por",
		"Loja de Background",
		"Mudar cor de fundo",
		"Mudar fundo do seu Tamo",
		"Sair",
		"Saindo...",
		"Tem certeza que deseja sair?",
		"Bem vindo",
		"Nível",
		"Iniciar foco",
		"Interromper foco",
		"Voltar ao foco",
		"Vamos concentrar!",
		"# de sessões",
		"Duração da sessão",
		"Duração do intervalo",
		"Parabéns!",
		"Sessão completa",
		"Você focou por",
		"minuto(s) e",
		"segundo(s)",
		"Quem sabe na próxima...",
		"Sessão de foco interrompida"
	};
	
	//German
	private String[] german = {
		"PLACEHOLDER",
		"Profil",
		"Statistik",
		"Gesamtzeit",
		"Gesamtzeit in Session",
		"Benutzer",
		"Beitrittsdatum",
		"Inventar",
		"Gegenstand benutzen",
		"Inventar leer",
		"Erfolge",
		"Der Anfang",
		"Gesamtfokuszeit von 3 Stunden erreicht",
		"Nichts kann dich aufhalten!",
		"Gesamtfokuszeit von 1 Tag erreicht",
		"Gib niemals auf!",
		"Gesamtfokuszeit von 7 Tagen erreicht",
		"Customizer 1",
		"Ändere deine Backgroundfarbe",
		"Customizer 2",
		"Ändere deinen Tamo-Background",
		"Von Anfang an",
		"Upgedatetes Profil über den Tamo Profil Updater",
		"Tamo satt",
		"Betreten des Markts, wenn Tamo satt ist",
		"Tamo Liebe",
		"Erreiche maximales Tamo-Glück",
		"Einstelllungen",
		"Ändere Fokus-Modus",
		"5-Intervall Countdown",
		"Benutzerdefinierter Intervall-Countdown",
		"Pomodoro Modus",
		"Sprache ändern",
		"Schwierigkeit ändern",
		"Einfach",
		"Schwierig",
		"Ton",
		"An",
		"Aus",
		"Markt",
		"Hunger",
		"Tamo Münzen",
		"Kauf kann nicht beendet werden",
		"Nicht genug Tamo Münzen",
		"Betreten des Markts nicht möglich",
		"Kauf von",
		"Background Store",
		"Ändere Backgroundfarbe",
		"Ändere Tamo Background",
		"Logout",
		"Ausloggen...",
		"Bist du dir sicher?",
		"Willkommen",
		"Level",
		"Beginn Fokus",
		"Pause Fokus",
		"Zurück zum Fokus",
		"Konzentriere dich!",
		"# von Sessions",
		"Sessiondauer",
		"Pausendauer",
		"Glückwunsch!",
		"Session vollendet",
		"Fokussiert für",
		"minute(n) und",
		"sekunde(n)",
		"Vielleicht nächstes Mal...",
		"Fokus Session abgebrochen"			
	};
	
	//Japanese: Marie
	private String[] japanese = {
		"PLACEHOLDER",
		"プロファイル",
		"統計",
		"時間集計",
		"今日のセッション時間集計",
		"ユーザー",
		"入会年月日",
		"目録",
		"アイテムを使う",
		"空の目録",
		"アチーブメント",
		"始め",
		"フォーカス時間の集計を３時間に達する",
		"何も止められない！",
		"フォーカス時間の集計を1日間に達する",
		"ネバー・ギブ・アップ！",
		"フォーカス時間の集計を７日間に達する",
		"カストマイザー１",
		"バックグラウンド色を変更する",
		"カストマイザー２",
		"タモのバックグラウンドを変更する",
		"始めから",
		"タモプロファイルアップデーターでプロファイルを更新する",
		"タモフル",
		"タモが満腹したまま、食料品店に行く",
		"タモラブ",
		"タモの幸せレベルを最高に達する",
		"設定",
		"フォーカスモードを変更する",
		"5分間隔カウントダウン",
		"カスタムの間隔カウントダウン",
		"ポモドーロモード",
		"言語を変更する",
		"難易度を変更する",
		"平和的",
		"挑戦的",
		"音",
		"オン",
		"オフ",
		"食料品店",
		"空腹",
		"タモトークンズ",
		"購入できない",
		"お金不足",
		"食料品店に入れない",
		"で購入する", //Number must be at the front of this text
		"バックグラウンドストア",
		"バックグラウンド色を変更する",
		"タモのバックグラウンドを変更する",
		"ログアウト",
		"ログアウト中",
		"本当に？",
		"ようこそ",
		"レベル",
		"フォーカスを始める",
		"フォカスを止める",
		"フォーカスに戻る",
		"フォーカスしよう！",
		"セッション数",
		"セッションの長さ",
		"ブレークの長さ",
		"おめでとうございます！",
		"セッション完成",
		"フォーカスしました",
		"分", //Number must be at the front of this text
		"秒", //Number must be at the front of this text
		"今度かもしれない…",
		"フォーカスセッション中断"	
	};
	
	//Dutch: 
	private String[] dutch = {
			
	};
	
	//French: Marie
	private String[] french = {
		"PLACEHOLDER",
		"Profil",
		"Statistiques",
		"Total d'heures",
		"Total d'heures en session",
		"Utilisateur",
		"Date d'inscription",
		"Inventaire",
		"Utiliser l'objet",
		"Inventaire vide",
		"Succès",
		"Le début",
		"Atteignez un temps de concentration total de 3 heures",
		"Rien ne peut vous arrêter !",
		"Atteignez un temps de concentration total de 1 jour",
		"N'abandonnez jamais !",
		"Atteignez un temps de concentration total de 7 jours",
		"Personnalisateur 1",
		"Changez la couleur d'arrière-plan de votre Tamo",
		"Personnalisateur 2",
		"Changez l'arrière-plan de votre Tamo",
		"Depuis le début",
		"Profil TamoStudy mis à jour",
		"Tamo plein",
		"Entrez dans la supérette lorsque votre Tamo est plein",
		"Amour de Tamo",
		"Atteignez le niveau de bonheur maximal de votre Tamo",
		"Paramètres",
		"Changer le mode de concentration",
		"Intervalle de 5mn",
		"Compte à rebours personnalisé",
		"Mode pomodoro",
		"Changer la langue",
		"Changer la difficulté",
		"Paisible",
		"Challengeant",
		"Son",
		"Avec",
		"Sans",
		"Supérette",
		"Faim",
		"Jetons Tamo",
		"Impossible de compléter l'achat",
		"Fonds insuffisants",
		"Impossible d'entrer dans la supérette",
		"Acheter pour",
		"Magasin d'arrière-plan",
		"Changer la couleur d'arrière-plan",
		"Changer l'arrière-plan du Tamo",
		"Se déconnecter",
		"Déconnexion",
		"Êtes-vous sûr(e) ?",
		"Bienvenue",
		"Niveau",
		"Commencer la concentration",
		"Interrompre la concentration",
		"Retourner à la concentration",
		"Concentrons-nous !",
		"Nombre de sessions",
		"Durée de la session",
		"Durée de la pause",
		"Félicitations !",
		"Session complétée",
		"Vous vous êtes concentré(e) pendant",
		"minute(s) et",
		"seconde(s)",
		"La prochaine fois peut-être...",
		"Session interrompue"
	};
	
	//Chinese:
	private String[] chinese = {
			
	};
	
	//Turkish:
	private String[] turkish = {
		"PLACEHOLDER",
		"Profil",
		"İstatistikler",
		"Toplam Saat",
		"Oturumdaki Toplam Saat",
		"Kullanıcı",
		"Katılma Tarihi",
		"Envanter",
		"Eşyayı Kullan",
		"Envanter Boş",
		"Başarımlar",
		"Başlangıç",
		"Toplamda 3 saat boyunca odaklan",
		"Hiçbir şey seni durduramaz!",
		"Toplamda 1 gün boyunca odaklan",
		"Asla pes etme!",
		"Toplamda 7 gün boyunca odaklan",
		"Kişiselleştirme 1",
		"Arka plan rengini değiştir",
		"Kişiselleştirme 2",
		"Tamo'nun arka planını değiştir",
		"Başlangıçtan itibaren",
		"Tamo profil güncelleyicisi kullanılarak güncelleştirilmiş profil",
		"Tamo doydu",
		"Tamo aç iken yiyecek mağazasına giriş yap",
		"Tamo sevgisi",
		"Maksimum tamo sevgisine eriş",
		"Ayarlar",
		"Odaklanma modunu değiştir",
		"5 Bölmeli Geri Sayım",
		"Özel Ayarlanabilen Geri Sayım",
		"Pomodoro Modu",
		"Dili Değiştir",
		"Zorluğu Değiştir",
		"Barışçıl",
		"Zorlayıcı",
		"Sesler",
		"Açık",
		"Kapalı",
		"Yiyecek Mağazası",
		"Açlık",
		"Tamo Jetonları",
		"Ödeme Yapılamadı",
		"Yeteri kadar jetonun yok",
		"Yyiecek mağazasına girilemiyor",
		"Bunun için öde",
		"Arka Plan Mağazası",
		"Arka Plan rengini değiştir",
		"Tamo'nun arka planını değiştir",
		"Çıkış",
		"Çıkış Yapılıyor",
		"Emin misin ?",
		"Hoş Geldin",
		"Seviye",
		"Odaklanmaya Başla",
		"Odaklanmayı İptal Et",
		"Odaklanmaya Geri Dön",
		"Hadi Odaklanalım !",
		"Oturumun #",
		"Odaklanma Süresi",
		"Mola Süresi",
		"Tebrikler !",
		"Oturum Tamamlandı",
		"Odaklanma Süren",
		"dakika ve",
		"saniye",
		"Belki gelecek sefer ...",
		"Odaklanma Oturumu Bozuldu"
	};
	
	//Irish: Medkep
	private String[] irish = {
		"PLACEHOLDER",
		"Prófíl",
		"Staitisticí",
		"Uaireanta iomlána",
		"Uaireanta iomlána sa seisiún",
		"Úsáideoir",
		"Dáta tosaigh",
		"Fardal",
		"Bain úsaid as mir",
		"Fardal folamh",
		"Éachtaí",
		"An tús",
		"Am fócais iomlán 3 uair an chloig a bhaint amach",
		"Níl aon rud chun stop a chur ort ",
		"Am fócais iomlán 1 lá a bhaint amach",
		"Riamh a thabhairt suas!",
		"Am fócais iomlán 7 lá a bhaint amach",
		"Saincheaptha 1",
		"Aithrigh an dath cúlra",
		"Saincheaptha 2",
		"Aithrigh an cúlra do chuid Tamo",
		"As an tús",
		"Próifíl a nuashonrú ag baint úsáide as úrachadhóir próifíl Tamo",
		"Tamo lán",
		"Entering the food shop when Tamo is full - Ag dul isteach sa siopa bia nuair atá do Tamo lán",
		"Grá Tamo",
		"Sonas Tamo uasta a bhaint amach",
		"Socruithe",
		"Aithraigh modh fócais",
		"Comhaireamh síos 5-eatramh",
		"Comhaireamh síos eatramh saincheaptha",
		"Modh Pomodoro",
		"Aithraigh teanga",
		"Aithrú an dheacracht",
		"Síochanta",
		"Dúshlánach",
		"Fuaim",
		"Cas ar",
		"Múch",
		"Siopa bia",
		"Ocras",
		"Boinn Tamo",
		"Níl feidir cheannach a críochnú",
		"Níl go leor boinn Tamo agat",
		"Níl chead agat dul isteach sa siopa bia",
		"Faigh ar feadh",
		"Siopa cúlra",
		"Aithrigh an dath cúlra",
		"Aithrigh an cúlra do chuid Tamo",
		"Logáil amach",
		"Ag logáil amach...",
		"An bhfuil tú cinnte?",
		"Fáilte",
		"Leibhéal",
		"Tosú ag díriú",
		"Stop ag díriú",
		"Filleadh go dtí díriú",
		"Déanaimis díriú!",
		"Seisiún/í",
		"Fad seisiún",
		"Fad briseadh",
		"Comhghairdeas!",
		"Seisiún críochnaithe",
		"Bhí tú ag díriú i gcomhair",
		"Nóiméad agus",
		"Soicind",
		"B'fhéidir an chéad uair eile ansin",
		"Bhris fócas seisiún"
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
		if(lang == 8)
			return turkishText[num];
		
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
		if(lang == 8)
			return turkishAhmTitle[num];
		
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
		if(lang == 8)
			return turkishAhmDesc[num];
		
		return null;
	}
	
	/*
	 * get
	 * method return indicated text from specified language (from profile)
	 */
	public String get(int num) {
		if(lang == 0)
			return english[num];
		if(lang == 1)
			return spanish[num];
		if(lang == 2)
			return portuguese[num];
		if(lang == 3)
			return german[num];
		if(lang == 4)
			return japanese[num];
		if(lang == 5)
			return dutch[num];
		if(lang == 6)
			return french[num];
		if(lang == 8)
			return turkish[num];
		if(lang == 9)
			return irish[num];
		
		return null;
	}
	
}
