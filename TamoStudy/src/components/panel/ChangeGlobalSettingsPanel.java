package components.panel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import gui.WelcomeGUI;
import io.GlobalSettingsJsonManager;
import model.GlobalSettings;
import model.language.Language;
import resources.Debug;
import resources.Theme;

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
	private Theme theme;
	
	/*
	 * ##################################
	 * ##################################
	 * SELECTION COMPONENTS
	 * ##################################
	 * ##################################
	 */
	private JLabel messageLabel;
	
	private JPanel settingsPanel;
	private JPanel languagePanel;
	private JLabel languageLabel;
	private JComboBox<String> languageBox;
	private JPanel resetDefaultLocalProfilePanel;
	private JLabel resetDefaultLocalProfileLabel;
	private JButton resetDefaultLocalProfileButton;
	private JPanel receiveUpdateNotificationsPanel;
	private JLabel receiveUpdateNotificationsLabel;
	private JButton receiveUpdateNotificationsButton;
	
	private JButton saveChangesButton;
	
	public ChangeGlobalSettingsPanel(WelcomeGUI welcomeGUI) {
		this.welcomeGUI = welcomeGUI;
		
		initializeAttributes();
		initializeComponents();
		initializeComponentVisuals();
		initializeComponentActions();
		addComponentsToPanel();
	}
	
	private void initializeAttributes() {
		globalSettingsJsonManager = welcomeGUI.getGlobalSettingsJsonManager();
		globalSettings = welcomeGUI.getGlobalSettings();
		Debug.info("ChangeGlobalSettingsPanel.initializeAttributes", "globalSettings=" + globalSettings.toString());
		language = globalSettings.getLanguage();
		theme = Theme.DARK;
	}
	
	private void initializeComponents() {
		messageLabel = new JLabel(language.globalSettingsText);
		
		settingsPanel = new JPanel(new GridBagLayout());
		
		languagePanel = new JPanel(new GridBagLayout());
		languageLabel = new JLabel(language.languageText);
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
		
		resetDefaultLocalProfilePanel = new JPanel(new GridBagLayout());
		resetDefaultLocalProfileLabel = new JLabel(language.resetDefaultProfileText);
		resetDefaultLocalProfileButton = new JButton(language.resetText);
		
		receiveUpdateNotificationsPanel = new JPanel(new GridBagLayout());
		receiveUpdateNotificationsLabel = new JLabel(language.updateNotificationsText);
		
		receiveUpdateNotificationsButton = new JButton();
		if(globalSettings.getReceiveUpdateNotifications()) {
			receiveUpdateNotificationsButton.setText(language.onText);
			Theme.primaryVisualButton(receiveUpdateNotificationsButton);
		} else {
			receiveUpdateNotificationsButton.setText(language.offText);
			Theme.secondaryVisualButton(receiveUpdateNotificationsButton);;
		}
		
		
		saveChangesButton = new JButton(language.saveText);
	}
	
	private void initializeComponentVisuals() {
		this.setPreferredSize(new Dimension(500, 400));
		this.setLayout(new GridBagLayout());
		this.setBackground(theme.mainColor);
		
		messageLabel.setFont(theme.fontBoldReg);
		messageLabel.setForeground(Color.WHITE);
		
		settingsPanel.setBackground(theme.subColor);
		settingsPanel.setBorder(Theme.SUB_BORDER);
		
		languagePanel.setBackground(theme.subColor);
		languageLabel.setFont(theme.fontBoldRegSmall);
		languageLabel.setForeground(Color.WHITE);
		languageBox.setSelectedIndex(Language.getIndexFromLanguage(language));
		
		resetDefaultLocalProfilePanel.setBackground(theme.subColor);
		resetDefaultLocalProfileLabel.setFont(theme.fontBoldRegSmall);
		resetDefaultLocalProfileLabel.setForeground(Color.WHITE);
		Theme.primaryVisualButton(resetDefaultLocalProfileButton);
		
		receiveUpdateNotificationsPanel.setBackground(theme.subColor);
		receiveUpdateNotificationsLabel.setFont(theme.fontBoldRegSmall);
		receiveUpdateNotificationsLabel.setForeground(Color.WHITE);
		
		Theme.successVisualButton(saveChangesButton);
	}
	
	private void initializeComponentActions() {
		languageBox.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Language selectedLanguage = Language.getLanguageFromBox(languageBox.getSelectedIndex());
				Debug.info("ChangeGlobalSettingsPanel.languageBox.actionPerformed", "Changing language to " + selectedLanguage.toString());
				globalSettings.setLanguage(selectedLanguage);
			}
		});
		
		resetDefaultLocalProfileButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				messageLabel.setText(language.defaultProfileReset);
				messageLabel.setForeground(Theme.PRIMARY);
				
				globalSettings.setDefaultLocalProfile(-1);
			}
		});
		
		receiveUpdateNotificationsButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(globalSettings.getReceiveUpdateNotifications()) {
					globalSettings.setReceiveUpdateNotifications(false);
					receiveUpdateNotificationsButton.setText(language.offText);
					Theme.secondaryVisualButton(receiveUpdateNotificationsButton);
				} else {
					globalSettings.setReceiveUpdateNotifications(true);
					receiveUpdateNotificationsButton.setText(language.onText);
					Theme.primaryVisualButton(receiveUpdateNotificationsButton);
				}
			}
		});
		
		saveChangesButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				messageLabel.setText(language.settingsSavedText);
				messageLabel.setForeground(Theme.SUCCESS);
				
				globalSettingsJsonManager.writeJsonToFile(globalSettings);
				Debug.info("ChangeGlobalSettingsPanel.saveChangesButton.actionPerformed", "Saved new globalSettings=" + globalSettings);
			}
			
		});
	}
	
	private void addComponentsToPanel() {
		GridBagConstraints gbch = new GridBagConstraints();
		gbch.gridheight = GridBagConstraints.REMAINDER;
		
		GridBagConstraints gbcv = new GridBagConstraints();
		gbcv.gridwidth = GridBagConstraints.REMAINDER;
		
		GridBagConstraints innergbcv = new GridBagConstraints();
		innergbcv.gridwidth = GridBagConstraints.REMAINDER;
		innergbcv.anchor = GridBagConstraints.WEST;
		
		languagePanel.add(languageLabel);
		languagePanel.add(languageBox);
		
		resetDefaultLocalProfilePanel.add(resetDefaultLocalProfileLabel);
		resetDefaultLocalProfilePanel.add(Box.createHorizontalStrut(20));
		resetDefaultLocalProfilePanel.add(resetDefaultLocalProfileButton);
		
		receiveUpdateNotificationsPanel.add(receiveUpdateNotificationsLabel);
		receiveUpdateNotificationsPanel.add(Box.createHorizontalStrut(20));
		receiveUpdateNotificationsPanel.add(receiveUpdateNotificationsButton);
		
		// Settings Panel
		settingsPanel.add(languagePanel, innergbcv);
		settingsPanel.add(Box.createVerticalStrut(20), innergbcv);
		settingsPanel.add(resetDefaultLocalProfilePanel, innergbcv);
		settingsPanel.add(Box.createVerticalStrut(20), innergbcv);
		settingsPanel.add(receiveUpdateNotificationsPanel, innergbcv);
		
		this.add(messageLabel, gbcv);
		this.add(Box.createVerticalStrut(20), gbcv);
		this.add(settingsPanel, gbcv);
		this.add(Box.createVerticalStrut(20), gbcv);
		this.add(saveChangesButton, gbcv);
	}
}
