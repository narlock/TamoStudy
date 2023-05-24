package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;

import components.panel.ChangeGlobalSettingsPanel;
import components.panel.ProfileSelectionPanel;
import io.GlobalSettingsJsonManager;
import model.GlobalSettings;
import model.language.Language;
import resources.CheckForUpdates;
import resources.Constants;
import resources.Debug;
import resources.Theme;

public class WelcomeGUI extends JFrame {
	
	private static final long serialVersionUID = -8500200649157878440L;
	
	/*
	 * ##################################
	 * ##################################
	 * ATTRIBUTES
	 * ##################################
	 * ##################################
	 */
	private GlobalSettingsJsonManager globalSettingsJsonManager;
	private GlobalSettings globalSettings;
	private Theme theme;
	private Language language;
	
	/*
	 * ##################################
	 * ##################################
	 * GUI COMPONENTS
	 * ##################################
	 * ##################################
	 */
	private JPanel mainPanel;
	
	private JPanel messageSettingsPanel;
	private JButton websiteButton;
	private JButton messageButton;
	private JButton settingsButton;
	
	private JLabel tamoStudyLogoImageLabel;
	private JPanel buttonPanel;
	private JButton localStudyButton, onlineStudyButton;
	private JLabel authorLabel;
	
	public WelcomeGUI() {
		initializeAttributes();
		initializeComponents();
		initializeComponentActions();
		initializeFrame();
		
		if(globalSettings.getReceiveUpdateNotifications())
			checkForTamoStudyUpdates();
	}
	
	private void initializeAttributes() {
		globalSettingsJsonManager = new GlobalSettingsJsonManager();
		globalSettings = globalSettingsJsonManager.readJson();
		Debug.info("WelcomeGUI.initializeAttributes", "Loaded Global Settings: " + globalSettings.toString());
		theme = Theme.DARK;
		language = globalSettings.getLanguage();
	}
	
