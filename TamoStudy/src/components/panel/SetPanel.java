package components.panel;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import model.language.Language;
import resources.Debug;
import resources.Theme;

public class SetPanel extends JPanel {

	private static final long serialVersionUID = -4533299272357080931L;
	
	/*
	 * ##################################
	 * ##################################
	 * ATTRIBUTES
	 * ##################################
	 * ##################################
	 */
	TimerPanel timerPanel;
	long focusMode;
	Language language;
	Theme theme;
	
	/*
	 * ##################################
	 * ##################################
	 * COMPONENTS
	 * ##################################
	 * ##################################
	 */
	
	// Pomodoro Mode
	private JPanel pomoNumberOfSessionsPanel;
	private JLabel pomoNumberOfSessionsLabel;
	public JComboBox<Integer> pomoNumberOfSessionsBox;
	private JPanel pomoSessionLengthPanel;
	private JLabel pomoSessionLengthLabel;
	public JComboBox<String> pomoSessionLengthBox;
	private JPanel pomoBreakLengthPanel;
	private JLabel pomoBreakLengthLabel;
	public JComboBox<String> pomoBreakLengthBox;
	
	// TODO Pomodoro Mode + Long Break
	private JPanel pomoLongBreakSelectionPanel;
	private JLabel pomoLongBreakSessions;
	public JButton pomoLongBreakSetButton; // TODO change dynamically based off of settings
	public Map<Integer, Integer> sessions;
	private JPanel pomoLongBreakLengthPanel;
	private JLabel pomoLongBreakLengthLabel;
	public JComboBox<String> pomoLongBreakLengthBox;
	
	// Custom Countdown Mode
	private JPanel customMinuteLengthPanel;
	private JLabel customMinuteLengthLabel;
	public JComboBox<String> customMinuteLengthBox;
	private JPanel customSecondLengthPanel;
	private JLabel customSecondLengthLabel;
	public JComboBox<String> customSecondLengthBox;
	
	// 5 Minute Countdown Interval Mode
	private JPanel fiveLengthPanel;
	private JLabel fiveLengthLabel;
	public JComboBox<String> fiveLengthBox;
	
	// Stop watch contains no components
	
	public SetPanel(Theme theme, TimerPanel timerPanel, long focusMode, Language language) {
		this.timerPanel = timerPanel;
		this.focusMode = focusMode;
		this.language = language;
		this.theme = theme;
		sessions = new HashMap<>();
		
		initializeComponents();
		initializePanel();
	}
	
	public void initializeComponents() {
		switch((int) focusMode) {
		case 0:
			// Pomodoro
			initializePomodoroSetComponents();
			break;
		case 1:
			// Custom Countdown
			initializeCustomCountdownSetComponents();
			break;
		case 2:
			// Five Min Interval Countdown
			initializeFiveIntervalCountdownSetComponents();
			break;
		case 3:
			// Stopwatch
			initializeStopwatchComponents();
			break;
		case 4:
			// Pomodoro with Long Breaks
			initializePomodoroSetComponents();
			initializePomodoroLongBreakSetComponents();
			break;
		default:
			initializePomodoroSetComponents();
			break;
		}
	}
	
	public void initializePanel() {
		this.setBackground(timerPanel.getTheme().mainColor);
		this.setBorder(timerPanel.getGuiSize().settingsPanelBorder);
	}
	
