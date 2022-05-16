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
		this.setBackground(subColor);
		
		achievementsHeaderLabel = new JLabel("Achievements");
			achievementsHeaderLabel.setForeground(textColor);
			achievementsHeaderLabel.setFont(fontBoldReg);
			achievementsHeaderLabel.setAlignmentX(JComponent.CENTER_ALIGNMENT);
		this.add(achievementsHeaderLabel);
		
		this.add(createSpaceLabel(0));
		
		hoursPanel = new JPanel();
		setPanelComponent(hoursPanel);
		hoursPanel.add(createAchievementLabel(
				"The Beginning", "<html>Reach total focus time<br> of 3 hours</html>", "AHM_1.png"));
		hoursPanel.add(createAchievementLabel(
				"The Beginning", "<html>Reach total focus time<br> of 3 hours</html>", "AHM_1.png"));
		hoursPanel.add(createAchievementLabel(
				"The Beginning", "<html>Reach total focus time<br> of 3 hours</html>", "AHM_1.png"));
		this.add(hoursPanel);
		
		this.add(createSpaceLabel(0));
		
		customPanel = new JPanel();
		setPanelComponent(customPanel);
		customPanel.add(createAchievementLabel(
				"The Beginning", "<html>Reach total focus time<br> of 3 hours</html>", "AHM_1.png"));
		customPanel.add(createAchievementLabel(
				"The Beginning", "<html>Reach total focus time<br> of 3 hours</html>", "AHM_1.png"));
		customPanel.add(createAchievementLabel(
				"The Beginning", "<html>Reach total focus time<br> of 3 hours</html>", "AHM_1.png"));
		this.add(customPanel);
		
		this.add(createSpaceLabel(0));
		
		maxPanel = new JPanel();
		setPanelComponent(maxPanel);
		maxPanel.add(createAchievementLabel(
				"The Beginning", "<html>Reach total focus time<br> of 3 hours</html>", "AHM_1.png"));
		maxPanel.add(createAchievementLabel(
				"The Beginning", "<html>Reach total focus time<br> of 3 hours</html>", "AHM_1.png"));
		maxPanel.add(createAchievementLabel(
				"The Beginning", "<html>Reach total focus time<br> of 3 hours</html>", "AHM_1.png"));
		this.add(maxPanel);
		
		this.add(createSpaceLabel(0));
		
		timePanel = new JPanel();
		setPanelComponent(timePanel);
		timePanel.add(createAchievementLabel(
				"The Beginning", "<html>Reach total focus time<br> of 3 hours</html>", "AHM_1.png"));
		timePanel.add(createAchievementLabel(
				"The Beginning", "<html>Reach total focus time<br> of 3 hours</html>", "AHM_1.png"));
		timePanel.add(createAchievementLabel(
				"The Beginning", "<html>Reach total focus time<br> of 3 hours</html>", "AHM_1.png"));
		this.add(timePanel);
		
		this.add(createSpaceLabel(0));
	}

	@Override
	public void setActions() {
		// TODO Auto-generated method stub
		
	}
	
	public void setPanelComponent(JPanel panel) {
		panel.setLayout(new GridLayout(1,3,30,30));
		panel.setBackground(subColor);
		panel.setAlignmentX(JComponent.CENTER_ALIGNMENT);
	}
	
	public JPanel createAchievementLabel(String title, String desc, String imageUrl) {
		JPanel panel = new JPanel();
			panel.setBackground(layerColor);
			panel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
			panel.setLayout(new BorderLayout());
		JLabel imgLabel = new JLabel(new ImageIcon(getClass().getClassLoader().getResource(imageUrl)));
		
		JPanel textPanel = new JPanel();
			textPanel.setBackground(layerColor);
			textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.Y_AXIS));
			
		JLabel achievementLabel = new JLabel(title);
			achievementLabel.setForeground(textColor);
			achievementLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		JLabel descLabel = new JLabel(desc);
			descLabel.setForeground(textColor);
			descLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
			
		textPanel.add(achievementLabel);
		textPanel.add(descLabel);
		
		panel.add(imgLabel, BorderLayout.WEST);
		panel.add(textPanel, BorderLayout.CENTER);
		
		return panel;
	}
}
