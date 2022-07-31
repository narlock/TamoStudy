package panels;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import resources.Settings;

public class ViewCurrentSettingsPanel extends JPanel {
	private Settings settings;
	
	private JLabel versionLabel;
	private JLabel studyModeLabel;
	
	private JLabel timerBorderColorLabel;
	private JLabel backgroundColorLabel;
	private JLabel timerBackgroundColorLabel;
	private JLabel textColorLabel;
	
	private JLabel timerFontSizeLabel;
	private JLabel sessionFontSizeLabel;
	
	private JLabel fontLabel;
	private JLabel soundIndicatorLabel;
	
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
		versionLabel = new JLabel("Version: " + settings.getVersion());
		studyModeLabel = new JLabel("Study Mode: " + settings.getStudyMode());
		
		backgroundColorLabel = new JLabel("Background Color (RGB): " +
									settings.getBackgroundColor().getRed() + ", " +
									settings.getBackgroundColor().getGreen() + ", " +
									settings.getBackgroundColor().getBlue()
								);
		timerBorderColorLabel = new JLabel("Timer Border Color (RGB): " + 
									settings.getTimerBorderColor().getRed() + ", " +
									settings.getTimerBorderColor().getGreen() + ", " +
									settings.getTimerBorderColor().getBlue()
								);
		timerBackgroundColorLabel = new JLabel("Timer Background Color (RGB): " +
									settings.getTimerBackgroundColor().getRed() + ", " +
									settings.getTimerBackgroundColor().getGreen() + ", " +
									settings.getTimerBackgroundColor().getBlue()
								);
		textColorLabel = new JLabel("Text Color (RGB): " +
									settings.getTextColor().getRed() + ", " +
									settings.getTextColor().getGreen() + ", " +
									settings.getTextColor().getBlue()
								);
		
		timerFontSizeLabel = new JLabel("Timer Font Size: " + settings.getTimerFontSize());
		sessionFontSizeLabel = new JLabel("Session Font Size: " + settings.getSessionFontSize());
		
		fontLabel = new JLabel("Font: " + settings.getFontString());
		soundIndicatorLabel = new JLabel("Sound Indicator: " + settings.getSoundName());
				
	}
	
	private void setUpGUI() {
		this.add(versionLabel);
		this.add(studyModeLabel);
		this.add(backgroundColorLabel);
		this.add(timerBorderColorLabel);
		this.add(timerBackgroundColorLabel);
		this.add(textColorLabel);
		this.add(timerFontSizeLabel);
		this.add(sessionFontSizeLabel);
		this.add(fontLabel);
		this.add(soundIndicatorLabel);
	}
	
	
	public void showMessageDialog() {
		JOptionPane.showMessageDialog(
				null, 
				this, 
				"Current Settings", 
				JOptionPane.PLAIN_MESSAGE
			);
	}
}
