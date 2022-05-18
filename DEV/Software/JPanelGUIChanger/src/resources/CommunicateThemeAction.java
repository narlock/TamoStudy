package resources;

import java.awt.Font;
import java.util.Stack;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CommunicateThemeAction {
	
	private Theme theme;
	
	//MainGUI stuff
	private JButton openSideLabel;
	private Stack<JPanel> panels;
	private Stack<JButton> buttons;
	private Stack<JLabel> labels;
	private Stack<JLabel> breaks;
	
	//ThemeStrategy stuff
	private Stack<JLabel> tlabels;
	private Stack<JPanel> tpanels;
	
	//Constructor for MainGUI
	public CommunicateThemeAction(Theme theme, JButton openSideLabel,
				Stack<JPanel> panels, Stack<JButton> buttons, 
				Stack<JLabel> labels, Stack<JLabel> breaks) {
		
		this.openSideLabel = openSideLabel;
		this.theme = theme;
		this.panels = panels;
		this.buttons = buttons;
		this.labels = labels;
		this.breaks = breaks;
	}
	
	public CommunicateThemeAction(Theme theme, Stack<JLabel> tlabels, Stack<JPanel> tpanels) {
		this.theme = theme;
		this.tlabels = tlabels;
		this.tpanels = tpanels;
	}
	
	/**
	 * updateMainGUI
	 * @brief updates the main GUI
	 */
	public void updateMainGUI() {
		System.out.println("[TAMOSTUDY] Updating Theme...");
		setUpButtonComponent(openSideLabel, 1);
		for(JPanel panel : panels) { panel.setBackground(theme.mainColor); }
		for(JButton button : buttons) { setUpButtonComponent(button); }
		for(JLabel label : labels) { setUpLabelComponent(label); }
		for(JLabel thematicBreak : breaks) { setUpLabelComponent(thematicBreak, 1); }
	}
	
	/**
	 * Behavior Update Methods
	 */
	public void setUpLabelComponent(JLabel label) {
		label.setForeground(theme.layerTextColor);
		label.setFont(new Font("Arial", Font.BOLD, 16));
	}
	
	public void setUpLabelComponent(JLabel label, int num) {
		label.setForeground(theme.layerTextColor);
	}
	
	public void setUpButtonComponent(JButton button) {
		button.setBorderPainted(false);
		button.setBackground(theme.mainColor);
		button.setForeground(theme.layerTextColor);
		button.setFocusPainted(false);
		button.setFont(new Font("Arial", Font.BOLD, 16));
	}
	
	public void setUpButtonComponent(JButton button, int num) {
		button.setBackground(theme.mainColor);
		button.setForeground(theme.layerTextColor);
		button.setFocusPainted(false);
		button.setFont(new Font("Arial", Font.BOLD, 16));
	}
	
	/**
	 * updateThemeStrategy
	 * @brief updates the theme strategy
	 */
	public void updateThemeStrategy() {
		for(JPanel panel : tpanels) { panel.setBackground(theme.subColor); }
		for(JLabel label : tlabels) { setUpThemeLabelComponent(label); }
	}
	
	public void setUpThemeLabelComponent(JLabel label) {
		label.setForeground(theme.textColor);
		label.setFont(theme.fontBoldReg);
		label.setAlignmentX(JComponent.CENTER_ALIGNMENT);
	}
}
