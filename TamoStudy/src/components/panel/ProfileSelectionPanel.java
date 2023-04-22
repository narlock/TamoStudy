package components.panel;

import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

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
	private ProfileJsonManager profileJsonManager = new ProfileJsonManager();
	private List<Profile> profiles;
	private Theme theme;
	
	/*
	 * ##################################
	 * ##################################
	 * GUI COMPONENTS
	 * ##################################
	 * ##################################
	 */
	private JLabel messageLabel;
	private JButton createNewProfileButton;
	private JButton importProfileButton;
}
