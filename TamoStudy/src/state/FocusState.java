package state;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

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
	private JButton startFocusButton, breakFocusButton;

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
		setPanel = new SetPanel(timerPanel, profile.getSettings().getFocusMode());
		buttonPanel = new JPanel();
		startFocusButton = new JButton("Start Focus");
		breakFocusButton = new JButton("Break Focus");
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
		tamoPanel.add(tamoGraphicsPanel, gbcv);
		tamoPanel.add(tamoHappyHungerPanel, gbcv);
		
		// Timer Set Panel
		startFocusButton.setBackground(Theme.SUCCESS);
		startFocusButton.setFont(theme.fontBoldRegSmall);
		startFocusButton = guiSize.scaleSuccessJButton(startFocusButton, guiSize.getScaleFromSize((int) profile.getSettings().getGuiSize()));
		
		breakFocusButton.setBackground(Theme.DANGER);
		breakFocusButton.setFont(theme.fontBoldRegSmall);
		breakFocusButton = guiSize.scaleDangerJButton(breakFocusButton, guiSize.getScaleFromSize((int) profile.getSettings().getGuiSize()));
		
		buttonPanel.setBackground(theme.subColor);
		buttonPanel.add(startFocusButton);
		buttonPanel.add(breakFocusButton);
		
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
				disableFocusButtons();
				
				//Create Timer
				createTimer();
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
			break;
		case 1:
			// Custom Countdown
			timerPanel.minuteTimeLabel.setText(((String) setPanel.customMinuteLengthBox.getSelectedItem()));
			timerPanel.secondTimeLabel.setText(((String) setPanel.customSecondLengthBox.getSelectedItem()));
			break;
		case 2:
			// Five Min Interval Countdown
			timerPanel.minuteTimeLabel.setText(((String) setPanel.fiveLengthBox.getSelectedItem()).substring(0, 2));
			timerPanel.secondTimeLabel.setText(((String) setPanel.fiveLengthBox.getSelectedItem()).substring(3));
			break;
		case 4:
			// Pomodoro with Long Breaks
			// TODO
			break;
		default:
			// Pomodoro
			timerPanel.minuteTimeLabel.setText(((String) setPanel.pomoSessionLengthBox.getSelectedItem()).substring(0, 2));
			timerPanel.secondTimeLabel.setText(((String) setPanel.pomoSessionLengthBox.getSelectedItem()).substring(3));
			break;
		}
		
	}
	
	public void setFocusInformation() {
		
	}
	
	public void disableFocusButtons() {
		
	}
	
	public void createTimer() {
		
	}
}
