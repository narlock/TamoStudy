/**
 * @author: Anthony Narlock
 * @description: foodGUI: this is the food GUI screen in TamoStudy
 */


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class foodGUI extends JFrame {
	
	/*
	 * Components of foodGUI
	 * Initialized based off of location on the screen
	 */
	private Profile p;
	private GridBagConstraints gbc = new GridBagConstraints();
	
	//Left Panel Components
	private JPanel leftPanel;
	
	private JLabel food1ImageLabel, food1InfoLabel;
	private JButton food1BuyButton;
	
	//Center Panel Components
	private JPanel centerPanel;
	
	private JLabel shopImageLabel;
	private JLabel tutorialLabel;
	
	//Right Panel Components
	private JPanel rightPanel;
	
	private JLabel food2ImageLabel, food2InfoLabel;
	private JButton food2BuyButton;
	
	//South panel components
	private JPanel southPanel;
	
	private JButton returnToFocus;
	
	/*
	 * Constructor for GUI, parameter is profile information
	 */
	
	public foodGUI(Profile profile) {
		this.p = profile;

		
		setUpFrame();
		
		initComponents();
		
		setUpGUI();
		
		this.setSize(720, 300);
		
	}
	
	/*
	 *  Sets up frame information, size, etc.
	 */
	
	public void setUpFrame() {
		ImageIcon logo = new ImageIcon("assets/heart.png");
		
		this.setTitle("Food Shop - Current TamoTokens: " + p.getMoney());
		this.setSize(720, 299);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);
		this.setBackground(new Color(255,161,161));
		this.setIconImage(logo.getImage());
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	/*
	 * Initializes GUI components, including action listeners
	 */
	
	public void initComponents() {
		//Init Left Panel Components
		leftPanel = new JPanel();
		leftPanel.setBackground(new Color(255,161,161));
		
		food1ImageLabel = new JLabel(new ImageIcon("assets/food1.png"));
		food1InfoLabel = new JLabel("100 TamoTokens, 1 Hunger");
		food1BuyButton = new JButton("BUY");
		
		//Init Center Panel Components
		centerPanel = new JPanel();
		centerPanel.setBackground(new Color(255,161,161));
		
		shopImageLabel = new JLabel(new ImageIcon("assets/shop.png"));
		tutorialLabel = new JLabel("Buy food for your Tamo!\nUpon purchase, Tamo will eat food.");
		
		//Init right panel components
		rightPanel = new JPanel();
		rightPanel.setBackground(new Color(255,161,161));
		
		food2ImageLabel = new JLabel(new ImageIcon("assets/food2.png"));
		food2InfoLabel = new JLabel("200 TamoTokens, 3 Hunger");
		food2BuyButton = new JButton("BUY");
		
		//Init South panel components
		southPanel = new JPanel();
		southPanel.setBackground(new Color(255,161,161));
		returnToFocus = new JButton("Return to Focus");
		
		/*
		 * Button activities
		 */
		
		food1BuyButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(p.getMoney() - 100 >= 0) {
					if(JOptionPane.showConfirmDialog(null, "Are you sure?", "Purchase for 100 Tamo Tokens",
							JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
						p.getTamo().setHunger(p.getTamo().getHunger() + 1);
						p.setMoney(p.getMoney() - 100);
						
						GUI Focus = new GUI(p);
						hideWindow();
					}
				} else {
					JOptionPane.showMessageDialog(null, "You don't have sufficient funds.", "Can't complete purchase", JOptionPane.INFORMATION_MESSAGE);
				}
				
			}
			
		});
		
		food2BuyButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(p.getMoney() - 200 >= 0) {
					if(JOptionPane.showConfirmDialog(null, "Are you sure?", "Purchase for 200 Tamo Tokens",
							JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
						if(p.getTamo().getHunger() > 7) {
							p.getTamo().setHunger(10);
						} else {
							p.getTamo().setHunger(p.getTamo().getHunger() + 3);
						}
						
						p.setMoney(p.getMoney() - 200);
						
						GUI Focus = new GUI(p);
						hideWindow();
					}
				} else {
					JOptionPane.showMessageDialog(null, "You don't have sufficient funds.", "Can't complete purchase", JOptionPane.INFORMATION_MESSAGE);
				}
				
			}
			
		});
		
		
		returnToFocus.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				GUI Focus = new GUI(p);
				hideWindow();
				
			}
			
		});
	}
	
	/*
	 * Sets up the GUI, layout, etc.
	 */
	
	public void setUpGUI() {
		this.setLayout(new BorderLayout());
		
		this.add(leftPanel, BorderLayout.WEST);
		leftPanel.setLayout(new GridLayout(3, 1));
		leftPanel.add(food1ImageLabel);
		leftPanel.add(food1InfoLabel);
		leftPanel.add(food1BuyButton);
		
		this.add(centerPanel, BorderLayout.CENTER);
		centerPanel.setLayout(new GridLayout(1, 1));
		centerPanel.add(shopImageLabel); 
		//centerPanel.add(tutorialLabel);
		
		this.add(rightPanel, BorderLayout.EAST);
		rightPanel.setLayout(new GridLayout(3, 1));
		rightPanel.add(food2ImageLabel);
		rightPanel.add(food2InfoLabel);
		rightPanel.add(food2BuyButton);
		
		this.add(southPanel, BorderLayout.SOUTH);
		southPanel.add(returnToFocus);
	}
	
	/*
	 * Method hides the main windows and disposes it
	 */
	public void hideWindow() {
		this.setVisible(false);
		this.dispose();
	}
}
