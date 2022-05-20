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
import resources.BubbleBorder;

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
	
	//Tamo Panel
	private JPanel tamoPanel;
	private JLabel tamoNameLevelLabel;
	private JLabel imageLabel, backgroundImageLabel;
	
	private JPanel tamoHappiness, tamoHunger;
	
	//Timer Panel
	private JPanel timerPanel;
	
	private JPanel timerTextPanel, timerStreamPanel;
	private JLabel minuteTime, secondTime, spaceLabel;
	private JLabel currentSessionLabel;
	
	//The timer set panel will be different depending on user's mode
	private JPanel timerSetBoxPanel;
	
	//Interval Timer Countdown
	//The difference is only the values in the 5-min and custom
	//the second box will NOT appear in 5-min interval mode
	private JComboBox minuteBox, secondBox;
	
	//Pomodoro Mode
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
		tamoNameLevelLabel = new JLabel("Lisa - " + profile.getLanguage().focusText[0] + ": " + Integer.toString(profile.getTamoLevel()));
			tamoNameLevelLabel.setForeground(theme.textColor);
		tamoNameLevelLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		tamoNameLevelLabel.setAlignmentX(JComponent.CENTER_ALIGNMENT);
		tamoPanel.add(tamoNameLevelLabel); //Add to tamoPanel
		
		//Tamo-Images Components
		System.out.println(profile.getTamo().getImageUrl(false));
		imageLabel = new JLabel(new ImageIcon(getClass().getClassLoader().getResource(profile.getTamo().getImageUrl(false))));
		backgroundImageLabel = new JLabel(new ImageIcon(getClass().getClassLoader().getResource(profile.getBgUrl())));
		
		backgroundImageLabel.setLayout(new GridBagLayout());
		imageLabel.setSize(imageLabel.getPreferredSize());
		backgroundImageLabel.add(imageLabel, gbc);
		backgroundImageLabel.setAlignmentX(JComponent.CENTER_ALIGNMENT);
		tamoPanel.add(backgroundImageLabel); //Add to tamoPanel
		
		//Happy-Hunger Components
		tamoHappiness = new JPanel();
			tamoHappiness.setBackground(theme.subColor);
			if(profile.getTamo().getHappiness() == 0) {
				//TODO get some indicator of 0 happy
			} else {
				for(int i = 0; i < profile.getTamo().getHappiness(); i++) {
					tamoHappiness.add(new JLabel(new ImageIcon(getClass().getClassLoader().getResource("HAPPY.png"))));
				}
			}
			tamoHappiness.setAlignmentX(JComponent.CENTER_ALIGNMENT);
			
		tamoHunger = new JPanel();
			tamoHunger.setBackground(theme.subColor);
			if(profile.getTamo().getHunger() == 0) {
				//TODO get some indicator of 0 happy
			} else {
				for(int i = 0; i < profile.getTamo().getHunger(); i++) {
					tamoHunger.add(new JLabel(new ImageIcon(getClass().getClassLoader().getResource("HUNGER.png"))));
				}
			}
			tamoHunger.setAlignmentX(JComponent.CENTER_ALIGNMENT);
			
		tamoPanel.add(tamoHappiness); //Add to tamoPanel
		tamoPanel.add(tamoHunger); //Add to tamoPanel
		tamoPanel.add(createSpaceLabel(1));
		
		this.add(tamoPanel); //Will add in first cell of GridLayout
	}
	
	public void createTimerPanel() {
		timerPanel = new JPanel();
		timerPanel.setLayout(new BoxLayout(timerPanel, BoxLayout.Y_AXIS));
			timerPanel.setBackground(theme.subColor);
		
		//Space Component
		timerPanel.add(createSpaceLabel(0)); //timerPanel
		
		timerStreamPanel = new JPanel();
			timerStreamPanel.setBackground(theme.layerColor);
			timerStreamPanel.setLayout(new BoxLayout(timerStreamPanel, BoxLayout.Y_AXIS));
			timerStreamPanel.setBorder(new BubbleBorder(Color.BLACK, 3, 20, 10, true));
		
		//timerTextPanel
		timerTextPanel = new JPanel();
			timerTextPanel.setBackground(theme.layerColor);
			timerTextPanel.setLayout(new BoxLayout(timerTextPanel, BoxLayout.X_AXIS));
		
		minuteTime = new JLabel("00");
			minuteTime.setForeground(theme.textColor);
		minuteTime.setFont(new Font ("Arial", Font.BOLD, 96));
		spaceLabel = new JLabel(":");
			spaceLabel.setForeground(theme.textColor);
		spaceLabel.setFont(new Font ("Arial", Font.BOLD, 96));
		secondTime = new JLabel("00");
			secondTime.setForeground(theme.textColor);
		secondTime.setFont(new Font ("Arial", Font.BOLD, 96));
		timerTextPanel.add(minuteTime);
		timerTextPanel.add(spaceLabel);
		timerTextPanel.add(secondTime);
		
		timerStreamPanel.add(timerTextPanel);
		//timerPanel.add(timerTextPanel); //timerPanel
		
		//Session Label - POMODORO ONLY
		if(profile.getSettings().getFocusMode() == 2) {
			currentSessionLabel = new JLabel(profile.getLanguage().focusText[11]);
			currentSessionLabel.setForeground(theme.textColor);
			currentSessionLabel.setFont(new Font ("Tahoma", Font.BOLD, 25));
			currentSessionLabel.setAlignmentX(JComponent.CENTER_ALIGNMENT);
			timerStreamPanel.add(currentSessionLabel);
		}
		
		timerPanel.add(timerStreamPanel);
		
		//Space Component
		timerPanel.add(createSpaceLabel(0));
		
		//timerSetBox Panel Initialization
		timerSetBoxPanel = new JPanel();
			timerSetBoxPanel.setBackground(theme.subColor);
			
		//timerSetPanel - CUSTOM INTERVAL COUNTDOWN
		if(profile.getSettings().getFocusMode() == 0) {
			minuteBox = new JComboBox();
				minuteBox.setFont(theme.fontBoldRegSmall);
			secondBox = new JComboBox();
				secondBox.setFont(theme.fontBoldRegSmall);
			
			timerSetBoxPanel.add(minuteBox);
			timerSetBoxPanel.add(secondBox);
			
			timerPanel.add(timerSetBoxPanel);
		}
		
		//timerSetPanel - 5 MIN INTERVAL COUNTDOWN
		if(profile.getSettings().getFocusMode() == 1) {
			minuteBox = new JComboBox();
				minuteBox.setFont(theme.fontBoldRegSmall);
			timerSetBoxPanel.add(minuteBox);
			
			timerPanel.add(timerSetBoxPanel);
		}
		
		//timerSetPanel - POMODORO
		if(profile.getSettings().getFocusMode() == 2) {
			pomoSessionLabel = new JLabel(profile.getLanguage().focusText[1] + "     " 
					+ profile.getLanguage().focusText[2] + "     " 
					+ profile.getLanguage().focusText[3]);
			pomoSessionLabel.setForeground(theme.textColor);
			pomoSessionLabel.setAlignmentX(JComponent.CENTER_ALIGNMENT);
		
			timerPanel.add(pomoSessionLabel);

			//Set Boxes
			pomoNumberSessionBox = new JComboBox();
				pomoNumberSessionBox.setBackground(Color.WHITE);
			pomoSessionBox = new JComboBox();
				pomoSessionBox.setBackground(Color.WHITE);
			pomoBreakBox = new JComboBox();
				pomoBreakBox.setBackground(Color.WHITE);
				
			timerSetBoxPanel.add(pomoNumberSessionBox);
			timerSetBoxPanel.add(pomoSessionBox);
			timerSetBoxPanel.add(pomoBreakBox);
			
			timerPanel.add(timerSetBoxPanel);
		}
			
		//Button Panel
		timerButtonPanel = new JPanel();
			timerButtonPanel.setBackground(theme.subColor);
			
		startFocusButton = new JButton(profile.getLanguage().focusText[4]);
			startFocusButton.setFont(theme.fontBoldRegSmall);
		
		breakFocusButton = new JButton(profile.getLanguage().focusText[5]);
			breakFocusButton.setFont(theme.fontBoldRegSmall);
		timerButtonPanel.add(startFocusButton);
		timerButtonPanel.add(breakFocusButton);
		
		timerPanel.add(timerButtonPanel);
		
		this.add(timerPanel);
	}

	@Override
	public void setActions() {
		//CUSTOTM COUNTDOWN ACTIONS
		if(profile.getSettings().getFocusMode() == 0) {
			for(int i = 0; i <= 60; i++) {
				if(i < 10) {
					secondBox.addItem("0" + i);
				}
				else {
					secondBox.addItem(i);
				}
				
			}
			
			for(int i = 0; i <= 90; i++) {
				if(i < 10) {
					minuteBox.addItem("0" + i);
				} else {
					minuteBox.addItem(i);
				}
			}
			
			minuteBox.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					minuteTime.setText(""+minuteBox.getSelectedItem());
				}
			});
			
			secondBox.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					secondTime.setText(""+secondBox.getSelectedItem());
				}
			});
		}
		
		//5MIN COUNTDOWN ACTIONS
		if(profile.getSettings().getFocusMode() == 1) {
			for(int i = 5; i <= 90; i = i + 5) {
				if(i == 5)
					minuteBox.addItem("0" + i + ":00");
				else
					minuteBox.addItem(i + ":00");
			}
			
			minuteBox.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					minuteTime.setText(minuteBox.getSelectedItem().toString().substring(0,2));
				}
			});
		}
		
		//POMODORO ACTIONS
		if(profile.getSettings().getFocusMode() == 2) {
			pomoSessionBox.addItem("01:00");
			pomoBreakBox.addItem("01:00");
			
			for(int i = 5; i <= 90; i = i + 5) {
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
			
			pomoSessionBox.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					minuteTime.setText(""+pomoSessionBox.getSelectedItem());
					minuteTime.setText(minuteTime.getText().substring(0,2));
				}
			});
		}
		
	}
	
	//Getters for MainGUI
	public JButton getStartButton() { return startFocusButton; }
	public JButton getBreakButton() { return breakFocusButton; }
	public JLabel getMinuteTimeLabel() { return minuteTime; }
	public JLabel getSecondTimeLabel() { return secondTime; }
	public JComboBox getMinuteBox() { return minuteBox; }
	public JComboBox getSecondBox() { return secondBox; }
	public JComboBox getPomoSessionBox() { return pomoSessionBox; }
	public JComboBox getPomoBreakBox() { return pomoBreakBox; }
	public JComboBox getPomoNumberSessionBox() { return pomoNumberSessionBox; }
	public JLabel getCurrentSessionLabel() { return currentSessionLabel; }
	public JLabel getTamoImageLabel() { return imageLabel; }
	
}
