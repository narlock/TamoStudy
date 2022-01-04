package guicomponents;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class invItemPanel extends JPanel {
	private JPanel northPanel, centerPanel, bottomPanel;
	private JLabel itemImage;
	private JButton useItem;
	
	private String[] imageString = {"color-default.png", 
									"color-blue.png", 
									"color-green.png", 
									"color-orange.png", 
									"color-purple.png", 
									"color-yellow.png", 
									"color-grey.png",
									"inv-7.png", "inv-8.png","inv-9.png","inv-a.png","inv-b.png"};
	
	private String[] itemTitle = {"Default Background Color",
								"Blue Background Color",
								"Green Background Color",
								"Orange Background Color",
								"Purple Background Color",
								"Yellow Background Color",
								"Grey Background Color",
								"Background 1",
								"Background 2",
								"Background 3",
								"Background 4",
								"Background 5"
								};
	
	private int id;
	
	public invItemPanel(int id) {
		this.id = id;
		this.itemImage = new JLabel(new ImageIcon(getClass().getClassLoader().getResource(imageString[id])));
		this.useItem = new JButton("Use Item");
		
		createPanel();
	}
	
	public void createPanel() {
		this.setLayout(new GridLayout(2,1));
		this.add(itemImage);
		
		JPanel bottomPanel = new JPanel();
		bottomPanel.add(useItem);
		this.add(bottomPanel);
	}
	
	public invItemPanel getInvItemPanel() {
		return this;
	}
	
	public JButton getButton() {
		return useItem;
	}
	
	public int getId() {
		return id;
	}
	
	public String getItemTitle() {
		return itemTitle[id];
	}

}
