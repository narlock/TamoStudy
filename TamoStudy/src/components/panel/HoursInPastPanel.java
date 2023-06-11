package components.panel;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.LookAndFeel;
import javax.swing.plaf.basic.BasicPopupMenuUI;

import model.GuiSize;
import model.language.Language;
import model.time.DailyFocusEntry;
import resources.Theme;
import util.Utils;

/**
 * HoursInPastPanel
 * @author narlock
 * @brief JPanel that displays the amount of hours studied
 * in the past 354 days.
 */
public class HoursInPastPanel extends JPanel {

	private static final long serialVersionUID = 6373302726491243044L;

	/*
	 * ##################################
	 * ##################################
	 * ATTRIBUTES
	 * ##################################
	 * ##################################
	 */
	private List<LocalDate> dateList;
	private List<DailyFocusEntry> focusEntries;
	private GuiSize guiSize;
	private Theme theme;
	
	public HoursInPastPanel(Theme theme, List<DailyFocusEntry> focusEntries, GuiSize guiSize) {
		this.focusEntries = focusEntries;
		this.guiSize = guiSize;
		this.theme = theme;
		this.dateList = getDateList();

		initializePanel();
	}
	
	public void initializePanel() {
		int gridRowCount = 7;
		int gridColCount = 26;
		this.setBackground(theme.mainColor);
		this.setBorder(guiSize.messageBorder);
		this.setLayout(new GridLayout(gridRowCount, gridColCount));
		this.setPreferredSize(guiSize.hoursInPastDimension);
		addDaysToPanel();
	}
	
	public void addDaysToPanel() {
		// Get previous 
		for (LocalDate date : dateList) {
            boolean dateExists = false;

            for (DailyFocusEntry entry : focusEntries) {
                if (entry.getDay().equals((long) date.getDayOfMonth()) &&
                    entry.getMonth().equals((long) date.getMonthValue()) &&
                    entry.getYear().equals((long) date.getYear())) {
                    dateExists = true;
                    
                    // add since it exists - add popup to show time during that day
                    JLabel dateLabel = new JLabel();
                    dateLabel.setIcon(chooseIconByTime(entry.getTime()));
                    
                    // Popup
            		final JPopupMenu popupMenu = new JPopupMenu("Test Popup");
            		JLabel popupMessageLabel = new JLabel("  " + Utils.convertSecondsToHours(entry.getTime()) + " hours on " + date.getDayOfWeek() + ", " + date.getMonth() + " " + date.getDayOfMonth() + ", " + date.getYear() + "  ");
            		
            		popupMessageLabel.setForeground(theme.textColor);
            		popupMenu.setBackground(theme.layerColor);
            		popupMenu.add(popupMessageLabel);
            		
            		dateLabel.addMouseListener(new MouseAdapter() {
            			public void mouseEntered(MouseEvent e) {
            				popupMenu.show(dateLabel, e.getX() - 120, e.getY() - 50);
            			}
            		});
            		
            		this.add(dateLabel);
                    break;
                }
            }

            if (!dateExists) {
            	
            	// add since it does not exist - add popup to show time during that day
                JLabel dateLabel = new JLabel(guiSize.grayIcon);
        		final JPopupMenu popupMenu = new JPopupMenu("Test Popup");
        		JLabel popupMessageLabel = new JLabel("  0.0 hours on " + date.getDayOfWeek() + ", " + date.getMonth() + " " + date.getDayOfMonth() + ", " + date.getYear() + "  ");
        		
        		popupMessageLabel.setForeground(theme.textColor);
        		popupMenu.setBackground(theme.layerColor);
        		
        		// popup
        		popupMenu.add(popupMessageLabel);
        		dateLabel.addMouseListener(new MouseAdapter() {
        			public void mouseEntered(MouseEvent e) {
        				popupMenu.show(dateLabel, e.getX() - 120, e.getY() - 50);
        			}
        		});
        		
        		this.add(dateLabel);
            }
        }
	}
	
	/*
	 * ##################################
	 * ##################################
	 * HELPER METHODS
	 * ##################################
	 * ##################################
	 */
	public List<LocalDate> getDateList() {
		Date currentDate = Utils.today();
		LocalDate localCurrentDate = currentDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		List<LocalDate> dateList = new ArrayList<>();
		
		for (int i = 0; i < 182; i++) {
            dateList.add(localCurrentDate.minusDays(i));
        }
		
		return dateList;
	}
	
	public ImageIcon chooseIconByTime(long time) {
		double hours = Utils.convertSecondsToHours(time);
		
		if(hours < 1) {
			return guiSize.grayIcon;
		} else if(hours >= 1 && hours < 3) {
			return guiSize.green1Icon;
		} else if(hours >= 3 && hours < 5) {
			return guiSize.green2Icon;
		} else if(hours >= 5 && hours < 10) {
			return guiSize.green3Icon;
		} else {
			return guiSize.green4Icon;
		}
	}
}
