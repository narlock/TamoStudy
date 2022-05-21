package state;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import profile.Profile;
import resources.TextBubbleBorder;

/**
 * @author Anthony Narlock
 * ShopStrategy
 * 
 * This is a concrete StateStrategy which is a JPanel
 * that will display the user interface for Shop
 */

public class ShopStrategy extends StateStrategy {
	
	public ShopStrategy(Profile profile) {
		super(profile);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Shop Panel
	 * 
	 * Left Panel is Food Panel
	 * Center Panel is Main Panel
	 * Right Panel is Background Panel
	 */
	
	//Separators
	
	//foodPanel
	private JPanel foodPanel;
	private JLabel foodShopLabel;
	private JPanel[] foodItems;
	
	//mainPanel
	private JPanel mainPanel, tokenPanel;
	private JLabel shopImageLabel, tokenImageLabel;
	private JLabel tokenDisplayLabel;
	
	private JPanel messagePanel;
	private JLabel kathImage;
	private JLabel messageText;
	
	//bgPanel
	private JPanel bgPanel;
	private JLabel bgShopLabel;
	private JPanel[] bgItems;

	@Override
	public void setPanel() {
		this.setLayout(new GridLayout(1,3,30,30));
		this.setBackground(theme.subColor);
		createFoodPanel();
		createMainPanel();
		createBgPanel();
	}
	
	//Creates the food panel
	public void createFoodPanel() {
		foodPanel = new JPanel();
			foodPanel.setBackground(theme.subColor);
			foodPanel.setLayout(new BoxLayout(foodPanel, BoxLayout.Y_AXIS));
		
		foodShopLabel = new JLabel(profile.getLanguage().shopText[0]);
			foodShopLabel.setForeground(theme.textColor);
			foodShopLabel.setFont(theme.fontBoldReg);
			foodShopLabel.setAlignmentX(JComponent.CENTER_ALIGNMENT);
		
		foodPanel.add(foodShopLabel);
		
		//For each food item, we will add them
		
		//TODO
		//Make it so depending on the month, there will be different
		//backgrounds in which the player can choose to have....
		
		foodItems = new JPanel[3];
		foodItems[0] = createFoodItemPanel(1, "FOOD_1.png", 100);
		foodItems[1] = createFoodItemPanel(3, "FOOD_3.png", 200);
		foodItems[2] = createFoodItemPanel(10, "FOOD_10.png", 800);
		
		foodPanel.add(createSpaceLabel());
		for(int i = 0; i < foodItems.length; i++) {
			foodPanel.add(foodItems[i]);
			foodPanel.add(createSpaceLabel());
		}
		
		this.add(foodPanel);
	}
	
	//Creates the main panel
	public void createMainPanel() {
		mainPanel = new JPanel();
			mainPanel.setBackground(theme.subColor);
			mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		
		shopImageLabel = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("KATH_SHOP.png")));
			shopImageLabel.setAlignmentX(JComponent.CENTER_ALIGNMENT);
		mainPanel.add(shopImageLabel);
		
