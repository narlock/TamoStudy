import java.text.SimpleDateFormat;
import java.util.Date;

public class Profile {
	private String username;
	private String password;
	
	private Date join_date;
	private SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	private String dateString;
	
	private Tamo tamo;
	private int money;
	private int totalTime;
	
	public Profile() {
		this.username = "null";
		this.password = "null";
		this.tamo = new Tamo();
		
		this.join_date = new Date();
		this.dateString = formatter.format(join_date);
		
		this.totalTime = 0;
		
		this.money = -1;
	}
	
	public Profile(String username, String password, String tamoName) {
		this.username = username;
		this.password = password;
		this.tamo = new Tamo(tamoName);
		
		this.join_date = new Date();
		this.dateString = formatter.format(join_date);
		
		this.totalTime = 0;
		
		this.money = 0;
	}
	
	
	//When loading profile, use this
	public Profile(String username, String password, String dateString, int totalTime, int money, Tamo tamo) {
		this.username = username;
		this.password = password;
		this.dateString = dateString;
		this.money = money;
		this.totalTime = totalTime;
		
		this.tamo = tamo;
	}


	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getJoin_date() {
		return join_date;
	}

	public Tamo getTamo() {
		return tamo;
	}

	public void setTamo(Tamo tamo) {
		this.tamo = tamo;
	}

	public String getJoinDate() {
		return dateString;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}
	
	public int getTotalTime(int minutes, int seconds) {	
		//Convert tempMin to seconds
		int convertedSeconds = minutes * 60;
		
		this.totalTime = this.totalTime + convertedSeconds;
		
		//Returns totalTimeInSession (in seconds)
		return totalTime;
	}
	public int getTotalTime() {
		return totalTime;
	}
	
	public void setTotalTime(int totalTime) {
		this.totalTime = totalTime;
	}
}
