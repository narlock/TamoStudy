
public class Tamo {
	private String name;
	private int level;
	private int experience;
	private int age;
	private int happiness;
	private int hunger;
	
	public Tamo() {
		this.name = "null";
		this.level = -1;
		this.experience = -1;
		this.age = -1;
		this.happiness = -1;
		this.hunger = -1;
		
	}
	
	public Tamo(String name) {
		this.name = name;
		this.level = 0;
		this.experience = 0;
		this.age = 0;
		this.happiness = 0;
		this.hunger = 0;
	}
	
	//getters
	public String getName() {
		return name;
	}
	
	public int getAge() {
		return age;
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
	
	@Override
	public String toString() {
		return
				"Name: " + name +
				"\nAge: " + age + " days" +
				"\nHappiness: " + happiness +
				"\nHunger: " + hunger;
	}
}
