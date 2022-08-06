package panels;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import resources.Settings;

public class ViewCurrentSettingsPanel extends JPanel {
	private Settings settings;
	
	private final JLabel generalSettingsHeaderLabel = new JLabel("General Settings");
	private JLabel generalSettingsLabel;
	
	private JLabel timerSettingsHeaderLabel = new JLabel("Timer Settings");
	private JLabel timerSettingsLabel;
	
	private final JLabel clockSettingsHeaderLabel = new JLabel("Clock Settings");
	private JLabel clockSettingsLabel;
	
	public ViewCurrentSettingsPanel(Settings settings) {
		this.settings = settings;
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
		String tamoStudyProfileString = "TamoStudy Profile Path: " + settings.getTamoStudyProfileString();
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
		        "<li>" + tamoStudyProfileString + "</li>" +  
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
		
		
//		timerBorderColorLabel = new JLabel("Timer Border Color (RGB): " + 
//									settings.getTimerBorderColor().getRed() + ", " +
//									settings.getTimerBorderColor().getGreen() + ", " +
//									settings.getTimerBorderColor().getBlue()
//								);
//		timerBackgroundColorLabel = new JLabel("Timer Background Color (RGB): " +
//									settings.getTimerBackgroundColor().getRed() + ", " +
//									settings.getTimerBackgroundColor().getGreen() + ", " +
//									settings.getTimerBackgroundColor().getBlue()
//								);
//		
//		timerFontSizeLabel = new JLabel("Timer Font Size: " + settings.getTimerFontSize());
//		sessionFontSizeLabel = new JLabel("Session Font Size: " + settings.getSessionFontSize());
//		fontLabel = new JLabel("Font: " + settings.getFontString());
		
	}
	
	private void setUpGUI() {
		this.add(generalSettingsHeaderLabel);
		this.add(generalSettingsLabel);
		this.add(timerSettingsHeaderLabel);
		this.add(timerSettingsLabel);
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
