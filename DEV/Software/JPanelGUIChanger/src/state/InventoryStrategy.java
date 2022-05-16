package state;

import javax.swing.JLabel;

import profile.Profile;

public class InventoryStrategy extends StateStrategy {

	public InventoryStrategy(Profile profile) {
		super(profile);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void setPanel() {
		this.setBackground(subColor);
		this.add(new JLabel("Inventory Empty"));
		
	}

	@Override
	public void setActions() {
		// TODO Auto-generated method stub
		
	}

}
