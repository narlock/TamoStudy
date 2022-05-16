
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import profile.Profile;
import state.AboutStrategy;
import state.AchievementsStrategy;
import state.InventoryStrategy;
import state.SettingsStrategy;
import state.ShopStrategy;
import state.StateStrategy;
import state.StatisticsStrategy;
import state.StudyFocusStrategy;
import state.ThemeStrategy;
import state.TitleStrategy;

/**
 * MainGUI
 * @author Anthony Narlock
 * @brief The Context and Main Frame of Program
 */

public class MainGUI extends JFrame {
	/**
	 * MainGUI the "Context"
	 */
	
	private boolean openedSideBar; 								//State of the sidebar being opened
	private JPanel sidePanel; 									//The sidebar panel
	private JPanel openSidePanel; 								//The openSideBar panel
	private StateStrategy strategy; 							//The center strategy state
																//This is what is rendered on
																//center of the screen.
	private static final String 								//Line Divider for some JLabels
		DIVIDER_STRING = "     ━━━━━━━━━━━━━━━━━━━━━     ";
	
	/**
	 * Profile Components
	 */
	//TODO change these to be initialized when profile is loaded
	//To keep track of different options
	private Profile profile;
	
	private Color mainColor = new Color(64,64,64); 		//DEFAULT
	private Color textColor = new Color(153,153,153);	//DEFAULT

	/**
	 * @brief Main Constructor
	 */
	public MainGUI() {
		//Sets the attributes accordingly
		openedSideBar = true;
		profile = new Profile(); //TODO Update this so it loads/New profile
		strategy = new TitleStrategy(profile);
		
		//Initializes the GUI components
		initFrame();
		initSidePanels();
		initComponentsToFrame();
		
		//Hopefully fixes Swing issues on painting
		this.setIconImage(new ImageIcon(getClass().getClassLoader().getResource("ICON.png")).getImage());
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
		
		JLabel thematicBreak = new JLabel(DIVIDER_STRING);
		JLabel thematicBreak2 = new JLabel(DIVIDER_STRING);
		setUpLabelComponent(thematicBreak, 1);
		setUpLabelComponent(thematicBreak2, 1);
		
		sidePanel = new JPanel();
		sidePanel.setBackground(mainColor);
		sidePanel.setLayout(new GridLayout(15,1));
		
		JButton titleCardButton = new JButton("Title Card");
		setUpButtonComponent(titleCardButton);
		titleCardButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("[TAMOSTUDY] Changing Strategy to Title Card");
				updateSideBar();
				StateStrategy newStrategy = new TitleStrategy(profile);
				recall(newStrategy);
			}
		});
		
		JButton focusButton = new JButton("Focus");
		setUpButtonComponent(focusButton);
		focusButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("[TAMOSTUDY] Changing Strategy to StudyFocus");
				updateSideBar();
				StateStrategy newStrategy = new StudyFocusStrategy(profile);
				recall(newStrategy);
			}
		});
		
		JButton shopButton = new JButton("Shop");
		setUpButtonComponent(shopButton);
		//TODO implement shop Button to change strategy
		shopButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("[TAMOSTUDY] Changing Strategy to Shop");
				updateSideBar();
				StateStrategy newStrategy = new ShopStrategy(profile);
				recall(newStrategy);
			}
		});
		
		JButton themesButton = new JButton("Themes");
		setUpButtonComponent(themesButton);
		//TODO implement theme Button to change strategy
		themesButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("[TAMOSTUDY] Changing Strategy to Themes");
				updateSideBar();
				StateStrategy newStrategy = new ThemeStrategy(profile);
				recall(newStrategy);
			}
		});
		
		
		JButton inventoryButton = new JButton("Inventory");
		setUpButtonComponent(inventoryButton);
		//TODO implement inventory Button to change strategy
		inventoryButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("[TAMOSTUDY] Changing Strategy to Inventory");
				updateSideBar();
				StateStrategy newStrategy = new InventoryStrategy(profile);
				recall(newStrategy);
			}
		});
		
		JButton statsButton = new JButton("Statistics");
		setUpButtonComponent(statsButton);
		//TODO implement stats Button to change strategy
		statsButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("[TAMOSTUDY] Changing Strategy to Statistics");
				updateSideBar();
				StateStrategy newStrategy = new StatisticsStrategy(profile);
				recall(newStrategy);
			}
		});
		
		JButton achievementsButton = new JButton("Achievements");
		setUpButtonComponent(achievementsButton);
		//TODO implement ahm button to change strategy
		achievementsButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("[TAMOSTUDY] Changing Strategy to Achievements");
				updateSideBar();
				StateStrategy newStrategy = new AchievementsStrategy(profile);
				recall(newStrategy);
			}
		});
		
		JButton settingsButton = new JButton("Settings");
		setUpButtonComponent(settingsButton);
		//TODO implement settings Button to change strategy
		settingsButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("[TAMOSTUDY] Changing Strategy to Settings");
				updateSideBar();
				StateStrategy newStrategy = new SettingsStrategy(profile);
				recall(newStrategy);
			}
		});
		
		JButton aboutButton = new JButton("About");
		setUpButtonComponent(aboutButton);
		
		//TODO implement about button to change strategy
		aboutButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("[TAMOSTUDY] Changing Strategy to About");
				updateSideBar();
				StateStrategy newStrategy = new AboutStrategy(profile);
				recall(newStrategy);
			}
		});
		
		
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
		sidePanel.add(aboutButton);
		
		
		
		/**
		 * Setting up openSidePanel
		 */
		openSidePanel = new JPanel();
		openSidePanel.setBackground(mainColor);
		
		//openSidePanel component
		
		JButton openSideLabel = new JButton("MENU");
		setUpButtonComponent(openSideLabel, 1);
		openSideLabel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("[TAMOSTUDY] Menu was updated!");
				updateSideBar();
			}
		});
		
		JLabel welcomeUserLabel = new JLabel(profile.getLanguage().text[1]);
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
		label.setForeground(textColor);
		label.setFont(new Font("Arial", Font.BOLD, 16));
	}
	
	public void setUpLabelComponent(JLabel label, int num) {
		label.setForeground(textColor);
	}
	
	public void setUpButtonComponent(JButton button) {
		button.setBorderPainted(false);
		button.setBackground(mainColor);
		button.setForeground(textColor);
		button.setFocusPainted(false);
		button.setFont(new Font("Arial", Font.BOLD, 16));
	}
	
	public void setUpButtonComponent(JButton button, int num) {
		button.setBackground(mainColor);
		button.setForeground(textColor);
		button.setFocusPainted(false);
		button.setFont(new Font("Arial", Font.BOLD, 16));
	}
}
