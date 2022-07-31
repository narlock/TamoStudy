package resources;

import java.awt.Color;
import java.awt.Font;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class SettingsReaderWriter {
	
	private static FileWriter file;
	private static JSONParser parser = new JSONParser();
	
	public static Settings jsonToSettings() throws IOException, ParseException {
		JSONParser parser = new JSONParser();
		Reader reader = new FileReader("settings.json");
        JSONObject settingsJsonObject = (JSONObject) parser.parse(reader);
        
        JSONArray bgColor = (JSONArray) settingsJsonObject.get("backgroundColor");
        JSONArray timerBgColor = (JSONArray) settingsJsonObject.get("timerBackgroundColor");
        JSONArray borderColor = (JSONArray) settingsJsonObject.get("timerBorderColor");
        JSONArray textColor = (JSONArray) settingsJsonObject.get("textColor");
        
        return new Settings(
        		(String) settingsJsonObject.get("version"),
        		(String) settingsJsonObject.get("studyMode"),
        		new Color((int) (long) bgColor.get(0), (int) (long) bgColor.get(1), (int) (long) bgColor.get(2)),
        		new Color((int) (long) timerBgColor.get(0), (int) (long) timerBgColor.get(1), (int) (long) timerBgColor.get(2)),
        		new Color((int) (long) borderColor.get(0), (int) (long) borderColor.get(1), (int) (long) borderColor.get(2)),
        		new Color((int) (long) textColor.get(0), (int) (long) textColor.get(1), (int) (long) textColor.get(2)),
        		(String) settingsJsonObject.get("font"),
        		(long) settingsJsonObject.get("timerFontSize"),
        		(long) settingsJsonObject.get("sessionFontSize"),
        		(long) settingsJsonObject.get("soundIndicator")
        	);
	}
	
	public static JSONObject settingsToJsonObject(Settings settings) {
		return settings.getJsonObject();
	}
	
	public static void updateSettingsJson(JSONObject obj) {
		try {
            file = new FileWriter("settings.json");
            file.write(obj.toJSONString());
 
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                file.flush();
                file.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
	}
}
