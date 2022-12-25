import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.net.URL;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import profile.Profile;
import profile.ProfileReaderWriter;
import resources.BubbleBorder;
import resources.CheckForUpdates;
import resources.DiscordRP;
import resources.Encryption;

/**
 * WelcomeGUI
 * @author Anthony Narlock (narlock)
 * @brief The Welcome / Login GUI
 * Logs the user into the main program
 */

public class WelcomeGUI extends JFrame {
	
	private JPanel mainPanel;
	
	private JLabel titleCardImageLabel;
	
	private JPanel buttonPanel;
	private JButton newProfileButton, loadProfileButton;
	
	private JLabel authorLabel;
	
	private final Color mainColor = new Color(78,78,78);
	private final Font fontBoldReg = new Font("Arial", Font.BOLD, 24);
	
	//Update Checker
	private JButton updateButton;
	private final JLabel visibleSpaceLabel = createSpaceLabel();
	
	//Display Message
	private final JLabel displayErrorProfileLabel = new JLabel("Invalid Profile File - the file you chose is incompatible with TamoStudy Beta v4.0");
	
	//FILE COMPONENTS
	private File file;
	private BufferedWriter bw;
	private Profile profile;
	
	private JFileChooser fileChooser;
	
	private DiscordRP discordRP;
	
	/**
	 * WelcomeGUI
	 * The Frame that will log the user in to TamoStudy
	 */
	public WelcomeGUI() {
		discordRP = new DiscordRP();
		discordRP.start();
		
		initFrame();
		initComponentsToFrame();
		initComponentActions();
		this.setSize(650,500);
		
		//Check for updates
		checkForUpdates();
		
		discordRP.update("Idle", "Welcome Screen");
	}

