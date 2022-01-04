/**
 * @description Main and GUI Class of TamoStudy
 * @author Anthony Narlock
 */

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.net.URL;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.io.IOException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.ThreadLocalRandom;
import javax.sound.sampled.*;

public class GUI extends JFrame {
	
	/*
	 * headPanel: The top of panel of the project
	 * Components: statsButton, inventory Button, store Button
	 */
	private JPanel headPanel;
	private JMenuBar headMenu;
	private JMenu profileMenu;
	private JMenuItem statsButton, inventoryButton, ahmButton, optionsButton;
	
	private JButton feedButton, backgroundShopButton, logOutButton;
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
	private JComboBox fiveIntervalBox;
	
	private JLabel pomoNumberSessionLabel, pomoSessionLabel, pomoBreakLabel;
	private JLabel currentSessionLabel;
	private JComboBox pomoNumberSessionBox, pomoSessionBox, pomoBreakBox;
	private int pomoSessionNumber, currentSession;
	private boolean breakCondition;
	
	private JPanel timerButtonPanel;
	private JButton startButton, breakButton;
	
	//GridBagConstraints for the Tamo's image and background labels
	private GridBagConstraints gbc = new GridBagConstraints();
	
	//private JPanel top2Panel, topPanel, topCenterPanel, centerPanel, botCenterPanel, botPanel;
	
	/*
	 * Variables
	 */
	private int min, sec, tempMin, tempSec, studyMin, studySec, studyTimeMinutes, studyTimeSeconds;
	private boolean zeroMinFlag, zeroSecFlag, isStopped = false, death, soundsEnabled;
	private String studyMessage;
	private Timer timer;
	private Profile profile;
	private int sessionMin, sessionSec;
	
	private File profileFile;
	private Encryption encryption;
	

	/*
	 * Default Constructor, profile will be null
	 */
	public GUI()  {
		this.profile = new Profile();
		
		setUpFrame();
		
		initComponents();
		
		setUpGUI();
		
		this.setSize(720, 550);
		
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
		
		if(profile.getSettings().getFocusMode() == 2) {
			this.setSize(720,650);
			this.setLocationRelativeTo(null);
		} else {
			this.setSize(720, 550);
		}
	}
	
	public GUI(Profile p, File file) {
		this.death = false;
		this.profile = p;
		this.profileFile = file;
		encryption = new Encryption();
		
		setUpFrame();
		
		updateHappyHunger();
		
		achievementUpdates();
		
		updateUserInformationToFile();
		
		initComponents();
		
		setUpGUI();
		
		updateGUI();
		
		if(this.death)
			tamoDeath();

		if(profile.getSettings().getFocusMode() == 2) {
			this.setSize(720,650);
			this.setLocationRelativeTo(null);
		} else {
			this.setSize(720, 550);
		}
	}
	
	/*
	 * Sets up the JFrame and settings of Frame
	 */
	public void setUpFrame() {
		//ImageIcon logo = new ImageIcon(getClass().getClassLoader().getResource("heart.png"));
		ImageIcon logo = new ImageIcon(getClass().getClassLoader().getResource("ico.png"));
		
		UIManager UI = new UIManager();
		UI.put("OptionPane.background", profile.getColor());
		UI.put("Panel.background", profile.getColor());
		
		this.setTitle("TamoStudy | beta 3.0");
		this.setSize(720,549);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setIconImage(logo.getImage());
		
	}
	
	/*
	 * Calls methods that initialize each individual panel
	 */
	public void initComponents()  {
		
		createHeadPanel();
		
		createTamoPanel();
		
		createTimerPanel();
		
		initActions();
		
		initButtonVisuals();
	}
	
