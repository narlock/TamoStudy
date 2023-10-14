package components.panel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import gui.TamoStudyGUI;
import gui.WelcomeGUI;
import io.ProfileJsonManager;
import model.language.Language;
import model.profile.Profile;
import resources.Debug;
import resources.Theme;
import util.Utils;

public class ProfileSelectionPanel extends JPanel {

	private static final long serialVersionUID = -3861540929503194485L;
	
	/*
	 * ##################################
	 * ##################################
	 * ATTRIBUTES
	 * ##################################
	 * ##################################
	 */
	private WelcomeGUI welcomeGUI;
	private ProfileJsonManager profileJsonManager;
	private List<Profile> profiles;
	private Theme theme;
	private Language language;
	
	/*
	 * ##################################
	 * ##################################
	 * SELECTION COMPONENTS
	 * ##################################
	 * ##################################
	 */
	private JLabel messageLabel;
	private boolean foundProfiles;
	
	private JPanel createButtonPanel;
	private JButton createNewProfileButton;
	private JButton importProfileButton;
	
	private JPanel selectProfilePanel;
	private JLabel selectProfileLabel;
	private JComboBox<String> profilesBox;
	private JCheckBox assignDefaultProfile;
	
	private JPanel profileOptionsButtonPanel;
	private JButton loadProfileButton;
	private JButton deleteProfileButton;
	
	/*
	 * ##################################
	 * ##################################
	 * CREATION COMPONENTS
	 * ##################################
	 * ##################################
	 */
	private JLabel createProfileLabel;
	
	private JPanel createProfilePanel;
	private JLabel enterUsernameLabel;
	private JPanel enterUsernamePanel;
	private JTextField enterUsernameTextField;
	private JLabel enterTamoNameLabel;
	private JPanel enterTamoNamePanel;
	private JTextField enterTamoNameTextField;
	private JPanel languagePanel;
	private JLabel languageLabel;
	private JComboBox<String> languageBox;
	private JPanel difficultyPanel;
	private JLabel difficultyLabel;
	private JComboBox<String> difficultyBox;
	private JPanel focusModePanel;
	private JLabel focusModeLabel;
	private JComboBox<String> focusModeBox;
	
	private JPanel createProfileButtonPanel;
	private JButton confirmCreateProfileButton;
	private JButton cancelCreateProfileButton;
	
	public ProfileSelectionPanel(WelcomeGUI welcomeGUI) {
		this.welcomeGUI = welcomeGUI;
		
		initializeAttributes();
		initializeComponents();
		initializeComponentActions();
		addInitialComponentsToPanel();
	}
	
	private void initializeAttributes() {
		profileJsonManager = new ProfileJsonManager();
		profiles = profileJsonManager.readJson();
		theme = Theme.DARK;
		language = welcomeGUI.getGlobalSettings().getLanguage();
	}
	
	/*
	 * ##################################
	 * ##################################
	 * SELECTION MENU
	 * ##################################
	 * ##################################
	 */
	
	private void initializeInitialMode() {
		initializeAttributes();
		initializeComponents();
		initializeComponentActions();
		addInitialComponentsToPanel();
	}
	
	private void initializeComponents() {
		foundProfiles = !profiles.isEmpty();
		
		messageLabel = new JLabel();
		if(!foundProfiles) {
			messageLabel.setText(language.noProfilesText);
		} else {
			messageLabel.setText(language.welcomeBackText);
		}
		
		createButtonPanel = new JPanel();
		createNewProfileButton = new JButton(language.createNewProfileText);
		importProfileButton = new JButton(language.importProfileText);
		
		selectProfilePanel = new JPanel();
		selectProfileLabel = new JLabel(language.chooseProfileText);
		profilesBox = new JComboBox<>();
		if(foundProfiles) {
			for(Profile profile : profiles) {
				profilesBox.addItem(profile.getName());
			}
		}
		assignDefaultProfile = new JCheckBox(language.loadProfileAutomaticallyText);
		
		profileOptionsButtonPanel = new JPanel();
		loadProfileButton = new JButton(language.loadProfileText);
		deleteProfileButton = new JButton(language.deleteProfileText);
		
		initializeComponentVisuals();
	}
	