	public void initFrame() {
		this.getContentPane().setBackground(mainColor);
		this.setTitle("launcher • TamoStudy Beta v4.2");
		this.setVisible(true);
		this.setSize(650,499);
		this.setLocationRelativeTo(null);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent evt) {
				System.out.println("TamoStudy Closing...");
			    discordRP.shutdown();
			    System.exit(0);
			}
		});
		this.setResizable(false);
		this.setIconImage(new ImageIcon(getClass().getClassLoader().getResource("ICON.png")).getImage());
	}
	
	public void initComponentsToFrame() {
		updateButton = new JButton("A new update is available. Click here to download!");
		updateButton.setOpaque(true);
		updateButton.setBackground(Color.WHITE);
		updateButton.setFont(new Font("Arial", Font.BOLD, 18));
		updateButton.setFocusPainted(false);
		updateButton.setBorder(new BubbleBorder(Color.BLACK, 2, 5, 2, true));
		updateButton.setAlignmentX(JComponent.CENTER_ALIGNMENT);
		updateButton.setVisible(false);
		
		mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		mainPanel.setBackground(mainColor);
		
		titleCardImageLabel = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("TITLE_SMALL.gif")));
		titleCardImageLabel.setAlignmentX(JComponent.CENTER_ALIGNMENT);
		
		buttonPanel = new JPanel();
			buttonPanel.setBackground(mainColor);
			buttonPanel.setAlignmentX(JComponent.CENTER_ALIGNMENT);
		newProfileButton = new JButton("New Profile");
			setUpJButton(newProfileButton);
		loadProfileButton = new JButton("Load Profile");
			setUpJButton(loadProfileButton);
		buttonPanel.add(newProfileButton);
		buttonPanel.add(loadProfileButton);
		
		authorLabel = new JLabel("Created by narlock • tamostudy.com");
			authorLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
			authorLabel.setForeground(new Color(153,153,153));
			authorLabel.setAlignmentX(JComponent.CENTER_ALIGNMENT);
		
		mainPanel.add(updateButton);
		mainPanel.add(visibleSpaceLabel);
		
		displayErrorProfileLabel.setForeground(Color.RED);
		displayErrorProfileLabel.setVisible(false);
		displayErrorProfileLabel.setAlignmentX(JComponent.CENTER_ALIGNMENT);
		mainPanel.add(displayErrorProfileLabel);
		
		mainPanel.add(titleCardImageLabel);
		mainPanel.add(createSpaceLabel());
		mainPanel.add(buttonPanel);
		mainPanel.add(authorLabel);
		mainPanel.add(createSpaceLabel());
		
		this.add(mainPanel);
	}
	
	//Styles Main Buttons
	public void setUpJButton(JButton button) {
//		if(System.getProperty("os.name").startsWith("Linux") || System.getProperty("os.name").startsWith("Windows"))
//			
		button.setOpaque(true);
		button.setBackground(Color.WHITE);
			
		button.setFont(fontBoldReg);
		button.setFocusPainted(false);
		button.setBorder(new BubbleBorder(Color.BLACK, 2, 10, 10, true));
	}
	
	//Creates a space label
	public JLabel createSpaceLabel() {
		//Space Component
		JLabel transparentComponent = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("TRANSPARENT.png")));
		transparentComponent.setAlignmentX(JComponent.CENTER_ALIGNMENT);
		return transparentComponent;
	}
	
	//Update Checker
	public void checkForUpdates() {
		CheckForUpdates updates = new CheckForUpdates();
		boolean isThereUpdates = false;
		
		try { isThereUpdates = updates.checkForUpdates(); }
		catch (Exception e1) { e1.printStackTrace(); }
		
		if(isThereUpdates) {
			mainPanel.remove(visibleSpaceLabel);
			updateButton.setVisible(true);
		}
	}
	
	//Initializes the component Actions
	public void initComponentActions() {
		fileChooser = new JFileChooser();
		
		//Update Button
		updateButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try { Desktop.getDesktop().browse(new URL("https://github.com/narlock/TamoStudy/releases/").toURI()); } 
				catch (Exception e1) { e1.printStackTrace(); }
			}
		});
		
		//New Profile Button Functionality
		newProfileButton.addActionListener(new ActionListener() {
			JPanel newProfilePanel = new JPanel(new GridLayout(0,1));
			JLabel usernameLabel = new JLabel("New username:");
			JLabel tamoNameLabel = new JLabel("Enter your Tamo's name:");
			JLabel languageLabel = new JLabel("Language:");
			JLabel difficultyLabel = new JLabel("Difficulty:");
			
			JTextField usernameField = new JTextField("");
			JTextField tamoNameField = new JTextField("");
			
			JComboBox languageBox = new JComboBox();
			JComboBox difficultyBox = new JComboBox();
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//Open the JOptionPane for creating a profile
				
				//Language Options
				languageBox.addItem("English");
				languageBox.addItem("Español (Spanish)");
				languageBox.addItem("Português (Portuguese)");
				languageBox.addItem("Deutsche (German)");
				languageBox.addItem("Français (French)");
				languageBox.addItem("Nederlands (Dutch)");
				languageBox.addItem("Türkçe (Turkish)");
				languageBox.addItem("Gaeilge (Irish)");
				languageBox.addItem("हिन्दी (Hindi)");
				languageBox.addItem("日本語 (Japanese)");
				languageBox.addItem("汉语/漢語 (Chinese)");
				
				//Difficulty Options
				difficultyBox.addItem("Peaceful");
				difficultyBox.addItem("Challenging");
				
				//Adding to Panel
				newProfilePanel.add(usernameLabel);
				newProfilePanel.add(usernameField);
				newProfilePanel.add(tamoNameLabel);
				newProfilePanel.add(tamoNameField);
				newProfilePanel.add(languageLabel);
				newProfilePanel.add(languageBox);
				newProfilePanel.add(difficultyLabel);
				newProfilePanel.add(difficultyBox);
				
				//OptionPane
				int resultPane =
						JOptionPane.showConfirmDialog(null, newProfilePanel,
						"Create New Profile", JOptionPane.OK_CANCEL_OPTION, 
						JOptionPane.PLAIN_MESSAGE);
				if(resultPane == JOptionPane.OK_OPTION) {
					profile = new Profile(null, usernameField.getText(), tamoNameField.getText(), 
							languageBox.getSelectedIndex(), difficultyBox.getSelectedIndex());
					File profileFile = null;
					if((profileFile = ProfileReaderWriter.writeProfileToFile(profile)) != null) {
						profile = new Profile(profileFile, usernameField.getText(), tamoNameField.getText(), 
								languageBox.getSelectedIndex(), difficultyBox.getSelectedIndex());

						
						MainGUI gui = new MainGUI(profile);
						hideWindow();
						discordRP.shutdown();
					}
					
				}
			}
		});
		
		//Load Profile Button Functionality
		loadProfileButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(selectFile() == 1) {
					try { 
						//Load the profile, launch main program
						profile = ProfileReaderWriter.getProfileInfoFromFile(file); 
						MainGUI Focus = new MainGUI(profile);
						hideWindow();
					}
					catch (Exception e1) { 
						displayErrorProfileLabel.setVisible(true); 
					
					}
				}
			}
		});
	}
	
	/**
	 * selectFile selects profile file and assigns to file.
	 * @return 1 for success, 0 for failure
	 */
	public int selectFile() {
		if(fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
			this.file = fileChooser.getSelectedFile();
			return 1;
		} else { return 0; }
	}
	
	/*
	 * Method hides the main windows and disposes it
	 */
	public void hideWindow() {
		this.setVisible(false);
		this.dispose();
	}
	
}
