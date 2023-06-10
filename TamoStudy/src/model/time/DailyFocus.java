package model.time;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import gui.TamoStudyGUI;
import resources.Achievements;
import resources.Debug;
import util.Utils;

public class DailyFocus {
	
	private Long profileId;
	private List<DailyFocusEntry> dailyFocusEntries;

	public DailyFocus(Long profileId, List<DailyFocusEntry> dailyFocusEntry) {
		super();
		this.profileId = profileId;
		this.dailyFocusEntries = dailyFocusEntry;
	}

	public Long getProfileId() {
		return profileId;
	}

	public void setProfileId(Long profileId) {
		this.profileId = profileId;
	}

	public List<DailyFocusEntry> getDailyFocusEntries() {
		return dailyFocusEntries;
	}

	public void setDailyFocusEntries(List<DailyFocusEntry> dailyFocusEntry) {
		this.dailyFocusEntries = dailyFocusEntry;
	}
	
	public void checkInRowDailyFocusAchievements(TamoStudyGUI gui, int length) {
		List<Date> datesForAchievements = new ArrayList<>();
		Date todayDate = Utils.today();
		datesForAchievements.add(todayDate);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(todayDate);
		
		for(int i = 1; i < length; i++) {
			calendar.add(Calendar.DAY_OF_YEAR, -1);
			datesForAchievements.add(calendar.getTime());
		}
		
		boolean[] earnedDates = new boolean[length];
		for(int i = 0; i < length; i++) {
			earnedDates[i] = false;
		}
		
		for(int i = 0; i < length; i++) {
			Calendar dateCalendar = Calendar.getInstance();
			dateCalendar.setTime(datesForAchievements.get(i));
			
			long day = dateCalendar.get(Calendar.DAY_OF_MONTH);
			long month = dateCalendar.get(Calendar.MONTH) + 1;
			long year = dateCalendar.get(Calendar.YEAR);
			
			Debug.info("DailyFocus.checkInRowDailyFocusAchievement(" + length + ")", "Checking " + month + "/" + day + "/" + year);
			
			for(DailyFocusEntry entry : this.dailyFocusEntries) {
				Debug.info("DailyFocus.checkInRowDailyFocusAchievement(" + length + ")", "Checking " + month + "/" + day + "/" + year + " is equal " + entry.getMonth() + "/" + entry.getDay() + "/" + entry.getYear() + " = " + (day == entry.getDay() && month == entry.getMonth() && year == entry.getYear()));
				if(day == entry.getDay() && month == entry.getMonth() && year == entry.getYear() && entry.getTime() >= 3600) {
					earnedDates[i] = true;
				}
			}
			
			Debug.info("DailyFocus.checkInRowDailyFocusAchievement(" + length + ")", "Result: " + month + "/" + day + "/" + year + ". earnedDates[i] = " + earnedDates[i]);
		}
		
		boolean earnedAchievement = true;
		for(int i = 0; i < length; i++) {
			if(earnedDates[i] == false) {
				earnedAchievement = false;
			}
		}
		
		if(earnedAchievement) {
			switch(length) {
			case 3:
				Debug.info("DailyFocus.checkInRowDailyFocusAchievement", "Profile earned " + length + " achievement.");
				Achievements.earn(gui, 9);
				break;
			case 7:
				Debug.info("DailyFocus.checkInRowDailyFocusAchievement", "Profile earned " + length + " achievement.");
				Achievements.earn(gui, 10);
				break;
			case 30:
				Debug.info("DailyFocus.checkInRowDailyFocusAchievement", "Profile earned " + length + " achievement.");
				Achievements.earn(gui, 11);
				break;
			}
		} else {
			Debug.warn("DailyFocus.checkInRowDailyFocusAchievement", "Profile did not earn " + length + " achievement.");
		}
	}
}
