package state;

import java.awt.Color;
import java.awt.Font;

import javax.swing.*;

import profile.Profile;
import resources.Theme;

/**
 * StateStrategy
 * @author Anthony Narlock
 * @brief Abstract Implementation of the StateStrategy JPanel
 */

public abstract class StateStrategy extends JPanel {
	
	/**
	 * Profile Components
	 */
	public Profile profile;
	public Theme theme; //For colors
	
	//Default Constructor
	public StateStrategy(Profile profile) {
		this.profile = profile;
		this.theme = profile.getThemeIndicator(); //For theme colors
		setPanel();
		setActions();
	}
	
	//TODO
	//Make a constructor to set member variables
	//that come from the profile file
	
	//Sets the panel information
	public abstract void setPanel();
	
	//Sets the actions of the panel
	public abstract void setActions();
	
	//Creates a space label
	protected JLabel createSpaceLabel(int indicator) {
		//Space Component
		JLabel transparentComponent = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("TRANSPARENT.png")));
		
		//If we want a large indicator, we will pass in a 1
		if(indicator == 1)
			transparentComponent = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("TRANSPARENT2.png")));
		
		transparentComponent.setAlignmentX(JComponent.CENTER_ALIGNMENT);
		
		return transparentComponent;
	}
	
	
	
}
