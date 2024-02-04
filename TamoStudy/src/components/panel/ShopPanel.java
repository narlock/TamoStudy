package components.panel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JPanel;

import gui.TamoStudyGUI;
import model.GuiSize;
import model.language.Language;
import resources.Debug;
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
	private int shopPage;
	
	/*
	 * ##################################
	 * ##################################
	 * COMPONENTS
	 * ##################################
	 * ##################################
	 */
	private JButton nextButton;
	private JButton previousButton;
	
	public ShopPanel(TamoStudyGUI tsGui, GuiSize guiSize, Language language) {
		this.tsGui = tsGui;
		this.guiSize = guiSize;
		this.language = language;
		theme = Theme.DARK;
		currentShopIndicator = 0;
		shopPage = 0;
		
		initializeComponents();
		initializePanel();
	}
	
	public void initializeComponents() {
		nextButton = new JButton(guiSize.rightArrowIcon);
		addButtonVisual(nextButton);
		
		nextButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				nextPreviousPage(true);
				
			}
		});
		
		previousButton = new JButton(guiSize.leftArrowIcon);
		addButtonVisual(previousButton);
		
		previousButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				nextPreviousPage(false);
				
			}
		});
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
				shopPage = 0;
				
				this.revalidate();
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
				shopPage = 0;
				
				this.revalidate();
			}
			
			break;
		case 2:
			if(currentShopIndicator != 2) {
				this.removeAll();
				this.repaint();
				
				this.add(previousButton);
				this.add(new ShopItemPanel(tsGui, guiSize, language, "BACKGROUND", 1, false));
				this.add(Box.createHorizontalStrut(guiSize.settingsHorizontalDifference));
				this.add(new ShopItemPanel(tsGui, guiSize, language, "BACKGROUND", 2, false));
				this.add(Box.createHorizontalStrut(guiSize.settingsHorizontalDifference));
				this.add(new ShopItemPanel(tsGui, guiSize, language, "BACKGROUND", 3, false));
				this.add(nextButton);
				
				currentShopIndicator = 2;
				shopPage = 0;
				
				this.revalidate();
			}
			
			break;
		case 3:
			if(currentShopIndicator != 3) {
				this.removeAll();
				this.repaint();
				
				this.add(previousButton);
				this.add(new ShopItemPanel(tsGui, guiSize, language, "BORDER", 1, false));
				this.add(Box.createHorizontalStrut(guiSize.settingsHorizontalDifference));
				this.add(new ShopItemPanel(tsGui, guiSize, language, "BORDER", 2, false));
				this.add(Box.createHorizontalStrut(guiSize.settingsHorizontalDifference));
				this.add(new ShopItemPanel(tsGui, guiSize, language, "BORDER", 3, false));
				this.add(nextButton);
				
				currentShopIndicator = 3;
				shopPage = 0;
				
				this.revalidate();
			}
			
			break;
		}
		
		Debug.info("ShopPanel.setShop(" + shopIndicator + ")", "" + this.getComponentCount());
	}
	
	public void nextPreviousPage(boolean next) {
		// If next is true, we are moving forward, otherwise, we are moving back
		if(next) {
			shopPage++;
		} else {
			shopPage--;
		}
		
		Debug.info("ShopPanel.nextPreviousPage", "shopPage=" + shopPage + ", currentShopIndicator=" + currentShopIndicator);
		
		switch(currentShopIndicator) {
		case 2:
			if(shopPage == 0) {
				this.removeAll();
				this.repaint();
				
				// Add shop options on page 0
				this.add(previousButton);
				this.add(new ShopItemPanel(tsGui, guiSize, language, "BACKGROUND", 1, false));
				this.add(Box.createHorizontalStrut(guiSize.settingsHorizontalDifference));
				this.add(new ShopItemPanel(tsGui, guiSize, language, "BACKGROUND", 2, false));
				this.add(Box.createHorizontalStrut(guiSize.settingsHorizontalDifference));
				this.add(new ShopItemPanel(tsGui, guiSize, language, "BACKGROUND", 3, false));
				this.add(nextButton);
				
				this.revalidate();
			} else if(shopPage == 1) {
				this.removeAll();
				this.repaint();
				
				// Add shop options on page 1
				this.add(previousButton);
				this.add(new ShopItemPanel(tsGui, guiSize, language, "BACKGROUND", 4, false));
				this.add(Box.createHorizontalStrut(guiSize.settingsHorizontalDifference));
				this.add(new ShopItemPanel(tsGui, guiSize, language, "BACKGROUND", 5, false));
				this.add(Box.createHorizontalStrut(guiSize.settingsHorizontalDifference));
				this.add(new ShopItemPanel(tsGui, guiSize, language, "BACKGROUND", 6, false));
				this.add(nextButton);
				
				this.revalidate();
			} else if(shopPage == 2) {
				this.removeAll();
				this.repaint();
				
				// Add shop options on page 1
				this.add(previousButton);
				this.add(new ShopItemPanel(tsGui, guiSize, language, "BACKGROUND", 7, false));
				this.add(Box.createHorizontalStrut(guiSize.settingsHorizontalDifference));
				this.add(new ShopItemPanel(tsGui, guiSize, language, "BACKGROUND", 8, false));
				this.add(Box.createHorizontalStrut(guiSize.settingsHorizontalDifference));
				this.add(new ShopItemPanel(tsGui, guiSize, language, "BACKGROUND", 9, false));
				this.add(nextButton);
				
				this.revalidate();
			} else {
			
				this.removeAll();
				this.repaint();
			}
			
			break;
		case 3:
			if(shopPage == 0) {
				this.removeAll();
				this.repaint();
				
				// Add shop options on page 0
				this.add(previousButton);
				this.add(new ShopItemPanel(tsGui, guiSize, language, "BORDER", 1, false));
				this.add(Box.createHorizontalStrut(guiSize.settingsHorizontalDifference));
				this.add(new ShopItemPanel(tsGui, guiSize, language, "BORDER", 2, false));
				this.add(Box.createHorizontalStrut(guiSize.settingsHorizontalDifference));
				this.add(new ShopItemPanel(tsGui, guiSize, language, "BORDER", 3, false));
				this.add(nextButton);
				
				this.revalidate();
			} else if(shopPage == 1) {
				this.removeAll();
				this.repaint();
				
				// Add shop options on page 1
				this.add(previousButton);
				this.add(new ShopItemPanel(tsGui, guiSize, language, "BORDER", 4, false));
				this.add(Box.createHorizontalStrut(guiSize.settingsHorizontalDifference));
				this.add(new ShopItemPanel(tsGui, guiSize, language, "BORDER", 5, false));
				this.add(Box.createHorizontalStrut(guiSize.settingsHorizontalDifference));
				this.add(new ShopItemPanel(tsGui, guiSize, language, "BORDER", 6, false));
				this.add(nextButton);
				
				this.revalidate();
			} else if(shopPage == 2) {
				this.removeAll();
				this.repaint();
				
				// Add shop options on page 1
				this.add(previousButton);
				this.add(new ShopItemPanel(tsGui, guiSize, language, "BORDER", 7, false));
				this.add(Box.createHorizontalStrut(guiSize.settingsHorizontalDifference));
				this.add(new ShopItemPanel(tsGui, guiSize, language, "BORDER", 8, false));
				this.add(Box.createHorizontalStrut(guiSize.settingsHorizontalDifference));
				this.add(new ShopItemPanel(tsGui, guiSize, language, "BORDER", 9, false));
				this.add(nextButton);
				
				this.revalidate();
			} else {
				this.removeAll();
				this.repaint();
			}
			
			break;
		}
		
		Debug.info("ShopPanel.nextPreviousPage", "" + this.getComponentCount());
		
		// If we get to a page with no items, go back to previous/next page
		if(this.getComponentCount() == 0) {
			if(next) {
				nextPreviousPage(false);
			} else {
				nextPreviousPage(true);
			}
		}
	}
	
	public void addButtonVisual(JButton button) {
		button.setContentAreaFilled(false);
		button.setOpaque(false);
		button.setBorderPainted(false);
		button.setFocusPainted(false);
	}
}
