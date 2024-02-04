package test.model.profile;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;

import org.junit.jupiter.api.Test;

import model.language.EnglishLanguage;
import model.profile.Profile;
import model.profile.ProfileSettings;
import model.profile.ProfileUpdateManager;
import model.profile.Tamo;
import resources.Debug;
import util.Utils;

class ProfileUpdateManagerTests {
	
	void updateHappyHungerOnDayChange(Profile profile) {
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
			Debug.info("ProfileUpdateManager.updateHappyHungerOnDayChange", 
					"daysBetween = " + daysBetween);
			
			if(daysBetween < 3) {
				updateTamoHunger(profile.getTamo(), 2);
				updateTamoHappy(profile.getTamo(), 1);
				
				if((profile.getTamo().getHunger() < 2 || profile.getTamo().getHappy() < 2) && profile.getSettings().getDifficulty() != 0) {
					profile.getTamo().setStrikes(profile.getTamo().getStrikes() + 1);
					Debug.info("ProfileUpdateManager.updateHappyHungerOnDayChange", "Strike added to tamo " + profile.getTamo().getName() + ", now has " + profile.getTamo().getStrikes() + ".");
				}
			} else if(daysBetween < 7 && daysBetween >= 3) {
				updateTamoHunger(profile.getTamo(), 3);
				updateTamoHappy(profile.getTamo(), 2);
				
				if((profile.getTamo().getHunger() < 2 || profile.getTamo().getHappy() < 2) && profile.getSettings().getDifficulty() != 0) {
					profile.getTamo().setStrikes(profile.getTamo().getStrikes() + 1);
					Debug.info("ProfileUpdateManager.updateHappyHungerOnDayChange", "Strike added to tamo " + profile.getTamo().getName() + ", now has " + profile.getTamo().getStrikes() + ".");
				}
			} else if(daysBetween >= 7 && daysBetween < 30) {
				updateTamoHunger(profile.getTamo(), 10);
				updateTamoHappy(profile.getTamo(), 10);
				
				if((profile.getTamo().getHunger() < 2 || profile.getTamo().getHappy() < 2) && profile.getSettings().getDifficulty() != 0) {
					profile.getTamo().setStrikes(profile.getTamo().getStrikes() + 1);
					Debug.info("ProfileUpdateManager.updateHappyHungerOnDayChange", "Strike added to tamo " + profile.getTamo().getName() + ", now has " + profile.getTamo().getStrikes() + ".");
				}
			} else if(daysBetween >= 30 && profile.getSettings().getDifficulty() != 0) {
				profile.getTamo().setStrikes(3);
				Debug.info("ProfileUpdateManage.updateHappyHungerOnDayChange", "User did not login within 30 days. Tamo automatically passes.");
			}
			
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
	
	public Profile createTestProfile() {
		return new Profile(
				123,
				"TestName",
				Utils.todayAsString(),
				1000,
				100,
				new ProfileSettings(new EnglishLanguage(), 0, 1),
				0,
				0,
				new ArrayList<Long>(),
				new ArrayList<Long>(),
				new ArrayList<Long>(),
				new ArrayList<Long>(),
				new Tamo("Lisa"),
				new ArrayList<Tamo>()
			);
	}

	@Test
	void testUpdateHappyHungerOnChangeSameDay() {
		Profile profile = createTestProfile();
		
		updateHappyHungerOnDayChange(profile);
		
		assertEquals(profile.getTamo().getStrikes(), 0);
		assertEquals(profile.getTamo().getHappy(), 7);
		assertEquals(profile.getTamo().getHunger(), 8);
	}
	
	@Test
	void testUpdateHappyHungerOnChangeDaysBetween3NoStrikes() {
		// Get the current date
        LocalDate currentDate = Utils.today().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate previousDate = currentDate.minusDays(1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String previousDateString = previousDate.format(formatter);
        
        // Test today - 1
		Profile profile = createTestProfile();
		profile.setPreviousDateString(previousDateString);
		updateHappyHungerOnDayChange(profile);
		
		assertEquals(profile.getTamo().getStrikes(), 0);
		assertEquals(profile.getTamo().getHappy(), 6);
		assertEquals(profile.getTamo().getHunger(), 6);
		
		// Test today - 2
		previousDate.minusDays(1);
		previousDateString = previousDate.format(formatter);
		Profile profile2 = createTestProfile();
		profile2.setPreviousDateString(previousDateString);
		updateHappyHungerOnDayChange(profile2);
		
		assertEquals(profile2.getTamo().getStrikes(), 0);
		assertEquals(profile2.getTamo().getHappy(), 6);
		assertEquals(profile2.getTamo().getHunger(), 6);
	}
	
	@Test
	void testUpdateHappyHungerOnChangeDaysBetween3Strikes() {
		// Get the current date
        LocalDate currentDate = Utils.today().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate previousDate = currentDate.minusDays(1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String previousDateString = previousDate.format(formatter);
        
        // Test today - 1
		Profile profile = createTestProfile();
		profile.getTamo().setHappy(2);
		profile.getTamo().setHunger(2);
		profile.setPreviousDateString(previousDateString);
		updateHappyHungerOnDayChange(profile);
		
		assertEquals(profile.getTamo().getStrikes(), 1);
		assertEquals(profile.getTamo().getHappy(), 1);
		assertEquals(profile.getTamo().getHunger(), 0);
	}

	
	@Test
	void testUpdateHappyHungerOnChangeDaysBetween3and7NoStrikes() {
		// Get the current date
        LocalDate currentDate = Utils.today().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate previousDate = currentDate.minusDays(3);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String previousDateString = previousDate.format(formatter);
        
        // Test today - 1
		Profile profile = createTestProfile();
		profile.setPreviousDateString(previousDateString);
		updateHappyHungerOnDayChange(profile);
		
		assertEquals(0, profile.getTamo().getStrikes());
		assertEquals(5, profile.getTamo().getHappy());
		assertEquals(5, profile.getTamo().getHunger());
	}
	
	@Test
	void testUpdateHappyHungerOnChangeDaysBetween3and7Strikes() {
		// Get the current date
        LocalDate currentDate = Utils.today().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate previousDate = currentDate.minusDays(3);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String previousDateString = previousDate.format(formatter);
        
        // Test today - 1
		Profile profile = createTestProfile();
		profile.getTamo().setHappy(4);
		profile.getTamo().setHunger(4);
		profile.setPreviousDateString(previousDateString);
		updateHappyHungerOnDayChange(profile);
		
		assertEquals(1, profile.getTamo().getStrikes());
		assertEquals(2, profile.getTamo().getHappy());
		assertEquals(1, profile.getTamo().getHunger());
	}
}
