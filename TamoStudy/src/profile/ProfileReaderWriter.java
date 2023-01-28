package profile;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.List;

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
			String encryptedProfile = Encryption.encrypt(profile.toString());
			System.out.println("SAVING TO FILE: " + encryptedProfile);
			outFile.append(encryptedProfile);
			
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
				System.out.println("[TAMOSTUDYSTREAM/PROFILEREADER] " + line);
				String[] profileDetails = Encryption.decrypt(line).split(",");
				
				if(profileDetails[0].equals("b4.0")) {
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
				else {
					br.close();
					return updateProfileAndLoad(file, profileDetails);
				}
			}
		}
		
		//If the file fails
		br.close();
		return new Profile();
	}
	
	private static Profile updateProfileAndLoad(File file, String[] profileDetails) {
		if(profileDetails.length == 21) {
			//Beta 3.2 profile
			System.out.println("[TAMOSTUDY] Updating 3.2 Profile");
			
			//Settings, difficulty is set to Peaceful, notifications ON
			Settings profileSettings = new Settings(Integer.parseInt(profileDetails[10]),
					Integer.parseInt(profileDetails[12]), Integer.parseInt(profileDetails[13]),
					Integer.parseInt(profileDetails[14]), 1);
			
			//profileTamo
			Tamo profileTamo = new Tamo(profileDetails[15], Integer.parseInt(profileDetails[17]),
					Integer.parseInt(profileDetails[18]), Integer.parseInt(profileDetails[16]));
			
			int newLangIndicator = getLanguageIndicatorFrom(Integer.parseInt(profileDetails[11]));
			
			//In case the user previously has bg0 as theirs,
			//they won't have duplicate item in inventory
			String invString = "";
			if(!(profileDetails[6].equals("0")))
				invString = "0" + profileDetails[6];
			else
				invString = profileDetails[6];

			Profile profileToLoad = new Profile(file, profileDetails[0], profileDetails[1], profileDetails[2],
					Integer.parseInt(profileDetails[5]), Integer.parseInt(profileDetails[4]), 
					Integer.parseInt(profileDetails[6]), 0, Integer.parseInt(profileDetails[8]),
					profileTamo, newLangIndicator, "000000100000", invString, profileSettings);
		
			return profileToLoad;
			
		} else if(profileDetails.length == 17) {
			//Beta 2.4 profile
			System.out.println("[TAMOSTUDY] Updating 2.4 Profile");
			
			//Settings, difficulty is set to Peaceful, notifications ON
			Settings profileSettings = new Settings(Integer.parseInt(profileDetails[8]),
					Integer.parseInt(profileDetails[10]), Integer.parseInt(profileDetails[11]), 0, 1);
			
			//profileTamo
			Tamo profileTamo = new Tamo(profileDetails[12], Integer.parseInt(profileDetails[14]),
					Integer.parseInt(profileDetails[15]), Integer.parseInt(profileDetails[13]));
			
			int newLangIndicator = getLanguageIndicatorFrom(Integer.parseInt(profileDetails[9]));
			
			
			Profile profileToLoad = new Profile(file, profileDetails[0], profileDetails[1], profileDetails[2],
					Integer.parseInt(profileDetails[4]), Integer.parseInt(profileDetails[3]), 
					Integer.parseInt(profileDetails[5]), 0, 0, profileTamo, newLangIndicator,
					"000000100000", "0", profileSettings);
		
			return profileToLoad;
		}
		
		//This should not happen
		return null;
	}
	
	public static int getLanguageIndicatorFrom(int oldIndicator) {
		if(oldIndicator == 0) { return 0; } //English
		else if(oldIndicator == 1) { return 1; } //Spanish
		else if(oldIndicator == 2) { return 2; } //Portuguese
		else if(oldIndicator == 3) { return 3; } //German
		else if(oldIndicator == 4) { return 9; } //Japanese
		else if(oldIndicator == 5) { return 5; } //Dutch
		else if(oldIndicator == 6) { return 4; } //French
		else if(oldIndicator == 7) { return 6; } //Turkish
		else if(oldIndicator == 8) { return 7; } //Irish
		
		return 0;
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
			String encryptedProfileString = Encryption.encrypt(profile.toString());
			fileOut.write(encryptedProfileString.getBytes());
			fileOut.close();
			
		} catch (Exception e) { e.printStackTrace(); }
		
		//Should not get here
		return false;
	}
	
	/**
	 * checkForTamoStudyDirectory
	 * @brief Checks if the directory Documents/TamoStudy/ exists on
	 * the users disk. If it does not, create the directory and create
	 * the `profiles.json` file. This file will store all of the local
	 * profiles.
	 */
	public static void checkForTamoStudyDirectory() {
		//TODO
		
		//Create the directory if it does not exist
		
		//If the directory exists, make sure the profiles.json file exists.
		//If it does not, create it
	}
	
	/**
	 * putNewProfileInProfilesJsonFile
	 * @brief Puts a new profile object into the profile JSON file.
	 * @param profile - the profile to put in the file.
	 * @return True for successful file writing
	 */
	public static boolean putNewProfileInProfilesJsonFile(Profile profile) {
		//TODO
		//Read profile file
		
		//Append profile to list of profiles
		return false;
	}
	
	/**
	 * getProfilesFromProfilesJsonFile
	 * @return list of profiles in the profile JSON.
	 */
	public static List<Profile> getProfilesFromProfilesJsonFile() {
		//TODO
		//Read profiles file
		
		//Return profiles
		return null;
	}
	
	/**
	 * updateProfileInfoToProfilesJsonFile
	 * @brief Updates profile object to profiles JSON file based on provided index.
	 * @param profileIndex
	 * @param profile
	 * @return True for successful profile update, false for failure
	 */
	public static boolean updateProfileInfoToProfilesJsonFile(int profileIndex, Profile profile) {
		//TODO
		//Read profile file
		
		//Update profile
		return false;
	}
	
}
