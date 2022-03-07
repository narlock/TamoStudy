package guicomponents;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.*;

import profile.Language;

public class ahmPanel extends JPanel {
	
	private JPanel centerPanel;
	private JLabel ahmImage;
	private JLabel ahmTitle;
	private JLabel ahmDesc;
	
	private int id;
	private int achieved;
	
	private Language lang;
	
	public ahmPanel(int id, int achieved, int languageIndicator) {
		this.achieved = achieved;
		this.id = id;
		this.lang = new Language(languageIndicator);
		
		centerPanel = new JPanel();
		ahmImage = new JLabel();
		ahmTitle = new JLabel();
		ahmTitle.setFont(new Font("Tahoma", Font.BOLD, 18));
		ahmDesc = new JLabel();
		
		setAhmInfo(id);
		createPanel();
	}
	
	public void setAhmInfo(int id) {
		//TODO change to Language Indicator
		
		if(id == 0) {
			this.ahmTitle.setText(lang.get(11));
			this.ahmDesc.setText(lang.get(12));
		}
		
		if(id == 1) {
			this.ahmTitle.setText(lang.get(13));
			this.ahmDesc.setText(lang.get(14));
		}
		
		if(id == 2) {
			this.ahmTitle.setText(lang.get(15));
			this.ahmDesc.setText(lang.get(16));
		}
		
		if(id == 3) {
			this.ahmTitle.setText(lang.get(17));
			this.ahmDesc.setText(lang.get(18));
		}
		
		if(id == 4) {
			this.ahmTitle.setText(lang.get(19));
			this.ahmDesc.setText(lang.get(20));
		}
		
		if(id == 5) {
			this.ahmTitle.setText(lang.get(21));
			this.ahmDesc.setText(lang.get(22));
		}
		
		if(id == 6) {
			this.ahmTitle.setText(lang.get(23));
			this.ahmDesc.setText(lang.get(24));
		}
		
		if(id == 7) {
			this.ahmTitle.setText(lang.get(25));
			this.ahmDesc.setText(lang.get(26));
		}
		
		//Unused Achievements
		
		if(id == 8) {
			this.ahmTitle.setText(lang.getAhmTitle(8));
			this.ahmDesc.setText(lang.getAhmDesc(8));
		}
		
		if(id == 9) {
			this.ahmTitle.setText(lang.getAhmTitle(9));
			this.ahmDesc.setText(lang.getAhmDesc(9));
		}
		
		if(id == 10) {
			this.ahmTitle.setText(lang.getAhmTitle(10));
			this.ahmDesc.setText(lang.getAhmDesc(10));
		}
		
		
	}
	
	public void createPanel() {
		if(achieved == 1) {
			//this.ahmImage.setIcon(new ImageIcon(getClass().getClassLoader().getResource("ahm-achieved.png")));
			if(id == 0) {
				this.ahmImage.setIcon(new ImageIcon(getClass().getClassLoader().getResource("ahm-01.png")));
			}
			
			if(id == 1) {
				this.ahmImage.setIcon(new ImageIcon(getClass().getClassLoader().getResource("ahm-11.png")));
			}
			
			if(id == 2) {
				this.ahmImage.setIcon(new ImageIcon(getClass().getClassLoader().getResource("ahm-21.png")));
			}
			
			if(id == 3) {
				this.ahmImage.setIcon(new ImageIcon(getClass().getClassLoader().getResource("ahm-41.png")));
			}
			
			if(id == 4) {
				this.ahmImage.setIcon(new ImageIcon(getClass().getClassLoader().getResource("ahm-31.png")));
			}
			
			if(id == 5) {
				this.ahmImage.setIcon(new ImageIcon(getClass().getClassLoader().getResource("ahm-51.png")));
			}
			
			if(id == 6) {
				this.ahmImage.setIcon(new ImageIcon(getClass().getClassLoader().getResource("ahm-61.png")));
			}
			
			if(id == 7) {
				this.ahmImage.setIcon(new ImageIcon(getClass().getClassLoader().getResource("ahm-71.png")));
			}
			
		} else {
			if(id == 0) {
				this.ahmImage.setIcon(new ImageIcon(getClass().getClassLoader().getResource("ahm-00.png")));
			}
			
			if(id == 1) {
				this.ahmImage.setIcon(new ImageIcon(getClass().getClassLoader().getResource("ahm-00.png")));
			}
			
			if(id == 2) {
				this.ahmImage.setIcon(new ImageIcon(getClass().getClassLoader().getResource("ahm-00.png")));
			}
			
			if(id == 3) {
				this.ahmImage.setIcon(new ImageIcon(getClass().getClassLoader().getResource("ahm-40.png")));
			}
			
			if(id == 4) {
				this.ahmImage.setIcon(new ImageIcon(getClass().getClassLoader().getResource("ahm-30.png")));
			}
			
			if(id == 5) {
				this.ahmImage.setIcon(new ImageIcon(getClass().getClassLoader().getResource("ahm-50.png")));
			}
			
			if(id == 6) {
				this.ahmImage.setIcon(new ImageIcon(getClass().getClassLoader().getResource("ahm-60.png")));
			}
			
			if(id == 7) {
				this.ahmImage.setIcon(new ImageIcon(getClass().getClassLoader().getResource("ahm-70.png")));
			}
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
