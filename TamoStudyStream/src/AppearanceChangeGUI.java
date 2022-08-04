

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;

import panels.MessagePanel;
import resources.RoundedBorder;
import resources.JFontChooser;
import resources.Settings;
import resources.SettingsReaderWriter;

public class AppearanceChangeGUI extends JFrame {
	private Settings settings;
	
	private JPanel settingsPanel; //changing the settings
	private final JLabel previewTextLabel = new JLabel("Preview");
	
	private JLabel timerBorderColorLabel;
	private JLabel backgroundColorLabel;
	private JLabel timerBackgroundColorLabel;
	private JLabel textColorLabel;
	private JLabel timerFontSizeLabel;
	private JLabel sessionFontSizeLabel;
	private JLabel fontLabel;
	private JLabel borderThicknessLabel;
	private JLabel borderTypeLabel;
	
	private JPanel previewPanel; //the timer panel right hand side
	private JPanel timerStreamPanel;
	private JPanel timerTextPanel;
	private JLabel minuteTime, secondTime, spaceLabel;
	private JLabel currentSessionLabel;
	private final JButton saveChangesButton = new JButton("Save Changes");
	
	public AppearanceChangeGUI(Settings settings) {
		this.settings = settings;
		initFrame();
		setUpGUI();
	}
	
	private void initFrame() {
		initComponents();
		
		//Custom window close option
		//When the window is closed, the mainGUI will be opened
		WindowListener exitListener = new WindowAdapter() {
		    @Override
		    public void windowClosing(WindowEvent e) {
		    	MainGUI gui = new MainGUI();
		    	hideWindow();
		    }
		};
		this.addWindowListener(exitListener);
		this.setVisible(true);
		this.setResizable(false);
		this.setTitle("Appearance - TamoStudyStream v0.1");
		this.setIconImage(new ImageIcon(getClass().getClassLoader().getResource("ICON.png")).getImage());
		this.setLayout(new GridLayout(1,2)); //One for left panel, other for right
		this.setSize(700,500);
		this.setLocationRelativeTo(null);
	}
	
	private void initComponents() {
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
		
		fontLabel = new JLabel("Timer Font: " + settings.getFontString() + ", size: " + settings.getTimerFontSize());
		sessionFontSizeLabel = new JLabel("Timer Font: " + settings.getFontString() + ", size: " + settings.getSessionFontSize());
	
		borderThicknessLabel = new JLabel("Border Thickness: ");
		borderTypeLabel = new JLabel("Border Type: ");
	}
	
	private void setUpGUI() {
		initSettingsPanel();
		initPreviewPanel();
	}
	
	private void initSettingsPanel() {
		settingsPanel = new JPanel();
		settingsPanel.setBackground(Color.DARK_GRAY);
		settingsPanel.setLayout(new BoxLayout(settingsPanel, BoxLayout.Y_AXIS));
		
		settingsPanel.add(createColorChangePanel(backgroundColorLabel, 1));
		settingsPanel.add(createColorChangePanel(timerBorderColorLabel, 2));
		settingsPanel.add(createColorChangePanel(timerBackgroundColorLabel, 3));
		settingsPanel.add(createColorChangePanel(textColorLabel, 4));
		
		settingsPanel.add(createFontChangePanel(fontLabel, 1));
		settingsPanel.add(createFontChangePanel(sessionFontSizeLabel, 2));
		
		settingsPanel.add(createChangeThicknessPanel(borderThicknessLabel));
		settingsPanel.add(createChangeBorderTypePanel(borderTypeLabel));
		
		this.add(settingsPanel);
	}

