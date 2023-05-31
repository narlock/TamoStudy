package state;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import components.panel.InventoryItemPanel;
import gui.TamoStudyGUI;
import model.GuiSize;
import model.profile.Profile;
import resources.Debug;
import resources.Items;
import resources.Theme;

public class InventoryState extends State {

	private static final long serialVersionUID = -8665762242093633226L;
	
	/*
	 * ##################################
	 * ##################################
	 * ATTRIBUTES
	 * ##################################
	 * ##################################
	 */
	private GuiSize guiSize;
	private Profile profile;
	private Theme theme;
	
	/*
	 * ##################################
	 * ##################################
	 * COMPONENTS
	 * ##################################
	 * ##################################
	 */
	private JPanel inventorySelectionPanel;
	private JLabel inventoryTitleLabel;
	public JComboBox<String> inventoryBox;
	
	private JPanel inventoryPanel;
	private JPanel inventoryMenuPanel;
	public InventoryItemPanel inventoryItemPanel;

	public InventoryState(TamoStudyGUI tamoStudyGUI) {
		super(tamoStudyGUI);
		initializeAttributes();
		initializeComponents();
		initializeComponentVisuals();
		initializeComponentActions();
		initializePanel();
	}

	@Override
	protected void initializeAttributes() {
		profile = tsGui.getProfile();
		guiSize = new GuiSize((int) tsGui.getProfile().getSettings().getGuiSize());
		theme = Theme.DARK;
		
	}

