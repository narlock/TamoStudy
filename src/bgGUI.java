import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.*;

public class bgGUI extends JFrame {
	private Profile p;
	private File file;
	
	private JPanel northPanel, centerPanel;
	private JPanel mainPanel;
	private JLabel shopImage;
	
	private JPanel changeColorPanel, changeColorNorth, changeColorSouth;
	private JLabel localBackgroundLabel;
	private JButton redButton, blueButton, greenButton, yellowButton, purpleButton, orangeButton, greyButton;
	
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
	
	public bgGUI(Profile profile, File file) {
		this.p = profile;
		this.file = file;
		
		setUpFrame();
		
		initComponents();
		
		addActions();
		
		setUpGUI();
		
		this.setSize(1280, 750);
	}
	
	public void setUpFrame() {
		ImageIcon logo = new ImageIcon(getClass().getClassLoader().getResource("ico.png"));
		
		this.setTitle(p.getSettings().getLang().getText(7) + " | TamoTokens: " + p.getMoney());
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
		northPanel.setBackground(p.getColor());
		
		mainPanel = new JPanel();
		mainPanel.setBackground(p.getColor());
		returnToFocus = new JButton(p.getSettings().getLang().getText(23));
		shopImage = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("shop.png")));
		
		//Change background Panel
		changeColorPanel = new JPanel();
		changeColorPanel.setBackground(p.getColor());
		changeColorNorth = new JPanel();
		changeColorNorth.setBackground(p.getColor());
		changeColorSouth = new JPanel();
		changeColorSouth.setBackground(p.getColor());

		localBackgroundLabel = new JLabel("Change Background Color (500 TamoTokens)");
		redButton = new JButton(new ImageIcon(getClass().getClassLoader().getResource("color-default.png")));
		blueButton = new JButton(new ImageIcon(getClass().getClassLoader().getResource("color-blue.png")));
		greenButton = new JButton(new ImageIcon(getClass().getClassLoader().getResource("color-green.png")));
		yellowButton = new JButton(new ImageIcon(getClass().getClassLoader().getResource("color-yellow.png")));
		purpleButton = new JButton(new ImageIcon(getClass().getClassLoader().getResource("color-purple.png")));
		orangeButton = new JButton(new ImageIcon(getClass().getClassLoader().getResource("color-orange.png")));
		greyButton = new JButton(new ImageIcon(getClass().getClassLoader().getResource("color-grey.png")));
		
		
		//center panel
		centerPanel = new JPanel();
		centerPanel.setBackground(p.getColor());
		
		bg1Panel = new JPanel();
		bg1Panel.setBackground(p.getColor());
		bg2Panel = new JPanel();
		bg2Panel.setBackground(p.getColor());
		bg3Panel = new JPanel();
		bg3Panel.setBackground(p.getColor());
		bg4Panel = new JPanel();
		bg4Panel.setBackground(p.getColor());
		bg5Panel = new JPanel();
		bg5Panel.setBackground(p.getColor());
		
		bg1 = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("bg.png")));
		bg2 = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("bg2.png")));
		bg3 = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("bg3.png")));
		bg4 = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("bg4.png")));
		bg5 = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("bg5.png")));
		
		bg1button = new JButton(p.getSettings().getLang().getText(28) + " 1000 Tokens");
		bg2button = new JButton(p.getSettings().getLang().getText(28) + " 1000 Tokens");
		bg3button = new JButton(p.getSettings().getLang().getText(28) + " 1000 Tokens");
		bg4button = new JButton(p.getSettings().getLang().getText(28) + " 1000 Tokens");
		bg5button = new JButton(p.getSettings().getLang().getText(28) + " 5000 Tokens");
	
		
	}
	
	public void addActions() {
		returnToFocus.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				GUI Focus = new GUI(p,file);
				hideWindow();
				
			}
			
		});
		
		
		bg1button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(p.getMoney() - 1000 >= 0) {
					if(JOptionPane.showConfirmDialog(null, p.getSettings().getLang().getText(39), p.getSettings().getLang().getText(28) + " 1000 " + p.getSettings().getLang().getText(29),
							JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
						p.setCurrentBackground(0);
						p.setMoney(p.getMoney() - 1000);
						
						p.getAhm().setIndicator(4,1);
						
						GUI Focus = new GUI(p,file);
						hideWindow();
					}
				} else {
					JOptionPane.showMessageDialog(null, p.getSettings().getLang().getText(25), p.getSettings().getLang().getText(24), JOptionPane.INFORMATION_MESSAGE, new ImageIcon(getClass().getClassLoader().getResource("info.png")));
				}
				
			}
			
		});
		
		bg2button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(p.getMoney() - 1000 >= 0) {
					if(JOptionPane.showConfirmDialog(null, p.getSettings().getLang().getText(39), p.getSettings().getLang().getText(28) + " 1000 " + p.getSettings().getLang().getText(29),
							JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
						p.setCurrentBackground(1);
						p.setMoney(p.getMoney() - 1000);
						
						p.getAhm().setIndicator(4,1);
						
						GUI Focus = new GUI(p,file);
						hideWindow();
					}
				} else {
					JOptionPane.showMessageDialog(null, p.getSettings().getLang().getText(25), p.getSettings().getLang().getText(24), JOptionPane.INFORMATION_MESSAGE, new ImageIcon(getClass().getClassLoader().getResource("info.png")));
				}
				
			}
			
		});
		
		bg3button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(p.getMoney() - 1000 >= 0) {
					if(JOptionPane.showConfirmDialog(null, p.getSettings().getLang().getText(39), p.getSettings().getLang().getText(28) + " 1000 " + p.getSettings().getLang().getText(29),
							JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
						p.setCurrentBackground(2);
						p.setMoney(p.getMoney() - 1000);
						
						p.getAhm().setIndicator(4,1);
						
						GUI Focus = new GUI(p,file);
						hideWindow();
					}
				} else {
					JOptionPane.showMessageDialog(null, p.getSettings().getLang().getText(25), p.getSettings().getLang().getText(24), JOptionPane.INFORMATION_MESSAGE, new ImageIcon(getClass().getClassLoader().getResource("info.png")));
				}
				
			}
			
		});
		
		bg4button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(p.getMoney() - 1000 >= 0) {
					if(JOptionPane.showConfirmDialog(null, p.getSettings().getLang().getText(39), p.getSettings().getLang().getText(28) + " 1000 " + p.getSettings().getLang().getText(29),
							JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
						p.setCurrentBackground(3);
						p.setMoney(p.getMoney() - 1000);
						
						p.getAhm().setIndicator(4,1);
						
						GUI Focus = new GUI(p,file);
						hideWindow();
					}
				} else {
					JOptionPane.showMessageDialog(null, p.getSettings().getLang().getText(25), p.getSettings().getLang().getText(24), JOptionPane.INFORMATION_MESSAGE, new ImageIcon(getClass().getClassLoader().getResource("info.png")));
				}
				
			}
			
		});
		
		bg5button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(p.getMoney() - 5000 >= 0) {
					if(JOptionPane.showConfirmDialog(null, p.getSettings().getLang().getText(39), p.getSettings().getLang().getText(28) + " 5000 " + p.getSettings().getLang().getText(29),
							JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
						p.setCurrentBackground(4);
						p.setMoney(p.getMoney() - 5000);
						
						p.getAhm().setIndicator(4,1);
						
						GUI Focus = new GUI(p,file);
						hideWindow();
					}
				} else {
					JOptionPane.showMessageDialog(null, p.getSettings().getLang().getText(25), p.getSettings().getLang().getText(24), JOptionPane.INFORMATION_MESSAGE, new ImageIcon(getClass().getClassLoader().getResource("info.png")));
				}
				
			}
			
		});
		
		
		addGuiColorActions();
	}
	

	public void setUpGUI() {
		this.setLayout(new GridLayout(2,1));
		//JPanel changeColorNorth, changeColorSouth;
		// JLabel localBackgroundLabel;
		this.add(northPanel);
		northPanel.setLayout(new GridLayout(1,2));
		northPanel.add(mainPanel);
		northPanel.add(changeColorPanel);
		
		mainPanel.add(returnToFocus);
		mainPanel.add(shopImage);
		
		changeColorPanel.setLayout(new BorderLayout());
		changeColorPanel.add(changeColorNorth, BorderLayout.NORTH);
		changeColorPanel.add(changeColorSouth, BorderLayout.CENTER);
		
		changeColorNorth.add(localBackgroundLabel);
		
		changeColorSouth.add(redButton);
		changeColorSouth.add(blueButton);
		changeColorSouth.add(greenButton);
		changeColorSouth.add(orangeButton);
		changeColorSouth.add(purpleButton);
		changeColorSouth.add(yellowButton);
		changeColorSouth.add(greyButton);
		
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
	
	public void addGuiColorActions() {
		redButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(p.getMoney() - 500 >= 0) {
					if(JOptionPane.showConfirmDialog(null, p.getSettings().getLang().getText(39), p.getSettings().getLang().getText(28) + " 500 " + p.getSettings().getLang().getText(29),
							JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
						p.setGuiColor("default");
						p.setMoney(p.getMoney() - 500);
						
						p.getAhm().setIndicator(3,1);
						
						GUI Focus = new GUI(p,file);
						hideWindow();
					}
				} else {
					JOptionPane.showMessageDialog(null, p.getSettings().getLang().getText(25), p.getSettings().getLang().getText(24), JOptionPane.INFORMATION_MESSAGE, new ImageIcon(getClass().getClassLoader().getResource("info.png")));
				}
				
			}
			
		});
		
		
		blueButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(p.getMoney() - 500 >= 0) {
					if(JOptionPane.showConfirmDialog(null, p.getSettings().getLang().getText(39), p.getSettings().getLang().getText(28) + " 500 " + p.getSettings().getLang().getText(29),
							JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
						p.setGuiColor("blue");
						p.setMoney(p.getMoney() - 500);
						
						p.getAhm().setIndicator(3,1);
						
						GUI Focus = new GUI(p,file);
						hideWindow();
					}
				} else {
					JOptionPane.showMessageDialog(null, p.getSettings().getLang().getText(25), p.getSettings().getLang().getText(24), JOptionPane.INFORMATION_MESSAGE, new ImageIcon(getClass().getClassLoader().getResource("info.png")));
				}
				
			}
			
		});
		
		greenButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(p.getMoney() - 500 >= 0) {
					if(JOptionPane.showConfirmDialog(null, p.getSettings().getLang().getText(39), p.getSettings().getLang().getText(28) + " 500 " + p.getSettings().getLang().getText(29),
							JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
						p.setGuiColor("green");
						p.setMoney(p.getMoney() - 500);
						
						p.getAhm().setIndicator(3,1);
						
						GUI Focus = new GUI(p,file);
						hideWindow();
					}
				} else {
					JOptionPane.showMessageDialog(null, p.getSettings().getLang().getText(25), p.getSettings().getLang().getText(24), JOptionPane.INFORMATION_MESSAGE, new ImageIcon(getClass().getClassLoader().getResource("info.png")));
				}
				
			}
			
		});
		
		orangeButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(p.getMoney() - 500 >= 0) {
					if(JOptionPane.showConfirmDialog(null, p.getSettings().getLang().getText(39), p.getSettings().getLang().getText(28) + " 500 " + p.getSettings().getLang().getText(29),
							JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
						p.setGuiColor("orange");
						p.setMoney(p.getMoney() - 500);
						
						p.getAhm().setIndicator(3,1);
						
						GUI Focus = new GUI(p,file);
						hideWindow();
					}
				} else {
					JOptionPane.showMessageDialog(null, p.getSettings().getLang().getText(25), p.getSettings().getLang().getText(24), JOptionPane.INFORMATION_MESSAGE, new ImageIcon(getClass().getClassLoader().getResource("info.png")));
				}
				
			}
			
		});
		
		purpleButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(p.getMoney() - 500 >= 0) {
					if(JOptionPane.showConfirmDialog(null, p.getSettings().getLang().getText(39), p.getSettings().getLang().getText(28) + " 500 " + p.getSettings().getLang().getText(29),
							JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
						p.setGuiColor("purple");
						p.setMoney(p.getMoney() - 500);
						
						p.getAhm().setIndicator(3,1);
						
						GUI Focus = new GUI(p,file);
						hideWindow();
					}
				} else {
					JOptionPane.showMessageDialog(null, p.getSettings().getLang().getText(25), p.getSettings().getLang().getText(24), JOptionPane.INFORMATION_MESSAGE, new ImageIcon(getClass().getClassLoader().getResource("info.png")));
				}
				
			}
			
		});
		
		yellowButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(p.getMoney() - 500 >= 0) {
					if(JOptionPane.showConfirmDialog(null, p.getSettings().getLang().getText(39), p.getSettings().getLang().getText(28) + " 500 " + p.getSettings().getLang().getText(29),
							JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
						p.setGuiColor("yellow");
						p.setMoney(p.getMoney() - 500);
						
						p.getAhm().setIndicator(3,1);
						
						GUI Focus = new GUI(p,file);
						hideWindow();
					}
				} else {
					JOptionPane.showMessageDialog(null, p.getSettings().getLang().getText(25), p.getSettings().getLang().getText(24), JOptionPane.INFORMATION_MESSAGE, new ImageIcon(getClass().getClassLoader().getResource("info.png")));
				}
				
			}
			
		});
		
		greyButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(p.getMoney() - 500 >= 0) {
					if(JOptionPane.showConfirmDialog(null, p.getSettings().getLang().getText(39), p.getSettings().getLang().getText(28) + " 500 " + p.getSettings().getLang().getText(29),
							JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
						p.setGuiColor("grey");
						p.setMoney(p.getMoney() - 500);
						
						p.getAhm().setIndicator(3,1);
						
						GUI Focus = new GUI(p,file);
						hideWindow();
					}
				} else {
					JOptionPane.showMessageDialog(null, p.getSettings().getLang().getText(25), p.getSettings().getLang().getText(24), JOptionPane.INFORMATION_MESSAGE, new ImageIcon(getClass().getClassLoader().getResource("info.png")));
				}
				
			}
			
		});
		
	}
	
}
