package state;

import java.awt.Color;
import java.awt.Dimension;
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
import model.profile.Profile;
import model.profile.Tamo;
import resources.Theme;

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
	private GuiSize guiSize;
	private Tamo tamo;
	private Theme theme;

	/*
	 * ##################################
	 * ##################################
	 * COMPONENTS
	 * ##################################
	 * ##################################
	 */
	private JLabel tamoStudyLogoImageLabel;
	private JPanel tamoDashboardPanel;				// Grid Panel
	private TamoGraphicsPanel tamoGraphicsPanel; 	// LHS
	private JPanel tamoInfoPanel; 					// RHS
	private JLabel tamoNameLabel;
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
		this.profile = tsGui.getProfile();
		this.guiSize = new GuiSize((int) profile.getSettings().getGuiSize());
		this.tamo = profile.getTamo();
		this.theme = Theme.DARK;
	}

	@Override
	protected void initializeComponents() {
		tamoStudyLogoImageLabel = new JLabel(guiSize.tamoStudyLogoImageIcon);
		tamoDashboardPanel = new JPanel(new GridBagLayout());
		tamoGraphicsPanel = new TamoGraphicsPanel(guiSize, tamo, profile.getBackgroundIndicator(), profile.getBorderIndicator());
		
		tamoInfoPanel = new JPanel(new GridBagLayout());
		tamoNameLabel = new JLabel(tamo.getName());
		tamoHoursTodayLabel = new JLabel("Today's Focus: 4 hrs");
		tamoHoursMonthLabel = new JLabel("Month Focus: 10 hrs");
		tamoHoursAllLabel = new JLabel("Total Focus: 34 hrs");
		tamoLevelLabel = new JLabel("Level " + tamo.getLevel());
		levelProgressBar = new JProgressBar(0, 100);
		
	}

	@Override
	protected void initializeComponentVisuals() {
		tamoInfoPanel.setBackground(theme.subColor);
		
		tamoNameLabel.setFont(guiSize.messageLabelFont);
		tamoNameLabel.setForeground(theme.textColor);
		
		tamoHoursAllLabel.setFont(guiSize.statisticsInfoFont);
		tamoHoursAllLabel.setForeground(theme.textColor);
		tamoHoursMonthLabel.setFont(guiSize.statisticsInfoFont);
		tamoHoursMonthLabel.setForeground(theme.textColor);
		tamoHoursTodayLabel.setFont(guiSize.statisticsInfoFont);
		tamoHoursTodayLabel.setForeground(theme.textColor);
		
		tamoLevelLabel.setFont(guiSize.statisticsInfoFontBold);
		tamoLevelLabel.setForeground(theme.textColor);
		
		levelProgressBar.setOpaque(true);
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
		
		tamoInfoPanel.setPreferredSize(new Dimension(215, 315));
		tamoInfoPanel.add(tamoNameLabel, gbcv);
		tamoInfoPanel.add(createSpaceLabel(), gbcv);
		tamoInfoPanel.add(tamoHoursTodayLabel, gbcv);
		tamoInfoPanel.add(tamoHoursMonthLabel, gbcv);
		tamoInfoPanel.add(tamoHoursAllLabel, gbcv);
		tamoInfoPanel.add(createSpaceLabel(), gbcv);
		tamoInfoPanel.add(tamoLevelLabel, gbcv);
		tamoInfoPanel.add(Box.createVerticalStrut(guiSize.settingsVerticalDifference), gbcv);
		tamoInfoPanel.add(levelProgressBar, gbcv);
		
		
		tamoDashboardPanel.add(tamoGraphicsPanel, gbch);
		tamoDashboardPanel.add(tamoInfoPanel, gbch);
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
		this.add(tamoStudyLogoImageLabel, gbcv);
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
				? "━━━━━━━━━━━━━━━━━━ " : "━━━━━━━";
		
		JLabel label = new JLabel(DIVIDER);
		label.setFont(guiSize.topMenuFont);
		label.setForeground(theme.altTextColor);
		return label;
	}
	
}
