import java.awt.Color;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import resources.BubbleBorder;

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
	private JButton newProfileButton, loadProfileButton, profileUpdateButton;
	
	private JLabel authorLabel;
	
	private final Color mainColor = new Color(78,78,78);
	private final Font fontBoldReg = new Font("Arial", Font.BOLD, 24);
	
	/**
	 * WelcomeGUI
	 * The Frame that will log the user in to TamoStudy
	 */
	public WelcomeGUI() {
		initFrame();
		initComponentsToFrame();
		this.setSize(650,500);
	}
	
	public void initFrame() {
		this.setBackground(mainColor);
		this.setTitle("launcher • TamoStudy Beta v4.0");
		this.setVisible(true);
		this.setSize(650,499);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setIconImage(new ImageIcon(getClass().getClassLoader().getResource("ICON.png")).getImage());
	}
	
	public void initComponentsToFrame() {
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
		profileUpdateButton = new JButton("Update Profile");
			setUpJButton(profileUpdateButton);
		buttonPanel.add(newProfileButton);
		buttonPanel.add(loadProfileButton);
		buttonPanel.add(profileUpdateButton);
		
		authorLabel = new JLabel("Created by Anthony Narlock • anthonynarlock.com");
			authorLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
			authorLabel.setForeground(new Color(153,153,153));
			authorLabel.setAlignmentX(JComponent.CENTER_ALIGNMENT);
		
		mainPanel.add(createSpaceLabel());
		mainPanel.add(titleCardImageLabel);
		mainPanel.add(createSpaceLabel());
		mainPanel.add(buttonPanel);
		mainPanel.add(authorLabel);
		mainPanel.add(createSpaceLabel());
		
		this.add(mainPanel);
	}
	
	public void setUpJButton(JButton button) {
		button.setFont(fontBoldReg);
		button.setBackground(Color.WHITE);
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
}
