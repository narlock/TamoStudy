package resources;

import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import javax.swing.GrayFilter;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import gui.TamoStudyGUI;
import model.GuiSize;
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
	
	public static String getAchievementTitleByIndicator(int indicator) {
		switch(indicator) {
		case 0:
			return "The Beginning";
		case 1:
			return "Nothing can stop us!";
		case 2:
			return "Never give up!";
		case 3:
			return "Focus Ascension";
		case 4:
			return "Cosmetics";
		case 5:
			return "Scenery Change";
		case 6:
			return "From the Beginning";
		case 7:
			return "Tamo Full";
		case 8:
			return "Tamo Love";
		case 9:
			return "Dedicated";
		case 10:
			return "Building Consistency";
		case 11:
			return "Tamo Scholar";
		}
		throw new RuntimeException("Invalid indicator provided");
	}
	
	public static String getAchievementDescriptionByIndicator(int indicator) {
		switch(indicator) {
		case 0:
			return "<html>Earn Tamo level 1.<br>(Achieve total focus time of 24 hours)</html>";
		case 1:
			return "<html>Earn Tamo level 3.<br>(Achieve total focus time of 72 hours)</html>";
		case 2:
			return "<html>Earn Tamo level 10.<br>(Achieve total focus time of 240 hours)</html>";
		case 3:
			return "<html>Earn Tamo level 50.<br>(Achieve total focus time of 1200 hours)</html>";
		case 4:
			return "Purchase and change your Tamo's Border.";
		case 5:
			return "Purchase and change your Tamo's Background.";
		case 6:
			return "Updated from previous TamoStudy release.";
		case 7:
			return "Achieve maximum Tamo hunger.";
		case 8:
			return "Achieve maximum Tamo happiness.";
		case 9:
			return "Focus for 1+ hours for 3 days consecutively.";
		case 10:
			return "Focus for 1+ hours for 7 days consecutively.";
		case 11:
			return "Focus for 1+ hours for 30 days consecutively.";
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
				JOptionPane.showMessageDialog(gui.getRootPane(), "<html>Achievement Unlocked: " + getAchievementTitleByIndicator((int) indicator) + "<br>You have earned " + tokensEarned + " Tamo tokens!</html>", "TamoStudy", JOptionPane.INFORMATION_MESSAGE,  new ImageIcon(Achievements.class.getClassLoader().getResource("INFO.png")));
			}
			
			// Ensure Changes are earned
			gui.updateTamoTokensLabel();
			gui.getProfileJsonManager().writeJsonToFile(gui.getProfiles());
		} else {
			Debug.warn("Achievements.earn", "Profile " + profile.getName() + " already has achievement " + indicator + ".");
		}
	}
}
