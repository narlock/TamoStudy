package components.panel;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import gui.TamoStudyGUI;
import model.GuiSize;
import model.language.Language;
import model.profile.Profile;
import resources.Achievements;
import resources.Debug;
import resources.Items;
import resources.Theme;
import state.InventoryState;

public class InventoryItemPanel extends JPanel {

	private static final long serialVersionUID = -6379471515355369571L;

	/*
	 * ##################################
	 * ##################################
	 * ATTRIBUTES
	 * ##################################
	 * ##################################
	 */
	private TamoStudyGUI tsGui;
	private InventoryState inventoryState;
	private Profile profile;
	private GuiSize guiSize;
	private Theme theme;
	private Language language;
	private String type;
	private int indicator;
	
	/*
	 * ##################################
	 * ##################################
	 * COMPONENTS
	 * ##################################
	 * ##################################
	 */
	private JLabel itemTitleLabel;
	private JLabel itemIconLabel;
	
	private JPanel itemDescriptionPanel;
	private JLabel itemDescriptionLabel;
	
	private JButton itemActionButton;
	
	public InventoryItemPanel(TamoStudyGUI tsGui, InventoryState inventoryState, String type, int indicator) {
		this.tsGui = tsGui;
		this.inventoryState = inventoryState;
		this.profile = tsGui.getProfile();
		this.guiSize = tsGui.getGuiSize();
		this.language = tsGui.getProfile().getSettings().getLanguage();
		this.theme = profile.getSettings().getTheme();
		
		this.type = type;
		this.indicator = indicator;
		
		initializeComponents();
		initializePanel();
	}
	
	public void initializeComponents() {
		if(type.equals("FOOD")) {
			initializeFoodItemPanel();
		} else if(type.equals("BACKGROUND")) {
			initializeBackgroundItemPanel();
		} else if(type.equals("BORDER")) {
			initializeBorderItemPanel();
		}
	}
	
