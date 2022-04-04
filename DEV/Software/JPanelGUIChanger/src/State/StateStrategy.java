package State;

import javax.swing.*;

/**
 * StateStrategy
 * @author Anthony Narlock
 * @brief Abstract Implementation of the StateStrategy JPanel
 */

public abstract class StateStrategy extends JPanel {
	public StateStrategy() {
		setPanel();
		setActions();
	}
	
	//Sets the panel information
	public abstract void setPanel();
	
	//Sets the actions of the panel
	public abstract void setActions();
	
}
