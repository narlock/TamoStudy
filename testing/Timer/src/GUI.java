/**
 * @description GUI Class of TamoStudy
 * @author Anthony Narlock
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUI extends JFrame {
	
	//Component Declaration
	private JPanel topPanel, centerPanel, botPanel;
	private JButton startButton, breakButton;

	public GUI() {
		
		setUpFrame();
		
		initVariables();
		
		createAspects();
		
		setUpGUI();
		
		this.setSize(350, 350);
		
	}
	
	public void setUpFrame() {
		//Sets up the GUI's frame
		this.setTitle("TamoStudy (version: 0.1)");
		this.setSize(350,350);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void initVariables() {
		topPanel = new JPanel();
		centerPanel = new JPanel();
		botPanel = new JPanel();
	}

	public void createAspects() {
		startButton = new JButton("Start");
		startButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
			}
			
		});
		
		breakButton = new JButton("Break");
		breakButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
	}
	
	public void setUpGUI() {
		this.getContentPane().setLayout(new BorderLayout());
		
		this.getContentPane().add(botPanel, BorderLayout.SOUTH);
		
		addComponentsToBottomPanel();
	}

	public void addComponentsToBottomPanel() {
		botPanel.add(startButton);
		botPanel.add(breakButton);
	}
}
