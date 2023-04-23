package state;

import javax.swing.JLabel;

import gui.TamoStudyGUI;

public class StatisticsState extends State {

	private static final long serialVersionUID = 1058419726546781724L;

	public StatisticsState(TamoStudyGUI tamoStudyGUI) {
		super(tamoStudyGUI);
		this.add(new JLabel("Statistics State"));
	}

}
