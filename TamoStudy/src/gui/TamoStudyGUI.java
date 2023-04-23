package gui;

import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import io.ProfileJsonManager;
import model.GuiSize;
import model.profile.Profile;
import resources.Constants;
import resources.Debug;
import resources.DiscordRP;
import resources.Theme;
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
	private State state;
	
	public TamoStudyGUI(List<Profile> profiles, int profileIndex) {
		this.profiles = profiles;
		this.profile = profiles.get(profileIndex);
		Debug.info("TamoStudyGUI", "Initialized with profile=" + profile.toString());
		
		initializeAttributes();
		initializeComponents();
		initializeComponentActions();
		initializeFrame();
	}
	
	private void initializeAttributes() {
		profileJsonManager = new ProfileJsonManager();
		theme = Theme.DARK;
		guiSize = new GuiSize((int) profile.getSettings().getGuiSize());
	}
	
	private void initializeComponents() {
		
	}
	
	private void initializeComponentActions() {
		
	}
	
	private void initializeFrame() {
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
