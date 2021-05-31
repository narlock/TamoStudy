/**
 * @author Anthony Narlock
 * @description welcome to TamoStudy page
 */

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

public class welcomeGUI extends JFrame {
	
	/*
	 * Panels and components of GUI
	 */
	private JPanel topPanel, centerPanel, buttonPanel;
	private JLabel titleLabel, botLabel;
	private JButton existingLoginButton, createProfileButton, aboutButton;
	
	private JLabel imageLabel;
	
	/*
	 * Variables, file information
	 */
	private Profile profile;
	private int result;
	
	private File file;
	private BufferedWriter bw;
	
	private JComboBox languageBox;
	
	/*
	 * Constructor
	 */
	public welcomeGUI() {
		//System.out.println("If you can see this message, do NOT close the terminal/command line or TamoStudy will close.");
		
		setUpFrame();
		
		initVariables();
		
		createAspects();
		
		setUpGUI();
		
		this.setSize(550,350);
	}
	
	/*
	 * Method sets up the frame information
	 */
	public void setUpFrame() {
		ImageIcon logo = new ImageIcon(getClass().getClassLoader().getResource("heart.png"));
		
		//UI Manager implements background colors for panels and option panes
		UIManager UI = new UIManager();
		UI.put("OptionPane.background", new Color(255,161,161));
		UI.put("Panel.background", new Color(255,161,161));
		
		this.setTitle("TamoStudy | alpha 0.7.0");
		this.setSize(550,349);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setIconImage(logo.getImage());
		
	}
	/*
	 * Method initializes the variables and components
	 */
	public void initVariables() {
		//imageLabel = new JLabel(new ImageIcon("assets/welcome.png"));
		imageLabel = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("wel-welcome.png")));
		
		topPanel = new JPanel();
		centerPanel = new JPanel();
		buttonPanel = new JPanel();
		
		titleLabel = new JLabel("Welcome to TamoStudy");
		titleLabel.setFont(new Font ("Tahoma", Font.BOLD, 24));
		
		botLabel = new JLabel("alpha 0.5.0");
		
		//createProfileButton = new JButton("Create New Profile");
		createProfileButton = new JButton(new ImageIcon(getClass().getClassLoader().getResource("wel-new_button.png")));
		createProfileButton.setBorderPainted(false);
		createProfileButton.setFocusPainted(false);
		createProfileButton.setContentAreaFilled(false);
		//existingLoginButton = new JButton("Load Existing Profile");
		existingLoginButton = new JButton(new ImageIcon(getClass().getClassLoader().getResource("wel-load_button.png")));
		existingLoginButton.setBorderPainted(false);
		existingLoginButton.setFocusPainted(false);
		existingLoginButton.setContentAreaFilled(false);
		//aboutButton = new JButton("About TamoStudy");
		aboutButton = new JButton(new ImageIcon(getClass().getClassLoader().getResource("wel-about.png")));
		//aboutButton.setBorderPainted(new ImageIcon("assets/about_button.png"));
		aboutButton.setBorderPainted(false);
		aboutButton.setFocusPainted(false);
		aboutButton.setContentAreaFilled(false);

		languageBox = new JComboBox();
		languageBox.addItem("English");
		languageBox.addItem("Español (Spanish)");
		languageBox.addItem("Português (Portuguese)");
		languageBox.addItem("Deutsche (German)");
		languageBox.addItem("日本語 (Japanese)");
		languageBox.addItem("Nederlands (Dutch)");
		languageBox.addItem("Français (French)");
		//languageBox.addItem("汉语/漢語 (Chinese)");
	}
	
	/*
	 * Method creates the aspects of the components, action listeners
	 */
	public void createAspects() {
		createProfileButton.addActionListener(new ActionListener() {

			JPanel newProfilePanel = new JPanel(new GridLayout(0,1));
			JLabel usernameLabel = new JLabel("New username:");
			JLabel passwordLabel = new JLabel("New password:");
			JLabel tamoNameLabel = new JLabel("Enter your Tamo's name:");
			JLabel languageLabel = new JLabel("Language:");
			
			JTextField usernameField = new JTextField("");
			JTextField passwordField = new JTextField("");
			JTextField tamoNameField = new JTextField("");
			
			//JButton confirmNewProfileButton = new JButton("Confirm New Profile");
			//JButton cancelButton = new JButton("Cancel");
			
			@Override
			public void actionPerformed(ActionEvent e) {
				newProfilePanel.add(usernameLabel);
				newProfilePanel.add(usernameField);
				newProfilePanel.add(passwordLabel);
				newProfilePanel.add(passwordField);
				newProfilePanel.add(tamoNameLabel);
				newProfilePanel.add(tamoNameField);
				newProfilePanel.add(languageLabel);
				newProfilePanel.add(languageBox);
				
				int resultPane = JOptionPane.showConfirmDialog(null, newProfilePanel, "Create New Profile",
						JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
				if(resultPane == JOptionPane.OK_OPTION) {
					result = 1;
					
					int language_indicator = getLanguageIndicator(languageBox.getSelectedItem().toString());
					
					profile = new Profile(usernameField.getText(), passwordField.getText(), tamoNameField.getText(), language_indicator);
					
					
					try {
						if(profileExistsInFile(usernameField.getText())) {
							JOptionPane.showMessageDialog(rootPane, "Unexpected Error:\nThis user already exists in data file.", "Error Message", JOptionPane.INFORMATION_MESSAGE,  new ImageIcon(getClass().getClassLoader().getResource("info.png")));
							usernameField.setText("");
							passwordField.setText("");
						} else {
							writeProfileToFile(profile);
							
							GUI Focus = new GUI(profile);
						}
						
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					
				} else {
					//System.out.println("Cancelled");
				}
				
			}
			
		});
		
		
		//User wants to load profile already in text file
		existingLoginButton.addActionListener(new ActionListener() {

			JPanel newProfilePanel = new JPanel(new GridLayout(0,1));
			JLabel usernameLabel = new JLabel("Username:");
			JLabel passwordLabel = new JLabel("Password:");
			
			JTextField usernameField = new JTextField("");
			JTextField passwordField = new JTextField("");
			
			@Override
			public void actionPerformed(ActionEvent e) {
				newProfilePanel.add(usernameLabel);
				newProfilePanel.add(usernameField);
				newProfilePanel.add(passwordLabel);
				newProfilePanel.add(passwordField);
				
				int resultPane = JOptionPane.showConfirmDialog(null, newProfilePanel, "Load Existing Profile",
						JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
				if(resultPane == JOptionPane.OK_OPTION) {
					result = 1;
					try {
						if(profileExistsInFile(usernameField.getText(), passwordField.getText())) {
						//if(!usernameField.getText().equals("") && !passwordField.equals("")) {
								profile = loadProfileFromFile(usernameField.getText(), passwordField.getText());
								GUI Focus = new GUI(profile);
								hideWindow();
							
							
						} else {
							JOptionPane.showMessageDialog(rootPane, "Unexpected Error:\nThis user is not in data file.", "Error Message", JOptionPane.INFORMATION_MESSAGE,  new ImageIcon(getClass().getClassLoader().getResource("info.png")));
							usernameField.setText("");
							passwordField.setText("");
						}
					} catch (IOException e1) {
						//e1.printStackTrace();
						JOptionPane.showMessageDialog(rootPane, "This user is not in data file.\nIf you believe this is a mistake, please report bug on our Discord Server", "Error Message", JOptionPane.INFORMATION_MESSAGE,  new ImageIcon(getClass().getClassLoader().getResource("info.png")));
						usernameField.setText("");
						passwordField.setText("");
					}
					
					
				} else {
					//System.out.println("Cancelled");
				}
				
				
			}
			
		});
		
		aboutButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//TODO: Create an ImageIcon and throw it into a JLabel, then display that to an OK Option Pane
				JPanel aboutPanel = new JPanel();
				aboutPanel.setBackground(new Color(255,161,161));
				JPanel rightPanel = new JPanel();
				rightPanel.setBackground(new Color(255,161,161));
				rightPanel.setLayout(new GridLayout(4,1));
				
				JLabel label = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("about-about.png")));
				JButton twitter_button = new JButton(new ImageIcon(getClass().getClassLoader().getResource("about-twitter.png")));
				
				twitter_button.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						try {
							Desktop.getDesktop().browse(new URL("http://twitter.com/anthonynarlock").toURI());
						} catch (MalformedURLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (URISyntaxException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					
				});
				
				JButton github_button = new JButton(new ImageIcon(getClass().getClassLoader().getResource("about-github.png")));
				
				github_button.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						try {
							Desktop.getDesktop().browse(new URL("http://github.com/narlock").toURI());
						} catch (MalformedURLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (URISyntaxException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					
				});
				
				JButton discord_button = new JButton(new ImageIcon(getClass().getClassLoader().getResource("about-discord.png")));
				
				discord_button.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						try {
							Desktop.getDesktop().browse(new URL("https://discord.gg/eEbEYbXaNS").toURI());
						} catch (MalformedURLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (URISyntaxException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					
				});		
				
				JButton personal_button = new JButton(new ImageIcon(getClass().getClassLoader().getResource("about-narlock.png")));
				
				personal_button.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						try {
							Desktop.getDesktop().browse(new URL("https://anthonynarlock.com").toURI());
						} catch (MalformedURLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (URISyntaxException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					
				});	
				
				aboutPanel.add(label);
				aboutPanel.add(rightPanel);
				rightPanel.add(personal_button);
				rightPanel.add(github_button);
				rightPanel.add(twitter_button);
				rightPanel.add(discord_button);
				
				rootPane.setBackground(new Color(255,161,161));
				
				JOptionPane.showMessageDialog(rootPane, aboutPanel, "About TamoStudy", JOptionPane.PLAIN_MESSAGE);
			}
			
		});
	}
	
	/*
	 * Method sets up GUI, layout
	 */
	public void setUpGUI() {
		//this.getContentPane().setLayout(new GridLayout(3,1));
		this.getContentPane().setLayout(new BorderLayout());
		this.getContentPane().setBackground(new Color(255,161,161));
		
		this.getContentPane().add(topPanel, BorderLayout.NORTH);
		this.getContentPane().add(centerPanel, BorderLayout.CENTER);
		this.getContentPane().add(buttonPanel, BorderLayout.SOUTH);
		
		addComponentsToTopPanel();
		addComponentsToCenterPanel();
		addComponentsToButtonPanel();
	}
	
	public void addComponentsToTopPanel() {
		topPanel.setLayout(new BorderLayout());
		topPanel.setBackground(new Color(255,161,161));
		
		//titleLabel.setHorizontalAlignment(JLabel.CENTER);
		//botLabel.setHorizontalAlignment(JLabel.CENTER);
		
		//topPanel.add(titleLabel, BorderLayout.CENTER);
		
		//topPanel.add(botLabel, BorderLayout.SOUTH);
		//topPanel.add(imageLabel);
	}
	
	public void addComponentsToCenterPanel() {
		centerPanel.setBackground(new Color(255,161,161));
		centerPanel.add(imageLabel);
	}
	
	public void addComponentsToButtonPanel() {
		buttonPanel.setBackground(new Color(255,161,161));
		buttonPanel.add(createProfileButton);
		buttonPanel.add(existingLoginButton);
		buttonPanel.add(aboutButton);
		//buttonPanel.add(botLabel);
	
	}
	
	/*
	 * Method hides the main windows and disposes it
	 */
	public void hideWindow() {
		this.setVisible(false);
		this.dispose();
	}
	
	/*
	 * Write the profile to a file
	 */
	public void writeProfileToFile(Profile p) throws IOException {
		//hides the main screen page
		this.setVisible(false);
		
		String profileInfo = "\n" + p.getUsername() + "," + p.getPassword() + "," + p.getJoinDate() + "," + p.getTotalTime() + "," + p.getMoney() + "," + p.getTamo().tamoInfo() + "," + p.getLastLoginString()  + "," + p.getCurrentBackground() + "," + p.getGuiColor() + "," + p.getTamo().getId() + "," + p.getLanguageIndicator();
		//System.out.println("DEBUG: profileInfo = " + profileInfo);
		String encryptedInfo = (profileInfo);
		
		FileWriter fileWriter = new FileWriter("profiles/"+ p.getUsername() +".txt");
		fileWriter.write(encryptedInfo);
		fileWriter.flush();
		fileWriter.close();
		
		//System.out.println("pasts commands");
	}
	
	/*
	 * Check to see if the profile exists inside of the profiles folder
	 * The indicator is if the text file is the username, and the password matches inside of the text field
	 */
	public boolean profileExistsInFile(String username, String password) throws IOException {
		//System.out.println("debug: username = " + username);
		
		//file = new File("profiles/"+ username + ".txt");
		BufferedReader br = new BufferedReader(new FileReader("profiles/"+ username + ".txt"));
		
		String line;
		while ((line = (br.readLine())) != null) {
			if(!line.equals("")) {
				//System.out.println(line);
				boolean exists = false;
				String[] profileDetails = line.split(",");
				
				if(profileDetails[1].equals(password)) {
					br.close();
					return true;
				}
			} else {
				
			}
		}
		br.close();
		return false;
	}
	
	public boolean profileExistsInFile(String username) {
		//System.out.println("debug: username = " + username);
		
		try {
			BufferedReader br = new BufferedReader(new FileReader("profiles/"+ username + ".txt"));
		} catch (IOException e) {
			return false;
		}
		
		return true;

	}
	
	/*
	 * Loads profile from file
	 */
	public Profile loadProfileFromFile(String username, String password) throws IOException {
		//String[] profileDetails = line.split(",");
		//compare [0] to username and [1] to password, if equal return the profile
		String line = "";
		
		BufferedReader br = new BufferedReader(new FileReader("profiles/"+ username + ".txt"));
		
		//TODO: fix this shit
		while((line = (br.readLine())) != null) {
			if(!line.equals("")) {
				int flag = -1;
				boolean flagFound = false;
				String[] profileDetails = line.split(",");
			
				
				if(profileDetails[1].equals(password)) {
					flag = 0;
					flagFound = true;
				}
			
				if(flagFound) {
					//return here
					Tamo loadTamo = new Tamo(profileDetails[flag+5], Integer.parseInt(profileDetails[flag+6]), Integer.parseInt(profileDetails[flag+7]), Integer.parseInt(profileDetails[flag+8]), Integer.parseInt(profileDetails[flag+12]));
					Profile load = new Profile(profileDetails[flag+0],profileDetails[flag+1],profileDetails[flag+2], Integer.parseInt(profileDetails[flag+3]), Integer.parseInt(profileDetails[flag+4]),loadTamo, profileDetails[flag+9], Integer.parseInt(profileDetails[flag+10]), profileDetails[flag+11], Integer.parseInt(profileDetails[flag+13]));
					br.close();
					return load;
				}
			}
			else {
				
			}
		}
		br.close();
		return null;
	}
	
	public int getLanguageIndicator(String languageString) {
		if(languageString.equals("English"))
			return 0;
		if(languageString.equals("Español (Spanish)"))
			return 1;
		if(languageString.equals("Português (Portuguese)"))
			return 2;
		if(languageString.equals("Deutsche (German)"))
			return 3;
		if(languageString.equals("日本語 (Japanese)"))
			return 4;
		if(languageString.equals("Nederlands (Dutch)"))
			return 5;
		if(languageString.equals("Français (French)"))
			return 6;
		if(languageString.equals("汉语/漢語 (Chinese)"))
			return 7;
		
		return 0;
	}
}
