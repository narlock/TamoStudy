import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.json.simple.parser.ParseException;

import resources.BubbleBorder;
import resources.Settings;
import resources.SettingsReaderWriter;

/**
 * MainGUI
 * @author Anthony Narlock (narlock)
 * @brief The Context and Main Frame of Program
 */

public class MainGUI extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private Settings settings;
	
	private JPanel timerPanel;
	private JPanel timerStreamPanel;
	private JPanel timerTextPanel;
	private JPanel timerSetBoxPanel;
	private JPanel timerButtonPanel;
	
	private JLabel minuteTime, secondTime;
	private JLabel currentSessionLabel;
	
	private JComboBox<String> pomoSessionBox, pomoBreakBox, pomoNumberSessionBox;
	
	private final JLabel spaceLabel = new JLabel(":");
	private JLabel pomoSessionLabel;
	
	private final JButton startFocus = new JButton("Start Focus");
	private final JButton breakFocus = new JButton("Break Focus");
	
	public MainGUI() throws IOException, ParseException {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		settings = SettingsReaderWriter.jsonToSettings();
		initFrame();
		
	}
	
	private void initFrame() {
		addComponentsToFrame();
		this.setVisible(true);
		this.setTitle("TamoStudyStream v1.0");
		this.setIconImage(new ImageIcon(getClass().getClassLoader().getResource("ICON.png")).getImage());
		this.setSize(500,500);
		this.setLocationRelativeTo(null);
	}
	
	private void addComponentsToFrame() {
		initTimerPanel();
		initPomodoroMode();
		this.add(timerPanel);
	}
	
	private void initTimerPanel() {
		timerPanel = new JPanel();
		timerPanel.setLayout(new BoxLayout(timerPanel, BoxLayout.Y_AXIS));
			timerPanel.setBackground(settings.getBackgroundColor());
			
		timerStreamPanel = new JPanel();
			timerStreamPanel.setBackground(settings.getTimerBackgroundColor());
			timerStreamPanel.setLayout(new BoxLayout(timerStreamPanel, BoxLayout.Y_AXIS));
			timerStreamPanel.setBorder(new BubbleBorder(Color.BLACK, 5, 20, 10, true));
			
		timerTextPanel = new JPanel();
			timerTextPanel.setBackground(settings.getTimerBackgroundColor());
			timerTextPanel.setLayout(new BoxLayout(timerTextPanel, BoxLayout.X_AXIS));
		
		minuteTime = new JLabel("00");
			minuteTime.setForeground(settings.getTextColor());
		minuteTime.setFont(settings.getFont());
		
		spaceLabel.setForeground(settings.getTextColor());
		spaceLabel.setFont(new Font ("Arial", Font.BOLD, 96));
		
		secondTime = new JLabel("00");
			secondTime.setForeground(settings.getTextColor());
		secondTime.setFont(settings.getFont());
		
		timerTextPanel.add(minuteTime);
		timerTextPanel.add(spaceLabel);
		timerTextPanel.add(secondTime);
		
		timerStreamPanel.add(timerTextPanel);
	}
	
	private void initPomodoroMode() {
		currentSessionLabel = new JLabel("Let's Focus!");
		currentSessionLabel.setForeground(settings.getTextColor());
		currentSessionLabel.setFont(new Font ("Tahoma", Font.BOLD, 25));
		currentSessionLabel.setAlignmentX(JComponent.CENTER_ALIGNMENT);
		timerStreamPanel.add(currentSessionLabel);
		
		timerPanel.add(timerStreamPanel);
		
		timerSetBoxPanel = new JPanel();
			timerSetBoxPanel.setBackground(settings.getBackgroundColor());
			
		pomoSessionLabel = new JLabel("# of Sessions" + "     " 
				+ "Session Length" + "     " 
				+ "Break Length");
		pomoSessionLabel.setForeground(settings.getTextColor());
		pomoSessionLabel.setAlignmentX(JComponent.CENTER_ALIGNMENT);
	
		timerPanel.add(pomoSessionLabel);

		//Set Boxes
		pomoNumberSessionBox = new JComboBox();
		pomoSessionBox = new JComboBox();
		pomoBreakBox = new JComboBox();
		
		timerSetBoxPanel.add(pomoNumberSessionBox);
		timerSetBoxPanel.add(pomoSessionBox);
		timerSetBoxPanel.add(pomoBreakBox);
		
		timerPanel.add(timerSetBoxPanel);
		
		pomoSessionBox.addItem("01:00");
		pomoBreakBox.addItem("01:00");
		
		for(int i = 5; i <= 90; i = i + 5) {
			if(i == 5) {
				pomoSessionBox.addItem("0" + i + ":00");
				pomoBreakBox.addItem("0" + i + ":00");
			}
			else {
				pomoSessionBox.addItem(i + ":00");
				pomoBreakBox.addItem(i + ":00");
			}
		}
		
		for(int i = 1; i <= 16; i++) {
			pomoNumberSessionBox.addItem(String.valueOf(i));
		}
		
		pomoSessionBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				minuteTime.setText(""+pomoSessionBox.getSelectedItem());
				minuteTime.setText(minuteTime.getText().substring(0,2));
			}
		});
	}
	
	protected JLabel createSpaceLabel() {
		JLabel transparentComponent = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("TRANSPARENT.png")));
		transparentComponent.setAlignmentX(JComponent.CENTER_ALIGNMENT);
		return transparentComponent;
	}
	
	private void updateGUI() {
		
	}
}
