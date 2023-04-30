package gui;

import java.awt.BorderLayout;
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
import state.AboutState;
import state.AchievementsState;
import state.DashboardState;
import state.FocusState;
import state.InventoryState;
import state.SettingsState;
import state.ShopState;
import state.State;
import state.StatisticsState;

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
	private int profileIndex;
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
	
	/**
	 * Load TamoStudyGUI Constructor
	 * @param profiles
	 * @param profileIndex
	 */
	public TamoStudyGUI(List<Profile> profiles, int profileIndex) {
		this.profiles = profiles;
		this.profileIndex = profileIndex;
		this.profile = profiles.get(profileIndex);
		this.lang = profile.getSettings().getLanguage();
		Debug.info("TamoStudyGUI", "Initialized with profile=" + profile.toString());
		
		// Initialize Attributes
		profileJsonManager = new ProfileJsonManager();
		theme = Theme.DARK;
		guiSize = new GuiSize((int) profile.getSettings().getGuiSize());
		state = new DashboardState(getThis());
		
		initializeComponents();
		initializeComponentVisuals();
		initializeComponentActions();
		initializeFrame();
	}
	
	/**
	 * Reset GUI TamoStudyGUI Constructor
	 * @param profiles
	 * @param profileIndex
	 * @param state
	 */
	public TamoStudyGUI(List<Profile> profiles, int profileIndex, int settingsOn) {
		this.profiles = profiles;
		this.profileIndex = profileIndex;
		this.profile = profiles.get(profileIndex);
		this.lang = profile.getSettings().getLanguage();
		Debug.info("TamoStudyGUI", "Initialized with profile=" + profile.toString());
		
		// Initialize Attributes
		profileJsonManager = new ProfileJsonManager();
		theme = Theme.DARK;
		guiSize = new GuiSize((int) profile.getSettings().getGuiSize());
		this.state = new SettingsState(getThis());
		
		initializeComponents();
		initializeComponentVisuals();
		initializeComponentActions();
		initializeFrame();
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
		statisticsStateButton = new JButton(lang.statisticsStateButtonText);
		achievementsStateButton = new JButton(lang.achievementsStateButtonText);
		settingsStateButton = new JButton(lang.settingsStateButtonText);
		aboutStateButton = new JButton(lang.aboutStateButton);
		
	}
	
	private void initializeComponentVisuals() {
		// Component Visual Attributes
		topPanel.setLayout(new BorderLayout());
		topPanel.setBackground(theme.mainColor);
		addMenuButtonVisual(topMenuButton);
		topMenuButton.setIcon(guiSize.topMenuImageIcon);
			
		topNameTokensLabel.setFont(guiSize.topMenuFont);
		topNameTokensLabel.setForeground(theme.textColor);
		topNameTokensLabel.setIcon(guiSize.tamoTokenImageIcon);
		topNameTokensLabel.setHorizontalTextPosition(SwingConstants.LEADING);
		
		sidePanel.setLayout(new GridBagLayout());
		sidePanel.setBackground(theme.mainColor);
		addMenuButtonVisual(dashboardStateButton);
		addMenuButtonVisual(focusStateButton);
		addMenuButtonVisual(shopStateButton);
		addMenuButtonVisual(inventoryStateButton);
		addMenuButtonVisual(statisticsStateButton);
		addMenuButtonVisual(achievementsStateButton);
		addMenuButtonVisual(settingsStateButton);
		addMenuButtonVisual(aboutStateButton);
		
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
		sidePanel.add(statisticsStateButton, gbcv);
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
		
		dashboardStateButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(!(state instanceof DashboardState)) {
					changeState(new DashboardState(getThis()));
				}
			}
			
		});
		
		focusStateButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(!(state instanceof FocusState)) {
					changeState(new FocusState(getThis()));
				}
			}
			
		});
		
		shopStateButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(!(state instanceof ShopState)) {
					changeState(new ShopState(getThis()));
				}
			}
			
		});
		
		inventoryStateButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(!(state instanceof InventoryState)) {
					changeState(new InventoryState(getThis()));
				}
			}
			
		});
		
		statisticsStateButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(!(state instanceof StatisticsState)) {
					changeState(new StatisticsState(getThis()));
				}
			}
			
		});
		
		achievementsStateButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(!(state instanceof AchievementsState)) {
					changeState(new AchievementsState(getThis()));
				}
			}
			
		});
		
		settingsStateButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(!(state instanceof SettingsState)) {
					changeState(new SettingsState(getThis()));
				}
			}
			
		});
		
		aboutStateButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(!(state instanceof AboutState)) {
					changeState(new AboutState(getThis()));
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
		this.setSize(guiSize.frameSize);
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
	public void changeState(State newState) {
		this.remove(state);
		state = newState;
		this.add(state, BorderLayout.CENTER);
		this.repaint();
		this.revalidate();
	}
	
	public void resetGui() {
		this.setVisible(false);
		this.dispose();
		
		new TamoStudyGUI(profiles, profileIndex);
	}
	
	public void resizeGui() {
		this.setVisible(false);
		this.dispose();
		
		new TamoStudyGUI(profiles, profileIndex, 0);
	}
	
	public void addMenuButtonVisual(JButton button) {
		button.setFont(guiSize.topMenuFont);
		button.setForeground(theme.textColor);
		button.setBorderPainted(false);
		button.setFocusPainted(false);
		theme.buttonLayerEnterEffect(button);
	}
	
	public JLabel createSpaceLabel() {
		String DIVIDER = (System.getProperty("os.name").startsWith("Linux") || System.getProperty("os.name").startsWith("Windows"))
				? "━━━━━━━━━━━━━━━━━━ " : "━━━━━━━";
		
		JLabel label = new JLabel(DIVIDER);
		label.setFont(guiSize.topMenuFont);
		label.setForeground(theme.altTextColor);
		return label;
	}
	
	public void disableSidePanelButtons() {
		dashboardStateButton.setEnabled(false);
		focusStateButton.setEnabled(false);
		shopStateButton.setEnabled(false);
		inventoryStateButton.setEnabled(false);
		statisticsStateButton.setEnabled(false);
		achievementsStateButton.setEnabled(false);
		settingsStateButton.setEnabled(false);
		aboutStateButton.setEnabled(false);
	}
	
	public void enableSidePanelButtons() {
		dashboardStateButton.setEnabled(true);
		focusStateButton.setEnabled(true);
		shopStateButton.setEnabled(true);
		inventoryStateButton.setEnabled(true);
		statisticsStateButton.setEnabled(true);
		achievementsStateButton.setEnabled(true);
		settingsStateButton.setEnabled(true);
		aboutStateButton.setEnabled(true);
	}
	
	/*
	 * ##################################
	 * ##################################
	 * ACCESSOR METHODS
	 * ##################################
	 * ##################################
	 */
	public TamoStudyGUI getThis() {
		return this;
	}
	
	public Theme getTheme() {
		return this.theme;
	}
	
	public List<Profile> getProfiles() {
		return this.profiles;
	}
	
	public ProfileJsonManager getProfileJsonManager() {
		return this.profileJsonManager;
	}
	
	public Profile getProfile() {
		return this.profile;
	}
	
	public DiscordRP getDiscordRP() {
		return this.discordRP;
	}
	
	public GuiSize getGuiSize() {
		return this.guiSize;
	}
	public void setGuiSize(GuiSize guiSize) {
		this.guiSize = guiSize;
	}
}
