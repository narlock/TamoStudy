
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.*;

public class debugGUI extends JFrame {
	private JLabel[] labels = {
			new JLabel("Username"),
			new JLabel("Join Date"),
			new JLabel("Last Login"),
			new JLabel("Total Seconds"),
			new JLabel("Money"),
			new JLabel("Current BG int"),
			new JLabel("GUIcolor"),
			new JLabel("Tamo name"),
			new JLabel("Tamo ID"),
			new JLabel("Tamo Happiness"),
			new JLabel("Tamo Hunger"),
			new JLabel("ahm String"),
	};
	
	private JTextField userField, joinDate, lastLogin, seconds, money, bgInt, guiColor, tamoName, tamoHap, tamoHun, ahmString;
	private JButton saveChanges;
	
	private Profile p;
	private File file;
	private Encryption encryption;
	
	public debugGUI(Profile profile, File file) {
		this.p = profile;
		this.file = file;
		
		setUpFrame();
		
		initComponents();
		
		setUpGUI();
		
		this.setSize(500,500);
	}
	
	public void setUpFrame() { 
		this.setTitle("DEBUG MENU");
		this.setSize(499,500);
		this.setLocationRelativeTo(null);
		this.setResizable(true);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void initComponents() {
		userField = new JTextField(10);
		joinDate = new JTextField(10);
		lastLogin = new JTextField(10);
		seconds = new JTextField(10);
		money = new JTextField(10);
		bgInt = new JTextField(10);
		guiColor = new JTextField(10);
		tamoName = new JTextField(10);
		tamoHap = new JTextField(10);
		tamoHun = new JTextField(10);
		ahmString = new JTextField(10);
		
		saveChanges = new JButton("Save Changes");
	}
	
	public void initActions() {
		saveChanges.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				updateUserInformationToFile();
				GUI gui = new GUI(p, file);
				hideWindow();
			}
			
		});
	}
	
	public void setUpGUI() {
		
	}
	
	public void hideWindow() {
		this.setVisible(false);
		this.dispose();
	}
	
	/*
	 * Updates the profile that is in use to the profiles text file
	 * 
	 * HOW: Rewrites the changeable values to the file.
	 * This includes: totalTime, totalMoney, tamoLevel, tamoHappiness, tamoHunger.
	 * 
	 * This is for local purposes, assuming that the user does not have a lot of locally stored profiles.
	 * In the future, their may be a profile limit?
	 * 
	 * But eventually when added to a database, this method of updating system information will not be used to
	 * rewrite the locally stored profile to the database. (because it would be inefficient then)
	 */
	private void updateUserInformationToFile() {
		try {
			//BufferedReader file = new BufferedReader(new FileReader("profiles.txt"));
			BufferedReader file = new BufferedReader(new FileReader(file));
			StringBuffer inputBuffer = new StringBuffer();
			String line;
			
			while((line = (file.readLine())) != null) {
				inputBuffer.append(line);
			}
			
			file.close();
			String inputStr = inputBuffer.toString();
			String decryptedString = encryption.decrypt(inputStr);
			
			//System.out.println(inputStr); //DEBUG TO DISPLAY ORIGINAL FILE
			
			//split the string, by comma so username can be identified
			String[] inputtedString = decryptedString.split(",");
			
			
			//I didn't know where to put the code to update the level, so it's here:
			//Every 24 hours, your tamo will gain 1 level
			int new_level = (profile.getTotalTime() / 86400);
			profile.getTamo().setLevel(new_level);
			
			/*
			 * Rewriting Profile Information
			 */
			
			//Update login date
			//System.out.println("DEBUG: Rewriting newloginString");
			if(profile.getNewLoginString() == null) {
				
			} else {
			inputtedString[2] = profile.getNewLoginString();
			}
			
			//Rewrite TotalTime
			//System.out.println("DEBUG: Rewriting Total Time = " + profile.getTotalTime());
			inputtedString[3] = String.valueOf(profile.getTotalTime());
			
			//Rewrite TotalMoney
			//System.out.println("DEBUG: Rewriting Total Money = " + profile.getMoney());
			inputtedString[4] = String.valueOf(profile.getMoney());
			
			//Rewrite currentbackground
			//System.out.println("DEBUG: Rewriting current bg");
			inputtedString[5] = String.valueOf(profile.getCurrentBackground());
			
			//System.out.println("DEBUG: Rewriting guiColor");
			inputtedString[6] = profile.getGuiColor();
			
			/*
			 * Rewriting Profile Settings
			 */
			
			inputtedString[8] = String.valueOf(profile.getSettings().getFocusMode());
			inputtedString[9] = String.valueOf(profile.getSettings().getLang().getIndicator());
			inputtedString[10] = String.valueOf(profile.getSettings().getSessionSounds());
			inputtedString[11] = String.valueOf(profile.getSettings().getBackgroundSounds());
			
			/*
			 * Rewriting Tamo Information
			 */
			
			//Rewrite Tamo Name
			//System.out.println("DEBUG: Rewriting name = " + profile.getTamo().getName());
			inputtedString[12] = profile.getTamo().getName();
			
			//System.out.println("DEBUG: Rewriting tamo ID");
			inputtedString[13] = String.valueOf(profile.getTamo().getId());
			
			//System.out.println("DEBUG: Rewriting Happiness = " + profile.getTamo().getHappiness());
			inputtedString[14] = String.valueOf(profile.getTamo().getHappiness());
			
			//System.out.println("DEBUG: Rewriting Hunger to = " + profile.getTamo().getHunger());
			inputtedString[15] = String.valueOf(profile.getTamo().getHunger());
			
			/*
			 * Rewriting Achievement String
			 */
			
			inputtedString[16] = profile.getAhm().getAhmString();
			
			//join the string back together
			decryptedString = String.join(",", inputtedString);
			//System.out.println("after rewrite: " + inputStr); //DEBUG TO DISPLAY WRITTEN FILE
			
			String encryptedStr = encryption.encrypt(decryptedString);
			
			//FileOutputStream fileOut = new FileOutputStream("profiles.txt");
			FileOutputStream fileOut = new FileOutputStream(file);
			fileOut.write(encryptedStr.getBytes());
			fileOut.close();
			
			
			}
		catch (Exception e) {
			System.out.println("Updating user information failed due to exception." + e);
			}
		}
	
}
