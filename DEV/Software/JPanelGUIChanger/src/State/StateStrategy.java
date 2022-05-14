package State;

import java.awt.Color;

import javax.swing.*;

/**
 * StateStrategy
 * @author Anthony Narlock
 * @brief Abstract Implementation of the StateStrategy JPanel
 */

public abstract class StateStrategy extends JPanel {
	/**
	 * Profile Components
	 */
	//TODO change these to be initialized when profile is loaded
	//To keep track of different options
	//protected means that the other child classes can use it
	//as if it is an attribute
	protected Color subColor = new Color(78,78,78); //DEFAULT
	protected Color textColor = new Color(153,153,153);
	
	
	public StateStrategy() {
		setPanel();
		setActions();
	}
	
	//Sets the panel information
	public abstract void setPanel();
	
	//Sets the actions of the panel
	public abstract void setActions();
	
}
