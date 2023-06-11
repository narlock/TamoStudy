package state;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.plaf.basic.BasicProgressBarUI;

import components.panel.HoursInPastPanel;
import components.panel.TamoGraphicsPanel;
import gui.TamoStudyGUI;
import io.DailyFocusJsonManager;
import model.GuiSize;
import model.language.Language;
import model.profile.Profile;
import model.profile.Tamo;
import model.time.DailyFocus;
import model.time.DailyFocusEntry;
import model.time.MonthFocusEntry;
import resources.Theme;
import util.Utils;

public class StatisticsState extends State {

	private static final long serialVersionUID = 1058419726546781724L;
	
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
	private JPanel statisticsPanel;
	private TamoGraphicsPanel tamoGraphicsPanel; 	// LHS
	private JPanel tamoInfoPanel; 					// RHS
	private JLabel tamoNameLabel;
	private JLabel tamoHappyLabel;
	private JLabel tamoHungerLabel;
	private JLabel tamoHoursTodayLabel;
	private JLabel tamoHoursMonthLabel;
	private JLabel tamoHoursAllLabel;
	private JLabel tamoLevelLabel;
	private JProgressBar levelProgressBar;
	
	private DailyFocus profileDailyFocus;
	private HoursInPastPanel hoursInPastPanel;

	public StatisticsState(TamoStudyGUI tamoStudyGUI) {
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
		theme = profile.getSettings().getTheme();
		
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
		
		DailyFocusJsonManager dailyFocusJsonManager = new DailyFocusJsonManager();
		List<DailyFocus> dailyFocusList = dailyFocusJsonManager.readJson();
		for(DailyFocus dailyFocus : dailyFocusList) {
			if(dailyFocus.getProfileId() == profile.getId()) {
				profileDailyFocus = dailyFocus;
			}
		}
	}

	@Override
	protected void initializeComponents() {
		statisticsPanel = new JPanel();
		tamoGraphicsPanel = new TamoGraphicsPanel(guiSize, tamo, profile.getBackgroundIndicator(), profile.getBorderIndicator());
		tamoInfoPanel = new JPanel(new GridBagLayout());
		tamoNameLabel = new JLabel(tamo.getName());
		tamoHappyLabel = new JLabel("" + tamo.getHappy());
		tamoHungerLabel = new JLabel("" + tamo.getHunger());
		tamoHoursTodayLabel = new JLabel(language.todaysFocusText + ": " + Utils.convertSecondsToHours(dailyFocusEntry.getTime()) + " " + language.hoursText);
		tamoHoursMonthLabel = new JLabel(language.monthFocusText + ": " + Utils.convertSecondsToHours(monthFocusEntry.getTime()) + " " + language.hoursText);
		tamoHoursAllLabel = new JLabel(language.totalFocusText + ": " + Utils.convertSecondsToHours(profile.getTime()) + " " + language.hoursText);
		tamoLevelLabel = new JLabel(language.levelText + " " + tamo.getLevel());
		levelProgressBar = new JProgressBar(0, 100);
		
		hoursInPastPanel = new HoursInPastPanel(theme, profileDailyFocus.getDailyFocusEntries(), guiSize);
	}

	@Override
	protected void initializeComponentVisuals() {
		statisticsPanel.setBackground(theme.subColor);
		tamoInfoPanel.setBackground(theme.subColor);
		
		tamoNameLabel.setFont(guiSize.messageLabelFont);
		tamoNameLabel.setForeground(theme.textColor);
		
		tamoHappyLabel.setFont(guiSize.statisticsInfoFontBold);
		tamoHappyLabel.setForeground(theme.textColor);
		tamoHappyLabel.setIcon(guiSize.heartImageIcon);
		
		tamoHungerLabel.setFont(guiSize.statisticsInfoFontBold);
		tamoHungerLabel.setForeground(theme.textColor);
		tamoHungerLabel.setIcon(guiSize.onigiriImageIcon);
		
		tamoHoursAllLabel.setFont(guiSize.statisticsInfoFont);
		tamoHoursAllLabel.setForeground(theme.textColor);
		tamoHoursMonthLabel.setFont(guiSize.statisticsInfoFont);
		tamoHoursMonthLabel.setForeground(theme.textColor);
		tamoHoursTodayLabel.setFont(guiSize.statisticsInfoFont);
		tamoHoursTodayLabel.setForeground(theme.textColor);
		
		tamoLevelLabel.setFont(guiSize.statisticsInfoFontBold);
		tamoLevelLabel.setForeground(theme.textColor);
		
		levelProgressBar.setOpaque(true);
		levelProgressBar.setFont(guiSize.statisticsInfoFont);
		levelProgressBar.setForeground(Theme.SUCCESS);
		levelProgressBar.setBackground(theme.mainColor);
		levelProgressBar.setBorder(BorderFactory.createLineBorder(theme.textColor, 1));
		levelProgressBar.setUI(new BasicProgressBarUI() {
		    protected Color getSelectionBackground() {
		        return Color.WHITE; // set the color of the progress bar
		    }
		    protected Color getSelectionForeground() {
		        return Color.BLACK; // set the color of the text on the progress bar
		    }
		});
		levelProgressBar.setStringPainted(true);
		levelProgressBar.setValue(tamo.levelProgress());
		
		GridBagConstraints gbcv = new GridBagConstraints();
		gbcv.gridwidth = GridBagConstraints.REMAINDER;
		
		GridBagConstraints gbch = new GridBagConstraints();
		gbch.gridheight = GridBagConstraints.REMAINDER;
		
		tamoInfoPanel.add(tamoNameLabel, gbcv);
		tamoInfoPanel.add(createSpaceLabel(), gbcv);
		tamoInfoPanel.add(tamoHappyLabel, gbcv);
		tamoInfoPanel.add(Box.createVerticalStrut(guiSize.settingsVerticalDifference), gbcv);
		tamoInfoPanel.add(tamoHungerLabel, gbcv);
		tamoInfoPanel.add(createSpaceLabel(), gbcv);
		tamoInfoPanel.add(tamoHoursTodayLabel, gbcv);
		tamoInfoPanel.add(tamoHoursMonthLabel, gbcv);
		tamoInfoPanel.add(tamoHoursAllLabel, gbcv);
		tamoInfoPanel.add(createSpaceLabel(), gbcv);
		tamoInfoPanel.add(tamoLevelLabel, gbcv);
		tamoInfoPanel.add(Box.createVerticalStrut(guiSize.settingsVerticalDifference), gbcv);
		tamoInfoPanel.add(levelProgressBar, gbcv);
		
		statisticsPanel.add(tamoGraphicsPanel);
		statisticsPanel.add(tamoInfoPanel);
	}

	@Override
	protected void initializeComponentActions() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void initializePanel() {
		GridBagConstraints gbcv = new GridBagConstraints();
		gbcv.gridwidth = GridBagConstraints.REMAINDER;
		this.setLayout(new GridBagLayout());
		this.add(statisticsPanel, gbcv);
		// TODO Add Github-like contribution calendar
		this.add(hoursInPastPanel, gbcv);
	}

	/*
	 * ##################################
	 * ##################################
	 * HELPER METHODS
	 * ##################################
	 * ##################################
	 */
	
	public JLabel createSpaceLabel() {
		String DIVIDER = (System.getProperty("os.name").startsWith("Linux") || System.getProperty("os.name").startsWith("Windows"))
				? "────────────" : "━━━━━━━";
		
		JLabel label = new JLabel(DIVIDER);
		label.setFont(guiSize.topMenuFont);
		label.setForeground(theme.altTextColor);
		return label;
	}
}
