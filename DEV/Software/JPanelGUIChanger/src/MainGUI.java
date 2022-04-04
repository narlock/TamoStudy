
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import State.StateStrategy;
import State.StudyFocusStrategy;
import State.TitleStrategy;

/**
 * MainGUI
 * @author Anthony Narlock
 * @brief The Context and Main Frame of Program
 */

public class MainGUI extends JFrame {
	/**
	 * MainGUI the "Context"
	 */
	
	private boolean openedSideBar; //State of the sidebar being opened
	private JPanel sidePanel; //The sidebar panel
	private JPanel openSidePanel; //The openSideBar panel
	private StateStrategy strategy; //The center strategy state
									//This is what is rendered on
									//center of the screen.

	/**
	 * @brief Main Constructor
	 */
	public MainGUI() {
		//Sets the attributes accordingly
		strategy = new TitleStrategy();
		openedSideBar = true;
		
		//Initializes the GUI components
		initFrame();
		initSidePanels();
		initComponentsToFrame();
		
		//Hopefully fixes Swing issues on painting
		this.setSize(800,600);
		this.repaint();
	}
	
	/**
	 * recall
	 * @param newStrategy
	 * @brief Changes the StateStrategy
	 * Will 'repaint' the main panel.
	 */
	public void recall(StateStrategy newStrategy) {
		System.out.println("TEST");
		this.remove(strategy);
		strategy = newStrategy;
		this.add(strategy, BorderLayout.CENTER);
		this.repaint();
	}
	
	/**
	 * initFrame
	 * @brief Initializes the JFrame
	 */
	public void initFrame() {
		this.setTitle("TamoStudy Beta v4.0");
		this.setVisible(true);
		this.setSize(800,599);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setBackground(Color.DARK_GRAY);
	}
	
	/**
	 * initSidePanels
	 */
	public void initSidePanels() {
		
		/**
		 * Setting up the Side Panel
		 */
		
		JLabel thematicBreak = new JLabel("     ━━━━━━━━━━━━━━━━━━━━━     ");
		JLabel thematicBreak2 = new JLabel("     ━━━━━━━━━━━━━━━━━━━━━     ");
		setUpLabelComponent(thematicBreak, 1);
		setUpLabelComponent(thematicBreak2, 1);
		
		sidePanel = new JPanel();
		sidePanel.setBackground(new Color(64,64,64));
		sidePanel.setLayout(new GridLayout(15,1));
		
		JButton titleCardButton = new JButton("Title Card");
		setUpButtonComponent(titleCardButton);
		titleCardButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				updateSideBar();
				StateStrategy newStrategy = new TitleStrategy();
				recall(newStrategy);
			}
		});
		
		JButton focusButton = new JButton("Focus");
		setUpButtonComponent(focusButton);
		focusButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				updateSideBar();
				StateStrategy newStrategy = new StudyFocusStrategy();
				recall(newStrategy);
			}
		});
		
		JButton shopButton = new JButton("Shop");
		setUpButtonComponent(shopButton);
		//TODO implement shop Button to change strategy
		
		JButton themesButton = new JButton("Themes");
		setUpButtonComponent(themesButton);
		//TODO implement theme Button to change strategy
		
		JButton inventoryButton = new JButton("Inventory");
		setUpButtonComponent(inventoryButton);
		//TODO implement inventory Button to change strategy
		
		JButton statsButton = new JButton("Statistics");
		setUpButtonComponent(statsButton);
		//TODO implement stats Button to change strategy
		
		JButton achievementsButton = new JButton("Achievements");
		setUpButtonComponent(achievementsButton);
		//TODO implement ahm button to change strategy
		
		JButton settingsButton = new JButton("Settings");
		setUpButtonComponent(settingsButton);
		//TODO implement settings Button to change strategy
		
		JButton changeLogButton = new JButton("Change Log");
		setUpButtonComponent(changeLogButton);
		//TODO implement change log button to change strategy
		
		JButton aboutButton = new JButton("About");
		setUpButtonComponent(aboutButton);
		//TODO implement about button to change strategy
		
		
		sidePanel.add(titleCardButton);
		sidePanel.add(focusButton);
		sidePanel.add(thematicBreak);
		sidePanel.add(shopButton);
		sidePanel.add(themesButton);
		sidePanel.add(inventoryButton);
		sidePanel.add(statsButton);
		sidePanel.add(achievementsButton);
		sidePanel.add(thematicBreak2);
		sidePanel.add(settingsButton);
		sidePanel.add(changeLogButton);
		sidePanel.add(aboutButton);
		
		
		
		/**
		 * Setting up openSidePanel
		 */
		openSidePanel = new JPanel();
		openSidePanel.setBackground(new Color(64,64,64));
		
		//openSidePanel component
		
		JButton openSideLabel = new JButton("MENU");
		setUpButtonComponent(openSideLabel, 1);
		openSideLabel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				updateSideBar();
			}
		});
		
		JLabel welcomeUserLabel = new JLabel("Welcome, user!");
		setUpLabelComponent(welcomeUserLabel);
		
		openSidePanel.add(openSideLabel);
		openSidePanel.add(welcomeUserLabel);
	}
	
	public void initComponentsToFrame() {
		this.add(openSidePanel, BorderLayout.NORTH);
		this.add(sidePanel, BorderLayout.WEST);
		this.add(strategy, BorderLayout.CENTER);
	}
	
	public void updateSideBar() {
		if (this.openedSideBar) {
			//Close the side bar
			this.openedSideBar = false;
			this.sidePanel.setVisible(false);
		} else {
			//Open the side bar
			this.openedSideBar = true;
			this.sidePanel.setVisible(true);
		}
	}
	
	public void setUpLabelComponent(JLabel label) {
		label.setForeground(new Color(153,153,153));
		label.setFont(new Font("Arial", Font.BOLD, 16));
	}
	
	public void setUpLabelComponent(JLabel label, int num) {
		label.setForeground(new Color(153,153,153));
	}
	
	public void setUpButtonComponent(JButton button) {
		button.setBorderPainted(false);
		button.setBackground(new Color(64,64,64));
		button.setForeground(new Color(153,153,153));
		button.setFocusPainted(false);
		button.setFont(new Font("Arial", Font.BOLD, 16));
	}
	
	public void setUpButtonComponent(JButton button, int num) {
		button.setBackground(new Color(64,64,64));
		button.setForeground(new Color(153,153,153));
		button.setFocusPainted(false);
		button.setFont(new Font("Arial", Font.BOLD, 16));
	}
}
