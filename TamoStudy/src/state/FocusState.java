package state;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

import components.panel.SetPanel;
import components.panel.TamoGraphicsPanel;
import components.panel.TimerPanel;
import gui.TamoStudyGUI;
import model.GuiSize;
import model.language.Language;
import model.profile.Profile;
import model.profile.Tamo;
import model.time.DailyFocusEntry;
import model.time.MonthFocusEntry;
import resources.Debug;
import resources.Theme;
import util.Utils;

public class FocusState extends State {

	private static final long serialVersionUID = -3878552282431644324L;
	
	/*
	 * ##################################
	 * ##################################
	 * ATTRIBUTES
	 * ##################################
	 * ##################################
	 */
	private Profile profile;
	private Language language;
	private GuiSize guiSize;
	private Tamo tamo;
	private Theme theme;
	private DailyFocusEntry dailyFocusEntry;
	private MonthFocusEntry monthFocusEntry;
	
	private Timer timer;
	private int sessionsRemaining;
	private Timer pauseTimer;
	private int timerPauseIndicator;
	
	/**
	 * Indicator for what time to use during pomodoro countdown timers.
	 * 0 : Pomodoro Session Length
	 * 1 : Pomodoro Break Length
	 * 2 : Pomodoro Long Break Length
	 */
	private int sessionTimeIndicator;
	private int tempSec, tempMin, sec, min;
	
	/*
	 * ##################################
	 * ##################################
	 * COMPONENTS
	 * ##################################
	 * ##################################
	 */
	
	// Side 1
	private JPanel tamoPanel;
	
	private JLabel tamoNameLabel;
	private TamoGraphicsPanel tamoGraphicsPanel;
	private JPanel tamoHappyHungerPanel;
	private JLabel tamoHappyLabel;
	private JLabel tamoHungerLabel;
	
	// Side 2
	private JPanel timerSetPanel;
	private TimerPanel timerPanel;
	private SetPanel setPanel;
	private JPanel buttonPanel;
	private JButton startFocusButton, breakFocusButton, pauseFocusButton;

	public FocusState(TamoStudyGUI tamoStudyGUI) {
		super(tamoStudyGUI);
		initializeAttributes();
		initializeComponents();
		initializeComponentVisuals();
		initializeComponentActions();
		initializePanel();
	}

	@Override
	protected void initializeAttributes() {
		profile = tsGui.getProfile();
		language = tsGui.getProfile().getSettings().getLanguage();
		guiSize = new GuiSize((int) profile.getSettings().getGuiSize());
		tamo = profile.getTamo();
		theme = Theme.DARK;
		
		this.dailyFocusEntry = Utils.searchTodayFocusEntryByProfile(tsGui.getDailyFocus().getDailyFocusEntries());
		// Create new daily focus entry if it does not exist
		if(dailyFocusEntry == null) {
			dailyFocusEntry = Utils.createDailyFocusEntry();
			tsGui.addNewDailyFocusEntryToDailyFocus(dailyFocusEntry);
			tsGui.getDailyFocusJsonManager().writeJsonToFile(tsGui.getDailyFocusList());
		}
		
		this.monthFocusEntry = Utils.searchCurrentMonthEntryByProfile(tsGui.getMonthFocus().getMonthFocusEntries());
		// Create new month focus entry if it does not exist
		if(monthFocusEntry == null) {
			monthFocusEntry = Utils.createMonthFocusEntry();
			tsGui.addNewMonthFocusEntryToMonthFocus(monthFocusEntry);
			tsGui.getMonthFocusJsonManager().writeJsonToFile(tsGui.getMonthFocusList());
		}
	}

