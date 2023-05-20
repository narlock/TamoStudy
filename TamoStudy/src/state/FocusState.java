package state;

import javax.swing.JLabel;
import javax.swing.JPanel;

import components.panel.TamoGraphicsPanel;
import gui.TamoStudyGUI;
import model.GuiSize;
import model.language.Language;
import model.profile.Profile;
import model.profile.Tamo;
import model.time.DailyFocusEntry;
import model.time.MonthFocusEntry;
import resources.Theme;

public class FocusState extends State {

	private static final long serialVersionUID = -3878552282431644324L;
	
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
	private Tamo tamo;
	private Theme theme;
	private DailyFocusEntry dailyFocusEntry;
	private MonthFocusEntry monthFocusEntry;
	
	/*
	 * ##################################
	 * ##################################
	 * COMPONENTS
	 * ##################################
	 * ##################################
	 */
	
	// Side 1
	private JPanel tamoPanel;
	
	private JLabel tamoNameLabel;
	private TamoGraphicsPanel tamoGraphicsPanel;
	private JPanel tamoHappyHungerPanel;
	private JLabel tamoHappyLabel;
	private JLabel tamoHungerLabel;
	
	// Side 2
	private JPanel timerPanel;
	

	public FocusState(TamoStudyGUI tamoStudyGUI) {
		super(tamoStudyGUI);
		initializeAttributes();
		initializeComponents();
		initializeComponentVisuals();
		initializeComponentActions();
		initializePanel();
	}

	@Override
	protected void initializeAttributes() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void initializeComponents() {
		// TODO Auto-generated method stub
		
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
