//welcome to TamoStudy page

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;

public class welcomeGUI extends JFrame {
	private JPanel topPanel, centerPanel, buttonPanel;
	private JLabel titleLabel, botLabel;
	private JButton existingLoginButton, createProfileButton;
	
	private JLabel imageLabel;
	
	private Profile profile;
	private int result;
	
	private File file;
	private BufferedWriter bw;
	
	public welcomeGUI() {
		setUpFrame();
		
		initVariables();
		
		createAspects();
		
		setUpGUI();
		
		this.setSize(500,350);
	}
	
	public void setUpFrame() {
		ImageIcon logo = new ImageIcon("assets/heart.png");
		
		this.setTitle("TamoStudy - alpha 0.2.2");
		this.setSize(500,349);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setIconImage(logo.getImage());
		
	}
	
	public void initVariables() {
		imageLabel = new JLabel(new ImageIcon("assets/tama_welcome.png"));
		
		topPanel = new JPanel();
		centerPanel = new JPanel();
		buttonPanel = new JPanel();
		
		titleLabel = new JLabel("Welcome to TamoStudy");
		titleLabel.setFont(new Font ("Tahoma", Font.BOLD, 24));
		
		botLabel = new JLabel("alpha 0.2.2");
		
		createProfileButton = new JButton("Create New Profile");
		existingLoginButton = new JButton("Load Existing Profile");

		
	}
	
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
	}
	
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
		
		titleLabel.setHorizontalAlignment(JLabel.CENTER);
		botLabel.setHorizontalAlignment(JLabel.CENTER);
		
		topPanel.add(titleLabel, BorderLayout.CENTER);
		
		topPanel.add(botLabel, BorderLayout.SOUTH);
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
		//buttonPanel.add(botLabel);
	
	}
	
	public void hideWindow() {
		this.setVisible(false);
	}
	
	public void writeProfileToFile(Profile p) throws IOException {
		//hides the main screen page
		this.setVisible(false);
		
		String profileInfo = p.getUsername() + "," + p.getPassword() + "," + p.getJoinDate() + "," + p.getTotalTime() + "," + p.getMoney() + "," + p.getTamo().tamoInfo();
		
		
		file = new File("profiles.txt");
		if(!file.exists()) {
			file.createNewFile();
		}
		
		FileWriter fileWriter = new FileWriter(file.getName(), true);
		bw = new BufferedWriter(fileWriter);
		bw.append("\n" + profileInfo);
		bw.close();
		
		
	}
	
	//TODO: Scan the file to see if the profile exists
	public boolean profileExistsInFile(String username, String password) throws IOException {
		file = new File("profiles.txt");
		BufferedReader br = new BufferedReader(new FileReader(file.getName()));
		
		String line;
		while ((line = br.readLine()) != null) {
			if(!line.equals("")) {
				//System.out.println(line);
				boolean exists = false;
				String[] profileDetails = line.split(",");
				
				if(profileDetails[0].equals(username) && profileDetails[1].equals(password)) {
					br.close();
					return true;
				}
			} else {
				
			}
		}
		br.close();
		return false;
	}
	
	public Profile loadProfileFromFile(String username, String password) throws IOException {
		//String[] profileDetails = line.split(",");
		//compare [0] to username and [1] to password, if equal return the profile
		String line = "";
		
		file = new File("profiles.txt");
		if(!file.exists()) {
			file.createNewFile();
		}
		
		BufferedReader br = new BufferedReader(new FileReader(file.getName()));
		
		//TODO: fix this shit
		while((line = br.readLine()) != null) {
			if(!line.equals("")) {
				int flag = -1;
				boolean flagFound = false;
				String[] profileDetails = line.split(",");
			
				for(int i = 0; i < profileDetails.length; i++) {
					if(profileDetails[i].equals(username) && profileDetails[i+1].equals(password)) {
						flag = i;
						flagFound = true;
					}
					
				}
			
				if(flagFound) {
					//return here
					Tamo loadTamo = new Tamo(profileDetails[flag+5], Integer.parseInt(profileDetails[flag+6]), Integer.parseInt(profileDetails[flag+7]), Integer.parseInt(profileDetails[flag+8]));
					Profile load = new Profile(profileDetails[flag+0],profileDetails[flag+1],profileDetails[flag+2], Integer.parseInt(profileDetails[flag+3]), Integer.parseInt(profileDetails[flag+4]),loadTamo);
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
