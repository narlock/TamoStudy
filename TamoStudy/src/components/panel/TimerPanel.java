package components.panel;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import components.border.BubbleBorder;
import model.GuiSize;
import model.language.Language;
import model.profile.Profile;
import resources.Theme;

public class TimerPanel extends JPanel {

	private static final long serialVersionUID = 4026276417716279630L;
	
	/*
	 * ##################################
	 * ##################################
	 * ATTRIBUTES
	 * ##################################
	 * ##################################
	 */
	private Profile profile;
	private Language language;
	private GuiSize guiSize;
	private Theme theme;
	
	/*
	 * ##################################
	 * ##################################
	 * COMPONENTS
	 * ##################################
	 * ##################################
	 */
	private JPanel timerTimePanel;
	public JLabel minuteTimeLabel, colonLabel, secondTimeLabel;
	public JLabel subTextLabel;

	public TimerPanel(Profile profile) {
		this.profile = profile;
		this.language = profile.getSettings().getLanguage();
		this.guiSize = new GuiSize((int) profile.getSettings().getGuiSize());
		this.theme = Theme.DARK;
		
		initializeAttributes();
		initializePanel();
	}
	
	public void initializeAttributes() {
		timerTimePanel = new JPanel();
		timerTimePanel.setBackground(Color.BLACK);
		
		minuteTimeLabel = new JLabel("00");
		minuteTimeLabel.setForeground(theme.textColor);
		minuteTimeLabel.setFont(guiSize.timerFont);
		
		colonLabel = new JLabel(":");
		colonLabel.setForeground(theme.textColor);
		colonLabel.setFont(guiSize.timerFont);
		
		secondTimeLabel = new JLabel("00");
		secondTimeLabel.setForeground(theme.textColor);
		secondTimeLabel.setFont(guiSize.timerFont);
		
		timerTimePanel.add(minuteTimeLabel);
		timerTimePanel.add(colonLabel);
		timerTimePanel.add(secondTimeLabel);
		
		subTextLabel = new JLabel(language.letsFocusText);
		subTextLabel.setForeground(theme.textColor);
		subTextLabel.setFont(guiSize.subTextFont);
	}
	
	public void initializePanel() {
		GridBagConstraints gbcv = new GridBagConstraints();
		gbcv.gridwidth = GridBagConstraints.REMAINDER;
		this.setLayout(new GridBagLayout());
		this.setBackground(Color.BLACK);
		this.setBorder(guiSize.timerBorder);
		
		this.add(timerTimePanel, gbcv);
		this.add(subTextLabel, gbcv);
	}
	
	public Theme getTheme() {
		return theme;
	}
	
	public GuiSize getGuiSize() {
		return guiSize;
	}
}
