/**
 * updatedTestGUI.java
 * @author Anthony Narlock - github.com/narlock
 */

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.io.IOException;

public class updatedTestGUI extends JFrame {
	
	/**
	 *  headPanel: The top panel of the project
	 *  Components: statsButton, inventory box, store box
	 */
	private JPanel headPanel;
	private JButton statsButton;
	private JComboBox inventoryBox, storeBox;
	
	/**
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
	private JLabel profileNameLabel, moneyLabel, nameLabel, levelLabel, happyLabel, hungerLabel;
	
	/**
	 * timerPanel
	 * JPanels: timerTextPanel, timerSetPanel, timerButtonPanel
	 * timerTextPanel: the actual text of the timer counting down
	 * 		Components: minutesLabel, :label, secondsLabel
	 * timerSetPanel: combo boxes for setting the timer
	 * 		Components: minutesComboBox, secondsComboBox
	 * timerButtonPanel: start and stop
	 * 		Components: start and break buttons
	 * 
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
	
	public updatedTestGUI() {
		setUpFrame();
		
		initComponents();
		
		setUpGUI();
		
		this.setSize(720,535);
	}
	
	public void setUpFrame() {
		this.setTitle("Test GUI");
		this.setSize(720, 534);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
	}
	
	public void initComponents() {
		
		//Initializes GridBag's gridx and gridy (don't work at the moment, this is fine for now)
		this.gbc.gridx = 0;
		this.gbc.gridy = 0;
		
		createHeadPanel();
		
		createTamoPanel();
		
		createTimerPanel();
		
	}
	
	public void createHeadPanel() {
		//Create Head Panel
		headPanel = new JPanel();
		headPanel.setLayout(new FlowLayout());
		headPanel.setBackground(new Color(255,161,161));
		
		//Initialize Head Panel components
		statsButton = new JButton("Statistics");
		inventoryBox = new JComboBox();
		storeBox = new JComboBox();
		
		//Add Components to Head Panel
		headPanel.add(statsButton);
		headPanel.add(inventoryBox);
		headPanel.add(storeBox);
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
		
		profileNameLabel = new JLabel("Welcome, <profile_name>");
		profileNameLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		moneyLabel = new JLabel("Tamo Tokens: 100");
		moneyLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		nameLabel = new JLabel("Tamo: LISA");
		nameLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		levelLabel = new JLabel("Level: 0");
		levelLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		happyLabel = new JLabel("Happiness: 0/10");
		happyLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		hungerLabel = new JLabel("Hunger: 0/10");
		hungerLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		
		tamoStatsPanel.add(profileNameLabel);
		tamoStatsPanel.add(moneyLabel);
		tamoStatsPanel.add(nameLabel);
		tamoStatsPanel.add(levelLabel);
		tamoStatsPanel.add(happyLabel);
		tamoStatsPanel.add(hungerLabel);
		
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
	
	public void setUpGUI() {
		
		this.getContentPane().setBackground(new Color(255,161,161));
		this.getContentPane().add(headPanel, BorderLayout.NORTH);
		this.getContentPane().add(tamoPanel, BorderLayout.CENTER);
		this.getContentPane().add(timerPanel, BorderLayout.SOUTH);
		
		
	}
	
}
