package components.panel;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import gui.WelcomeGUI;
import io.GlobalSettingsJsonManager;
import model.GlobalSettings;
import model.language.Language;

public class ChangeGlobalSettingsPanel extends JPanel {

	private static final long serialVersionUID = 7788124824526423171L;

	/*
	 * ##################################
	 * ##################################
	 * ATTRIBUTES
	 * ##################################
	 * ##################################
	 */
	private WelcomeGUI welcomeGUI;
	private GlobalSettingsJsonManager globalSettingsJsonManager;
	private GlobalSettings globalSettings;
	private Language language;
	
	/*
	 * ##################################
	 * ##################################
	 * SELECTION COMPONENTS
	 * ##################################
	 * ##################################
	 */
	private JLabel messageLabel;
	
	private JPanel settingsPanel;
	private JLabel languageLabel;
	private JComboBox<String> languageBox;
	private JLabel resetDefaultLocalProfileLabel;
	private JButton resetDefaultLocalProfileButton;
	private JLabel receiveUpdateNotificationsLabel;
	private JButton receiveUpdateNotificationsButton;
	
	private JPanel confirmCancelButtonPanel;
	private JButton confirmButton;
	private JButton cancelButton;
	
	public ChangeGlobalSettingsPanel(WelcomeGUI welcomeGUI) {
		this.welcomeGUI = welcomeGUI;
		
		initializeAttributes();
		initializeComponents();
		initializeComponentActions();
		addComponentsToPanel();
	}
	
	private void initializeAttributes() {
		globalSettingsJsonManager = welcomeGUI.getGlobalSettingsJsonManager();
		globalSettings = welcomeGUI.getGlobalSettings();
		language = globalSettings.getLanguage();
	}
	
	private void initializeComponents() {
		messageLabel = new JLabel("Global Settings");
		
		settingsPanel = new JPanel();
		
		languageLabel = new JLabel("Language");
		languageBox = new JComboBox<>();
		languageBox.addItem(language.englishText);
		languageBox.addItem(language.spanishText);
		languageBox.addItem(language.hindiText);
		languageBox.addItem(language.portugueseText);
		languageBox.addItem(language.japaneseText);
		languageBox.addItem(language.germanText);
		languageBox.addItem(language.frenchText);
		languageBox.addItem(language.turkishText);
		languageBox.addItem(language.mandarinChineseText);
		languageBox.addItem(language.dutchText);
		languageBox.addItem(language.koreanText);
		languageBox.addItem(language.russianText);
		languageBox.addItem(language.hungarianText);
		languageBox.addItem(language.romanianText);
		
		resetDefaultLocalProfileLabel = new JLabel("Reset Default Profile");
		resetDefaultLocalProfileButton = new JButton("Reset");
		
		receiveUpdateNotificationsLabel = new JLabel("Update Notifications");
		receiveUpdateNotificationsButton = new JButton("ON");
		
		confirmCancelButtonPanel = new JPanel();
		confirmButton = new JButton("Confirm");
		cancelButton = new JButton("Cancel");
	}
	
	private void initializeComponentActions() {
		
	}
	
	private void addComponentsToPanel() {
		
	}
}
