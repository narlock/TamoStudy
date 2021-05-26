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
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class GUI extends JFrame {
	
	/*
	 * headPanel: The top of panel of the project
	 * Components: statsButton, inventory Button, store Button
	 */
	private JPanel headPanel;
	private JButton statsButton, feedButton, backgroundShopButton, logOutButton;
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
	private JLabel tamoHappiness, tamoHunger;
	
	private JPanel profilePanel;
	private JLabel profileName;
	
	private JPanel moneyPanel;
	private JLabel moneyLabel, moneyImage;
	
	private JPanel tamoNamePanel;
	private JLabel tamoName;
	
	private JPanel tamoLevelPanel;
	private JLabel tamoLevel;
	
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
	private int min, sec, tempMin, tempSec, studyMin, studySec, studyTimeMinutes, studyTimeSeconds;
	private boolean zeroMinFlag, zeroSecFlag, isStopped = false, death;
	private String studyMessage;
	private Timer timer;
	private Profile profile;
	private int sessionMin, sessionSec;
	

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
		this.death = false;
		
		this.profile = p;
		
		setUpFrame();
		
		updateHappyHunger();
		
		//updateUserInformation(p);
		
		updateUserInformationToFile();
		
		initComponents();
		
		setUpGUI();
		
		updateGUI();
		
		if(this.death)
			tamoDeath();
		
		this.setSize(720, 535);
	}
	
	/*
	 * Sets up the JFrame and settings of Frame
	 */
	public void setUpFrame() {
		//ImageIcon logo = new ImageIcon(getClass().getClassLoader().getResource("heart.png"));
		ImageIcon logo = new ImageIcon("assets/heart.png");
		
		this.setTitle("TamoStudy | alpha 0.6.0");
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
		profileName = new JLabel(p.getLanguage().getText(1) + ", " + p.getUsername() + "!");
		tamoName = new JLabel("" + p.getTamo().getName());
		tamoLevel = new JLabel(profile.getLanguage().getText(2) + p.getTamo().getLevel());
		tamoHappiness = new JLabel("Happiness: " + p.getTamo().getHappiness() + "/10");
		tamoHunger = new JLabel("Hunger: " + p.getTamo().getHunger() + "/10");
		
		
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
	
	/*
	 * The next methods create the panels for GUI
	 */
	public void createHeadPanel() {
		//Create Head Panel
		headPanel = new JPanel();
		headPanel.setLayout(new FlowLayout());
		headPanel.setBackground(new Color(255,161,161));
				
		//Initialize Head Panel components
		statsButton = new JButton(profile.getLanguage().getText(3));
		feedButton = new JButton(profile.getLanguage().getText(4));
		backgroundShopButton = new JButton(profile.getLanguage().getText(5));
		logOutButton = new JButton(profile.getLanguage().getText(6));
		shopBox = new JComboBox();
				
		//Add Components to Head Panel
		headPanel.add(statsButton);
		headPanel.add(feedButton);
		headPanel.add(backgroundShopButton);
		headPanel.add(logOutButton);
		//headPanel.add(shopBox);
	}
	
	public void createTamoPanel() {
		spaceLabel = new JLabel();
		
		//Base Panel
		tamoPanel = new JPanel();
		tamoPanel.setLayout(new GridLayout(1,2));
		tamoPanel.setBackground(new Color(255,161,161));
				
		//LeftSidePanel
		tamoImagePanel = new JPanel();
		tamoImagePanel.setBackground(new Color(255,161,161));
				
		imageLabel = new JLabel(new ImageIcon("assets/tamo0_default.png"));
		
		backgroundImageLabel = new JLabel(new ImageIcon("assets/bg4.png"));
		setBackground(profile.getCurrentBackground());
				
		backgroundImageLabel.setLayout(new GridBagLayout());
		imageLabel.setSize(imageLabel.getPreferredSize());
		backgroundImageLabel.add(imageLabel, gbc);
				
		tamoImagePanel.add(backgroundImageLabel);
				
		//RightSidePanel
		tamoStatsPanel = new JPanel();
		tamoStatsPanel.setLayout(new GridLayout(6,1));
		tamoStatsPanel.setBackground(new Color(255,161,161));
				
		profileName = new JLabel(profile.getLanguage().getText(1) + ", " + profile.getUsername());
		if(profile.getLanguageIndicator() == 4 || profile.getLanguageIndicator() == 7)
			profileName.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		else
			profileName.setFont(new Font("Tahoma", Font.BOLD, 24));
		
		moneyPanel = new JPanel();
		moneyImage = new JLabel(new ImageIcon("assets/tamo_token.png"));
		moneyLabel = new JLabel("" + profile.getMoney());
		moneyLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		
		
		tamoName = new JLabel("Tamo: " + profile.getTamo().getName());
		tamoName.setFont(new Font("Tahoma", Font.PLAIN, 24));
		tamoLevel = new JLabel(profile.getLanguage().getText(2) + profile.getTamo().getLevel());
		tamoLevel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		
		//tamoHappiness = new JLabel("Happiness: " + profile.getTamo().getHappiness() + "/10");
		//tamoHappiness.setFont(new Font("Tahoma", Font.PLAIN, 24));
		tamoHappiness = new JLabel();
		updateTamoHappiness(profile.getTamo().getHappiness());
		
		//tamoHunger = new JLabel("Hunger: " + profile.getTamo().getHunger() + "/10");
		//tamoHunger.setFont(new Font("Tahoma", Font.PLAIN, 24));
		tamoHunger = new JLabel();
		updateTamoHunger(profile.getTamo().getHunger());
				
		tamoStatsPanel.add(profileName);
		tamoStatsPanel.add(moneyPanel);
		
		moneyPanel.setLayout(new GridLayout(1,4));
		moneyPanel.setBackground(new Color(255,161,161));
		moneyPanel.add(moneyImage);
		moneyPanel.add(moneyLabel);
		moneyPanel.add(spaceLabel);
		moneyPanel.add(spaceLabel);
		
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
				
		startButton = new JButton(profile.getLanguage().getText(7));
		breakButton = new JButton(profile.getLanguage().getText(8));
				
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
				//Initial study values
				updateTamoImage(profile.getTamo().getId(),4);
				
				studyMin = Integer.parseInt(minuteTime.getText());
				studySec = Integer.parseInt(secondTime.getText());
				System.out.println("STUDY SESSION: " + studyMin + " minutes and " + studySec + " seconds.");
				tempSec = -1;
				tempMin = 0;
				
				//Enabled and Disabled updating
				minuteBox.setEnabled(false);
				secondBox.setEnabled(false);
				startButton.setEnabled(false);
				breakButton.setEnabled(true);
				
				statsButton.setEnabled(false);
				feedButton.setEnabled(false);
				backgroundShopButton.setEnabled(false);
				logOutButton.setEnabled(false);
				
				timer = new Timer(1000, new ActionListener() {
					

					//This is the "timer" action
					@Override
					public void actionPerformed(ActionEvent e) {
						
						
						//Set how long studied for variables
						tempSec = tempSec + 1;
						if(tempSec == 60) {
							tempMin = tempMin + 1;
							tempSec = 0;
						}
						
						System.out.println(tempMin + " minutes and " + tempSec + " seconds.");
						
						if(sec == 0) {
							sec = 60;
							min--;
						}
						
						if(min < 0) {
							//Caclulate studyTime & update stats
							studyTimeMinutes = tempMin;
							studyTimeSeconds = tempSec;
							updateStudyStats(studyTimeMinutes, studyTimeSeconds);
							studyMessage = "Session Completed\nYou focused for " + studyTimeMinutes + " minute(s) and " + studyTimeSeconds + " second(s).";
							
							sessionMin = sessionMin + studyTimeMinutes;
							sessionSec = sessionSec + studyTimeSeconds;
							
							
							//Display Completed message, in the future, it will do a calculation to show amount of points earned in the session
							JOptionPane.showMessageDialog(rootPane, studyMessage, "Congratulations!", JOptionPane.INFORMATION_MESSAGE,  new ImageIcon("assets/info.png"));
							
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
				studyTimeMinutes = tempMin;
				studyTimeSeconds = tempSec;
				
				//Tamo Loses happiness upon breaking session
				if(profile.getTamo().getHappiness() > 1) {
					profile.getTamo().setHappiness(profile.getTamo().getHappiness() - 1);
				}
				
				updateStudyStats(studyTimeMinutes, studyTimeSeconds);
				studyMessage = "Session Focus Broke\nYou focused for " + studyTimeMinutes + " minute(s) and " + studyTimeSeconds + " second(s).";
				
				sessionMin = sessionMin + studyTimeMinutes;
				sessionSec = sessionSec + studyTimeSeconds;
				
				resetTimer();
				timer.stop();
				
				JOptionPane.showMessageDialog(rootPane, studyMessage, "Maybe next time...", JOptionPane.INFORMATION_MESSAGE,  new ImageIcon("assets/info.png"));
				
			}
			
			
		});
		
		
		/*
		 * Shows statistics of the profile. 
		 * Converts the minute/sec to total hours studied
		 * Converts the minute/sec of current session to hours
		 * 
		 * The data in the text file is stored via seconds, so the calculation for hours is done
		 * with a rounding of 2 decimal places
		 */
		statsButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int totalSeconds = profile.getTotalTime();
				
				double totalHours = totalSeconds * 0.000277778;
				totalHours = Math.round(totalHours * 100.0) / 100.0;	//Rounds totalHours to the nearest Hundredth
				
				double sessionTotalSeconds = (sessionMin * 60) + sessionSec;
				double totalSessionHours = sessionTotalSeconds * 0.0002777778;
				totalSessionHours = Math.round(totalSessionHours * 100.0) / 100.0;
				
				String statsMessage = profile.getLanguage().getText(9) + ": " + totalHours +
									"\n" + profile.getLanguage().getText(10) + ": " + totalSessionHours +
									"\n\n" + profile.getLanguage().getText(11) + ": " + profile.getUsername() + 
									"\n" + profile.getLanguage().getText(12) + ": " + profile.getJoinDate() +
									"\n" + profile.getLanguage().getText(13) + ": 0/30";
				
				JOptionPane.showMessageDialog(rootPane, statsMessage, profile.getLanguage().getText(3), JOptionPane.INFORMATION_MESSAGE,  new ImageIcon("assets/info.png"));
				
			}
			
		});
		
		/*
		 * Opens the Food GUI and allows user to purchase food, increasing hunger
		 */
		feedButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(profile.getTamo().getHunger() < 10) {
					foodGUI food = new foodGUI(profile);
					hideWindow();
				} else {
					JOptionPane.showMessageDialog(null, profile.getLanguage().getText(15), profile.getLanguage().getText(14), JOptionPane.INFORMATION_MESSAGE, new ImageIcon("assets/info.png"));
				}
				
			}
			
		});
		
		backgroundShopButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				bgGUI bg = new bgGUI(profile);
				hideWindow();
			}
			
		});
		
		logOutButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int resultPane = JOptionPane.showConfirmDialog(null, profile.getLanguage().getText(23), profile.getLanguage().getText(22),
						JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, new ImageIcon("assets/info.png"));
				if(resultPane == JOptionPane.OK_OPTION) {
					welcomeGUI welcome = new welcomeGUI();
					hideWindow();
					
				} else {
					System.out.println("Cancelled");
				}
				
			}
			
		});
		
		//TODO Add mini games in the future

	}
	
	public void setUpGUI() {
		this.getContentPane().setBackground(new Color(255,161,161));
		this.getContentPane().add(headPanel, BorderLayout.NORTH);
		this.getContentPane().add(tamoPanel, BorderLayout.CENTER);
		this.getContentPane().add(timerPanel, BorderLayout.SOUTH);
	}
	
	/*
	 * Method resets the timer
	 */
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
		
		statsButton.setEnabled(true);
		feedButton.setEnabled(true);
		backgroundShopButton.setEnabled(true);
		logOutButton.setEnabled(true);
		
	}
	
	
	/*
	 * Updates the profile that is in use to the profiles text file
	 * 
	 * HOW: Rewrites the changeable values to the file.
	 * This includes: totalTime, totalMoney, tamoLevel, tamoHappiness, tamoHunger.
	 * 
	 * This is for local purposes, assuming that the user does not have a lot of locally stored profiles.
	 * In the future, their may be a profile limit?
	 * 
	 * But eventually when added to a database, this method of updating system information will not be used to
	 * rewrite the locally stored profile to the database. (because it would be inefficient then)
	 */
	private void updateUserInformationToFile() {
		try {
			//BufferedReader file = new BufferedReader(new FileReader("profiles.txt"));
			BufferedReader file = new BufferedReader(new FileReader("profiles/" + profile.getUsername() + ".txt"));
			StringBuffer inputBuffer = new StringBuffer();
			String line;
			String username = "\n" + profile.getUsername();
			
			while((line = file.readLine()) != null) {
				inputBuffer.append(line);
				inputBuffer.append('\n');
			}
			
			file.close();
			String inputStr = inputBuffer.toString();
			
			System.out.println(inputStr); //DEBUG TO DISPLAY ORIGINAL FILE
			
			//split the string, by comma so username can be identified
			String[] inputtedString = inputStr.split(",");
			
			
			//I didn't know where to put the code to update the level, so it's here:
			//Every 24 hours, your tamo will gain 1 level
			int new_level = (profile.getTotalTime() / 86400);
			profile.getTamo().setLevel(new_level);
			System.out.println("tamo level is currently " + profile.getTamo().getLevel());
			
			//Rewrite TotalTime
			System.out.println("DEBUG: Rewriting Total Time = " + profile.getTotalTime());
			inputtedString[3] = String.valueOf(profile.getTotalTime());
			
			//Rewrite TotalMoney
			System.out.println("DEBUG: Rewriting Total Money = " + profile.getMoney());
			inputtedString[4] = String.valueOf(profile.getMoney());
			
			//Rewrite TotalMoney
			System.out.println("DEBUG: Rewriting name = " + profile.getTamo().getName());
			inputtedString[5] = profile.getTamo().getName();
			
			//Rewrite TamoLevel, happiness, and 
			System.out.println("DEBUG: Rewriting Level = " + profile.getTamo().getLevel());
			inputtedString[6] = String.valueOf(profile.getTamo().getLevel());
			
			System.out.println("DEBUG: Rewriting Happiness = " + profile.getTamo().getHappiness());
			inputtedString[7] = String.valueOf(profile.getTamo().getHappiness());
			
			System.out.println("DEBUG: Rewriting Hunger to = " + profile.getTamo().getHunger());
			inputtedString[8] = String.valueOf(profile.getTamo().getHunger());
			
			//Update login date
			System.out.println("DEBUG: Rewriting newloginString");
			if(profile.getNewLoginString() == null) {
				
			} else {
			inputtedString[9] = profile.getNewLoginString();
			}
			
			//Rewrite currentbackground
			System.out.println("DEBUG: Rewriting current bg");
			inputtedString[10] = String.valueOf(profile.getCurrentBackground());
			
			System.out.println("DEBUG: Rewriting guiColor");
			inputtedString[11] = profile.getGuiColor();
			
			System.out.println("DEBUG: Rewriting tamo ID");
			inputtedString[12] = String.valueOf(profile.getTamo().getId());
			
			System.out.println("DEBUG: Success");
			
			System.out.println("inputted string after:");
			for(int i = 0; i < inputtedString.length; i++) {
				System.out.println(inputtedString[i]);
			}
				
			//join the string back together
			inputStr = String.join(",", inputtedString);
			System.out.println("after rewrite: " + inputStr); //DEBUG TO DISPLAY WRITTEN FILE
			
			//FileOutputStream fileOut = new FileOutputStream("profiles.txt");
			FileOutputStream fileOut = new FileOutputStream("profiles/" + profile.getUsername() + ".txt");
			fileOut.write(inputStr.getBytes());
			fileOut.close();
			
			
			}
		catch (Exception e) {
			System.out.println("Updating user information failed due to exception." + e);
			}
		}
		
	
	
	/*
	 * Updates the totalTime studied for the user
	 */
	public void updateStudyStats(int min, int sec) {
		int totalSeconds = (min * 60) + sec;
		profile.setTotalTime(profile.getTotalTime() + totalSeconds);
		
		//Give money, every 3600 seconds (1 hour) = 50 Tamo Tokens
		//Dev Note: This means that for every 72 seconds, 1 Tamo Token is earned.
		int earnedSessionMoney = ((50 * totalSeconds) / 3600);
		profile.setMoney(profile.getMoney() + earnedSessionMoney);
		
		//Update TamoHappiness, tamoHappiness will increment by one for every half hour studied.
		int heartsEarned = 0;
		if(profile.getTamo().getHappiness() == 10) {
			// The user exceeded the amount of happiness, no happiness is rewarded since it has already been made.
		} else {
			heartsEarned = (totalSeconds / 1800);
			profile.getTamo().setHappiness(profile.getTamo().getHappiness() + heartsEarned);
		}
		
		updateGUI();
		
		updateUserInformationToFile();
	}
	
	/*
	 * Updates the GUI components
	 */
	public void updateGUI() {
		//Update Last Login Date and compare to update happiness and hunger
		//TODO
		
		//Update Labels
		
		moneyLabel.setText("" + profile.getMoney());
		
		tamoLevel.setText(profile.getLanguage().getText(2) + ": " + profile.getTamo().getLevel());
		//tamoHappiness.setText("Happiness: " + profile.getTamo().getHappiness() + "/10");
		updateTamoHappiness(profile.getTamo().getHappiness());
		
		//tamoHunger.setText("Hunger: " + profile.getTamo().getHunger()  + "/10");
		updateTamoHunger(profile.getTamo().getHunger());
		
		//Update Tamo Image
		int happy = profile.getTamo().getHappiness();
		int calcHung = profile.getTamo().getHunger();
		boolean hungry = true;
		
		if(calcHung >= 5)
			hungry = false;
		
		if(happy >= 4 && happy <= 6) {
			if(hungry)
				updateTamoImage(profile.getTamo().getId(),3);
			else
			updateTamoImage(profile.getTamo().getId(), 0);
			
		} else if (happy >= 7 && happy <= 10) {
			if(hungry)
				updateTamoImage(profile.getTamo().getId(),3);
			else
			updateTamoImage(profile.getTamo().getId(), 1);
		} else if (happy >= 1 && happy <= 3) {
			updateTamoImage(profile.getTamo().getId(), 2);
		}
		
	}
	
	/*
	 * Updates the Tamo's image based on number
	 * 0 - default
	 * 1 - happy
	 * 2 - sad
	 * 3 - hungry
	 * 4 - focus mode
	 * TODO: Get an artist to create tamo images
	 */
	public void updateTamoImage(int tamoID, int num) {
		if(tamoID == 0) {
			if(num == 0) 
				imageLabel.setIcon(new ImageIcon("assets/tamo/tamo0_default.gif"));
			else if(num == 1)
				imageLabel.setIcon(new ImageIcon("assets/tamo/tamo0_happy.png"));
			else if(num == 2)
				imageLabel.setIcon(new ImageIcon("assets/tamo/tamo0_sad.png"));
			else if(num == 3)
				imageLabel.setIcon(new ImageIcon("assets/tamo/tamo0_hungry.png"));
			else if(num == 4)
				imageLabel.setIcon(new ImageIcon("assets/tamo/tamo0_focus.png"));
			
		}
		
		if(tamoID == 1) {
			if(num == 0) 
				imageLabel.setIcon(new ImageIcon("assets/tamo/tamo1_default.gif"));
			else if(num == 1)
				imageLabel.setIcon(new ImageIcon("assets/tamo/tamo1_happy.gif"));
			else if(num == 2)
				imageLabel.setIcon(new ImageIcon("assets/tamo/tamo1_sad.png"));
			else if(num == 3)
				imageLabel.setIcon(new ImageIcon("assets/tamo/tamo1_hungry.png"));
			else if(num == 4)
				imageLabel.setIcon(new ImageIcon("assets/tamo/tamo1_focus.png"));
		}
		
	}

	/*
	 * Hides the window
	 */
	public void hideWindow() {
		this.setVisible(false);
		this.dispose();
	}

	/*
	 * Changes the Tamo's background image
	 */
	public void setBackground(int num) {
		if(num == 0)
			backgroundImageLabel.setIcon(new ImageIcon("assets/backgrounds/bg.png"));
		else if(num == 1)
			backgroundImageLabel.setIcon(new ImageIcon("assets/backgrounds/bg2.png"));
		else if(num == 2)
			backgroundImageLabel.setIcon(new ImageIcon("assets/backgrounds/bg3.png"));
		else if(num == 3)
			backgroundImageLabel.setIcon(new ImageIcon("assets/backgrounds/bg4.png"));
		else if(num == 4)
			backgroundImageLabel.setIcon(new ImageIcon("assets/backgrounds/bg5.png"));
	}
	
	/*
	 * Updates values based off of log in date
	 */
	public void updateHappyHunger() {
		System.out.println("RUNNING UPDATEHAPPYHUNGER METHOD\n--------------------------");
		
		System.out.println("DEBUG: Hunger before updateHappyHunger = " + profile.getTamo().getHunger());
		System.out.println("DEBUG: Happiness before updateHappyHunger = " + profile.getTamo().getHappiness());
		
		//will grab profile.lastLoginString and compare it to profile.newLoginString
		boolean first_day = true;
		LocalDate end = null;
		LocalDate start = null;
		
		try {
			start = LocalDate.parse(profile.getLastLoginString());
			end = LocalDate.parse(profile.getNewLoginString());
			first_day = false;
		} catch (Exception e) {
			System.out.println("NOTICE: Profile does not have a last Login string, exception *first day of profile*");
		}
		
		
		if(first_day == false) {
			long diff = ChronoUnit.DAYS.between(start,end);
			System.out.println("DEBUG: DIFFERENCE BETWEEN DAYS IS " + diff);
		if(diff == 0) {
			//If the user logs in on the same day, no changes will occur.
			System.out.println("DEBUG: Running difference = 0");
			
		} 
		
		
		if(diff == 1) {
			//If the user is logging in on a consecutive day, hunger will deplete 2 hunger points
			System.out.println("DEBUG: Running difference = 1:");
			int hungerAfterDepletion = profile.getTamo().getHunger() - 2;
			System.out.println("HUNGER AFTER DEPLETION = " + hungerAfterDepletion);
			int happinessAfterDepletion = profile.getTamo().getHappiness() - 2;
			System.out.println("HAPPY AFTER DEPLETION = " + happinessAfterDepletion);
			
			if(underEqualZero(hungerAfterDepletion)) {
				profile.getTamo().setHunger(0);
			} else {
				profile.getTamo().setHunger(hungerAfterDepletion);
			}
			
			if(underEqualZero(happinessAfterDepletion)) {
				profile.getTamo().setHappiness(1);
			} else {
				profile.getTamo().setHappiness(happinessAfterDepletion);
			}
		} 
		
		
		if(diff > 1 && diff < 4) {
			//If the user is logging in between 2 and 3 days, hunger will deplete 4, happiness deplete 2
			System.out.println("DEBUG: Running difference = 2-3:");
			int hungerAfterDepletion = (profile.getTamo().getHunger() - 4);
			System.out.println("HUNGER AFTER DEPLETION = " + hungerAfterDepletion);
			int happinessAfterDepletion = profile.getTamo().getHappiness() - 3;
			System.out.println("HAPPY AFTER DEPLETION = " + happinessAfterDepletion);
			
			System.out.println("HUNGER UNDEREQUAL ZERO VALUE: " + underEqualZero(hungerAfterDepletion));
			if(underEqualZero(hungerAfterDepletion)) {
				System.out.println("SETTING HUNGER TO ZERO");
				profile.getTamo().setHunger(0);
			} else { 
				System.out.println("SETTING HUNGER TO: " + hungerAfterDepletion);
				profile.getTamo().setHunger(hungerAfterDepletion);
			}
			
			if(underEqualZero(happinessAfterDepletion)) {
				profile.getTamo().setHappiness(1);
			} else {
				profile.getTamo().setHappiness(happinessAfterDepletion);
			}
		}
			
		if(diff > 3 && diff < 8) {
			//If the user is logging in between 4 and 7 days, hunger will deplete 5, happiness deplete 3
			System.out.println("Running difference = 4-7:");
			int hungerAfterDepletion = profile.getTamo().getHunger() - 5;
			System.out.println("HUNGER AFTER DEPLETION = " + hungerAfterDepletion);
			int happinessAfterDepletion = profile.getTamo().getHappiness() - 4;
			System.out.println("HAPPY AFTER DEPLETION = " + happinessAfterDepletion);
			
			if(underEqualZero(hungerAfterDepletion)) {
				profile.getTamo().setHunger(0);
			} else {
				profile.getTamo().setHunger(hungerAfterDepletion);
			}
			
			if(underEqualZero(happinessAfterDepletion)) {
				profile.getTamo().setHappiness(1);
			} else {
				profile.getTamo().setHappiness(happinessAfterDepletion);
			}
		}
		
		if(diff >= 8 && diff < 30) {
			//If the user does not log in for a week, hunger and happiness will be both depleted entirely
			System.out.println("Running difference = 7+:");
			profile.getTamo().setHunger(0);
			profile.getTamo().setHappiness(1);
		}

		if(diff >= 30) {
			System.out.println("Running difference = 30+:");
			//If the user does not log in for a month, the Tamo will reset (die).
			//TODO
			//Essentially the tamo data will be wiped and user will start over
			//all of the info will be reset, the tamo will be wiped, and new tamo will be assigned
			//will write to the profile file
			//profile.setWarnings(3);
			this.death = true;
			
		}
		
		System.out.println("DEBUG HUNGER AFTER FUNCTION: " + profile.getTamo().getHunger());
		System.out.println("DEBUG HAPPY AFTER FUNCTION: " + profile.getTamo().getHappiness());
		
		//Set the new date equal to the previous date here
		profile.setLast_login_date(profile.getNew_login_date());
		profile.setLastLoginString(profile.getNewLoginString());
		
		if(profile.getTamo().getHappiness() > 10)
			profile.getTamo().setHappiness(10);
		
		}
		
	}
	
	/*
	 * Method that returns if a number is less than or equal to zero
	 */
	public boolean underEqualZero(int num) {
		if(num <= 0) {
			return true;
		} else return false;
	}
	
	/*
	 * Update tamo Happiness/hunger
	 * grabs the happiness/hunger level and changes the visual image
	 */
	public void updateTamoHappiness(int happiness) {
		String str = Integer.toString(happiness);
		
		for(int i = 1; i <= happiness; i++) {
			if(i == happiness) {
				tamoHappiness.setIcon(new ImageIcon("assets/happiness/" + str +".png"));
			}
		}
	}
	
	public void updateTamoHunger(int hunger) {
		String str = Integer.toString(hunger);
		
		for(int i = 0; i <= hunger; i++) {
			if(i == hunger) {
				tamoHunger.setIcon(new ImageIcon("assets/hunger/" + str +".png"));
			}
		}
	}
	
	
	//The death of Tamo from inactivity or bad care
	public void tamoDeath() {
		System.out.println("Initiating Tamo Death");
		
		JPanel deathPanel = new JPanel();
		deathPanel.setLayout(new GridLayout(5,1));
		JLabel deathMessage = new JLabel("Your Tamo didn't receive the care it needed and has passed.");
		JLabel spaceLabel = new JLabel();
		JLabel infoMessage = new JLabel("Your statistics for your previous Tamo will be reset.");
		JLabel newTamoMessage = new JLabel("Enter new Tamo name: ");
		JTextField newTamoNameField = new JTextField(10);
		
		deathPanel.add(deathMessage);
		deathPanel.add(infoMessage);
		deathPanel.add(spaceLabel);
		deathPanel.add(newTamoMessage);
		deathPanel.add(newTamoNameField);
		
		Object[] options = {"Reset"};
		
		int resultPane = JOptionPane.showOptionDialog(null, deathPanel, "Tamo Death", JOptionPane.PLAIN_MESSAGE, JOptionPane.QUESTION_MESSAGE, new ImageIcon("assets/info.png"), options, options[0]);
		if(resultPane == 0) {
			System.out.println("Resetting Tamo");
			resetTamo(newTamoNameField.getText());
					
		} else if(resultPane == JOptionPane.CLOSED_OPTION) {
			System.out.println("Resetting Tamo using original name");
			resetTamo(profile.getTamo().getName());
		}
		
	}
	
	
	//Resets TamoStudy, will occur on after TamoDeath
	public void resetTamo(String name) {
		profile.setTotalTime(0);
		profile.setMoney(0);
		profile.setCurrentBackground(0);
		profile.getTamo().setName(name);
		profile.getTamo().setHappiness(5);
		profile.getTamo().setHunger(5);
		
		updateUserInformationToFile();
		hideWindow();
		
		GUI newGUI = new GUI(profile);
	}
	
}
