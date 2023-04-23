package io;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import model.language.Language;
import model.profile.Profile;
import model.profile.ProfileSettings;
import model.profile.Tamo;
import resources.Debug;

public class ProfileJsonManager extends JsonManager<List<Profile>> {

	public static final String profilesPath = System.getProperty("user.home") + File.separatorChar + "Documents" + File.separatorChar + "TamoStudy" 
			+ File.separatorChar + "profiles.json";
	
	@Override
	public List<Profile> readJson() {
		Debug.info("ProfileJsonManager.readJson", "Attempting to read profiles.json");
		File globalSettingsJsonFile = new File(profilesPath);
		
		if(globalSettingsJsonFile.exists()) {
			JSONParser parser = new JSONParser();
			try {
				Reader reader = new FileReader(profilesPath);
				JSONArray profilesJsonArray = (JSONArray) parser.parse(reader);
				Debug.info("ProfileJsonManager.readJson", "Read JSONArray profilesJsonArray. profilesJsonArray.size = " + profilesJsonArray.size());
				return profilesJsonToProfileList(profilesJsonArray);
			} catch (IOException | ParseException e) {
				Debug.error("ProfileJsonManager.readJson", "Exception throw while reading profiles.json");
                e.printStackTrace();
            }
		}
		
		Debug.info("ProfileJsonManager.readJson", "No profiles were found");
		return Collections.emptyList();
	}

	@Override
	public boolean writeJsonToFile(List<Profile> profiles) {
		try {
			File profilesJsonFile = new File(profilesPath);
			FileWriter fileWriter = new FileWriter(profilesJsonFile);
			JSONArray profilesJson = profileListToProfilesJson(profiles);
			try {
				
				fileWriter.write(profilesJson.toJSONString());
				return true;
			} catch (IOException e) {
				Debug.error("ProfileJsonManager.writeJsonToFile", "Error occurred writing profiles to profiles.json");
				e.printStackTrace();
				return false;
			} finally {
				try {
					fileWriter.flush();
					fileWriter.close();
				} catch (IOException e) {
					Debug.error("ProfileJsonManager.writeJsonToFile", "Error occurred while closing file writer.");
					e.printStackTrace();
					return false;
				}
			}
		} catch (IOException e) {
			Debug.error("ProfileJsonManager.writeJsonToFile", "Error occurred while instantiating fileWriter");
			e.printStackTrace();
			return false;
		}
	}
	
	/*
	 * ##################################
	 * ##################################
	 * MAPPINGS
	 * ##################################
	 * ##################################
	 */

	public List<Profile> profilesJsonToProfileList(JSONArray profilesJson) {
		List<Profile> profiles = new ArrayList<>();
		for(int i = 0; i < profilesJson.size(); i++) {
			profiles.add(profileJsonToProfileModel((JSONObject) profilesJson.get(i)));
		}
		return profiles;
	}
	
	@SuppressWarnings("unchecked")
	public JSONArray profileListToProfilesJson(List<Profile> profiles) {
		Debug.info("ProfileJsonManager.profileListToProfilesJson", "Attempting conversion... profiles.size = " + profiles.size());
		JSONArray profilesJson = new JSONArray();
		for(Profile profile : profiles) {
			profilesJson.add(profileModelToProfileJson(profile));
		}
		return profilesJson;
	}
	
	public Profile profileJsonToProfileModel(JSONObject profileJson) {
		return new Profile(
				(long) profileJson.get("id"),
				(String) profileJson.get("name"),
				(String) profileJson.get("previousDateString"),
				(long) profileJson.get("time"),
				(long) profileJson.get("tokens"),
				profileSettingsJsonToProfileSettingsModel((JSONObject) profileJson.get("settings")),
				(long) profileJson.get("backgroundIndicator"),
				(long) profileJson.get("borderIndicator"),
				indicatorListJsonToIndicatorList((JSONArray) profileJson.get("achievementList")),
				indicatorListJsonToIndicatorList((JSONArray) profileJson.get("foodInventoryList")),
				indicatorListJsonToIndicatorList((JSONArray) profileJson.get("backgroundInventoryList")),
				indicatorListJsonToIndicatorList((JSONArray) profileJson.get("borderInventoryList")),
				tamoJsonToTamoModel((JSONObject) profileJson.get("tamo")),
				tamoHistoryJsonToTamoHistoryList((JSONArray) profileJson.get("tamoHistory"))
			);
	}
	
	@SuppressWarnings("unchecked")
	public JSONObject profileModelToProfileJson(Profile profile) {
		JSONObject profileJson = new JSONObject();
		profileJson.put("id", profile.getId());
		profileJson.put("name", profile.getName());
		profileJson.put("previousDateString", profile.getPreviousDateString());
		profileJson.put("time", profile.getTime());
		profileJson.put("tokens", profile.getTokens());
		profileJson.put("settings", profileSettingsModelToProfileSettingsJson(profile.getSettings()));
		profileJson.put("backgroundIndicator", profile.getBackgroundIndicator());
		profileJson.put("borderIndicator", profile.getBorderIndicator());
		profileJson.put("achievementList", indicatorListToIndicatorListJson(profile.getAchievementList()));
		profileJson.put("foodInventoryList", indicatorListToIndicatorListJson(profile.getFoodInventoryList()));
		profileJson.put("backgroundInventoryList", indicatorListToIndicatorListJson(profile.getBackgroundInventoryList()));
		profileJson.put("borderInventoryList", indicatorListToIndicatorListJson(profile.getBorderInventoryList()));
		profileJson.put("tamo", tamoModelToTamoJson(profile.getTamo()));
		profileJson.put("tamoHistory", tamoHistoryListToTamoHistoryJson(profile.getTamoHistory()));
		return profileJson;
	}
	
