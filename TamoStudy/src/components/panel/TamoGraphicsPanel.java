package components.panel;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

import model.GuiSize;
import model.profile.Tamo;
import resources.ImageResourceHandler;

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
	private Image tamoImage;

	public TamoGraphicsPanel(GuiSize guiSize, Tamo tamo, long backgroundIndicator, long borderIndicator) {
		this.guiSize = guiSize;
		this.tamo = tamo;
		this.backgroundIndicator = (int) backgroundIndicator;
		this.borderIndicator = (int) borderIndicator;
		
		
		initializeAttributes();
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
	    ImageResourceHandler irh = new ImageResourceHandler();
	    
	    tamoImage = guiSize.getTamoImage((int) tamo.getType(), tamo.getStatus(false));
	    backgroundImage = guiSize.getBackgroundImage(backgroundIndicator);
	    borderImage = guiSize.getBorderImage(borderIndicator);
	}

	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		
		g.drawImage(backgroundImage,(int) (8 / 1.5), (int) (8 / 1.5), this);
		g.drawImage(tamoImage, 8, 8, this);
		g.drawImage(borderImage, 0, 0, this);
	}
}
