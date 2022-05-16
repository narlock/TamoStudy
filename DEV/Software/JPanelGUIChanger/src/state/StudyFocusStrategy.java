package state;

import java.awt.*;

/**
 * @author Anthony Narlock
 * StudyFocusStrategy
 * 
 * This is a concrete StateStrategy which is a JPanel
 * that will display the user interface for Study/Focus
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import profile.Profile;

public class StudyFocusStrategy extends StateStrategy {
	public StudyFocusStrategy(Profile profile) {
		super(profile);
		// TODO Auto-generated constructor stub
	}

	//GridBagConstraints for the Tamo's image and background labels
	private GridBagConstraints gbc = new GridBagConstraints();
	
	/**
	 * The Study Focus Panel
	 * Left Panel is the Tamo Panel
	 * Right Panel is the Timer Panel
	 */
	
	//Separators
	private JLabel textSpace, textSpace2;	
	
	//Tamo Panel
	private JPanel tamoPanel;
	private JLabel tamoName, tamoLevel;
	private JLabel imageLabel, backgroundImageLabel;
	private JLabel tamoHappiness, tamoHunger;
	
	//Timer Panel
	private JPanel timerPanel;
	
	private JPanel timerTextPanel;
	private JLabel minuteTime, secondTime, spaceLabel;
	private JLabel currentSessionLabel;
	
	//The timer set panel will be different depending on user's mode
	private JPanel timerSetBoxPanel;
	private JLabel pomoNumberSessionLabel, pomoSessionLabel, pomoBreakLabel;
	private JComboBox pomoNumberSessionBox, pomoSessionBox, pomoBreakBox;
	
	private JPanel timerButtonPanel;
	private JButton startFocusButton, breakFocusButton;
	
	@Override
	public void setPanel() {
		this.setLayout(new GridLayout(1,2));
		this.setBackground(theme.subColor);
		createTamoPanel();
		createTimerPanel();
	}
	
	public void createTamoPanel() {
		tamoPanel = new JPanel(); 							  				//Base Tamo Panel
		tamoPanel.setLayout(new BoxLayout(tamoPanel, BoxLayout.Y_AXIS));	//BorderLayout
			tamoPanel.setBackground(theme.subColor);
		
		//Space Component - calls parent function
		tamoPanel.add(createSpaceLabel(0));
			
		//Name-Level Components
		tamoName = new JLabel("Lisa - " + profile.getLanguage().focusText[0] + ": 24");
			tamoName.setForeground(Color.WHITE);
		tamoName.setFont(new Font("Tahoma", Font.PLAIN, 24));
		tamoName.setAlignmentX(JComponent.CENTER_ALIGNMENT);
		tamoPanel.add(tamoName); //Add to tamoPanel
		
		//Tamo-Images Components
		imageLabel = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("TAMO_NORMAL_1.gif")));
		backgroundImageLabel = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("BG_1.png")));
		
		backgroundImageLabel.setLayout(new GridBagLayout());
		imageLabel.setSize(imageLabel.getPreferredSize());
		backgroundImageLabel.add(imageLabel, gbc);
		backgroundImageLabel.setAlignmentX(JComponent.CENTER_ALIGNMENT);
		tamoPanel.add(backgroundImageLabel); //Add to tamoPanel
		
		//Happy-Hunger Components
		tamoHappiness = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("HAPPY_10.png")));
			tamoHappiness.setAlignmentX(JComponent.CENTER_ALIGNMENT);
		tamoHunger = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("HUNGER_10.png")));
			tamoHunger.setAlignmentX(JComponent.CENTER_ALIGNMENT);
		tamoPanel.add(tamoHappiness); //Add to tamoPanel
		tamoPanel.add(tamoHunger); //Add to tamoPanel
		
		this.add(tamoPanel); //Will add in first cell of GridLayout
	}
	
	public void createTimerPanel() {
		timerPanel = new JPanel();
		timerPanel.setLayout(new BoxLayout(timerPanel, BoxLayout.Y_AXIS));
			timerPanel.setBackground(new Color(78,78,78));
		
		//Space Component
		timerPanel.add(createSpaceLabel(1)); //timerPanel
		
		//timerTextPanel
		timerTextPanel = new JPanel();
			timerTextPanel.setBackground(new Color(78,78,78));
			timerTextPanel.setLayout(new BoxLayout(timerTextPanel, BoxLayout.X_AXIS));
		
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
		
		timerPanel.add(timerTextPanel); //timerPanel
		
		//Session Label
		currentSessionLabel = new JLabel("2 / 12");
			currentSessionLabel.setForeground(Color.WHITE);
			currentSessionLabel.setFont(new Font ("Tahoma", Font.BOLD, 25));
			currentSessionLabel.setAlignmentX(JComponent.CENTER_ALIGNMENT);
		timerPanel.add(currentSessionLabel);
		
		//Space Component
		timerPanel.add(createSpaceLabel(0));
		
		//timerSetText Panel	
		pomoSessionLabel = new JLabel(profile.getLanguage().focusText[1] + "     " 
						+ profile.getLanguage().focusText[2] + "     " 
						+ profile.getLanguage().focusText[3]);
			pomoSessionLabel.setForeground(Color.WHITE);
			pomoSessionLabel.setAlignmentX(JComponent.CENTER_ALIGNMENT);
		
		timerPanel.add(pomoSessionLabel);
		
		//timerSetBox Panel
		timerSetBoxPanel = new JPanel();
			timerSetBoxPanel.setBackground(new Color(78,78,78));
		//timerSetBoxPanel.setLayout(new BoxLayout(timerSetBoxPanel, BoxLayout.X_AXIS));
		
		pomoNumberSessionBox = new JComboBox();
			pomoNumberSessionBox.setBackground(Color.WHITE);
		pomoSessionBox = new JComboBox();
			pomoSessionBox.setBackground(Color.WHITE);
		pomoBreakBox = new JComboBox();
			pomoBreakBox.setBackground(Color.WHITE);
			
		textSpace = new JLabel("           ");
		textSpace2 = new JLabel("           ");
			
		timerSetBoxPanel.add(pomoNumberSessionBox);
		timerSetBoxPanel.add(textSpace);
		timerSetBoxPanel.add(pomoSessionBox);
		timerSetBoxPanel.add(textSpace2);
		timerSetBoxPanel.add(pomoBreakBox);
		
		timerPanel.add(timerSetBoxPanel);
			
		//Button Panel
		timerButtonPanel = new JPanel();
			timerButtonPanel.setBackground(new Color(78,78,78));
			
		startFocusButton = new JButton(profile.getLanguage().focusText[4]);
		breakFocusButton = new JButton(profile.getLanguage().focusText[5]);
		timerButtonPanel.add(startFocusButton);
		timerButtonPanel.add(breakFocusButton);
		
		timerPanel.add(timerButtonPanel);
		
		this.add(timerPanel);
	}

	@Override
	public void setActions() {
		//Init Pomodoro Box Items
		for(int i = 5; i <= 60; i = i + 5) {
			if(i == 5) {
				pomoSessionBox.addItem("0" + i + ":00");
				pomoBreakBox.addItem("0" + i + ":00");
			}
			else {
				pomoSessionBox.addItem(i + ":00");
				pomoBreakBox.addItem(i + ":00");
			}
		}
		
		for(int i = 1; i <= 16; i++) {
			pomoNumberSessionBox.addItem(i);
		}
		
	}
	
}
