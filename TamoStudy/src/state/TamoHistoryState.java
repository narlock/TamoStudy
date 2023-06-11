package state;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.plaf.basic.BasicProgressBarUI;

import components.panel.TamoGraphicsPanel;
import gui.TamoStudyGUI;
import model.GuiSize;
import model.language.Language;
import model.profile.Profile;
import model.profile.Tamo;
import resources.Debug;
import resources.Theme;
import util.Utils;

public class TamoHistoryState extends State {

	private static final long serialVersionUID = -8715178495100570733L;
	
	/*
	 * ##################################
	 * ##################################
	 * ATTRIBUTES
	 * ##################################
	 * ##################################
	 */
	private Profile profile;
	private List<Tamo> tamoHistory;
	private Tamo tamo;
	private GuiSize guiSize;
	private int tamoPage;
	private Language language;
	private Theme theme;
	
	/*
	 * ##################################
	 * ##################################
	 * COMPONENTS
	 * ##################################
	 * ##################################
	 */
	private JButton previousButton;
	private JButton nextButton;
	
	private JPanel tamoPanel;
	private JLabel tamoNameLabel;
	private JLabel tamoLevelLabel;
	private JProgressBar levelProgressBar;
	private JLabel tamoHeadstoneLabel;
	private JPanel tamoGraphicsPanelPanel;
	private TamoGraphicsPanel tamoGraphicsPanel;

	public TamoHistoryState(TamoStudyGUI tamoStudyGUI) {
		super(tamoStudyGUI);
		initializeAttributes();
		initializeComponents();
		initializeComponentVisuals();
		initializeComponentActions();
		initializePanel();
	}

	@Override
	protected void initializeAttributes() {
		profile = tsGui.getProfile();
		tamoHistory = tsGui.getProfile().getTamoHistory();
		guiSize = tsGui.getGuiSize();
		tamoPage = 0;
		theme = profile.getSettings().getTheme();
	}

	@Override
	protected void initializeComponents() {
		nextButton = new JButton(guiSize.rightArrowIcon);
		previousButton = new JButton(guiSize.leftArrowIcon);
		
		tamoPanel = new JPanel(new GridBagLayout());
		tamo = tamoHistory.get(0);
		tamoGraphicsPanelPanel = new JPanel();
		tamoGraphicsPanel = new TamoGraphicsPanel(guiSize, tamo, profile.getBackgroundIndicator(), profile.getBorderIndicator());
		
		tamoNameLabel = new JLabel(tamo.getName());
		tamoLevelLabel = new JLabel("Level: " + tamo.getLevel());
		levelProgressBar = new JProgressBar(0, 100);
		tamoHeadstoneLabel = new JLabel(tamo.getBirthDateString() + " - " + tamo.getPassDateString());
	}

	@Override
	protected void initializeComponentVisuals() {
		addButtonVisual(nextButton);
		addButtonVisual(previousButton);
		
		tamoPanel.setBackground(theme.subColor);
		
		tamoNameLabel.setFont(guiSize.messageLabelFont);
		tamoNameLabel.setForeground(theme.textColor);
		
		tamoLevelLabel.setFont(guiSize.statisticsInfoFont);
		tamoLevelLabel.setForeground(theme.textColor);
		
		levelProgressBar.setOpaque(true);
		levelProgressBar.setFont(guiSize.statisticsInfoFont);
		levelProgressBar.setForeground(Theme.SUCCESS);
		levelProgressBar.setBackground(theme.mainColor);
		levelProgressBar.setBorder(BorderFactory.createLineBorder(theme.textColor, 1));
		levelProgressBar.setUI(new BasicProgressBarUI() {
		    protected Color getSelectionBackground() {
		        return Color.WHITE; // set the color of the progress bar
		    }
		    protected Color getSelectionForeground() {
		        return Color.BLACK; // set the color of the text on the progress bar
		    }
		});
		levelProgressBar.setStringPainted(true);
		levelProgressBar.setValue(tamo.levelProgress());
		
		tamoHeadstoneLabel.setFont(guiSize.messageLabelFont);
		tamoHeadstoneLabel.setForeground(theme.textColor);
	}

	@Override
	protected void initializeComponentActions() {
		nextButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				nextPreviousPage(true);
				
			}
		});
		
		previousButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				nextPreviousPage(false);
				
			}
		});
	}

	@Override
	protected void initializePanel() {
		GridBagConstraints gbch = new GridBagConstraints();
		gbch.gridheight = GridBagConstraints.REMAINDER;
		
		GridBagConstraints gbcv = new GridBagConstraints();
		gbcv.gridwidth = GridBagConstraints.REMAINDER;
		
		tamoPanel.add(tamoNameLabel, gbcv);
		tamoPanel.add(Box.createVerticalStrut(guiSize.settingsVerticalDifference), gbcv);
		
		tamoGraphicsPanelPanel.add(tamoGraphicsPanel);
		
		tamoPanel.add(tamoGraphicsPanelPanel, gbcv);
		tamoPanel.add(Box.createVerticalStrut(guiSize.settingsVerticalDifference), gbcv);
		tamoPanel.add(tamoHeadstoneLabel, gbcv);
		tamoPanel.add(Box.createVerticalStrut(guiSize.settingsVerticalDifference), gbcv);
		tamoPanel.add(tamoLevelLabel, gbcv);
		tamoPanel.add(levelProgressBar, gbcv);
		
		this.setLayout(new GridBagLayout());
		this.add(previousButton, gbch);
		this.add(tamoPanel, gbch);
		this.add(nextButton, gbch);
	}
	
	public void nextPreviousPage(boolean next) {
		if(next) {
			try {
				tamoHistory.get(tamoPage + 1);
				
				// Changing page
				tamoPage++;
				tamo = tamoHistory.get(tamoPage);
				repaintTamoPanel();
			} catch (IndexOutOfBoundsException e) {
				// No Tamo for index
				System.out.println("Cannot move forward");
			}
		} else {
			try {
				tamoHistory.get(tamoPage - 1);
				
				// Changing page
				tamoPage--;
				tamo = tamoHistory.get(tamoPage);
				repaintTamoPanel();
			} catch (IndexOutOfBoundsException e) {
				// No Tamo for index
				System.out.println("Cannot move backwards");
			}
		}
		
		Debug.info("TamoHistoryState.nextPreviousPage", "tamoPage = " + tamoPage);
	}
	
	public void repaintTamoPanel() {
		tamoGraphicsPanelPanel.remove(tamoGraphicsPanel);
		tamoGraphicsPanel = new TamoGraphicsPanel(guiSize, tamo, profile.getBackgroundIndicator(), profile.getBorderIndicator());
		tamoGraphicsPanelPanel.add(tamoGraphicsPanel);
		
		tamoNameLabel.setText(tamo.getName());
		tamoLevelLabel.setText("Level: " + tamo.getLevel());
		levelProgressBar.setValue(tamo.levelProgress());
		tamoHeadstoneLabel.setText(tamo.getBirthDateString() + " - " + tamo.getPassDateString());
		
		tamoGraphicsPanel.revalidate();
		tamoGraphicsPanel.repaint();
		this.revalidate();
		this.repaint();
	}

	/*
	 * ##################################
	 * ##################################
	 * HELPER METHODS
	 * ##################################
	 * ##################################
	 */
	public void addButtonVisual(JButton button) {
		button.setContentAreaFilled(false);
		button.setOpaque(false);
		button.setBorderPainted(false);
		button.setFocusPainted(false);
	}
}
