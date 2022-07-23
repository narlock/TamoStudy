import java.io.IOException;

import org.json.simple.parser.ParseException;

import resources.Settings;
import resources.SettingsReaderWriter;

/**
 * TamoStream
 * @author Anthony Narlock (narlock)
 * @brief Runs the Main loop of the project
 */

public class TamoStream {
	public static void main(String[] args) throws IOException, ParseException {
		Settings settings = SettingsReaderWriter.jsonToSettings();
		settings.setFontString("Tahoma");
		SettingsReaderWriter.updateSettingsJson(settings.getJsonObject());
		System.out.println(settings.getJsonObject());
	}
}
