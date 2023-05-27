package gui;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import io.DailyFocusJsonManager;
import io.MonthFocusJsonManager;
import io.ProfileJsonManager;
import model.GuiSize;
import model.language.Language;
import model.profile.Profile;
import model.time.DailyFocus;
import model.time.DailyFocusEntry;
import model.time.MonthFocus;
import model.time.MonthFocusEntry;
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
import util.Utils;

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
	
	private DailyFocusJsonManager dailyFocusJsonManager;
	private List<DailyFocus> dailyFocusList;
	private DailyFocus dailyFocus;
	private MonthFocusJsonManager monthFocusJsonManager;
	private List<MonthFocus> monthFocusList;
	private MonthFocus monthFocus;
	
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

		initializeAttributes();
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
		
		initializeAttributes();
		state = new SettingsState(getThis());
		
		initializeComponents();
		initializeComponentVisuals();
		initializeComponentActions();
		initializeFrame();
		
		sidePanel.setVisible(false);
	}
	
	private void initializeAttributes() {
		profileJsonManager = new ProfileJsonManager();
		theme = Theme.DARK;
		guiSize = new GuiSize((int) profile.getSettings().getGuiSize());
		
		dailyFocusJsonManager = new DailyFocusJsonManager();
		dailyFocusList = dailyFocusJsonManager.readJson();
		
		dailyFocus = Utils.searchDailyFocusByProfile(dailyFocusList, profile);
		// Create dailyFocus if it does not exist
		if(dailyFocus == null) {
			dailyFocus = addNewDailyFocusToDailyFocusList(Utils.createDailyFocus(profile));
		}
		
		monthFocusJsonManager = new MonthFocusJsonManager();
		monthFocusList = monthFocusJsonManager.readJson();
		
		monthFocus = Utils.searchMonthFocusByProfile(monthFocusList, profile);
		if(monthFocus == null) {
			monthFocus = addNewMonthFocusToMonthFocusList(Utils.createMonthFocus(profile));
		}
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
		
		/*
		 * Opens/Closes the Top Menu.
		 */
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
		
		/*
		 * Changes to the Dash board State.
		 */
		dashboardStateButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(!(state instanceof DashboardState)) {
					changeState(new DashboardState(getThis()));
					sidePanel.setVisible(false);
				}
			}
			
		});
		
		/*
		 * Changes to the focus state.
		 */
		focusStateButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(!(state instanceof FocusState)) {
					changeState(new FocusState(getThis()));
					sidePanel.setVisible(false);
				}
			}
			
		});
		
		/*
		 * Changes to the shop state.
		 */
		shopStateButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(!(state instanceof ShopState)) {
					changeState(new ShopState(getThis()));
					sidePanel.setVisible(false);
				}
			}
			
		});
		
		/*
		 * Changes to the inventory state.
		 */
		inventoryStateButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(!(state instanceof InventoryState)) {
					changeState(new InventoryState(getThis()));
					sidePanel.setVisible(false);
				}
			}
			
		});
		
		/*
		 * Changes to the statistics state.
		 */
		statisticsStateButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(!(state instanceof StatisticsState)) {
					changeState(new StatisticsState(getThis()));
					sidePanel.setVisible(false);
				}
			}
			
		});
		
		/*
		 * Changes to the achievements state.
		 */
		achievementsStateButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(!(state instanceof AchievementsState)) {
					changeState(new AchievementsState(getThis()));
					sidePanel.setVisible(false);
				}
			}
			
		});
		
		/*
		 * Changes to the settings state.
		 */
		settingsStateButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(!(state instanceof SettingsState)) {
					changeState(new SettingsState(getThis()));
					sidePanel.setVisible(false);
				}
			}
			
		});
		
		/*
		 * Changes to the about state.
		 */
		aboutStateButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(!(state instanceof AboutState)) {
					changeState(new AboutState(getThis()));
					sidePanel.setVisible(false);
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
	
	/**
	 * changeState
	 * @brief Changes the current State to a new State.
	 * and repaints the frame to coordinate the update.
	 * @param newState
	 */
	public void changeState(State newState) {
		this.remove(state);
		state = newState;
		this.add(state, BorderLayout.CENTER);
		this.repaint();
		this.revalidate();
	}
	
	/**
	 * resetGui
	 * @brief Resets the GUI, disposes, and
	 * creates a new object.
	 */
	public void resetGui() {
		this.setVisible(false);
		this.dispose();
		
		new TamoStudyGUI(profiles, profileIndex);
	}
	
	/**
	 * resizeGui
	 * @brief Helper method for resizing the GUI.
	 * Disposes of the old GUI, then calls the
	 * Settings Constructor to create the new GUI.
	 */
	public void resizeGui() {
		this.setVisible(false);
		this.dispose();
		
		new TamoStudyGUI(profiles, profileIndex, 0);
	}
	
	/**
	 * addMenuButtonVisual
	 * @brief Sets Menu button visuals.
	 * @param button
	 */
	public void addMenuButtonVisual(JButton button) {
		button.setContentAreaFilled(false);
		button.setOpaque(false);
		button.setFont(guiSize.topMenuFont);
		button.setForeground(theme.textColor);
		button.setBorderPainted(false);
		button.setFocusPainted(false);
		theme.buttonLayerEnterEffect(button);
	}
	
	public JLabel createSpaceLabel() {
		String DIVIDER = (System.getProperty("os.name").startsWith("Linux") || System.getProperty("os.name").startsWith("Windows"))
				? "────────────" : "━━━━━━━";
		
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

	public List<DailyFocus> getDailyFocusList() {
		return dailyFocusList;
	}
	
	public void setDailyFocusList(List<DailyFocus> dailyFocusList) {
		this.dailyFocusList = dailyFocusList;
	}
	
	public DailyFocus getDailyFocus() {
		return dailyFocus;
	}

	public List<MonthFocus> getMonthFocusList() {
		return monthFocusList;
	}
	
	public void setMonthFocusList(List<MonthFocus> monthFocusList) {
		this.monthFocusList = monthFocusList;
	}

	public MonthFocus getMonthFocus() {
		return monthFocus;
	}

	public DailyFocusJsonManager getDailyFocusJsonManager() {
		return dailyFocusJsonManager;
	}

	public MonthFocusJsonManager getMonthFocusJsonManager() {
		return monthFocusJsonManager;
	}
	
	/*
	 * ##################################
	 * ##################################
	 * HELPER METHODS
	 * ##################################
	 * ##################################
	 */
	public DailyFocus addNewDailyFocusToDailyFocusList(DailyFocus dailyFocus) {
		List<DailyFocus> dailyFocusList = new ArrayList<>(this.dailyFocusList);
		try {
			dailyFocusList.add(dailyFocus);
			this.setDailyFocusList(dailyFocusList);
			this.dailyFocusJsonManager.writeJsonToFile(this.dailyFocusList);
			return dailyFocus;
		} catch (Exception e) {
			Debug.error("TamoStudyGUI.addNewDailyFocusToDailyFocusList", "bruh idk what happened");
			e.printStackTrace();
			throw e;
		}
	}
	
	public MonthFocus addNewMonthFocusToMonthFocusList(MonthFocus monthFocus) {
		List<MonthFocus> monthFocusList = new ArrayList<>(this.monthFocusList);
		try {
			monthFocusList.add(monthFocus);
			this.setMonthFocusList(monthFocusList);
			this.monthFocusJsonManager.writeJsonToFile(this.monthFocusList);
			return monthFocus;
		} catch (Exception e) {
			Debug.error("TamoStudyGUI.addNewMonthFocusToMonthFocusList", "bruh idk what happened");
			e.printStackTrace();
			throw e;
		}
	}
	
	public boolean addNewDailyFocusEntryToDailyFocus(DailyFocusEntry dailyFocusEntry) {
		List<DailyFocusEntry> dailyFocusEntriesList = new ArrayList<>(dailyFocus.getDailyFocusEntries());
		try {
			dailyFocusEntriesList.add(dailyFocusEntry);
			dailyFocus.setDailyFocusEntries(dailyFocusEntriesList);
			Debug.info("Length of dailyFocus", "length of daily focus = " + dailyFocus);
			return true;
		} catch (Exception e) {
			Debug.error("TamoStudyGUI.addNewDailyFocusEntryToDailyFocus", "bruh idk what happened");
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean addNewMonthFocusEntryToMonthFocus(MonthFocusEntry monthFocusEntry) {
		List<MonthFocusEntry> monthFocusEntriesList = new ArrayList<>(monthFocus.getMonthFocusEntries());
		try {
			monthFocusEntriesList.add(monthFocusEntry);
			monthFocus.setMonthFocusEntries(monthFocusEntriesList);
			return true;
		} catch (Exception e) {
			Debug.error("TamoStudyGUI.addNewMonthFocusEntryToDailyFocus", "bruh idk what happened");
			e.printStackTrace();
			return false;
		}
	}
	
	public void toggleMenuButtons(boolean enabled) {
		dashboardStateButton.setEnabled(enabled);
		focusStateButton.setEnabled(enabled);
		shopStateButton.setEnabled(enabled);
		inventoryStateButton.setEnabled(enabled);
		statisticsStateButton.setEnabled(enabled);
		achievementsStateButton.setEnabled(enabled);
		settingsStateButton.setEnabled(enabled);
		aboutStateButton.setEnabled(enabled);
	}
	
	public void updateTamoTokensLabel() {
		topNameTokensLabel.setText(profile.getName() + " • " + profile.getTokens());
	}
	
}

