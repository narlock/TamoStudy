/**
 * @author Anthony Narlock
 * @desc inventoryGUI stores a user's inventory of the purchases inside of the
 * application that they have made
 */

import javax.swing.*;
import java.awt.*;
import java.io.*;

public class inventoryGUI extends JFrame {
	
	/*
	 * Components of inventoryGUI
	 * Initialized based off of location on the screen
	 */
	private Profile p;
	private File file;
	private GridBagConstraints gbc = new GridBagConstraints();
	
	//North Panel Components
	private JPanel northPanel;
	
	//Center Panel Components
	private JPanel centerPanel;
	
	//South Panel Components
	private JPanel southPanel;
	
	
	public inventoryGUI(Profile profile, File profileFile) {
		this.p = profile;
		this.file = profileFile;
		
		setUpFrame();
		
		initComponents();
		
		setUpGUI();
		
		this.setSize(550, 720);
	}
	
	/*
	 *  Sets up frame information, size, etc.
	 */
	public void setUpFrame() {
		ImageIcon logo = new ImageIcon(getClass().getClassLoader().getResource("ico.png"));
		
		this.setTitle("Inventory - TamoStudy");
		this.setSize(550,719);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);
		this.setBackground(p.getColorDark());
		this.setIconImage(logo.getImage());
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	/*
	 * Initializes GUI components, including action listeners
	 */
	public void initComponents() {
		initNorthComponents();
		initCenterComponents();
		initSouthComponents();
	}
	
	public void initNorthComponents() {
		
	}
	
	public void initCenterComponents() {
		
	}
	
	public void initSouthComponents() {
		
	}
	
	/*
	 * Sets up the GUI, layout, etc.
	 */
	public void setUpGUI() {
		
	}
	
	/*
	 * Method hides the main windows and disposes it
	 */
	public void hideWindow() {
		this.setVisible(false);
		this.dispose();
	}
	
}
