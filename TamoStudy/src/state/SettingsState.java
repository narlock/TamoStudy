package state;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

import gui.TamoStudyGUI;

public class SettingsState extends State {

	private static final long serialVersionUID = -8979954063946210819L;
	int index = 1;

	public SettingsState(TamoStudyGUI tamoStudyGUI) {
		super(tamoStudyGUI);
		this.add(new JLabel("Settings state"));
		
		JButton button = new JButton("-");
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("index = " + index);
				if(index > -1) {
					tsGui.getProfile().getSettings().setGuiSize(tsGui.getProfile().getSettings().getGuiSize() - 1);
					index--;
					tsGui.resizeGui(index);
				}
				
			}
		});
		this.add(button);
		
		JButton button2 = new JButton("+");
		button2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("index = " + index);
				
				if(index < 3) {
					tsGui.getProfile().getSettings().setGuiSize(tsGui.getProfile().getSettings().getGuiSize() + 1);
					index++;
					tsGui.resizeGui(index);
				}
				
			}
		});
		this.add(button2);
	}
	
	public SettingsState(TamoStudyGUI tamoStudyGUI, int index) {
		super(tamoStudyGUI);
		this.add(new JLabel("Settings state"));
		
		JButton button = new JButton("-");
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("index = " + index);
				if(index > -1) {
					tsGui.getProfile().getSettings().setGuiSize(tsGui.getProfile().getSettings().getGuiSize() - 1);
				    int newindex = index - 1;
					tsGui.resizeGui(newindex);
				}
				
			}
		});
		this.add(button);
		
		JButton button2 = new JButton("+");
		button2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("index = " + index);
				
				if(index < 3) {
					tsGui.getProfile().getSettings().setGuiSize(tsGui.getProfile().getSettings().getGuiSize() + 1);
					int newindex = index + 1;
					tsGui.resizeGui(newindex);
				}
				
			}
		});
		this.add(button2);
	}

}