	@Override
	protected void initializeComponents() {
		tamoPanel = new JPanel(new GridBagLayout());
		tamoNameLabel = new JLabel(tamo.getName());
		tamoGraphicsPanel = new TamoGraphicsPanel(guiSize, tamo, profile.getBackgroundIndicator(), profile.getBorderIndicator());
		tamoHappyHungerPanel = new JPanel();
		tamoHappyLabel = new JLabel("" + tamo.getHappy());
		tamoHungerLabel = new JLabel("" + tamo.getHunger());
		
		timerSetPanel = new JPanel(new GridBagLayout());
		timerPanel = new TimerPanel(profile);
		setPanel = new SetPanel(timerPanel, profile.getSettings().getFocusMode(), language);
		buttonPanel = new JPanel();
		startFocusButton = new JButton(language.startFocusText);
		breakFocusButton = new JButton(language.breakFocusText);
		pauseFocusButton = new JButton("Pause Focus");
	}

	@Override
	protected void initializeComponentVisuals() {
		GridBagConstraints gbcv = new GridBagConstraints();
		gbcv.gridwidth = GridBagConstraints.REMAINDER;
		
		// Tamo Panel
		tamoPanel.setBackground(theme.subColor);
		
		tamoNameLabel.setFont(guiSize.messageLabelFont);
		tamoNameLabel.setForeground(theme.textColor);
		
		tamoHappyHungerPanel.setBackground(theme.subColor);
		
		tamoHappyLabel.setFont(guiSize.statisticsInfoFontBold);
		tamoHappyLabel.setForeground(theme.textColor);
		tamoHappyLabel.setIcon(guiSize.heartImageIcon);
		
		tamoHungerLabel.setFont(guiSize.statisticsInfoFontBold);
		tamoHungerLabel.setForeground(theme.textColor);
		tamoHungerLabel.setIcon(guiSize.onigiriImageIcon);
		
		tamoHappyHungerPanel.add(tamoHappyLabel);
		tamoHappyHungerPanel.add(tamoHungerLabel);
		
		tamoPanel.add(tamoNameLabel, gbcv);
		tamoPanel.add(Box.createVerticalStrut(guiSize.settingsVerticalDifference), gbcv);
		tamoPanel.add(tamoGraphicsPanel, gbcv);
		tamoPanel.add(Box.createVerticalStrut(guiSize.settingsVerticalDifference), gbcv);
		tamoPanel.add(tamoHappyHungerPanel, gbcv);
		
		// Timer Set Panel
		startFocusButton.setBackground(Theme.SUCCESS);
		startFocusButton.setFont(theme.fontBoldRegSmall);
		startFocusButton = guiSize.scaleSuccessJButton(startFocusButton, guiSize.getScaleFromSize((int) profile.getSettings().getGuiSize()));
		
		breakFocusButton.setBackground(Theme.DANGER);
		breakFocusButton.setFont(theme.fontBoldRegSmall);
		breakFocusButton = guiSize.scaleDangerJButton(breakFocusButton, guiSize.getScaleFromSize((int) profile.getSettings().getGuiSize()));
		breakFocusButton.setEnabled(false);
		breakFocusButton.setBackground(Theme.DANGER_ALT);
		breakFocusButton.setForeground(new Color(191, 191, 191));
		
		pauseFocusButton.setBackground(Theme.PRIMARY);
		pauseFocusButton.setFont(theme.fontBoldRegSmall);
		pauseFocusButton = guiSize.scalePrimaryJButton(pauseFocusButton, guiSize.getScaleFromSize((int) profile.getSettings().getGuiSize()));
		pauseFocusButton.setEnabled(false);
		pauseFocusButton.setBackground(Theme.PRIMARY_ALT);
		pauseFocusButton.setForeground(new Color(191, 191, 191));
		
		buttonPanel.setBackground(theme.subColor);
		buttonPanel.add(startFocusButton);
		buttonPanel.add(breakFocusButton);
		buttonPanel.add(pauseFocusButton);
		
		timerSetPanel.setBackground(theme.subColor);
		timerSetPanel.add(timerPanel, gbcv);
		timerSetPanel.add(setPanel, gbcv);
		timerSetPanel.add(buttonPanel, gbcv);
	}

