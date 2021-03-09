/**
 * @description GUI Class of TamoStudy
 * @author Anthony Narlock
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class testGUI extends JFrame {
	
	//Component Declaration
	private JPanel topPanel, centerPanel, botPanel;
	private JButton startButton, breakButton;
	private JLabel timeRemaining;
	private JTextField enterSecondField;
	
	private Countdown countdown;

	public testGUI() {
		
		setUpFrame();
		
		initVariables();
		
		createAspects();
		
		setUpGUI();
		
		this.setSize(350, 350);
		
	}
	
	public void setUpFrame() {
		//Sets up the GUI's frame
		this.setTitle("TamoStudy (version: 0.1)");
		this.setSize(350,349);
		this.setLocationRelativeTo(null);
		this.setResizable(true);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	public void initVariables() {
		topPanel = new JPanel();
		centerPanel = new JPanel();
		botPanel = new JPanel();
		
		timeRemaining = new JLabel("Time remaining: ");
		
		startButton = new JButton("Start");
		breakButton = new JButton("Break");
		
		enterSecondField = new JTextField(10);
		
	}

	public void createAspects() {
		startButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if(enterSecondField == null) {
					System.err.println("No selection was entered");
				}
				else {
					int secondsRemaining = Integer.parseInt(enterSecondField.getText());
					countdown = new Countdown(secondsRemaining);
					countdown.timer.schedule(countdown.task, 1000, 1000);
					SwingUtilities.invokeLater(updateLoop(countdown));
					
				
					
				}
			}
			
		});
		
		breakButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
	}
	
	public void setUpGUI() {
		this.getContentPane().setLayout(new BorderLayout());
		
		this.getContentPane().add(centerPanel, BorderLayout.CENTER);
		this.getContentPane().add(botPanel, BorderLayout.SOUTH);
		
		addComponentsToCenterPanel();
		addComponentsToBottomPanel();
	}

	public void addComponentsToCenterPanel() {
		centerPanel.add(timeRemaining);
		centerPanel.add(enterSecondField);
	}
	
	public void addComponentsToBottomPanel() {
		botPanel.add(startButton);
		botPanel.add(breakButton);
	}
	
	public Runnable updateLoop(Countdown countdown) {
		int secondsRemaining = Integer.parseInt(enterSecondField.getText());
		
		while(secondsRemaining > 0) {
			System.out.println(secondsRemaining);
			secondsRemaining = countdown.updateSeconds();
			
			timeRemaining.setText("Time remaining: " + secondsRemaining);
		}
		return null;
		
	}
}