	public List<Long> indicatorListJsonToIndicatorList(JSONArray indicatorListJson) {
		List<Long> indicatorList = new ArrayList<>();
		for(int i = 0; i < indicatorListJson.size(); i++) {
			indicatorList.add((long) indicatorListJson.get(i));
		}
		return indicatorList;
	}
	
	@SuppressWarnings("unchecked")
	public JSONArray indicatorListToIndicatorListJson(List<Long> indicatorList) {
		JSONArray indicatorListJson = new JSONArray();
		for(Long indicator : indicatorList) {
			indicatorListJson.add(indicator);
		}
		return indicatorListJson;
	}
	
	public ProfileSettings profileSettingsJsonToProfileSettingsModel(JSONObject profileSettingsJson) {
		return new ProfileSettings(
					Language.getLanguage((String) profileSettingsJson.get("language")),
					(long) profileSettingsJson.get("focusMode"),
					(long)profileSettingsJson.get("difficulty"),
					(long) profileSettingsJson.get("timerAlarm"),
					(long) profileSettingsJson.get("guiSize"),
					(boolean) profileSettingsJson.get("receiveNotifications"),
					(boolean) profileSettingsJson.get("enableDiscordRPC"),
					(boolean) profileSettingsJson.get("showProgramCloseMessage")
				);
	}
	
	@SuppressWarnings("unchecked")
	public JSONObject profileSettingsModelToProfileSettingsJson(ProfileSettings profileSettings) {
		JSONObject profileSettingsJson = new JSONObject();
		profileSettingsJson.put("language", profileSettings.getLanguage().toString());
		profileSettingsJson.put("focusMode", profileSettings.getFocusMode());
		profileSettingsJson.put("difficulty", profileSettings.getDifficulty());
		profileSettingsJson.put("timerAlarm", profileSettings.getTimerAlarm());
		profileSettingsJson.put("guiSize", profileSettings.getGuiSize());
		profileSettingsJson.put("receiveNotifications", profileSettings.getReceiveNotifications());
		profileSettingsJson.put("enableDiscordRPC", profileSettings.getEnableDiscordRPC());
		profileSettingsJson.put("showProgramCloseMessage", profileSettings.getShowProgramCloseMessage());
		return profileSettingsJson;
	}
	public Tamo tamoJsonToTamoModel(JSONObject tamoJson) {
		return new Tamo(
					(String) tamoJson.get("name"),
					(long) tamoJson.get("time"),
					(long) tamoJson.get("type"),
					(String) tamoJson.get("birthDateString"),
					(long) tamoJson.get("happy"),
					(long) tamoJson.get("hunger"),
					(long) tamoJson.get("strikes")
				);
	}
	
	@SuppressWarnings("unchecked")
	public JSONObject tamoModelToTamoJson(Tamo tamo) {
		JSONObject tamoJson = new JSONObject();
		tamoJson.put("name", tamo.getName());
		tamoJson.put("time", tamo.getTime());
		tamoJson.put("type", tamo.getType());
		tamoJson.put("birthDateString", tamo.getBirthDateString());
		tamoJson.put("happy", tamo.getHappy());
		tamoJson.put("hunger", tamo.getHunger());
		tamoJson.put("strikes", tamo.getStrikes());
		return tamoJson;
	}
	
	public List<Tamo> tamoHistoryJsonToTamoHistoryList(JSONArray tamoHistoryJson) {
		List<Tamo> tamoHistory = new ArrayList<>();
		for(int i = 0; i < tamoHistoryJson.size(); i++) {
			tamoHistory.add(deceasedTamoJsonToDeceasedTamo((JSONObject) tamoHistoryJson.get(i)));
		}
		return tamoHistory;
	}
	
	@SuppressWarnings("unchecked")
	public JSONArray tamoHistoryListToTamoHistoryJson(List<Tamo> tamoHistory) {
		JSONArray tamoHistoryJson = new JSONArray();
		for(Tamo tamo : tamoHistory) {
			tamoHistoryJson.add(deceasedTamoToDeceasedTamoJson(tamo));
		}
		return tamoHistoryJson;
	}
	
	public Tamo deceasedTamoJsonToDeceasedTamo(JSONObject deceasedTamoJson) {
		return new Tamo(
					(String) deceasedTamoJson.get("name"),
					(long) deceasedTamoJson.get("time"),
					(long) deceasedTamoJson.get("type"),
					(String) deceasedTamoJson.get("birthDateString"),
					(String) deceasedTamoJson.get("passDateString")
				);
	}
	
	@SuppressWarnings("unchecked")
	public JSONObject deceasedTamoToDeceasedTamoJson(Tamo deceasedTamo) {
		JSONObject deceasedTamoJson = new JSONObject();
		deceasedTamoJson.put("name", deceasedTamo.getName());
		deceasedTamoJson.put("time", deceasedTamo.getTime());
		deceasedTamoJson.put("type", deceasedTamo.getType());
		deceasedTamoJson.put("birthDateString", deceasedTamo.getBirthDateString());
		deceasedTamoJson.put("passDateString", deceasedTamo.getPassDateString());
		return deceasedTamoJson;
	}
}
