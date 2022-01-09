/**
 * 
 * @author Anthony Narlock
 * @description ProfileUpdater updates a profile text file to the latest version of TamoStudy
 * 
 * How to use: 
 * 
 * User selects the version of TamoStudy their profile is from, then selects
 * the text file that their profile is from.
 * User will then hit update profile button and then the file will be rewritten and updated.
 *
 */

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ProfileUpdater extends JFrame {
	
	private JPanel mainPanel, centerPanel, centerTopPanel, centerBotPanel, filePanel, versionPanel, botPanel, titlePanel, imagePanel;
	
	private JLabel titleLabel, mainImageLabel, selectVersionLabel, selectFileLabel;
	private JComboBox versionBox;
	private JLabel pathFileLabel, tamoInfoImage;
	private JButton selectFileButton, updateButton;
	
	private File file;
	private JFileChooser fileChooser;
	private Encryption encryption;
	
	public ProfileUpdater() {
		setUpFrame();
		
		initComponents();
		
		initComponentFunctionality();
		
		setUpGUI();
		
		this.setSize(500,400);
	}
	
	public void setUpFrame() {
		this.setTitle("TamoStudy Profile Updater - By: Anthony Narlock");
		this.setSize(500,399);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);
		this.setBackground(new Color(255,161,161));
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		ImageIcon logo = new ImageIcon(getClass().getClassLoader().getResource("ico.png"));
		this.setIconImage(logo.getImage());
		
		UIManager UI = new UIManager();
		UI.put("OptionPane.background", new Color(255,161,161));
		UI.put("Panel.background", new Color(255,161,161));
	}
	
	
	public void initComponents() {
		fileChooser = new JFileChooser();
		encryption = new Encryption();
		
		mainPanel = new JPanel();
		mainPanel.setBackground(new Color(255,161,161));
		centerPanel = new JPanel();
		centerPanel.setBackground(new Color(255,161,161));
		centerTopPanel = new JPanel();
		centerTopPanel.setBackground(new Color(255,161,161));
		centerBotPanel = new JPanel();
		centerBotPanel.setBackground(new Color(255,161,161));
		filePanel = new JPanel();
		filePanel.setBackground(new Color(255,161,161));
		versionPanel = new JPanel();
		versionPanel.setBackground(new Color(255,161,161));
		botPanel = new JPanel();
		botPanel.setBackground(new Color(255,161,161));
		titlePanel = new JPanel();
		titlePanel.setBackground(new Color(255,161,161));
		imagePanel = new JPanel();
		imagePanel.setBackground(new Color(255,161,161));
		
		titleLabel = new JLabel("TamoStudy Profile Updater");
		//tamoInfoImage = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("info.png")));
		tamoInfoImage = new JLabel();
		mainImageLabel = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("update.png")));
		selectVersionLabel = new JLabel("Select Version:");
		selectFileButton = new JButton("Open Profile File");
		
		versionBox = new JComboBox();
		versionBox.addItem("Open to Select Version");
		//versionBox.addItem("alpha 0.4.1");
		//versionBox.addItem("alpha 0.5.0");
		//versionBox.addItem("alpha 0.6.2");
		versionBox.addItem("beta 1.1");
		versionBox.addItem("beta 2.4");
		
		pathFileLabel = new JLabel("No File Opened");
		
		updateButton = new JButton("Update Profile");
	}
	
	public void initComponentFunctionality() {
		
		titleLabel.setFont(new Font("Tahoma", Font.BOLD, 18));

		selectFileButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				selectFile();
			}
		});
		
		updateButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					updateProfileFile();
					welcomeGUI gui = new welcomeGUI();
					hideWindow();
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
				}
			}
		});
	}
	
	public void setUpGUI() {
		this.add(titlePanel, BorderLayout.NORTH);
		this.add(centerPanel, BorderLayout.CENTER);
		this.add(botPanel, BorderLayout.SOUTH);
		
		titlePanel.add(titleLabel);
		titlePanel.add(tamoInfoImage);
		botPanel.add(updateButton);
		
		centerPanel.setLayout(new GridLayout(2,1));
		centerPanel.add(centerTopPanel);
		centerTopPanel.add(imagePanel);
		imagePanel.add(mainImageLabel);
		
		centerPanel.add(centerBotPanel);
		
		centerBotPanel.add(versionPanel);
		versionPanel.add(selectVersionLabel);
		versionPanel.add(versionBox);
		
		centerBotPanel.add(filePanel);
		filePanel.add(selectFileButton);
		filePanel.add(pathFileLabel);
		
	}
	
	public int selectFile() {
		if(fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
			this.file = fileChooser.getSelectedFile();
			pathFileLabel.setText(file.getAbsolutePath());
			return 1;
		} else {
			pathFileLabel.setText("No File Opened");
			return 0;
		}
	}
	
	public void updateProfileFile() throws IOException {
		if(this.file == null || versionBox.getSelectedItem().toString() == "Open to Select Version") {
			System.out.println("yes");
			return;
		}
		
		String version = versionBox.getSelectedItem().toString();
		if(version == "alpha 0.4.1") {
			updateVersion(0);
			return;
		}
		
		if(version == "alpha 0.5.0" || version == "alpha 0.6.2") {
			updateVersion(1);
			return;
		}
		
		if(version == "beta 1.1") {
			updateVersion(2);
			return;
		}
		
		if(version == "beta 2.4") {
			updateVersion(3);
			return;
		}
		
		
	}
	
	public void updateVersion(int num) throws IOException {
		if(num == 0) {
			BufferedReader br = new BufferedReader(new FileReader(file));
			
			String line;
			while ((line = (br.readLine())) != null) {
				if(!line.equals("")) {
					String old = line;
					String[] oldDetails = line.split(",");
					
					for(int i = 0; i < oldDetails.length; i++) {
						System.out.print("olddetails["+i+"] = " + oldDetails[i] + ",");
					}

					
					String[] newDetails = new String[13];
					
					newDetails[0] = oldDetails[0];
					
					
					for(int i = 1; i < 10; i++) {
						newDetails[i] = oldDetails[i + 1];
					}
					
					newDetails[10] = "default";
					newDetails[11] = "0";
					newDetails[12] = "0";
					
					System.out.println("\n");
					
					for(int i = 0; i < newDetails.length; i++) {
						System.out.print("newdetails["+i+"] = " + newDetails[i] + ",");
					}
					
					String newInfo = String.join(",", newDetails);
					System.out.println("\nnewinfo = " + newInfo);
					newInfo = encryption.encrypt(newInfo);
					
					File fnew = new File(file.getAbsolutePath());
					
					try {
						FileWriter writer = new FileWriter(fnew, false);
						writer.write(newInfo);
						writer.close();
						return;
						
					} catch (IOException e) {
						
					} catch (ArrayIndexOutOfBoundsException e) {
						
					}
					
				}
			}
		}
		
		
		if(num == 1) {
			BufferedReader br = new BufferedReader(new FileReader(file));
			
			String line;
			while ((line = (br.readLine())) != null) {
				if(!line.equals("")) {
					String old = line;
					String[] oldDetails = line.split(",");
					
					for(int i = 0; i < oldDetails.length; i++) {
						System.out.print("olddetails["+i+"] = " + oldDetails[i] + ",");
					}

					
					String[] newDetails = new String[13];
					
					newDetails[0] = oldDetails[0];
					
					
					for(int i = 1; i < 12; i++) {
						newDetails[i] = oldDetails[i + 1];
					}
					
					newDetails[12] = "0";
					
					System.out.println("\n");
					
					for(int i = 0; i < newDetails.length; i++) {
						System.out.print("newdetails["+i+"] = " + newDetails[i] + ",");
					}
					
					String newInfo = String.join(",", newDetails);
					System.out.println("\nnewinfo = " + newInfo);
					newInfo = encryption.encrypt(newInfo);
					
					File fnew = new File(file.getAbsolutePath());
					
					try {
						FileWriter writer = new FileWriter(fnew, false);
						writer.write(newInfo);
						writer.close();
						return;
						
					} catch (IOException e) {
						
					} catch (ArrayIndexOutOfBoundsException e) {
						
					}
					
				}
			}
		}
		
		if(num == 2) {
			BufferedReader br = new BufferedReader(new FileReader(file));
			
			String line;
			while ((line = (br.readLine())) != null) {
				if(!line.equals("")) {
					line = encryption.decrypt(line);
					String[] oldDetails = line.split(",");
					
					for(int i = 0; i < oldDetails.length; i++) {
						System.out.print("olddetails["+i+"] = " + oldDetails[i] + ",");
					}

					
					String[] newDetails = new String[17];
					String[] newerDetails = new String[21];
					
					//Updates to 2.4
					newDetails[0] = oldDetails[0];
					newDetails[1] = oldDetails[1];
					newDetails[2] = oldDetails[8];
					newDetails[3] = oldDetails[2];
					newDetails[4] = oldDetails[3];
					newDetails[5] = oldDetails[9];
					newDetails[6] = oldDetails[10];
					newDetails[7] = "0";
					newDetails[8] = "0";
					newDetails[9] = oldDetails[12];
					newDetails[10] = "0";
					newDetails[11] = "0";
					newDetails[12] = oldDetails[4];
					newDetails[13] = oldDetails[11];
					newDetails[14] = oldDetails[6];
					newDetails[15] = oldDetails[7];
					newDetails[16] = "00000100";
					
					update2to3(newDetails, newerDetails);
					
					System.out.println("\n");
					
					for(int i = 0; i < newerDetails.length; i++) {
						System.out.print("newdetails["+i+"] = " + newerDetails[i] + ",");
					}
					
					String newInfo = String.join(",", newerDetails);
					System.out.println("\nnewinfo = " + newInfo);
					newInfo = encryption.encrypt(newInfo);
					
					File fnew = new File(file.getAbsolutePath());
					
					try {
						FileWriter writer = new FileWriter(fnew, false);
						writer.write(newInfo);
						writer.close();
						return;
						
					} catch (IOException e) {
						
					} catch (ArrayIndexOutOfBoundsException e) {
						
					}
					
				}
			}
		}
		
		if(num == 3) {
			BufferedReader br = new BufferedReader(new FileReader(file));
			
			String line;
			while ((line = (br.readLine())) != null) {
				if(!line.equals("")) {
					line = encryption.decrypt(line);
					String[] oldDetails = line.split(",");
					
					for(int i = 0; i < oldDetails.length; i++) {
						System.out.print("olddetails["+i+"] = " + oldDetails[i] + ",");
					}

					
					String[] newDetails = new String[21];
					
					newDetails[0] = oldDetails[0];
					newDetails[1] = oldDetails[1];
					
					//Apparently there was an unknown date bug in this version
					//New date assigned
					SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
					Date newDate = new Date();
					String newDateString = formatter.format(newDate);
					newDetails[2] = newDateString;
					
					newDetails[3] = "0"; //CONSECUTIVE LOGIN
					newDetails[4] = oldDetails[3];
					newDetails[5] = oldDetails[4];
					newDetails[6] = oldDetails[5];
					newDetails[7] = oldDetails[6];
					newDetails[8] = "0"; //STRIKE COUNT
					newDetails[9] = "0"; //SAME DAY CHECK
					newDetails[10] = oldDetails[8];
					newDetails[11] = oldDetails[9];
					newDetails[12] = oldDetails[10];
					newDetails[13] = oldDetails[11];
					newDetails[14] = "0"; //DIFFICULTY
					newDetails[15] = oldDetails[12];
					newDetails[16] = oldDetails[13];
					newDetails[17] = oldDetails[14];
					newDetails[18] = oldDetails[15];
					newDetails[19] = oldDetails[16]; //ACHIEVEMENT
					newDetails[20] = "-";
					
					System.out.println("\n");
					
					for(int i = 0; i < newDetails.length; i++) {
						System.out.print("newdetails["+i+"] = " + newDetails[i] + ",");
					}
					
					String newInfo = String.join(",", newDetails);
					System.out.println("\nnewinfo = " + newInfo);
					newInfo = encryption.encrypt(newInfo);
					
					File fnew = new File(file.getAbsolutePath());
					
					try {
						FileWriter writer = new FileWriter(fnew, false);
						writer.write(newInfo);
						writer.close();
						return;
						
					} catch (IOException e) {
						
					} catch (ArrayIndexOutOfBoundsException e) {
						
					}
					
				}
			}
		}
		
	}
	
	private void update2to3(String[] oldDetails, String[] newDetails) {
		newDetails[3] = "0"; //CONSECUTIVE LOGIN
		newDetails[4] = oldDetails[3];
		newDetails[5] = oldDetails[4];
		newDetails[6] = oldDetails[5];
		newDetails[7] = oldDetails[6];
		newDetails[8] = "0"; //STRIKE COUNT
		newDetails[9] = "0"; //SAME DAY CHECK
		newDetails[10] = oldDetails[8];
		newDetails[11] = oldDetails[9];
		newDetails[12] = oldDetails[10];
		newDetails[13] = oldDetails[11];
		newDetails[14] = "0"; //DIFFICULTY
		newDetails[15] = oldDetails[12];
		newDetails[16] = oldDetails[13];
		newDetails[17] = oldDetails[14];
		newDetails[18] = oldDetails[15];
		newDetails[19] = oldDetails[16]; //ACHIEVEMENT
		newDetails[20] = "-";
		
	}

	/*
	 * Method hides the main windows and disposes it
	 */
	public void hideWindow() {
		this.setVisible(false);
		this.dispose();
	}
}

