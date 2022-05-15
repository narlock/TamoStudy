package State;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SettingsStrategy extends StateStrategy {

	private JLabel settingsHeaderLabel;
	
	private JPanel optionsPanel;
	
	private JPanel focusSettingPanel;
	private JLabel focusSettingLabel;
	private JComboBox focusSettingBox;
	
	private JPanel languageSettingPanel;
	private JLabel languageSettingLabel;
	private JComboBox languageSettingBox;
	
	private JPanel difficultySettingPanel;
	private JLabel difficultySettingLabel;
	private JComboBox difficultySettingBox;
	
	private JPanel soundSettingPanel;
	private JLabel soundSettingLabel;
	private JButton soundSettingONOFFButton;
	private JComboBox soundSettingBox;
	
	private JButton saveChanges;
	
	
	@Override
	public void setPanel() {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setBackground(subColor);
		
		//Header
		settingsHeaderLabel = new JLabel("Settings");
			settingsHeaderLabel.setFont(fontBoldReg);
			settingsHeaderLabel.setForeground(textColor);
			settingsHeaderLabel.setAlignmentX(CENTER_ALIGNMENT);
		this.add(settingsHeaderLabel);
		this.add(createSpaceLabel(0));
		
		optionsPanel = new JPanel();
		optionsPanel.setBackground(subColor);
		optionsPanel.setLayout(new GridLayout(5,1,20,20));
		
		//Settings
		focusSettingPanel = new JPanel();
			focusSettingPanel.setBackground(subColor);
		focusSettingLabel = new JLabel("Change Focus Mode");
			focusSettingLabel.setForeground(textColor);
		focusSettingBox = new JComboBox();
			focusSettingBox.addItem("Pomodoro Mode");
		focusSettingPanel.add(focusSettingLabel);
		focusSettingPanel.add(focusSettingBox);
		
		languageSettingPanel = new JPanel();
			languageSettingPanel.setBackground(subColor);
		languageSettingLabel = new JLabel("Choose Language");
			languageSettingLabel.setForeground(textColor);
		languageSettingBox = new JComboBox();
			languageSettingBox.addItem("Português (Portuguese)");
		languageSettingPanel.add(languageSettingLabel);
		languageSettingPanel.add(languageSettingBox);
		
		difficultySettingPanel = new JPanel();
			difficultySettingPanel.setBackground(subColor);
		difficultySettingLabel = new JLabel("Difficulty");
			difficultySettingLabel.setForeground(textColor);
		difficultySettingBox = new JComboBox();
			difficultySettingBox.addItem("Challenging");
		difficultySettingPanel.add(difficultySettingLabel);
		difficultySettingPanel.add(difficultySettingBox);
		
		soundSettingPanel = new JPanel();
			soundSettingPanel.setBackground(subColor);
		soundSettingLabel = new JLabel("Sounds");
			soundSettingLabel.setForeground(textColor);
		soundSettingONOFFButton = new JButton("OFF");
		soundSettingBox = new JComboBox();
			soundSettingBox.addItem("Soft Alarm");
		soundSettingPanel.add(soundSettingLabel);
		soundSettingPanel.add(soundSettingONOFFButton);
		soundSettingPanel.add(soundSettingBox);
			
		optionsPanel.add(focusSettingPanel);
		optionsPanel.add(languageSettingPanel);
		optionsPanel.add(difficultySettingPanel);
		optionsPanel.add(soundSettingPanel);
		
		this.add(optionsPanel);
		
		saveChanges = new JButton("Save Changes");
			saveChanges.setAlignmentX(CENTER_ALIGNMENT);
		this.add(saveChanges);
		this.add(createSpaceLabel(1));
	}

	@Override
	public void setActions() {
		// TODO Auto-generated method stub
		
	}

}
