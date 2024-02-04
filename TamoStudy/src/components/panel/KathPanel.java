package components.panel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JLabel;
import javax.swing.JPanel;

import model.GuiSize;
import model.language.Language;
import resources.Debug;
import resources.Theme;

public class KathPanel extends JPanel {

	private static final long serialVersionUID = 1209578719406725927L;

	/*
	 * ##################################
	 * ##################################
	 * ATTRIBUTES
	 * ##################################
	 * ##################################
	 */
	private Theme theme;
	private GuiSize guiSize;
	private Language language;
	public int shopIndicator;
	
	/*
	 * ##################################
	 * ##################################
	 * COMPONENTS
	 * ##################################
	 * ##################################
	 */
	 public Image kathImage;
	 public JLabel messageLabel;
	
	public KathPanel(Theme theme, GuiSize guiSize, Language language) {
		this.guiSize = guiSize;
		this.language = language;
		shopIndicator = 0;
		this.theme = theme;
		
		messageLabel = new JLabel();
		
		initializeAttributes();
		initializeComponents();
		initializePanel();
		
	}
	
	public void initializeAttributes() {
		Debug.info("KathPanel.initializeAttributes", "shopIndicator = " + shopIndicator);
		
		if(shopIndicator == 0) {
			messageLabel.setText(language.welcomeToTheShopText);
			
			this.setPreferredSize(guiSize.kathShopDimension);
			this.setBackground(new Color(153, 236, 255));
			this.setBorder(guiSize.messageBorder);
		} else if(shopIndicator == 1) {
			messageLabel.setText(language.hereAreOurFoodOptionsText);
			
			this.setPreferredSize(guiSize.kathMsgDimension);
			this.setBackground(theme.subColor);
			this.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		} else if(shopIndicator == 2) {
			messageLabel.setText(language.whatBackgroundsCanIHelpFindText);
			
			this.setPreferredSize(guiSize.kathMsgDimension);
			this.setBackground(theme.subColor);
			this.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		} else if(shopIndicator == 3) {
			messageLabel.setText(language.whatBordersCanIHelpFindText);
			
			this.setPreferredSize(guiSize.kathMsgDimension);
			this.setBackground(theme.subColor);
			this.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		} else if(shopIndicator == 4) {
			messageLabel.setText(language.letsCustomizeFocusTimerText);
			
			this.setPreferredSize(guiSize.kathMsgDimension);
			this.setBackground(theme.subColor);
			this.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		}
	}
	
	public void initializeComponents() {
		messageLabel.setOpaque(true);
		messageLabel.setForeground(Color.black);
		messageLabel.setBackground(Color.white);
		messageLabel.setBorder(guiSize.messageBorder);
		messageLabel.setFont(guiSize.kathMessageFont);
	}
	
	public void initializePanel() {
		this.add(messageLabel);
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		
		if(shopIndicator == 0) {
			kathImage = guiSize.getKathImage(0); // Kath Image starts at shop
			g.drawImage(kathImage, 0, guiSize.kathImageOffset, this);
		} else {
			kathImage = guiSize.getKathImage(1); // Kath Image
			g.drawImage(kathImage, 0, guiSize.kathImageOffset, this);
		}
	}
	
	/*
	 * ##################################
	 * ##################################
	 * HELPER METHODS
	 * ##################################
	 * ##################################
	 */
	public int getKathCenterX() {
		int backgroundImageWidth = this.getX();
	    int tamoImageWidth = kathImage.getWidth(this);
	    int number = (tamoImageWidth + tamoImageWidth) / 2;

	    return (backgroundImageWidth - number) / 2;
	}
}
