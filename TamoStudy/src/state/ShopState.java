package state;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

import components.panel.KathPanel;
import components.panel.ShopPanel;
import gui.TamoStudyGUI;

public class ShopState extends State {

	private static final long serialVersionUID = 1930763097782384868L;
	
	/*
	 * ##################################
	 * ##################################
	 * ATTRIBUTES
	 * ##################################
	 * ##################################
	 */
	private int shopIndicator; // Which shop we are currently in
	
	/*
	 * ##################################
	 * ##################################
	 * COMPONENTS
	 * ##################################
	 * ##################################
	 */
	private KathPanel kathPanel;
	private ShopPanel shopPanel;
	private JComboBox<String> shopOptions;

	public ShopState(TamoStudyGUI tamoStudyGUI) {
		super(tamoStudyGUI);
		initializeAttributes();
		initializeComponents();
		initializeComponentVisuals();
		initializeComponentActions();
		initializePanel();
	}

	@Override
	protected void initializeAttributes() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void initializeComponents() {
		shopIndicator = 0;
		kathPanel = new KathPanel(tsGui.getGuiSize(), tsGui.getProfile().getSettings().getLanguage());
		shopPanel = new ShopPanel(tsGui, tsGui.getGuiSize(), tsGui.getProfile().getSettings().getLanguage());
		shopOptions = new JComboBox<>();
		shopOptions.addItem("Select Shop");
		shopOptions.addItem("Food");
		shopOptions.addItem("Backgrounds");
		shopOptions.addItem("Borders");
//		shopOptions.addItem("Timer Customization");
	}

	@Override
	protected void initializeComponentVisuals() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void initializeComponentActions() {
		shopOptions.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				kathPanel.shopIndicator = shopOptions.getSelectedIndex();
				
				// Validate Kath Panel
				kathPanel.initializeAttributes();
				kathPanel.repaint();
				
				// Validate Shop Panel
				shopPanel.setShop(shopOptions.getSelectedIndex());
				repaint();
			}
			
		});
	}

	@Override
	protected void initializePanel() {
		GridBagConstraints gbcv = new GridBagConstraints();
		gbcv.gridwidth = GridBagConstraints.REMAINDER;
		
		this.setLayout(new GridBagLayout());
		this.add(kathPanel, gbcv);
		this.add(shopPanel, gbcv);
		this.add(shopOptions, gbcv);
	}

}
