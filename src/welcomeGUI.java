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
	
	private Profile profile;
	private int result;
	private File file;
	
	public welcomeGUI() {
		setUpFrame();
		
		initVariables();
		
		createAspects();
		
		setUpGUI();
		
		this.setSize(500,350);
	}
	
	public void setUpFrame() {
		ImageIcon logo = new ImageIcon("assets/heart.png");
		
		this.setTitle("Welcome - TamoStudy - alpha 0.2.0");
		this.setSize(500,349);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setIconImage(logo.getImage());
		
	}
	
	public void initVariables() {
		topPanel = new JPanel();
		centerPanel = new JPanel();
		buttonPanel = new JPanel();
		
		titleLabel = new JLabel("Welcome to TamoStudy");
		titleLabel.setFont(new Font ("Tahoma", Font.BOLD, 24));
		
		botLabel = new JLabel("Created by Anthony Narlock - Version: alpha 0.2.0");
		
		createProfileButton = new JButton("Create New Profile");
		existingLoginButton = new JButton("Existing Profile");
		//TODO
		existingLoginButton.setEnabled(false);
		
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
	}
	
	public void setUpGUI() {
		this.getContentPane().setLayout(new GridLayout(3,1));
		this.getContentPane().setBackground(new Color(255,161,161));
		
		this.getContentPane().add(topPanel);
		this.getContentPane().add(centerPanel);
		this.getContentPane().add(buttonPanel);
		
		addComponentsToTopPanel();
		addComponentsToCenterPanel();
		addComponentsToButtonPanel();
	}
	
	public void addComponentsToTopPanel() {
		topPanel.setBackground(new Color(255,161,161));
		topPanel.add(titleLabel);
	}
	
	public void addComponentsToCenterPanel() {
		centerPanel.setBackground(new Color(255,161,161));
	}
	
	public void addComponentsToButtonPanel() {
		buttonPanel.setBackground(new Color(255,161,161));
		buttonPanel.add(createProfileButton);
		buttonPanel.add(existingLoginButton);
		buttonPanel.add(botLabel);
	
	}
	
	public void writeProfileToFile(Profile p) throws IOException {
		//hides the main screen page
		this.setVisible(false);
		
		String profileInfo = p.getUsername() + "," + p.getPassword() + "," + p.getTamo().tamoInfo();
		
		//rid this
		file = new File("profiles.txt");
		OutputStream outStream = new FileOutputStream(file);
		outStream.write(profileInfo.getBytes());
		outStream.close();
		
	}
}
