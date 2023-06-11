package state;

import javax.swing.JPanel;

import gui.TamoStudyGUI;

public abstract class State extends JPanel {
	
	public TamoStudyGUI tsGui;

	public State(TamoStudyGUI tamoStudyGUI) {
		this.tsGui = tamoStudyGUI;
		this.setBackground(tsGui.getTheme().subColor);
	}
	
	protected abstract void initializeAttributes();
	protected abstract void initializeComponents();
	protected abstract void initializeComponentVisuals();
	protected abstract void initializeComponentActions();
	protected abstract void initializePanel();
}
