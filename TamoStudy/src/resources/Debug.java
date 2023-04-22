package resources;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Debug
 * 
 * @author narlock
 *
 * @brief Simple developer debug tool for printing logging messages.
 */
public class Debug {
	
	private static final boolean on = true;
	
	public static void info(String location, String message) {
		if(on) {
			String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
			System.out.println("\u001B[33m" + timeStamp + " [\u001B[37mINFO\u001B[33m] : \u001B[35m" + location + " \u001B[37m: " + message + "\u001B[0m");
		}
	}
	
	public static void error(String location, String message) {
		if(on) {
			String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
			System.out.println("\u001B[33m" + timeStamp + " [\u001B[31mERROR\u001B[33m] : \u001B[35m" + location + " \u001B[37m: " + message + "\u001B[0m");
		}
	}
}
