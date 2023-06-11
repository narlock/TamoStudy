package state;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import components.panel.AchievementPanel;
import gui.TamoStudyGUI;
import model.GuiSize;
import model.language.Language;
import model.profile.Profile;
import resources.Constants;
import resources.Theme;

public class AchievementsState extends State {

	private static final long serialVersionUID = -7353342192190711969L;
	
	/*
	 * ##################################
	 * ##################################
	 * ATTRIBUTES
	 * ##################################
	 * ##################################
	 */
	private GuiSize guiSize;
	private Language language;
	private Profile profile;
	private Theme theme;
	
	/*
	 * ##################################
	 * ##################################
	 * COMPONENTS
	 * ##################################
	 * ##################################
	 */
	private JScrollPane scrollPane;
	private JPanel achievementsPanel;

	public AchievementsState(TamoStudyGUI tamoStudyGUI) {
		super(tamoStudyGUI);
		guiSize = tsGui.getGuiSize();
		profile = tsGui.getProfile();
		language = profile.getSettings().getLanguage();
		theme = profile.getSettings().getTheme();
		
		initializeAttributes();
		initializeComponents();
		initializeComponentVisuals();
		initializeComponentActions();
		initializePanel();
	}

	@Override
	protected void initializeAttributes() {
		
	}

	@Override
	protected void initializeComponents() {
		GridBagConstraints gbcv = new GridBagConstraints();
		gbcv.gridwidth = GridBagConstraints.REMAINDER;
		gbcv.anchor = GridBagConstraints.WEST;
		
		achievementsPanel = new JPanel(new GridBagLayout());
		achievementsPanel.setBackground(theme.mainColor);
		for(int i = 0; i < Constants.ACHIEVEMENT_COUNT; i++) {
			boolean earned = false;
			if(profile.getAchievementList().contains((long) i)) {
				earned = true;
			}
			achievementsPanel.add(new AchievementPanel(theme, guiSize, language, i, earned), gbcv);
		}
		scrollPane = new JScrollPane(achievementsPanel, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.getVerticalScrollBar().setUnitIncrement(16);
		scrollPane.setPreferredSize(guiSize.achievementScrollPaneDimension);
		scrollPane.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
	}

	@Override
	protected void initializeComponentVisuals() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void initializeComponentActions() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void initializePanel() {
		// TODO Auto-generated method stub
		this.add(scrollPane);
	}

}