	@Override
	protected void initializeComponentActions() {
		startFocusButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//Update Timer Information
				updateTimerInformation();
				
				//Set Information, TamoImage, study/Temp Min/Sec
				setFocusInformation();
				
				//Disable Buttons
				toggleButtons(false);
				
				//Create Timer
				createTimer();
			}
			
		});
		
		breakFocusButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				sessionsRemaining = 0;		// Reset pomdoro - no sessions remaining
				sessionTimeIndicator = 0;	// Reset time indicator - will start on focus time
				
				String studyMessage = language.youFocusedForText + " " + tempMin + " " + language.minutesAndText + " " + tempSec + " " + language.secondsPeriodText;

				// Reset counting variables
				tempMin = 0;
				tempSec = 0;
				
				timer.stop();
				resetTimer();
				
				JOptionPane.showMessageDialog(getRootPane(), studyMessage, language.focusBrokeText, JOptionPane.INFORMATION_MESSAGE,  new ImageIcon(getClass().getClassLoader().getResource("INFO.png")));
			}
		});
		
		pauseFocusButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				pauseResumeTimer();
			}
		});
	}

	@Override
	protected void initializePanel() {
		this.setLayout(new GridLayout(1, 2));
		this.setBackground(theme.subColor);
		this.add(tamoPanel);
		this.add(timerSetPanel);
	}
	
	/*
	 * ##################################
	 * ##################################
	 * TIMER ACTIONS
	 * ##################################
	 * ##################################
	 */
	public void updateTimerInformation() {
		switch((int) profile.getSettings().getFocusMode()) {
		case 0:
			// Set Timer based on Pomodoro setting
			timerPanel.minuteTimeLabel.setText(((String) setPanel.pomoSessionLengthBox.getSelectedItem()).substring(0, 2));
			timerPanel.secondTimeLabel.setText(((String) setPanel.pomoSessionLengthBox.getSelectedItem()).substring(3));
			sessionsRemaining = (Integer) setPanel.pomoNumberOfSessionsBox.getSelectedItem();
			break;
		case 1:
			// Custom Countdown
			timerPanel.minuteTimeLabel.setText(((String) setPanel.customMinuteLengthBox.getSelectedItem()));
			timerPanel.secondTimeLabel.setText(((String) setPanel.customSecondLengthBox.getSelectedItem()));
			sessionsRemaining = 0;
			break;
		case 2:
			// Five Min Interval Countdown
			timerPanel.minuteTimeLabel.setText(((String) setPanel.fiveLengthBox.getSelectedItem()).substring(0, 2));
			timerPanel.secondTimeLabel.setText(((String) setPanel.fiveLengthBox.getSelectedItem()).substring(3));
			sessionsRemaining = 0;
			break;
		case 4:
			// Pomodoro with Long Breaks
			// TODO
			break;
		default:
			// Pomodoro
			timerPanel.minuteTimeLabel.setText(((String) setPanel.pomoSessionLengthBox.getSelectedItem()).substring(0, 2));
			timerPanel.secondTimeLabel.setText(((String) setPanel.pomoSessionLengthBox.getSelectedItem()).substring(3));
			sessionsRemaining = (Integer) setPanel.pomoNumberOfSessionsBox.getSelectedItem();
			break;
		}
		pauseFocusButton.setText("Pause Focus");
		timerPanel.subTextLabel.setText(language.letsFocusText);
	}
	
	public void setFocusInformation() {
		// Set timer attributes
		min = Integer.parseInt(timerPanel.minuteTimeLabel.getText());
		sec = Integer.parseInt(timerPanel.secondTimeLabel.getText());
		tempSec = 0;
		tempMin = 0;
		
		// Set Tamo Image To Focus
		tamoGraphicsPanel.getTamo().setFocused(true);
		tamoGraphicsPanel.repaint();
	}
	
	public void createTimer() {
		Debug.info("FocusState.createTimer", "Starting focus timer...");
		
		sessionTimeIndicator = 0; // Ensure in focus mode
		if(profile.getSettings().getFocusMode() == 0) {
			int numOfSessions = (Integer) setPanel.pomoNumberOfSessionsBox.getSelectedItem();
			timerPanel.subTextLabel.setText(language.focusText + " " + ((numOfSessions - sessionsRemaining) + 1) + "/" + numOfSessions);
		}
		
		// Initialize Timer to subtract a second such that time focused is accurate
		if(sec == 0 && min > 0) {
			sec = 60;
			min--;	
		}
		
		if(sec != 0) {
			sec--;
			if(sec < 10) {
				timerPanel.secondTimeLabel.setText("0" + sec);
			}
			else {
				timerPanel.secondTimeLabel.setText("" + sec);
			}
			if(min < 10) {
				timerPanel.minuteTimeLabel.setText("0" + min);
			}
			else {
				timerPanel.minuteTimeLabel.setText("" + min);
			}
		}
		
		// Begin the count down timer
		timer = new Timer(1000, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//Set how long studied for variables
				tempSec = tempSec + 1;
				
				if(tempSec == 60) {
					tempMin = tempMin + 1;
					tempSec = 0;
				}
				
				if(sec == 0) {
					sec = 60;
					min--;
				}
				
				//Timer Completed
				if(min < 0) {
					
					// Update statistics
					updateFocusStatistics();
					
					String studyMessage = language.youFocusedForText + " " + tempMin + " " + language.minutesAndText + " " + tempSec + " " + language.secondsPeriodText;
					if(sessionTimeIndicator != 0) {
						studyMessage = "Break is over. Time to get back to focus!";
					}

					// Reset counting variables
					tempMin = 0;
					tempSec = 0;
					
					if(profile.getSettings().getTimerAlarm() >= 1) { // If user has a sound clip 
					
						try {
							//Get the url for the sound clip
							String soundPath = profile.getSettings().getSoundPath();
							
							URL url = this.getClass().getClassLoader().getResource(soundPath);
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
							JOptionPane.showMessageDialog(getRootPane(), studyMessage, "TamoStudy", JOptionPane.INFORMATION_MESSAGE,  new ImageIcon(getClass().getClassLoader().getResource("INFO.png")));
							clip.stop();
							
						} catch (Exception ex) {
							/*
							 * Under the condition that the user has a set timer alarm, but an exception
							 * occurs, TamoStudy will proceed as if there was no alarm set.
							 */
							JOptionPane.showMessageDialog(getRootPane(), studyMessage, "TamoStudy", JOptionPane.INFORMATION_MESSAGE,  new ImageIcon(getClass().getClassLoader().getResource("INFO.png")));
						}
					
					} else {
						/*
						 * Under the condition that there is no timer alarm set
						 */
						JOptionPane.showMessageDialog(getRootPane(), studyMessage, "TamoStudy", JOptionPane.INFORMATION_MESSAGE,  new ImageIcon(getClass().getClassLoader().getResource("INFO.png")));
					}
					//TODO Display Completed message, in the future, it will do a calculation to show amount of points earned in the session
					
					// Go to next session or break - POMODORO ONLY
					if(sessionsRemaining > 1) {
						// Currently finished focus session
						if(sessionTimeIndicator == 0) {
							int numOfSessions = (Integer) setPanel.pomoNumberOfSessionsBox.getSelectedItem();
							Debug.info("FocusState.timer.actionPerformed", "Focus session " + ((numOfSessions - sessionsRemaining) + 1) + "/" + numOfSessions + " completed.");
							sessionTimeIndicator = 1; // Break time
							timerPanel.subTextLabel.setText(language.breakText + " " + ((numOfSessions - sessionsRemaining) + 1) + "/" + numOfSessions);
							// TODO Refactor to add logic to check if long break or not... Set to 2 if long break
						} 
						// Currently finished break session
						else if(sessionTimeIndicator == 1) {
							sessionsRemaining--;
							int numOfSessions = (Integer) setPanel.pomoNumberOfSessionsBox.getSelectedItem();
							Debug.info("FocusState.timer.actionPerformed", "Break session ended. Beginning focus session " + ((numOfSessions - sessionsRemaining) + 1) + "/" + numOfSessions);
							sessionTimeIndicator = 0; // Focus time
							timerPanel.subTextLabel.setText(language.focusText + " " + ((numOfSessions - sessionsRemaining) + 1) + "/" + numOfSessions);
						}
						// TODO Add else if branch for long session and refactor for long session
						
						nextSession();
					} else {
						// Timer is done!
						timer.stop();
						resetTimer();
					}
					
				} 
				//Timer still running
				else {
					sec--;
					if(sec < 10) {
						timerPanel.secondTimeLabel.setText("0" + sec);
					}
					else {
						timerPanel.secondTimeLabel.setText("" + sec);
					}
					if(min < 10) {
						timerPanel.minuteTimeLabel.setText("0" + min);
					}
					else {
						timerPanel.minuteTimeLabel.setText("" + min);
					}
//					updateRPCTimer();
				}
			}
		});
		
		//Start timer
		timer.start();
	}
	
	public void nextSession() {
		switch(sessionTimeIndicator) {
		case 1:
			// Break Timer Set
			timerPanel.minuteTimeLabel.setText(((String) setPanel.pomoBreakLengthBox.getSelectedItem()).substring(0, 2));
			timerPanel.secondTimeLabel.setText(((String) setPanel.pomoBreakLengthBox.getSelectedItem()).substring(3));
			
			// Set Tamo Image To Non-Focus
			tamoGraphicsPanel.getTamo().setFocused(false);
			tamoGraphicsPanel.repaint();
			break;
		case 2:
			// TODO Long Break Timer Set
			break;
		case 0:
		default:
			// Pomodoro Focus Timer Set
			timerPanel.minuteTimeLabel.setText(((String) setPanel.pomoSessionLengthBox.getSelectedItem()).substring(0, 2));
			timerPanel.secondTimeLabel.setText(((String) setPanel.pomoSessionLengthBox.getSelectedItem()).substring(3));
			
			// Set Tamo Image To Focus
			tamoGraphicsPanel.getTamo().setFocused(true);
			tamoGraphicsPanel.repaint();
			break;
		}
		min = Integer.parseInt(timerPanel.minuteTimeLabel.getText());
		sec = Integer.parseInt(timerPanel.secondTimeLabel.getText());
		
		// TODO Add logic to add a conditional if statement to start
		// the next session. By default, this click will be done
		// for the user.
		startFocusButton.doClick();
	}
	
	/*
	 * ##################################
	 * ##################################
	 * STATISTIC METHODS
	 * ##################################
	 * ##################################
	 */
	
	/**
	 * @brief tempMin and tempSec store the minutes
	 * and seconds that have been studied during the time
	 * that this method is called.
	 * This method calculates the total time (in seconds)
	 * the user has studied and adds to the total time.
	 * The user earns Tamo happiness based
	 * off of the amount of time studied.
	 * Finally, the user earns Tamo tokens based off of
	 * the amount of time studied.
	 */
	public void updateFocusStatistics() {
		// Update Time
		if(sessionTimeIndicator == 0) { // Only earn on focus sessions
			int timeEarned = tempSec + (tempMin * 60);
			dailyFocusEntry.setTime(dailyFocusEntry.getTime() + timeEarned); // Daily Time
			monthFocusEntry.setTime(monthFocusEntry.getTime() + timeEarned); // Month Time
			profile.setTime(profile.getTime() + timeEarned); // Total Time
			
			// Update Tokens (72 seconds = 1 Tamo token)
			profile.setTokens(profile.getTokens() + ((50 * timeEarned) / 3600));
			
			// Update Tamo Happiness
			int happinessEarned = timeEarned / 1800;
			int newHappy = (int) tamo.getHappy() + happinessEarned;
			tamo.setHappy(newHappy >= 10 ? 10 : newHappy);
			
			// Update Profile JSON
			tsGui.getProfileJsonManager().writeJsonToFile(tsGui.getProfiles());
			tsGui.updateTamoTokensLabel();
		}
	}
	
	public void resetTimer() {
		// Reset timer back to where user set it
		updateTimerInformation();
		
		// Set Tamo Image To Non-Focus
		tamoGraphicsPanel.getTamo().setFocused(false);
		tamoGraphicsPanel.resetTamoImage();
		tamoGraphicsPanel.repaint();
		
		// Enable menu, options, and start buttons again
		toggleButtons(true);
	}
	
	/**
	 * @brief Method that disables buttons from
	 * the TamoStudyGUI menu, the start focus button.
	 * Also disables the selection options for the timer.
	 * 
	 * Enables the break focus button.
	 */
	public void toggleButtons(boolean enabled) {
		// Disable menu buttons
		tsGui.toggleMenuButtons(enabled);
		
		// Disable options
		setPanel.toggleOptionButtons(enabled);
		
		// Disable Start focus
		startFocusButton.setEnabled(enabled);
		breakFocusButton.setEnabled(!enabled);
		pauseFocusButton.setEnabled(!enabled);
		
		// Re-color start / break buttons
		if(enabled) {
			// Modify colors of start button
			startFocusButton.setBackground(Theme.SUCCESS);
			startFocusButton.setForeground(Color.WHITE);
			if(profile.getSettings().getDifficulty() == 0) {
				startFocusButton.setVisible(true);
			}
			
			// Modify colors of break button
			breakFocusButton.setBackground(Theme.DANGER_ALT);
			breakFocusButton.setForeground(new Color(191, 191, 191));
			
			// Modify colors of pause button
			pauseFocusButton.setBackground(Theme.PRIMARY_ALT);
			pauseFocusButton.setForeground(new Color(191, 191, 191));
		} else {
			startFocusButton.setBackground(Theme.SUCCESS_ALT);
			startFocusButton.setForeground(new Color(191, 191, 191));
			
			if(profile.getSettings().getDifficulty() == 0) {
				startFocusButton.setVisible(false);
			}
			
			// Modify colors of break button
			breakFocusButton.setBackground(Theme.DANGER);
			breakFocusButton.setForeground(Color.WHITE);
			
			// Modify colors of pause button
			pauseFocusButton.setBackground(Theme.PRIMARY);
			pauseFocusButton.setForeground(Color.WHITE);
		}
	}
	
	public void pauseResumeTimer() {
		if(timer.isRunning()) {
			pauseFocusButton.setText("Resume Focus");
			timer.stop();
			
			timerPauseIndicator = 0;
			pauseTimer = new Timer(750, new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					if(timerPauseIndicator == 0) {
						// Color Normal
						timerPanel.minuteTimeLabel.setForeground(theme.altTextColor);
						timerPanel.colonLabel.setForeground(theme.altTextColor);
						timerPanel.secondTimeLabel.setForeground(theme.altTextColor);
						timerPauseIndicator = 1;
					} else {
						// Color Alt
						timerPanel.minuteTimeLabel.setForeground(theme.textColor);
						timerPanel.colonLabel.setForeground(theme.textColor);
						timerPanel.secondTimeLabel.setForeground(theme.textColor);
						timerPauseIndicator = 0;
					}
				}
				
			});
			pauseTimer.start();
			
		} else {
			pauseFocusButton.setText("Pause Focus");
			timer.start();
			
			if(pauseTimer.isRunning()) {
				pauseTimer.stop();
				// Set Color Normal
				timerPanel.minuteTimeLabel.setForeground(theme.textColor);
				timerPanel.colonLabel.setForeground(theme.textColor);
				timerPanel.secondTimeLabel.setForeground(theme.textColor);
			}
		}
		
	}
	
}
