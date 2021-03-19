/**
 * @description Main and GUI Class of TamoStudy
 * @author Anthony Narlock
 */

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.io.IOException;

public class GUI extends JFrame {
	
	/*
	 * headPanel: The top of panel of the project
	 * Components: statsButton, inventory Button, store Button
	 */
	private JPanel headPanel;
	private JButton statsButton, inventoryButton;
	private JComboBox shopBox;
	
	/*
	 * tamoPanel
	 * JPanels: tamoImagePanel(left) and tamoStatsPanel(right)
	 * tamoImagePanel: image of tamo with background
	 * 		Components: tamoImage and background image
	 * tamoStatsPanel: labels with basic stats of tamo
	 * 		Components: profileNameLabel, nameLabel, levelLabel, happy and hunger labels
	 */
	private JPanel tamoPanel;
	
	private JPanel tamoImagePanel;
	private JLabel imageLabel, backgroundImageLabel;
	
	private JPanel tamoStatsPanel;
	private JLabel profileName, moneyLabel, tamoName, tamoLevel, tamoHappiness, tamoHunger;
	
	/*
	 * timerPanel
	 * JPanels: timerTextPanel, timerSetPanel, timerButtonPanel
	 * timerTextPanel: the actual text of timer counting down
	 * 		Components: minutesLabel, spaceLabel, secondsLabel
	 * timerSetPanel: combo boxes for settings the timer
	 * 		Components: minutesComboBox, secondsComboBox
	 * timerButtonPanel: start and stop
	 * 		Components: start and break buttons
	 */
	
	private JPanel timerPanel;
	
	private JPanel timerTextPanel;
	private JLabel minuteTime, secondTime, spaceLabel;
	
	private JPanel timerSetPanel;
	private JComboBox minuteBox, secondBox;
	
	private JPanel timerButtonPanel;
	private JButton startButton, breakButton;
	
	//GridBagConstraints for the Tamo's image and background labels
	private GridBagConstraints gbc = new GridBagConstraints();
	
	//private JPanel top2Panel, topPanel, topCenterPanel, centerPanel, botCenterPanel, botPanel;
	
	/*
	 * Variables
	 */
	private int min, sec, tempMin, tempSec;
	private boolean zeroMinFlag, zeroSecFlag, isStopped = false;
	private Timer timer;
	private Profile profile;
	

	/*
	 * Default Constructor, profile will be null
	 */
	public GUI()  {
		this.profile = new Profile();
		
		setUpFrame();
		
		initComponents();
		
		setUpGUI();
		
		updateUserInformation(profile);
		
		this.setSize(720, 535);
		
	}
	
	/*
	 * Main constructor, profile is set according to what is called
	 */
	public GUI(Profile p) {
		this.profile = p;
		
		setUpFrame();
		
		updateUserInformation(p);
		
		initComponents();
		
		setUpGUI();
		
		
		this.setSize(720, 535);
	}
	
	/*
	 * Sets up the JFrame and settings of Frame
	 */
	public void setUpFrame() {
		//ImageIcon logo = new ImageIcon(getClass().getClassLoader().getResource("heart.png"));
		ImageIcon logo = new ImageIcon("assets/heart.png");
		
		this.setTitle("TamoStudy - alpha 0.2.2");
		this.setSize(720,534);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setIconImage(logo.getImage());
		
	}
	
	/*
	 * Updates the user information labels and writes them back to the file
	 */
	public void updateUserInformation(Profile p) {
		profileName = new JLabel("Welcome, " + p.getUsername() + "!");
		tamoName = new JLabel("" + p.getTamo().getName());
		tamoLevel = new JLabel("Level: " + p.getTamo().getLevel());
		tamoHappiness = new JLabel("Happiness: " + p.getTamo().getHappiness() + "/10");
		tamoHunger = new JLabel("Hunger: " + p.getTamo().getHunger() + "/10");
		
		updateUserInformationToFile(p);
		
	}

	/*
	 * Calls methods that initialize each individual panel
	 */
	public void initComponents()  {
		
		//Initializes GridBag's gridx and gridy (don't work at the moment, this is fine for now)
		this.gbc.gridx = 0;
		this.gbc.gridy = 0;
		
		createHeadPanel();
		
		createTamoPanel();
		
		createTimerPanel();
		
		initActions();
		
		
	}
	
