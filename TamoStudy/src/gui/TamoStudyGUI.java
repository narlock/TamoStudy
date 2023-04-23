package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import io.ProfileJsonManager;
import model.GuiSize;
import model.language.Language;
import model.profile.Profile;
import resources.Constants;
import resources.Debug;
import resources.DiscordRP;
import resources.Theme;
import state.DashboardState;
import state.State;

public class TamoStudyGUI extends JFrame {

	private static final long serialVersionUID = -1279489061097200797L;

	/*
	 * ##################################
	 * ##################################
	 * ATTRIBUTES
	 * ##################################
	 * ##################################
	 */
	private List<Profile> profiles;
	private ProfileJsonManager profileJsonManager;
	private Profile profile;
	private Language lang;
	private DiscordRP discordRP;
	private Theme theme;
	private GuiSize guiSize;
	
	/*
	 * ##################################
	 * ##################################
	 * GUI COMPONENTS
	 * ##################################
	 * ##################################
	 */
	private JPanel topPanel;
		private JButton topMenuButton;
		private JLabel topNameTokensLabel;
	
	private JPanel sidePanel;
		private JButton dashboardStateButton;
		private JButton focusStateButton;
		private JButton shopStateButton;
		private JButton inventoryStateButton;
		private JButton statisticsStateButton;
		private JButton achievementsStateButton;
		private JButton settingsStateButton;
		private JButton aboutStateButton;
		
	private State state;
	
	public TamoStudyGUI(List<Profile> profiles, int profileIndex) {
		this.profiles = profiles;
		this.profile = profiles.get(profileIndex);
		this.lang = profile.getSettings().getLanguage();
		Debug.info("TamoStudyGUI", "Initialized with profile=" + profile.toString());
		
		initializeAttributes();
		initializeComponents();
		initializeComponentVisuals();
		initializeComponentActions();
		initializeFrame();
	}
	
	private void initializeAttributes() {
		profileJsonManager = new ProfileJsonManager();
		theme = Theme.DARK;
		guiSize = new GuiSize((int) profile.getSettings().getGuiSize());
	}
	
	private void initializeComponents() {
		topPanel = new JPanel();
		topMenuButton = new JButton(lang.menuButtonText);
		topNameTokensLabel = new JLabel(profile.getName() + " • " + profile.getTokens()); // TODO Level Progess on the top, along with hours studied today

		sidePanel = new JPanel();
		dashboardStateButton = new JButton(lang.dashboardStateButtonText);
		focusStateButton = new JButton(lang.focusStateButtonText);
		shopStateButton = new JButton(lang.shopStateButtonText);
		inventoryStateButton = new JButton(lang.inventoryStateButtonText);
		achievementsStateButton = new JButton(lang.achievementsStateButtonText);
		settingsStateButton = new JButton(lang.settingsStateButtonText);
		aboutStateButton = new JButton(lang.aboutStateButton);
		
		state = new DashboardState();
	}
	
	private void initializeComponentVisuals() {
		// Component Visual Attributes
		topPanel.setLayout(new BorderLayout());
		topPanel.setBackground(theme.mainColor);
		addMenuButtonVisual(topMenuButton);
		topMenuButton.setIcon(guiSize.getTopMenuImageIcon());
			
		topNameTokensLabel.setFont(guiSize.getTopMenuFont());
		topNameTokensLabel.setForeground(theme.textColor);
		topNameTokensLabel.setIcon(guiSize.getTamoTokenImageIcon());
		topNameTokensLabel.setHorizontalTextPosition(SwingConstants.LEADING);
		
		sidePanel.setLayout(new GridBagLayout());
		sidePanel.setBackground(theme.mainColor);
		addMenuButtonVisual(dashboardStateButton);
		addMenuButtonVisual(focusStateButton);
		addMenuButtonVisual(shopStateButton);
		addMenuButtonVisual(inventoryStateButton);
		addMenuButtonVisual(achievementsStateButton);
		addMenuButtonVisual(settingsStateButton);
		addMenuButtonVisual(aboutStateButton);
		
		state.setBackground(theme.subColor);
		
		// Component Visual Placement
		topPanel.add(topMenuButton, BorderLayout.WEST);
		topPanel.add(topNameTokensLabel, BorderLayout.EAST);
		
		GridBagConstraints gbcv = new GridBagConstraints();
		gbcv.gridwidth = GridBagConstraints.REMAINDER;
		
		sidePanel.add(dashboardStateButton, gbcv);
		sidePanel.add(focusStateButton, gbcv);
		sidePanel.add(createSpaceLabel(), gbcv);
		sidePanel.add(shopStateButton, gbcv);
		sidePanel.add(inventoryStateButton, gbcv);
		sidePanel.add(achievementsStateButton, gbcv);
		sidePanel.add(createSpaceLabel(), gbcv);
		sidePanel.add(settingsStateButton, gbcv);
		sidePanel.add(aboutStateButton, gbcv);
	}
	
	private void initializeComponentActions() {
		topMenuButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(sidePanel.isVisible()) {
					sidePanel.setVisible(false);
				} else {
					sidePanel.setVisible(true);
				}
			}
			
		});
	}
	
	private void initializeFrame() {
		this.add(topPanel, BorderLayout.NORTH);
		this.add(sidePanel, BorderLayout.WEST);
		this.add(state, BorderLayout.CENTER);
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE); // TODO Add Window Listener
		this.getContentPane().setBackground(theme.mainColor);
		this.setTitle("TamoStudy Release " + Constants.version);
		this.setSize(guiSize.getFrameSize());
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setIconImage(new ImageIcon(getClass().getClassLoader().getResource("ICON.png")).getImage());
		this.setVisible(true);
	}
	
	/*
	 * ##################################
	 * ##################################
	 * HELPER METHODS
	 * ##################################
	 * ##################################
	 */
	public void addMenuButtonVisual(JButton button) {
		button.setFont(guiSize.getTopMenuFont());
		button.setForeground(theme.textColor);
		button.setBorderPainted(false);
		button.setFocusPainted(false);
		theme.buttonLayerEnterEffect(button);
	}
	
	public JLabel createSpaceLabel() {
		String DIVIDER = (System.getProperty("os.name").startsWith("Linux") || System.getProperty("os.name").startsWith("Windows"))
				? "━━━━━━━━━━━━━━━━━━ " : "━━━━━━━";
		
		JLabel label = new JLabel(DIVIDER);
		label.setFont(guiSize.getTopMenuFont());
		label.setForeground(theme.altTextColor);
		return label;
	}
}
