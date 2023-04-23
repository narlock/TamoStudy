package state;

import javax.swing.JLabel;

import gui.TamoStudyGUI;

public class DashboardState extends State {
	
	private static final long serialVersionUID = -774794028854162351L;

	public DashboardState(TamoStudyGUI tamoStudyGUI) {
		super(tamoStudyGUI);
		this.add(new JLabel("DashboardState"));
	}
	
}