	public void createHeadPanel() {
		//Create Head Panel
		headPanel = new JPanel();
		headPanel.setLayout(new FlowLayout());
		headPanel.setBackground(new Color(255,161,161));
				
		//Initialize Head Panel components
		statsButton = new JButton("Statistics");
		inventoryButton = new JButton("Inventory");
		shopBox = new JComboBox();
				
		//Add Components to Head Panel
		headPanel.add(statsButton);
		headPanel.add(inventoryButton);
		headPanel.add(shopBox);
	}
	
	public void createTamoPanel() {
		//Base Panel
		tamoPanel = new JPanel();
		tamoPanel.setLayout(new GridLayout(1,2));
		tamoPanel.setBackground(new Color(255,161,161));
				
		//LeftSidePanel
		tamoImagePanel = new JPanel();
		tamoImagePanel.setBackground(new Color(255,161,161));
				
		imageLabel = new JLabel(new ImageIcon("assets/tama_test4.png"));
		backgroundImageLabel = new JLabel(new ImageIcon("assets/bg.png"));
				
		backgroundImageLabel.setLayout(new GridBagLayout());
		imageLabel.setSize(imageLabel.getPreferredSize());
		backgroundImageLabel.add(imageLabel, gbc);
				
		tamoImagePanel.add(backgroundImageLabel);
				
		//RightSidePanel
		tamoStatsPanel = new JPanel();
		tamoStatsPanel.setLayout(new GridLayout(6,1));
		tamoStatsPanel.setBackground(new Color(255,161,161));
				
		profileName = new JLabel("Welcome, " + profile.getUsername());
		profileName.setFont(new Font("Tahoma", Font.BOLD, 24));
		moneyLabel = new JLabel("Tamo Tokens: " + profile.getMoney());
		moneyLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		tamoName = new JLabel("Tamo: " + profile.getTamo().getName());
		tamoName.setFont(new Font("Tahoma", Font.PLAIN, 24));
		tamoLevel = new JLabel("Level: " + profile.getTamo().getLevel());
		tamoLevel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		tamoHappiness = new JLabel("Happiness: " + profile.getTamo().getHappiness() + "/10");
		tamoHappiness.setFont(new Font("Tahoma", Font.PLAIN, 24));
		tamoHunger = new JLabel("Hunger: " + profile.getTamo().getHunger() + "/10");
		tamoHunger.setFont(new Font("Tahoma", Font.PLAIN, 24));
				
		tamoStatsPanel.add(profileName);
		tamoStatsPanel.add(moneyLabel);
		tamoStatsPanel.add(tamoName);
		tamoStatsPanel.add(tamoLevel);
		tamoStatsPanel.add(tamoHappiness);
		tamoStatsPanel.add(tamoHunger);
				
		//Add panels
		tamoPanel.add(tamoImagePanel);
		tamoPanel.add(tamoStatsPanel);
	}
	
	public void createTimerPanel() {
		//Base Panel
		timerPanel = new JPanel();
		timerPanel.setLayout(new BorderLayout());
		timerPanel.setBackground(new Color(255,161,161));
				
		//timerTextPanel
		timerTextPanel = new JPanel();
		timerTextPanel.setBackground(new Color(255,161,161));
				
		minuteTime = new JLabel("00");
		minuteTime.setFont(new Font ("Tahoma", Font.BOLD, 48));
		spaceLabel = new JLabel(":");
		spaceLabel.setFont(new Font ("Tahoma", Font.BOLD, 48));
		secondTime = new JLabel("00");
		secondTime.setFont(new Font ("Tahoma", Font.BOLD, 48));
				
		timerTextPanel.add(minuteTime);
		timerTextPanel.add(spaceLabel);
		timerTextPanel.add(secondTime);
				
		//timerSetPanel
		timerSetPanel = new JPanel();
		timerSetPanel.setBackground(new Color(255,161,161));
				
		minuteBox = new JComboBox();
		secondBox = new JComboBox();
				
		timerSetPanel.add(minuteBox);
		timerSetPanel.add(secondBox);
				
		//timerButtonPanel
		timerButtonPanel = new JPanel();
		timerButtonPanel.setBackground(new Color(255,161,161));
				
		startButton = new JButton("Start Focus");
		breakButton = new JButton("Break Focus");
				
		timerButtonPanel.add(startButton);
		timerButtonPanel.add(breakButton);
				
		//Add panels
		timerPanel.add(timerTextPanel,BorderLayout.NORTH);
		timerPanel.add(timerSetPanel,BorderLayout.CENTER);
		timerPanel.add(timerButtonPanel,BorderLayout.SOUTH);
	}
	
