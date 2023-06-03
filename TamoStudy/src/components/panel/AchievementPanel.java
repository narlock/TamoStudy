package components.panel;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import model.GuiSize;
import model.language.Language;
import resources.Achievements;
import resources.Theme;

/**
 * AchievementPanel
 * @author narlock
 * @brief An individual achievement represented as a panel.
 * The achievement panel will contain components 
 *
 */
public class AchievementPanel extends JPanel {

	private static final long serialVersionUID = 4615565255974024312L;

	/*
	 * ##################################
	 * ##################################
	 * ATTRIBUTES
	 * ##################################
	 * ##################################
	 */
	private GuiSize guiSize;
	private Language language;
	private Theme theme;
	private int indicator;
	private boolean earned;
	
	/*
	 * ##################################
	 * ##################################
	 * COMPONENTS
	 * ##################################
	 * ##################################
	 */
	private JLabel achievementIconLabel;
	
	private JPanel achievementTextPanel;
	private JLabel achievementTitleLabel;
	private JLabel achievementDescriptionLabel;
	
	public AchievementPanel(GuiSize guiSize, Language language, int indicator, boolean earned) {
		this.guiSize = guiSize;
		this.language = language;
		this.indicator = indicator;
		this.earned = earned;
		this.theme = Theme.DARK;
		
		initializeComponents();
		initializePanel();
	}
	
	public void initializeComponents() {
		achievementIconLabel = new JLabel(Achievements.getAchievementIconByIndicator(earned, indicator, guiSize));
		achievementTextPanel = new JPanel(new GridLayout(2, 1));
		achievementTitleLabel = new JLabel(Achievements.getAchievementTitleByIndicator(indicator));
		achievementTitleLabel.setFont(guiSize.achievementTitleLabelFont);
		achievementTitleLabel.setForeground(theme.textColor);
		achievementDescriptionLabel = new JLabel(Achievements.getAchievementDescriptionByIndicator(indicator));
		achievementDescriptionLabel.setFont(guiSize.achievementDescriptionLabelFont);
		achievementDescriptionLabel.setForeground(theme.textColor);
		achievementTextPanel.add(achievementTitleLabel);
		achievementTextPanel.add(achievementDescriptionLabel);
	}
	
	public void initializePanel() {
		this.add(achievementIconLabel, BorderLayout.WEST);
		this.add(achievementTextPanel, BorderLayout.CENTER);
	}
	
	
	
	
}
