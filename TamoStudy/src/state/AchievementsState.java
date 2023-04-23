package state;

import javax.swing.JLabel;

import gui.TamoStudyGUI;

public class AchievementsState extends State {

	private static final long serialVersionUID = -7353342192190711969L;

	public AchievementsState(TamoStudyGUI tamoStudyGUI) {
		super(tamoStudyGUI);
		this.add(new JLabel("Achievements State"));
	}

}
