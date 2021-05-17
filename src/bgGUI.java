import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class bgGUI extends JFrame {
	private Profile p;
	
	private JPanel northPanel, centerPanel;
	private JLabel shopImage;
	
	private JPanel bg1Panel, bg2Panel, bg3Panel, bg4Panel, bg5Panel;
	
	private JLabel bg1, bg2, bg3, bg4, bg5;
	private JButton bg1button, bg2button, bg3button, bg4button, bg5button;
	
	private JButton returnToFocus;
	
	public bgGUI() {
		this.p = new Profile();
		
		setUpFrame();
		
		initComponents();
		
		setUpGUI();
		
		this.setSize(1280, 750);
		
	}
	
	public bgGUI(Profile profile) {
		this.p = profile;
		
		setUpFrame();
		
		initComponents();
		
		addActions();
		
		setUpGUI();
		
		this.setSize(1280, 750);
		
	}
	
	public void setUpFrame() {
		ImageIcon logo = new ImageIcon("assets/heart.png");
		
		this.setTitle("Background Shop | TamoTokens: " + p.getMoney());
		this.setSize(1280, 749);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);
		this.setBackground(new Color(255,161,161));
		this.setIconImage(logo.getImage());
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	public void initComponents() {
		//north panel
		northPanel = new JPanel();
		northPanel.setBackground(new Color(255,161,161));
		shopImage = new JLabel(new ImageIcon("assets/shop.png"));
		
		//center panel
		centerPanel = new JPanel();
		centerPanel.setBackground(new Color(255,161,161));
		
		bg1Panel = new JPanel();
		bg1Panel.setBackground(new Color(255,161,161));
		bg2Panel = new JPanel();
		bg2Panel.setBackground(new Color(255,161,161));
		bg3Panel = new JPanel();
		bg3Panel.setBackground(new Color(255,161,161));
		bg4Panel = new JPanel();
		bg4Panel.setBackground(new Color(255,161,161));
		bg5Panel = new JPanel();
		bg5Panel.setBackground(new Color(255,161,161));
		
		bg1 = new JLabel(new ImageIcon("assets/backgrounds/bg.png"));
		bg2 = new JLabel(new ImageIcon("assets/backgrounds/bg2.png"));
		bg3 = new JLabel(new ImageIcon("assets/backgrounds/bg3.png"));
		bg4 = new JLabel(new ImageIcon("assets/backgrounds/bg4.png"));
		bg5 = new JLabel(new ImageIcon("assets/backgrounds/bg5.png"));
		
		bg1button = new JButton("BUY (1000 Tokens)");
		bg2button = new JButton("BUY (1000 Tokens)");
		bg3button = new JButton("BUY (1000 Tokens)");
		bg4button = new JButton("BUY (1000 Tokens)");
		bg5button = new JButton("BUY (5000 Tokens)");
		
		returnToFocus = new JButton("Return to Focus");
	}
	
	public void addActions() {
		returnToFocus.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				GUI Focus = new GUI(p);
				hideWindow();
				
			}
			
		});
		
		
		bg1button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(p.getMoney() - 1000 >= 0) {
					if(JOptionPane.showConfirmDialog(null, "Are you sure?", "Purchase for 1000 Tamo Tokens",
							JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
						p.setCurrentBackground(0);
						p.setMoney(p.getMoney() - 1000);
						
						GUI Focus = new GUI(p);
						hideWindow();
					}
				} else {
					JOptionPane.showMessageDialog(null, "You don't have sufficient funds.", "Can't complete purchase", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("assets/info.png"));
				}
				
			}
			
		});
		
		bg2button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(p.getMoney() - 1000 >= 0) {
					if(JOptionPane.showConfirmDialog(null, "Are you sure?", "Purchase for 1000 Tamo Tokens",
							JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
						p.setCurrentBackground(1);
						p.setMoney(p.getMoney() - 1000);
						
						GUI Focus = new GUI(p);
						hideWindow();
					}
				} else {
					JOptionPane.showMessageDialog(null, "You don't have sufficient funds.", "Can't complete purchase", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("assets/info.png"));
				}
				
			}
			
		});
		
		bg3button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(p.getMoney() - 1000 >= 0) {
					if(JOptionPane.showConfirmDialog(null, "Are you sure?", "Purchase for 1000 Tamo Tokens",
							JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
						p.setCurrentBackground(2);
						p.setMoney(p.getMoney() - 1000);
						
						GUI Focus = new GUI(p);
						hideWindow();
					}
				} else {
					JOptionPane.showMessageDialog(null, "You don't have sufficient funds.", "Can't complete purchase", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("assets/info.png"));
				}
				
			}
			
		});
		
		bg4button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(p.getMoney() - 1000 >= 0) {
					if(JOptionPane.showConfirmDialog(null, "Are you sure?", "Purchase for 1000 Tamo Tokens",
							JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
						p.setCurrentBackground(3);
						p.setMoney(p.getMoney() - 1000);
						
						GUI Focus = new GUI(p);
						hideWindow();
					}
				} else {
					JOptionPane.showMessageDialog(null, "You don't have sufficient funds.", "Can't complete purchase", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("assets/info.png"));
				}
				
			}
			
		});
		
		bg5button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(p.getMoney() - 5000 >= 0) {
					if(JOptionPane.showConfirmDialog(null, "Are you sure?", "Purchase for 5000 Tamo Tokens",
							JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
						p.setCurrentBackground(4);
						p.setMoney(p.getMoney() - 5000);
						
						GUI Focus = new GUI(p);
						hideWindow();
					}
				} else {
					JOptionPane.showMessageDialog(null, "You don't have sufficient funds.", "Can't complete purchase", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("assets/info.png"));
				}
				
			}
			
		});
	}
	
	public void setUpGUI() {
		this.setLayout(new GridLayout(2,1));
		
		this.add(northPanel);
		northPanel.add(shopImage);
		northPanel.add(returnToFocus);
		
		this.add(centerPanel);
		centerPanel.setLayout(new GridLayout(1,5));
		
		centerPanel.add(bg1Panel);
		bg1Panel.add(bg1);
		bg1Panel.add(bg1button);
		
		centerPanel.add(bg2Panel);
		bg2Panel.add(bg2);
		bg2Panel.add(bg2button);
		
		centerPanel.add(bg3Panel);
		bg3Panel.add(bg3);
		bg3Panel.add(bg3button);
		
		centerPanel.add(bg4Panel);
		bg4Panel.add(bg4);
		bg4Panel.add(bg4button);
		
		centerPanel.add(bg5Panel);
		bg5Panel.add(bg5);
		bg5Panel.add(bg5button);
		
	}
	
	public void hideWindow() {
		this.setVisible(false);
		this.dispose();
	}
}
