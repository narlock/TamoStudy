package state;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import gui.TamoStudyGUI;
import io.ProfileJsonManager;
import model.GuiSize;
import model.language.Language;
import model.profile.ProfileSettings;
import resources.Debug;
import resources.Theme;

/**
 * SettingsState
 * @author narlock
 * @brief The settings state of TamoStudy
 */
public class SettingsState extends State {
	
	private static final long serialVersionUID = -8979954063946210819L;
	
	/*
	 * ##################################
	 * ##################################
	 * ATTRIBUTES
	 * ##################################
	 * ##################################
	 */
	private ProfileJsonManager profileJsonManager;
	private ProfileSettings settings;
	private Language language;
	private GuiSize guiSize;
	private Theme theme;
	
	/*
	 * ##################################
	 * ##################################
	 * COMPONENTS
	 * ##################################
	 * ##################################
	 */
	private JLabel messageLabel;
	private JPanel settingsPanel;
	private JPanel languagePanel;
	private JLabel languageLabel;
	private JComboBox<String> languageBox;
	private JPanel focusModePanel;
	private JLabel focusModeLabel;
	private JComboBox<String> focusModeBox;
	private JPanel difficultyPanel;
	private JLabel difficultyLabel;
	private JComboBox<String> difficultyBox;
	private JPanel timerAlarmPanel;
	private JLabel timerAlarmLabel;
	private JComboBox<String> timerAlarmBox;
	private JPanel guiSizePanel;
	private JLabel guiSizeLabel;
	private JButton decreaseGuiSizeButton;
	private JButton increaseGuiSizeButton;
	private JPanel receiveNotificationsPanel;
	private JLabel receiveNotificationsLabel;
	private JButton receiveNotificationsButton;
	private JPanel enableDiscordRPCPanel;
	private JLabel enableDiscordRPCLabel;
	private JButton enableDiscordRPCButton;
	private JPanel showProgramCloseMessagePanel;
	private JLabel showProgramCloseMessageLabel;
	private JButton showProgramCloseMessageButton;
	private JButton saveChangesButton;

	/**
	 * SettingsState
	 * @param tamoStudyGUI
	 */
	public SettingsState(TamoStudyGUI tamoStudyGUI) {
		super(tamoStudyGUI);
		initializeAttributes();
		initializeComponents();
		initializeComponentVisuals();
		initializeComponentActions();
		initializePanel();
		
	}
	
	private void initializeAttributes() {
		profileJsonManager = tsGui.getProfileJsonManager();
		settings = tsGui.getProfile().getSettings();
		language = tsGui.getProfile().getSettings().getLanguage();
		guiSize = new GuiSize((int) tsGui.getProfile().getSettings().getGuiSize());
		theme = Theme.DARK;
		Debug.info("SettingsState.initializeAttributes", "Loaded settings=" + settings);
	}
	
	private void initializeComponents() {
		messageLabel = new JLabel("Settings");
		
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
		
		focusModePanel = new JPanel(new GridBagLayout());
		focusModeLabel = new JLabel(language.focusModeText);
		focusModeBox = new JComboBox<>();
		focusModeBox.addItem(language.pomodoroText);
		focusModeBox.addItem(language.customCountdownText);
		focusModeBox.addItem(language.fiveMinIntervalCountdownText);
		focusModeBox.addItem(language.stopwatchText);
		
		difficultyPanel = new JPanel(new GridBagLayout());
		difficultyLabel = new JLabel(language.difficultyText);
		difficultyBox = new JComboBox<>();
		difficultyBox.addItem(language.peacefulText);
		difficultyBox.addItem(language.challengingText);
		difficultyBox.addItem(language.ironManText);
		
		timerAlarmPanel = new JPanel(new GridBagLayout());
		timerAlarmLabel = new JLabel(language.timerAlarmText);
		timerAlarmBox = new JComboBox<>();
		timerAlarmBox.addItem(language.noTimerAlarmText);
		timerAlarmBox.addItem(language.softAlarmText);
		timerAlarmBox.addItem(language.traditionalAlarmText);
		timerAlarmBox.addItem(language.pacAlarmText);
		timerAlarmBox.addItem(language.calmAlarmText);
		timerAlarmBox.addItem(language.bellAlarmText);
		
		guiSizePanel = new JPanel(new GridBagLayout());
		guiSizeLabel = new JLabel(language.guiSizeText);
		decreaseGuiSizeButton = new JButton(guiSize.minusImageIcon);
		increaseGuiSizeButton = new JButton(guiSize.addImageIcon);
		
		receiveNotificationsPanel = new JPanel(new GridBagLayout());
		receiveNotificationsLabel = new JLabel(language.notificationsText);
		receiveNotificationsButton = new JButton();
		
		enableDiscordRPCPanel = new JPanel(new GridBagLayout());
		enableDiscordRPCLabel = new JLabel(language.discordRPCText);
		enableDiscordRPCButton = new JButton();
		
		showProgramCloseMessagePanel = new JPanel(new GridBagLayout());
		showProgramCloseMessageLabel = new JLabel(language.exitMessageText);
		showProgramCloseMessageButton = new JButton();
		
		saveChangesButton = new JButton(language.saveText);
	}
	
