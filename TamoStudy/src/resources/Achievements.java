package resources;

import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import javax.swing.GrayFilter;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import gui.TamoStudyGUI;
import model.GuiSize;
import model.language.Language;
import model.profile.Profile;

public class Achievements {
	public static ImageIcon getAchievementIconByIndicator(boolean earned, int indicator, GuiSize guiSize) {
		if(earned) {
			return guiSize.scaleImageIcon(new ImageIcon(Achievements.class.getClassLoader().getResource("ACHIEVEMENT_" + indicator + ".png")));
		}
		return toGrayscale(guiSize.scaleImageIcon(new ImageIcon(Achievements.class.getClassLoader().getResource("ACHIEVEMENT_" + indicator + ".png"))));
	}
	
	public static ImageIcon toGrayscale(ImageIcon originalIcon) {
        // Extract the Image from the ImageIcon
        Image originalImage = originalIcon.getImage();

        // Convert the Image to grayscale using GrayFilter
        Image grayImage = GrayFilter.createDisabledImage(originalImage);

        // Create a new ImageIcon from the grayscale image
        ImageIcon grayscaleIcon = new ImageIcon(grayImage);

        return grayscaleIcon;
    }
	
	public static String getAchievementTitleByIndicator(int indicator, Language language) {
		switch(indicator) {
		case 0:
			return language.theBeginningText;
		case 1:
			return language.nothingCanStopUsText;
		case 2:
			return language.neverGiveUpText;
		case 3:
			return language.focusAscensionText;
		case 4:
			return language.cosmeticsText;
		case 5:
			return language.sceneryChangeText;
		case 6:
			return language.fromTheBeginningText;
		case 7:
			return language.tamoFullText;
		case 8:
			return language.tamoLoveText;
		case 9:
			return language.dedicatedText;
		case 10:
			return language.buildingConsistencyText;
		case 11:
			return language.tamoScholarText;
		}
		throw new RuntimeException("Invalid indicator provided");
	}
	
	public static String getAchievementDescriptionByIndicator(int indicator, Language language) {
		switch(indicator) {
		case 0:
			return language.theBeginningDescText;
		case 1:
			return language.nothingCanStopUsDescText;
		case 2:
			return language.neverGiveUpDescText;
		case 3:
			return language.focusAscensionDescText;
		case 4:
			return language.cosmeticsDescText;
		case 5:
			return language.sceneryChangeDescText;
		case 6:
			return language.fromTheBeginningDescText;
		case 7:
			return language.tamoFullDescText;
		case 8:
			return language.tamoLoveDescText;
		case 9:
			return language.dedicatedDescText;
		case 10:
			return language.buildingConsistencyDescText;
		case 11:
			return language.tamoScholarDescText;
		}
		throw new RuntimeException("Invalid indicator provided");
	}
	
	public static long getAchievementTokenEarningsByIndicator(int indicator) {
		switch(indicator) {
		case 0:
			return 100;
		case 1:
			return 500;
		case 2:
			return 1000;
		case 3:
			return 2000;
		case 4:
			return 50;
		case 5:
			return 50;
		case 6:
			return 50;
		case 7:
			return 50;
		case 8:
			return 50;
		case 9:
			return 100;
		case 10:
			return 250;
		case 11:
			return 1000;
		}
		throw new RuntimeException("Invalid indicator provided");
	}
	
	public static void earn(TamoStudyGUI gui, long indicator) {
		Profile profile = gui.getProfile();
		Language language = gui.getProfile().getSettings().getLanguage();
		List<Long> achievementList = new ArrayList<>(profile.getAchievementList());
		if(!achievementList.contains((Long) indicator)) {
			// Add achievement to achievement list
			Debug.info("Achievements.earn", "Profile " + profile.getName() + " has earned achievement " + indicator + ".");
			achievementList.add(indicator);
			profile.setAchievementList(achievementList);
			
			// Earn tokens for earning the achievement
			Debug.info("Achievements.earn", "Profile tokens before achievement: " + profile.getTokens());
			long tokensEarned = getAchievementTokenEarningsByIndicator((int) indicator);
			profile.setTokens(profile.getTokens() + tokensEarned);
			Debug.info("Achievements.earn", "Profile tokens after achievement: " + profile.getTokens());
			
			// Display achievement notification if setting is enabled
			if(profile.getSettings().getReceiveNotifications()) {
				JOptionPane.showMessageDialog(gui.getRootPane(), "<html>Achievement Unlocked: " + getAchievementTitleByIndicator((int) indicator, language) + "<br>You have earned " + tokensEarned + " Tamo tokens!</html>", "TamoStudy", JOptionPane.INFORMATION_MESSAGE,  new ImageIcon(Achievements.class.getClassLoader().getResource("INFO.png")));
			}
			
			// Ensure Changes are earned
			gui.updateTamoTokensLabel();
			gui.getProfileJsonManager().writeJsonToFile(gui.getProfiles());
		} else {
			Debug.warn("Achievements.earn", "Profile " + profile.getName() + " already has achievement " + indicator + ".");
		}
	}
}
