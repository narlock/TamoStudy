
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;

import javax.swing.*;

import profile.Profile;
import resources.CommunicateThemeAction;
import resources.Theme;
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
 * @author Anthony Narlock (narlock)
 * @brief The Context and Main Frame of Program
 */

public class MainGUI extends JFrame {
	/**
	 * MainGUI the "Context"
	 */
	
	//Primary Components of the MainGUI
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
	public Theme theme;
	
	//Used to track the components on sidebar so we can update them accordingly
	private Stack<JPanel> panels;
	private Stack<JButton> buttons;
	private Stack<JLabel> labels;
	private JButton openSideLabel; //Menu Button
	private Stack<JLabel> breaks; //Thematic breaks
	
	/**
	 * Specific Function Components
	 * 
	 * These are member variables that correspond to
	 * the objects that are in the specific strategies
	 * in which we need to interact with the MainGUI.
	 */
	
	//StudyFocusStrategy
	private JButton startFocusButton;			//Start focus button
	private JButton breakFocusButton;			//Break focus button
	
	//ThemeStrategy
	private Stack<JButton> selectButtons;
	private CommunicateThemeAction themeAction;

	/**
	 * @brief Main Constructor
	 * Sets the default values, will be used on new profile
	 */
	public MainGUI() {
		//Sets the attributes accordingly
		openedSideBar = true;
		profile = new Profile(); //TODO Update this so it loads/New profile
		theme = profile.getThemeIndicator(); //For colors
		strategy = new TitleStrategy(profile);
		panels = new Stack<>();
		buttons = new Stack<>();
		labels = new Stack<>();
		breaks = new Stack<>();
		
		//Initializes the GUI components
		initFrame();
		initSidePanels();
		initComponentsToFrame();
		
		//Hopefully fixes Swing issues on painting
		this.setIconImage(new ImageIcon(getClass().getClassLoader().getResource("ICON.png")).getImage());
		this.setSize(800,600);	//Resize properly so display is correct
		this.repaint();
	}
	
