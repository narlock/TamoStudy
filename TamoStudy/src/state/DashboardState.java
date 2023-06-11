package state;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.plaf.basic.BasicProgressBarUI;

import components.panel.TamoGraphicsPanel;
import gui.TamoStudyGUI;
import model.GuiSize;
import model.language.Language;
import model.profile.Profile;
import model.profile.Tamo;
import model.time.DailyFocusEntry;
import model.time.MonthFocusEntry;
import resources.Constants;
import resources.Theme;
import util.Utils;

public class DashboardState extends State {
	
	private static final long serialVersionUID = -774794028854162351L;
	
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
	private JLabel tamoStudyLogoImageLabel;
	private JLabel versionLabel;
	private JPanel tamoDashboardPanel;				// Grid Panel
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
	
	public DashboardState(TamoStudyGUI tamoStudyGUI) {
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
	}

	@Override
	protected void initializeComponents() {
		tamoStudyLogoImageLabel = new JLabel(guiSize.getTamoStudyLogoImage());
		versionLabel = new JLabel(Constants.version);
		
		tamoDashboardPanel = new JPanel();
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
		
	}

	@Override
	protected void initializeComponentVisuals() {
		versionLabel.setFont(guiSize.versionFont);
		versionLabel.setForeground(theme.layerTextColor);
		
		tamoDashboardPanel.setBackground(theme.subColor);
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
		
		
		tamoDashboardPanel.add(tamoGraphicsPanel);
		tamoDashboardPanel.add(tamoInfoPanel);
	}

	@Override
	protected void initializeComponentActions() {
		// No actions in Dash board state
	}

	@Override
	protected void initializePanel() {
		GridBagConstraints gbcv = new GridBagConstraints();
		gbcv.gridwidth = GridBagConstraints.REMAINDER;
		this.setLayout(new GridBagLayout());
		
		// TODO Re-scale the image for small window and then get rid of this
		if(guiSize.index != 0) {
			this.add(tamoStudyLogoImageLabel, gbcv);
		}
		
		this.add(tamoDashboardPanel, gbcv);
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
