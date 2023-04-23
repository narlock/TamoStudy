package state;

import javax.swing.JLabel;

import gui.TamoStudyGUI;

public class FocusState extends State {

	private static final long serialVersionUID = -3878552282431644324L;

	public FocusState(TamoStudyGUI tamoStudyGUI) {
		super(tamoStudyGUI);
		this.add(new JLabel("Focus State"));
	}
}
