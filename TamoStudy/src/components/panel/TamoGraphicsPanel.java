package components.panel;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;
import javax.swing.Timer;

import model.GuiSize;
import model.profile.Tamo;

public class TamoGraphicsPanel extends JPanel {

	private static final long serialVersionUID = 893329295457663557L;
	/*
	 * ##################################
	 * ##################################
	 * ATTRIBUTES
	 * ##################################
	 * ##################################
	 */
	private GuiSize guiSize;
	private Tamo tamo;
	private int backgroundIndicator;
	private int borderIndicator;
	
	/*
	 * ##################################
	 * ##################################
	 * COMPONENTS
	 * ##################################
	 * ##################################
	 */
	private Image borderImage;
	private Image backgroundImage;
	public Image tamoImage;

	public TamoGraphicsPanel(GuiSize guiSize, Tamo tamo, long backgroundIndicator, long borderIndicator) {
		this.guiSize = guiSize;
		this.tamo = tamo;
		this.backgroundIndicator = (int) backgroundIndicator;
		this.borderIndicator = (int) borderIndicator;
		
		initializeAttributes();
		
		// If Tamo is happy or normal status, repaint so tamo appears in random location
		if(tamo.getStatus(false).equals("HAPPY") || tamo.getStatus(false).equals("NOMRAL")) {
			Timer timer = new Timer(1000, e -> repaint());
		    timer.start();
		}
	}
	
	/**
	 * @param tamo
	 * @param backgroundIndicator
	 * @param borderIndicator
	 * @brief Based off of the GUI size, we will initialize our tamoImage,
	 * backgroundImage, and borderImage
	 */
	public void initializeAttributes() {
	    this.setPreferredSize(guiSize.tamoGraphicsPanelDimension);
	    
	    tamoImage = guiSize.getTamoImage((int) tamo.getType(), tamo.getStatus(false));
	    backgroundImage = guiSize.getBackgroundImage(backgroundIndicator);
	    borderImage = guiSize.getBorderImage(borderIndicator);
	}

	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		
		g.drawImage(backgroundImage, guiSize.backgroundImageOffset, guiSize.backgroundImageOffset, this);
		g.drawImage(tamoImage, getTamoX(), getTamoY(), this);
		g.drawImage(borderImage, 0, 0, this);
	}
	
	/*
	 * ##################################
	 * ##################################
	 * HELPER METHODS
	 * ##################################
	 * ##################################
	 */
	
	public int getTamoX() {
		if(tamo.getStatus(false).equals("HAPPY") || tamo.getStatus(false).equals("NOMRAL")) {
			return getTamoRandomX();
		} else { 
			return getTamoCenterX();
		}
	}
	
	public int getTamoY() {
		if(tamo.getStatus(false).equals("HAPPY") || tamo.getStatus(false).equals("NOMRAL")) {
			return getTamoRandomY();
		} else { 
			return getTamoCenterY();
		}
	}
	
	public int getTamoCenterX() {
		int backgroundImageWidth = backgroundImage.getWidth(this);
	    int tamoImageWidth = tamoImage.getWidth(this);
	    int number = (tamoImageWidth + tamoImageWidth/2) / 2;

	    return (backgroundImageWidth - number) / 2;
	}
	
	public int getTamoCenterY() {
	    int backgroundImageHeight = backgroundImage.getHeight(this);
	    int tamoImageHeight = tamoImage.getHeight(this);

	    return (backgroundImageHeight - tamoImageHeight) / 2;
	}
	
	public int getTamoRandomX() {
	    int backgroundImageWidth = backgroundImage.getWidth(this);
	    int tamoImageWidth = tamoImage.getWidth(this);

	    return (int) (Math.random() * (backgroundImageWidth - tamoImageWidth));
	}
	
	public int getTamoRandomY() {
	    int backgroundImageHeight = backgroundImage.getHeight(this);
	    int tamoImageHeight = tamoImage.getHeight(this);
	    return (int) (Math.random() * (backgroundImageHeight - tamoImageHeight));
	}
}