	private void initializeComponents() {
		// Initialize components, visuals
		mainPanel = new JPanel();
		
		messageSettingsPanel = new JPanel();
		websiteButton = new JButton(new ImageIcon(getClass().getClassLoader().getResource("TITLE_ICON.png")));
		messageButton = new JButton("\t");
		settingsButton = new JButton(new ImageIcon(getClass().getClassLoader().getResource("SETTINGS.png")));
		
		tamoStudyLogoImageLabel = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("TAMOSTUDY_LOGO_IMAGE_LARGE.gif")));
		
		authorLabel = new JLabel("Release " + Constants.version + " • " + language.createdByText + " narlock • tamostudy.com");
		
		buttonPanel = new JPanel();
		localStudyButton = new JButton(language.localStudyText);
		onlineStudyButton = new JButton(language.onlineStudyText);

		initializeComponentVisual();
		
		// Placement of components on frame and panels
		GridBagConstraints gbch = new GridBagConstraints();
		gbch.gridheight = GridBagConstraints.REMAINDER;
		
		GridBagConstraints gbcv = new GridBagConstraints();
		gbcv.gridwidth = GridBagConstraints.REMAINDER;
		
		messageSettingsPanel.add(websiteButton, BorderLayout.WEST);
		messageSettingsPanel.add(messageButton, BorderLayout.CENTER);
		messageSettingsPanel.add(settingsButton, BorderLayout.EAST);
		
		buttonPanel.add(localStudyButton, gbch);
		buttonPanel.add(Box.createHorizontalStrut(20), gbch);
		buttonPanel.add(onlineStudyButton, gbch);
		
		this.add(messageSettingsPanel, BorderLayout.NORTH);
		mainPanel.add(tamoStudyLogoImageLabel, gbcv);
		mainPanel.add(Box.createVerticalStrut(20), gbcv);
		mainPanel.add(buttonPanel, gbcv);
		mainPanel.add(Box.createVerticalStrut(20), gbcv);
		mainPanel.add(authorLabel, gbcv);
		
		this.add(mainPanel);
	}
	
	private void initializeComponentActions() {
		websiteButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try { Desktop.getDesktop().browse(new URL("https://tamostudy.com/").toURI()); } 
				catch (Exception e1) { e1.printStackTrace(); }
			}
			
		});
		
		settingsButton.addActionListener(new ActionListener() {

			@SuppressWarnings("static-access")
			@Override
			public void actionPerformed(ActionEvent e) {
				UIManager UI = new UIManager();
				UI.put("OptionPane.background", new ColorUIResource(theme.mainColor));
				UI.put("Panel.background", new ColorUIResource(theme.mainColor));
				UI.put("OptionPane.messageForeground", new ColorUIResource(Color.WHITE));
				 
				Object[] options = {};
				JOptionPane.showOptionDialog(getRootPane(),
						new ChangeGlobalSettingsPanel(getThis()),
						language.globalSettingsText,
						JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, null);
			}
			
		});
		
		localStudyButton.addActionListener(new ActionListener() {

			@SuppressWarnings("static-access")
			@Override
			public void actionPerformed(ActionEvent e) {
				UIManager UI = new UIManager();
				UI.put("OptionPane.background", new ColorUIResource(theme.mainColor));
				UI.put("Panel.background", new ColorUIResource(theme.mainColor));
				UI.put("OptionPane.messageForeground", new ColorUIResource(Color.WHITE));
				 
				Object[] options = {};
				JOptionPane.showOptionDialog(getRootPane(),
						new ProfileSelectionPanel(getThis()),
						language.localStudyText,
						JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, null);
			}
			
		});
	}
	
	private void initializeFrame() {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.getContentPane().setBackground(theme.mainColor);
		this.setTitle("TamoStudy Release " + Constants.version);
		this.setSize(650,500);
		this.setLocationRelativeTo(null);
		this.setResizable(true);
		this.setIconImage(new ImageIcon(getClass().getClassLoader().getResource("ICON.png")).getImage());
		this.setVisible(true);
	}
	
	private void checkForTamoStudyUpdates() {
		CheckForUpdates checkForUpdates = new CheckForUpdates();
		try {
			String updateCheck = checkForUpdates.checkForUpdates();
			if(!(updateCheck == null)) {
				messageButton.setForeground(Theme.SUCCESS);
				String message = "TamoStudy " + updateCheck + " " + language.updateAvailableDownloadText;
				messageButton.setText(message.replaceAll("\"", ""));
				
				messageButton.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						try { Desktop.getDesktop().browse(new URL("https://github.com/narlock/TamoStudy/releases/").toURI()); } 
						catch (Exception e1) { e1.printStackTrace(); }
					}
					
				});
			}
		} catch (Exception e) {
			Debug.error("WelcomeGUI.checkForTamoStudyUpdates", "Error occurred when calling checkForUpdates.checkForUpdates");
			e.printStackTrace();
			
			messageButton.setForeground(Theme.DANGER);
			messageButton.setText(language.unableSearchUpdatesText);
		}
	}
	
	/*
	 * ##################################
	 * ##################################
	 * GUI COMPONENT VISUAL METHODS
	 * ##################################
	 * ##################################
	 */
	private void initializeComponentVisual() {
		// Panels
		mainPanel.setLayout(new GridBagLayout());
		initializePanelVisual(mainPanel);
		messageSettingsPanel.setLayout(new BorderLayout());
		initializePanelVisual(messageSettingsPanel);
		buttonPanel.setLayout(new GridBagLayout());
		initializePanelVisual(buttonPanel);
		
		// messageButton
		addMenuButtonVisual(websiteButton);
		Theme.labelButton(messageButton);
		addMenuButtonVisual(settingsButton);
		
		// authorLabel
		authorLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		authorLabel.setForeground(new Color(153,153,153));
		
		// Buttons
		Theme.primaryVisualButton(localStudyButton);
		Theme.primaryDisabledVisualButton(onlineStudyButton);
	}
	
	private void initializePanelVisual(JPanel panel) {
		panel.setBackground(theme.mainColor);
	}
	
	/*
	 * ##################################
	 * ##################################
	 * HELPER METHODS
	 * ##################################
	 * ##################################
	 */
	
	private WelcomeGUI getThis() {
		return this;
	}
	
	public void addMenuButtonVisual(JButton button) {
		button.setContentAreaFilled(false);
		button.setOpaque(false);
		button.setForeground(theme.textColor);
		button.setBorderPainted(false);
		button.setFocusPainted(false);
		theme.buttonLayerEnterEffect(button);
	}
	
	/**
	 * resetToMainMenu
	 * @brief Revalidates main panel on updates
	 */
	public void resetToMainMenu() {
		// TODO
	}
	
	/*
	 * ##################################
	 * ##################################
	 * ACCESSOR METHODS
	 * ##################################
	 * ##################################
	 */
	
	public GlobalSettingsJsonManager getGlobalSettingsJsonManager() {
		return globalSettingsJsonManager;
	}
	
	public GlobalSettings getGlobalSettings() {
		return globalSettings;
	}
}