	private void initializeComponentVisuals() {
		this.setLayout(new GridBagLayout());
		
		messageLabel.setFont(guiSize.messageLabelFont);
		messageLabel.setForeground(theme.textColor);
		
		settingsPanel.setBackground(theme.mainColor);
		settingsPanel.setBorder(guiSize.settingsPanelBorder);
		
		languagePanel.setBackground(theme.mainColor);
		languageLabel.setFont(guiSize.settingLabelFont);
		languageLabel.setForeground(theme.textColor);
		languageBox.setSelectedIndex(Language.getIndexFromLanguage(language));
		languageBox.setFont(guiSize.settingsChoiceFont);
		
		focusModePanel.setBackground(theme.mainColor);
		focusModeLabel.setFont(guiSize.settingLabelFont);
		focusModeLabel.setForeground(theme.textColor);
		focusModeBox.setSelectedIndex((int) settings.getFocusMode());
		focusModeBox.setFont(guiSize.settingsChoiceFont);
		
		difficultyPanel.setBackground(theme.mainColor);
		difficultyLabel.setFont(guiSize.settingLabelFont);
		difficultyLabel.setForeground(theme.textColor);
		difficultyBox.setSelectedIndex((int) settings.getDifficulty());
		difficultyBox.setFont(guiSize.settingsChoiceFont);
		
		timerAlarmPanel.setBackground(theme.mainColor);
		timerAlarmLabel.setFont(guiSize.settingLabelFont);
		timerAlarmLabel.setForeground(theme.textColor);
		timerAlarmBox.setSelectedIndex((int) settings.getTimerAlarm());
		timerAlarmBox.setFont(guiSize.settingsChoiceFont);
		
		guiSizePanel.setBackground(theme.mainColor);
		guiSizeLabel.setFont(guiSize.settingLabelFont);
		guiSizeLabel.setForeground(theme.textColor);
		addButtonVisual(decreaseGuiSizeButton);
		addButtonVisual(increaseGuiSizeButton);
		
		receiveNotificationsPanel.setBackground(theme.mainColor);
		receiveNotificationsLabel.setFont(guiSize.settingLabelFont);
		receiveNotificationsLabel.setForeground(theme.textColor);
		if(settings.getReceiveNotifications()) {
			receiveNotificationsButton.setText(language.onText);
			Theme.primaryVisualButton(receiveNotificationsButton, guiSize);
		} else {
			receiveNotificationsButton.setText(language.offText);
			Theme.secondaryVisualButton(receiveNotificationsButton, guiSize);
		}
		
		enableDiscordRPCPanel.setBackground(theme.mainColor);
		enableDiscordRPCLabel.setFont(guiSize.settingLabelFont);
		enableDiscordRPCLabel.setForeground(theme.textColor);
		if(settings.getEnableDiscordRPC()) {
			enableDiscordRPCButton.setText(language.onText);
			Theme.primaryVisualButton(enableDiscordRPCButton, guiSize);
		} else {
			enableDiscordRPCButton.setText(language.offText);
			Theme.secondaryVisualButton(enableDiscordRPCButton, guiSize);
		}
		
		showProgramCloseMessagePanel.setBackground(theme.mainColor);
		showProgramCloseMessageLabel.setFont(guiSize.settingLabelFont);
		showProgramCloseMessageLabel.setForeground(theme.textColor);
		if(settings.getShowProgramCloseMessage()) {
			showProgramCloseMessageButton.setText(language.onText);
			Theme.primaryVisualButton(showProgramCloseMessageButton, guiSize);
		} else {
			showProgramCloseMessageButton.setText(language.offText);
			Theme.secondaryVisualButton(showProgramCloseMessageButton, guiSize);
		}
		
		Theme.successVisualButton(saveChangesButton, guiSize);
	}

