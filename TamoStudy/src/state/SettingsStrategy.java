package state;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import profile.Profile;
import profile.ProfileReaderWriter;
import resources.BubbleBorder;

public class SettingsStrategy extends StateStrategy {

	public SettingsStrategy(Profile profile) {
		super(profile);
		// TODO Auto-generated constructor stub
	}
	
	private JLabel messageLabel;

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
	private JComboBox soundSettingBox;
	
	private JPanel ahmNotificationsPanel;
	private JLabel ahmNotificationsLabel;
	private JButton ahmNotificationsButton;
	
	private JButton saveChanges;
	
	
	@Override
	public void setPanel() {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setBackground(theme.subColor);
		
		messageLabel = new JLabel("");
			messageLabel.setForeground(new Color(10, 153, 0));
			messageLabel.setFont(theme.fontBoldRegSmall);
			messageLabel.setAlignmentX(JComponent.CENTER_ALIGNMENT);
		
		this.add(messageLabel);
		
		
		//Header
		settingsHeaderLabel = new JLabel(profile.getLanguage().text[9]);
			settingsHeaderLabel.setFont(theme.fontBoldReg);
			settingsHeaderLabel.setForeground(theme.textColor);
			settingsHeaderLabel.setAlignmentX(CENTER_ALIGNMENT);
		this.add(settingsHeaderLabel);
		this.add(createSpaceLabel(0));
		
		optionsPanel = new JPanel();
		optionsPanel.setBackground(theme.subColor);
		optionsPanel.setLayout(new GridLayout(5,1,20,20));
		
		//Settings
		focusSettingPanel = new JPanel();
			focusSettingPanel.setBackground(theme.subColor);
		focusSettingLabel = new JLabel(profile.getLanguage().settingsText[0]);
			focusSettingLabel.setForeground(theme.textColor);
			focusSettingLabel.setFont(theme.fontBoldRegSmall);
		focusSettingBox = new JComboBox();
			styleComponent(focusSettingBox);
			focusSettingBox.addItem(profile.getLanguage().settingsText[4]);
			focusSettingBox.addItem(profile.getLanguage().settingsText[5]);
			focusSettingBox.addItem(profile.getLanguage().settingsText[6]);
			//focusSettingBox.addItem(profile.getLanguage().settingsText[7]);
			focusSettingBox.setSelectedIndex(profile.getSettings().getFocusMode());
			displayUnsavedChanges(focusSettingBox);
		focusSettingPanel.add(focusSettingLabel);
		focusSettingPanel.add(focusSettingBox);
		
		languageSettingPanel = new JPanel();
			languageSettingPanel.setBackground(theme.subColor);
		languageSettingLabel = new JLabel(profile.getLanguage().settingsText[1]);
			languageSettingLabel.setForeground(theme.textColor);
			languageSettingLabel.setFont(theme.fontBoldRegSmall);
		languageSettingBox = new JComboBox();
			styleComponent(languageSettingBox);
			languageSettingBox.addItem(profile.getLanguage().settingsText[8]);
			languageSettingBox.addItem(profile.getLanguage().settingsText[9]);
			languageSettingBox.addItem(profile.getLanguage().settingsText[10]);
			languageSettingBox.addItem(profile.getLanguage().settingsText[11]);
			languageSettingBox.addItem(profile.getLanguage().settingsText[12]);
			languageSettingBox.addItem(profile.getLanguage().settingsText[13]);
			languageSettingBox.addItem(profile.getLanguage().settingsText[14]);
			languageSettingBox.addItem(profile.getLanguage().settingsText[15]);
			languageSettingBox.addItem(profile.getLanguage().settingsText[16]);
			languageSettingBox.addItem(profile.getLanguage().settingsText[17]);
			languageSettingBox.addItem(profile.getLanguage().settingsText[18]);
			languageSettingBox.setSelectedIndex(profile.getLanguageIndicator());
			displayUnsavedChanges(languageSettingBox);
		languageSettingPanel.add(languageSettingLabel);
		languageSettingPanel.add(languageSettingBox);
		
		difficultySettingPanel = new JPanel();
			difficultySettingPanel.setBackground(theme.subColor);
		difficultySettingLabel = new JLabel(profile.getLanguage().settingsText[2]);
			difficultySettingLabel.setForeground(theme.textColor);
			difficultySettingLabel.setFont(theme.fontBoldRegSmall);
		difficultySettingBox = new JComboBox();
			styleComponent(difficultySettingBox);
			difficultySettingBox.addItem(profile.getLanguage().settingsText[19]);
			difficultySettingBox.addItem(profile.getLanguage().settingsText[20]);
			difficultySettingBox.setSelectedIndex(profile.getSettings().getDifficulty());
			displayUnsavedChanges(difficultySettingBox);
		difficultySettingPanel.add(difficultySettingLabel);
		difficultySettingPanel.add(difficultySettingBox);
		
		soundSettingPanel = new JPanel();
			soundSettingPanel.setBackground(theme.subColor);
		soundSettingLabel = new JLabel(profile.getLanguage().settingsText[3]);
			soundSettingLabel.setFont(theme.fontBoldRegSmall);
			soundSettingLabel.setForeground(theme.textColor);
		soundSettingBox = new JComboBox();
			styleComponent(soundSettingBox);
			soundSettingBox.addItem(profile.getLanguage().settingsText[30]);
			soundSettingBox.addItem(profile.getLanguage().settingsText[23]);
			soundSettingBox.addItem(profile.getLanguage().settingsText[24]);
			soundSettingBox.addItem(profile.getLanguage().settingsText[25]);
			soundSettingBox.setSelectedIndex(profile.getSettings().getSessionSoundIndicator());
			displayUnsavedChanges(soundSettingBox);
		soundSettingPanel.add(soundSettingLabel);
		soundSettingPanel.add(soundSettingBox);
		
		ahmNotificationsPanel = new JPanel();
			ahmNotificationsPanel.setBackground(theme.subColor);
		ahmNotificationsLabel = new JLabel(profile.getLanguage().settingsText[29]);
			ahmNotificationsLabel.setFont(theme.fontBoldRegSmall);
			ahmNotificationsLabel.setForeground(theme.textColor);
		
		String labelText;
		if(profile.getSettings().getShowAhmNotifications() == 0) {
			labelText = profile.getLanguage().settingsText[21];
		} else {
			labelText = profile.getLanguage().settingsText[22];
		}
		ahmNotificationsButton = new JButton(labelText);
		styleComponent(ahmNotificationsButton);
		ahmNotificationsPanel.add(ahmNotificationsLabel);
		ahmNotificationsPanel.add(ahmNotificationsButton);
			
		optionsPanel.add(focusSettingPanel);
		optionsPanel.add(languageSettingPanel);
		optionsPanel.add(difficultySettingPanel);
		optionsPanel.add(soundSettingPanel);
		optionsPanel.add(ahmNotificationsPanel);
		
		this.add(optionsPanel);
		this.add(createSpaceLabel(0));
		
		saveChanges = new JButton(profile.getLanguage().settingsText[26]);
		styleComponent(saveChanges);
		this.add(saveChanges);
		this.add(createSpaceLabel(1));
	}

