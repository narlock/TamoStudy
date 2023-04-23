package state;

import javax.swing.JPanel;

import gui.TamoStudyGUI;

public abstract class State extends JPanel {
	
	public TamoStudyGUI tsGui;

	public State(TamoStudyGUI tamoStudyGUI) {
		this.tsGui = tamoStudyGUI;
		this.setBackground(tsGui.getTheme().subColor);
	}
}
