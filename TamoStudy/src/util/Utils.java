package util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

import model.profile.Profile;
import model.time.DailyFocus;
import model.time.DailyFocusEntry;
import model.time.MonthFocus;
import model.time.MonthFocusEntry;
import resources.Debug;

public class Utils {
	public static Date today() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String formattedDateString = formatter.format(date);
		try {
			return formatter.parse(formattedDateString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		throw new RuntimeException("Unexpected error occurred");
	}
	
	public static Date yesterday(Date today) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date date = Date.from(today.toInstant().minus(1, ChronoUnit.DAYS));
		String formattedDateString = formatter.format(date);
		try {
			return formatter.parse(formattedDateString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		throw new RuntimeException("Unexpected error occurred");
	}
	
	public static String todayAsString() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		return formatter.format(date);
	}
	
	public static Date stringToDate(String dateString) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		try {
			return formatter.parse(dateString);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static String dateAsString(Date date) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		return formatter.format(date);
	}
	
	public static String prettyDateAsString(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("EEEE, MMMM d, yyyy");
        return sdf.format(date);
	}
	
	public static boolean validateDateString(String dateString) {
		String regex = "^\\d{4}\\-(0[1-9]|1[012])\\-(0[1-9]|[12][0-9]|3[01])$";
		return Pattern.matches(regex, dateString);
	}
	
	public static String decrypt(String message) {
		char[] chars = message.toCharArray();
		for(int i = 0; i < message.length(); i++) {
			chars[i] -= 6;
		}
		
		String encryptedMessage = new String(chars);
		return encryptedMessage;
	}
	
	public static String readFile(File file) {
	      StringBuilder fileContents = new StringBuilder();
	      try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
	         String line;
	         while ((line = reader.readLine()) != null) {
	            fileContents.append(line);
	            fileContents.append(System.lineSeparator());
	         }
	      } catch (IOException e) {
	         e.printStackTrace();
	      }
	      return fileContents.toString();
	   }
	
	public static long getCurrentDay() {
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.DAY_OF_MONTH);
    }
    
    public static long getCurrentMonth() {
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.MONTH) + 1; // Month is zero-based, so add 1
    }
    
    public static long getCurrentYear() {
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.YEAR);
    }
    
    public static DailyFocus createDailyFocus(Profile profile) {
    	return new DailyFocus(
    				profile.getId(),
    				Collections.emptyList()
    			);
    }
    
    public static MonthFocus createMonthFocus(Profile profile) {
    	return new MonthFocus(
				profile.getId(),
				Collections.emptyList()
			);
    }
    
    public static DailyFocusEntry createDailyFocusEntry() {
    	return new DailyFocusEntry(
    				getCurrentDay(),
    				getCurrentMonth(),
    				getCurrentYear(),
    				(long) 0
    			);
    }
    
    public static MonthFocusEntry createMonthFocusEntry() {
    	return new MonthFocusEntry(getCurrentMonth(), getCurrentYear(), (long) 0);
    }
    
    public static DailyFocus searchDailyFocusByProfile(List<DailyFocus> dailyFocusList, Profile profile) {
    	for(DailyFocus dailyFocus : dailyFocusList) {
    		if(dailyFocus.getProfileId() == profile.getId()) {
    			return dailyFocus;
    		}
    	}
    	Debug.warn("Utils.searchDailyFocusByProfileId", "No daily focus object found for profile. Returning null to signal does not exist");
    	return null;
    }
    
    public static DailyFocusEntry searchTodayFocusEntryByProfile(List<DailyFocusEntry> dailyFocusEntries) {
    	for(DailyFocusEntry dailyFocusEntry : dailyFocusEntries) {
    		if(dailyFocusEntry.getDay() == getCurrentDay()
    				&& dailyFocusEntry.getMonth() == getCurrentMonth()
    				&& dailyFocusEntry.getYear() == getCurrentYear()) {
    			return dailyFocusEntry;
    		}
    	}
    	
    	Debug.warn("Utils.searchTodayFocusEntryByProfile", "No daily focus entry found for today. Returning null to signal entry does not exist");
    	return null;
    }
    
    public static MonthFocus searchMonthFocusByProfile(List<MonthFocus> monthFocusList, Profile profile) {
    	for(MonthFocus monthFocus : monthFocusList) {
    		if(monthFocus.getProfileId() == profile.getId()) {
    			return monthFocus;
    		}
    	}
    	
    	Debug.warn("Utils.searchMonthFocusByProfile", "No month focus object found for profile. Returning null to signal does not exist");
    	return null;
    }
    
    public static MonthFocusEntry searchCurrentMonthEntryByProfile(List<MonthFocusEntry> monthFocusEntries) {
    	for(MonthFocusEntry monthFocusEntry : monthFocusEntries) {
    		if(monthFocusEntry.getMonth() == getCurrentMonth()
    				&& monthFocusEntry.getYear() == getCurrentYear()) {
    			return monthFocusEntry;
    		}
    	}
    	
    	Debug.warn("Utils.searchCurrentMonthEntryByProfile", "No month focus entry found for this month. Returning null to signal entry does not exist");
    	return null;
    }
    
    public static double convertSecondsToHours(long seconds) {
        double hours = (double) seconds / 3600; // 1 hour = 3600 seconds
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        return Double.parseDouble(decimalFormat.format(hours));
    }
}