	/*
	 * ##################################
	 * ##################################
	 * POMODORO SETUP
	 * ##################################
	 * ##################################
	 */
	public void initializePomodoroSetComponents() {
		// Initialize Components
		pomoNumberOfSessionsPanel = new JPanel();
		pomoNumberOfSessionsPanel.setBackground(theme.mainColor);
		
		pomoNumberOfSessionsLabel = new JLabel(language.pomoNumberOfSessionsText);
		pomoNumberOfSessionsBox = new JComboBox<>();
		
		for(int i = 1; i <= 16; i++) {
			pomoNumberOfSessionsBox.addItem(i);
		}
		
		pomoSessionLengthPanel = new JPanel();
		pomoSessionLengthPanel.setBackground(theme.mainColor);
		
		pomoSessionLengthLabel = new JLabel(language.pomoSessionLengthText);
		pomoSessionLengthBox = new JComboBox<>();
		
		pomoBreakLengthPanel = new JPanel();
		pomoBreakLengthPanel.setBackground(theme.mainColor);
		
		pomoBreakLengthLabel = new JLabel(language.pomoBreakLengthText);
		pomoBreakLengthBox = new JComboBox<>();
		
		for(int i = 5; i <= 95; i = i + 5) {
			if(i == 5) {
				pomoSessionLengthBox.addItem("0" + i + ":00");
				pomoBreakLengthBox.addItem("0" + i + ":00");
			}
			else {
				pomoSessionLengthBox.addItem(i + ":00");
				pomoBreakLengthBox.addItem(i + ":00");
			}
		}
		
		// Component Visuals
		pomoNumberOfSessionsLabel.setForeground(timerPanel.getTheme().textColor);
		pomoNumberOfSessionsLabel.setFont(timerPanel.getGuiSize().settingsChoiceBoldFont);
		pomoNumberOfSessionsPanel.add(pomoNumberOfSessionsLabel);
		pomoNumberOfSessionsPanel.add(pomoNumberOfSessionsBox);
		
		pomoSessionLengthLabel.setForeground(timerPanel.getTheme().textColor);
		pomoSessionLengthLabel.setFont(timerPanel.getGuiSize().settingsChoiceBoldFont);
		pomoSessionLengthPanel.add(pomoSessionLengthLabel);
		pomoSessionLengthPanel.add(pomoSessionLengthBox);
		
		pomoBreakLengthLabel.setForeground(timerPanel.getTheme().textColor);
		pomoBreakLengthLabel.setFont(timerPanel.getGuiSize().settingsChoiceBoldFont);
		pomoBreakLengthPanel.add(pomoBreakLengthLabel);
		pomoBreakLengthPanel.add(pomoBreakLengthBox);
		
		// Add Components to set panel
		this.setLayout(new GridBagLayout());
		GridBagConstraints innergbcv = new GridBagConstraints();
		innergbcv.gridwidth = GridBagConstraints.REMAINDER;
		innergbcv.anchor = GridBagConstraints.WEST;
		this.add(pomoNumberOfSessionsPanel, innergbcv);
		this.add(pomoSessionLengthPanel, innergbcv);
		this.add(pomoBreakLengthPanel, innergbcv);
		
		initializePomodoroComponentActions();
	}
	