	private void initializeComponentActions() {
		createNewProfileButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
		        // Remove all components from this
		        removeAllComponents();
		        
		        // Enter Create Mode
		        initializeCreateMode();
			}
			
		});
		
		importProfileButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
	            int returnValue = fileChooser.showOpenDialog(null);

	            if (returnValue == JFileChooser.APPROVE_OPTION) {
	               String[] contents = Utils.decrypt(Utils.readFile(fileChooser.getSelectedFile())).split(",");
	               
	               try {
	            	   // Ensure that the file is from Beta v4.0 - v4.2
		               boolean sizeCheck = contents.length == 21;
		               boolean versionCheck = contents[0].equals("b4.0");
		               
		               if(sizeCheck && versionCheck) {
		            	   /**
			                 * A Beta v4.2 button should meet the following requirements
			                 * 
							 * [0] version
							 * [1] username
							 * [2] joinDateString
							 * [3] lastLoginDateString
							 * [4] tamoTokens
							 * [5] totalTime
							 * [6] bgIndicator
							 * [7] themeIndicator
							 * [8] strikes
							 * [9] tamoName
							 * [10] tamoHappiness
							 * [11] tamoHunger
							 * [12] tamoId
							 * [13] languageIndicator
							 * [14] ahmString
							 * [15] invString
							 * [16] focusMode
							 * [17] sessionSoundIndicator
							 * [18] backgroundSoundIndicator
							 * [19] difficulty
							 * [20] showAhmNotifications
							 */
			               Profile profile = new Profile(
			            		   		contents[1],
			            		   		contents[2],
			            		   		contents[3],
			            		   		Long.parseLong(contents[5]),
			            		   		Long.parseLong(contents[4]),
			            		   		Long.parseLong(contents[6]),
			            		   		Long.parseLong(contents[8]),
			            		   		contents[9],
			            		   		Long.parseLong(contents[10]),
			            		   		Long.parseLong(contents[11]),
			            		   		Long.parseLong(contents[12]),
			            		   		Long.parseLong(contents[13]),
			            		   		contents[14],
			            		   		contents[15],
			            		   		Long.parseLong(contents[16]),
			            		   		Long.parseLong(contents[17]),
			            		   		Long.parseLong(contents[19]),
			            		   		(contents[20].equals("0") ? false : true)
			            		   );
			               Debug.info("ProfileSelectionPanel.importProfileButton.actionPerformed", "Loaded Beta v4.2 profile: " + profile.toString());
			               
			               // Add Profile to Profiles List and update profiles.json
			               List<Profile> allProfiles = new ArrayList<>();
							for(Profile aProfile : profiles) {
								allProfiles.add(aProfile);
							}
							allProfiles.add(profile);
							profileJsonManager.writeJsonToFile(allProfiles);
			               
			               // Revalidate GUI
							removeAllComponents();
							initializeInitialMode();
		               } 
		               else throw new Exception();
		               
	               } catch (Exception e1) {
	            	   Debug.error("ProfileSelectionPanel.importProfileButton.actionPerformed", "Selected file failed index access check");
	            	   setMessageLabelError(language.invalidProfileFileText);
	            	   e1.printStackTrace();
	               }
	               
	            }
			}
			
		});
		
		loadProfileButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int profileIndex = profilesBox.getSelectedIndex();
				if(assignDefaultProfile.isSelected()) {
					welcomeGUI.getGlobalSettings().setDefaultLocalProfile(profileIndex);
					welcomeGUI.getGlobalSettingsJsonManager().writeJsonToFile(welcomeGUI.getGlobalSettings());
				}
				new TamoStudyGUI(profiles, profileIndex);
				close();
			}
			
		});
		
		deleteProfileButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Profile profile = profiles.get(profilesBox.getSelectedIndex());
				
				int result = JOptionPane.showConfirmDialog(getRootPane(),
						language.confirmDeleteProfileText + " " + profile.getName() + ".",
						language.areYouSureText,
						JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE,
						new ImageIcon(getClass().getClassLoader().getResource("INFO.png"))
					);

				if (result == JOptionPane.YES_OPTION) {
				    profiles.removeIf(p -> p.getId() == profile.getId() && p.getName().equals(profile.getName()));
				    profileJsonManager.writeJsonToFile(profiles);
				    
				    // Revalidate GUI
					removeAllComponents();
					initializeInitialMode();
				}

			}
			
		});
	}
	
	private void initializeComponentVisuals() {
		this.setPreferredSize(new Dimension(500, 450));
		this.setBackground(theme.mainColor);
		this.setLayout(new GridBagLayout());
		
		messageLabel.setFont(theme.fontBoldReg);
		messageLabel.setForeground(Color.WHITE);
		
		createButtonPanel.setBackground(theme.mainColor);
		createButtonPanel.setLayout(new GridBagLayout());
		
		Theme.primaryVisualButton(createNewProfileButton);
		Theme.secondaryVisualButton(importProfileButton);
		
		selectProfilePanel.setLayout(new GridBagLayout());
		selectProfilePanel.setBackground(theme.subColor);
		selectProfilePanel.setBorder(Theme.SUB_BORDER);
		
		selectProfileLabel.setFont(theme.fontBoldReg);
		selectProfileLabel.setForeground(Color.WHITE);
		
		assignDefaultProfile.setForeground(Color.WHITE);
		assignDefaultProfile.setBackground(theme.subColor);
		
		profileOptionsButtonPanel.setLayout(new GridBagLayout());
		profileOptionsButtonPanel.setBackground(theme.subColor);
		Theme.successVisualButton(loadProfileButton);
		Theme.dangerVisualButton(deleteProfileButton);
	}
	
	private void addInitialComponentsToPanel() {
		GridBagConstraints gbch = new GridBagConstraints();
		gbch.gridheight = GridBagConstraints.REMAINDER;
		
		GridBagConstraints gbcv = new GridBagConstraints();
		gbcv.gridwidth = GridBagConstraints.REMAINDER;
		
		createButtonPanel.add(createNewProfileButton, gbcv);
		createButtonPanel.add(Box.createVerticalStrut(20), gbcv);
		createButtonPanel.add(importProfileButton, gbcv);
		
		this.add(messageLabel, gbcv);
		
		selectProfilePanel.add(selectProfileLabel, gbcv);
		selectProfilePanel.add(Box.createVerticalStrut(20), gbcv);
		selectProfilePanel.add(profilesBox, gbcv);
		selectProfilePanel.add(assignDefaultProfile, gbcv);
		selectProfilePanel.add(Box.createVerticalStrut(20), gbcv);
		
		profileOptionsButtonPanel.add(loadProfileButton, gbch);
		profileOptionsButtonPanel.add(Box.createHorizontalStrut(20), gbch);
		profileOptionsButtonPanel.add(deleteProfileButton, gbch);
		
		
		selectProfilePanel.add(profileOptionsButtonPanel, gbcv);
	
		if(foundProfiles) {
			this.add(Box.createVerticalStrut(20), gbcv);
			this.add(selectProfilePanel, gbcv);
		}
		
		this.add(Box.createVerticalStrut(40), gbcv);
		this.add(createButtonPanel, gbcv);
	}
	
	/*
	 * ##################################
	 * ##################################
	 * CREATION MENU
	 * ##################################
	 * ##################################
	 */
	
	private void initializeCreateMode() {
		initializeCreateComponents();
		initializeCreateComponentActions();
		addCreateModeComponentsToPanel();
	}
	
	private void initializeCreateComponents() {
		createProfileLabel = new JLabel(language.createProfileText);
		
		createProfilePanel = new JPanel();
		
		enterUsernamePanel = new JPanel();
		enterUsernameLabel = new JLabel(language.usernameText);
		enterUsernameTextField = new JTextField(10);
		
		enterTamoNamePanel = new JPanel();
		enterTamoNameLabel = new JLabel(language.tamoNameText);
		enterTamoNameTextField = new JTextField(10);
		
		languagePanel = new JPanel();
		languageLabel = new JLabel(language.languageText);
		languageBox = new JComboBox<>();
		languageBox.addItem(language.englishText);
		languageBox.addItem(language.spanishText);
//		languageBox.addItem(language.hindiText);
//		languageBox.addItem(language.portugueseText);
//		languageBox.addItem(language.japaneseText);
//		languageBox.addItem(language.germanText);
//		languageBox.addItem(language.frenchText);
//		languageBox.addItem(language.turkishText);
//		languageBox.addItem(language.mandarinChineseText);
//		languageBox.addItem(language.dutchText);
//		languageBox.addItem(language.koreanText);
//		languageBox.addItem(language.russianText);
//		languageBox.addItem(language.hungarianText);
//		languageBox.addItem(language.romanianText);
//		
		difficultyPanel = new JPanel();
		difficultyLabel = new JLabel(language.difficultyText);
		difficultyBox = new JComboBox<>();
		difficultyBox.addItem(language.peacefulText);
		difficultyBox.addItem(language.challengingText);
		difficultyBox.addItem(language.ironManText);
		
		focusModePanel = new JPanel();
		focusModeLabel = new JLabel(language.focusModeText);
		focusModeBox = new JComboBox<>();
		focusModeBox.addItem(language.pomodoroText);
		focusModeBox.addItem(language.customCountdownText);
		focusModeBox.addItem(language.fiveMinIntervalCountdownText);
		focusModeBox.addItem(language.stopwatchText);
		
		createProfileButtonPanel = new JPanel();
		confirmCreateProfileButton = new JButton(language.createText);
		cancelCreateProfileButton = new JButton(language.cancelText);
		
		initializeCreateComponentVisuals();
	}
	
	private void initializeCreateComponentActions() {
		confirmCreateProfileButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// Validate Form Fields
				boolean validForm = false;
				
				if(enterUsernameTextField.getText().trim().isEmpty()
						|| enterTamoNameTextField.getText().trim().isEmpty()) {
					setCreationMessage(language.mustEnterValidNameText);
				} else {
					validForm = true;
				}
				
				if(validForm) {
					// Add Profile to Profiles
					Profile profile = new Profile(enterUsernameTextField.getText(), 
							Language.getLanguageFromBox(languageBox.getSelectedIndex()), 
							difficultyBox.getSelectedIndex(), 
							focusModeBox.getSelectedIndex(), 
							enterTamoNameTextField.getText()
						);
					
					// Write / Update Profiles to profiles.json
					List<Profile> allProfiles = new ArrayList<>();
					for(Profile aProfile : profiles) {
						allProfiles.add(aProfile);
					}
					allProfiles.add(profile);
					profileJsonManager.writeJsonToFile(allProfiles);
					
					// Revalidate GUI
					removeAllComponents();
					initializeInitialMode();
				}
			}
			
		});
		
		cancelCreateProfileButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				removeAllComponents();
				
				initializeInitialMode();
			}
			
		});
	}
	
	private void initializeCreateComponentVisuals() {
		createProfileLabel.setIcon(new ImageIcon(getClass().getClassLoader().getResource("INFO_GOOD.png")));
		createProfileLabel.setFont(theme.fontBoldReg);
		createProfileLabel.setForeground(Color.WHITE);
		
		createProfilePanel.setLayout(new GridBagLayout());
		createProfilePanel.setBackground(theme.subColor);
		createProfilePanel.setBorder(Theme.SUB_BORDER);
		
		enterUsernamePanel.setLayout(new GridBagLayout());
		enterUsernamePanel.setBackground(theme.subColor);
		enterUsernameLabel.setFont(theme.fontBoldRegSmall);
		enterUsernameLabel.setForeground(Color.WHITE);
		
		enterTamoNamePanel.setLayout(new GridBagLayout());
		enterTamoNamePanel.setBackground(theme.subColor);
		enterTamoNameLabel.setFont(theme.fontBoldRegSmall);
		enterTamoNameLabel.setForeground(Color.WHITE);
		
		languagePanel.setLayout(new GridBagLayout());
		languagePanel.setBackground(theme.subColor);
		languageLabel.setFont(theme.fontBoldRegSmall);
		languageLabel.setForeground(Color.WHITE);
		
		difficultyPanel.setLayout(new GridBagLayout());
		difficultyPanel.setBackground(theme.subColor);
		difficultyLabel.setFont(theme.fontBoldRegSmall);
		difficultyLabel.setForeground(Color.WHITE);
		
		focusModePanel.setLayout(new GridBagLayout());
		focusModePanel.setBackground(theme.subColor);
		focusModeLabel.setFont(theme.fontBoldRegSmall);
		focusModeLabel.setForeground(Color.WHITE);
		
		createProfileButtonPanel.setLayout(new GridBagLayout());
		createProfileButtonPanel.setBackground(theme.mainColor);
		Theme.primaryVisualButton(confirmCreateProfileButton);
		Theme.secondaryVisualButton(cancelCreateProfileButton);
	}
	
	private void addCreateModeComponentsToPanel() {
		GridBagConstraints gbch = new GridBagConstraints();
		gbch.gridheight = GridBagConstraints.REMAINDER;
		
		GridBagConstraints gbcv = new GridBagConstraints();
		gbcv.gridwidth = GridBagConstraints.REMAINDER;
		
		GridBagConstraints innergbcv = new GridBagConstraints();
		innergbcv.gridwidth = GridBagConstraints.REMAINDER;
		innergbcv.anchor = GridBagConstraints.WEST;
		
		// Sub Panels
		enterUsernamePanel.add(enterUsernameLabel);
		enterUsernamePanel.add(enterUsernameTextField);
		
		enterTamoNamePanel.add(enterTamoNameLabel);
		enterTamoNamePanel.add(enterTamoNameTextField);
		
		languagePanel.add(languageLabel);
		languagePanel.add(languageBox);
		
		difficultyPanel.add(difficultyLabel);
		difficultyPanel.add(difficultyBox);
		
		focusModePanel.add(focusModeLabel);
		focusModePanel.add(focusModeBox);
		
		// Create Profile Panel 
		createProfilePanel.add(enterUsernamePanel, innergbcv);
		createProfilePanel.add(Box.createVerticalStrut(10), innergbcv);
		createProfilePanel.add(enterTamoNamePanel, innergbcv);
		createProfilePanel.add(Box.createVerticalStrut(10), innergbcv);
		createProfilePanel.add(languagePanel, innergbcv);
		createProfilePanel.add(Box.createVerticalStrut(10), innergbcv);
		createProfilePanel.add(difficultyPanel, innergbcv);
		createProfilePanel.add(Box.createVerticalStrut(10), innergbcv);
		createProfilePanel.add(focusModePanel, innergbcv);
		
		// Button Panel
		createProfileButtonPanel.add(confirmCreateProfileButton, gbch);
		createProfileButtonPanel.add(Box.createHorizontalStrut(20), gbch);
		createProfileButtonPanel.add(cancelCreateProfileButton, gbch);
		
		this.add(createProfileLabel, gbcv);
		this.add(Box.createVerticalStrut(20), gbcv);
		this.add(createProfilePanel, gbcv);
		this.add(Box.createVerticalStrut(20), gbcv);
		this.add(createProfileButtonPanel, gbcv);
		
	}
	
	/*
	 * ##################################
	 * ##################################
	 * HELPER METHODS
	 * ##################################
	 * ##################################
	 */
	private void removeAllComponents() {
		this.removeAll();
		this.repaint();
		this.revalidate();
	}
	
	private void close() {
		Debug.info("ProfileSelectionPanel.close", "Closing WelcomeGUI and ProfileSelectionPanel");
		welcomeGUI.dispose();
		welcomeGUI.removeAll();
	}
	
	private void setMessageLabelError(String message) {
		messageLabel.setIcon(new ImageIcon(getClass().getClassLoader().getResource("INFO.png")));
		messageLabel.setText(message);
		messageLabel.setForeground(Theme.DANGER);
	}
	
	private void setCreationMessage(String message) {
		createProfileLabel.setIcon(new ImageIcon(getClass().getClassLoader().getResource("INFO.png")));
		createProfileLabel.setText(message);
		createProfileLabel.setForeground(Theme.DANGER);
	}
}
