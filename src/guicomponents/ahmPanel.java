package guicomponents;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.*;

public class ahmPanel extends JPanel {
	
	private JPanel centerPanel;
	private JLabel ahmImage;
	private JLabel ahmTitle;
	private JLabel ahmDesc;
	
	private int languageIndicator;
	private int id;
	private int achieved;
	
	public ahmPanel(int id, int achieved, int languageIndicator) {
		this.achieved = achieved;
		this.id = id;
		this.languageIndicator = languageIndicator;
		
		centerPanel = new JPanel();
		ahmImage = new JLabel();
		ahmTitle = new JLabel();
		ahmDesc = new JLabel();
		
		setAhmInfo(id);
		createPanel();
	}
	
	public void setAhmInfo(int id) {
		//TODO change to Language Indicator
		
		if(id == 0) {
			this.ahmTitle.setText("The Beginning");
			this.ahmDesc.setText("Reach Total focus tim of 3 hours");
		}
		
		if(id == 1) {
			this.ahmTitle.setText("Nothing can stop you!");
			this.ahmDesc.setText("Reach Total focus tim of 3 hours");
		}
		
		if(id == 2) {
			this.ahmTitle.setText("Never give up");
			this.ahmDesc.setText("Reach Total focus tim of 3 hours");
		}
		
		if(id == 3) {
			this.ahmTitle.setText("The Beginning2");
			this.ahmDesc.setText("Reach Total focus tim of 3 hours");
		}
		
		if(id == 4) {
			this.ahmTitle.setText("The Beginning3");
			this.ahmDesc.setText("Reach Total focus tim of 3 hours");
		}
		
		if(id == 5) {
			this.ahmTitle.setText("The Beginning4");
			this.ahmDesc.setText("Reach Total focus tim of 3 hours");
		}
		
		if(id == 6) {
			this.ahmTitle.setText("The Beginning5");
			this.ahmDesc.setText("Reach Total focus tim of 3 hours");
		}
		
		if(id == 7) {
			this.ahmTitle.setText("The Beginning6");
			this.ahmDesc.setText("Reach Total focus tim of 3 hours");
		}
		
		if(id == 8) {
			this.ahmTitle.setText("The Beginning7");
			this.ahmDesc.setText("Reach Total focus tim of 3 hours");
		}
		
		if(id == 9) {
			this.ahmTitle.setText("The Beginning8");
			this.ahmDesc.setText("Reach Total focus tim of 3 hours");
		}
		
		if(id == 10) {
			this.ahmTitle.setText("The Beginning9");
			this.ahmDesc.setText("Reach Total focus tim of 3 hours");
		}
		
		
	}
	
	public void createPanel() {
		if(achieved == 1) {
			this.ahmImage.setIcon(new ImageIcon(getClass().getClassLoader().getResource("ahm-achieved.png")));
		} else {
			this.ahmImage.setIcon(new ImageIcon(getClass().getClassLoader().getResource("ahm-not.png")));
		}
		
		this.add(ahmImage, BorderLayout.WEST);
		this.add(centerPanel);
		
		centerPanel.setLayout(new GridLayout(2,1));
		centerPanel.add(ahmTitle);
		centerPanel.add(ahmDesc);
	}
	
	public ahmPanel getAhm() {
		return this;
	}
	
	@Override
	public String toString() {
		return this.ahmTitle.getText();
	}
}
