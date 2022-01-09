/**
 * @author Anthony Narlock
 * @description welcome to TamoStudy page
 * 
 * @purpose Creates launching page for TamoStudy application
 * Users can create a new profile, fill out new profile form, then save profile text file to file system
 * Users can load their created profile. It must be a profile text file that is on their file system
 * Users can read "ABOUT" which displays TamoStudy about page with links
 */

import javax.imageio.ImageIO;
import javax.swing.*;
import profile.*;
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
	
	//private JMenu menu;
	private JButton updateProfile;
	private JButton checkForUpdatesButton;
	
	/*
	 * Variables, file information
	 */
	private Profile profile;
	private int result;
	
	private File file;
	private BufferedWriter bw;
	
	private JComboBox languageBox, difficultyBox;
	
	private JFileChooser fileChooser;
	private Encryption encryption;
	
	/*
	 * Constructor
	 */
	public welcomeGUI() {
		//System.out.println("If you can see this message, do NOT close the terminal/command line or TamoStudy will close.");
		
		setUpFrame();
		
		initVariables();
		
		createAspects();
		
		setUpGUI();
		
		this.setSize(550,400);
	
		checkForUpdatesNow();
	}
	
	public welcomeGUI(int old) {
		//System.out.println("If you can see this message, do NOT close the terminal/command line or TamoStudy will close.");
		
		setUpFrame();
		
		initVariables();
		
		createAspects();
		
		setUpGUI();
		
		this.setSize(550,400);
	}
	
	/*
	 * Method sets up the frame information
	 */
	public void setUpFrame() {
		ImageIcon logo = new ImageIcon(getClass().getClassLoader().getResource("ico.png"));
		
		//UI Manager implements background colors for panels and option panes
		UIManager UI = new UIManager();
		UI.put("OptionPane.background", new Color(255,161,161));
		UI.put("Panel.background", new Color(255,161,161));
		
		this.setTitle("TamoStudy | beta 3.0");
		this.setSize(550,399);
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
		updateProfile = new JButton("Update Outdated Profile");
		initButton(updateProfile);
		
		checkForUpdatesButton = new JButton("Check for Updates");
		initButton(checkForUpdatesButton);
		
		encryption = new Encryption();
		
		fileChooser = new JFileChooser();
		imageLabel = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("wel-welcome2.png")));
		
		topPanel = new JPanel();
		centerPanel = new JPanel();
		buttonPanel = new JPanel();
		
		titleLabel = new JLabel("Welcome to TamoStudy");
		titleLabel.setFont(new Font ("Tahoma", Font.BOLD, 24));
		
		botLabel = new JLabel("alpha 0.5.0");
		
		createProfileButton = new JButton(new ImageIcon(getClass().getClassLoader().getResource("wel-new.png")));
		createProfileButton.setBorderPainted(false);
		createProfileButton.setFocusPainted(false);
		createProfileButton.setContentAreaFilled(false);
		existingLoginButton = new JButton(new ImageIcon(getClass().getClassLoader().getResource("wel-load.png")));
		existingLoginButton.setBorderPainted(false);
		existingLoginButton.setFocusPainted(false);
		existingLoginButton.setContentAreaFilled(false);
		aboutButton = new JButton(new ImageIcon(getClass().getClassLoader().getResource("wel-option.png")));
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
			languageBox.addItem("Türkçe (Turkish)");
			//languageBox.addItem("汉语/漢語 (Chinese)");
		
		difficultyBox = new JComboBox();
			difficultyBox.addItem("Peaceful");
			difficultyBox.addItem("Challenging");
	}
	
	/*
	 * Method creates the aspects of the components, action listeners
	 */
	public void createAspects() {
		createProfileButton.addActionListener(new ActionListener() {

			JPanel newProfilePanel = new JPanel(new GridLayout(0,1));
			JLabel usernameLabel = new JLabel("New username:");
			JLabel tamoNameLabel = new JLabel("Enter your Tamo's name:");
			JLabel languageLabel = new JLabel("Language:");
			JLabel difficultyLabel = new JLabel("Difficulty:");
			
			JTextField usernameField = new JTextField("");
			JTextField tamoNameField = new JTextField("");
			
			@Override
			public void actionPerformed(ActionEvent e) {
				newProfilePanel.add(usernameLabel);
				newProfilePanel.add(usernameField);
				newProfilePanel.add(tamoNameLabel);
				newProfilePanel.add(tamoNameField);
				newProfilePanel.add(languageLabel);
				newProfilePanel.add(languageBox);
				newProfilePanel.add(difficultyLabel);
				newProfilePanel.add(difficultyBox);
				
				int resultPane = JOptionPane.showConfirmDialog(null, newProfilePanel, "Create New Profile",
						JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
				if(resultPane == JOptionPane.OK_OPTION) {
					result = 1;
					
					int language_indicator = getLanguageIndicator(languageBox.getSelectedItem().toString());
					int difficulty_indicator = getDifficultyIndicator(difficultyBox.getSelectedItem().toString());
					
					profile = new Profile(usernameField.getText(), tamoNameField.getText(), language_indicator, difficulty_indicator);
					
					if(writeProfileToFile(profile) == 1) {
						GUI Focus = new GUI(profile,file);
						hideWindow();
					} else {
						// do nothing
					}
					
				} else {
					//System.out.println("Cancelled");
				}
				
			}
			
		});
		
		
		//User wants to load profile already in text file
		existingLoginButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(selectFile() == 1) {
					try {
						profile = getProfileInfoFromFile();
					} catch (NumberFormatException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					GUI Focus = new GUI(profile, file);
					hideWindow();
				} else {
					//do nothing
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
				
				JPanel optionsPanel = new JPanel();
				optionsPanel.setLayout(new GridLayout(3,1));
				
				JLabel label = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("about-about2.png")));
				JButton twitter_button = new JButton(new ImageIcon(getClass().getClassLoader().getResource("about-twitter.png")));
				initButton(twitter_button);
				
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
				initButton(github_button);
				
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
				initButton(discord_button);
				
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
				initButton(personal_button);
				
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
				aboutPanel.add(optionsPanel, BorderLayout.SOUTH);
					optionsPanel.add(checkForUpdatesButton);
					JLabel spaceLabel = new JLabel();
					optionsPanel.add(spaceLabel);
					optionsPanel.add(updateProfile);
				rightPanel.add(personal_button);
				rightPanel.add(github_button);
				rightPanel.add(twitter_button);
				rightPanel.add(discord_button);
				
				rootPane.setBackground(new Color(255,161,161));
				
				JOptionPane.showMessageDialog(rootPane, aboutPanel, "Options - TamoStudy", JOptionPane.PLAIN_MESSAGE);
			}
			
		});
		
		updateProfile.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ProfileUpdater pu = new ProfileUpdater();
				hideWindow();
			}
			
		});
		
		checkForUpdatesButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				CheckForUpdates updates = new CheckForUpdates();
				boolean isThereUpdates = false;
				
				try {
					isThereUpdates = updates.checkForUpdates();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
				JPanel updatesPanel = new JPanel();
				JLabel updateResult = new JLabel();
				
				if(isThereUpdates) {
					updatesPanel.setLayout(new GridLayout(3,1));
					updateResult.setText("A new update is available!");
					JButton clickHereToDownload = new JButton("Click Here To Download Latest Update");
					initButton(clickHereToDownload);
					
					clickHereToDownload.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							try {
								Desktop.getDesktop().browse(new URL("https://github.com/narlock/TamoStudy/releases").toURI());
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
					
					JButton notifyButton = new JButton("Join Discord for update notifications!");
					initButton(notifyButton);
					notifyButton.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							try {
								Desktop.getDesktop().browse(new URL("https://tinyurl.com/TamoDiscord").toURI());
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
					
					
					updatesPanel.add(updateResult);
					updatesPanel.add(clickHereToDownload);
					updatesPanel.add(notifyButton);
					JOptionPane.showMessageDialog(rootPane, updatesPanel, "Checking for Updates", JOptionPane.PLAIN_MESSAGE, new ImageIcon(getClass().getClassLoader().getResource("info.png")));
				
				}
				else {
					JButton notifyButton = new JButton("Join Discord for update notifications!");
					initButton(notifyButton);
					notifyButton.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							try {
								Desktop.getDesktop().browse(new URL("https://tinyurl.com/TamoDiscord").toURI());
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
					
					updateResult.setText("No updates are available!");
					
					updatesPanel.setLayout(new GridLayout(2,1));
					updatesPanel.add(updateResult);
					updatesPanel.add(notifyButton);
					JOptionPane.showMessageDialog(rootPane, updatesPanel, "Checking for Updates", JOptionPane.PLAIN_MESSAGE, new ImageIcon(getClass().getClassLoader().getResource("info.png")));
				}
				
				
					
				
				
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
		//topPanel.setLayout(new BorderLayout());
		//topPanel.setBackground(new Color(255,161,161));
		
		//menu.add(updateProfile);
		//topPanel.add(checkForUpdatesButton);
		//topPanel.add(updateProfile);
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
	
	public int writeProfileToFile(Profile p) {
		final JFileChooser SaveAs = new JFileChooser();
		int actionDialog = SaveAs.showSaveDialog(this);
		if(actionDialog != JFileChooser.APPROVE_OPTION) {
			return 0;
		}
		
		File fileName = new File(SaveAs.getSelectedFile() + ".txt");
		BufferedWriter outFile = null;
		try {
			outFile = new BufferedWriter(new FileWriter(fileName));
			//Write Profile Information
			String profileInfo = p.toString() + "," + p.getSettings().toString() + "," + p.getTamo().toString() + "," + p.getAhm().getAhmString() + "," + p.getInv().getInvString();
			String encryptedInfo = encryption.encrypt(profileInfo);
			
			outFile.append(encryptedInfo);
			
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (outFile != null) {
				try {
					this.file = new File(SaveAs.getSelectedFile() + ".txt");
					outFile.close();
					return 1;
				} catch (IOException ex2) {
					
				}
			}
		}
		
		
		return 0;
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
		if(languageString.equals("Türkçe (Turkish)"))
			return 8;
		
		return 0;
	}
	
	public int getDifficultyIndicator(String difficultyString) {
		if(difficultyString.equals("Peaceful"))
			return 0;
		if(difficultyString.equals("Challenging"))
			return 1;
		
		return 0;
	}
	
	public int selectFile() {
		if(fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
			this.file = fileChooser.getSelectedFile();
			return 1;
		} else {
			return 0;
		}
	}
	
	public Profile getProfileInfoFromFile() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new FileReader(file));
		String line = "";
		Profile nullProfile;
		
		//TODO: fix this shit
		while((line = (br.readLine())) != null) {
			if(!line.equals("")) {
				System.out.println("line= " + line);
				String decrypt = encryption.decrypt(line);
				
				String[] profileDetails = decrypt.split(","); 
				
				for(int i = 0; i < profileDetails.length; i++) {
					System.out.println("profileDetails["+i+"] = " + profileDetails[i]);
				}
				//Constructor: Focus mode, language indicator, sessionSounds, backgroundSounds, difficulty
				ProfileSettings loadSettings = new ProfileSettings(Integer.parseInt(profileDetails[9]), Integer.parseInt(profileDetails[10]), Integer.parseInt(profileDetails[11]), Integer.parseInt(profileDetails[12]), Integer.parseInt(profileDetails[13]));
				
				//Constructor: stringIndicator
				Achievements loadAhm = new Achievements(profileDetails[18]);
				
				//Constructor: stringIndicator
				Inventory loadInv = new Inventory(profileDetails[19]);
				
				Tamo loadTamo = new Tamo(profileDetails[14], Integer.parseInt(profileDetails[15]), Integer.parseInt(profileDetails[16]), Integer.parseInt(profileDetails[17]));
				
				//Constructor: Name, JoinDate, NewLoginString, ConsecCount, TotalTime, TotalMoney, CurrentBG, CurrentGUI, StrikeCount
				Profile load = new Profile(profileDetails[0], profileDetails[1], profileDetails[2], Integer.parseInt(profileDetails[3]), Integer.parseInt(profileDetails[4]), Integer.parseInt(profileDetails[5]), Integer.parseInt(profileDetails[6]), profileDetails[7], Integer.parseInt(profileDetails[8]), loadSettings, loadTamo, loadAhm, loadInv);
				br.close();
				return load;
			}
		}
		return new Profile();
	}
	
	public void initButton(JButton button) {
		button.setBackground(Color.WHITE);
		button.setBorderPainted(false);
		button.setFocusPainted(false);
		
		button.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	if(button.isEnabled())
		    		button.setBackground(Color.LIGHT_GRAY);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	if(button.isEnabled())
		    		button.setBackground(Color.WHITE);
		    }
		});
	}
	
	/*
	 * InitButton
	 * 
	 * This method will take a JLabel, which will be an image icon, along with an identification integer
	 * This will implement a mouse listener (similar to the one above this comment) that changes
	 * the image to a highlighted image when the mouse enters the JLabel
	 */
	public void initButton(JLabel label, int id) {
		label.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	if(label.isEnabled()) {
		    		//set Image Icon according to id
		    	}
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	if(label.isEnabled()) {
		    		//set Image icon according to id
		    	}
		    }
		});
	}
	
	public void checkForUpdatesNow() {
		CheckForUpdates updates = new CheckForUpdates();
		boolean isThereUpdates = false;
		
		try {
			isThereUpdates = updates.checkForUpdates();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		JPanel updatesPanel = new JPanel();
		JLabel updateResult = new JLabel();
		
		if(isThereUpdates) {
			updatesPanel.setLayout(new GridLayout(3,1));
			updateResult.setText("A new update is available!");
			JButton clickHereToDownload = new JButton("Click Here To Download Latest Update");
			initButton(clickHereToDownload);
			
			clickHereToDownload.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						Desktop.getDesktop().browse(new URL("https://github.com/narlock/TamoStudy/releases").toURI());
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
			
			JButton notifyButton = new JButton("Join Discord for update notifications!");
			initButton(notifyButton);
			notifyButton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						Desktop.getDesktop().browse(new URL("https://tinyurl.com/TamoDiscord").toURI());
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
			
			
			updatesPanel.add(updateResult);
			updatesPanel.add(clickHereToDownload);
			updatesPanel.add(notifyButton);
			JOptionPane.showMessageDialog(rootPane, updatesPanel, "Checking for Updates", JOptionPane.PLAIN_MESSAGE, new ImageIcon(getClass().getClassLoader().getResource("info.png")));
		
		}
		
	}
	
}
