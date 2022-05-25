package language;

public class PortugueseStrategy extends LanguageStrategy {
	
	/**
	 * @author Anthony Narlock (narlock)
	 * @translator Kath F.
	*/
	
	public PortugueseStrategy() {
		String engText[] = {
			"MENU",
			"Bem vindo/a, ",
			"Título do card",
			"Foco",
			"Loja",
			"Temas",
			"Inventário",
			"Estatísticas",
			"Conquistas",
			"Configurações",
			"Sobre",
			"Conquista desbloqueada"
		};
		this.text = engText;
		
		String engTitleText[] = {
			"Never give up!!"
		};
		this.titleText = engTitleText;
	
		String engFocusText[] = {
			"Nível",
			"# de sessões",
			"Duração do foco",
			"Duração dointervalo",
			"Iniciar foco",
			"Interromper foco",
			"Foco completado",
			"O foco foi interrompido",
			"Você focou por",
			"minutos(s) e",
			"segundo(s)",
			"Vamos iniciar!",
			"Intervalo"
		};
		this.focusText = engFocusText;
		
		String engShopText[] = {
			"Loja de comida",
			"Fundos",
			"Ei! Eu sou a Kath.",
			"Bem vindo/a a minha loja!",
			"Comprar",
			"Você não tem TamoTokens suficientes",
			"Your Tamo is full!",
			"Tem certeza?",
			"por",
			"TamoTokens?",
			"ae",
			"Tem mais alguma coisa",
			"que eu posso te ajudar?",
			"SIM",
			"NÃO",
			"Você já comprou este item!"
		};
		this.shopText = engShopText;
		
		String[] engThemeText = {
			"Modo Escuro",
			"Modo Claro",
			"Vermelho Clássico",
			"Azul Clássico",
			"Verde Clássico",
			"Amarelo Clássico",
			"Laranja Clássico",
			"Roxo Clássico",
			"Temas",
			"Selecionar",
			"Temas Clássico",
			"Tema alterado para ",
		};
		this.themesText = engThemeText;
		
		String[] engInvText = {
			"Inventário vazio",
			"Selecionar",
			"Fundo alterado!",
			"Inventário"
		};
		this.inventoryText = engInvText;
		
		String[] engStatsText = {
			"Estatísticas",
			"Nome de usuário",
			"Data de criação",
			"Foco total em horas",
			"Consquistas descbloqueadas",
			"Nível do Tamo"
		};
		this.statsText = engStatsText;
		
		String[] engAhmTitle = {
			"O início de tudo!",
			"Nada pode nos parar!",
			"Never give up!",
			"Ascenção do foco",
			"Customizador 1",
			"Customizador 2",
			"Desde o início",
			"Tamo está cheio",
			"Tamo Love",
			"Conquista 10",
			"Conquista 11",
			"Conquista 12"
		};
		this.ahmTitle = engAhmTitle;
		
		String[] engAhmText = {
			"Alcançou um tempo de foco total de<br>3 horas",
			"Alcançou um tempo de foco total de<br>1 dia",
			"Alcançou um tempo de foco total de<br>7 dias",
			"Alcançou um tempo de foco total de<br>30 dias",
			"Mudou o tema do TamoStudy!",
			"Mudou o fundo do seu Tamo's<br>",
			"Atualizou a versão antiga<br>TamoStudy",
			"Achieve maximum Tamo hunger",
			"Deixou seu Tamo 100% feliz",
			"Não sabemos muito sobre essa conquista... ainda",
			"Não sabemos muito sobre essa conquista... ainda",
			"Não sabemos muito sobre essa conquista... ainda"
		};
		this.ahmText = engAhmText;
		
		String[] engSettingsText = {
			"CMudar modo de foco",
			"Mudar língua",
			"Mudar dificuldade",
			"Som do alarme",
			"Tempo de intervalo personalizado",
			"Intervalo de 5 minutos",
			"Modo pomodoro",
			"Modo cronômetro",
			"Inglês",
			"Espanhol",
			"Português",
			"Alemão",
			"Francês",
			"Holandês",
			"Turco",
			"Irlandês",
			"Hindi",
			"Japonês",
			"Chinês",
			"Calmo",
			"Desafiante",
			"Desliga",
			"Liga",
			"Som Soft",
			"Som Trad",
			"Som Pac",
			"Salvar alterações",
			"Alterações salvas!",
			"Você tem alterações que não foram salvas.",
			"Notificações de conquistas",
			"Sem som"
		};
		this.settingsText = engSettingsText;
		
		String[] engAboutText = {
			"TamoStudy timer de produtividade",
			"trabalho e foco que",
			"implementa um pet virtual",
			"que te ajuda a ficar super focado/a!",
			"Desenvolvido por: ",
			"@narlock"
		};
		this.aboutText = engAboutText;
		
		String[] engDeathText = {
			"Seu Tamo morreu",
			"Seu Tamo não recebeu o carinho e atenção que precisava e faleceu",
			"Suas estatísticas serão resetadas",
			"Insira o nome do seu novo Tamo: "
		};
		this.deathText = engDeathText;	
	}
	
	//Change the language in the quotation marks
	//with your language in english
	@Override
	public void printCurrentLanguage() {
		System.out.println("Portuguese");
	}
}
