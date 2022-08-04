package panels;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import resources.Settings;
import resources.SettingsReaderWriter;

public class SoundSettingsPanel extends JPanel {
	private Settings settings;
	
	private JComboBox<String> soundsComboBox;
	private JLabel currentSoundLabel;
	private JButton playSoundButton;
	
	private Clip clip;
	private boolean isCollided;
	
	public SoundSettingsPanel(Settings settings) {
		this.settings = settings;
		initFrame();
		initComponents();
		setUpGUI();
	}
	
	private void initFrame() {
		this.setVisible(true);
		this.setSize(250,250);
		this.setLayout(new GridLayout(3,1));
	}
	
	private void initComponents() {
		currentSoundLabel = new JLabel("Current Sound: " + settings.getSoundName());
		isCollided = false;
		
		soundsComboBox = new JComboBox<String>();
		soundsComboBox.addItem("Disabled");
		soundsComboBox.addItem("Soft Alarm");
		soundsComboBox.addItem("Trad Alarm");
		soundsComboBox.addItem("Pac Alarm");
		soundsComboBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				switch((String) soundsComboBox.getSelectedItem()) {
					case "Disabled":
						settings.setSoundIndicator(0);
						updateGUI();
						break;
					case "Soft Alarm":
						settings.setSoundIndicator(1);
						updateGUI();
						break;
					case "Trad Alarm":
						settings.setSoundIndicator(2);
						updateGUI();
						break;
					case "Pac Alarm":
						settings.setSoundIndicator(3);
						updateGUI();
						break;
				}
			}
		});
		soundsComboBox.setSelectedIndex(settings.getSoundIndicator());
		
		playSoundButton = new JButton("▶    Play Sound");
		playSoundButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(isCollided && clip != null) {
					clip.stop();
					isCollided = false;
				}
				if(settings.getSoundIndicator() > 0) {
					try {
						isCollided = true;
						String soundPath = settings.getSoundPath();
						
						URL url = this.getClass().getClassLoader().getResource(soundPath);
						AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
						
						clip = AudioSystem.getClip();
						clip.open(audioIn);
						
						FloatControl volume = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
				        volume.setValue(-1 * 20);
						
						clip.start();
					} catch(Exception e2) {
						e2.printStackTrace();
					}
				}
			}
		});
	}
	
	private void setUpGUI() {
		this.add(currentSoundLabel);
		this.add(soundsComboBox);
		this.add(playSoundButton);
	}
	
	private void updateGUI() {
		SettingsReaderWriter.updateSettingsJson(settings.getJsonObject());
		currentSoundLabel.setText("Current Sound: " + settings.getSoundName());
	}
	
	public void showMessageDialog() {
		int result = JOptionPane.showConfirmDialog(
				null, 
				this, 
				"Sound Settings", 
				JOptionPane.PLAIN_MESSAGE,
				1, new ImageIcon(getClass().getClassLoader().getResource("INFO.png"))
			);
		if(result >= 0 && clip != null) {
			clip.stop();
		}
	}
}
