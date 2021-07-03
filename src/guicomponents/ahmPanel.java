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
		ahmDesc = new JLabel();
		
		setAhmInfo(id);
		createPanel();
	}
	
	public void setAhmInfo(int id) {
		//TODO change to Language Indicator
		
		if(id == 0) {
			this.ahmTitle.setText(lang.getAhmTitle(0));
			this.ahmDesc.setText(lang.getAhmDesc(0));
		}
		
		if(id == 1) {
			this.ahmTitle.setText(lang.getAhmTitle(1));
			this.ahmDesc.setText(lang.getAhmDesc(1));
		}
		
		if(id == 2) {
			this.ahmTitle.setText(lang.getAhmTitle(2));
			this.ahmDesc.setText(lang.getAhmDesc(2));
		}
		
		if(id == 3) {
			this.ahmTitle.setText(lang.getAhmTitle(3));
			this.ahmDesc.setText(lang.getAhmDesc(3));
		}
		
		if(id == 4) {
			this.ahmTitle.setText(lang.getAhmTitle(4));
			this.ahmDesc.setText(lang.getAhmDesc(4));
		}
		
		if(id == 5) {
			this.ahmTitle.setText(lang.getAhmTitle(5));
			this.ahmDesc.setText(lang.getAhmDesc(5));
		}
		
		if(id == 6) {
			this.ahmTitle.setText(lang.getAhmTitle(6));
			this.ahmDesc.setText(lang.getAhmDesc(6));
		}
		
		if(id == 7) {
			this.ahmTitle.setText(lang.getAhmTitle(7));
			this.ahmDesc.setText(lang.getAhmDesc(7));
		}
		
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
