import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.WindowConstants;

import org.json.simple.parser.ParseException;

import panels.GuidePanel;
import panels.MessagePanel;
import panels.SoundSettingsPanel;
import panels.ViewCurrentSettingsPanel;
import resources.ComponentSetup;
import resources.RoundedBorder;
import resources.Settings;
import resources.SettingsReaderWriter;
import tamostudy.Profile;
import tamostudy.ProfileReaderWriter;

/**
 * MainGUI
 * @author Anthony Narlock (narlock)
 * @brief The Context and Main Frame of Program
 */

public class MainGUI extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private Settings settings;
	private final ComponentSetup componentSetup = new ComponentSetup();
	
	/**
	 * UI Components
	 */
	private JMenuBar menuBar;
	private JMenu fileMenu;
	private JMenuItem linkTamoStudyProfileMenuItem;
	private JMenuItem viewCurrentSettingsMenuItem;
	private JMenuItem exportSettingsFileMenuItem;
	private JMenuItem importSettingsFileMenuItem;
	private JMenuItem resetSettingsMenuItem;
	
	private JMenu customizationMenu;
	private JMenuItem appearanceOptionsMenuItem;
	private JMenuItem soundOptionsMenuItem;
	private JMenuItem studyOptionsMenuItem;
	private JMenuItem clockOptionsMenuItem;
	
	private JMenu helpMenu;
	private JMenuItem howToUseMenuItem;
	
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
	
	/**
	 * Timer Components
	 */
	private Timer timer;
	private int min, sec, tempSec, tempMin;
	private int currentPomodoroSession, totalPomodoroSessions;
	private boolean breakCondition;
	private Profile tamoStudyProfile;
	private boolean linkedTamoProfile;
	
	public MainGUI() {
		//Read Settings File
		try {
			settings = SettingsReaderWriter.getSettings();
		} catch (IOException e) {
			new MessagePanel(rootPane, "TamoStudyStream", "An unexpected error occurred"
					+ "\n\"" + e.getMessage() + "\"", 1);
			e.printStackTrace();
		} catch (ParseException e) {
			new MessagePanel(rootPane, "TamoStudyStream", "An unexpected error occurred"
					+ "\n\"" + e.getMessage() + "\"", 1);
			e.printStackTrace();
		}
		
		//Check Window Adapter Setting
		if(settings.isShowWindowAdapter()) {
			this.addWindowListener(makeExitWindowListener());
			this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		} else {
			this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		}
		
		initFrame();
		
		//Check TamoStudy Profile Setting
		if(settings.getTamoStudyProfileString().equals("null")) {
			linkedTamoProfile = false;
		} else {
			try {
				tamoStudyProfile = ProfileReaderWriter.getProfileInfoFromFile(new File(settings.getTamoStudyProfileString()));
				linkedTamoProfile = true;
				System.out.println("Successfully loaded TamoStudy profile\n" + tamoStudyProfile.toString());
			} catch (Exception e1) {
				//Profile file is invalid
				new MessagePanel(rootPane, "The linked TamoStudy profile file is either missing or invalid.", "Error - TamoStudyStream", 1);
				settings.setTamoStudyProfileString("null");
				SettingsReaderWriter.updateSettingsJson(settings.getJsonObject());
				linkedTamoProfile = false;
			}
		}
	}
	
	private void initFrame() {
		addComponentsToFrame();
		this.setVisible(true);
		this.setResizable(false);
		this.setTitle("TamoStudyStream v0.1");
		this.setIconImage(new ImageIcon(getClass().getClassLoader().getResource("ICON.png")).getImage());
		this.setSize(500,500);
		this.setLocationRelativeTo(null);
	}
	
	private void addComponentsToFrame() {
		initMenu();
		initTimerPanel();
		initPomodoroMode();
		initButtonPanel();
		initTimerActions();
		this.add(timerPanel);
	}
	
	/**
	 * User interface methods
	 */
	
	private void initMenu() {
		menuBar = new JMenuBar();
		
		fileMenu = new JMenu("File");
		linkTamoStudyProfileMenuItem = new JMenuItem("Link TamoStudy Profile");
		linkTamoStudyProfileMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				File tamoStudyFile;
				if(fileChooser.showOpenDialog(rootPane) == JFileChooser.APPROVE_OPTION) {
					tamoStudyFile = fileChooser.getSelectedFile();
					
					try {
						settings.setTamoStudyProfileString(tamoStudyFile.getAbsolutePath());
						tamoStudyProfile = ProfileReaderWriter.getProfileInfoFromFile(new File(settings.getTamoStudyProfileString()));
						SettingsReaderWriter.updateSettingsJson(settings.getJsonObject());
						if(tamoStudyProfile.getUsername() == null) {
							throw new Exception();
						}
						linkedTamoProfile = true;
					} catch (Exception e1) {
						new MessagePanel(rootPane, "Invalid TamoStudy Profile file.", "Error - TamoStudyStream", 1);
						settings.setTamoStudyProfileString("null");
						SettingsReaderWriter.updateSettingsJson(settings.getJsonObject());
						linkedTamoProfile = false;
					}
				}
			}
		});
		viewCurrentSettingsMenuItem = new JMenuItem("View Current Settings");
			viewCurrentSettingsMenuItem.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					ViewCurrentSettingsPanel pane = new ViewCurrentSettingsPanel(settings, tamoStudyProfile);
					pane.showMessageDialog(rootPane);
				}
			});
		importSettingsFileMenuItem = new JMenuItem("Import Settings");
		importSettingsFileMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				int result = fileChooser.showOpenDialog(rootPane);
				if (result == JFileChooser.APPROVE_OPTION) {
					File selectedFile = fileChooser.getSelectedFile();
					if(SettingsReaderWriter.importSettingsFromJsonFile(selectedFile)) {
						new MessagePanel(rootPane, "Settings Successfully Imported", "TamoStudyStream", 0);
						MainGUI gui = new MainGUI();
						hideWindow();
					} else {
						new MessagePanel(rootPane, "Settings Unsuccessfully Imported\nPlease use valid settings.json file.", "TamoStudyStream", 1);
					}
				}
			}
		});
		exportSettingsFileMenuItem = new JMenuItem("Export Settings");
		exportSettingsFileMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				final JFileChooser SaveAs = new JFileChooser();
				int actionDialog = SaveAs.showSaveDialog(rootPane);
				if(actionDialog == JFileChooser.APPROVE_OPTION) { 
					File file = new File(SaveAs.getSelectedFile() + ".json");
					FileWriter fileWriter = null;
					try {
						fileWriter = new FileWriter(file);
						fileWriter.write(settings.getJsonObject().toJSONString());
			        } catch (IOException e4) {
			            new MessagePanel(rootPane, "IOException when exporting settings", "Error - TamoStudyStream", 1);
			        } finally {
			            try {
			                fileWriter.flush();
			                fileWriter.close();
			                new MessagePanel(rootPane, "Settings Successfully Exported", "TamoStudyStream", 0);
			            } catch (IOException e5) {
			            	new MessagePanel(rootPane, "IOException when exporting settings", "Error - TamoStudyStream", 1);
			            }
			        }
				}
			}
		});
		resetSettingsMenuItem = new JMenuItem("Reset Settings");
		resetSettingsMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JPanel panel = new JPanel();
		    	panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		    	JLabel label = new JLabel("By confirming, your settings will be set to defaults.");
		    	label.setAlignmentX(JComponent.CENTER_ALIGNMENT);
		    	JLabel confirmLabel = new JLabel("Are you sure you want to reset to default settings?");
		    	confirmLabel.setAlignmentX(JComponent.CENTER_ALIGNMENT);
		    	
		    	panel.add(label);
		    	panel.add(confirmLabel);
		    	
		    	int confirm = JOptionPane.showOptionDialog(
		                rootPane, 
		                panel, 
		                "Reset TamoStudyStream Settings", 
		                JOptionPane.YES_NO_OPTION, 
		                JOptionPane.QUESTION_MESSAGE, 
		                new ImageIcon(getClass().getClassLoader().getResource("INFO.png")), 
		                null, 
		                null);
	           if (confirm == JOptionPane.YES_OPTION) {
	        	  SettingsReaderWriter.updateSettingsJson(new Settings().getJsonObject());
	        	  MainGUI gui = new MainGUI();
	        	  hideWindow();
	           }
			}
		});
		fileMenu.add(linkTamoStudyProfileMenuItem);
		fileMenu.add(viewCurrentSettingsMenuItem);
		fileMenu.add(importSettingsFileMenuItem);
		fileMenu.add(exportSettingsFileMenuItem);
		fileMenu.add(resetSettingsMenuItem);
		menuBar.add(fileMenu);
		
		customizationMenu = new JMenu("Customize");
		appearanceOptionsMenuItem = new JMenuItem("Timer Appearance Options");
		appearanceOptionsMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				AppearanceChangeGUI change = new AppearanceChangeGUI(settings);
				hideWindow();
			}
		});
		clockOptionsMenuItem = new JMenuItem("Clock Appearance Options");
		clockOptionsMenuItem.setEnabled(false);
		soundOptionsMenuItem = new JMenuItem("Sound Options");
		soundOptionsMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SoundSettingsPanel ssp = new SoundSettingsPanel(settings);
				ssp.showMessageDialog(rootPane);
			}
		});
		studyOptionsMenuItem = new JMenuItem("Study Options");
		studyOptionsMenuItem.setEnabled(false);
		customizationMenu.add(soundOptionsMenuItem);
		customizationMenu.add(appearanceOptionsMenuItem);
		customizationMenu.add(clockOptionsMenuItem);
		customizationMenu.add(studyOptionsMenuItem);
		menuBar.add(customizationMenu);
		
		helpMenu = new JMenu("Help");
		howToUseMenuItem = new JMenuItem("Guide");
		howToUseMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				GuidePanel gp = new GuidePanel();
				gp.showMessageDialog(rootPane);
			}
		});
		helpMenu.add(howToUseMenuItem);
		menuBar.add(helpMenu);
		
		this.add(menuBar, BorderLayout.NORTH);
	}
	
	private void initTimerPanel() {
		timerPanel = new JPanel();
		timerPanel.setLayout(new BoxLayout(timerPanel, BoxLayout.Y_AXIS));
			timerPanel.setBackground(settings.getBackgroundColor());
			
		timerPanel.add(componentSetup.createSpaceLabel()); //Adds space between menu and timer
			
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
		
		spaceLabel.setForeground(settings.getTextColor());
		spaceLabel.setFont(settings.getFont());
		
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
		currentSessionLabel.setFont(settings.getSessionFont());
		currentSessionLabel.setAlignmentX(JComponent.CENTER_ALIGNMENT);
		timerStreamPanel.add(currentSessionLabel);
		
		timerPanel.add(timerStreamPanel);
		
		timerSetBoxPanel = new JPanel();
			timerSetBoxPanel.setBackground(settings.getBackgroundColor());
			
		pomoSessionLabel = new JLabel("# of Sessions" + "     " 
				+ "Session Length" + "     " 
				+ "Break Length");
		pomoSessionLabel.setForeground(settings.getTextColor());
		pomoSessionLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		pomoSessionLabel.setAlignmentX(JComponent.CENTER_ALIGNMENT);
	
		timerPanel.add(componentSetup.createSpaceLabel()); //Adds space between timer and setup
		timerPanel.add(pomoSessionLabel);

		//Set Boxes
		pomoNumberSessionBox = new JComboBox();
			componentSetup.setUpJComboBox(pomoNumberSessionBox);
		pomoSessionBox = new JComboBox();
			componentSetup.setUpJComboBox(pomoSessionBox);
		pomoBreakBox = new JComboBox();
			componentSetup.setUpJComboBox(pomoBreakBox);
		
		timerSetBoxPanel.add(Box.createHorizontalStrut(40));
		timerSetBoxPanel.add(pomoNumberSessionBox);
		timerSetBoxPanel.add(Box.createHorizontalStrut(60));
		timerSetBoxPanel.add(pomoSessionBox);
		timerSetBoxPanel.add(Box.createHorizontalStrut(60));
		timerSetBoxPanel.add(pomoBreakBox);
		timerSetBoxPanel.add(Box.createHorizontalStrut(20));
		
		timerPanel.add(timerSetBoxPanel);
		
		pomoSessionBox.addItem("01:00");
		pomoBreakBox.addItem("01:00");
		
	}
	
	private void initButtonPanel() {
		timerButtonPanel = new JPanel();
			timerButtonPanel.setBackground(settings.getBackgroundColor());
		timerButtonPanel.add(startFocus);
			componentSetup.setUpJButton(startFocus);
		timerButtonPanel.add(breakFocus);
			componentSetup.setUpJButton(breakFocus);
		timerPanel.add(timerButtonPanel);
	}
	
	/**
	 * Timer action methods
	 */
	
	private void initTimerActions() {
		//These are only for pomodoro study mode
		//will need to add if/else branch for other settings
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
		
		//study component functions
		breakFocus.setEnabled(false);
		breakFocus.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String studyMessage = "You studied for " + tempMin + " minute(s) and " + tempSec + " second(s).";
				resetTimer();
				timer.stop();
				JOptionPane.showMessageDialog(rootPane, studyMessage, "Session Focus Broke", JOptionPane.INFORMATION_MESSAGE,  new ImageIcon(getClass().getClassLoader().getResource("INFO.png")));
			}
			
		});
		
		//Start Button
		startFocus.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//Update Timer Information
				updateTimerInformation();
				
				//Set Information, TamoImage, study/Temp Min/Sec
				setFocusInformation();
				
				//Disable Buttons
				disableFocusButtons();
				
				//Create Timer
				createTimer();
			}
			
		});
	}
	
	//Step 1 - Update Timer Information
	private void updateTimerInformation() {
		//pomodoro
		totalPomodoroSessions = pomoNumberSessionBox.getSelectedIndex();
		System.out.println("pomoSessions: " + totalPomodoroSessions);
		minuteTime.setText(""+pomoSessionBox.getSelectedItem());
		minuteTime.setText(minuteTime.getText().substring(0,2));
		
		min = Integer.parseInt(minuteTime.getText());
		sec = Integer.parseInt(secondTime.getText());
	}
	
	//Step 2 - Set Information, TamoImage, etc.
	private void setFocusInformation() {
		//Pomodoro sets the time information
		setCurrentSession();
		
		//Initialize other values
		tempSec = -1;
		tempMin = 0;
	}
	
	//Step 3 - Disable Buttons
	public void disableFocusButtons() {
		//Disable Focus Components
		pomoNumberSessionBox.setEnabled(false);
		pomoSessionBox.setEnabled(false);
		pomoBreakBox.setEnabled(false);

		startFocus.setEnabled(false);
		breakFocus.setEnabled(true);
	}
	
	//Step 4 - Create Timer
	public void createTimer() {
		timer = new Timer(1000, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//Set how long studied for variables
				tempSec = tempSec + 1;
				if(tempSec == 60) {
					tempMin = tempMin + 1;
					tempSec = 0;
				}
				
				if(sec == 0) {
					sec = 60;
					min--;
				}
				
				if(min < 0) {
					
					updateTamoTokensToTamoStudyProfile(tempMin, tempSec);
					String studyMessage = "You studied for " + tempMin + " minute(s) and " + tempSec + " second(s).";
					
					tempMin = 0;
					tempSec = 0;

					//If sounds are enabled
					if(settings.getSoundIndicator() >= 1) {
					
						try {
							//Get the url for the sound clip
							String soundPath = settings.getSoundPath();
							
							URL url = this.getClass().getClassLoader().getResource(soundPath);
							AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
							
							//get the clip from the url
							Clip clip = AudioSystem.getClip();
							clip.open(audioIn);
							
							//volume control - make the sound quieter
							FloatControl volume = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
					        volume.setValue(-1 * 20);
							
					        //start and loop the clip
							clip.start();
							clip.loop(Clip.LOOP_CONTINUOUSLY);
							
							//loop will end when user hits ok dialog
							JOptionPane.showMessageDialog(rootPane, studyMessage, "Session Completed", JOptionPane.INFORMATION_MESSAGE,  new ImageIcon(getClass().getClassLoader().getResource("INFO.png")));
							clip.stop();
							
						} catch (Exception ex2) {
							ex2.printStackTrace();
						}
					
					} else {
						JOptionPane.showMessageDialog(rootPane, studyMessage, "Session Completed", JOptionPane.INFORMATION_MESSAGE,  new ImageIcon(getClass().getClassLoader().getResource("INFO.png")));
						
					}
					//JOptionPane.showMessageDialog(rootPane, studyMessage, "Session Complete", JOptionPane.INFORMATION_MESSAGE,  new ImageIcon(getClass().getClassLoader().getResource("INFO.png")));
					//Display Completed message, in the future, it will do a calculation to show amount of points earned in the session
					
					if(totalPomodoroSessions != 0) {
						System.out.println("pomoSessionNumber: " + totalPomodoroSessions);
						nextSession();
						setCurrentSession();
					} else {
						resetTimer();
						timer.stop();
					}
				} 
				else {
					sec--;
					if(sec < 10) {
						secondTime.setText("0" + sec);
					}
					else {
						secondTime.setText("" + sec);
					}
					if(min < 10) {
						minuteTime.setText("0" + min);
					}
					else {
						minuteTime.setText("" + min);
					}
				}
				
			}
			
		});
		timer.start();
	}
	
	//Resets the timer
	//Called either when 'Break' is clicked or end of regular session
	public void resetTimer() {
		currentSessionLabel.setText("Let's Focus!");
		
		minuteTime.setText("00");
		secondTime.setText("00");
		
		pomoNumberSessionBox.setEnabled(true);
		pomoSessionBox.setEnabled(true);
		pomoBreakBox.setEnabled(true);
		
		//Enable focus/break buttons
		startFocus.setEnabled(true);
		breakFocus.setEnabled(false);
	}
	
	//Indicates next session of Pomodoro Mode
	public void nextSession() {
		if(breakCondition == false) {
			//Start Break Timer
			minuteTime.setText(""+pomoBreakBox.getSelectedItem());
			minuteTime.setText(minuteTime.getText().substring(0,2));
			min = Integer.parseInt(minuteTime.getText());
			sec = Integer.parseInt(secondTime.getText());
			breakCondition = true;
			
			startFocus.doClick();
		}
		else {
			//End Break Timer, begin next session timer
			minuteTime.setText(""+pomoSessionBox.getSelectedItem());
			minuteTime.setText(minuteTime.getText().substring(0,2));
			min = Integer.parseInt(minuteTime.getText());
			sec = Integer.parseInt(secondTime.getText());
			breakCondition = false;
			this.totalPomodoroSessions--;
			
			startFocus.doClick();
		}
	}
	
	//Sets the current session in Pomodoro Mode
	public void setCurrentSession() {
		if(breakCondition) {
			currentSessionLabel.setText("Break");
		} else {
			currentPomodoroSession = pomoNumberSessionBox.getSelectedIndex() - totalPomodoroSessions;
			System.out.println("currentSession = " + (currentPomodoroSession + 1));
			currentSessionLabel.setText((currentPomodoroSession + 1) + " / " + (pomoNumberSessionBox.getSelectedIndex() + 1));
		}
		
	}		
	
	/**
	 * Updating user interface actions
	 */
	
	private void updateGUI() {
		
	}
	
	/*
	 * Method hides the main windows and disposes it
	 */
	public void hideWindow() {
		this.setVisible(false);
		this.dispose();
	}
	
	public void updateTamoTokensToTamoStudyProfile(int min, int sec) {
		//Update time
		int totalSeconds = (min * 60) + sec;
		tamoStudyProfile.setTotalTime(tamoStudyProfile.getTotalTime() + totalSeconds);
		
		//Update tokens
		//Every 3600 seconds, 50 Tamo tokens are earned
		//(72 seconds is 1 Tamo token)
		int earnedSessionTokens = ((50 * totalSeconds) / 3600);
		tamoStudyProfile.setTamoTokens(tamoStudyProfile.getTamoTokens() + earnedSessionTokens);
		
		//Update the profile file
		ProfileReaderWriter.updateProfileInfoToFile(tamoStudyProfile);
	}
	
	/**
	 * Enables WindowListener
	 * Asks user if they are sure they want to exit application
	 */
	public WindowListener makeExitWindowListener() {
		WindowListener exitListener = new WindowAdapter() {
		    @Override
		    public void windowClosing(WindowEvent e) {
		    	JPanel panel = new JPanel();
		    	panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		    	JLabel label = new JLabel("Are you sure you want to exit?");
		    	label.setAlignmentX(JComponent.CENTER_ALIGNMENT);
		    	JPanel confirmPanel = new JPanel();
		    	confirmPanel.setAlignmentX(JComponent.CENTER_ALIGNMENT);
		    	JCheckBox checkBox = new JCheckBox();
		    	JLabel confirmLabel = new JLabel("Don't show this message again");
		    	
		    	panel.add(label);
		    	confirmPanel.add(checkBox);
		    	confirmPanel.add(confirmLabel);
		    	panel.add(confirmPanel);
		    	
		    	int confirm = JOptionPane.showOptionDialog(
		                rootPane, 
		                panel, 
		                "Exit TamoStudyStream?", 
		                JOptionPane.YES_NO_OPTION, 
		                JOptionPane.QUESTION_MESSAGE, 
		                new ImageIcon(getClass().getClassLoader().getResource("INFO.png")), 
		                null, 
		                null);
	           if (confirm == JOptionPane.YES_OPTION) {
	        	  if(checkBox.isSelected()) {
	        		  settings.setShowWindowAdapter(false);
	        		  SettingsReaderWriter.updateSettingsJson(settings.getJsonObject());
	        	  }
	              System.exit(0);
	           }
		    }
		};
		return exitListener;
	}
}
