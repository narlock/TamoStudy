package components.panel;

import java.awt.Image;

import javax.swing.JPanel;

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
		// Initialize tamoImage
		tamoImage = guiSize.getTamoImage((int) tamo.getType(), tamo.getStatus(false));
		
		// Initialize backgroundImage
		backgroundImage = guiSize.getBackgroundImage(backgroundIndicator);
		
		// Initialize borderImage
		borderImage = guiSize.getBorderImage(borderIndicator);
	}
}
