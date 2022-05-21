package state;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import profile.Profile;
import resources.CommunicateThemeAction;
import resources.Theme;

public class ThemeStrategy extends StateStrategy {

	public ThemeStrategy(Profile profile) {
		super(profile);
		// TODO Auto-generated constructor stub
	}

	private JLabel themeHeaderLabel, themeHeaderClassicLabel, ensuranceLabel;
	private JPanel themePanel, themePanel2, themePanel3, themePanel4;
	
	private CommunicateThemeAction action;
	private Stack<JLabel> tlabels;
	private Stack<JPanel> tpanels;
	
	private Stack<JButton> selectButtons;
	private boolean changeReceived;
	
	@Override
	public void setPanel() {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setBackground(theme.subColor);
		
		changeReceived = false;
		selectButtons = new Stack<>();
		
		ensuranceLabel = new JLabel("");
		ensuranceLabel.setForeground(new Color(10, 153, 0));
		ensuranceLabel.setFont(theme.fontBoldRegSmall);
		ensuranceLabel.setAlignmentX(JComponent.CENTER_ALIGNMENT);
		this.add(ensuranceLabel);
		
		themeHeaderLabel = new JLabel(profile.getLanguage().themesText[8]);
		setUpLabelComponent(themeHeaderLabel);
		this.add(themeHeaderLabel);
		
		themePanel = new JPanel();
			themePanel.setBackground(theme.subColor);
			
		themePanel.add(themePanel(profile.getLanguage().themesText[0], "DARK_MODE.png"));
		themePanel.add(themePanel(profile.getLanguage().themesText[1], "LIGHT_MODE.png"));
		
		this.add(themePanel);
		
		themeHeaderClassicLabel = new JLabel(profile.getLanguage().themesText[10]);
		setUpLabelComponent(themeHeaderClassicLabel);
		this.add(themeHeaderClassicLabel);
		
		themePanel2 = new JPanel();
		themePanel2.setBackground(theme.subColor);
		
		themePanel2.add(themePanel(profile.getLanguage().themesText[2], "CLASSIC_MODE.png"));
		themePanel2.add(themePanel(profile.getLanguage().themesText[3], "CLASSIC_BLUE_MODE.png"));
		
		this.add(themePanel2);
		
		themePanel3 = new JPanel();
		themePanel3.setBackground(theme.subColor);
		
		themePanel3.add(themePanel(profile.getLanguage().themesText[4], "CLASSIC_GREEN_MODE.png"));
		themePanel3.add(themePanel(profile.getLanguage().themesText[5], "CLASSIC_YELLOW_MODE.png"));
		
		this.add(themePanel3);
		
		themePanel4 = new JPanel();
		themePanel4.setBackground(theme.subColor);
		
		themePanel4.add(themePanel(profile.getLanguage().themesText[6], "CLASSIC_ORANGE_MODE.png"));
		themePanel4.add(themePanel(profile.getLanguage().themesText[7], "CLASSIC_PURPLE_MODE.png"));
		
		this.add(themePanel4);
		
	}

	@Override
	public void setActions() {
		// TODO Auto-generated method stub
		tlabels = new Stack<>();
		tlabels.push(themeHeaderLabel);
		tlabels.push(themeHeaderClassicLabel);
		//tlabels.push(ensuranceLabel);
		
		tpanels = new Stack<>();
		tpanels.push(this);
		tpanels.push(themePanel);
		tpanels.push(themePanel2);
		tpanels.push(themePanel3);
		tpanels.push(themePanel4);
		
	}
	
	public JPanel themePanel(String name, String imageUrl) {
		JPanel panel = new JPanel();
			panel.setAlignmentX(JComponent.CENTER_ALIGNMENT);
			panel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
			panel.setBackground(Color.WHITE);
		JLabel nameLabel = new JLabel(name);
		JLabel imgLabel = new JLabel(new ImageIcon(getClass().getClassLoader().getResource(imageUrl)));
		
		JButton select = new JButton("<html>" + profile.getLanguage().themesText[9] + "<br>" + name + "</html>");
		select.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(imageUrl.equals("DARK_MODE.png")) { themeChanged(0); }
				else if(imageUrl.equals("LIGHT_MODE.png")) { themeChanged(1); }
				else if(imageUrl.equals("CLASSIC_MODE.png")) { themeChanged(2); }
				else if(imageUrl.equals("CLASSIC_BLUE_MODE.png")) { themeChanged(3); }
				else if(imageUrl.equals("CLASSIC_GREEN_MODE.png")) { themeChanged(4); }
				else if(imageUrl.equals("CLASSIC_YELLOW_MODE.png")) { themeChanged(5); }
				else if(imageUrl.equals("CLASSIC_ORANGE_MODE.png")) { themeChanged(6); }
				else if(imageUrl.equals("CLASSIC_PURPLE_MODE.png")) { themeChanged(7); }
				checkThemeAchievement();
			}
		});
		selectButtons.push(select);
		
		panel.add(nameLabel);
		panel.add(imgLabel);
		panel.add(select);
		
		return panel;
	}
	
	public void setUpLabelComponent(JLabel label) {
		label.setForeground(theme.textColor);
		label.setFont(theme.fontBoldReg);
		label.setAlignmentX(JComponent.CENTER_ALIGNMENT);
	}
	
	public void themeChanged(int i) {
		profile.setThemeIndicator(i);
		theme = profile.getThemeIndicator();
		ensuranceLabel.setAlignmentX(JComponent.CENTER_ALIGNMENT);
		ensuranceLabel.setText(profile.getLanguage().themesText[11] + profile.getLanguage().themesText[i]);
		ensuranceLabel.setAlignmentX(JComponent.CENTER_ALIGNMENT);
		
		action = new CommunicateThemeAction(theme, tlabels, tpanels);
		action.updateThemeStrategy();
	
		//TODO Update the profile file
	}
	
	public Stack<JButton> getSelectButtons() {
		return selectButtons;
	}
	
	public void checkThemeAchievement() {
		//Reach 3 hours focus time
		if(profile.getAhmIndicator(4).equals("0")) {
			profile.getAchievement(4);
			JOptionPane.showMessageDialog(this, profile.getLanguage().ahmTitle[4], profile.getLanguage().text[11], JOptionPane.INFORMATION_MESSAGE,  new ImageIcon(getClass().getClassLoader().getResource("INFO.png")));
		}
	}
	
}
