/**
 * @description GUI Class of TamoStudy
 * @author Anthony Narlock
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUI extends JFrame {
	
	//Component Declaration
	private JPanel topPanel, centerPanel, botPanel;
	private JButton studyButton, endStudyButton;

	public GUI() {
		
		setUpFrame();
		
		initVariables();
		
		createAspects();
		
		setUpGUI();
		
		this.setSize(1280, 720);
		
	}
	
	public void setUpFrame() {
		//Sets up the GUI's frame
		this.setTitle("TamoStudy (version: 0.1)");
		this.setSize(1280,720);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void initVariables() {
		
	}

	public void createAspects() {
		
	}
	
	public void setUpGUI() {
		
	}

}
