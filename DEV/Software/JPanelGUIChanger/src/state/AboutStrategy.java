package state;

import java.awt.BorderLayout;
import java.awt.Desktop;
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

	private JPanel socialsPanel;
	private JButton anthonyWebButton, tamoWebButton,
				gitWebButton, instaWebButton, discordButton;
	
	private JLabel heroImage;
	
	@Override
	public void setPanel() {
		this.setBackground(theme.subColor);
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		this.add(createSpaceLabel(0));
		
		heroImage = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("ABOUT.png")));
			heroImage.setAlignmentX(JComponent.CENTER_ALIGNMENT);
		this.add(heroImage);
		
		socialsPanel = new JPanel();
			socialsPanel.setBackground(theme.subColor);
		
		anthonyWebButton = new JButton(new ImageIcon(getClass().getClassLoader().getResource("FAVICON.png")));
		tamoWebButton = new JButton(new ImageIcon(getClass().getClassLoader().getResource("ICON.png")));
		gitWebButton = new JButton(new ImageIcon(getClass().getClassLoader().getResource("GITHUB.png")));
		instaWebButton = new JButton(new ImageIcon(getClass().getClassLoader().getResource("INSTAGRAM.png")));
		discordButton = new JButton(new ImageIcon(getClass().getClassLoader().getResource("DISCORD.png")));
		
		socialsPanel.add(anthonyWebButton);
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

}
