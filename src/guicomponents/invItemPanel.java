package guicomponents;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class invItemPanel extends JPanel {
	private JPanel northPanel, centerPanel, bottomPanel;
	private JLabel itemImage;
	private JButton useItem;
	
	private String[] imageString = {"inv-0.png", "inv-1.png", "inv-2.png", "inv-3.png", 
									"inv-4.png", "inv-5.png", "inv-6.png",
									"inv-7.png", "inv-8.png","inv-9.png",
									"inv-10.png","inv-11.png"};
	
	private int id;
	
	public invItemPanel(int id) {
		this.id = id;
		this.itemImage = new JLabel(new ImageIcon(getClass().getClassLoader().getResource(imageString[id])));
		this.useItem = new JButton("Use Item");
		initButtonActions();
	}
	
	public void initButtonActions() {
		
		//If the item is a background, add the background
		if(id <= 6) {
			useItem.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					
				}
				
			});
		} else {
			useItem.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					
				}
				
			});
		}
		
		//TODO If the item is already being used, disable the button
	}

}