		messagePanel = new JPanel();
			messagePanel.setBackground(theme.subColor);
			messagePanel.setLayout(new BoxLayout(messagePanel, BoxLayout.Y_AXIS));
			messagePanel.setAlignmentX(JComponent.CENTER_ALIGNMENT);
		kathImage = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("KATH_MSG.png")));
			kathImage.setAlignmentX(JComponent.CENTER_ALIGNMENT);
			
		//TODO Dynamically change this..
		//Make a method that changes it based off of an indicator since we need HTML...
		messageText = new JLabel("<html>" + profile.getLanguage().shopText[2] 
				+ "<br>" + profile.getLanguage().shopText[3] + "</html>");
		
			messageText.setOpaque(true);
			messageText.setBackground(Color.WHITE);
			messageText.setForeground(Color.BLACK);
			messageText.setBorder(new TextBubbleBorder(Color.BLACK, 2, 6, 10, true));
			messageText.setAlignmentX(JComponent.CENTER_ALIGNMENT);
		messagePanel.add(messageText);
		messagePanel.add(kathImage);
		mainPanel.add(messagePanel);
		
		//mainPanel.add(createSpaceLabel());
		
		tokenPanel = new JPanel();
			tokenPanel.setBackground(theme.subColor);
		tokenImageLabel = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("TAMO_TOKEN.png")));
		tokenDisplayLabel = new JLabel(Integer.toString(profile.getTamoTokens()));
			tokenDisplayLabel.setForeground(theme.textColor);
			tokenDisplayLabel.setFont(theme.fontBoldReg);
		tokenPanel.add(tokenImageLabel);
		tokenPanel.add(tokenDisplayLabel);
		mainPanel.add(tokenPanel);
		
		
		this.add(mainPanel);
	}
	
	//Creates the background panel
	public void createBgPanel() {
		bgPanel = new JPanel();
			bgPanel.setBackground(theme.subColor);
			bgPanel.setLayout(new BoxLayout(bgPanel, BoxLayout.Y_AXIS));
		bgShopLabel = new JLabel(profile.getLanguage().shopText[1]);
			bgShopLabel.setForeground(theme.textColor);
			bgShopLabel.setFont(theme.fontBoldReg);
			bgShopLabel.setAlignmentX(JComponent.CENTER_ALIGNMENT);
		bgPanel.add(bgShopLabel);
		
		//For each food item, we will add them
		bgItems = new JPanel[4];
		bgItems[0] = createItemPanel(1, "SHOP_BG_2.png", 1000);
		bgItems[1] = createItemPanel(2, "SHOP_BG_3.png", 1000);
		bgItems[2] = createItemPanel(3, "SHOP_BG_4.png", 1000);
		
		bgPanel.add(createSpaceLabel());
		for(int i = 0; i < foodItems.length; i++) {
			bgPanel.add(bgItems[i]);
			bgPanel.add(createSpaceLabel());
		}
		
		this.add(bgPanel);
	}

	@Override
	public void setActions() {
		// TODO Auto-generated method stub
		
	}
	
	public JPanel createItemPanel(int indicator, String imageUrl, int price) {
		JPanel itemPanel = new JPanel();
		itemPanel.setLayout(new GridLayout(1,2));
		itemPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
		itemPanel.setBackground(theme.layerColor);
		
		JLabel imageLabel = new JLabel(new ImageIcon(getClass().getClassLoader().getResource(imageUrl)));
		itemPanel.add(imageLabel);
		JPanel infoPanel = new JPanel();
			infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
			infoPanel.setBackground(theme.layerColor);
		JPanel tokenPanel = new JPanel();
			tokenPanel.setAlignmentX(JComponent.CENTER_ALIGNMENT);
			tokenPanel.setBackground(theme.layerColor);
		JLabel tokenImage = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("TAMO_TOKEN.png")));
		JLabel priceLabel = new JLabel("" + price);
			priceLabel.setForeground(theme.textColor);
		tokenPanel.add(tokenImage);
		tokenPanel.add(priceLabel);
		infoPanel.add(tokenPanel);
		JButton purchaseButton = new JButton(profile.getLanguage().shopText[4]);
			setBackgroundButtonAction(purchaseButton, price, indicator);
			purchaseButton.setAlignmentX(JComponent.CENTER_ALIGNMENT);
		infoPanel.add(purchaseButton);
		itemPanel.add(infoPanel);
		
		return itemPanel;
	}
	
	public JPanel createFoodItemPanel(int hunger, String imageUrl, int price) {
		JPanel foodPanel = new JPanel();
			foodPanel.setLayout(new GridLayout(1,2));
			foodPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
			foodPanel.setBackground(theme.layerColor);
			
		JLabel foodImageLabel = new JLabel(new ImageIcon(getClass().getClassLoader().getResource(imageUrl)));
		foodPanel.add(foodImageLabel);
		JPanel infoPanel = new JPanel();
			infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
			infoPanel.setBackground(theme.layerColor);
		JPanel tokenPanel = new JPanel();
			tokenPanel.setAlignmentX(JComponent.CENTER_ALIGNMENT);
			tokenPanel.setBackground(theme.layerColor);
		JLabel tokenImage = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("TAMO_TOKEN.png")));
		JLabel foodPriceLabel = new JLabel("" + price + " | " + hunger);
			foodPriceLabel.setForeground(theme.textColor);
		tokenPanel.add(tokenImage);
		tokenPanel.add(foodPriceLabel);
		infoPanel.add(tokenPanel);
		JButton foodPurchaseButton = new JButton(profile.getLanguage().shopText[4]);
			foodPurchaseButton.setAlignmentX(JComponent.CENTER_ALIGNMENT);
			setFoodButtonAction(foodPurchaseButton, price, hunger);
		infoPanel.add(foodPurchaseButton);
		foodPanel.add(infoPanel);
		
		return foodPanel;
	}
	
	public JLabel createSpaceLabel() {
		//Space Component
		JLabel transparentComponent = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("TRANSPARENT.png")));
		transparentComponent.setAlignmentX(JComponent.CENTER_ALIGNMENT);
		
		return transparentComponent;
	}
	
	public void setFoodButtonAction(JButton button, int price, int hunger) {
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//If I can purchase the Food item
				if(profile.getTamoTokens() - price >= 0 && profile.getTamo().getHunger() != 10) {
					
					messageText.setText("<html>" + profile.getLanguage().shopText[4] + " " + profile.getLanguage().shopText[8] + "<br>" + price + " " + profile.getLanguage().shopText[9] + "</html>");
					JPanel optionPanel = new JPanel();
						optionPanel.setBackground(theme.subColor);
					JButton confirmPurchase = new JButton(profile.getLanguage().shopText[13]);
						confirmPurchase.setAlignmentX(JComponent.CENTER_ALIGNMENT);
						confirmPurchase.setFont(new Font("Tahoma", Font.BOLD, 18));
						confirmPurchase.addActionListener(new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent e) {
								//Update Tamo Tokens
								profile.setTamoTokens(profile.getTamoTokens() - price); 				//Subtract the amount from my total
								tokenDisplayLabel.setText(Integer.toString(profile.getTamoTokens())); 	//Update the total number of tamoTokens
								
								//Update Food
								if(profile.getTamo().getHunger() + hunger >= 10) { profile.getTamo().setHunger(10); }
								else { profile.getTamo().setHunger(profile.getTamo().getHunger() + hunger); }
								//TODO Update the profile file
								
								messageText.setBorder(new TextBubbleBorder(Color.BLACK, 2, 6, 10, true));
								messageText.setText("<html>" + profile.getLanguage().shopText[11] + "<br>"  + profile.getLanguage().shopText[12] + "</html>");
								messagePanel.remove(optionPanel);
								
								//Check Achievement
								checkTamoHungerAchievement();
							}
							
						});
					JButton declinePurchase = new JButton(profile.getLanguage().shopText[14]);
						declinePurchase.setAlignmentX(JComponent.CENTER_ALIGNMENT);
						declinePurchase.setFont(new Font("Tahoma", Font.BOLD, 18));
						declinePurchase.addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent e) {
								messageText.setBorder(new TextBubbleBorder(Color.BLACK, 2, 6, 10, true));
								messageText.setText("<html>" + profile.getLanguage().shopText[11] + "<br>"  + profile.getLanguage().shopText[12] + "</html>");
								messagePanel.remove(optionPanel);
							}
						});
						
					messageText.setBorder(new TextBubbleBorder(Color.RED, 2, 6, 10, true));
					optionPanel.add(confirmPurchase);
					optionPanel.add(declinePurchase);
					messagePanel.add(optionPanel);
					
				} else {
					if(!(profile.getTamoTokens() - price >= 0))
						messageText.setText("<html>" + profile.getLanguage().shopText[5] + "</html>");
					else
						messageText.setText("<html>" + profile.getLanguage().shopText[6] + "</html>");
				}
			}
		});
	}
	
	public void setBackgroundButtonAction(JButton button, int price, int indicator) {
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				// TODO Check if the user already has the background in inventory
				if(profile.getTamoTokens() - price >= 0 && profile.containsItem(indicator) == false) {
					messageText.setText("<html>" + profile.getLanguage().shopText[4] + " " + profile.getLanguage().shopText[8] + "<br>" + price + " " + profile.getLanguage().shopText[9] + "</html>");
					JPanel optionPanel = new JPanel();
						optionPanel.setBackground(theme.subColor);
					JButton confirmPurchase = new JButton(profile.getLanguage().shopText[13]);
						confirmPurchase.setAlignmentX(JComponent.CENTER_ALIGNMENT);
						confirmPurchase.setFont(new Font("Tahoma", Font.BOLD, 18));
						confirmPurchase.addActionListener(new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent e) {
								//Update Tamo Tokens
								profile.setTamoTokens(profile.getTamoTokens() - price); 				//Subtract the amount from my total
								tokenDisplayLabel.setText(Integer.toString(profile.getTamoTokens())); 	//Update the total number of tamoTokens
								
								//Put the Item in profile inventory
								profile.setInvString(profile.getInvString() + Integer.toString(indicator));
								//TODO update the file
								
								messageText.setBorder(new TextBubbleBorder(Color.BLACK, 2, 6, 10, true));
								messageText.setText("<html>" + profile.getLanguage().shopText[11] + "<br>"  + profile.getLanguage().shopText[12] + "</html>");
								messagePanel.remove(optionPanel);
							}
							
						});
					JButton declinePurchase = new JButton(profile.getLanguage().shopText[14]);
						declinePurchase.setAlignmentX(JComponent.CENTER_ALIGNMENT);
						declinePurchase.setFont(new Font("Tahoma", Font.BOLD, 18));
						declinePurchase.addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent e) {
								messageText.setBorder(new TextBubbleBorder(Color.BLACK, 2, 6, 10, true));
								messageText.setText("<html>" + profile.getLanguage().shopText[11] + "<br>"  + profile.getLanguage().shopText[12] + "</html>");
								messagePanel.remove(optionPanel);
							}
						});
						
					messageText.setBorder(new TextBubbleBorder(Color.RED, 2, 6, 10, true));
					optionPanel.add(confirmPurchase);
					optionPanel.add(declinePurchase);
					messagePanel.add(optionPanel);
				}
				else {
					if(!(profile.getTamoTokens() - price >= 0))
						messageText.setText("<html>" + profile.getLanguage().shopText[5] + "</html>");
					else
						messageText.setText("<html>" + profile.getLanguage().shopText[15] + "</html>");
				}
			}
			
		});
	}
	
	public void checkTamoHungerAchievement() {
		if(profile.getTamo().getHunger() == 10 && profile.getAhmIndicator(7).equals("0")) {
			profile.getAchievement(7);
			JOptionPane.showMessageDialog(this, profile.getLanguage().ahmTitle[7], profile.getLanguage().text[11], JOptionPane.INFORMATION_MESSAGE,  new ImageIcon(getClass().getClassLoader().getResource("INFO.png")));
		}
	}

}
