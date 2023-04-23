package state;

import javax.swing.JLabel;

import gui.TamoStudyGUI;

public class AboutState extends State {

	private static final long serialVersionUID = 353696047710911712L;

	public AboutState(TamoStudyGUI tamoStudyGUI) {
		super(tamoStudyGUI);
		this.add(new JLabel("Abotu State"));
		
	}

}
