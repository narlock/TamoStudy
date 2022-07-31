import java.io.File;
import java.io.IOException;

import javax.swing.filechooser.FileSystemView;

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
		MainGUI gui = new MainGUI();
	}
}
