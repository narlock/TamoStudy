

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

import javax.swing.Box;
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
import resources.ComponentSetup;
import resources.JFontChooser;
import resources.NormalBorder;
import resources.Settings;
import resources.SettingsReaderWriter;

public class AppearanceChangeGUI extends JFrame {
	private Settings settings;
	private final ComponentSetup componentSetup = new ComponentSetup();
	
	private JPanel settingsPanel; //changing the settings
	private final JLabel previewTextLabel = new JLabel("Preview");
	
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
		this.setTitle("Timer Appearance • TamoStudyStream v0.2");
		this.setIconImage(new ImageIcon(getClass().getClassLoader().getResource("ICON.png")).getImage());
		this.setLayout(new GridLayout(1,2)); //One for left panel, other for right
		this.setSize(750,600);
		
		if(System.getProperty("os.name").startsWith("Mac") || System.getProperty("os.name").startsWith("Windows")) {
			this.setLocationRelativeTo(null);
		}
		
	}
	
	private void initComponents() {
		borderThicknessLabel = new JLabel("Border Thickness ");
		borderTypeLabel = new JLabel("Border Type ");
	}
	
	private void setUpGUI() {
		initSettingsPanel();
		initPreviewPanel();
	}
	
	private void initSettingsPanel() {
		settingsPanel = new JPanel();
		settingsPanel.setBackground(Color.DARK_GRAY);
		settingsPanel.setLayout(new BoxLayout(settingsPanel, BoxLayout.Y_AXIS));
		
		settingsPanel.add(createColorChangePanel(1, "UI Background Color"));
		settingsPanel.add(createColorChangePanel(2, "Border Color"));
		settingsPanel.add(createColorChangePanel(3, "Timer Color"));
		settingsPanel.add(createColorChangePanel(4, "Text Color"));
		
		settingsPanel.add(createFontChangePanel(1, "Time Font"));
		settingsPanel.add(createFontChangePanel(2, "Timer Sub Font"));
		
		settingsPanel.add(createChangeThicknessPanel(borderThicknessLabel));
		settingsPanel.add(createChangeBorderTypePanel(borderTypeLabel));
		
		this.add(settingsPanel);
	}

	private void initPreviewPanel() {
		previewPanel = new JPanel();
		previewPanel.setBackground(settings.getBackgroundColor());
		
		previewPanel.add(createSpaceLabel());
		previewTextLabel.setOpaque(true);
		previewTextLabel.setForeground(Color.BLACK);
		previewTextLabel.setBackground(Color.MAGENTA);
		previewTextLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		previewTextLabel.setBorder(new NormalBorder(Color.BLACK, 3, 10, 10, true));
		previewPanel.add(previewTextLabel);
		previewPanel.add(Box.createVerticalStrut(50));
		
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
		previewPanel.add(Box.createVerticalStrut(300));
		
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

		settings.setTimerBorder(timerStreamPanel);
	}
	
	private JPanel createColorChangePanel(int indicator, String text) {
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setAlignmentX(LEFT_ALIGNMENT);
		
		JButton colorChangeButton = new JButton(text);
		componentSetup.setUpJButton(colorChangeButton);
		colorChangeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Color color = JColorChooser.showDialog(rootPane, "Choose a color", Color.GRAY);
				if(color != null) {
					updateColorSettingsByIndicator(indicator, color);
				}
			}
		});
		panel.add(colorChangeButton);
		
		return panel;
	}
	
	private JPanel createFontChangePanel(int indicator, String text) {
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setAlignmentX(LEFT_ALIGNMENT);
		
		JButton colorChangeButton = new JButton(text);
		componentSetup.setUpJButton(colorChangeButton);
		colorChangeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFontChooser fontChooser = new JFontChooser(settings, indicator);
				int result = fontChooser.showDialog(rootPane);
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
		panel.setAlignmentX(LEFT_ALIGNMENT);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel.add(label);
		
		JLabel thicknessLabel = new JLabel(Long.toString(settings.getTimerBorderThickness()));
		thicknessLabel.setForeground(Color.WHITE);
		thicknessLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JButton decreaseSizeButton = new JButton("-");
		componentSetup.setUpJButton(decreaseSizeButton);
		decreaseSizeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					long newSize = Long.parseLong(thicknessLabel.getText()) - 1;
					settings.setTimerBorderThickness(newSize);
					thicknessLabel.setText(Long.toString(settings.getTimerBorderThickness()));
					updateGUIOnChange();
				} catch (Exception e2) {
					new MessagePanel(rootPane, "You must enter a valid size!\n(Enter an integer!)", "TamoStudyStream", 1);
					if(Integer.parseInt(thicknessLabel.getText()) < 0) {
						settings.setTimerBorderThickness(0);
						thicknessLabel.setText("0");
						updateGUIOnChange();
					}
				}
			}
		});
		JButton increaseSizeButton = new JButton("+");
		componentSetup.setUpJButton(increaseSizeButton);
		increaseSizeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					long newSize = Long.parseLong(thicknessLabel.getText()) + 1;
					settings.setTimerBorderThickness(newSize);
					thicknessLabel.setText(Long.toString(settings.getTimerBorderThickness()));
					updateGUIOnChange();
				} catch (Exception e2) {
					new MessagePanel(rootPane, "You must enter a valid size!\n(Enter an integer!)", "TamoStudyStream", 1);
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
		panel.setAlignmentX(LEFT_ALIGNMENT);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel.add(label);
		
		JComboBox<String> borderTypeBox = new JComboBox<String>();
		componentSetup.setUpJComboBox(borderTypeBox);
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
				settings.setSubFontString(font.getName());
				settings.setSessionFontSize(font.getSize());
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
		button.setOpaque(true);
		
		if(button.getText() == "Start Focus" || button.getText() == "Save Changes")
			button.setBackground(new Color(120,255,120));
		else if(button.getText() == "Break Focus")
			button.setBackground(new Color(255,120,120));
		else
			button.setBackground(Color.WHITE);
		
		button.setFont(new Font("Tahoma", Font.BOLD, 20));
		button.setFocusPainted(false);
		button.setBorder(new RoundedBorder(Color.BLACK, 2, 10, 10, true));
	}
}
