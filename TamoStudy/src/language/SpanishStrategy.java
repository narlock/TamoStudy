package language;

public class SpanishStrategy extends LanguageStrategy {
	
	/**
	 * @author Anthony Narlock (narlock)
	 * @translator Marie マリ
	 */
	
	public SpanishStrategy() {
		String engText[] = {
			"MENÚ",
			"Bienvenido/a, ",
			"Pantalla de título",
			"Concentración",
			"Tienda",
			"Temas",
			"Inventario",
			"Estadísticas",
			"Logros",
			"Ajustes",
			"Información",
			"Logro debloqueado"
		};
		this.text = engText;
		
		String engTitleText[] = {
			"Never give up!!"
		};
		this.titleText = engTitleText;
	
		String engFocusText[] = {
			"Nivel",
			"Número de sesiónes",
			"Duración de la sesión",
			"Duración de la pausa",
			"Empiezar la concentración",
			"Interrumpir la concentración",
			"Sesión completada",
			"Sesión interrumpida",
			"Te concentraste por",
			"minutos(s) y",
			"segundo(s)",
			"¡Concentremos nos!",
			"Pausa"
		};
		this.focusText = engFocusText;
		
		String engShopText[] = {
			"Tienda de comida",
			"Fondos",
			"¡Hola! Soy Kath.",
			"¡Bienvenido/a a la tienda!",
			"¿Comprar",
			"¡No tienes los fondos suficientes!",
			"¡Tu Tamo está lleno!",
			"¿Estás seguro/a?",
			"por",
			"Fichas Tamo?",
			"y",
			"¿Hay algo en lo que",
			"puedo ayudarte?",
			"SÍ",
			"NO",
			"¡Ya tienes este artículo!"
		};
		this.shopText = engShopText;
		
		String[] engThemeText = {
			"Modo oscuro",
			"Modo claro",
			"Rojo clásico",
			"Azul clásico",
			"Verde clásico",
			"Amarillo clásico",
			"Naranja clásico",
			"Violeta clásico",
			"Temas",
			"Seleccionar",
			"Tema clásicos",
			"Tema cambiado por",
		};
		this.themesText = engThemeText;
		
		String[] engInvText = {
			"Inventario vacío",
			"Seleccionar",
			"¡Fondo cambiado!",
			"Inventario"
		};
		this.inventoryText = engInvText;
		
		String[] engStatsText = {
			"Estadísticas",
			"Usuario",
			"Fecha de registro",
			"Horas totales en concentración",
			"Logros debloqueados",
			"Nivel del Tamo"
		};
		this.statsText = engStatsText;
		
		String[] engAhmTitle = {
			"¡El comienzo!",
			"¡Nada puede pararnos!",
			"¡Nunca abandone!",
			"La Ascensión de la concentración",
			"Personalizador 1",
			"Personalizador 2",
			"Desde el comienzo",
			"Tamo lleno",
			"Amor del Tamo",
			"Logro 10",
			"Logro 11",
			"Logro 12"
		};
		this.ahmTitle = engAhmTitle;
		
		String[] engAhmText = {
			"Alcanzar un tiempo total de concentración de<br>horas",
			"Alcanzar un tiempo total de concentración de<br>1 día",
			"Alcanzar un tiempo total de concentración de<br>7 días",
			"Alcanzar un tiempo total de concentración de<br>30 días",
			"Cambiar el tema de TamoStudy",
			"Cambiar el color de<br>tu Tamo",
			"Actualizar desde una precedente versión<br>de TamoStudy",
			"Llegar el nivel de hambre de tu Tamo al máximo",
			"Llegar el nivel de felicidad de tu Tamo al máximo",
			"No sabemos mucho sobre este logro",
			"No sabemos mucho sobre este logro",
			"No sabemos mucho sobre este logro",
		};
		this.ahmText = engAhmText;
		
		String[] engSettingsText = {
			"Cambiar el modo de concentración",
			"Cambiar el idioma",
			"Cambiar la dificultad",
			"Alarma",
			"Cuenta regresiva personalizada",
			"Intervalo de 5 minutos",
			"Modo pomodoro",
			"Modo cronómetro",
			"Inglés",
			"Español",
			"Portugués",
			"Alemán",
			"Francés",
			"Neerlandés",
			"Turkish",
			"Irlandés",
			"Hindi",
			"Japonés",
			"Chino",
			"Tranquilo",
			"Desafiante",
			"SIN",
			"CON",
			"Alarma suave",
			"Alarma clásica",
			"Alarma Pac",
			"Guardar los cambios",
			"¡Cambios guardados!",
			"Tienes cambios no guardados.",
			"Notificaciones de los logros",
			"Sonido desactivado"
		};
		this.settingsText = engSettingsText;
		
		String[] engAboutText = {
			"¡TamoStudy es un temporizador",
			"de productividad que incluye",
			"una mascota virtual,",
			"ayudándote a mantener concentrado/a!",
			"Desarollado por: ",
			"narlock"
		};
		this.aboutText = engAboutText;
		
		String[] engDeathText = {
			"Muerte del Tamo",
			"Tu Tamo no recibió el cuidado necesitado y murió",
			"Los datos de tu precedente Tamo von a reiniciarse",
			"Nombre del nuevo Tamo: "
		};
		this.deathText = engDeathText;	
	}
	
	@Override
	public void printCurrentLanguage() {
		System.out.println("Spanish");
	}
}
