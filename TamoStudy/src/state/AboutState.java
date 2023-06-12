package state;

import java.awt.Desktop;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import gui.TamoStudyGUI;
import model.GuiSize;
import model.language.Language;
import resources.Constants;
import resources.Theme;

public class AboutState extends State {

	private static final long serialVersionUID = 353696047710911712L;
	
	/*
	 * ##################################
	 * ##################################
	 * ATTRIBUTES
	 * ##################################
	 * ##################################
	 */
	private GuiSize guiSize;
	private Language language;
	private Theme theme;
	
	/*
	 * ##################################
	 * ##################################
	 * COMPONENTS
	 * ##################################
	 * ##################################
	 */
	private JLabel tamoStudyImageLabel;
	private JLabel versionLabel;
	
	private JPanel aboutTamoStudyPanel;
	private JLabel aboutTamoStudyLabel;
	
	private JPanel socialMediaPanel;
	private JButton narlockWebsiteButton;
	private JButton tamoStudyWebsiteButton;
	private JButton youtubeButton;
	private JButton twitterButton;
	private JButton instagramButton;

	public AboutState(TamoStudyGUI tamoStudyGUI) {
		super(tamoStudyGUI);
		initializeAttributes();
		initializeComponents();
		initializeComponentVisuals();
		initializeComponentActions();
		initializePanel();
		
	}

	@Override
	protected void initializeAttributes() {
		this.guiSize = tsGui.getGuiSize();
		this.language = tsGui.getProfile().getSettings().getLanguage();
		this.theme = tsGui.getTheme();
	}

	@Override
	protected void initializeComponents() {
		tamoStudyImageLabel = new JLabel(guiSize.getTamoStudyLogoImage());
		versionLabel = new JLabel(Constants.version);
		
		aboutTamoStudyPanel = new JPanel();
		aboutTamoStudyLabel = new JLabel(language.aboutTamoStudyText);
		
		socialMediaPanel = new JPanel();
		narlockWebsiteButton = new JButton(guiSize.narlockIcon);
		tamoStudyWebsiteButton = new JButton(guiSize.tamoStudyIcon);
		youtubeButton = new JButton(guiSize.youtubeIcon);
		twitterButton = new JButton(guiSize.twitterIcon);
		instagramButton = new JButton(guiSize.instagramIcon);
	}

	@Override
	protected void initializeComponentVisuals() {
		versionLabel.setFont(guiSize.achievementTitleLabelFont);
		versionLabel.setForeground(theme.textColor);
		
		aboutTamoStudyPanel.add(aboutTamoStudyLabel);
		aboutTamoStudyPanel.setBackground(theme.mainColor);
		aboutTamoStudyPanel.setBorder(guiSize.messageBorder);
		
		aboutTamoStudyLabel.setForeground(theme.textColor);
		
		socialMediaPanel.setBackground(theme.subColor);
		addButtonVisual(narlockWebsiteButton);
		addButtonVisual(tamoStudyWebsiteButton);
		addButtonVisual(youtubeButton);
		addButtonVisual(twitterButton);
		addButtonVisual(instagramButton);
		socialMediaPanel.add(narlockWebsiteButton);
		socialMediaPanel.add(tamoStudyWebsiteButton);
		socialMediaPanel.add(youtubeButton);
		socialMediaPanel.add(twitterButton);
		socialMediaPanel.add(instagramButton);
	}

	@Override
	protected void initializeComponentActions() {
		narlockWebsiteButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try { Desktop.getDesktop().browse(new URL("https://narlock.github.io/narlock").toURI()); } 
				catch (Exception e1) { e1.printStackTrace(); }
			}
			
		});
		
		tamoStudyWebsiteButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try { Desktop.getDesktop().browse(new URL("https://tamostudy.com/").toURI()); } 
				catch (Exception e1) { e1.printStackTrace(); }
			}
			
		});
		
		youtubeButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try { Desktop.getDesktop().browse(new URL("https://youtube.com/narlock").toURI()); } 
				catch (Exception e1) { e1.printStackTrace(); }
			}
			
		});
		
		twitterButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try { Desktop.getDesktop().browse(new URL("https://twitter.com/narlockdev").toURI()); } 
				catch (Exception e1) { e1.printStackTrace(); }
			}
			
		});
		
		instagramButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try { Desktop.getDesktop().browse(new URL("https://instagram.com/narlockdev").toURI()); } 
				catch (Exception e1) { e1.printStackTrace(); }
			}
			
		});
	}

	@Override
	protected void initializePanel() {
		GridBagConstraints gbcv = new GridBagConstraints();
		gbcv.gridwidth = GridBagConstraints.REMAINDER;
		this.setLayout(new GridBagLayout());
		this.add(tamoStudyImageLabel, gbcv);
		this.add(versionLabel, gbcv);
		this.add(Box.createVerticalStrut(guiSize.settingsVerticalDifference), gbcv);
		this.add(aboutTamoStudyPanel, gbcv);
		this.add(Box.createVerticalStrut(guiSize.settingsVerticalDifference), gbcv);
		this.add(socialMediaPanel, gbcv);
	}

	/*
	 * ##################################
	 * ##################################
	 * HELPER METHODS
	 * ##################################
	 * ##################################
	 */
	public void addButtonVisual(JButton button) {
		button.setContentAreaFilled(false);
		button.setOpaque(false);
		button.setBorderPainted(false);
		button.setFocusPainted(false);
	}
}
