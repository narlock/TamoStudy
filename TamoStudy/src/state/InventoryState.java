package state;

import javax.swing.JLabel;

import gui.TamoStudyGUI;

public class InventoryState extends State {

	private static final long serialVersionUID = -8665762242093633226L;

	public InventoryState(TamoStudyGUI tamoStudyGUI) {
		super(tamoStudyGUI);
		this.add(new JLabel("Inventory State"));
	}

}