	public void initActions() {
		//Init visibility
		breakButton.setEnabled(false);
		
		//Init Timer Combo Box items
		for(int i = 0; i <= 60; i++) {
			if(i < 10) {
				minuteBox.addItem("0" + i);
				secondBox.addItem("0" + i);
			}
			else {
				minuteBox.addItem(i);
				secondBox.addItem(i);
			}
			
		}
		
		//Combo box actions - update on selection
		minuteBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				minuteTime.setText(""+minuteBox.getSelectedItem());
				min = Integer.parseInt(minuteTime.getText());
			}
		});
		
		secondBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				secondTime.setText(""+secondBox.getSelectedItem());
				sec = Integer.parseInt(secondTime.getText());
			}
		});
		
		//Start and Break button actions
		startButton.addActionListener(new ActionListener() {

			//Button Action
			@Override
			public void actionPerformed(ActionEvent e) {
				timer = new Timer(1000, new ActionListener() {

					//This is the "timer" action
					@Override
					public void actionPerformed(ActionEvent e) {
						//Enabled and Disabled updating
						minuteBox.setEnabled(false);
						secondBox.setEnabled(false);
						startButton.setEnabled(false);
						breakButton.setEnabled(true);
						
						if(sec == 0) {
							sec = 60;
							min--;
						}
						
						if(min < 0) {
							//Display Completed message, in the future, it will do a calculation to show amount of points earned in the session
							JOptionPane.showMessageDialog(rootPane, "Session Completed\nYou focused for _ minutes", "Congratulations!", JOptionPane.INFORMATION_MESSAGE);
							
							//TODO: make methods to actually update coins and total statistics
							
							resetTimer();
							timer.stop();
						} 
						else {
							sec--;
							if(sec < 10) {
								secondTime.setText("0" + sec);
								zeroSecFlag = false;
							}
							else {
								secondTime.setText("" + sec);
							}
							if(min < 10) {
								minuteTime.setText("0" + min);
								zeroMinFlag = false;
							}
							else {
								minuteTime.setText("" + min);
							}
						}
					}
					
				});
				timer.start();
				
			}
			
		});
		
		breakButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				resetTimer();
				timer.stop();
				
				JOptionPane.showMessageDialog(rootPane, "Session Focus Broke\nYou focused for _ minutes", "Maybe next time...", JOptionPane.INFORMATION_MESSAGE);
				
			}
			
			
		});
	}

	
	public void setUpGUI() {
		this.getContentPane().setBackground(new Color(255,161,161));
		this.getContentPane().add(headPanel, BorderLayout.NORTH);
		this.getContentPane().add(tamoPanel, BorderLayout.CENTER);
		this.getContentPane().add(timerPanel, BorderLayout.SOUTH);
	}
	
	public void resetTimer() {
		min = 0;
		sec = 0;
		
		minuteTime.setText("0" + min);
		secondTime.setText("0" + sec);
		
		minuteBox.setSelectedIndex(0);
		secondBox.setSelectedIndex(0);
		
		//stop 
		minuteBox.setEnabled(true);
		secondBox.setEnabled(true);
		startButton.setEnabled(true);
		breakButton.setEnabled(false);
		
	}
	
	private void updateUserInformationToFile(Profile p) {
		// TODO Auto-generated method stub
		
	}
	
	/*
	 * Updates the Tamo's image based on number
	 * 0 - default
	 * 1 - happy
	 * 2 - very happy
	 * 3 - sad
	 * 4 - hungry
	 * TODO: Get an artist to create tamo images
	 */
	public void updateTamoImage(int tamaID, int num) {
		if(tamaID == 0) {
			if(num == 0) 
				imageLabel.setIcon(new ImageIcon("assets/tamo0_default.png"));
			else if(num == 1)
				imageLabel.setIcon(new ImageIcon("assets/tamo0_happy.png"));
			else if(num == 2)
				imageLabel.setIcon(new ImageIcon("assets/tamo0_veryHappy.png"));
			else if(num == 3)
				imageLabel.setIcon(new ImageIcon("assets/tamo0_sad.png"));
			else if(num == 4)
				imageLabel.setIcon(new ImageIcon("assets/tamo0_hungry.png"));
			
		}
		
	}

	

	
}
