import javax.swing.*;

import guicomponents.ahmPanel;
import static javax.swing.ScrollPaneConstants.*;
import java.awt.*;
import java.io.*;

/**
 * Achivement GUI
 * @author antho
 * 
 * This is the graphical user interface for the achievements page
 *
 */

public class ahmGUI extends JOptionPane {
	
	private Profile profile;
	private File file;
	
	private JButton returnToFocus;
	
	private JPanel guiPanel;
	private JPanel achievementPanel;
	private JScrollPane scrollPane;
	
	private ahmPanel achievementPanels[];
	
	public ahmGUI(Profile profile, File file) {
		this.profile = profile;
		this.file = file;
		
		this.achievementPanels = new ahmPanel[8];
		setAchievementPanels();
		
		setUpFrame();
		
		initComponents();
		
		initComponentActions();
		
		setUpGUI();
		
		this.setSize(480, 640);
	}
	
	public void setUpFrame() {
		ImageIcon logo = new ImageIcon(getClass().getClassLoader().getResource("ico.png"));
		
		UIManager UI = new UIManager();
		UI.put("OptionPane.background", profile.getColor());
		UI.put("Panel.background", profile.getColor());
		
		//this.setTitle(profile.getUsername() + "'s Achievements");
		this.setSize(481,640);
		//this.setLocationRelativeTo(null);
		//this.setResizable(true);
		this.setVisible(true);
		//this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		//this.setIconImage(logo.getImage());
	}
	
	public void setAchievementPanels() {
		System.out.println("ahmString = " + profile.getAhm().getAhmString());
		for(int i = 0; i < achievementPanels.length; i++) {
			achievementPanels[i] = new ahmPanel(i, profile.getAhm().getIndicator(i), profile.getSettings().getLang().getIndicator());
			System.out.println("Achievement Panel " + i + " " + achievementPanels[i].toString());
			System.out.println("Achievement Indicator for " + i + " = " + profile.getAhm().getIndicator(i));
		}
		
	}
	
	public void initComponents() {
		guiPanel = new JPanel();
		guiPanel.setBackground(profile.getColor());
		guiPanel.setSize(550,720);
		
		scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(HORIZONTAL_SCROLLBAR_NEVER);
		
		achievementPanel = new JPanel();
		achievementPanel.setBackground(profile.getColor());
		achievementPanel.setLayout(new GridLayout(4,2));
		returnToFocus = new JButton(profile.getSettings().getLang().get(56));
		initButton(returnToFocus);
		
	}
	
	public void initComponentActions() {
		
	}
	
	public void setUpGUI() {
		scrollPane.setViewportView(achievementPanel);
		
		System.out.println("achievementPanels length = " + achievementPanels.length);
		guiPanel.add(scrollPane, BorderLayout.CENTER);
		
		for(int i = 0; i < achievementPanels.length; i++) {
			achievementPanel.add(achievementPanels[i]);
		}
		
		//guiPanel.add(returnToFocus, BorderLayout.SOUTH);
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
	
	
	public void showConfirmDialog() {
		JOptionPane.showMessageDialog(null, achievementPanel, profile.getSettings().getLang().get(10) + ": " + profile.getUsername() , JOptionPane.PLAIN_MESSAGE);
	}
}
