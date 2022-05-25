package state;

import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import profile.Profile;

public class AboutStrategy extends StateStrategy {

	public AboutStrategy(Profile profile) {
		super(profile);
	}

	private JPanel socialsPanel, textPanel;
	private JButton anthonyWebButton, tamoWebButton,
				gitWebButton, instaWebButton, discordButton;
	
	private JLabel titleImage, groupImage, descLabel;
	
	@Override
	public void setPanel() {
		this.setBackground(theme.subColor);
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.add(createSpaceLabel(1));
		
		//titleImage = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("TAMOSTUDY_LOGO.png")));
		//	titleImage.setAlignmentX(JComponent.CENTER_ALIGNMENT);
		//this.add(titleImage);
		
		textPanel = new JPanel();
			textPanel.setBackground(theme.subColor);
			textPanel.setAlignmentX(JComponent.CENTER_ALIGNMENT);
		descLabel = new JLabel("<html>" + profile.getLanguage().aboutText[0] + "<br>" +
					profile.getLanguage().aboutText[1] + "<br>" +
					profile.getLanguage().aboutText[2] + "<br>" +
					profile.getLanguage().aboutText[3] + "<br><br>" +
					profile.getLanguage().aboutText[4] + "<b>" +
					profile.getLanguage().aboutText[5] + "</b>"
				);
		descLabel.setFont(new Font("Arial", Font.PLAIN, 24));
		descLabel.setForeground(theme.textColor);
		textPanel.add(descLabel);
		this.add(textPanel);
		
		groupImage = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("TAMOSTUDY_GROUP.png")));
			groupImage.setAlignmentX(JComponent.CENTER_ALIGNMENT);
		//this.add(groupImage);
		
		socialsPanel = new JPanel();
			socialsPanel.setBackground(theme.subColor);
		
		anthonyWebButton = new JButton(new ImageIcon(getClass().getClassLoader().getResource("FAVICON.png")));
			setUpJButtonComponent(anthonyWebButton);
		tamoWebButton = new JButton(new ImageIcon(getClass().getClassLoader().getResource("ICON.png")));
			setUpJButtonComponent(tamoWebButton);
		gitWebButton = new JButton(new ImageIcon(getClass().getClassLoader().getResource("GITHUB.png")));
			setUpJButtonComponent(gitWebButton);
		instaWebButton = new JButton(new ImageIcon(getClass().getClassLoader().getResource("INSTAGRAM.png")));
			setUpJButtonComponent(instaWebButton);
		discordButton = new JButton(new ImageIcon(getClass().getClassLoader().getResource("DISCORD.png")));
			setUpJButtonComponent(discordButton);
		
		//socialsPanel.add(anthonyWebButton);
		socialsPanel.add(tamoWebButton);
		socialsPanel.add(gitWebButton);
		socialsPanel.add(instaWebButton);
		socialsPanel.add(discordButton);
		
		this.add(socialsPanel);
	}

	@Override
	public void setActions() {
		setActionForLink(anthonyWebButton, "https://anthonynarlock.com/");
		setActionForLink(tamoWebButton, "http://tamostudy.com/");
		setActionForLink(gitWebButton, "https://github.com/narlock/TamoStudy");
		setActionForLink(instaWebButton, "https://instagram.com/TamoStudy");
		setActionForLink(discordButton, "https://discord.gg/eEbEYbXaNS");
	}
	
	public void setActionForLink(JButton button, String url) {
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try { Desktop.getDesktop().browse(new URL(url).toURI()); } 
				catch (Exception e1) { e1.printStackTrace(); }
			}
		});
	}
	
	public void setUpJButtonComponent(JButton button) {
		button.setBorderPainted(false);
		button.setBackground(theme.mainColor);
		button.setForeground(theme.layerTextColor);
		button.setFocusPainted(false);
	}

}
