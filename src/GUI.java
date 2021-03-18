/**
 * @description GUI Class of TamoStudy
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
	
	//Component Declaration
	private JPanel headPanel, top2Panel, topPanel, topCenterPanel, tamoPanel, centerPanel, botCenterPanel, botPanel;
	private JButton startButton, breakButton, statsButton, inventoryButton;
	private JLabel minuteTime, secondTime, spaceLabel, titleLabel;
	private JComboBox minuteBox, secondBox, shopBox;
	
	private int min, sec, tempMin, tempSec;
	private boolean zeroMinFlag, zeroSecFlag, isStopped = false;
	private Timer timer;

	private JLabel imageLabel;
	
	private Profile profile;
	private JLabel profileName, tamoName, tamoLevel, tamoHappiness, tamoHunger;
	private JPanel profileInfoPanel;
	

	public GUI()  {
		this.profile = new Profile();
		
		setUpFrame();
		
		initVariables();
		
		createAspects();
		
		setUpGUI();
		
		updateUserInformation(profile);
		
		this.setSize(650, 500);
		
	}
	
	public GUI(Profile p) {
		this.profile = p;
		
		setUpFrame();
		
		updateUserInformation(p);
		
		initVariables();
		
		createAspects();
		
		setUpGUI();
		
		
		this.setSize(650, 500);
	}
	
	public void setUpFrame() {
		//Sets up the GUI's frame
		//ImageIcon logo = new ImageIcon(getClass().getClassLoader().getResource("heart.png"));
		ImageIcon logo = new ImageIcon("assets/heart.png");
		
		this.setTitle("TamoStudy - alpha 0.2.0");
		this.setSize(650,499);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setIconImage(logo.getImage());
		
	}
	
	public void updateUserInformation(Profile p) {
		profileName = new JLabel("Welcome, " + p.getUsername() + "!");
		tamoName = new JLabel("" + p.getTamo().getName());
		tamoLevel = new JLabel("Level: " + p.getTamo().getLevel());
		tamoHappiness = new JLabel("Happiness: " + p.getTamo().getHappiness() + "/10");
		tamoHunger = new JLabel("Hunger: " + p.getTamo().getHunger() + "/10");
		
		updateUserInformationToFile(p);
	}

	public void initVariables()  {
		
		imageLabel = new JLabel(new ImageIcon("assets/tama_test3.png"));
		tamoPanel = new JPanel();
		
		headPanel = new JPanel();
		top2Panel = new JPanel();
		topPanel = new JPanel();
		topCenterPanel = new JPanel();
		centerPanel = new JPanel();
		botCenterPanel = new JPanel();
		botPanel = new JPanel();
		
		profileInfoPanel = new JPanel();
		
		titleLabel = new JLabel("Focus - TamoStudy");
		titleLabel.setFont(new Font ("Tahoma", Font.BOLD, 24));
		
		minuteTime = new JLabel("00");
		minuteTime.setFont(new Font ("Tahoma", Font.BOLD, 48));
		spaceLabel = new JLabel(":");
		spaceLabel.setFont(new Font ("Tahoma", Font.BOLD, 48));
		secondTime = new JLabel("00");
		secondTime.setFont(new Font ("Tahoma", Font.BOLD, 48));
		
		minuteBox = new JComboBox();
		minuteBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				minuteTime.setText(""+minuteBox.getSelectedItem());
				min = Integer.parseInt(minuteTime.getText());
			}
		});
		
		
		secondBox = new JComboBox();
		secondBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				secondTime.setText(""+secondBox.getSelectedItem());
				sec = Integer.parseInt(secondTime.getText());
			}
		});
		
		statsButton = new JButton("Statistics");
		inventoryButton = new JButton("Inventory");
		shopBox = new JComboBox();
		
		breakButton = new JButton("Break Focus");
		breakButton.setEnabled(false);
		
		startButton = new JButton("Start Focus");
		
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

	public void createAspects() {
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
		
	}
	
	public void setUpGUI() {
		this.getContentPane().setLayout(new GridLayout(5,1));
		this.getContentPane().setBackground(new Color(255,161,161));
		
		this.getContentPane().add(headPanel);
		this.getContentPane().add(topPanel);
		this.getContentPane().add(topCenterPanel);
		this.getContentPane().add(centerPanel);
		this.getContentPane().add(botCenterPanel);
		this.getContentPane().add(botPanel);
		
		tamoPanel.setLayout(new BorderLayout());
		headPanel.setLayout(new GridLayout(2,1));
		profileInfoPanel.setLayout(new GridLayout(5,1));
		
		addComponentsToTopPanel();
		addComponentsToTopCenterPanel();
		addComponentsToCenterPanel();
		addComponentsToBotCenterPanel();
		addComponentsToBottomPanel();
	}
	
	public void addComponentsToTopPanel() {
		headPanel.add(top2Panel);
		headPanel.add(topPanel);
		
		top2Panel.setLayout(new GridLayout(1,3));
		top2Panel.setBackground(new Color(255, 161, 161));
		top2Panel.add(statsButton);
		top2Panel.add(inventoryButton);
		top2Panel.add(shopBox);
		
		topPanel.setBackground(new Color(255,161,161));
		topPanel.add(profileName);
	}
	
	public void addComponentsToTopCenterPanel() {
		topCenterPanel.setLayout(new GridLayout(1,2));
		topCenterPanel.setBackground(new Color(255,161,161));
		topCenterPanel.add(tamoPanel);
		
		tamoPanel.add(imageLabel, BorderLayout.CENTER);
		tamoPanel.add(tamoName, BorderLayout.SOUTH);
		tamoName.setHorizontalAlignment(JLabel.CENTER);
		
		topCenterPanel.add(profileInfoPanel);
		
		profileInfoPanel.setBackground(new Color(255,161,161));
		//profileInfoPanel.add(profileName);
		//profileInfoPanel.add(tamoName);
		profileInfoPanel.add(tamoLevel);
		profileInfoPanel.add(tamoHappiness);
		profileInfoPanel.add(tamoHunger);
		
	}

	public void addComponentsToCenterPanel() {
		centerPanel.setBackground(new Color(255,161,161));
		centerPanel.add(minuteTime);
		centerPanel.add(spaceLabel);
		centerPanel.add(secondTime);
		
	}
	
	public void addComponentsToBotCenterPanel() {
		botCenterPanel.setBackground(new Color(255,161,161));
		botCenterPanel.add(minuteBox);
		botCenterPanel.add(secondBox);
	}
	
	public void addComponentsToBottomPanel() {
		botPanel.setBackground(new Color(255,161,161));
		botPanel.add(startButton);
		botPanel.add(breakButton);
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

	

	
}