	private void initializeComponentActions() {
		
		/*
		 * Upon click, the GUI's size will immediately be decreased.
		 * It will only be decreased if there is a size that is lower
		 * than the one it can be decreased to. The size will also
		 * be updated in the profile's settings.
		 */
		decreaseGuiSizeButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int index = (int) tsGui.getProfile().getSettings().getGuiSize();
				Debug.info("deceaseGuiButton.actionPerformed", "Index is=" + index);
				if(index > 0) {
					Debug.info("decreaseGuiButton.actionPerformed", "Decreasing gui size");
					tsGui.getProfile().getSettings().setGuiSize(tsGui.getProfile().getSettings().getGuiSize() - 1);
					tsGui.getProfileJsonManager().writeJsonToFile(tsGui.getProfiles());
					tsGui.resizeGui();
				}
			}
		});
		
		/*
		 * Upon click, the GUI's size will immediate be increased.
		 * It will only be increased if there is a size that is higher
		 * than the one it can be increased to. The size will also
		 * be updated in the profile's settings.
		 */
		increaseGuiSizeButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int index = (int) tsGui.getProfile().getSettings().getGuiSize();
				Debug.info("increaseGuiSizeButton.actionPerformed", "Index is=" + index);
				if(index < 2) {
					Debug.info("increaseGuiSizeButton.actionPerformed", "Increasing gui size");
					tsGui.getProfile().getSettings().setGuiSize(tsGui.getProfile().getSettings().getGuiSize() + 1);
					tsGui.getProfileJsonManager().writeJsonToFile(tsGui.getProfiles());
					tsGui.resizeGui();
				}
			}
		});
		
		/*
		 * Upon click, the button visual will change in accordance to ON/OFF.
		 * This will also set the value inside of the profile, but not
		 * immediately change it.
		 */
		receiveNotificationsButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(receiveNotificationsButton.getText().equals(language.onText)) {
					receiveNotificationsButton.setText(language.offText);
					Theme.secondaryVisualButton(receiveNotificationsButton, guiSize);
				} else {
					receiveNotificationsButton.setText(language.onText);
					Theme.primaryVisualButton(receiveNotificationsButton, guiSize);
				}
			}
		});
		
		/*
		 * Upon click, the button visual will change in accordance to ON/OFF.
		 * This will also set the value inside of the profile, but not
		 * immediately change it.
		 */
		enableDiscordRPCButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(enableDiscordRPCButton.getText().equals(language.onText)) {
					enableDiscordRPCButton.setText(language.offText);
					Theme.secondaryVisualButton(enableDiscordRPCButton, guiSize);
				} else {
					enableDiscordRPCButton.setText(language.onText);
					Theme.primaryVisualButton(enableDiscordRPCButton, guiSize);
				}
			}
		});
		
		/*
		 * Upon click, the button visual will change in accordance to ON/OFF.
		 * This will also set the value inside of the profile, but not
		 * immediately change it.
		 */
		showProgramCloseMessageButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(showProgramCloseMessageButton.getText().equals(language.onText)) {
					showProgramCloseMessageButton.setText(language.offText);
					Theme.secondaryVisualButton(showProgramCloseMessageButton, guiSize);
				} else {
					showProgramCloseMessageButton.setText(language.onText);
					Theme.primaryVisualButton(showProgramCloseMessageButton, guiSize);
				}
			}
		});
		
		/*
		 * Upon click, all of the set values of the settings will be set
		 * to the profile. After this, the settings will be wrote to the
		 * JSON file. Finally, the message label will change to success
		 * and display the saved message.
		 */
		saveChangesButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// Set Settings
				if(receiveNotificationsButton.getText().equals(language.onText)) {
					settings.setReceiveNotifications(true);
				} else {
					settings.setReceiveNotifications(false);
				}
				
				if(!(System.getProperty("os.name").startsWith("Windows"))) {
					settings.setEnableDiscordRPC(false);
				} else if(enableDiscordRPCButton.getText().equals(language.onText)) {
					settings.setEnableDiscordRPC(true);
				} else {
					settings.setEnableDiscordRPC(false);
				}
				
				if(showProgramCloseMessageButton.getText().equals(language.onText)) {
					settings.setShowProgramCloseMessage(true);
				} else {
					settings.setShowProgramCloseMessage(false);
				}
					
				settings.setLanguage(Language.getLanguageFromBox(languageBox.getSelectedIndex()));
				settings.setFocusMode(focusModeBox.getSelectedIndex());
				settings.setDifficulty(difficultyBox.getSelectedIndex());
				settings.setTimerAlarm(timerAlarmBox.getSelectedIndex());
				
				// Overwrite JSON file
				profileJsonManager.writeJsonToFile(tsGui.getProfiles());
				Debug.info("SettingsState.saveChangesButton.actionPerformed", "Wrote profiles to file=" + tsGui.getProfiles());
				
				// Change message label
				messageLabel.setText(language.settingsSavedText);
				messageLabel.setForeground(Theme.SUCCESS);
			}
		});
	}
	
	private void initializePanel() {
		GridBagConstraints gbch = new GridBagConstraints();
		gbch.gridheight = GridBagConstraints.REMAINDER;
		
		GridBagConstraints gbcv = new GridBagConstraints();
		gbcv.gridwidth = GridBagConstraints.REMAINDER;
		
		GridBagConstraints innergbcv = new GridBagConstraints();
		innergbcv.gridwidth = GridBagConstraints.REMAINDER;
		innergbcv.anchor = GridBagConstraints.WEST;
		
		languagePanel.add(languageLabel);
		languagePanel.add(languageBox);
		
		focusModePanel.add(focusModeLabel);
		focusModePanel.add(focusModeBox);
		
		difficultyPanel.add(difficultyLabel);
		difficultyPanel.add(difficultyBox);
		
		timerAlarmPanel.add(timerAlarmLabel);
		timerAlarmPanel.add(timerAlarmBox);
		
		guiSizePanel.add(guiSizeLabel, gbch); 
		guiSizePanel.add(Box.createHorizontalStrut(guiSize.settingsHorizontalDifference), gbch);
		guiSizePanel.add(decreaseGuiSizeButton, gbch);
		guiSizePanel.add(Box.createHorizontalStrut(guiSize.settingsHorizontalDifference), gbch);
		guiSizePanel.add(increaseGuiSizeButton, gbch);
		
		receiveNotificationsPanel.add(receiveNotificationsLabel, gbch);
		receiveNotificationsPanel.add(Box.createHorizontalStrut(guiSize.settingsHorizontalDifference), gbch);
		receiveNotificationsPanel.add(receiveNotificationsButton, gbch);
		
		enableDiscordRPCPanel.add(enableDiscordRPCLabel, gbch);
		enableDiscordRPCPanel.add(Box.createHorizontalStrut(guiSize.settingsHorizontalDifference), gbch);
		enableDiscordRPCPanel.add(enableDiscordRPCButton, gbch);
		
		showProgramCloseMessagePanel.add(showProgramCloseMessageLabel, gbch);
		showProgramCloseMessagePanel.add(Box.createHorizontalStrut(guiSize.settingsHorizontalDifference), gbch);
		showProgramCloseMessagePanel.add(showProgramCloseMessageButton, gbch);
		
		settingsPanel.add(languagePanel, innergbcv);
		settingsPanel.add(Box.createVerticalStrut(guiSize.settingsVerticalDifference), innergbcv);
		settingsPanel.add(focusModePanel, innergbcv);
		settingsPanel.add(Box.createVerticalStrut(guiSize.settingsVerticalDifference), innergbcv);
		settingsPanel.add(difficultyPanel, innergbcv);
		settingsPanel.add(Box.createVerticalStrut(guiSize.settingsVerticalDifference), innergbcv);
		settingsPanel.add(timerAlarmPanel, innergbcv);
		settingsPanel.add(Box.createVerticalStrut(guiSize.settingsVerticalDifference), innergbcv);
		settingsPanel.add(guiSizePanel, innergbcv);
		settingsPanel.add(Box.createVerticalStrut(guiSize.settingsVerticalDifference), innergbcv);
		settingsPanel.add(receiveNotificationsPanel, innergbcv);
		settingsPanel.add(Box.createVerticalStrut(guiSize.settingsVerticalDifference), innergbcv);
		settingsPanel.add(enableDiscordRPCPanel, innergbcv);
		settingsPanel.add(Box.createVerticalStrut(guiSize.settingsVerticalDifference), innergbcv);
		settingsPanel.add(showProgramCloseMessagePanel, innergbcv);
		
		this.add(messageLabel, gbcv);
		this.add(Box.createVerticalStrut(guiSize.settingsVerticalDifference), gbcv);
		this.add(settingsPanel, gbcv);
		this.add(Box.createVerticalStrut(guiSize.settingsVerticalDifference), gbcv);
		this.add(saveChangesButton, gbcv);
		
		if(!(System.getProperty("os.name").startsWith("Windows"))) {
			enableDiscordRPCPanel.setVisible(false);
		}
	}
	
	/*
	 * ##################################
	 * ##################################
	 * HELPER METHODS
	 * ##################################
	 * ##################################
	 */
	public void addButtonVisual(JButton button) {
		button.setOpaque(false);
		button.setFocusPainted(false);
		button.setBorderPainted(false);
	}
}
