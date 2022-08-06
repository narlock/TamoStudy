package panels;

import java.awt.Font;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GuidePanel extends JPanel {
	private JLabel highLevelOverviewLabel;
	private JLabel fileOptionsHeaderLabel;
	private JLabel fileOptionsLabel;
	private JLabel customizeOptionsHeaderLabel;
	private JLabel customizeOptionsLabel;
	private JLabel creditsLabel;
	
	public GuidePanel() {
		initPanel();
		initComponents();
		setUpGUI();
	}

	private void initPanel() {
		this.setVisible(true);
		this.setSize(400,300);
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
	}
	
	private void initComponents() {
		highLevelOverviewLabel = new JLabel("<html>TamoStudyStream "
				+ "is an application that builds upon TamoStudy's "
				+ "timer.<br>The purpose of this application is to "
				+ "give a customizable timer that streamers can "
				+ "utilize during live streams.</html>");
		fileOptionsHeaderLabel = new JLabel("File Options");
		fileOptionsLabel = new JLabel("<html><ul>" +
		        "<li>Link TamoStudy Profile: allows user to link with TamoStudy profile - all focused time will be awarded with Tamo Tokens.</li>" +             
		        "<li>View Current Settings: Displays the current settings of TamoStudyStream.</li>" + 
		        "<li>Import Settings: Allows the user to import a TamoStudyStream 'settings.json' file to change settings.</li>" + 
		        "<li>Export Settings: Allows the user to export their TamoStudyStream settings.</li>" + 
		        "<li>Reset Settings: Allows the user to reset their settings to the default TamoStudyStream settings.</li>" + 
				"</ul><html>");
		customizeOptionsHeaderLabel = new JLabel("Customize Options");
		customizeOptionsLabel = new JLabel("<html><ul>" +
		        "<li>Sound Options: Allows the user to change the ending sound of the timer.</li>" +             
		        "<li>Timer Appearance Settings: Allows the user to customize the timer.</li>" + 
		        "<li>Clock Apperance Settings: Allows the user to enable and customize the clock.</li>" + 
		        "<li>Timer Options: Allows the user to change the timer options.</li>" + 
				"</ul><html>");
		creditsLabel = new JLabel("Created by narlock • tamostudy.com");
		creditsLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
	}
	
	private void setUpGUI() {
		this.add(highLevelOverviewLabel);
		this.add(Box.createVerticalStrut(10));
		this.add(fileOptionsHeaderLabel);
		this.add(fileOptionsLabel);
		this.add(customizeOptionsHeaderLabel);
		this.add(customizeOptionsLabel);
		this.add(Box.createVerticalStrut(10));
		this.add(creditsLabel);
	}

	public void showMessageDialog(JComponent rootPane) {
		JOptionPane.showConfirmDialog(
				rootPane, 
				this, 
				"TamoStudyStream - Guide", 
				JOptionPane.PLAIN_MESSAGE,
				1, new ImageIcon(getClass().getClassLoader().getResource("INFO.png"))
			);
	}
}
