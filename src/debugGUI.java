
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.*;

/**
 * debugGUI
 * @author antho
 * 
 * developer debug menu, allows for profile information
 * to be changed through the program without having 
 * to decrypt the text file
 *
 */

public class debugGUI extends JFrame {
	private JLabel[] labels = {
			new JLabel("Username"),
			new JLabel("Join Date"),
			new JLabel("Last Login"),
			new JLabel("Total Seconds"),
			new JLabel("Money"),
			new JLabel("Current BG int"),
			new JLabel("GUIcolor"),
			new JLabel("Tamo name"),
			new JLabel("Tamo ID"),
			new JLabel("Tamo Happiness"),
			new JLabel("Tamo Hunger"),
			new JLabel("ahm String"),
	};
	private JPanel mainPanel;
	
	private JTextField userField, joinDate, lastLogin, seconds, money, bgInt, guiColor, tamoName, tamoHap, tamoHun, ahmString;
	private JButton saveChanges;
	
	private Profile p;
	private File file;
	private Encryption encryption;
	
	public debugGUI(Profile profile, File file) {
		this.p = profile;
		this.file = file;
		
		setUpFrame();
		
		initComponents();
		
		initActions();
		
		setUpGUI();
		
		this.setSize(250,500);
	}
	
	public void setUpFrame() { 
		this.setTitle("DEBUG MENU");
		this.setSize(251,500);
		this.setLocationRelativeTo(null);
		this.setResizable(true);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void initComponents() {
		userField = new JTextField(10);
		userField.setText(p.getUsername());
		lastLogin = new JTextField(10);
		lastLogin.setText(p.getLastLoginString());
		seconds = new JTextField(10);
		seconds.setText(Integer.toString(p.getTotalTime()));
		money = new JTextField(10);
		money.setText(Integer.toString(p.getMoney()));
		bgInt = new JTextField(10);
		bgInt.setText(Integer.toString(p.getCurrentBackground()));
		guiColor = new JTextField(10);
		guiColor.setText(p.getGuiColor());
		tamoName = new JTextField(10);
		tamoName.setText(p.getTamo().getName());
		tamoHap = new JTextField(10);
		tamoHap.setText(Integer.toString(p.getTamo().getHappiness()));
		tamoHun = new JTextField(10);
		tamoHun.setText(Integer.toString(p.getTamo().getHunger()));
		ahmString = new JTextField(10);
		ahmString.setText(p.getAhm().getAhmString());
		
		saveChanges = new JButton("Save Changes");
		mainPanel = new JPanel();
	}
	
	public void initActions() {
		saveChanges.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("yes");
				updateProfileFromFields();
				GUI gui = new GUI(p, file);
				hideWindow();
			}
			
		});
	}
	
	public void setUpGUI() {
		this.add(mainPanel);
		
		mainPanel.add(labels[0]);
		mainPanel.add(userField);
		mainPanel.add(labels[3]);
		mainPanel.add(seconds);
		mainPanel.add(labels[4]);
		mainPanel.add(money);
		mainPanel.add(labels[10]);
		mainPanel.add(tamoHun);
		
		mainPanel.add(saveChanges,BorderLayout.SOUTH);
	}
	
	public void hideWindow() {
		this.setVisible(false);
		this.dispose();
	}
	
	public void updateProfileFromFields() {
		p.setUsername(userField.getText());
		p.setTotalTime(Integer.parseInt(seconds.getText()));
		p.setMoney(Integer.parseInt(money.getText()));
		p.getTamo().setHunger(Integer.parseInt(tamoHun.getText()));
		
		
	}
}
