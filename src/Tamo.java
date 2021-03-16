
public class Tamo {
	private String name;
	private int level;
	private int experience;
	private int happiness;
	private int hunger;
	
	public Tamo() {
		this.name = "null";
		this.level = -1;
		this.experience = -1;
		this.happiness = -1;
		this.hunger = -1;
		
	}
	
	public Tamo(String name) {
		this.name = name;
		this.level = 0;
		this.experience = 0;
		this.happiness = 0;
		this.hunger = 0;
	}
	
	public Tamo(String name, int level, int happiness, int hunger) {
		this.name = name;
		this.level = level;
		this.happiness = happiness;
		this.hunger = hunger;
	}

	//getters
	public String getName() {
		return name;
	}
	
	public int getLevel() {
		return level;
	}
	
	public int getHappiness() {
		return happiness;
	}
	
	public int getHunger() {
		return hunger;
	}
	
	//setters
	public void setHappiness(int happiness) {
		this.happiness = happiness;
	}
	
	public void setHunger(int hunger) {
		this.hunger = hunger;
	}
	
	//increment levels and decrement
	public void incrementHappiness() {
		if(this.happiness >= 0 && this.happiness < 10) {
			this.happiness = happiness++;
		} else {
			//Happiness level will not change because max already reached...
		}
		
	}
	
	public void incrementHunger() {
		if(this.hunger >= 0 && this.hunger < 10) {
			this.hunger = hunger++;
		} else {
			//hunger level will not change because max already reached...
		}
	}
	
	public void decrementHappiness() {
		if(this.happiness > 0 && this.happiness <= 10) {
			this.happiness = happiness--;
		} else {
			//happy level already lowest... 
		}
	}
	
	public void decrementHunger() {
		if(this.hunger > 0 && this.hunger <= 10) {
			this.hunger = hunger--;
		} else {
			//happy level already lowest... 
		}
	}
	
	public String tamoInfo() {
		return name + "," + level + "," + happiness + "," + hunger;
	}
	
	@Override
	public String toString() {
		return
				"Name: " + name +
				"\nLevel: " + level +
				"\nHappiness: " + happiness +
				"\nHunger: " + hunger;
	}

	public void setName(String tamoName) {
		this.name = tamoName;
		
	}

}