	public void initializePomodoroComponentActions() {
		pomoSessionLengthBox.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				timerPanel.minuteTimeLabel.setText(((String) pomoSessionLengthBox.getSelectedItem()).substring(0, 2));
				timerPanel.secondTimeLabel.setText(((String) pomoSessionLengthBox.getSelectedItem()).substring(3));
			}
			
		});
		// Initialize Values
		timerPanel.minuteTimeLabel.setText(((String) pomoSessionLengthBox.getSelectedItem()).substring(0, 2));
		timerPanel.secondTimeLabel.setText(((String) pomoSessionLengthBox.getSelectedItem()).substring(3));
	}
	
	/*
	 * ##################################
	 * ##################################
	 * CUSTOM COUNTDOWN SETUP
	 * ##################################
	 * ##################################
	 */
	public void initializeCustomCountdownSetComponents() {
		// Initialize Components
		customMinuteLengthPanel = new JPanel();
		customMinuteLengthPanel.setBackground(theme.mainColor);
		
		customMinuteLengthLabel = new JLabel(language.minutesText);
		customMinuteLengthBox = new JComboBox<>();
		
		for(int i = 0; i <= 99; i++) {
			if(i < 10) {
				customMinuteLengthBox.addItem("0" + i);
			} else {
				customMinuteLengthBox.addItem("" + i);
			}
		}
		
		customSecondLengthPanel = new JPanel();
		customSecondLengthPanel.setBackground(theme.mainColor);
		
		customSecondLengthLabel = new JLabel(language.secondsText);
		customSecondLengthBox = new JComboBox<>();
		
		for(int i = 1; i <= 59; i++) {
			if(i < 10) {
				customSecondLengthBox.addItem("0" + i);
			}
			else {
				customSecondLengthBox.addItem("" + i);
			}
			
		}
		
		// Initalize Component Visual
		customMinuteLengthLabel.setForeground(timerPanel.getTheme().textColor);
		customMinuteLengthLabel.setFont(timerPanel.getGuiSize().settingsChoiceBoldFont);
		customMinuteLengthPanel.add(customMinuteLengthLabel);
		customMinuteLengthPanel.add(customMinuteLengthBox);
		
		customSecondLengthLabel.setForeground(timerPanel.getTheme().textColor);
		customSecondLengthLabel.setFont(timerPanel.getGuiSize().settingsChoiceBoldFont);
		customSecondLengthPanel.add(customSecondLengthLabel);
		customSecondLengthPanel.add(customSecondLengthBox);
		
		// Add Components to set panel
		this.setLayout(new GridBagLayout());
		GridBagConstraints innergbcv = new GridBagConstraints();
		innergbcv.gridwidth = GridBagConstraints.REMAINDER;
		innergbcv.anchor = GridBagConstraints.WEST;
		this.add(customMinuteLengthPanel, innergbcv);
		this.add(customSecondLengthPanel, innergbcv);
		
		timerPanel.minuteTimeLabel.setText(((String) customMinuteLengthBox.getSelectedItem()));
		timerPanel.secondTimeLabel.setText(((String) customSecondLengthBox.getSelectedItem()));
		
		initializeCustomCountdownComponentActions();
	}
	
	public void initializeCustomCountdownComponentActions() {
		customMinuteLengthBox.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				timerPanel.minuteTimeLabel.setText(((String) customMinuteLengthBox.getSelectedItem()));
			}
		});
		
		customSecondLengthBox.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				timerPanel.secondTimeLabel.setText(((String) customSecondLengthBox.getSelectedItem()));
			}
		});
	}
	
	/*
	 * ##################################
	 * ##################################
	 * FIVE MIN INTERVAL SETUP
	 * ##################################
	 * ##################################
	 */
	public void initializeFiveIntervalCountdownSetComponents() {
		// Initialize Components
		fiveLengthPanel = new JPanel();
		fiveLengthPanel.setBackground(theme.mainColor);
		
		fiveLengthLabel = new JLabel(language.durationText);
		fiveLengthBox = new JComboBox<>();
		
		for(int i = 5; i <= 95; i = i + 5) {
			if(i == 5)
				fiveLengthBox.addItem("0" + i + ":00");
			else
				fiveLengthBox.addItem(i + ":00");
		}

		// Initalize Component Visual
		fiveLengthLabel.setForeground(timerPanel.getTheme().textColor);
		fiveLengthLabel.setFont(timerPanel.getGuiSize().settingsChoiceBoldFont);
		fiveLengthPanel.add(fiveLengthLabel);
		fiveLengthPanel.add(fiveLengthBox);
		
		// Add Components to set panel
		this.setLayout(new GridBagLayout());
		GridBagConstraints innergbcv = new GridBagConstraints();
		innergbcv.gridwidth = GridBagConstraints.REMAINDER;
		innergbcv.anchor = GridBagConstraints.WEST;
		this.add(fiveLengthPanel, innergbcv);
		initializeFiveIntervalCountdownComponentActions();
	}
	
	public void initializeFiveIntervalCountdownComponentActions() {
		fiveLengthBox.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				timerPanel.minuteTimeLabel.setText(((String) fiveLengthBox.getSelectedItem()).substring(0, 2));
				timerPanel.secondTimeLabel.setText(((String) fiveLengthBox.getSelectedItem()).substring(3));
			}
		});
		
		// Initialize Values
		timerPanel.minuteTimeLabel.setText(((String) fiveLengthBox.getSelectedItem()).substring(0, 2));
		timerPanel.secondTimeLabel.setText(((String) fiveLengthBox.getSelectedItem()).substring(3));
	}
	
	/*
	 * ##################################
	 * ##################################
	 * STOPWATCH SETUP
	 * ##################################
	 * ##################################
	 */
	
	/*
	 * No components are needed for the stop watch setting.
	 * The stopwatch will essentially count up, and then
	 * reset when it hits 99:59. After this, the timer will
	 * go back to 00:00, and the user will gain a 'loop'.
	 * A loop is defined simply as 99 minutes and 59 seconds
	 * studied. Since our timer can't display more than that,
	 * we will just count is as a loop to the user. 
	 */
	
	public void initializeStopwatchComponents() {
		// Nothing at the moment
	}
	
	/*
	 * ##################################
	 * ##################################
	 * POMODORO LONG BREAK SETUP
	 * ##################################
	 * ##################################
	 */
	public void initializePomodoroLongBreakSetComponents() {
		/*
		 * TODO
		 * 
		 * This will be called in addition to the regular pomodoro components.
		 * In here we will want to add the long break components and add them
		 * to this.
		 */
		pomoLongBreakSelectionPanel = new JPanel();
		pomoLongBreakSelectionPanel.setBackground(theme.mainColor);
		pomoLongBreakSessions = new JLabel("Long Break");
		pomoLongBreakSessions.setForeground(timerPanel.getTheme().textColor);
		pomoLongBreakSessions.setFont(timerPanel.getGuiSize().settingsChoiceBoldFont);
		pomoLongBreakSetButton = new JButton("Configure");
		pomoLongBreakSelectionPanel.add(pomoLongBreakSessions);
		pomoLongBreakSelectionPanel.add(pomoLongBreakSetButton);
		
		pomoLongBreakLengthPanel = new JPanel();
		pomoLongBreakLengthPanel.setBackground(theme.mainColor);
		pomoLongBreakLengthLabel = new JLabel("Long Break Length");
		pomoLongBreakLengthLabel.setForeground(timerPanel.getTheme().textColor);
		pomoLongBreakLengthBox = new JComboBox<>();
		for(int i = 5; i <= 95; i = i + 5) {
			if(i == 5) {
				pomoLongBreakLengthBox.addItem("0" + i + ":00");
			}
			else {
				pomoLongBreakLengthBox.addItem(i + ":00");
			}
		}
		pomoLongBreakLengthPanel.add(pomoLongBreakLengthLabel);
		pomoLongBreakLengthPanel.add(pomoLongBreakLengthBox);
		
		GridBagConstraints innergbcv = new GridBagConstraints();
		innergbcv.gridwidth = GridBagConstraints.REMAINDER;
		innergbcv.anchor = GridBagConstraints.WEST;
		this.add(pomoLongBreakLengthPanel, innergbcv);
		this.add(pomoLongBreakSelectionPanel, innergbcv);
		
		initializePomodoroLongBreakComponentActions();
	}
	
	public void initializePomodoroLongBreakComponentActions() {
		pomoNumberOfSessionsBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				sessions.clear(); // Ensure sessions is empty
				int numberOfSessions = pomoNumberOfSessionsBox.getSelectedIndex() + 1;
				for(int i = 1; i <= numberOfSessions; i++) {
					sessions.put(i, 0); // 0 represents short break, 1 for long break
				}
				Debug.info("SetPanel.pomoNumberOfSessionsBox.actionPerfomed", "Pomodoro sessions set to " + sessions.size());
			}
			// Long breaks will be set using the long break set box.
		});
		
		pomoLongBreakSetButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(sessions.size() <= 1) {
					JOptionPane.showMessageDialog(getRootPane(), "<html>To configure long break, you must<br>do more than 1 session.</html>", "TamoStudy", JOptionPane.INFORMATION_MESSAGE, new ImageIcon(getClass().getClassLoader().getResource("INFO.png")));
				} else {
					LongBreakSetPanel longBreakSetPanel = new LongBreakSetPanel(theme, sessions);
					JOptionPane.showMessageDialog(getRootPane(), longBreakSetPanel, "TamoStudy", JOptionPane.INFORMATION_MESSAGE, new ImageIcon(getClass().getClassLoader().getResource("INFO.png")));
					for(int i = 1; i <= sessions.size(); i++) {
						System.out.println("sessions[" + i + "] = " + sessions.get(i));
					}
				}
				
			}
			
		});
	}
	
	/*
	 * ##################################
	 * ##################################
	 * HELPER METHODS
	 * ##################################
	 * ##################################
	 */
	public void toggleOptionButtons(boolean enabled) {
		switch((int) focusMode) {
		case 0:
			// Toggle Pomodoro Options
			pomoNumberOfSessionsBox.setEnabled(enabled);
			pomoSessionLengthBox.setEnabled(enabled);
			pomoBreakLengthBox.setEnabled(enabled);
			break;
		case 1:
			// Toggle Custom Countdown Options
			customMinuteLengthBox.setEnabled(enabled);
			customSecondLengthBox.setEnabled(enabled);
			break;
		case 2:
			// Toggle Five Min Interval Countdown Options
			fiveLengthBox.setEnabled(enabled);
			break;
		case 3:
			break;
		case 4:
			// Toggle Pomodoro with Long Breaks Options
			pomoNumberOfSessionsBox.setEnabled(enabled);
			pomoSessionLengthBox.setEnabled(enabled);
			pomoBreakLengthBox.setEnabled(enabled);
			pomoLongBreakSetButton.setEnabled(enabled);
			pomoLongBreakLengthBox.setEnabled(enabled);
			break;
		default:
			// Toggle Pomodoro Options
			pomoNumberOfSessionsBox.setEnabled(enabled);
			pomoSessionLengthBox.setEnabled(enabled);
			pomoBreakLengthBox.setEnabled(enabled);
			break;
		}
	}
	
}
