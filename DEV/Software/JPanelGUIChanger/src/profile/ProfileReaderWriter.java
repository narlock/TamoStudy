package profile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import resources.Encryption;

/**
 * @author Anthony Narlock (narlock)
 */

public class ProfileReaderWriter {
	
	/**
	 * getProfileInfoFromFile
	 * @return The profile file selected from file attribute
	 * @throws Exception
	 */
	public static Profile getProfileInfoFromFile(File file) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader(file));
		String line = "";
		
		while((line = (br.readLine())) != null) {
			if(!line.equals("")) {
				System.out.println("[TAMOSTUDY/WELCOME] Profile Line: " + line);
				//TODO add encryption to decrypt
				String[] profileDetails = Encryption.decrypt(line).split(",");
				
				//Settings profileSettings = new Settings(....
				//Tamo profileTamo = new Tamo(...
				//Profile profileToLoad = new Profile(...
				
				//Return loaded profile
				br.close();
				//return profileToLoad;
			}
		}
		
		//If the file fails
		br.close();
		return new Profile();
	}
	
}
