/**
 * @author Anthony Narlock
 * @desc inventoryGUI stores a user's inventory of the purchases inside of the
 * application that they have made
 */

import javax.swing.*;

import guicomponents.invItemPanel;
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
	private invItemPanel[] itemPanels;
	
	//North Panel Components
	private JPanel northPanel;
	private JButton returnToFocus;
	
	//Center Panel Components
	private JPanel centerPanel, itemPanelMain;
	private final JLabel NO_ITEMS = new JLabel("Inventory Empty");
	
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
		itemPanelMain = new JPanel();
		initItemPanel();
	}
	
	public void initSouthComponents() {
		
	}
	
	public void initItemPanel() {
		itemPanels = new invItemPanel[items.size()];
		
		if(p.getInv().getInvString().equals("-1")) {
			itemPanelMain.add(NO_ITEMS);
		} else {
			itemPanelMain.setLayout(new GridLayout(3,2));
			
			for(int i = 0; i < items.size(); i++) {
				itemPanels[i] = new invItemPanel(items.get(i).getIndicator());
				initButtonActions(itemPanels[i]);
				itemPanelMain.add(itemPanels[i]);
			}
		}
	}
	
	public void initButtonActions(invItemPanel item) {
		//If the item is a background, add the background
		if(item.getId() <= 6) {
			item.getButton().addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					int resultPane = JOptionPane.showConfirmDialog(null, "Are you sure?","Apply " + item.getItemTitle() + "?",
							JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, new ImageIcon(getClass().getClassLoader().getResource("info.png")));
					if(resultPane == JOptionPane.OK_OPTION) {
						
					}
				}
				
			});
		} else {
			item.getButton().addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					
				}
				
			});
		}
				
	//TODO If the item is already being used, disable the button
	}
	
	/*
	 * Sets up the GUI, layout, etc.
	 */
	public void setUpGUI() {
		northPanel.add(returnToFocus);
		
		centerPanel.add(itemPanelMain);
		
		this.add(northPanel, BorderLayout.NORTH);
		this.add(centerPanel, BorderLayout.CENTER);
		
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