	public void initializeFoodItemPanel() {
		itemTitleLabel = new JLabel(Items.getFoodTitleByIndicator(indicator, language));
		itemTitleLabel.setFont(guiSize.settingsChoiceBoldFont);
		itemTitleLabel.setForeground(theme.textColor);
		itemIconLabel = new JLabel(Items.getFoodIconByIndicator(indicator, guiSize));
		itemDescriptionPanel = new JPanel();
		itemDescriptionPanel.setBackground(theme.subColor);
		itemDescriptionPanel.setBorder(guiSize.settingsPanelBorder);
		itemDescriptionLabel = new JLabel(Items.getFoodDescriptionByIndicator(indicator, language));
		itemDescriptionLabel.setFont(guiSize.settingsChoiceBoldFont);
		itemDescriptionLabel.setForeground(theme.textColor);
		itemDescriptionPanel.add(itemDescriptionLabel);
		itemActionButton = new JButton(language.feedTamoText);
		
		itemActionButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Debug.info("InventoryItemPanel.itemActionButton.actionPerformed", "Feeding Tamo");
				
				// Consume food and add hunger points
				int hungerToAdd = Items.getFoodHungerByIndicator(indicator);
				if(profile.getTamo().getHunger() + hungerToAdd >= 10) {
					profile.getTamo().setHunger(10);
				} else {
					profile.getTamo().setHunger(profile.getTamo().getHunger() + hungerToAdd);
				}
				
				// Remove food from inventory
				int indexToRemove = -1;
				List<Long> foodInventoryList = new ArrayList<>(profile.getFoodInventoryList());
				
				// This will iterate through and delete one of the foods that match, since
				// the profile can have more than one instance of the food item.
				for(int i = 0; i < foodInventoryList.size(); i++) {
					if(foodInventoryList.get(i)  == indicator) {
						indexToRemove = i;
					}
				}
				Debug.info("InventoryItemPanel.itemActionButton.actionPerformed", "indexToRemove=" + indexToRemove);
				foodInventoryList.remove(indexToRemove);
				profile.setFoodInventoryList(foodInventoryList);
				
				// Earn Tamo Full achievement if applicable
				if(profile.getTamo().getHunger() >= 10) {
					Achievements.earn(tsGui, 7);
				}
				
				// Update JSON
				tsGui.getProfileJsonManager().writeJsonToFile(tsGui.getProfiles());
				
				// Call changeInventory
				// TODO call an animation from inventory state to say something like "Tamo Hunger 8/10" and fade to background color.
				inventoryState.changeInventory();
			}
		});
	}
	
	public void initializeBackgroundItemPanel() {
		itemTitleLabel = new JLabel(Items.getBackgroundTitleByIndicator(indicator, language));
		itemTitleLabel.setFont(guiSize.settingsChoiceBoldFont);
		itemTitleLabel.setForeground(theme.textColor);
		itemIconLabel = new JLabel(Items.getBackgroundIconByIndicator(indicator, guiSize));
		itemDescriptionPanel = new JPanel();
		itemDescriptionPanel.setBackground(theme.subColor);
		itemDescriptionPanel.setBorder(guiSize.settingsPanelBorder);
		itemDescriptionLabel = new JLabel(Items.getBackgroundDescriptionByIndicator(indicator, language));
		itemDescriptionLabel.setForeground(theme.textColor);
		itemDescriptionLabel.setFont(guiSize.settingsChoiceBoldFont);
		itemDescriptionPanel.add(itemDescriptionLabel);
		itemActionButton = new JButton(language.setBackgroundText);
		
		itemActionButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Debug.info("InventoryItemPanel.itemActionButton.actionPerformed", "Setting Background");
				
				// Set Background
				profile.setBackgroundIndicator(indicator);
				
				// Earn Background achievement if applicable
				if(indicator != 0) {
					Achievements.earn(tsGui, 5);
				}
				
				// Update JSON
				// TODO Add animation that background was set: "Background sunset set!" and fade to background color.
				tsGui.getProfileJsonManager().writeJsonToFile(tsGui.getProfiles());
			}
		});
	}
	
	public void initializeBorderItemPanel() {
		itemTitleLabel = new JLabel(Items.getBorderTitleByIndicator(indicator, language));
		itemTitleLabel.setFont(guiSize.settingsChoiceBoldFont);
		itemTitleLabel.setForeground(theme.textColor);
		itemIconLabel = new JLabel(Items.getBorderIconByIndicator(indicator, guiSize));
		itemDescriptionPanel = new JPanel();
		itemDescriptionPanel.setBackground(theme.subColor);
		itemDescriptionPanel.setBorder(guiSize.settingsPanelBorder);
		itemDescriptionLabel = new JLabel(Items.getBorderDescriptionByIndicator(indicator, language));
		itemDescriptionLabel.setFont(guiSize.settingsChoiceBoldFont);
		itemDescriptionLabel.setForeground(theme.textColor);
		itemDescriptionPanel.add(itemDescriptionLabel);
		itemActionButton = new JButton(language.setBorderText);
		
		itemActionButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Debug.info("InventoryItemPanel.itemActionButton.actionPerformed", "Setting Border");
				
				// Set backgrounds
				profile.setBorderIndicator(indicator);
				
				// Earn Background achievement if applicable
				if(indicator != 0) {
					Achievements.earn(tsGui, 4);
				}
				
				// Update JSON
				// TODO Add animation that border was set: "Border black set!" and fade to background color.
				tsGui.getProfileJsonManager().writeJsonToFile(tsGui.getProfiles());
			}
		});
	}
	
	public void initializePanel() {
		GridBagConstraints gbcv = new GridBagConstraints();
		gbcv.gridwidth = GridBagConstraints.REMAINDER;
		
		this.setLayout(new GridBagLayout());
		this.setBackground(theme.mainColor);
		
		this.add(itemTitleLabel, gbcv);
		this.add(Box.createVerticalStrut(guiSize.settingsVerticalDifference), gbcv);
		this.add(itemIconLabel, gbcv);
		this.add(Box.createVerticalStrut(guiSize.settingsVerticalDifference), gbcv);
		this.add(itemDescriptionPanel, gbcv);
		this.add(Box.createVerticalStrut(guiSize.settingsVerticalDifference), gbcv);
		this.add(itemActionButton, gbcv);
	}
}
