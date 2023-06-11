package model.profile;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import javax.swing.Timer;

import gui.TamoStudyGUI;
import resources.Debug;
import util.Utils;

public class ProfileUpdateManager {
	/*
	 * ##################################
	 * ##################################
	 * ATTRIBUTES
	 * ##################################
	 * ##################################
	 */
	private TamoStudyGUI tamoStudyGUI;
	private Tamo tamo;
	private Profile profile;
	private Timer timer;
	
	public ProfileUpdateManager(TamoStudyGUI tamoStudyGUI) {
		this.tamoStudyGUI = tamoStudyGUI;
		this.profile = tamoStudyGUI.getProfile();
		this.tamo = tamoStudyGUI.getProfile().getTamo();
		
		// Call update day on creation
		updateHappyHungerOnDayChange();
	}
	
	public void updateHappyOnEvent(int subtraction) {
		updateTamoHappy(tamo, subtraction);
		
		// Update JSON
		tamoStudyGUI.getProfileJsonManager().writeJsonToFile(tamoStudyGUI.getProfiles());
	}
	
	public void updateHappyHungerOnDayChange() {
		Debug.info("ProfileUpdateManager.updateHappyHungerOnDayChange", 
				"Updating Happy Hunger for " + profile.getName()
			);
		String todayAsString = Utils.todayAsString();
		if(!profile.getPreviousDateString().equals(todayAsString)) {
			Debug.info("ProfileUpdateManager.updateHappyHungerOnDayChange", 
					"New day - updating date string and applying happy/hunger changes."
				);
			LocalDate todayLocalDate = LocalDate.parse(Utils.todayAsString());
			LocalDate previousLocalDate = LocalDate.parse(profile.getPreviousDateString());
			
			profile.setPreviousDateString(todayAsString);
			// Updating happiness and hunger based on time
			
			long daysBetween = ChronoUnit.DAYS.between(previousLocalDate, todayLocalDate);
			
			if(daysBetween < 7) {
				updateTamoHunger(tamo, 3);
				updateTamoHappy(tamo, 2);
				
				if(profile.getTamo().getHunger() < 2 || profile.getTamo().getHappy() < 2) {
					profile.getTamo().setStrikes(profile.getTamo().getStrikes() + 1);
					Debug.info("ProfileUpdateManager.updateHappyHungerOnDayChange", "Strike added to tamo " + profile.getTamo().getName() + ", now has " + profile.getTamo().getStrikes() + ".");
				}
			} else if(daysBetween >= 7) {
				updateTamoHunger(tamo, 10);
				updateTamoHappy(tamo, 10);
				
				if(profile.getTamo().getHunger() < 2 || profile.getTamo().getHappy() < 2) {
					profile.getTamo().setStrikes(profile.getTamo().getStrikes() + 1);
					Debug.info("ProfileUpdateManager.updateHappyHungerOnDayChange", "Strike added to tamo " + profile.getTamo().getName() + ", now has " + profile.getTamo().getStrikes() + ".");
				}
			}
			
			
			// Update JSON
			tamoStudyGUI.getProfileJsonManager().writeJsonToFile(tamoStudyGUI.getProfiles());
			
			/*
			 * TODO
			 * 
			 * Under the condition that the state is display happy and hunger, notably,
			 * dashboard, focus, and statistics, the happiness and hunger should be updated,
			 * along with the tamo image.
			 */
		} else {
			Debug.info("ProfileUpdateManager.updateHappyHungerOnDayChange", 
					"Same day detected - applying no changes to profile."
				);
		}
	}
	
	public void updateHappyHungerBasedOnTime() {
		timer = new Timer(900000, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				updateHappyHungerOnDayChange();
			}
		});
		timer.start();
	}
	
	public void updateTamoHunger(Tamo tamo, int subtraction) {
		// Calculate hunger
		int hunger = (int) tamo.getHunger() - subtraction;
		
		// Validate hunger cannot be negative
		if(hunger < 0) {
			hunger = 0;
		}
		
		// Set hunger
		tamo.setHunger(hunger);
	}
	
	public void updateTamoHappy(Tamo tamo, int subtraction) {
		// Calculate hunger
		int happy = (int) tamo.getHappy() - subtraction;
		
		// Validate hunger cannot be negative
		if(happy < 0) {
			happy = 0;
		}
		
		// Set hunger
		tamo.setHappy(happy);
	}
}