	@Override
	public void setActions() {
		
		ahmNotificationsButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(ahmNotificationsButton.getText().equals(profile.getLanguage().settingsText[21])) {
					ahmNotificationsButton.setText(profile.getLanguage().settingsText[22]);
					messageLabel.setText(profile.getLanguage().settingsText[28]);
				} else {
					ahmNotificationsButton.setText(profile.getLanguage().settingsText[21]);
					messageLabel.setText(profile.getLanguage().settingsText[28]);
				}
			}
			
		});
		
		saveChanges.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//Update focus mode
				profile.getSettings().setFocusMode(focusSettingBox.getSelectedIndex());
				
				//Update language indicator
				profile.setLanguageIndicator(languageSettingBox.getSelectedIndex());
				profile.setLanguageStrategy(languageSettingBox.getSelectedIndex());
				
				//Update Difficulty
				profile.getSettings().setDifficulty(difficultySettingBox.getSelectedIndex());
				
				//Update Sounds
				profile.getSettings().setSessionSoundIndicator(soundSettingBox.getSelectedIndex());
				
				//Update Achievement Notifications
				if(ahmNotificationsButton.getText().equals(profile.getLanguage().settingsText[21])) {
					profile.getSettings().setShowAhmNotifications(0);
				} else {
					profile.getSettings().setShowAhmNotifications(1);
				}
				
				//Write the information to the profile's file
				ProfileReaderWriter.updateProfileInfoToFile(profile);
				
				//Update local UI
				resetComponentsLanguageChange();
				
				//Set the message label to the selected language text
				messageLabel.setText(profile.getLanguage().settingsText[27]);
				
				//Set the text of the save changes button to the selected language text
				saveChanges.setText(profile.getLanguage().settingsText[26]);
			}
			
		});
		
	}
	
	//Upon selecting something from a JComboBox
	//The messageLabel will indicate that there are unsaved changes
	public void displayUnsavedChanges(JComboBox box) {
		box.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				messageLabel.setText(profile.getLanguage().settingsText[28]);
				
			}
			
		});
	}

	
	//Returns the save changes button
	public JButton getSaveChangesButton() {
		return saveChanges;
	}
	
	public int getLanguageIndicatorFromBox() {
		return languageSettingBox.getSelectedIndex();
	}
	
	//Style Component
	public void styleComponent(JComponent comp) {
		if(comp instanceof JButton) {
				comp.setOpaque(true);
				
				if(((JButton) comp).getText().equals(profile.getLanguage().settingsText[26])) {
					comp.setAlignmentX(JComponent.CENTER_ALIGNMENT);
					comp.setBackground(new Color(120,255,120));
					comp.setBorder(new BubbleBorder(Color.BLACK, 2, 10, 10, true));
				} else {
					comp.setBackground(Color.WHITE);
					comp.setBorder(new BubbleBorder(Color.BLACK, 2, 5, 5, true));
				}
					
			
			comp.setFont(theme.fontBoldRegSmall);
			((AbstractButton) comp).setFocusPainted(false);
		}
		
		if(comp instanceof JComboBox) {
			if(System.getProperty("os.name").startsWith("Windows"))
				comp.setBackground(Color.WHITE);
			
			comp.setFont(theme.fontBoldRegSmall);
		}
	}
	
	//Reset method will load new language
	public void resetComponentsLanguageChange() {
		//Header
		settingsHeaderLabel.setText(profile.getLanguage().text[9]);
		
		//Label
		focusSettingLabel.setText(profile.getLanguage().settingsText[0]);
		languageSettingLabel.setText(profile.getLanguage().settingsText[1]);
		difficultySettingLabel.setText(profile.getLanguage().settingsText[2]);
		soundSettingLabel.setText(profile.getLanguage().settingsText[3]);
		ahmNotificationsLabel.setText(profile.getLanguage().settingsText[29]);
		
		//ahmNotifications Button
		String labelText;
		if(profile.getSettings().getShowAhmNotifications() == 0) { labelText = profile.getLanguage().settingsText[21]; } 
		else { labelText = profile.getLanguage().settingsText[22]; }
		ahmNotificationsButton.setText(labelText);
		
		//Combo Boxes
		
		//Focus
		for(int i = focusSettingBox.getItemCount() - 1; i >= 0; i--) { focusSettingBox.removeItemAt(i); }
		focusSettingBox.addItem(profile.getLanguage().settingsText[4]);
		focusSettingBox.addItem(profile.getLanguage().settingsText[5]);
		focusSettingBox.addItem(profile.getLanguage().settingsText[6]);
		focusSettingBox.setSelectedIndex(profile.getSettings().getFocusMode());
		
		//Language
		for(int i = languageSettingBox.getItemCount() - 1; i >= 0; i--) { languageSettingBox.removeItemAt(i); }
		languageSettingBox.addItem(profile.getLanguage().settingsText[8]);
		languageSettingBox.addItem(profile.getLanguage().settingsText[9]);
		languageSettingBox.addItem(profile.getLanguage().settingsText[10]);
		languageSettingBox.addItem(profile.getLanguage().settingsText[11]);
		languageSettingBox.addItem(profile.getLanguage().settingsText[12]);
		languageSettingBox.addItem(profile.getLanguage().settingsText[13]);
		languageSettingBox.addItem(profile.getLanguage().settingsText[14]);
		languageSettingBox.addItem(profile.getLanguage().settingsText[15]);
		languageSettingBox.addItem(profile.getLanguage().settingsText[16]);
		languageSettingBox.addItem(profile.getLanguage().settingsText[17]);
		languageSettingBox.addItem(profile.getLanguage().settingsText[18]);
		languageSettingBox.setSelectedIndex(profile.getLanguageIndicator());
		
		//Difficulty
		for(int i = difficultySettingBox.getItemCount() - 1; i >= 0; i--) { difficultySettingBox.removeItemAt(i); }
		difficultySettingBox.addItem(profile.getLanguage().settingsText[19]);
		difficultySettingBox.addItem(profile.getLanguage().settingsText[20]);
		difficultySettingBox.setSelectedIndex(profile.getSettings().getDifficulty());
		
		//Sound
		for(int i = soundSettingBox.getItemCount() - 1; i >= 0; i--) { soundSettingBox.removeItemAt(i); }
		soundSettingBox.addItem(profile.getLanguage().settingsText[30]);
		soundSettingBox.addItem(profile.getLanguage().settingsText[23]);
		soundSettingBox.addItem(profile.getLanguage().settingsText[24]);
		soundSettingBox.addItem(profile.getLanguage().settingsText[25]);
		soundSettingBox.setSelectedIndex(profile.getSettings().getSessionSoundIndicator());
		
	}
}