	@Override
	protected void initializeComponents() {
		inventorySelectionPanel = new JPanel();
		inventorySelectionPanel.setBackground(theme.subColor);
		inventoryTitleLabel = new JLabel("Inventory");
		inventoryTitleLabel.setFont(guiSize.settingLabelFont);
		inventoryTitleLabel.setForeground(theme.textColor);
		inventoryBox = new JComboBox<>();
		inventoryBox.addItem("Food");
		inventoryBox.addItem("Backgrounds");
		inventoryBox.addItem("Borders");
		
		inventoryBox.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				changeInventory();
			}
		});
		
		inventorySelectionPanel.add(inventoryTitleLabel);
		inventorySelectionPanel.add(inventoryBox);
	}

	@Override
	protected void initializeComponentVisuals() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void initializeComponentActions() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void initializePanel() {
		GridBagConstraints gbcv = new GridBagConstraints();
		gbcv.gridwidth = GridBagConstraints.REMAINDER;
		
		this.setLayout(new GridBagLayout());
		this.add(inventorySelectionPanel, gbcv);
		initializeItemsToInventoryMenuPanel(gbcv);
	}
	
	public void initializeItemsToInventoryMenuPanel(GridBagConstraints gbcv) {
		inventoryPanel = new JPanel(new GridLayout(1, 2));
		inventoryPanel.setBorder(guiSize.settingsPanelBorder);
		inventoryMenuPanel = new JPanel(new GridLayout(7, 5));
		
		for(long foodIndicator : profile.getFoodInventoryList()) {
			inventoryMenuPanel.add(createFoodMenuItemButton((int) foodIndicator));
		}
		
		int noItemCount = 35 - profile.getFoodInventoryList().size();
		if(noItemCount > 0) {
			for(int i = 0; i < noItemCount; i++) {
				inventoryMenuPanel.add(createEmptyMenuItem());
			}
		}

		inventoryPanel.add(inventoryMenuPanel);
		this.add(inventoryPanel, gbcv);
	}
	
	public void changeInventory() {
		GridBagConstraints gbcv = new GridBagConstraints();
		gbcv.gridwidth = GridBagConstraints.REMAINDER;
		
		GridBagConstraints gbch = new GridBagConstraints();
		gbch.gridheight = GridBagConstraints.REMAINDER;
		
		this.remove(inventoryPanel);
		this.repaint();
		
		inventoryPanel = new JPanel(new GridBagLayout());
		inventoryPanel.setBorder(guiSize.settingsPanelBorder);
		inventoryMenuPanel = new JPanel(new GridLayout(7, 5));
		
		if(inventoryBox.getSelectedIndex() == 0) {
			for(long foodIndicator : profile.getFoodInventoryList()) {
				inventoryMenuPanel.add(createFoodMenuItemButton((int) foodIndicator));
			}
			
			int noItemCount = 35 - profile.getFoodInventoryList().size();
			if(noItemCount > 0) {
				for(int i = 0; i < noItemCount; i++) {
					inventoryMenuPanel.add(createEmptyMenuItem());
				}
			}
			
		} else if(inventoryBox.getSelectedIndex() == 1) {
			for(long backgroundIndicator : profile.getBackgroundInventoryList()) {
				inventoryMenuPanel.add(createBackgroundMenuItemButton((int) backgroundIndicator));
			}
			
			int noItemCount = 35 - profile.getBackgroundInventoryList().size();
			if(noItemCount > 0) {
				for(int i = 0; i < noItemCount; i++) {
					inventoryMenuPanel.add(createEmptyMenuItem());
				}
			}
		} else if(inventoryBox.getSelectedIndex() == 2) {
			for(long borderIndicator : profile.getBorderInventoryList()) {
				inventoryMenuPanel.add(createBorderMenuItemButton((int) borderIndicator));
			}
			
			int noItemCount = 35 - profile.getBorderInventoryList().size();
			if(noItemCount > 0) {
				for(int i = 0; i < noItemCount; i++) {
					inventoryMenuPanel.add(createEmptyMenuItem());
				}
			}
		}
		inventoryPanel.add(inventoryMenuPanel, gbch);
		this.add(inventoryPanel, gbcv);
		this.revalidate();
	}
	
	public JButton createFoodMenuItemButton(int indicator) {
		JButton foodMenuItemButton = new JButton(Items.getFoodInvIconByIndicator(indicator, guiSize));
		foodMenuItemButton.setPreferredSize(guiSize.itemMenuDimension);
		foodMenuItemButton.setContentAreaFilled(false);
		foodMenuItemButton.setOpaque(false);
		foodMenuItemButton.setBorderPainted(false);
		foodMenuItemButton.setFocusPainted(false);
		foodMenuItemButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				selectFoodItem(indicator);
			}
		});
		return foodMenuItemButton;
	}
	
	public JButton createBackgroundMenuItemButton(int indicator) {
		JButton backgroundMenuItemButton = new JButton(Items.getBackgroundInvIconByIndicator(indicator, guiSize));
		backgroundMenuItemButton.setPreferredSize(guiSize.itemMenuDimension);
		backgroundMenuItemButton.setContentAreaFilled(false);
		backgroundMenuItemButton.setOpaque(false);
		backgroundMenuItemButton.setBorderPainted(false);
		backgroundMenuItemButton.setFocusPainted(false);
		backgroundMenuItemButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				selectBackgroundItem(indicator);
			}
		});
		return backgroundMenuItemButton;
	}
	
	public JButton createBorderMenuItemButton(int indicator) {
		JButton borderMenuItemButton = new JButton(Items.getBorderInvIconByIndicator(indicator, guiSize));
		borderMenuItemButton.setPreferredSize(guiSize.itemMenuDimension);
		borderMenuItemButton.setContentAreaFilled(false);
		borderMenuItemButton.setOpaque(false);
		borderMenuItemButton.setBorderPainted(false);
		borderMenuItemButton.setFocusPainted(false);
		borderMenuItemButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				selectBorderItem(indicator);
			}
		});
		return borderMenuItemButton;
	}

	public JButton createEmptyMenuItem() {
		JButton itemButton = new JButton();
		itemButton.setPreferredSize(new Dimension(32, 32));
		itemButton.setContentAreaFilled(false);
		itemButton.setOpaque(false);
		itemButton.setBorderPainted(false);
		itemButton.setFocusPainted(false);
		return itemButton;
	}
	
	public void selectFoodItem(int indicator) {
		GridBagConstraints gbch = new GridBagConstraints();
		gbch.gridheight = GridBagConstraints.REMAINDER;
		
		if(inventoryPanel.getComponentCount() == 1) {
			// Need to add inventory item panel
			inventoryItemPanel = new InventoryItemPanel(tsGui, this, "FOOD", indicator);
			inventoryPanel.add(inventoryItemPanel, gbch);
			this.revalidate();
		} else {
			// Remove inventory item panel, re-add
			inventoryPanel.remove(inventoryItemPanel);
			inventoryItemPanel = new InventoryItemPanel(tsGui, this, "FOOD", indicator);
			inventoryPanel.add(inventoryItemPanel, gbch);
			this.revalidate();
		}
	}
	
	public void selectBackgroundItem(int indicator) {
		GridBagConstraints gbch = new GridBagConstraints();
		gbch.gridheight = GridBagConstraints.REMAINDER;
		
		if(inventoryPanel.getComponentCount() == 1) {
			// Need to add inventory item panel
			inventoryItemPanel = new InventoryItemPanel(tsGui, this, "BACKGROUND", indicator);
			inventoryPanel.add(inventoryItemPanel, gbch);
			this.revalidate();
		} else {
			// Remove inventory item panel, re-add
			inventoryPanel.remove(inventoryItemPanel);
			inventoryItemPanel = new InventoryItemPanel(tsGui, this, "BACKGROUND", indicator);
			inventoryPanel.add(inventoryItemPanel, gbch);
			this.revalidate();
		}
	}
	
	public void selectBorderItem(int indicator) {
		GridBagConstraints gbch = new GridBagConstraints();
		gbch.gridheight = GridBagConstraints.REMAINDER;
		
		if(inventoryPanel.getComponentCount() == 1) {
			// Need to add inventory item panel
			inventoryItemPanel = new InventoryItemPanel(tsGui, this, "BORDER", indicator);
			inventoryPanel.add(inventoryItemPanel, gbch);
			this.revalidate();
		} else {
			// Remove inventory item panel, re-add
			inventoryPanel.remove(inventoryItemPanel);
			inventoryItemPanel = new InventoryItemPanel(tsGui, this, "BORDER", indicator);
			inventoryPanel.add(inventoryItemPanel, gbch);
			this.revalidate();
		}
	}
}
