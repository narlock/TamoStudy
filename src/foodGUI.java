/**
 * @author: Anthony Narlock
 * @description: foodGUI: this is the food GUI screen in TamoStudy
 */


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.*;

public class foodGUI extends JFrame {
	
	/*
	 * Components of foodGUI
	 * Initialized based off of location on the screen
	 */
	private Profile p;
	private File file;
	private GridBagConstraints gbc = new GridBagConstraints();
	
	//Left Panel Components
	private JPanel leftPanel;
	
	private JLabel shopImageLabel;
	private JLabel tutorialLabel;
	
	//South panel components
	private JPanel southPanel;
	private JButton returnToFocus;
	
	//Center Panel Components
	private JPanel centerPanel;
	private JPanel food1Panel, food2Panel, food3Panel;
	
	private JLabel food1InfoLabel;
	private JButton food1BuyButton;
	
	private JLabel food2InfoLabel;
	private JButton food2BuyButton;
	
	private JLabel food3InfoLabel;
	private JButton food3BuyButton;
	

	
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
	
	public foodGUI(Profile profile, File profileFile) {
		this.p = profile;
		this.file = profileFile;
		
		setUpFrame();
		
		initComponents();
		
		setUpGUI();
		
		this.setSize(720, 300);
		
	}
	
	/*
	 *  Sets up frame information, size, etc.
	 */
	
	public void setUpFrame() {
		ImageIcon logo = new ImageIcon(getClass().getClassLoader().getResource("heart.png"));
		
		this.setTitle(p.getSettings().getLang().getText(4) + " | Tamo Tokens: " + p.getMoney());
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
		leftPanel.setBackground(p.getColor());
		
		//Init South panel components
		southPanel = new JPanel();
		southPanel.setBackground(p.getColor());
		returnToFocus = new JButton(p.getSettings().getLang().getText(20));
		
		//Init Center Panel Components
		centerPanel = new JPanel();
		centerPanel.setBackground(p.getColor());
		
		food1Panel = new JPanel();
		food1Panel.setBackground(p.getColor());
		
		food2Panel = new JPanel();
		food2Panel.setBackground(p.getColor());
		
		food3Panel = new JPanel();
		food3Panel.setBackground(p.getColor());
		
		shopImageLabel = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("shop.png")));
		tutorialLabel = new JLabel("Buy food for your Tamo!\nUpon purchase, Tamo will eat food.");
		
		food1InfoLabel = new JLabel("100 TamoTokens, 1 " + p.getSettings().getLang().getText(21));
		food1BuyButton = new JButton(new ImageIcon(getClass().getClassLoader().getResource("food-onigiri.png")));

		food2InfoLabel = new JLabel("200 TamoTokens, 3 " + p.getSettings().getLang().getText(21));
		food2BuyButton = new JButton(new ImageIcon(getClass().getClassLoader().getResource("food-plate.png")));
		
		food3InfoLabel = new JLabel("800 TamoTokens, 10 " + p.getSettings().getLang().getText(21));
		food3BuyButton = new JButton(new ImageIcon(getClass().getClassLoader().getResource("food-cheesecake.png")));
		
		
		/*
		 * Button activities
		 */
		
		food1BuyButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(p.getMoney() - 100 >= 0) {
					if(JOptionPane.showConfirmDialog(null, p.getSettings().getLang().getText(23), p.getSettings().getLang().getText(16) + " 100 " + p.getSettings().getLang().getText(17),
							JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
						p.getTamo().setHunger(p.getTamo().getHunger() + 1);
						p.setMoney(p.getMoney() - 100);
						
						GUI Focus = new GUI(p,file);
						hideWindow();
					}
				} else {
					JOptionPane.showMessageDialog(null, p.getSettings().getLang().getText(19), p.getSettings().getLang().getText(18), JOptionPane.INFORMATION_MESSAGE, new ImageIcon(getClass().getClassLoader().getResource("info.png")));
				}
				
			}
			
		});
		
		food2BuyButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(p.getMoney() - 200 >= 0) {
					if(JOptionPane.showConfirmDialog(null, p.getSettings().getLang().getText(23), p.getSettings().getLang().getText(16) + " 200 " + p.getSettings().getLang().getText(17),
							JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
						if(p.getTamo().getHunger() > 7) {
							p.getTamo().setHunger(10);
						} else {
							p.getTamo().setHunger(p.getTamo().getHunger() + 3);
						}
						
						p.setMoney(p.getMoney() - 200);
						
						GUI Focus = new GUI(p,file);
						hideWindow();
					}
				} else {
					JOptionPane.showMessageDialog(null, p.getSettings().getLang().getText(19), p.getSettings().getLang().getText(18), JOptionPane.INFORMATION_MESSAGE, new ImageIcon(getClass().getClassLoader().getResource("info.png")));
				}
				
			}
			
		});
		
		food3BuyButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(p.getMoney() - 800 >= 0) {
					if(JOptionPane.showConfirmDialog(null, p.getSettings().getLang().getText(23), p.getSettings().getLang().getText(16) + " 800 " + p.getSettings().getLang().getText(17),
							JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
						p.getTamo().setHunger(10);
						p.setMoney(p.getMoney() - 800);
						
						GUI Focus = new GUI(p,file);
						hideWindow();
					}
				} else {
					JOptionPane.showMessageDialog(null, p.getSettings().getLang().getText(19), p.getSettings().getLang().getText(18), JOptionPane.INFORMATION_MESSAGE, new ImageIcon(getClass().getClassLoader().getResource("info.png")));
				}
				
			}
			
		});
		
		
		returnToFocus.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				GUI Focus = new GUI(p,file);
				hideWindow();
				
			}
			
		});
	}
	
	/*
	 * Sets up the GUI, layout, etc.
	 */
	
	public void setUpGUI() {
		this.setLayout(new GridLayout(1,2));
		
		this.add(leftPanel);
		leftPanel.setLayout(new BorderLayout());
		leftPanel.add(shopImageLabel); 
		
		leftPanel.add(southPanel, BorderLayout.SOUTH);
		southPanel.add(returnToFocus);
		//leftPanel.add(food1ImageLabel);
		
		
		
		this.add(centerPanel);
		centerPanel.setLayout(new GridLayout(3, 1));
		
		centerPanel.add(food1Panel);
		
		food1Panel.setLayout(new BorderLayout());
		food1Panel.add(food1BuyButton, BorderLayout.WEST);
		food1Panel.add(food1InfoLabel, BorderLayout.CENTER);
		
		centerPanel.add(food2Panel);
		
		food2Panel.setLayout(new BorderLayout());
		food2Panel.add(food2BuyButton, BorderLayout.WEST);
		food2Panel.add(food2InfoLabel, BorderLayout.CENTER);
		
		centerPanel.add(food3Panel);
		
		food3Panel.setLayout(new BorderLayout());
		food3Panel.add(food3BuyButton, BorderLayout.WEST);
		food3Panel.add(food3InfoLabel, BorderLayout.CENTER);

	}
	
	/*
	 * Method hides the main windows and disposes it
	 */
	public void hideWindow() {
		this.setVisible(false);
		this.dispose();
	}
}
