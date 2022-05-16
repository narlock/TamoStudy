package state;

import java.awt.BorderLayout;
import java.awt.Graphics;

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
		this.setBackground(subColor);
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		this.add(createSpaceLabel(0));
		
		heroImage = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("ABOUT.png")));
			heroImage.setAlignmentX(JComponent.CENTER_ALIGNMENT);
		this.add(heroImage);
		
		socialsPanel = new JPanel();
			socialsPanel.setBackground(subColor);
		
		anthonyWebButton = new JButton(new ImageIcon(getClass().getClassLoader().getResource("DISCORD.png")));
		tamoWebButton = new JButton(new ImageIcon(getClass().getClassLoader().getResource("DISCORD.png")));
		gitWebButton = new JButton(new ImageIcon(getClass().getClassLoader().getResource("DISCORD.png")));
		instaWebButton = new JButton(new ImageIcon(getClass().getClassLoader().getResource("DISCORD.png")));
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
		// TODO Auto-generated method stub
		
	}

}
