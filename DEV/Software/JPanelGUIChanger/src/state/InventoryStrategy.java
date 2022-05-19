package state;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import profile.Profile;
import resources.BubbleBorder;
import resources.TextBubbleBorder;

public class InventoryStrategy extends StateStrategy {
	
	private final JLabel NO_ITEMS = new JLabel(profile.getLanguage().inventoryText[0]);
	private JLabel messageLabel;
	
	private JPanel itemPanel;

	public InventoryStrategy(Profile profile) {
		super(profile);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void setPanel() {
		this.setBackground(theme.subColor);
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		messageLabel = new JLabel(profile.getLanguage().inventoryText[3]);
			messageLabel.setFont(theme.fontBoldReg);
			messageLabel.setForeground(theme.textColor);
			messageLabel.setAlignmentX(JComponent.CENTER_ALIGNMENT);
		this.add(messageLabel, BorderLayout.NORTH);
		
		//Read the profile inventory string
		//add panels and functionality accordingly
		
		itemPanel = new JPanel();
			itemPanel.setBackground(theme.subColor);
		String[] inventoryItems = profile.getInvString().split("");
		
		for(int i = 0; i < inventoryItems.length; i++) {
			if(inventoryItems[i].equals("0") || inventoryItems[i].equals("1") ||
				inventoryItems[i].equals("2") || inventoryItems[i].equals("3") ||
				inventoryItems[i].equals("4") || inventoryItems[i].equals("5") ||
				inventoryItems[i].equals("6") || inventoryItems[i].equals("7") ||
				inventoryItems[i].equals("8") || inventoryItems[i].equals("9") 
				) {
				itemPanel.add(createItemPanel(inventoryItems[i], "Background"));
			}
		}
		this.add(itemPanel, BorderLayout.CENTER);
		
	}

	@Override
	public void setActions() {
		// TODO Auto-generated method stub
		
	}
	
	public JPanel createItemPanel(String name, String type) {
		String imageUrl = getImageUrl(name);
		
		if(type.equals("Background")) {
			JPanel panel = new JPanel();
			panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
				panel.setForeground(theme.layerColor);
				panel.setBorder(new BubbleBorder(Color.BLACK, 2, 6, 10, true));
			
			JLabel imageLabel = new JLabel(new ImageIcon(getClass().getClassLoader().getResource(imageUrl)));
				imageLabel.setAlignmentX(JComponent.CENTER_ALIGNMENT);
			panel.add(imageLabel);
			
			JButton useButton = new JButton(profile.getLanguage().inventoryText[1]);
				useButton.setAlignmentX(JComponent.CENTER_ALIGNMENT);
			useButton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					profile.setBgIndicator(Integer.parseInt(name));
					messageLabel.setText(profile.getLanguage().inventoryText[2]);
				}
				
			});
			panel.add(useButton);
			return panel;
		}
		return null;
	}
	
	public String getImageUrl(String name) {
		if(name.equals("0"))
			return "SHOP_BG_1.png";
		else if(name.equals("1"))
			return "SHOP_BG_2.png";
		else if(name.equals("2"))
			return "SHOP_BG_3.png";
		else if(name.equals("3"))
			return "SHOP_BG_4.png";
		else if(name.equals("5"))
			return "SHOP_BG_5.png";
		
		return null;
	}

}
