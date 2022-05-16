package state;

import java.awt.Color;
import java.awt.Font;

import javax.swing.*;

import profile.Profile;

/**
 * StateStrategy
 * @author Anthony Narlock
 * @brief Abstract Implementation of the StateStrategy JPanel
 */

public abstract class StateStrategy extends JPanel {
	
	//TODO
	//Make a colors class that will be replace this access....
	//A StateStrategy will have a colors class... From here,
	//upon calling.. we'll be able to store the colors differently
	//so they can change..
	protected Color subColor = new Color(78,78,78); //DEFAULT
	protected Color layerColor = new Color(108, 108, 108);
	protected Color textColor = Color.WHITE;
	protected Font fontPlainReg = new Font("Tahoma", Font.PLAIN, 24);
	protected Font fontBoldReg = new Font("Tahoma", Font.BOLD, 24);
	
	/**
	 * Profile Components
	 */
	//TODO change these to be initialized when profile is loaded
	//To keep track of different options
	//protected means that the other child classes can use it
	//as if it is an attribute
	public Profile profile;
	
	//Default Constructor
	public StateStrategy(Profile profile) {
		this.profile = profile;
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
