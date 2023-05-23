package components.panel;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

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
	private JPanel pomoLongBreakAfterXSessionsPanel;
	private JLabel pomoLongBreakAfterXSessionsLabel;
	public JComboBox<String> pomoLongBreakAfterXSessionsBox; // TODO change dynamically based off of settings
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
	
	public SetPanel(TimerPanel timerPanel, long focusMode) {
		this.timerPanel = timerPanel;
		this.focusMode = focusMode;
		
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
		pomoNumberOfSessionsLabel = new JLabel("No. Of Sessions");
		pomoNumberOfSessionsBox = new JComboBox<>();
		
		for(int i = 1; i <= 16; i++) {
			pomoNumberOfSessionsBox.addItem(i);
		}
		
		pomoSessionLengthPanel = new JPanel();
		pomoSessionLengthLabel = new JLabel("Session Length");
		pomoSessionLengthBox = new JComboBox<>();
		
		pomoBreakLengthPanel = new JPanel();
		pomoBreakLengthLabel = new JLabel("Break Length");
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
		customMinuteLengthLabel = new JLabel("Minutes");
		customMinuteLengthBox = new JComboBox<>();
		
		for(int i = 0; i <= 99; i++) {
			if(i < 10) {
				customMinuteLengthBox.addItem("0" + i);
			} else {
				customMinuteLengthBox.addItem("" + i);
			}
		}
		
		customSecondLengthPanel = new JPanel();
		customSecondLengthLabel = new JLabel("Seconds");
		customSecondLengthBox = new JComboBox<>();
		
		for(int i = 0; i <= 60; i++) {
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
		fiveLengthLabel = new JLabel("Duration");
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
		
		// Initialize Components
		
		// Initalize Component Visual
		
		// Add Components to set panel
		
		initializePomodoroLongBreakComponentActions();
	}
	
	public void initializePomodoroLongBreakComponentActions() {
		
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
		case 4:
			// Toggle Pomodoro with Long Breaks Options
			pomoNumberOfSessionsBox.setEnabled(enabled);
			pomoSessionLengthBox.setEnabled(enabled);
			pomoBreakLengthBox.setEnabled(enabled);
			pomoLongBreakAfterXSessionsBox.setEnabled(enabled);
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
