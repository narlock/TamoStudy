package gui;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import io.ProfileJsonManager;
import model.GuiSize;
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
		private JLabel topNameLabel;
		private JLabel topTamoTokensLabel;
	
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
		topMenuButton = new JButton("Menu");
		
		sidePanel = new JPanel();
		dashboardStateButton = new JButton("Dashboard");
		
		state = new DashboardState();
	}
	
	private void initializeComponentVisuals() {
		// Component Visual Attributes
		topPanel.setBackground(theme.mainColor);
		topMenuButton.setFont(guiSize.getTopMenuFont());
		topMenuButton.setIcon(guiSize.getTopMenuImageIcon());
		
		sidePanel.setBackground(theme.mainColor);
		dashboardStateButton.setFont(guiSize.getSideButtonFont());
		
		state.setBackground(theme.subColor);
		
		// Component Visual Placement
		topPanel.add(topMenuButton);
		
		sidePanel.add(dashboardStateButton);
	}
	
	private void initializeComponentActions() {
		
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
}