	//TODO Make Load Constructor
	//Sets values based off of profile
	
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
	 * @brief Initializes the main JFrame
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
	 * @brief Initializes the side panel
	 */
	public void initSidePanels() {
		
		/**
		 * Setting up the Side Panel
		 */
		
		//Initializes the thematic breaks
		JLabel thematicBreak = new JLabel(DIVIDER_STRING);
		JLabel thematicBreak2 = new JLabel(DIVIDER_STRING);
		setUpLabelComponent(thematicBreak, 1);
		setUpLabelComponent(thematicBreak2, 1);
		breaks.push(thematicBreak);
		breaks.push(thematicBreak2);
		
		//Initializes Side Panel
		sidePanel = new JPanel();
		sidePanel.setBackground(theme.mainColor);
		sidePanel.setLayout(new GridLayout(15,1));
		panels.push(sidePanel);
		
		//Initializes each of the side buttons
		//Includes dynamic functionality as needed to communicate
		//with it's respective strategy
		
		JButton titleCardButton = new JButton(profile.getLanguage().text[2]);
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
		buttons.push(titleCardButton);
		
		JButton focusButton = new JButton(profile.getLanguage().text[3]);
		setUpButtonComponent(focusButton);
		focusButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("[TAMOSTUDY] Changing Strategy to StudyFocus");
				updateSideBar();
				StateStrategy newStrategy = new StudyFocusStrategy(profile);
				
				//Functionality to communicate between
				//TODO Set up the actual timer inside this class...
				startFocusButton = ((StudyFocusStrategy) newStrategy).getStartButton();
				setStudyComponentFunctions();
				
				recall(newStrategy);
			}
		});
		buttons.push(focusButton);
		
		JButton shopButton = new JButton(profile.getLanguage().text[4]);
		setUpButtonComponent(shopButton);
		shopButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("[TAMOSTUDY] Changing Strategy to Shop");
				updateSideBar();
				StateStrategy newStrategy = new ShopStrategy(profile);
				recall(newStrategy);
			}
		});
		buttons.push(shopButton);
		
		JButton themesButton = new JButton(profile.getLanguage().text[5]);
		setUpButtonComponent(themesButton);
		themesButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("[TAMOSTUDY] Changing Strategy to Themes");
				updateSideBar();
				StateStrategy newStrategy = new ThemeStrategy(profile);
				
				//Actions that affect MainGUI
				selectButtons = ((ThemeStrategy) newStrategy).getSelectButtons();
				for(JButton button : selectButtons) {
					button.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							if(button.getText().equals("<html>Select<br>Dark Mode</html>")) { themeChanged(0); }
							else if(button.getText().equals("<html>Select<br>Light Mode</html>")) { themeChanged(1); }
							else if(button.getText().equals("<html>Select<br>Classic Red</html>")) { themeChanged(2); }
							else if(button.getText().equals("<html>Select<br>Classic Blue</html>")) { themeChanged(3); }
							else if(button.getText().equals("<html>Select<br>Classic Green</html>")) { themeChanged(4); }
							else if(button.getText().equals("<html>Select<br>Classic Yellow</html>")) { themeChanged(5); }
							else if(button.getText().equals("<html>Select<br>Classic Orange</html>")) { themeChanged(1); }
							else if(button.getText().equals("<html>Select<br>Classic Purple</html>")) { themeChanged(1); }
						}
					});
				}
				recall(newStrategy);
			}
		});
		buttons.push(themesButton);
		
		JButton inventoryButton = new JButton(profile.getLanguage().text[6]);
		setUpButtonComponent(inventoryButton);
		inventoryButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("[TAMOSTUDY] Changing Strategy to Inventory");
				updateSideBar();
				StateStrategy newStrategy = new InventoryStrategy(profile);
				recall(newStrategy);
			}
		});
		buttons.push(inventoryButton);
		
		JButton statsButton = new JButton(profile.getLanguage().text[7]);
		setUpButtonComponent(statsButton);
		statsButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("[TAMOSTUDY] Changing Strategy to Statistics");
				updateSideBar();
				StateStrategy newStrategy = new StatisticsStrategy(profile);
				recall(newStrategy);
			}
		});
		buttons.push(statsButton);
		
		JButton achievementsButton = new JButton(profile.getLanguage().text[8]);
		setUpButtonComponent(achievementsButton);
		achievementsButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("[TAMOSTUDY] Changing Strategy to Achievements");
				updateSideBar();
				StateStrategy newStrategy = new AchievementsStrategy(profile);
				recall(newStrategy);
			}
		});
		buttons.push(achievementsButton);
		
		JButton settingsButton = new JButton(profile.getLanguage().text[9]);
		setUpButtonComponent(settingsButton);
		settingsButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("[TAMOSTUDY] Changing Strategy to Settings");
				updateSideBar();
				StateStrategy newStrategy = new SettingsStrategy(profile);
				recall(newStrategy);
			}
		});
		buttons.push(settingsButton);
		
		JButton aboutButton = new JButton(profile.getLanguage().text[10]);
		setUpButtonComponent(aboutButton);
		aboutButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("[TAMOSTUDY] Changing Strategy to About");
				updateSideBar();
				StateStrategy newStrategy = new AboutStrategy(profile);
				recall(newStrategy);
			}
		});
		buttons.push(aboutButton);
		
		//adds components to the sidePanel
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
		openSidePanel.setBackground(theme.mainColor);
		panels.add(openSidePanel);
		
		//openSidePanel component
		
		openSideLabel = new JButton(profile.getLanguage().text[0]);
		setUpButtonComponent(openSideLabel, 1);
		openSideLabel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("[TAMOSTUDY] Menu was updated!");
				updateSideBar();
			}
		});
		
		JLabel welcomeUserLabel = new JLabel(profile.getLanguage().text[1] + profile.getUsername());
		setUpLabelComponent(welcomeUserLabel);
		labels.push(welcomeUserLabel);
		
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
		label.setForeground(theme.layerTextColor);
		label.setFont(new Font("Arial", Font.BOLD, 16));
	}
	
	public void setUpLabelComponent(JLabel label, int num) {
		label.setForeground(theme.layerTextColor);
	}
	
	public void setUpButtonComponent(JButton button) {
		button.setBorderPainted(false);
		button.setBackground(theme.mainColor);
		button.setForeground(theme.layerTextColor);
		button.setFocusPainted(false);
		button.setFont(new Font("Arial", Font.BOLD, 16));
	}
	
	public void setUpButtonComponent(JButton button, int num) {
		button.setBackground(theme.mainColor);
		button.setForeground(theme.layerTextColor);
		button.setFocusPainted(false);
		button.setFont(new Font("Arial", Font.BOLD, 16));
	}
	
	/**
	 * themeChanged
	 * @brief Indicates the theme has changed
	 * @param i
	 */
	public void themeChanged(int i) {
		profile.setThemeIndicator(i);
		theme = profile.getThemeIndicator();
		themeAction = new CommunicateThemeAction(theme, openSideLabel, panels, buttons, labels, breaks);
		themeAction.updateMainGUI();
	}
	
	/**
	 * setStudyComponentFunctions
	 * The point of this is to disable the buttons
	 * on the outside when the start button is selected
	 */
	public void setStudyComponentFunctions() {
		startFocusButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Hello from MainGUI");
				//TODO Disable the buttons during study session
				//I will need to make some timer variable in this GUI that signals
				//when a session is over... They must be the same....??
				startFocusButton.setText("Hello World");
			}
			
		});
	}
}
