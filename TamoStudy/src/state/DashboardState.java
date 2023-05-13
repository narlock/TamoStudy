package state;

import javax.swing.JLabel;
import javax.swing.JPanel;

import components.panel.TamoGraphicsPanel;
import gui.TamoStudyGUI;
import model.GuiSize;
import model.profile.Profile;
import model.profile.Tamo;

public class DashboardState extends State {
	
	private static final long serialVersionUID = -774794028854162351L;
	
	/*
	 * ##################################
	 * ##################################
	 * ATTRIBUTES
	 * ##################################
	 * ##################################
	 */
	private Profile profile;
	private GuiSize guiSize;
	private Tamo tamo;

	/*
	 * ##################################
	 * ##################################
	 * COMPONENTS
	 * ##################################
	 * ##################################
	 */
	private JLabel tamoStudyLogoImageLabel;
	private JPanel tamoDashboardPanel;				// Grid Panel
	private TamoGraphicsPanel tamoGraphicsPanel; 	// LHS
	private JPanel tamoInfoPanel; 					// RHS
	
	public DashboardState(TamoStudyGUI tamoStudyGUI) {
		super(tamoStudyGUI);
		initializeAttributes();
		initializeComponents();
		initializeComponentVisuals();
		initializeComponentActions();
		initializePanel();
	}

	@Override
	protected void initializeAttributes() {
		this.profile = tsGui.getProfile();
//		this.guiSize = new GuiSize((int) profile.getSettings().getGuiSize());
		this.tamo = profile.getTamo();
	}

	@Override
	protected void initializeComponents() {
//		tamoStudyLogoImageLabel = 
	}

	@Override
	protected void initializeComponentVisuals() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void initializeComponentActions() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void initializePanel() {
		// TODO Auto-generated method stub
		
	}
	
}
