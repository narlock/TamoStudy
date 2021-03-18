import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.io.IOException;

//this tests code to put an imageIcon label on top of another imageIcon label

public class testGUI2 extends JFrame {
	
	private JPanel testPanel, buttonPanel;
	private JLabel imageLabel, backgroundImageLabel;
	
	private JButton changeButton;
	private GridBagConstraints gbc = new GridBagConstraints();
	
	public testGUI2() {
		setUpFrame();
		
		initComponents();
		
		setUpGUI();
		
		this.setSize(600,500);
	}
	
	public void setUpFrame() {
		this.setTitle("Test GUI");
		this.setSize(600, 499);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void initComponents() {
		this.gbc.gridx = 0;
		this.gbc.gridy = 0;
		
		testPanel = new JPanel();
		buttonPanel = new JPanel();
		
		
		imageLabel = new JLabel(new ImageIcon("assets/tama_test4.png"));
		backgroundImageLabel = new JLabel(new ImageIcon("assets/bg4.png"));
		
		backgroundImageLabel.setLayout(new GridBagLayout());
		
		imageLabel.setSize(imageLabel.getPreferredSize());
		//imageLabel.setLocation();
		
		backgroundImageLabel.add(imageLabel, gbc);
		
		changeButton = new JButton("Change icon");
		changeButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				changeImage();
				
			}
			
		});
		
		
	}
	
	public void setUpGUI() {
		testPanel.add(backgroundImageLabel);
		buttonPanel.add(changeButton);
		
		this.getContentPane().add(testPanel, BorderLayout.CENTER);
		this.getContentPane().add(buttonPanel, BorderLayout.SOUTH);
		
		//this.add(backgroundImageLabel);
		
	}
	
	public void changeImage() {
		System.out.println("reaching method");
		this.imageLabel = new JLabel(new ImageIcon("assets/heart.png"));
		
		testPanel.revalidate();
		testPanel.repaint();
		this.setSize(600,499);
		
	}
}
