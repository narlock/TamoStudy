package components.panel;

import java.util.List;

import javax.swing.Box;
import javax.swing.JPanel;

import gui.TamoStudyGUI;
import model.GuiSize;
import model.language.Language;
import resources.Theme;

public class ShopPanel extends JPanel {

	private static final long serialVersionUID = -2126394001767280760L;

	/*
	 * ##################################
	 * ##################################
	 * ATTRIBUTES
	 * ##################################
	 * ##################################
	 */
	private TamoStudyGUI tsGui;
	private GuiSize guiSize;
	private Language language;
	private Theme theme;
	private List<ShopItemPanel> shopItems;
	private int currentShopIndicator;
	
	/*
	 * ##################################
	 * ##################################
	 * COMPONENTS
	 * ##################################
	 * ##################################
	 */
	
	public ShopPanel(TamoStudyGUI tsGui, GuiSize guiSize, Language language) {
		this.tsGui = tsGui;
		this.guiSize = guiSize;
		this.language = language;
		theme = Theme.DARK;
		currentShopIndicator = 0;
		
		initializeComponents();
		initializePanel();
	}
	
	public void initializeComponents() {
		
	}
	
	public void initializePanel() {
		this.setBackground(theme.subColor);
		
	}
	
	public void setShop(int shopIndicator) {
		switch(shopIndicator) {
		case 0:
			if(currentShopIndicator != 0) {
				this.removeAll();
				this.repaint();
				currentShopIndicator = 0;
			}
			
			break;
		case 1:
			if(currentShopIndicator != 1) {
				this.removeAll();
				this.repaint();
				
				this.add(new ShopItemPanel(tsGui, guiSize, language, "FOOD", 0, false));
				this.add(Box.createHorizontalStrut(guiSize.settingsHorizontalDifference));
				this.add(new ShopItemPanel(tsGui, guiSize, language, "FOOD", 1, false));
				this.add(Box.createHorizontalStrut(guiSize.settingsHorizontalDifference));
				this.add(new ShopItemPanel(tsGui, guiSize, language, "FOOD", 2, false));
				
				currentShopIndicator = 1;
			}
			
			break;
		case 2:
			if(currentShopIndicator != 2) {
				this.removeAll();
				this.repaint();
				
				this.add(new ShopItemPanel(tsGui, guiSize, language, "BACKGROUND", 1, false));
				this.add(Box.createHorizontalStrut(guiSize.settingsHorizontalDifference));
				this.add(new ShopItemPanel(tsGui, guiSize, language, "BACKGROUND", 2, false));
				this.add(Box.createHorizontalStrut(guiSize.settingsHorizontalDifference));
				this.add(new ShopItemPanel(tsGui, guiSize, language, "BACKGROUND", 3, false));
				
				currentShopIndicator = 2;
			}
			
			break;
		case 3:
			if(currentShopIndicator != 3) {
				this.removeAll();
				this.repaint();
				
				this.add(new ShopItemPanel(tsGui, guiSize, language, "BORDER", 1, false));
				this.add(Box.createHorizontalStrut(guiSize.settingsHorizontalDifference));
				this.add(new ShopItemPanel(tsGui, guiSize, language, "BORDER", 2, false));
				this.add(Box.createHorizontalStrut(guiSize.settingsHorizontalDifference));
				this.add(new ShopItemPanel(tsGui, guiSize, language, "BORDER", 3, false));
				
				currentShopIndicator = 3;
			}
			
			break;
		}
	}
}
