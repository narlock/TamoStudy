package components.panel;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import gui.TamoStudyGUI;
import model.GuiSize;
import model.language.Language;
import model.profile.Profile;
import resources.Debug;
import resources.Items;
import resources.Theme;

public class ShopItemPanel extends JPanel {
	
	private static final long serialVersionUID = -1261674542186022885L;
	
	/*
	 * ##################################
	 * ##################################
	 * ATTRIBUTES
	 * ##################################
	 * ##################################
	 */
	private TamoStudyGUI tsGui;
	private GuiSize guiSize;
	private Theme theme;
	private Language language;
	
	private String type;
	private int indicator;
	private boolean owned; // If the profile owns the item, they cannot buy it, button is disabled.
	private int price;
	
	/*
	 * ##################################
	 * ##################################
	 * COMPONENTS
	 * ##################################
	 * ##################################
	 */
	private JLabel itemTitleLabel;
	private JLabel iconLabel;
	private JButton buyButton;
	
	public ShopItemPanel(TamoStudyGUI tsGui, GuiSize guiSize, Language language, String type, int indicator, boolean owned) {
		this.tsGui = tsGui;
		this.guiSize = guiSize;
		this.language = language;
		theme = Theme.DARK;
		
		this.type = type;
		this.indicator = indicator;
		this.owned = owned;
		
		initializeAttributes();
		initializeComponents();
		initializePanel();
	}
	
	public void initializeAttributes() {
		
	}
	
	public void initializeComponents() {
		String itemTitle = getItemTitleByTypeIndicator(type, indicator);
		
		itemTitleLabel = new JLabel(itemTitle);
		itemTitleLabel.setFont(guiSize.kathMessageFont);
		itemTitleLabel.setForeground(theme.textColor);
		
		iconLabel = new JLabel(getItemIconByTypeIndicator(type, indicator));
		
		price = getItemPriceByTypeIndicator(type, indicator);
		buyButton = new JButton("" + price);
		buyButton.setIcon(guiSize.tamoTokenImageIcon);
		disableBuyButtonIfOwned();
		
		buyButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int tokensAfterPurchase = (int) tsGui.getProfile().getTokens() - price;
				
				// If the profile can afford the purchase
				if(!(tokensAfterPurchase < 0)) {
					
					// Confirm that the user wants to purchase this item?
					int result = JOptionPane.showConfirmDialog(
							getRootPane(), 
							"Confirm Purchase of " + itemTitle + " (" + type + ")",
							"Confirm Shop Purchase",
							JOptionPane.YES_NO_OPTION,
							JOptionPane.QUESTION_MESSAGE,
							new ImageIcon(getClass().getClassLoader().getResource("INFO.png")));
					
					if(result == JOptionPane.YES_OPTION) {
						// If yes, firstly subtract the profile's tokens
						tsGui.getProfile().setTokens(tokensAfterPurchase);
						
						// Secondly, add the item to the profile's inventory
						addItemToInventory(type, indicator, tsGui.getProfile());
						tsGui.getProfileJsonManager().writeJsonToFile(tsGui.getProfiles());
						
						// Finally, update the GUI. Tamo tokens, and disable buyButton.
						tsGui.updateTamoTokensLabel();
						if(!type.equals("FOOD")) {
							buyButton.setEnabled(false);
						}
						
					}
					
				}
			}
		});
	}
	
	public void disableBuyButtonIfOwned() {
		if(type.equals("FOOD")) {
			// Do nothing, can purchase multiple food
		} else if(type.equals("BACKGROUND")) {
			for(long l : tsGui.getProfile().getBackgroundInventoryList()) {
				if((int) l == indicator) {
					buyButton.setEnabled(false);
				}
			}
		} else if(type.equals("BORDER")) {
			for(long l : tsGui.getProfile().getBorderInventoryList()) {
				if((int) l == indicator) {
					buyButton.setEnabled(false);
				}
			}
		}
	}
	
	public void initializePanel() {
		GridBagConstraints gbcv = new GridBagConstraints();
		gbcv.gridwidth = GridBagConstraints.REMAINDER;
		
		this.setLayout(new GridBagLayout());
		this.setBackground(theme.mainColor);
		this.setBorder(guiSize.settingsPanelBorder);
		
		this.add(itemTitleLabel, gbcv);
		this.add(iconLabel, gbcv);
		this.add(buyButton, gbcv);
	}
	
	/*
	 * ##################################
	 * ##################################
	 * HELPER METHODS
	 * ##################################
	 * ##################################
	 */
	public String getItemTitleByTypeIndicator(String type, int indicator) {
		if(type.equals("FOOD")) {
			return Items.getFoodTitleByIndicator(indicator, language);
		} else if(type.equals("BACKGROUND")) {
			return Items.getBackgroundTitleByIndicator(indicator, language);
		} else if(type.equals("BORDER")) {
			return Items.getBorderTitleByIndicator(indicator, language);
		}
		throw new RuntimeException("Unknown type  provided to getItemTitleByTypeIndicator");
	}
	
	public ImageIcon getItemIconByTypeIndicator(String type, int indicator) {
		if(type.equals("FOOD")) {
			return Items.getFoodIconByIndicator(indicator, guiSize);
		} else if(type.equals("BACKGROUND")) {
			return Items.getBackgroundIconByIndicator(indicator, guiSize);
		} else if(type.equals("BORDER")) {
			return Items.getBorderIconByIndicator(indicator, guiSize);
		}
		throw new RuntimeException("Unknown type  provided to getItemIconByTypeIndicator");
	}
	
	public int getItemPriceByTypeIndicator(String type, int indicator) {
		if(type.equals("FOOD")) {
			return Items.getFoodPriceByIndicator(indicator);
		} else if(type.equals("BACKGROUND")) {
			return Items.getBackgroundPriceByIndicator(indicator);
		} else if(type.equals("BORDER")) {
			return Items.getBorderPriceByIndicator(indicator);
		}
		throw new RuntimeException("Unknown type  provided to getItemPriceByTypeIndicator");
	}
	
	public void addItemToInventory(String type, int indicator, Profile profile) {
		Debug.info("ShopItemPanel.addItemToInventory", "type=" + type + ", type.equals(\"FOOD\")=" + type.equals("FOOD") + "type.equals(\"BACKGROUND\")=" + type.equals("BACKGROUND") + "type.equals(\"BORDER\")=" + type.equals("BORDER"));
		
		if(type.equals("FOOD")) {
			List<Long> foodInventoryList = new ArrayList<Long>(profile.getFoodInventoryList());
			foodInventoryList.add((long) indicator);
			profile.setFoodInventoryList(foodInventoryList);
		} else if(type.equals("BACKGROUND")) {
			List<Long> backgroundInventoryList = new ArrayList<Long>(profile.getBackgroundInventoryList());
			backgroundInventoryList.add((long) indicator);
			profile.setBackgroundInventoryList(backgroundInventoryList);
		} else if(type.equals("BORDER")) {
			List<Long> borderInventoryList = new ArrayList<Long>(profile.getBorderInventoryList());
			borderInventoryList.add((long) indicator);
			profile.setBorderInventoryList(borderInventoryList);
		} else {
			throw new RuntimeException("Unknown type  provided to addItemToInventory: " + type);
		}
	}
}
