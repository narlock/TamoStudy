package State;

import javax.swing.JLabel;

public class InventoryStrategy extends StateStrategy {

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
