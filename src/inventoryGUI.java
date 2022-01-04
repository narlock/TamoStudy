/**
 * @author Anthony Narlock
 * @desc inventoryGUI stores a user's inventory of the purchases inside of the
 * application that they have made
 */

import javax.swing.*;

import profile.Item;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

public class inventoryGUI extends JFrame {
	
	/*
	 * Components of inventoryGUI
	 * Initialized based off of location on the screen
	 */
	private Profile p;
	private File file;
	private GridBagConstraints gbc = new GridBagConstraints();
	private ArrayList<Item> items;
	
	//North Panel Components
	private JPanel northPanel;
	private JButton returnToFocus;
	
	//Center Panel Components
	private JPanel centerPanel;
	
	//South Panel Components
	private JPanel southPanel;
	
	
	public inventoryGUI(Profile profile, File profileFile) {
		this.p = profile;
		this.file = profileFile;
		this.items = profile.getInv().getItemList();
		
		setUpFrame();
		
		initComponents();
		
		setUpGUI();
		
		this.setSize(550, 600);
	}
	
	/*
	 *  Sets up frame information, size, etc.
	 */
	public void setUpFrame() {
		ImageIcon logo = new ImageIcon(getClass().getClassLoader().getResource("ico.png"));
		
		this.setTitle("Inventory - TamoStudy");
		this.setSize(550,599);
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
		northPanel = new JPanel();
		centerPanel = new JPanel();
		southPanel = new JPanel();
		
		initNorthComponents();
		initCenterComponents();
		initSouthComponents();
	}
	
	public void initNorthComponents() {
		returnToFocus = new JButton(p.getSettings().getLang().getText(23));
		initButtonVisual(returnToFocus);
		returnToFocus.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				GUI Focus = new GUI(p,file);
				hideWindow();
			}
			
		});
	}
	
	public void initCenterComponents() {
		
	}
	
	public void initSouthComponents() {
		
	}
	
	/*
	 * Sets up the GUI, layout, etc.
	 */
	public void setUpGUI() {
		northPanel.add(returnToFocus);
		
		this.add(northPanel, BorderLayout.NORTH);
		
	}
	
	public void initButtonVisual(JButton button) {
		if(System.getProperty("os.name").startsWith("Windows")) {
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
	}
	
	/*
	 * Method hides the main windows and disposes it
	 */
	public void hideWindow() {
		this.setVisible(false);
		this.dispose();
	}
	
}
