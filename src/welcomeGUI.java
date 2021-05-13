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
	
	/*
	 * Constructor
	 */
	public welcomeGUI() {
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
		ImageIcon logo = new ImageIcon("assets/heart.png");
		
		this.setTitle("TamoStudy | alpha 0.4.3");
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
		imageLabel = new JLabel(new ImageIcon("assets/welcome.png"));
		
		topPanel = new JPanel();
		centerPanel = new JPanel();
		buttonPanel = new JPanel();
		
		titleLabel = new JLabel("Welcome to TamoStudy");
		titleLabel.setFont(new Font ("Tahoma", Font.BOLD, 24));
		
		botLabel = new JLabel("alpha 0.4.0");
		
		//createProfileButton = new JButton("Create New Profile");
		createProfileButton = new JButton(new ImageIcon("assets/new_button.png"));
		createProfileButton.setBorderPainted(false);
		createProfileButton.setFocusPainted(false);
		createProfileButton.setContentAreaFilled(false);
		//existingLoginButton = new JButton("Load Existing Profile");
		existingLoginButton = new JButton(new ImageIcon("assets/load_button.png"));
		existingLoginButton.setBorderPainted(false);
		existingLoginButton.setFocusPainted(false);
		existingLoginButton.setContentAreaFilled(false);
		//aboutButton = new JButton("About TamoStudy");
		aboutButton = new JButton(new ImageIcon("assets/about_button.png"));
		//aboutButton.setBorderPainted(new ImageIcon("assets/about_button.png"));
		aboutButton.setBorderPainted(false);
		aboutButton.setFocusPainted(false);
		aboutButton.setContentAreaFilled(false);

		
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
				
				int resultPane = JOptionPane.showConfirmDialog(null, newProfilePanel, "Create New Profile",
						JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
				if(resultPane == JOptionPane.OK_OPTION) {
					result = 1;
					profile = new Profile(usernameField.getText(), passwordField.getText(), tamoNameField.getText());
					
					
					//TODO: update this try and catch statement
					try {
						writeProfileToFile(profile);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
					GUI Focus = new GUI(profile);
					
				} else {
					System.out.println("Cancelled");
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
							JOptionPane.showMessageDialog(rootPane, "Unexpected Error:\nThis user is not in data file.", "Error Message", JOptionPane.INFORMATION_MESSAGE);
							usernameField.setText("");
							passwordField.setText("");
						}
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
				} else {
					System.out.println("Cancelled");
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
				rightPanel.setLayout(new GridLayout(3,1));
				
				JLabel label = new JLabel(new ImageIcon("assets/about.png"));
				JButton twitter_button = new JButton("Twitter");
				
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
				
				JButton github_button = new JButton("GitHub");
				
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
				
				JButton discord_button = new JButton("Join Discord");
				
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
				
				aboutPanel.add(label);
				aboutPanel.add(rightPanel);
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
		
		String profileInfo = "\n" + p.getUsername() + "," + p.getPassword() + "," + p.getJoinDate() + "," + p.getTotalTime() + "," + p.getMoney() + "," + p.getTamo().tamoInfo() + "," + p.getLastLoginString()  + "," + p.getCurrentBackground();
		System.out.println("DEBUG: profileInfo = " + profileInfo);
		
		FileWriter fileWriter = new FileWriter("profiles/"+ p.getUsername() +".txt");
		fileWriter.write(profileInfo);
		fileWriter.flush();
		fileWriter.close();
		
		System.out.println("pasts commands");
	}
	
	/*
	 * Check to see if the profile exists inside of the profiles folder
	 * The indicator is if the text file is the username, and the password matches inside of the text field
	 */
	public boolean profileExistsInFile(String username, String password) throws IOException {
		System.out.println("debug: username = " + username);
		
		//file = new File("profiles/"+ username + ".txt");
		BufferedReader br = new BufferedReader(new FileReader("profiles/"+ username + ".txt"));
		
		String line;
		while ((line = br.readLine()) != null) {
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
	
	/*
	 * Loads profile from file
	 */
	public Profile loadProfileFromFile(String username, String password) throws IOException {
		//String[] profileDetails = line.split(",");
		//compare [0] to username and [1] to password, if equal return the profile
		String line = "";
		
		BufferedReader br = new BufferedReader(new FileReader("profiles/"+ username + ".txt"));
		
		//TODO: fix this shit
		while((line = br.readLine()) != null) {
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
					Tamo loadTamo = new Tamo(profileDetails[flag+5], Integer.parseInt(profileDetails[flag+6]), Integer.parseInt(profileDetails[flag+7]), Integer.parseInt(profileDetails[flag+8]));
					Profile load = new Profile(profileDetails[flag+0],profileDetails[flag+1],profileDetails[flag+2], Integer.parseInt(profileDetails[flag+3]), Integer.parseInt(profileDetails[flag+4]),loadTamo, profileDetails[flag+9], Integer.parseInt(profileDetails[flag+10]));
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
}
