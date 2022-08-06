package panels;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import resources.Settings;
import tamostudy.Profile;

public class ViewCurrentSettingsPanel extends JPanel {
	private Settings settings;
	private Profile profile;
	
	private final JLabel generalSettingsHeaderLabel = new JLabel("General Settings");
	private JLabel generalSettingsLabel;
	
	private JLabel timerSettingsHeaderLabel = new JLabel("Timer Settings");
	private JLabel timerSettingsLabel;
	
	private final JLabel clockSettingsHeaderLabel = new JLabel("Clock Settings");
	private JLabel clockSettingsLabel;
	
	private JLabel tamoStudyProfileHeaderLabel;
	private JLabel tamoStudyProfileLabel;
	
	public ViewCurrentSettingsPanel(Settings settings, Profile tamoStudyProfile) {
		this.settings = settings;
		this.profile = tamoStudyProfile;
		initFrame();
		initComponents();
		setUpGUI();
	}
	
	private void initFrame() {
		this.setVisible(true);
		this.setSize(250,250);
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
	}
	
	private void initComponents() {
		String version = "Version: " + settings.getVersion();
		String studyMode = "Study Mode: " + settings.getStudyMode();
		String fontString = "Font: " + settings.getFontString();
		String backgroundColor = "Background Color (RGB): " +
									settings.getBackgroundColor().getRed() + ", " +
									settings.getBackgroundColor().getGreen() + ", " +
									settings.getBackgroundColor().getBlue();
		String textColor = "Text Color (RGB): " +
									settings.getTextColor().getRed() + ", " +
									settings.getTextColor().getGreen() + ", " +
									settings.getTextColor().getBlue();
		String soundIndicator = "Sound Indicator: " + settings.getSoundName();
		String showWindowAdapter = "Show Exit Message: " + settings.isShowWindowAdapter();
		
		generalSettingsLabel = new JLabel("<html><ul>" +
		        "<li>" + version + "</li>" +             
		        "<li>" + studyMode + "</li>" +   
		        "<li>" + fontString + "</li>" +   
		        "<li>" + backgroundColor + "</li>" +  
		        "<li>" + textColor + "</li>" +  
		        "<li>" + soundIndicator + "</li>" +  
		        "<li>" + showWindowAdapter + "</li>" +  
				"</ul><html>");
		
		String timerBackgroundColor = "Timer Color (RGB): " +
				settings.getTimerBackgroundColor().getRed() + ", " +
				settings.getTimerBackgroundColor().getGreen() + ", " +
				settings.getTimerBackgroundColor().getBlue();
		String timerBorderColor = "Timer Border Color (RGB): " +
				settings.getTimerBorderColor().getRed() + ", " +
				settings.getTimerBorderColor().getGreen() + ", " +
				settings.getTimerBorderColor().getBlue();
		String timerBorderType = "Timer Border Type: " + settings.getBorderType();
		String timerBorderThickness = "Timer Border Thickness: " + settings.getTimerBorderThickness();
		String timerFontSize = "Timer Font Size: " + settings.getTimerFontSize();
		String timerSubFontSize = "Timer Sub Font Size: " + settings.getSessionFontSize();
		
		timerSettingsLabel = new JLabel("<html><ul>" +
		        "<li>" + timerBackgroundColor + "</li>" +             
		        "<li>" + timerBorderColor + "</li>" +   
		        "<li>" + timerBorderType + "</li>" +   
		        "<li>" + timerBorderThickness + "</li>" +  
		        "<li>" + timerFontSize + "</li>" +  
		        "<li>" + timerSubFontSize + "</li>" +   
				"</ul><html>");
		
		tamoStudyProfileHeaderLabel = new JLabel("TamoStudy Profile: " + settings.getTamoStudyProfileString());
		if(settings.getTamoStudyProfileString().equals("null") || this.profile == null) {
			tamoStudyProfileLabel = new JLabel("<html><ul><li>Link a TamoStudy Profile to view details</li></ul></html>");
		} else {
			String tamoTokens = "Tamo Tokens: " + profile.getTamoTokens();
			String totalTime = "Total Time: " + Double.toString(profile.getTotalFocusHours());
			tamoStudyProfileLabel = new JLabel("<html><ul>" +
			        "<li>" + tamoTokens + "</li>" +             
			        "<li>" + totalTime + "</li>" +   
					"</ul><html>");
		}
		
	}
	
	private void setUpGUI() {
		this.add(generalSettingsHeaderLabel);
		this.add(generalSettingsLabel);
		this.add(timerSettingsHeaderLabel);
		this.add(timerSettingsLabel);
		
		//If a TamoStudy profile is linked, add these
		this.add(tamoStudyProfileHeaderLabel);
		this.add(tamoStudyProfileLabel);
	}
	
	
	public void showMessageDialog(JComponent rootPane) {
		JOptionPane.showConfirmDialog(
				rootPane, 
				this, 
				"Current Settings", 
				JOptionPane.PLAIN_MESSAGE,
				1, new ImageIcon(getClass().getClassLoader().getResource("INFO.png"))
			);
	}
}
