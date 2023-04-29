package state;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import gui.TamoStudyGUI;
import model.language.Language;
import resources.Debug;

public class SettingsState extends State {
	
	private static final long serialVersionUID = -8979954063946210819L;
	
	/*
	 * ##################################
	 * ##################################
	 * ATTRIBUTES
	 * ##################################
	 * ##################################
	 */
	private Language language;
	
	
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


	public SettingsState(TamoStudyGUI tamoStudyGUI) {
		super(tamoStudyGUI);
		initializeAttributes();
		initializeComponents();
		initializeComponentVisuals();
		initializeComponentActions();
		initializePanel();
		
	}
	
	public SettingsState(TamoStudyGUI tamoStudyGUI, int index) {
		super(tamoStudyGUI);
		initializeAttributes();
		initializeComponents();
		initializeComponentVisuals();
		initializeComponentActions(index);
		initializePanel();
	}
	
	private void initializeAttributes() {
		language = tsGui.getProfile().getSettings().getLanguage();
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
		decreaseGuiSizeButton = new JButton("-");
		increaseGuiSizeButton = new JButton("+");
		
		receiveNotificationsPanel = new JPanel(new GridBagLayout());
		receiveNotificationsLabel = new JLabel(language.notificationsText);
		receiveNotificationsButton = new JButton("ON");
		
		enableDiscordRPCPanel = new JPanel(new GridBagLayout());
		enableDiscordRPCLabel = new JLabel(language.discordRPCText);
		enableDiscordRPCButton = new JButton("ON");
		
		showProgramCloseMessagePanel = new JPanel(new GridBagLayout());
		showProgramCloseMessageLabel = new JLabel(language.exitMessageText);
		showProgramCloseMessageButton = new JButton("ON");
		
		saveChangesButton = new JButton(language.saveText);
	}
	
	private void initializeComponentVisuals() {
		this.setLayout(new GridBagLayout());
	}

	private void initializeComponentActions() {
		decreaseGuiSizeButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int index = (int) tsGui.getProfile().getSettings().getGuiSize();
				Debug.info("deceaseGuiButton.actionPerformed", "Index is=" + index);
				if(index > -1) {
					Debug.info("decreaseGuiButton.actionPerformed", "Decreasing gui size");
					tsGui.getProfile().getSettings().setGuiSize(tsGui.getProfile().getSettings().getGuiSize() - 1);
					tsGui.getProfileJsonManager().writeJsonToFile(tsGui.getProfiles());
					tsGui.resizeGui();
				}
			}
		});
		
		increaseGuiSizeButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int index = (int) tsGui.getProfile().getSettings().getGuiSize();
				Debug.info("increaseGuiSizeButton.actionPerformed", "Index is=" + index);
				if(index < 3) {
					Debug.info("increaseGuiSizeButton.actionPerformed", "Increasing gui size");
					tsGui.getProfile().getSettings().setGuiSize(tsGui.getProfile().getSettings().getGuiSize() + 1);
					tsGui.getProfileJsonManager().writeJsonToFile(tsGui.getProfiles());
					tsGui.resizeGui();
				}
			}
		});
	}
	
	/**
	 * initializeComponentActions
	 * @param flag : indicating that we have recalled this GUI on a resize.
	 */
	private void initializeComponentActions(int flag) {
		
		decreaseGuiSizeButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int index = (int) tsGui.getProfile().getSettings().getGuiSize();
				Debug.info("deceaseGuiButton.actionPerformed", "Index is=" + index);
				if(index > -1) {
					Debug.info("decreaseGuiButton.actionPerformed", "Decreasing gui size");
					tsGui.getProfile().getSettings().setGuiSize(tsGui.getProfile().getSettings().getGuiSize() - 1);
					tsGui.getProfileJsonManager().writeJsonToFile(tsGui.getProfiles());
					tsGui.resizeGui();
				}
				
			}
		});

		increaseGuiSizeButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int index = (int) tsGui.getProfile().getSettings().getGuiSize();
				Debug.info("increaseGuiSizeButton.actionPerformed", "Index is=" + index);
				if(index < 3) {
					Debug.info("increaseGuiSizeButton.actionPerformed", "Increasing gui size");
					tsGui.getProfile().getSettings().setGuiSize(tsGui.getProfile().getSettings().getGuiSize() + 1);
					tsGui.getProfileJsonManager().writeJsonToFile(tsGui.getProfiles());
					tsGui.resizeGui();
				}	
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
		
		guiSizePanel.add(guiSizeLabel);
		guiSizePanel.add(decreaseGuiSizeButton);
		guiSizePanel.add(increaseGuiSizeButton);
		
		receiveNotificationsPanel.add(receiveNotificationsLabel);
		receiveNotificationsPanel.add(receiveNotificationsButton);
		
		enableDiscordRPCPanel.add(enableDiscordRPCLabel);
		enableDiscordRPCPanel.add(enableDiscordRPCButton);
		
		showProgramCloseMessagePanel.add(showProgramCloseMessageLabel);
		showProgramCloseMessagePanel.add(showProgramCloseMessageButton);
		
		settingsPanel.add(languagePanel, innergbcv);
		settingsPanel.add(focusModePanel, innergbcv);
		settingsPanel.add(difficultyPanel, innergbcv);
		settingsPanel.add(timerAlarmPanel, innergbcv);
		settingsPanel.add(guiSizePanel, innergbcv);
		settingsPanel.add(receiveNotificationsPanel, innergbcv);
		settingsPanel.add(enableDiscordRPCPanel, innergbcv);
		settingsPanel.add(showProgramCloseMessagePanel, innergbcv);
		
		this.add(messageLabel, gbcv);
		this.add(settingsPanel, gbcv);
		this.add(saveChangesButton, gbcv);
	}
	
	/*
	 * ##################################
	 * ##################################
	 * HELPER METHODS
	 * ##################################
	 * ##################################
	 */
	public void addMessageLabelVisual(JLabel label) {
		
	}
}