	private void initPreviewPanel() {
		previewPanel = new JPanel();
		previewPanel.setBackground(settings.getBackgroundColor());
		
		previewPanel.add(createSpaceLabel());
		previewTextLabel.setForeground(settings.getTextColor());
		previewTextLabel.setFont(settings.getSessionFont());
		previewPanel.add(previewTextLabel);
		
		timerStreamPanel = new JPanel();
		timerStreamPanel.setBackground(settings.getTimerBackgroundColor());
		timerStreamPanel.setLayout(new BoxLayout(timerStreamPanel, BoxLayout.Y_AXIS));
		settings.setTimerBorder(timerStreamPanel);
		
		timerTextPanel = new JPanel();
			timerTextPanel.setBackground(settings.getTimerBackgroundColor());
			timerTextPanel.setLayout(new BoxLayout(timerTextPanel, BoxLayout.X_AXIS));
		
		minuteTime = new JLabel("00");
			minuteTime.setForeground(settings.getTextColor());
		minuteTime.setFont(settings.getFont());
		
		spaceLabel = new JLabel(":");
		spaceLabel.setForeground(settings.getTextColor());
		spaceLabel.setFont(settings.getFont());
		
		secondTime = new JLabel("00");
			secondTime.setForeground(settings.getTextColor());
		secondTime.setFont(settings.getFont());
		
		timerTextPanel.add(minuteTime);
		timerTextPanel.add(spaceLabel);
		timerTextPanel.add(secondTime);
		
		timerStreamPanel.add(timerTextPanel);
		
		currentSessionLabel = new JLabel("Let's Focus!");
		currentSessionLabel.setForeground(settings.getTextColor());
		currentSessionLabel.setFont(settings.getSessionFont());
		currentSessionLabel.setAlignmentX(JComponent.CENTER_ALIGNMENT);
		timerStreamPanel.add(currentSessionLabel);
		
		previewPanel.add(timerStreamPanel);
		
		setUpJButton(saveChangesButton);
		saveChangesButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MainGUI gui = new MainGUI();
				hideWindow();
			}
		});
		previewPanel.add(saveChangesButton, BorderLayout.SOUTH);
		
		this.add(previewPanel);
	}
	
	private void updateGUIOnChange() {
		//Settings
		SettingsReaderWriter.updateSettingsJson(settings.getJsonObject());
		
		//Text
		backgroundColorLabel.setText("Background Color (RGB): " +
				settings.getBackgroundColor().getRed() + ", " +
				settings.getBackgroundColor().getGreen() + ", " +
				settings.getBackgroundColor().getBlue()
			);
		timerBorderColorLabel.setText("Timer Border Color (RGB): " + 
						settings.getTimerBorderColor().getRed() + ", " +
						settings.getTimerBorderColor().getGreen() + ", " +
						settings.getTimerBorderColor().getBlue()
					);
		timerBackgroundColorLabel.setText("Timer Background Color (RGB): " +
						settings.getTimerBackgroundColor().getRed() + ", " +
						settings.getTimerBackgroundColor().getGreen() + ", " +
						settings.getTimerBackgroundColor().getBlue()
					);
		textColorLabel.setText("Text Color (RGB): " +
						settings.getTextColor().getRed() + ", " +
						settings.getTextColor().getGreen() + ", " +
						settings.getTextColor().getBlue()
					);
		timerFontSizeLabel.setText("Timer Font Size: " + settings.getTimerFontSize());
		sessionFontSizeLabel.setText("Session Font Size: " + settings.getSessionFontSize());
		
		//Visual
		previewPanel.setBackground(settings.getBackgroundColor());
		timerStreamPanel.setBackground(settings.getTimerBackgroundColor());
		settings.setTimerBorder(timerStreamPanel);
		timerTextPanel.setBackground(settings.getTimerBackgroundColor());
		minuteTime.setForeground(settings.getTextColor());
		minuteTime.setFont(settings.getFont());
		spaceLabel.setForeground(settings.getTextColor());
		spaceLabel.setFont(settings.getFont());
		secondTime.setForeground(settings.getTextColor());
		secondTime.setFont(settings.getFont());
		currentSessionLabel.setForeground(settings.getTextColor());
		currentSessionLabel.setFont(settings.getSessionFont());
		previewTextLabel.setForeground(settings.getTextColor());
		previewTextLabel.setFont(settings.getSessionFont());
		
		fontLabel.setText("Timer Font: " + settings.getFontString() + ", size: " + settings.getTimerFontSize());
		sessionFontSizeLabel.setText("Timer Font: " + settings.getFontString() + ", size: " + settings.getSessionFontSize());
		settings.setTimerBorder(timerStreamPanel);
	}
	
	private JPanel createColorChangePanel(JLabel label, int indicator) {
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		label.setForeground(Color.WHITE);
		panel.add(label);
		
		JButton colorChangeButton = new JButton("Edit");
		colorChangeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Color color = JColorChooser.showDialog(null, "Choose a color", Color.GRAY);
				if(color != null) {
					updateColorSettingsByIndicator(indicator, color);
				}
			}
		});
		panel.add(colorChangeButton);
		
		return panel;
	}
	
	private JPanel createFontChangePanel(JLabel label, int indicator) {
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		label.setForeground(Color.WHITE);
		panel.add(label);
		
		JButton colorChangeButton = new JButton("Edit");
		colorChangeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFontChooser fontChooser = new JFontChooser();
				int result = fontChooser.showDialog(null);
				if(result == JFontChooser.OK_OPTION) {
					updateFontSettingsByIndicator(indicator, fontChooser.getSelectedFont());
				}
			}
		});
		panel.add(colorChangeButton);
		
		return panel;
	}
	
	private JPanel createChangeThicknessPanel(JLabel label) {
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		label.setForeground(Color.WHITE);
		panel.add(label);
		
		JLabel thicknessLabel = new JLabel(Long.toString(settings.getTimerBorderThickness()));
		thicknessLabel.setForeground(Color.WHITE);
		
		JButton decreaseSizeButton = new JButton("-");
		decreaseSizeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					long newSize = Long.parseLong(thicknessLabel.getText()) - 1;
					settings.setTimerBorderThickness(newSize);
					thicknessLabel.setText(Long.toString(settings.getTimerBorderThickness()));
					updateGUIOnChange();
				} catch (Exception e2) {
					new MessagePanel(panel, "You must enter a valid size!\n(Enter an integer!)", "TamoStudyStream", 1);
				}
			}
		});
		JButton increaseSizeButton = new JButton("+");
		increaseSizeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					long newSize = Long.parseLong(thicknessLabel.getText()) + 1;
					settings.setTimerBorderThickness(newSize);
					thicknessLabel.setText(Long.toString(settings.getTimerBorderThickness()));
					updateGUIOnChange();
				} catch (Exception e2) {
					new MessagePanel(panel, "You must enter a valid size!\n(Enter an integer!)", "TamoStudyStream", 1);
				}
			}
		});
		panel.add(decreaseSizeButton);
		panel.add(thicknessLabel);
		panel.add(increaseSizeButton);
		
		return panel;
	}
	
	private JPanel createChangeBorderTypePanel(JLabel label) {
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		label.setForeground(Color.WHITE);
		panel.add(label);
		
		JComboBox<String> borderTypeBox = new JComboBox<String>();
		borderTypeBox.addItem("Rounded");
		borderTypeBox.addItem("Rectangluar");
		
		if(settings.getBorderType().equals("Rounded")) {
			borderTypeBox.setSelectedIndex(0);
		} else {
			borderTypeBox.setSelectedIndex(1);
		}
		
		borderTypeBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				settings.setBorderType((String) borderTypeBox.getSelectedItem());
				settings.setTimerBorder(timerStreamPanel);
				updateGUIOnChange();
			}
		});
		panel.add(borderTypeBox);
		
		return panel;
	}
	
	private boolean updateColorSettingsByIndicator(int indicator, Color color) {
		switch(indicator) {
			case 1:
				settings.setBackgroundColor(color);
				updateGUIOnChange();
				return true;
			case 2:
				settings.setTimerBorderColor(color);
				updateGUIOnChange();
				return true;
			case 3:
				settings.setTimerBackgroundColor(color);
				updateGUIOnChange();
				return true;
			case 4:
				settings.setTextColor(color);
				updateGUIOnChange();
				return true;
			}
		return false;
	}
	
	private boolean updateFontSettingsByIndicator(int indicator, Font font) {
		switch(indicator) {
			case 1:
				settings.setFont(font);
				settings.setFontString(font.getName());
				settings.setTimerFontSize(font.getSize());
				updateGUIOnChange();
				return true;
			case 2:
				settings.setSessionFont(font);
				settings.setFontString(font.getName());
				settings.setTimerFontSize(font.getSize());
				updateGUIOnChange();
				return true;
			}
		return false;
	}
	
	/*
	 * Method hides the main windows and disposes it
	 */
	public void hideWindow() {
		this.setVisible(false);
		this.dispose();
	}
	
	protected JLabel createSpaceLabel() {
		JLabel transparentComponent = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("TRANSPARENT.png")));
		transparentComponent.setAlignmentX(JComponent.CENTER_ALIGNMENT);
		return transparentComponent;
	}
	
	private void setUpJButton(JButton button) {
		if(System.getProperty("os.name").startsWith("Linux") || System.getProperty("os.name").startsWith("Windows")) {
			if(button.getText() == "Start Focus" || button.getText() == "Save Changes")
				button.setBackground(new Color(120,255,120));
			else if(button.getText() == "Break Focus")
				button.setBackground(new Color(255,120,120));
			else
				button.setBackground(Color.WHITE);
		}
			
		button.setFont(settings.getSessionFont());
		button.setFocusPainted(false);
		button.setBorder(new RoundedBorder(Color.BLACK, 2, 10, 10, true));
	}
}
