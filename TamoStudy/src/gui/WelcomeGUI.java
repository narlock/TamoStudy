package gui;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
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

import components.panel.ProfileSelectionPanel;
import io.GlobalSettingsJsonManager;
import model.GlobalSettings;
import resources.CheckForUpdates;
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
	
	/*
	 * ##################################
	 * ##################################
	 * GUI COMPONENTS
	 * ##################################
	 * ##################################
	 */
	private JPanel mainPanel;
	private JButton messageButton;
	private JLabel tamoStudyLogoImageLabel;
	private JPanel buttonPanel;
	private JButton localStudyButton, onlineStudyButton;
	private JLabel authorLabel;
	
	public WelcomeGUI() {
		initializeAttributes();
		initializeComponents();
		initializeComponentActions();
		initializeFrame();
		checkForTamoStudyUpdates();
	}
	
	private void initializeAttributes() {
		globalSettingsJsonManager = new GlobalSettingsJsonManager();
		globalSettings = globalSettingsJsonManager.readJson();
		theme = Theme.DARK;
	}
	
	private void initializeComponents() {
		// Initialize components, visuals
		mainPanel = new JPanel();
		
		messageButton = new JButton("\t");
		tamoStudyLogoImageLabel = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("TITLE_SMALL.gif")));
		
		authorLabel = new JLabel("Release v1.0.0 • Created by narlock • tamostudy.com");
		
		buttonPanel = new JPanel();
		localStudyButton = new JButton("Local Study");
		onlineStudyButton = new JButton("Online Study");

		initializeComponentVisual();
		
		// Placement of components on frame and panels
		GridBagConstraints gbch = new GridBagConstraints();
		gbch.gridheight = GridBagConstraints.REMAINDER;
		
		buttonPanel.add(localStudyButton, gbch);
		buttonPanel.add(Box.createHorizontalStrut(20), gbch);
		buttonPanel.add(onlineStudyButton, gbch);
		
		GridBagConstraints gbcv = new GridBagConstraints();
		gbcv.gridwidth = GridBagConstraints.REMAINDER;
		
		mainPanel.add(messageButton, gbcv);
		mainPanel.add(tamoStudyLogoImageLabel, gbcv);
		mainPanel.add(Box.createVerticalStrut(20), gbcv);
		mainPanel.add(buttonPanel, gbcv);
		mainPanel.add(Box.createVerticalStrut(20), gbcv);
		mainPanel.add(authorLabel, gbcv);
		
		this.add(mainPanel);
	}
	
	private void initializeComponentActions() {
		localStudyButton.addActionListener(new ActionListener() {

			@SuppressWarnings("static-access")
			@Override
			public void actionPerformed(ActionEvent e) {
				UIManager UI = new UIManager();
				UI.put("OptionPane.background", new ColorUIResource(theme.mainColor));
				UI.put("Panel.background", new ColorUIResource(theme.mainColor));
				 
				Object[] options = {};
				JOptionPane.showOptionDialog(getRootPane(),
						new ProfileSelectionPanel(getThis()),
						"Local Study",
						JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, null);
			}
			
		});
	}
	
	private void initializeFrame() {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.getContentPane().setBackground(theme.mainColor);
		this.setTitle("TamoStudy Release v1.0.0");
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
				String message = "TamoStudy " + updateCheck + " is now available. Click here to download!";
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
			messageButton.setText("Unable to search for updates. Not connected to the Internet.");
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
		buttonPanel.setLayout(new GridBagLayout());
		initializePanelVisual(buttonPanel);
		
		// messageButton
		Theme.labelButton(messageButton);
		
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
	
}
