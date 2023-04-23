package state;

import javax.swing.JLabel;

import gui.TamoStudyGUI;

public class ShopState extends State {

	private static final long serialVersionUID = 1930763097782384868L;

	public ShopState(TamoStudyGUI tamoStudyGUI) {
		super(tamoStudyGUI);
		this.add(new JLabel("ShopState"));
	}

}
