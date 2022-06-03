package language;

public class FrenchStrategy extends LanguageStrategy {
	
	/**
	 * @author Anthony Narlock (narlock)
	 * @translator Marie マリ
	 */
  	
	public FrenchStrategy() {
		String engText[] = {
			"MENU",
			"Bienvenue, ",
			"Écran titre",
			"Concentration",
			"Magasin",
			"Thèmes",
			"Inventaire",
			"Statistiques",
			"Succès",
			"Paramètres",
			"À propos",
			"Succès débloqué"
		};
		this.text = engText;
		
		String engTitleText[] = {
			"Never give up!!"
		};
		this.titleText = engTitleText;
	
		String engFocusText[] = {
			"Niveau",
			"Nombre de sessions",
			"Durée de la session",
			"Durée de la pause",
			"Commencer la concentration",
			"Interrompre la concentration",
			"Session complétée",
			"Session interrompue",
			"Vous vous êtes concentré(e) pendant",
			"minute(s) et",
			"seconde(s)",
			"Concentrons-nous !",
			"Pause"
		};
		this.focusText = engFocusText;
		
		String engShopText[] = {
			"Supérette",
			"Arrière-plans",
			"Salut ! Je suis Kath.",
			"Bienvenue au magasin !",
			"Acheter",
			"Vous n'avez pas assez de fonds !",
			"Votre Tamo est plein !",
			"Êtes vous sûr(e)?",
			"pour",
			"Jetons Tamo ?",
			"et",
			"Y a-t-il quoi que ce soit",
			"avec lequel je peux vous aider ?",
			"OUI",
			"NON",
			"Vous possédez déjà cet article !"
		};
		this.shopText = engShopText;
		
		String[] engThemeText = {
			"Mode sombre",
			"Mode clair",
			"Rouge classique",
			"Bleu classique",
			"Vert classique",
			"Jaune classique",
			"Orange classique",
			"Violet classique",
			"Thèmes",
			"Sélectionner",
			"Thèmes classiques",
			"Thème changé pour",
		};
		this.themesText = engThemeText;
		
		String[] engInvText = {
			"Inventaire vide",
			"Sélectionner",
			"Arrière-plan changé !",
			"Inventaire"
		};
		this.inventoryText = engInvText;
		
		String[] engStatsText = {
			"Statistiques",
			"Utilisateur",
			"Date d'inscription",
			"Total d'heures",
			"Succès débloqués",
			"Niveau du Tamo"
		};
		this.statsText = engStatsText;
		
		String[] engAhmTitle = {
			"Le commencement !",
			"Rien ne peut nous arrêter !",
			"N'abandonnez jamais !",
			"L'ascension",
			"Personnalisateur 1",
			"Personnalisateur 2",
			"Depuis le début",
			"Tamo plein",
			"Amour de Tamo",
			"Succès 10",
			"Succès 11",
			"Succès 12"
		};
		this.ahmTitle = engAhmTitle;
		
		String[] engAhmText = {
			"Atteignez un temps de concentration total de<br>3 heures",
			"Atteignez un temps de concentration total de<br>1 jour",
			"Atteignez un temps de concentration total de<br>7 jours",
			"Atteignez un temps de concentration total de<br>30 jours",
			"Changez le thème de TamoStudy !",
			"Changez l'arrière-plan de votre<br>Tamo",
			"Mise à jour d'une précédente<br>version de TamoStudy",
			"Atteignez le niveau de faim maximal de votre Tamo",
			"Atteignez le niveau de bonheur maximal de votre Tamo",
			"On ne sait pas grand chose à propos de ce succès",
			"On ne sait pas grand chose à propos de ce succès",
			"On ne sait pas grand chose à propos de ce succès"
		};
		this.ahmText = engAhmText;
		
		String[] engSettingsText = {
			"Changer le mode de concentration",
			"Changer la langue",
			"Changer la difficulté",
			"Alarme",
			"Compte à rebours personnalisé",
			"Intervalle de 5mn",
			"Mode pomodoro",
			"Chronomètre",
			"Anglais",
			"Espagnol",
			"Portugais",
			"Allemand",
			"Français",
			"Néerlandais",
			"Turc",
			"Irlandais",
			"Hindi",
			"Japonais",
			"Chinois",
			"Paisible",
			"Challengeant",
			"SANS",
			"AVEC",
			"Alarme douce",
			"Alarme classique",
			"Alarme Pac",
			"Sauvegarder les modifications",
			"Modifications effectuées !",
			"Vous avez des modifications non sauvegardées.",
			"Notifications des succès",
			"Son désactivé"
		};
		this.settingsText = engSettingsText;
		
		String[] engAboutText = {
			"TamoStudy est un timer de",
			"productivité qui inclut",
			"un animal de compagnie virtuel,",
			"vous aidant à rester concentré !",
			"Développé par : ",
			"@narlock"
		};
		this.aboutText = engAboutText;
		
		String[] engDeathText = {
			"Mort du Tamo",
			"Votre Tamo n'a pas reçu le soin dont il avait besoin et est décédé",
			"Les données de votre précédent Tamo vont être réinitialisées",
			"Nouveau Tamo: "
		};
		this.deathText = engDeathText;	
	}
	
	//Change the language in the quotation marks
	//with your language in english
	@Override
	public void printCurrentLanguage() {
		System.out.println("French");
	}
}
