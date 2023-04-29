package components.panel;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import gui.WelcomeGUI;
import io.GlobalSettingsJsonManager;
import model.GlobalSettings;

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
		addInitialComponentsToPanel();
	}
	
	private void initializeAttributes() {
		globalSettingsJsonManager = welcomeGUI.getGlobalSettingsJsonManager();
		globalSettings = welcomeGUI.getGlobalSettings();
	}
	
	private void initializeComponents() {
		messageLabel = new JLabel("Global Settings");
	}
	
	private void initializeComponentActions() {
		
	}
	
	private void addInitialComponentsToPanel() {
		
	}
}
