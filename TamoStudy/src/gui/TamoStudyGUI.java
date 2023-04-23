package gui;

import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import io.ProfileJsonManager;
import model.profile.Profile;
import resources.Constants;
import resources.Debug;
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
	private Theme theme;
	
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
	}
	
	private void initializeComponents() {
		
	}
	
	private void initializeComponentActions() {
		
	}
	
	private void initializeFrame() {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE); // TODO Add Window Listener
		this.getContentPane().setBackground(theme.mainColor);
		this.setTitle("TamoStudy Release " + Constants.version);
		setSizeBasedOnGuiSize();
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
	private void setSizeBasedOnGuiSize() {
		int guiSize = (int) profile.getSettings().getGuiSize();
		switch(guiSize) {
		case 0:
			this.setSize(100, 100);
			break;
		case 1:
			this.setSize(200, 200);
			break;
		case 2:
			this.setSize(300, 300);
			break;
		default:
			this.setSize(200, 200);
			break;
		}
	}
}
