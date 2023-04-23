package util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.regex.Pattern;

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
	
}