	/*
	 * The next methods create the panels for GUI
	 */
	public void createHeadPanel() {
		//Create Head Panel
		headPanel = new JPanel();
		headPanel.setLayout(new FlowLayout());
		headPanel.setBackground(profile.getColor());
		
		headMenu = new JMenuBar();
		if(System.getProperty("os.name").startsWith("Windows"))
			headMenu.setBackground(Color.WHITE);
		profileMenu = new JMenu("Profile");	
		
		//Initialize Head Panel components
		statsButton = new JMenuItem(profile.getSettings().getLang().getText(5), new ImageIcon(getClass().getClassLoader().getResource("menu-stats.png")));
		optionsButton = new JMenuItem(profile.getSettings().getLang().getText(8), new ImageIcon(getClass().getClassLoader().getResource("menu-options.png")));
		ahmButton = new JMenuItem(profile.getSettings().getLang().getText(21), new ImageIcon(getClass().getClassLoader().getResource("menu-ahm.png")));
		inventoryButton = new JMenuItem("Inventory", new ImageIcon(getClass().getClassLoader().getResource("menu-inventory.png")));
		
		//Other Menu Options
		feedButton = new JButton(profile.getSettings().getLang().getText(6));
		backgroundShopButton = new JButton(profile.getSettings().getLang().getText(7));
		logOutButton = new JButton(profile.getSettings().getLang().getText(9));

		shopBox = new JComboBox();
		
		profileMenu.add(statsButton);
		profileMenu.add(inventoryButton);
		profileMenu.add(ahmButton);
		profileMenu.add(optionsButton);
		
		
		headMenu.add(profileMenu);
		headMenu.add(feedButton);
		headMenu.add(backgroundShopButton);
		headMenu.add(logOutButton);
		
		//Add Components to Head Panel
		headPanel.add(headMenu);

	}
	

	
	public void createTamoPanel() {
		spaceLabel = new JLabel();
		
		//Base Panel
		tamoPanel = new JPanel();
		tamoPanel.setLayout(new GridLayout(1,2));
		tamoPanel.setBackground(profile.getColor());
				
		//LeftSidePanel
		tamoImagePanel = new JPanel();
		tamoImagePanel.setBackground(profile.getColor());
				
		imageLabel = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("tamo0_default.png")));
		backgroundImageLabel = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("bg4.png")));
		
		setBackground(profile.getCurrentBackground());
				
		backgroundImageLabel.setLayout(new GridBagLayout());
		imageLabel.setSize(imageLabel.getPreferredSize());
		backgroundImageLabel.add(imageLabel, gbc);
				
		tamoImagePanel.add(backgroundImageLabel);
				
		//RightSidePanel
		tamoStatsPanel = new JPanel();
		tamoStatsPanel.setLayout(new GridLayout(6,1));
		tamoStatsPanel.setBackground(profile.getColor());
				
		profileName = new JLabel(profile.getSettings().getLang().getText(1) + ", " + profile.getUsername());
		if(profile.getSettings().getLang().getIndicator() == 4 || profile.getSettings().getLang().getIndicator() == 7)
			profileName.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		else
			profileName.setFont(new Font("Tahoma", Font.BOLD, 24));
		
		moneyPanel = new JPanel();
		moneyImage = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("tamo_token.png")));
		moneyLabel = new JLabel("" + profile.getMoney());
		moneyLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		
		
		tamoName = new JLabel("Tamo: " + profile.getTamo().getName());
		tamoName.setFont(new Font("Tahoma", Font.PLAIN, 24));
		tamoLevel = new JLabel(profile.getSettings().getLang().getText(2) + profile.getTamo().getLevel());
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
		moneyPanel.setBackground(profile.getColor());
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
				
		//timerTextPanel
		timerTextPanel = new JPanel();
		timerTextPanel.setBackground(profile.getColorDark());
				
		minuteTime = new JLabel("00");
		minuteTime.setFont(new Font ("Tahoma", Font.BOLD, 52));
		spaceLabel = new JLabel(":");
		spaceLabel.setFont(new Font ("Tahoma", Font.BOLD, 52));
		secondTime = new JLabel("00");
		secondTime.setFont(new Font ("Tahoma", Font.BOLD, 52));
				
		timerTextPanel.add(minuteTime);
		timerTextPanel.add(spaceLabel);
		timerTextPanel.add(secondTime);
				
		//timerSetPanel
		timerSetPanel = new JPanel();
		timerSetPanel.setBackground(profile.getColorDark());
		
		/*
		 * Different Combo Boxes
		 * minute/secondBox represent the custom time
		 * fiveIntervalBox represents the default option which is times of 5 minute intervals
		 */
				
		minuteBox = new JComboBox();
		secondBox = new JComboBox();
		
		minuteBox.setVisible(false);
		minuteBox.setBackground(Color.WHITE);
		secondBox.setVisible(false);
		secondBox.setBackground(Color.WHITE);
		
		fiveIntervalBox = new JComboBox();
		fiveIntervalBox.setBackground(Color.WHITE);
		
		if(profile.getSettings().getFocusMode() == 1 || profile.getSettings().getFocusMode() == 0) {
			timerSetPanel.add(minuteBox);
			timerSetPanel.add(secondBox);
			timerSetPanel.add(fiveIntervalBox);
		}
		
		currentSessionLabel = new JLabel("Let's Focus!");
		currentSessionLabel.setFont(new Font ("Tahoma", Font.BOLD, 20));
		
		pomoNumberSessionLabel = new JLabel("# Of Sessions");
		pomoNumberSessionBox = new JComboBox();
		
		pomoSessionLabel = new JLabel("Session Length");
		pomoSessionBox = new JComboBox();
		pomoBreakLabel = new JLabel("Break Length");
		pomoBreakBox = new JComboBox();
		pomoSessionBox.setBackground(Color.WHITE);
		pomoBreakBox.setBackground(Color.WHITE);
		
		if(profile.getSettings().getFocusMode() == 2 ) {
			
			timerSetPanel.setLayout(new GridLayout(2,1));
			
			//Main Panels
			JPanel topSetPanel = new JPanel();
				topSetPanel.setLayout(new GridLayout(2,1));
				topSetPanel.setBackground(profile.getColorDark());
				JPanel topSetPanelTop = new JPanel();
					topSetPanelTop.setBackground(profile.getColorDark());
					JPanel topNumPanel = new JPanel();
						topNumPanel.setBackground(profile.getColorDark());
					JPanel topSessionPanel = new JPanel();
						topSessionPanel.setBackground(profile.getColorDark());
					JPanel topBreakPanel = new JPanel();
						topBreakPanel.setBackground(profile.getColorDark());
				JPanel topSetPanelBot = new JPanel();
					topSetPanelBot.setBackground(profile.getColorDark());
					//The Current Session Label is on this Panel
				
			JPanel botSetPanel = new JPanel();
				botSetPanel.setBackground(profile.getColorDark());
			JPanel numSessionPanel = new JPanel();
				numSessionPanel.setBackground(profile.getColorDark());
			
			JPanel botNumPanel = new JPanel();
				botNumPanel.setBackground(profile.getColorDark());
			JPanel botSessionPanel = new JPanel();
				botSessionPanel.setBackground(profile.getColorDark());
			JPanel botBreakPanel = new JPanel();
				botBreakPanel.setBackground(profile.getColorDark());
			
			
			timerSetPanel.add(topSetPanel);
			topSetPanel.add(topSetPanelBot);
				topSetPanelBot.add(currentSessionLabel);	
			topSetPanel.add(topSetPanelTop);
					topSetPanelTop.add(topNumPanel);
						topNumPanel.add(pomoNumberSessionLabel);
					topSetPanelTop.add(topSessionPanel);
						topSessionPanel.add(pomoSessionLabel);
					topSetPanelTop.add(topBreakPanel);
						topBreakPanel.add(pomoBreakLabel);
				
			timerSetPanel.add(botSetPanel);
				botSetPanel.add(botNumPanel);
					botNumPanel.add(pomoNumberSessionBox);
				botSetPanel.add(botSessionPanel);
					botSessionPanel.add(pomoSessionBox);
				botSetPanel.add(botBreakPanel);
					botBreakPanel.add(pomoBreakBox);
		}
		
		
		
		/*
		 * Set Enabled Timer Method:
		 * This will call a method that will automatically update the GUI based off of the timer selection.
		 * TODO:
		 * setEnabledTimerMethod();
		 */
				
		//timerButtonPanel
		timerButtonPanel = new JPanel();
		timerButtonPanel.setBackground(profile.getColorDark());
				
		startButton = new JButton(profile.getSettings().getLang().getText(3));
		breakButton = new JButton(profile.getSettings().getLang().getText(4));

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
				secondBox.addItem("0" + i);
			}
			else {
				secondBox.addItem(i);
			}
			
		}
		
		for(int i = 0; i <= 90; i++) {
			if(i < 10) {
				minuteBox.addItem("0" + i);
			} else {
				minuteBox.addItem(i);
			}
		}
		
		//Init 5 Increment Combo Box Items
		for(int i = 5; i <= 90; i = i + 5) {
			if(i == 5)
				fiveIntervalBox.addItem("0" + i + ":00");
			else
				fiveIntervalBox.addItem(i + ":00");
		}
		
		//Init Pomodoro Box Items
		for(int i = 5; i <= 60; i = i + 5) {
			if(i == 5) {
				pomoSessionBox.addItem("0" + i + ":00");
				pomoBreakBox.addItem("0" + i + ":00");
			}
			else {
				pomoSessionBox.addItem(i + ":00");
				pomoBreakBox.addItem(i + ":00");
			}
		}
		
		
		for(int i = 1; i <= 16; i++) {
			pomoNumberSessionBox.addItem(i);
			breakCondition = false;
		}
		
		pomoNumberSessionBox.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				pomoSessionNumber = pomoNumberSessionBox.getSelectedIndex();
				System.out.println("pomoSessions: " + pomoSessionNumber);
			}
			
		});
		
		
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
		
		fiveIntervalBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				minuteTime.setText(""+fiveIntervalBox.getSelectedItem());
				minuteTime.setText(minuteTime.getText().substring(0,2));
				min = Integer.parseInt(minuteTime.getText());
				sec = Integer.parseInt(secondTime.getText());
			}
		});
		
		pomoSessionBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				minuteTime.setText(""+pomoSessionBox.getSelectedItem());
				minuteTime.setText(minuteTime.getText().substring(0,2));
				min = Integer.parseInt(minuteTime.getText());
				sec = Integer.parseInt(secondTime.getText());
			}
		});
		
		//Start and Break button actions
		startButton.addActionListener(new ActionListener() {

			//Button Action
			@Override
			public void actionPerformed(ActionEvent e) {
				updateTimerInformation();
				setCurrentSession();
				
				//Initial study values
				updateTamoImage(profile.getTamo().getId(),4);
				startButton.setBackground(Color.WHITE);
				
				studyMin = Integer.parseInt(minuteTime.getText());
				studySec = Integer.parseInt(secondTime.getText());
				//System.out.println("STUDY SESSION: " + studyMin + " minutes and " + studySec + " seconds.");
				tempSec = -1;
				tempMin = 0;
				
				//Enabled and Disabled updating
				minuteBox.setEnabled(false);
				secondBox.setEnabled(false);
				fiveIntervalBox.setEnabled(false);
				pomoNumberSessionBox.setEnabled(false);
				pomoSessionBox.setEnabled(false);
				pomoBreakBox.setEnabled(false);
				startButton.setEnabled(false);
				breakButton.setEnabled(true);
				
				statsButton.setEnabled(false);
				feedButton.setEnabled(false);
				backgroundShopButton.setEnabled(false);
				optionsButton.setEnabled(false);
				inventoryButton.setEnabled(false);
				ahmButton.setEnabled(false);
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
						
						//System.out.println(tempMin + " minutes and " + tempSec + " seconds.");
						
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
							
							tempMin = 0;
							tempSec = 0;

							if(profile.getSettings().getSessionSounds() == 1) {
							
								try {
									//Get the url for the sound clip
									URL url = this.getClass().getClassLoader().getResource("end2.wav");
									AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
									
									//get the clip from the url
									Clip clip = AudioSystem.getClip();
									clip.open(audioIn);
									
									//volume control - make the sound quieter
									FloatControl volume = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
							        volume.setValue(-1 * 20);
									
							        //start and loop the clip
									clip.start();
									clip.loop(Clip.LOOP_CONTINUOUSLY);
									
									//loop will end when user hits ok dialog
									JOptionPane.showMessageDialog(rootPane, studyMessage, "Congratulations!", JOptionPane.INFORMATION_MESSAGE,  new ImageIcon(getClass().getClassLoader().getResource("info.png")));
									clip.stop();
									
								} catch (Exception ex2) {
									ex2.printStackTrace();
								}
							
							} else {
								JOptionPane.showMessageDialog(rootPane, studyMessage, "Congratulations!", JOptionPane.INFORMATION_MESSAGE,  new ImageIcon(getClass().getClassLoader().getResource("info.png")));
								
							}
							//Display Completed message, in the future, it will do a calculation to show amount of points earned in the session
							
							
							//TODO: make methods to actually update coins and total statistics
							if(profile.getSettings().getFocusMode() == 2 && pomoSessionNumber != 0) {
								System.out.println("pomoSessionNumber: " + pomoSessionNumber);
								nextSession();
								setCurrentSession();
							} else {
								resetTimer();
								timer.stop();
							}
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
				
				JOptionPane.showMessageDialog(rootPane, studyMessage, "Maybe next time...", JOptionPane.INFORMATION_MESSAGE,  new ImageIcon(getClass().getClassLoader().getResource("info.png")));
				
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
				JPanel statsPanel = new JPanel();
				statsPanel.setLayout(new GridLayout(5,1));
				
				//On the fly calculations
				int totalSeconds = profile.getTotalTime();
				double totalHours = totalSeconds * 0.000277778;
				totalHours = Math.round(totalHours * 100.0) / 100.0;	//Rounds totalHours to the nearest Hundredth
				
				double sessionTotalSeconds = (sessionMin * 60) + sessionSec;
				double totalSessionHours = sessionTotalSeconds * 0.0002777778;
				totalSessionHours = Math.round(totalSessionHours * 100.0) / 100.0;
				
				//Create statspanel components
				JLabel totalHoursLabel = new JLabel(profile.getSettings().getLang().getText(17) + ": " + totalHours);
				JLabel totalHoursSessionLabel = new JLabel(profile.getSettings().getLang().getText(18) + ": " + totalSessionHours);
				
				JPanel starPanel = new JPanel();
				starPanel.setLayout(new GridLayout());
				JLabel ahmStarLabel = new JLabel();
				
				//If the user has studied for 7 days total time, they will recieve a star badge on their profile
				if(totalSeconds >= 604800)
					ahmStarLabel.setIcon(new ImageIcon(getClass().getClassLoader().getResource("ahm-star.png")));
				
				starPanel.add(ahmStarLabel);
				
				JLabel usernameStatsLabel = new JLabel(profile.getSettings().getLang().getText(19) + ": " + profile.getUsername());
				JLabel joinDateStatsLabel = new JLabel(profile.getSettings().getLang().getText(20) + ": " + profile.getJoinDate());
				
				statsPanel.add(totalHoursLabel);
				statsPanel.add(totalHoursSessionLabel);
				statsPanel.add(starPanel);
				statsPanel.add(usernameStatsLabel);
				statsPanel.add(joinDateStatsLabel);
				
				JOptionPane.showMessageDialog(rootPane, statsPanel, profile.getSettings().getLang().getText(5), JOptionPane.INFORMATION_MESSAGE,  new ImageIcon(getClass().getClassLoader().getResource("info.png")));
				
			}
			
		});
		
		/*
		 * Opens the Food GUI and allows user to purchase food, increasing hunger
		 */
		feedButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(profile.getTamo().getHunger() < 10) {
					foodGUI food = new foodGUI(profile, profileFile);
					hideWindow();
				} else {
					JOptionPane.showMessageDialog(null, profile.getSettings().getLang().getText(27), profile.getSettings().getLang().getText(26), JOptionPane.INFORMATION_MESSAGE, new ImageIcon(getClass().getClassLoader().getResource("info.png")));
					
					//Earn achievement
					if(profile.getAhm().getIndicator(6) != 1) {
						profile.getAhm().setIndicator(6, 1);
						achievementUpdates();
					}
				}
				
			}
			
		});
		
		backgroundShopButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				bgGUI bg = new bgGUI(profile, profileFile);
				hideWindow();
			}
			
		});
		
		logOutButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int resultPane = JOptionPane.showConfirmDialog(null, profile.getSettings().getLang().getText(39), profile.getSettings().getLang().getText(38),
						JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, new ImageIcon(getClass().getClassLoader().getResource("info.png")));
				if(resultPane == JOptionPane.OK_OPTION) {
					welcomeGUI welcome = new welcomeGUI(1);
					hideWindow();
					
				} else {
					//System.out.println("Cancelled");
				}
				
			}
			
		});
		
		optionsButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JPanel optionsPanel = new JPanel();
				//TODO Change back to 3,1 AFTER DEBUG SESSION IS OVER
				optionsPanel.setLayout(new GridLayout(4,1));
				
				JPanel op1 = new JPanel(), op2 = new JPanel(), op3 = new JPanel();
				JLabel focusModeLabel = new JLabel("Change Focus Mode");
				JLabel langLabel = new JLabel("Change Language");
				JLabel soundsLabel = new JLabel("Sounds");
				
				JButton debugButton = new JButton("Debug");
				debugButton.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						debugGUI debug = new debugGUI(profile, profileFile);
						hideWindow();
					}
					
				});
				
				JComboBox focusMode = new JComboBox();
				focusMode.addItem("5-Interval Countdown");
				focusMode.addItem("Custom Interval Countdown");
				focusMode.addItem("Pomodoro Mode");
				
				focusMode.setSelectedIndex(profile.getSettings().getFocusMode());
				
				JComboBox languageBox = new JComboBox();
				languageBox.addItem("English");
				languageBox.addItem("Español (Spanish)");
				languageBox.addItem("Português (Portuguese)");
				languageBox.addItem("Deutsche (German)");
				languageBox.addItem("日本語 (Japanese)");
				languageBox.addItem("Nederlands (Dutch)");
				languageBox.addItem("Français (French)");
				languageBox.addItem("English (Chinese Spot)");
				languageBox.addItem("Türkçe (Turkish)");
				
				languageBox.setSelectedIndex(profile.getSettings().getLang().getIndicator());
				
				JButton soundButton = new JButton();
					if(profile.getSettings().getSessionSounds() == 1)
						soundButton.setText("ON");
					else
						soundButton.setText("OFF");
				
				soundButton.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						if (profile.getSettings().getSessionSounds() == 0) {
							soundButton.setText("ON");
							profile.getSettings().setSessionSounds(1);
								System.out.println("profile.getSettings().getSessionSounds() = " + profile.getSettings().getSessionSounds());
						} else {
							soundButton.setText("OFF");
							profile.getSettings().setSessionSounds(0);
								System.out.println("profile.getSettings().getSessionSounds() = " + profile.getSettings().getSessionSounds());
						}
							
						
					}
					
				});
				
				optionsPanel.add(op1);
				optionsPanel.add(op2);
				optionsPanel.add(op3);
				
				//TODO REMOVE THIS LATER
				//optionsPanel.add(debugButton);
				
				op1.add(focusModeLabel);
				op1.add(focusMode);
				
				op2.add(langLabel);
				op2.add(languageBox);
				
				op3.add(soundsLabel);
				op3.add(soundButton);
				
				int result = JOptionPane.showConfirmDialog(rootPane, optionsPanel, "Options", JOptionPane.PLAIN_MESSAGE, 0, new ImageIcon(getClass().getClassLoader().getResource("info.png")));
				if(result == 0) {
					//Change Settings
					
					//Focus Mode
					int focusModeIndicator = getFocusIndicator(focusMode.getSelectedItem().toString());
					int languageIndicator = getLanguageIndicator(languageBox.getSelectedItem().toString());
					
					//TODO Sounds on/off
					
					profile.getSettings().setFocusMode(focusModeIndicator);
					profile.getSettings().getLang().setIndicator(languageIndicator);
					
					//Update and Reload GUI
					updateUserInformationToFile();
					GUI reloadedGUI = new GUI(profile, profileFile);
					hideWindow();
					
					
				}
				
			}
			
		});
		
		ahmButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//Create achievement GUI
				ahmGUI ahmgui = new ahmGUI(profile, profileFile);
				ahmgui.showConfirmDialog();
				//hideWindow();
			}
			
		});
		
		inventoryButton.addActionListener(new ActionListener() {
		 
			@Override
			public void actionPerformed(ActionEvent e) {
				inventoryGUI invGui = new inventoryGUI(profile, profileFile);
				hideWindow();
			}
		});

	}
	

	public void updateTimerInformation() {
		if(profile.getSettings().getFocusMode() == 2) {
			pomoSessionNumber = pomoNumberSessionBox.getSelectedIndex();
			System.out.println("pomoSessions: " + pomoSessionNumber);
			minuteTime.setText(""+pomoSessionBox.getSelectedItem());
			minuteTime.setText(minuteTime.getText().substring(0,2));
		}
		
		if(profile.getSettings().getFocusMode() == 1) {
			minuteTime.setText(""+minuteBox.getSelectedItem());
			secondTime.setText(""+secondBox.getSelectedItem());
		}
		
		if(profile.getSettings().getFocusMode() == 0 ) {
			minuteTime.setText(""+fiveIntervalBox.getSelectedItem());
			minuteTime.setText(minuteTime.getText().substring(0,2));
			
		}
		
		min = Integer.parseInt(minuteTime.getText());
		sec = Integer.parseInt(secondTime.getText());
		
	}

	public void nextSession() {
		if(profile.getSettings().getFocusMode() == 2) {
			if(breakCondition == false) {
				//Start Break Timer
				minuteTime.setText(""+pomoBreakBox.getSelectedItem());
				minuteTime.setText(minuteTime.getText().substring(0,2));
				min = Integer.parseInt(minuteTime.getText());
				sec = Integer.parseInt(secondTime.getText());
				breakCondition = true;
				
				startButton.doClick();
			}
			else {
				//End Break Timer, begin next session timer
				minuteTime.setText(""+pomoSessionBox.getSelectedItem());
				minuteTime.setText(minuteTime.getText().substring(0,2));
				min = Integer.parseInt(minuteTime.getText());
				sec = Integer.parseInt(secondTime.getText());
				breakCondition = false;
				this.pomoSessionNumber--;
				
				updateTamoImage(profile.getTamo().getId(),4);
				startButton.doClick();
			}
		}
	}
	
	/*
	 * 
	 */
	public void setCurrentSession() {
		currentSession = pomoNumberSessionBox.getSelectedIndex() - pomoSessionNumber;
		System.out.println("currentSession = " + (currentSession + 1));
		currentSessionLabel.setText((currentSession + 1) + " / " + (pomoNumberSessionBox.getSelectedIndex() + 1));
	}
	
	/*
	 * setSoundsEnabled
	 * condition checks whether sounds are enabled or not - boolean
	 */
	public void setSoundsEnabled(boolean condition) {
		this.soundsEnabled = condition;
	}
	
	/*
	 * initButtonVisuals
	 * Initalizes the Button Visuals
	 */
	public void initButtonVisuals() {
		String operatingSystem = System.getProperty("os.name");
		
		if(operatingSystem.startsWith("Windows")) {
		
			feedButton.setBackground(Color.WHITE);
			feedButton.setBorderPainted(false);
			feedButton.setFocusPainted(false);
			
			feedButton.addMouseListener(new java.awt.event.MouseAdapter() {
			    public void mouseEntered(java.awt.event.MouseEvent evt) {
			    	if(feedButton.isEnabled())
			    		feedButton.setBackground(Color.LIGHT_GRAY);
			    }
	
			    public void mouseExited(java.awt.event.MouseEvent evt) {
			    	if(feedButton.isEnabled())
			    		feedButton.setBackground(Color.WHITE);
			    }
			});
			
			backgroundShopButton.setBackground(Color.WHITE);
			backgroundShopButton.setBorderPainted(false);
			backgroundShopButton.setFocusPainted(false);
			
			backgroundShopButton.addMouseListener(new java.awt.event.MouseAdapter() {
			    public void mouseEntered(java.awt.event.MouseEvent evt) {
			    	if(backgroundShopButton.isEnabled())
			    		backgroundShopButton.setBackground(Color.LIGHT_GRAY);
			    }
	
			    public void mouseExited(java.awt.event.MouseEvent evt) {
			    	if(backgroundShopButton.isEnabled())
			    		backgroundShopButton.setBackground(Color.WHITE);
			    }
			});
			
			logOutButton.setBackground(Color.WHITE);
			logOutButton.setBorderPainted(false);
			logOutButton.setFocusPainted(false);
			
			logOutButton.addMouseListener(new java.awt.event.MouseAdapter() {
			    public void mouseEntered(java.awt.event.MouseEvent evt) {
			    	if(logOutButton.isEnabled())
			    		logOutButton.setBackground(Color.LIGHT_GRAY);
			    }
	
			    public void mouseExited(java.awt.event.MouseEvent evt) {
			    	if(logOutButton.isEnabled())
			    		logOutButton.setBackground(Color.WHITE);
			    }
			});
			
			startButton.setBackground(Color.WHITE);
			startButton.setBorderPainted(false);
			startButton.setFocusPainted(false);
			
			startButton.addMouseListener(new java.awt.event.MouseAdapter() {
			    public void mouseEntered(java.awt.event.MouseEvent evt) {
			    	if(startButton.isEnabled())
			    		startButton.setBackground(Color.LIGHT_GRAY);
			    }
	
			    public void mouseExited(java.awt.event.MouseEvent evt) {
			    	if(startButton.isEnabled())
			    		startButton.setBackground(Color.WHITE);
			    }
			});
			
			breakButton.setBackground(Color.WHITE);
			breakButton.setBorderPainted(false);
			breakButton.setFocusPainted(false);
			
			breakButton.addMouseListener(new java.awt.event.MouseAdapter() {
			    public void mouseEntered(java.awt.event.MouseEvent evt) {
			    	if(breakButton.isEnabled())
			    		breakButton.setBackground(Color.LIGHT_GRAY);
			    }
	
			    public void mouseExited(java.awt.event.MouseEvent evt) {
			    	if(breakButton.isEnabled())
			    		breakButton.setBackground(Color.WHITE);
			    }
			});
		}
		
	}
	
	
	public void setUpGUI() {
		this.getContentPane().setBackground(new Color(255,161,161));
		this.getContentPane().add(headPanel, BorderLayout.NORTH);
		this.getContentPane().add(tamoPanel, BorderLayout.CENTER);
		this.getContentPane().add(timerPanel, BorderLayout.SOUTH);
	}
	
	/*
	 * resetTimer
	 * Method resets the timer
	 */
	public void resetTimer() {
		
		if(profile.getSettings().getFocusMode() == 0) {
			min = 5;
			sec = 0;
			
			fiveIntervalBox.setSelectedIndex(0);
			
			minuteTime.setText("0" + min);
			secondTime.setText("0" + sec);
			
		} else {
			min = 0;
			sec = 0;
			
			minuteTime.setText("0" + min);
			secondTime.setText("0" + sec);
		}
		
		
		minuteBox.setSelectedIndex(0);
		secondBox.setSelectedIndex(0);
		
		//stop 
		minuteBox.setEnabled(true);
		secondBox.setEnabled(true);
		fiveIntervalBox.setEnabled(true);
		pomoNumberSessionBox.setEnabled(true);
		pomoSessionBox.setEnabled(true);
		pomoBreakBox.setEnabled(true);
		startButton.setEnabled(true);
		breakButton.setEnabled(false);
		
		statsButton.setEnabled(true);
		feedButton.setEnabled(true);
		backgroundShopButton.setEnabled(true);
		optionsButton.setEnabled(true);
		inventoryButton.setEnabled(true);
		ahmButton.setEnabled(true);
		logOutButton.setEnabled(true);
		
		currentSessionLabel.setText("Let's Focus!");
		
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
	 * 
	 * Decrypts input string, updates values, re-encrypts string
	 */
	private void updateUserInformationToFile() {
		try {
			//Open the file
			BufferedReader file = new BufferedReader(new FileReader(profileFile));
			StringBuffer inputBuffer = new StringBuffer();
			String line;
			
			//Read the file, put output to inputBuffer
			while((line = (file.readLine())) != null) {
				inputBuffer.append(line);
			}
			
			file.close();
			
			//Close file and decrypt user file
			String inputStr = inputBuffer.toString();
			String decryptedString = encryption.decrypt(inputStr);
			
			//Split decrypted file into string array
			//each element represents a specific setting inside of the profile text file
			String[] inputtedString = decryptedString.split(",");
			
			
			//I didn't know where to put the code to update the level, so it's here:
			//Every 24 hours, your tamo will gain 1 level
			int new_level = (profile.getTotalTime() / 86400);
			profile.getTamo().setLevel(new_level);
			
			/**
			 * Rewriting Profile Information
			 * @author Anthony Narlock
			 * 
			 * Key Guide:
			 * [2] -> New Login String
			 * [3] -> Total Time Studied in seconds
			 * [4] -> Total Money
			 * [5] -> Current Background Indicator
			 * [6] -> GUI Background Color Indicator
			 * 
			 * [8] -> Settings / Focus Mode Indicator
			 * [9] -> Settings / Language Indicator
			 * [10] -> Settings / Session Sound Indicator
			 * [11] -> Settings / Background Sound Indicator
			 * [12] -> Tamo Name (string)
			 * [13] -> Tamo ID (corresponding to Tamo Image)
			 * [14] -> Tamo Happiness Integer
			 * [15] -> Tamo Hunger Integer
			 * [16] -> Achievement Indicator String
			 * [17] -> Inventory String
			 */
			
			if(profile.getNewLoginString() == null) {
				
			} else {
			inputtedString[2] = profile.getNewLoginString();
			}
			
			inputtedString[3] = String.valueOf(profile.getTotalTime());
			inputtedString[4] = String.valueOf(profile.getMoney());
			inputtedString[5] = String.valueOf(profile.getCurrentBackground());
			inputtedString[6] = profile.getGuiColor();
			
			/*
			 * Rewriting Profile Settings
			 */
			inputtedString[8] = String.valueOf(profile.getSettings().getFocusMode());
			inputtedString[9] = String.valueOf(profile.getSettings().getLang().getIndicator());
			inputtedString[10] = String.valueOf(profile.getSettings().getSessionSounds());
			inputtedString[11] = String.valueOf(profile.getSettings().getBackgroundSounds());
			
			/*
			 * Rewriting Tamo Information
			 */
			inputtedString[12] = profile.getTamo().getName();
			inputtedString[13] = String.valueOf(profile.getTamo().getId());
			inputtedString[14] = String.valueOf(profile.getTamo().getHappiness());
			inputtedString[15] = String.valueOf(profile.getTamo().getHunger());
			
			/*
			 * Rewriting Achievement String
			 */
			inputtedString[16] = profile.getAhm().getAhmString();
			
			
			//join the string back together and re-encrypt
			decryptedString = String.join(",", inputtedString);
			String encryptedStr = encryption.encrypt(decryptedString);
			
			//Overwrite the existing file to the File System
			FileOutputStream fileOut = new FileOutputStream(profileFile);
			fileOut.write(encryptedStr.getBytes());
			fileOut.close();
			
			}
		catch (Exception e) {
			System.out.println("Updating user information failed due to exception." + e);
			}
		}
		
	
	
	/*
	 * updateStudyStats
	 * Updates the totalTime studied for the user
	 */
	public void updateStudyStats(int min, int sec) {
		int totalSeconds = (min * 60) + sec;
		profile.setTotalTime(profile.getTotalTime() + totalSeconds);
		
		/**
		 * @author Anthony Narlock
		 * NOTE: Give money, every 3600 seconds (1 hour) = 50 Tamo Tokens
		 * This means that for every 72 seconds, 1 Tamo Token is earned.
		 */
		int earnedSessionMoney = ((50 * totalSeconds) / 3600);
		profile.setMoney(profile.getMoney() + earnedSessionMoney);
		
		//Update TamoHappiness, tamoHappiness will increment by one for every half hour studied.
		int heartsEarned = 0;
		if(profile.getTamo().getHappiness() == 10) {
			// The user exceeded the amount of happiness, no happiness is rewarded since it has already been made.
		} else {
			heartsEarned = (totalSeconds / 1800);
			if(profile.getTamo().getHappiness() + heartsEarned >= 10)
				profile.getTamo().setHappiness(10);
			else
				profile.getTamo().setHappiness(profile.getTamo().getHappiness() + heartsEarned);
		}
		
		updateGUI();
		
		updateUserInformationToFile();
	}
	
	/*
	 * updateGUI
	 * Updates the GUI components
	 */
	public void updateGUI() {
		//Update Last Login Date and compare to update happiness and hunger
		//TODO
		
		//Update General Labels
		moneyLabel.setText("" + profile.getMoney());
		tamoLevel.setText(profile.getSettings().getLang().getText(2) + ": " + profile.getTamo().getLevel());
		updateTamoHappiness(profile.getTamo().getHappiness());
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
		
		
		//Update Study Mode
		if(profile.getSettings().getFocusMode() == 0) {
			minuteBox.setVisible(false);
			secondBox.setVisible(false);
			fiveIntervalBox.setVisible(true);
			
			pomoNumberSessionBox.setVisible(false);
			pomoSessionBox.setVisible(false);
			pomoBreakBox.setVisible(false);
			
			pomoNumberSessionLabel.setVisible(false);
			pomoSessionLabel.setVisible(false);
			pomoBreakLabel.setVisible(false);
		}
		
		if(profile.getSettings().getFocusMode() == 1) {
			minuteBox.setVisible(true);
			secondBox.setVisible(true);
			fiveIntervalBox.setVisible(false);
			
			pomoNumberSessionBox.setVisible(false);
			pomoSessionBox.setVisible(false);
			pomoBreakBox.setVisible(false);
			
			pomoNumberSessionLabel.setVisible(false);
			pomoSessionLabel.setVisible(false);
			pomoBreakLabel.setVisible(false);
		}
		
		
		if(profile.getSettings().getFocusMode() == 2) {
			minuteBox.setVisible(false);
			secondBox.setVisible(false);
			fiveIntervalBox.setVisible(false);
			
			pomoNumberSessionBox.setVisible(true);
			pomoSessionBox.setVisible(true);
			pomoBreakBox.setVisible(true);
			
			pomoNumberSessionLabel.setVisible(true);
			pomoSessionLabel.setVisible(true);
			pomoBreakLabel.setVisible(true);
		}
		
	}
	
	/*
	 * Updates the Tamo's image based on number
	 * 0 - default
	 * 1 - happy
	 * 2 - sad
	 * 3 - hungry
	 * 4 - focus mode
	 */
	public void updateTamoImage(int tamoID, int num) {
			if(num == 0) 
				imageLabel.setIcon(new ImageIcon(getClass().getClassLoader().getResource("tamo"+tamoID+"_default.gif")));
			else if(num == 1)
				imageLabel.setIcon(new ImageIcon(getClass().getClassLoader().getResource("tamo"+tamoID+"_happy.gif")));
			else if(num == 2)
				imageLabel.setIcon(new ImageIcon(getClass().getClassLoader().getResource("tamo"+tamoID+"_sad.png")));
			else if(num == 3)
				imageLabel.setIcon(new ImageIcon(getClass().getClassLoader().getResource("tamo"+tamoID+"_hungry.png")));
			else if(num == 4)
				imageLabel.setIcon(new ImageIcon(getClass().getClassLoader().getResource("tamo"+tamoID+"_focus.png")));
	}

	/*
	 * hideWindow
	 * Hides the window
	 */
	public void hideWindow() {
		this.setVisible(false);
		this.dispose();
	}

	/*
	 * setBackground
	 * Changes the Tamo's background image
	 */
	public void setBackground(int num) {
		if(num == 0)
			backgroundImageLabel.setIcon(new ImageIcon(getClass().getClassLoader().getResource("bg.png")));
		else if(num == 1)
			backgroundImageLabel.setIcon(new ImageIcon(getClass().getClassLoader().getResource("bg2.png")));
		else if(num == 2)
			backgroundImageLabel.setIcon(new ImageIcon(getClass().getClassLoader().getResource("bg3.png")));
		else if(num == 3)
			backgroundImageLabel.setIcon(new ImageIcon(getClass().getClassLoader().getResource("bg4.png")));
		else if(num == 4)
			backgroundImageLabel.setIcon(new ImageIcon(getClass().getClassLoader().getResource("bg5.png")));
	}
	
	/*
	 * updateHappyHunger
	 * Updates values based off of log in date
	 * TODO: assign strike variables if hunger or happiness is below a certain threshold
	 */
	public void updateHappyHunger() {
		//System.out.println("RUNNING UPDATEHAPPYHUNGER METHOD\n--------------------------");
		
		//System.out.println("DEBUG: Hunger before updateHappyHunger = " + profile.getTamo().getHunger());
		//System.out.println("DEBUG: Happiness before updateHappyHunger = " + profile.getTamo().getHappiness());
		
		//will grab profile.lastLoginString and compare it to profile.newLoginString
		boolean first_day = true;
		LocalDate end = null;
		LocalDate start = null;
		
		try {
			start = LocalDate.parse(profile.getLastLoginString());
			end = LocalDate.parse(profile.getNewLoginString());
			first_day = false;
		} catch (Exception e) {
			//System.out.println("NOTICE: Profile does not have a last Login string, exception *first day of profile*");
		}
		
		
		if(first_day == false) {
			long diff = ChronoUnit.DAYS.between(start,end);
			
			//System.out.println("DEBUG: DIFFERENCE BETWEEN DAYS IS " + diff);
		if(diff == 0) {
			//If the user logs in on the same day, no changes will occur.
			//System.out.println("DEBUG: Running difference = 0");
			
		} 
		
		
		if(diff == 1) {
			//If the user is logging in on a consecutive day, hunger will deplete 2 hunger points
			//System.out.println("DEBUG: Running difference = 1:");
			int hungerAfterDepletion = profile.getTamo().getHunger() - 2;
			//System.out.println("HUNGER AFTER DEPLETION = " + hungerAfterDepletion);
			int happinessAfterDepletion = profile.getTamo().getHappiness() - 2;
			//System.out.println("HAPPY AFTER DEPLETION = " + happinessAfterDepletion);
			
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
			//System.out.println("DEBUG: Running difference = 2-3:");
			int hungerAfterDepletion = (profile.getTamo().getHunger() - 4);
			//System.out.println("HUNGER AFTER DEPLETION = " + hungerAfterDepletion);
			int happinessAfterDepletion = profile.getTamo().getHappiness() - 3;
			//System.out.println("HAPPY AFTER DEPLETION = " + happinessAfterDepletion);
			
			//System.out.println("HUNGER UNDEREQUAL ZERO VALUE: " + underEqualZero(hungerAfterDepletion));
			if(underEqualZero(hungerAfterDepletion)) {
				//System.out.println("SETTING HUNGER TO ZERO");
				profile.getTamo().setHunger(0);
			} else { 
				//System.out.println("SETTING HUNGER TO: " + hungerAfterDepletion);
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
			//System.out.println("Running difference = 4-7:");
			int hungerAfterDepletion = profile.getTamo().getHunger() - 5;
			//System.out.println("HUNGER AFTER DEPLETION = " + hungerAfterDepletion);
			int happinessAfterDepletion = profile.getTamo().getHappiness() - 4;
			//System.out.println("HAPPY AFTER DEPLETION = " + happinessAfterDepletion);
			
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
			//System.out.println("Running difference = 7+:");
			profile.getTamo().setHunger(0);
			profile.getTamo().setHappiness(1);
		}

		if(diff >= 30) {
			//System.out.println("Running difference = 30+:");
			//If the user does not log in for a month, the Tamo will reset (die).
			//Essentially the tamo data will be wiped and user will start over
			//all of the info will be reset, the tamo will be wiped, and new tamo will be assigned
			//will write to the profile file
			//profile.setWarnings(3);
			this.death = true;
			
		}
		
		//System.out.println("DEBUG HUNGER AFTER FUNCTION: " + profile.getTamo().getHunger());
		//System.out.println("DEBUG HAPPY AFTER FUNCTION: " + profile.getTamo().getHappiness());
		
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
				tamoHappiness.setIcon(new ImageIcon(getClass().getClassLoader().getResource("happy" + str +".png")));
			}
		}
	}
	
	public void updateTamoHunger(int hunger) {
		String str = Integer.toString(hunger);
		
		for(int i = 0; i <= hunger; i++) {
			if(i == hunger) {
				tamoHunger.setIcon(new ImageIcon(getClass().getClassLoader().getResource("hungry" + str +".png")));
			}
		}
	}
	
	/*
	 * TamoDeath
	 * Will occur if the user is inactive from TamoStudy, or user takes
	 * poor care of their Tamo (3 strikes are reached)
	 */
	public void tamoDeath() {
		//Create the Death Panel
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
		
		int resultPane = JOptionPane.showOptionDialog(null, deathPanel, "Tamo Death", JOptionPane.PLAIN_MESSAGE, JOptionPane.QUESTION_MESSAGE, new ImageIcon(getClass().getClassLoader().getResource("info.png")), options, options[0]);
		
		//User will be able to choose if they want to change the name of their Tamo
		if(resultPane == 0) {
			resetTamo(newTamoNameField.getText());
					
		} else if(resultPane == JOptionPane.CLOSED_OPTION) {
			resetTamo(profile.getTamo().getName());
		}
		
	}
	
	/*
	 * Resets Tamo in TamoStudy - all stats will be erased
	 * Will occur upon TamoDeath
	 */
	public void resetTamo(String name) {
		profile.setTotalTime(0);
		profile.setMoney(0);
		profile.setCurrentBackground(0);
		profile.getTamo().setName(name);
		profile.getTamo().setHappiness(5);
		profile.getTamo().setHunger(5);
		profile.getTamo().setId(ThreadLocalRandom.current().nextInt(1, 3 + 1));
		
		updateUserInformationToFile();
		hideWindow();
		
		GUI newGUI = new GUI(profile);
	}
	
	/*
	 * getFocusIndicator
	 * Returns the index corresponding to the stringIndicator argument
	 */
	public int getFocusIndicator(String stringIndicator) {
		if(stringIndicator.equals("5-Interval Countdown"))
			return 0;
		if(stringIndicator.equals("Custom Interval Countdown"))
			return 1;
		if(stringIndicator.equals("Pomodoro Mode"))
			return 2;
		
		
		return 0;
	}
	
	/*
	 * getLanguageIndicator
	 * Returns the index corresponding to the languageString argument
	 */
	public int getLanguageIndicator(String languageString) {
		if(languageString.equals("English"))
			return 0;
		if(languageString.equals("Español (Spanish)"))
			return 1;
		if(languageString.equals("Português (Portuguese)"))
			return 2;
		if(languageString.equals("Deutsche (German)"))
			return 3;
		if(languageString.equals("日本語 (Japanese)"))
			return 4;
		if(languageString.equals("Nederlands (Dutch)"))
			return 5;
		if(languageString.equals("Français (French)"))
			return 6;
		if(languageString.equals("汉语/漢語 (Chinese)"))
			return 7;
		if(languageString.equals("Türkçe (Turkish)"))
			return 8;
		
		return 0;
	}
	
	/*
	 * This method checks for updates for the achievements
	 * Then updates them to the string respectively
	 */
	public void achievementUpdates() {
		//Reach 3 hours focus time
		if(profile.getTotalTime() >= 10800 && profile.getAhm().getIndicator(0) != 1) {
			profile.getAhm().setIndicator(0,1);
		}
		
		//Reach 1 day focus time
		if(profile.getTotalTime() >= 86400 && profile.getAhm().getIndicator(1) != 1) {
			profile.getAhm().setIndicator(1,1);
		}
		
		//Reach 7 day focus time
		if(profile.getTotalTime() >= 604800 && profile.getAhm().getIndicator(2) != 1) {
			profile.getAhm().setIndicator(2,1);
		}
		
		/*
		 * Background achievements are covered in bgGUI
		 * TODO Updated profile version
		 * Food Shop achievement covered in that line of code
		 * Happiness achievement in updateHappyHunger
		 * TODO implement login ones (perhaps in future updates
		 */
		
		if(profile.getTamo().getHappiness() > 9 && profile.getAhm().getIndicator(7) != 1) {
			profile.getAhm().setIndicator(7, 1);
		}
		
		updateUserInformationToFile();
	}
	
}
