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
	private JButton statsButton, feedButton, backgroundShopButton, minigameButton;
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
	private int min, sec, tempMin, tempSec, studyMin, studySec, studyTimeMinutes, studyTimeSeconds;
	private boolean zeroMinFlag, zeroSecFlag, isStopped = false;
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
		this.profile = p;
		
		setUpFrame();
		
		updateHappyHunger();
		
		updateUserInformation(p);
		
		updateUserInformationToFile();
		
		initComponents();
		
		setUpGUI();
		
		updateGUI();
		
		this.setSize(720, 535);
	}
	
	/*
	 * Sets up the JFrame and settings of Frame
	 */
	public void setUpFrame() {
		//ImageIcon logo = new ImageIcon(getClass().getClassLoader().getResource("heart.png"));
		ImageIcon logo = new ImageIcon("assets/heart.png");
		
		this.setTitle("TamoStudy - alpha 0.4.0");
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
		statsButton = new JButton("Statistics");
		feedButton = new JButton("Food Store");
		backgroundShopButton = new JButton("Background Store");
		minigameButton = new JButton("Minigames (Coming soon)");
		shopBox = new JComboBox();
				
		//Add Components to Head Panel
		headPanel.add(statsButton);
		headPanel.add(feedButton);
		headPanel.add(backgroundShopButton);
		headPanel.add(minigameButton);
		//headPanel.add(shopBox);
	}
	
	public void createTamoPanel() {
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
				
		profileName = new JLabel("Welcome, " + profile.getUsername());
		profileName.setFont(new Font("Tahoma", Font.BOLD, 24));
		moneyLabel = new JLabel("Tamo Tokens: " + profile.getMoney());
		moneyLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		tamoName = new JLabel("Tamo: " + profile.getTamo().getName());
		tamoName.setFont(new Font("Tahoma", Font.PLAIN, 24));
		tamoLevel = new JLabel("Level: " + profile.getTamo().getLevel());
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
				//Initial study values
				updateTamoImage(0,4);
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
				//minigameButton.setEnabled(false);
				
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
							JOptionPane.showMessageDialog(rootPane, studyMessage, "Congratulations!", JOptionPane.INFORMATION_MESSAGE);
							
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
				updateStudyStats(studyTimeMinutes, studyTimeSeconds);
				studyMessage = "Session Focus Broke\nYou focused for " + studyTimeMinutes + " minute(s) and " + studyTimeSeconds + " second(s).";
				
				sessionMin = sessionMin + studyTimeMinutes;
				sessionSec = sessionSec + studyTimeSeconds;
				
				resetTimer();
				timer.stop();
				
				JOptionPane.showMessageDialog(rootPane, studyMessage, "Maybe next time...", JOptionPane.INFORMATION_MESSAGE);
				
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
				
				String statsMessage = "Total Hours: " + totalHours +
									"\nTotal Hours in Session: " + totalSessionHours +
									"\n\nUser: " + profile.getUsername() + "\nJoin Date: " + profile.getJoinDate() +
									"\nAchievements: 0/30";
				
				JOptionPane.showMessageDialog(rootPane, statsMessage, "Statistics", JOptionPane.INFORMATION_MESSAGE);
				
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
					JOptionPane.showMessageDialog(null, "Your Tamo is full!", "Can't enter food shop", JOptionPane.INFORMATION_MESSAGE);
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
		
		
		//TODO Add mini games in the future
		minigameButton.setEnabled(false);

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
		//minigameButton.setEnabled(true);
		
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
			System.out.println("DEBUG: Rewriting Total Time");
			inputtedString[3] = String.valueOf(profile.getTotalTime());
			
			//Rewrite TotalMoney
			System.out.println("DEBUG: Rewriting Total Money");
			inputtedString[4] = String.valueOf(profile.getMoney());
			
			//Rewrite TamoLevel, happiness, and 
			System.out.println("DEBUG: Rewriting Level");
			inputtedString[6] = String.valueOf(profile.getTamo().getLevel());
			
			System.out.println("DEBUG: Rewriting Happiness");
			inputtedString[7] = String.valueOf(profile.getTamo().getHappiness());
			
			System.out.println("DEBUG: Rewriting Hunger");
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
		
		moneyLabel.setText("Tamo Tokens: " + profile.getMoney());
		
		tamoLevel.setText("Level: " + profile.getTamo().getLevel());
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
				updateTamoImage(0,3);
			else
			updateTamoImage(0, 0);
			
		} else if (happy >= 7 && happy <= 10) {
			if(hungry)
				updateTamoImage(0,3);
			else
			updateTamoImage(0, 1);
		} else if (happy >= 1 && happy <= 3) {
			updateTamoImage(0, 2);
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
	public void updateTamoImage(int tamaID, int num) {
		if(tamaID == 0) {
			if(num == 0) 
				imageLabel.setIcon(new ImageIcon("assets/tamo0_default.png"));
			else if(num == 1)
				imageLabel.setIcon(new ImageIcon("assets/tamo0_happy.png"));
			else if(num == 2)
				imageLabel.setIcon(new ImageIcon("assets/tamo0_sad.png"));
			else if(num == 3)
				imageLabel.setIcon(new ImageIcon("assets/tamo0_hungry.png"));
			else if(num == 4)
				imageLabel.setIcon(new ImageIcon("assets/tamo0_focus.png"));
			
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
			backgroundImageLabel.setIcon(new ImageIcon("assets/bg.png"));
		else if(num == 1)
			backgroundImageLabel.setIcon(new ImageIcon("assets/bg2.png"));
		else if(num == 2)
			backgroundImageLabel.setIcon(new ImageIcon("assets/bg3.png"));
		else if(num == 3)
			backgroundImageLabel.setIcon(new ImageIcon("assets/bg4.png"));
		else if(num == 4)
			backgroundImageLabel.setIcon(new ImageIcon("assets/bg5.png"));
	}
	
	/*
	 * Updates values based off of log in date
	 */
	public void updateHappyHunger() {
		//will grab profile.lastLoginString and compare it to profile.newLoginString
		boolean first_day = true;
		LocalDate end = null;
		LocalDate start = null;
		
		try {
			start = LocalDate.parse(profile.getLastLoginString());
			end = LocalDate.parse(profile.getNewLoginString());
			first_day = false;
		} catch (Exception e) {
			System.out.println("Profile does not have a last Login string, exception *first day of profile*");
		}
		
		
		if(first_day == false) {
			long diff = ChronoUnit.DAYS.between(start,end);
			//System.out.println("test: difference between lastLogin and newLogin are " + diff + " days.");
		if(diff == 0) {
			//If the user logs in on the same day, no changes will occur.
		} else if(diff == 1) {
			//If the user is logging in on a consecutive day, hunger will deplete 3 hunger points
			int hungerAfterDepletion = profile.getTamo().getHunger() - 2;
			
			if(underEqualZero(hungerAfterDepletion)) {
				profile.getTamo().setHunger(0);
			} else {
				profile.getTamo().setHunger(hungerAfterDepletion);
			}
		} else if(diff > 1 && diff < 4) {
			//If the user is logging in between 2 and 3 days, hunger will deplete 4, happiness deplete 2
			int hungerAfterDepletion = profile.getTamo().getHunger() - 3;
			int happinessAfterDepletion = profile.getTamo().getHappiness() - 2;
			
			if(underEqualZero(hungerAfterDepletion)) {
				profile.getTamo().setHunger(0);
			} else {
				profile.getTamo().setHunger(hungerAfterDepletion);
			}
			
			if(underEqualZero(happinessAfterDepletion)) {
				profile.getTamo().setHappiness(1);
			} else {
				profile.getTamo().setHunger(happinessAfterDepletion);
			}
		} else if(diff > 4 && diff < 8) {
			//If the user is logging in between 4 and 7 days, hunger will deplete 5, happiness deplete 3
			int hungerAfterDepletion = profile.getTamo().getHunger() - 5;
			int happinessAfterDepletion = profile.getTamo().getHappiness() - 3;
			
			if(underEqualZero(hungerAfterDepletion)) {
				profile.getTamo().setHunger(0);
			} else {
				profile.getTamo().setHunger(hungerAfterDepletion);
			}
			
			if(underEqualZero(happinessAfterDepletion)) {
				profile.getTamo().setHappiness(1);
			} else {
				profile.getTamo().setHunger(happinessAfterDepletion);
			}
		} else if(diff > 8) {
			//If the user does not log in for a week, hunger and happiness will be both depleted entirely
			profile.getTamo().setHunger(0);
			profile.getTamo().setHappiness(1);

		} else if(diff > 30) {
			//If the user does not log in for a month, the Tamo will reset (die).
			//TODO
			//Essentially the tamo data will be wiped and user will start over
			//all of the info will be reset, the tamo will be wiped, and new tamo will be assigned
			//will write to the profile file
		}
		}
		
		//Set the new date equal to the previous date here
		profile.setLast_login_date(profile.getNew_login_date());
		profile.setLastLoginString(profile.getNewLoginString());
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
}
