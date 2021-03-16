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
	private JPanel topPanel, topCenterPanel, centerPanel, botCenterPanel, botPanel;
	private JButton startButton, breakButton;
	private JLabel minuteTime, secondTime, spaceLabel, titleLabel;
	private JComboBox minuteBox, secondBox;
	
	private int min, sec, tempMin, tempSec;
	private boolean zeroMinFlag, zeroSecFlag, isStopped = false;
	private Timer timer;

	private JLabel imageLabel;
	

	public GUI()  {
		
		setUpFrame();
		
		initVariables();
		
		createAspects();
		
		setUpGUI();
		
		updateUserInformation();
		
		this.setSize(500, 350);
		
	}
	
	public GUI(Profile p) {
		setUpFrame();
		
		initVariables();
		
		createAspects();
		
		setUpGUI();
		
		updateUserInformation(p);
		
		this.setSize(500, 350);
	}
	
	public void setUpFrame() {
		//Sets up the GUI's frame
		//ImageIcon logo = new ImageIcon(getClass().getClassLoader().getResource("heart.png"));
		ImageIcon logo = new ImageIcon("assets/heart.png");
		
		this.setTitle("TamoStudy - alpha 0.1.2");
		this.setSize(500,349);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setIconImage(logo.getImage());
		
	}
	
	public void initVariables()  {
		
		imageLabel = new JLabel(new ImageIcon("assets/tama_test3.png"));
		
		topPanel = new JPanel();
		topCenterPanel = new JPanel();
		centerPanel = new JPanel();
		botCenterPanel = new JPanel();
		botPanel = new JPanel();
		
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
		
		this.getContentPane().add(topPanel);
		this.getContentPane().add(topCenterPanel);
		this.getContentPane().add(centerPanel);
		this.getContentPane().add(botCenterPanel);
		this.getContentPane().add(botPanel);
		
		//centerPanel.setLayout(new GridLayout(1,3));
		
		addComponentsToTopPanel();
		addComponentsToTopCenterPanel();
		addComponentsToCenterPanel();
		addComponentsToBotCenterPanel();
		addComponentsToBottomPanel();
	}
	
	public void addComponentsToTopPanel() {
		topPanel.setBackground(new Color(255,161,161));
		topPanel.add(titleLabel);
	}
	
	public void addComponentsToTopCenterPanel() {
		topCenterPanel.setBackground(new Color(255,161,161));
		topCenterPanel.add(imageLabel);
		
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
	
	//no user information
	public void updateUserInformation() {
		
	}
	
	//with user information
	public void updateUserInformation(Profile p) {
		
	}

	
}
