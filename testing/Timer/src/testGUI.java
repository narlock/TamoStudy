/**
 * @description GUI Class of TamoStudy
 * @author Anthony Narlock
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class testGUI extends JFrame {
	
	//Component Declaration
	private JPanel topPanel, centerPanel, botCenterPanel, botPanel;
	private JButton startButton, breakButton;
	private JLabel minuteTime, secondTime, spaceLabel, titleLabel;
	private JComboBox minuteBox, secondBox;
	
	private int min, sec, tempMin, tempSec;
	private boolean zeroMinFlag, zeroSecFlag, isStopped = false;
	private Timer timer;
	
	//private Countdown countdown;

	public testGUI() {
		
		setUpFrame();
		
		initVariables();
		
		createAspects();
		
		setUpGUI();
		
		this.setSize(500, 350);
		
	}
	
	public void setUpFrame() {
		//Sets up the GUI's frame
		this.setTitle("FOCUS - TamoStudy (version: 0.1)");
		this.setSize(500,349);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	public void initVariables() {
		topPanel = new JPanel();
		centerPanel = new JPanel();
		botCenterPanel = new JPanel();
		botPanel = new JPanel();
		
		titleLabel = new JLabel("TamoStudy");
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
		
		startButton = new JButton("Start");
		startButton.addActionListener(new ActionListener() {

			//Button Action
			@Override
			public void actionPerformed(ActionEvent e) {
				timer = new Timer(1000, new ActionListener() {

					//This is the "timer" action
					@Override
					public void actionPerformed(ActionEvent e) {
						minuteBox.setEnabled(false);
						secondBox.setEnabled(false);
						
						if(sec == 0) {
							sec = 60;
							min--;
						}
						
						if(min < 0) {
							//Display Completed message, in the future, it will do a calculation to show amount of points earned in the session
							JOptionPane.showMessageDialog(rootPane, "Session Completed", "Congratulations!", JOptionPane.INFORMATION_MESSAGE);
							
							//TODO: make methods to actually update coins and total statistics
							
							//update the timer gui
							min = 0;
							sec = 0;
							
							minuteTime.setText("0" + min);
							secondTime.setText("0" + sec);
							
							//stop timer
							minuteBox.setEnabled(true);
							secondBox.setEnabled(true);
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
			
		breakButton = new JButton("Break Focus");
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
		this.getContentPane().setLayout(new GridLayout(4,1));
		
		this.getContentPane().add(topPanel);
		this.getContentPane().add(centerPanel);
		this.getContentPane().add(botCenterPanel);
		this.getContentPane().add(botPanel);
		
		//centerPanel.setLayout(new GridLayout(1,3));
		
		addComponentsToTopPanel();
		addComponentsToCenterPanel();
		addComponentsToBotCenterPanel();
		addComponentsToBottomPanel();
	}
	
	public void addComponentsToTopPanel() {
		topPanel.add(titleLabel);
	}

	public void addComponentsToCenterPanel() {
		centerPanel.add(minuteTime);
		centerPanel.add(spaceLabel);
		centerPanel.add(secondTime);
		
	}
	
	public void addComponentsToBotCenterPanel() {
		botCenterPanel.add(minuteBox);
		botCenterPanel.add(secondBox);
	}
	
	public void addComponentsToBottomPanel() {
		botPanel.add(startButton);
		botPanel.add(breakButton);
	}
	

	
}
