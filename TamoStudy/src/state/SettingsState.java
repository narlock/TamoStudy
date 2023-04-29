package state;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import gui.TamoStudyGUI;
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
		
	}
	
	private void initializeComponents() {
		decreaseGuiSizeButton = new JButton("-");
		increaseGuiSizeButton = new JButton("+");
	}
	
	private void initializeComponentVisuals() {
		
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
		this.add(decreaseGuiSizeButton);
		this.add(increaseGuiSizeButton);
	}
}
