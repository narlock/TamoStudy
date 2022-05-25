package profile;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;

import javax.swing.JFileChooser;

import resources.Encryption;

/**
 * @author Anthony Narlock (narlock)
 */

public class ProfileReaderWriter {
	
	/**
	 * writeProfileToFile
	 * Writes a new profile to a file
	 * @param profile
	 * @return true on success
	 */
	public static File writeProfileToFile(Profile profile) {
		final JFileChooser SaveAs = new JFileChooser();
		int actionDialog = SaveAs.showSaveDialog(null);
		if(actionDialog != JFileChooser.APPROVE_OPTION) { return null; }
		
		File fileName = new File(SaveAs.getSelectedFile() + ".txt");
		BufferedWriter outFile = null;
		try {
			outFile = new BufferedWriter(new FileWriter(fileName));
			//Write Profile Information
			outFile.append(profile.toString());
			
		} catch (Exception e) { e.printStackTrace(); }
		
		finally {
			if(outFile != null) {
				try {
					//Close the writer and return the file
					outFile.close();
					return new File(SaveAs.getSelectedFile() + ".txt");
				} catch (Exception e) { e.printStackTrace(); }
			}
		}
		
		//Should never get here, but just in case
		return null;
	}
	
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
				//String[] profileDetails = Encryption.decrypt(line).split(",");
				String[] profileDetails = line.split(",");
				
				/**
				 * [0] version
				 * [1] username
				 * [2] joinDateString
				 * [3] lastLoginDateString
				 * [4] tamoTokens
				 * [5] totalTime
				 * [6] bgIndicator
				 * [7] themeIndicator
				 * [8] strikes
				 * [9] tamoName
				 * [10] tamoHappiness
				 * [11] tamoHunger
				 * [12] tamoId
				 * [13] languageIndicator
				 * [14] ahmString
				 * [15] invString
				 * [16] focusMode
				 * [17] sessionSoundIndicator
				 * [18] backgroundSoundIndicator
				 * [19] difficulty
				 * [20] showAhmNotifications
				 */
				
				Settings profileSettings = new Settings(Integer.parseInt(profileDetails[16]),
						Integer.parseInt(profileDetails[17]), Integer.parseInt(profileDetails[18]),
						Integer.parseInt(profileDetails[19]), Integer.parseInt(profileDetails[20]));
				
				Tamo profileTamo = new Tamo(profileDetails[9], Integer.parseInt(profileDetails[10]), 
						Integer.parseInt(profileDetails[11]), Integer.parseInt(profileDetails[12]));
				
				Profile profileToLoad = new Profile(file, profileDetails[1], profileDetails[2], profileDetails[3],
						Integer.parseInt(profileDetails[4]), Integer.parseInt(profileDetails[5]),
						Integer.parseInt(profileDetails[6]), Integer.parseInt(profileDetails[7]),
						Integer.parseInt(profileDetails[8]), profileTamo, Integer.parseInt(profileDetails[13]),
						profileDetails[14], profileDetails[15], profileSettings);		
				
				//Return loaded profile
				br.close();
				return profileToLoad;
			}
		}
		
		//If the file fails
		br.close();
		return new Profile();
	}
	
	/**
	 * updateProfileInfoToFile
	 * @param profile
	 * @return true on success
	 */
	public static boolean updateProfileInfoToFile(Profile profile) {
		File fileName = profile.getFile();
		System.out.println(fileName);

		try {
			FileOutputStream fileOut = new FileOutputStream(fileName);
			fileOut.write(profile.toString().getBytes());
			fileOut.close();
			
		} catch (Exception e) { e.printStackTrace(); }
		
		//Should not get here
		return false;
	}
	
}
