package State;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class StudyFocusStrategy extends StateStrategy {
	//GridBagConstraints for the Tamo's image and background labels
		private GridBagConstraints gbc = new GridBagConstraints();
	
	/**
	 * The Study Focus Panel
	 * Left Panel is the Tamo Panel
	 * Right Panel is the Timer Panel
	 */
	
	//Tamo Panel
	private JPanel tamoPanel;
	
	private JPanel tamoImagePanel;
	private JLabel imageLabel, backgroundImageLabel;
	
	private JPanel tamoNameLevelPanel;
	private JLabel tamoName, tamoLevel;
	
	private JPanel moneyPanel;
	private JLabel moneyLabel, moneyImageLabel;
	
	private JPanel tamoStatsPanel;
	private JLabel tamoHappiness, tamoHunger;
	
	//Timer Panel
	private JPanel timerPanel;
	
	private JPanel timerTextPanel;
	private JLabel minuteTime, secondTime, spaceLabel;
	private JLabel currentSessionLabel;
	
	//The timer set panel will be different depending on user's mode
	private JPanel timerSetPanel;
	private JLabel pomoNumberSessionLabel, pomoSessionLabel, pomoBreakLabel;
	private JComboBox pomoNumberSessionBox, pomoSessionBox, pomoBreakBox;
	
	private JPanel timerButtonPanel;
	private JButton startFocusButton, breakFocusButton;
	
	
	@Override
	public void setPanel() {
		this.setLayout(new GridLayout(1,2));
		this.setBackground(new Color(78,78,78));
		createTamoPanel();
		createTimerPanel();
	}
	
	public void createTamoPanel() {
		tamoPanel = new JPanel(); 							  //Base Tamo Panel
		tamoPanel.setLayout(new BorderLayout());			  //BorderLayout
			tamoPanel.setBackground(new Color(78,78,78));
		
		//Top Components
		tamoNameLevelPanel = new JPanel();
			tamoNameLevelPanel.setBackground(new Color(78,78,78));
		tamoName = new JLabel("Lisa | Level: 24");
			tamoName.setForeground(Color.WHITE);
		tamoName.setFont(new Font("Tahoma", Font.PLAIN, 24));
		//tamoLevel = new JLabel("| Level: 24");
		tamoNameLevelPanel.add(tamoName);					   //Add Label to subPanel
		tamoPanel.add(tamoNameLevelPanel, BorderLayout.NORTH); //Add to tamoPanel
		
		//Middle Components
		tamoImagePanel = new JPanel();
			tamoImagePanel.setBackground(new Color(78,78,78));
		imageLabel = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("TAMO_NORMAL_1.gif")));
		backgroundImageLabel = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("BG-1.png")));
		
		backgroundImageLabel.setLayout(new GridBagLayout());
		imageLabel.setSize(imageLabel.getPreferredSize());
		backgroundImageLabel.add(imageLabel, gbc);
		tamoImagePanel.add(backgroundImageLabel);
		tamoPanel.add(tamoImagePanel, BorderLayout.CENTER);
		
		//Bottom Components
		tamoStatsPanel = new JPanel();
			tamoStatsPanel.setBackground(new Color(78,78,78));
		tamoStatsPanel.setLayout(new GridLayout(2,1));
		tamoHappiness = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("HAPPY_10.png")));
		tamoHunger = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("HUNGER_10.png")));
		tamoStatsPanel.add(tamoHappiness);
		tamoStatsPanel.add(tamoHunger);
		tamoPanel.add(tamoStatsPanel, BorderLayout.SOUTH);
		
		this.add(tamoPanel); //Will add in first cell of GridLayout
	}
	
	public void createTimerPanel() {
		timerPanel = new JPanel();
			timerPanel.setBackground(new Color(78,78,78));
		timerPanel.setLayout(new BorderLayout());
		
		//timerTextPanel
		timerTextPanel = new JPanel();
			timerTextPanel.setBackground(new Color(78,78,78));
		
		minuteTime = new JLabel("00");
			minuteTime.setForeground(Color.WHITE);
		minuteTime.setFont(new Font ("Tahoma", Font.BOLD, 96));
		spaceLabel = new JLabel(":");
			spaceLabel.setForeground(Color.WHITE);
		spaceLabel.setFont(new Font ("Tahoma", Font.BOLD, 96));
		secondTime = new JLabel("00");
			secondTime.setForeground(Color.WHITE);
		secondTime.setFont(new Font ("Tahoma", Font.BOLD, 96));
		timerTextPanel.add(minuteTime);
		timerTextPanel.add(spaceLabel);
		timerTextPanel.add(secondTime);
		
		//timerSetPanel
		timerSetPanel = new JPanel();
			timerSetPanel.setBackground(new Color(78,78,78));
		timerSetPanel.setLayout(new GridLayout(3,1));
		timerSetPanel.add(timerTextPanel,BorderLayout.NORTH);
		
		currentSessionLabel = new JLabel("2 / 12");
			currentSessionLabel.setForeground(Color.WHITE);
		currentSessionLabel.setFont(new Font ("Tahoma", Font.BOLD, 20));
		pomoNumberSessionLabel = new JLabel("# Of Sessions");
			pomoNumberSessionLabel.setForeground(Color.WHITE);
		pomoNumberSessionBox = new JComboBox();
		pomoSessionLabel = new JLabel("Session Length");
			pomoSessionLabel.setForeground(Color.WHITE);
		pomoSessionBox = new JComboBox();
		pomoBreakLabel = new JLabel("Break Length");
			pomoBreakLabel.setForeground(Color.WHITE);
		pomoBreakBox = new JComboBox();
		pomoSessionBox.setBackground(Color.WHITE);
		pomoBreakBox.setBackground(Color.WHITE);
		
		//Main Panels
		JPanel topSetPanel = new JPanel();
			topSetPanel.setBackground(new Color(78,78,78));
			topSetPanel.setLayout(new GridLayout(2,1));
			JPanel topSetPanelTop = new JPanel();
				topSetPanelTop.setBackground(new Color(78,78,78));
				JPanel topNumPanel = new JPanel();
					topNumPanel.setBackground(new Color(78,78,78));
				JPanel topSessionPanel = new JPanel();
					topSessionPanel.setBackground(new Color(78,78,78));
				JPanel topBreakPanel = new JPanel();
					topBreakPanel.setBackground(new Color(78,78,78));
			JPanel topSetPanelBot = new JPanel();
				topSetPanelBot.setBackground(new Color(78,78,78));
				//The Current Session Label is on this Panel
			
		JPanel botSetPanel = new JPanel();
			botSetPanel.setBackground(new Color(78,78,78));
		
		JPanel botNumPanel = new JPanel();
			botNumPanel.setBackground(new Color(78,78,78));
		JPanel botSessionPanel = new JPanel();
			botSessionPanel.setBackground(new Color(78,78,78));
		JPanel botBreakPanel = new JPanel();
			botBreakPanel.setBackground(new Color(78,78,78));
		
		
		timerSetPanel.add(topSetPanel);
		topSetPanel.add(topSetPanelBot);
			topSetPanelBot.add(currentSessionLabel);	
		topSetPanel.add(topSetPanelTop);
				topSetPanelTop.add(topNumPanel);
					topNumPanel.add(pomoNumberSessionLabel);
				topSetPanelTop.add(topSessionPanel);
					topSessionPanel.add(pomoSessionLabel);
				topSetPanelTop.add(topBreakPanel);
					topBreakPanel.add(pomoBreakLabel);
		timerSetPanel.add(botSetPanel);
		botSetPanel.add(botNumPanel);
			botNumPanel.add(pomoNumberSessionBox);
		botSetPanel.add(botSessionPanel);
			botSessionPanel.add(pomoSessionBox);
		botSetPanel.add(botBreakPanel);
			botBreakPanel.add(pomoBreakBox);
			
		//Button Panel
		timerButtonPanel = new JPanel();
			timerButtonPanel.setBackground(new Color(78,78,78));
		startFocusButton = new JButton("Start Focus");
		breakFocusButton = new JButton("Break Focus");
		timerButtonPanel.add(startFocusButton);
		timerButtonPanel.add(breakFocusButton);
		
		
		timerPanel.add(timerSetPanel,BorderLayout.CENTER);
		timerPanel.add(timerButtonPanel,BorderLayout.SOUTH);
		this.add(timerPanel);
	}

	@Override
	public void setActions() {
		
		
	}
	
}
