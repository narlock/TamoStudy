package resources;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;

import language.LanguageStrategy;

/**
 * @author Anthony Narlock (narlock)
 * CommunicateFocusAction
 */

public class CommunicateFocusAction {
	
	/**
	 * Actions for shared JComponents
	 * throughout the MainGUI and the Strategy
	 */
	
	private JComponent[] components;
	private LanguageStrategy lang;
	
	//Study Components
	private JButton studyFocusButton;
	
	public CommunicateFocusAction(JComponent[] components, LanguageStrategy lang) {
		this.components = components;
		this.lang = lang;
		
	}
	
	public void setStartButtonAction() {
		studyFocusButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Hello from Action.java");
				
			}
			
		});
	}
	
	/**
	 * This is a member function of the Action class
	 * that will be called after the timer is finished in MainGUI.
	 */
	public void signalEndOfTimer() {
		
	}
	
}
