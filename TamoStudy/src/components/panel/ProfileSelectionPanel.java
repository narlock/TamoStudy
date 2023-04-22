package components.panel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import io.ProfileJsonManager;
import model.profile.Profile;
import resources.Theme;

public class ProfileSelectionPanel extends JPanel {

	private static final long serialVersionUID = -3861540929503194485L;
	
	/*
	 * ##################################
	 * ##################################
	 * ATTRIBUTES
	 * ##################################
	 * ##################################
	 */
	private ProfileJsonManager profileJsonManager;
	private List<Profile> profiles;
	private Theme theme;
	
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
	private JButton loadProfileButton;
	
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
	
	public ProfileSelectionPanel() {
		initializeAttributes();
		initializeComponents();
		initializeComponentActions();
		addInitialComponentsToPanel();
	}
	
	private void initializeAttributes() {
		profileJsonManager = new ProfileJsonManager();
		profiles = profileJsonManager.readJson();
		theme = Theme.DARK;
	}
	
	/*
	 * ##################################
	 * ##################################
	 * SELECTION MENU
	 * ##################################
	 * ##################################
	 */
	
	private void initializeComponents() {
		foundProfiles = profiles != null && !profiles.isEmpty();
		
		messageLabel = new JLabel();
		if(!foundProfiles) {
			messageLabel.setIcon(new ImageIcon(getClass().getClassLoader().getResource("INFO.png")));
			messageLabel.setText("No local profiles were found.");
		} else {
			messageLabel.setIcon(new ImageIcon(getClass().getClassLoader().getResource("INFO_GOOD.png")));
			messageLabel.setText("Welcome back to TamoStudy!");
		}
		
		createButtonPanel = new JPanel();
		createNewProfileButton = new JButton("Create New Profile");
		importProfileButton = new JButton("Import Profile from Beta 4.2");
		
		selectProfilePanel = new JPanel();
		selectProfileLabel = new JLabel("      Choose Profile      ");
		profilesBox = new JComboBox<>();
		if(foundProfiles) {
			for(Profile profile : profiles) {
				profilesBox.addItem(profile.getName());
			}
		}
		assignDefaultProfile = new JCheckBox("Load Profile Automatically");
		loadProfileButton = new JButton("Load Profile");
		
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
		Theme.successVisualButton(loadProfileButton);
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
		selectProfilePanel.add(loadProfileButton, gbcv);
	
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
		createProfileLabel = new JLabel("Create TamoStudy Profile");
		
		createProfilePanel = new JPanel();
		
		enterUsernamePanel = new JPanel();
		enterUsernameLabel = new JLabel("Username");
		enterUsernameTextField = new JTextField(10);
		
		enterTamoNamePanel = new JPanel();
		enterTamoNameLabel = new JLabel("Tamo Name");
		enterTamoNameTextField = new JTextField(10);
		
		languagePanel = new JPanel();
		languageLabel = new JLabel("Language");
		languageBox = new JComboBox<>();
		languageBox.addItem("English");
		languageBox.addItem("Spanish");
		
		difficultyPanel = new JPanel();
		difficultyLabel = new JLabel("Difficulty");
		difficultyBox = new JComboBox<>();
		difficultyBox.addItem("Peaceful");
		difficultyBox.addItem("Challenging");
		difficultyBox.addItem("Iron man");
		
		focusModePanel = new JPanel();
		focusModeLabel = new JLabel("Focus Mode");
		focusModeBox = new JComboBox<>();
		focusModeBox.addItem("Pomodoro");
		focusModeBox.addItem("Custom Countdown");
		focusModeBox.addItem("5-Min Interval Countdown");
		focusModeBox.addItem("Stopwatch");
		
		createProfileButtonPanel = new JPanel();
		confirmCreateProfileButton = new JButton("Create");
		cancelCreateProfileButton = new JButton("Cancel");
		
		initializeCreateComponentVisuals();
	}
	
	private void initializeCreateComponentActions() {
		
	}
	
	private void initializeCreateComponentVisuals() {
		
	}
	
	private void addCreateModeComponentsToPanel() {
		GridBagConstraints gbch = new GridBagConstraints();
		gbch.gridheight = GridBagConstraints.REMAINDER;
		
		GridBagConstraints gbcv = new GridBagConstraints();
		gbcv.gridwidth = GridBagConstraints.REMAINDER;
		
		this.add(createProfileLabel, gbcv);
		
		createProfilePanel.setLayout(new GridBagLayout());
		createProfilePanel.add(enterUsernameLabel);
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
}
