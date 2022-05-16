package state;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import profile.Profile;

public class AchievementsStrategy extends StateStrategy {
	
	public AchievementsStrategy(Profile profile) {
		super(profile);
		// TODO Auto-generated constructor stub
	}

	//Header
	private JLabel achievementsHeaderLabel;
	
	//Achievement Panels
	private JPanel hoursPanel;
	private JPanel customPanel;
	private JPanel maxPanel;
	private JPanel timePanel;

	@Override
	public void setPanel() {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setBackground(theme.subColor);
		
		achievementsHeaderLabel = new JLabel(profile.getLanguage().text[8]);
			achievementsHeaderLabel.setForeground(theme.textColor);
			achievementsHeaderLabel.setFont(theme.fontBoldReg);
			achievementsHeaderLabel.setAlignmentX(JComponent.CENTER_ALIGNMENT);
		this.add(achievementsHeaderLabel);
		
		this.add(createSpaceLabel(0));
		
		hoursPanel = new JPanel();
		setPanelComponent(hoursPanel);
		hoursPanel.add(createAchievementLabel(
				profile.getLanguage().ahmTitle[0], profile.getLanguage().ahmText[0], "AHM_1.png"));
		hoursPanel.add(createAchievementLabel(
				profile.getLanguage().ahmTitle[1], profile.getLanguage().ahmText[1], "AHM_1.png"));
		hoursPanel.add(createAchievementLabel(
				profile.getLanguage().ahmTitle[2], profile.getLanguage().ahmText[2], "AHM_1.png"));
		this.add(hoursPanel);
		
		this.add(createSpaceLabel(0));
		
		customPanel = new JPanel();
		setPanelComponent(customPanel);
		customPanel.add(createAchievementLabel(
				profile.getLanguage().ahmTitle[3], profile.getLanguage().ahmText[3], "AHM_1.png"));
		customPanel.add(createAchievementLabel(
				profile.getLanguage().ahmTitle[4], profile.getLanguage().ahmText[4], "AHM_1.png"));
		customPanel.add(createAchievementLabel(
				profile.getLanguage().ahmTitle[5], profile.getLanguage().ahmText[5], "AHM_1.png"));
		this.add(customPanel);
		
		this.add(createSpaceLabel(0));
		
		maxPanel = new JPanel();
		setPanelComponent(maxPanel);
		maxPanel.add(createAchievementLabel(
				profile.getLanguage().ahmTitle[6], profile.getLanguage().ahmText[6], "AHM_1.png"));
		maxPanel.add(createAchievementLabel(
				profile.getLanguage().ahmTitle[7], profile.getLanguage().ahmText[7], "AHM_1.png"));
		maxPanel.add(createAchievementLabel(
				profile.getLanguage().ahmTitle[8], profile.getLanguage().ahmText[8], "AHM_1.png"));
		this.add(maxPanel);
		
		this.add(createSpaceLabel(0));
		
		timePanel = new JPanel();
		setPanelComponent(timePanel);
		timePanel.add(createAchievementLabel(
				profile.getLanguage().ahmTitle[9], profile.getLanguage().ahmText[9], "AHM_1.png"));
		timePanel.add(createAchievementLabel(
				profile.getLanguage().ahmTitle[10], profile.getLanguage().ahmText[10], "AHM_1.png"));
		timePanel.add(createAchievementLabel(
				profile.getLanguage().ahmTitle[11], profile.getLanguage().ahmText[11], "AHM_1.png"));
		this.add(timePanel);
		
		this.add(createSpaceLabel(0));
	}

	@Override
	public void setActions() {
		// TODO Auto-generated method stub
		
	}
	
	public void setPanelComponent(JPanel panel) {
		panel.setLayout(new GridLayout(1,3,30,30));
		panel.setBackground(theme.subColor);
		panel.setAlignmentX(JComponent.CENTER_ALIGNMENT);
	}
	
	public JPanel createAchievementLabel(String title, String desc, String imageUrl) {
		JPanel panel = new JPanel();
			panel.setBackground(theme.layerColor);
			panel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
			panel.setLayout(new BorderLayout());
		JLabel imgLabel = new JLabel(new ImageIcon(getClass().getClassLoader().getResource(imageUrl)));
		
		JPanel textPanel = new JPanel();
			textPanel.setBackground(theme.layerColor);
			textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.Y_AXIS));
			
		JLabel achievementLabel = new JLabel(title);
			achievementLabel.setForeground(theme.textColor);
			achievementLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		JLabel descLabel = new JLabel("<html>" + desc + "</html>");
			descLabel.setForeground(theme.textColor);
			descLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
			
		textPanel.add(achievementLabel);
		textPanel.add(descLabel);
		
		panel.add(imgLabel, BorderLayout.WEST);
		panel.add(textPanel, BorderLayout.CENTER);
		
		return panel;
	}
}
