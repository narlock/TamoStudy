import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Profile {
	private String username;
	private String password;
	
	private Date join_date;
	private Date last_login_date;
	private Date new_login_date;
	private SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	private String dateString;
	private String lastLoginString;
	private String newLoginString;
	
	private Tamo tamo;
	private int money;
	private int totalTime;
	private int currentBackground;
	private String guiColor;
	
	private int warnings;
	
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
		
		this.last_login_date = new Date();
		this.lastLoginString = formatter.format(last_login_date);
		this.currentBackground = 0;
		
		this.guiColor = "default";
		
		this.warnings = 0;
	}
	
	
	//When loading profile, use this
	public Profile(String username, String password, String dateString, int totalTime, int money, Tamo tamo, String lastLoginString, int currentBackground, String guiColor, int warnings) {
		this.username = username;
		this.password = password;
		this.dateString = dateString;
		this.money = money;
		this.totalTime = totalTime;
		
		this.tamo = tamo;
		
		this.lastLoginString = lastLoginString;
		
		this.new_login_date = new Date();
		this.newLoginString = formatter.format(new_login_date);
		
		this.currentBackground = currentBackground;
		
		this.guiColor = guiColor;
		
		this.warnings = warnings;
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

	public String getLastLoginString() {
		return lastLoginString;
	}

	public void setLastLoginString(String lastLoginString) {
		this.lastLoginString = lastLoginString;
	}

	public Date getLast_login_date() {
		return last_login_date;
	}

	public void setLast_login_date(Date last_login_date) {
		this.last_login_date = last_login_date;
	}

	public int getCurrentBackground() {
		return currentBackground;
	}

	public void setCurrentBackground(int currentBackground) {
		this.currentBackground = currentBackground;
	}

	public String getNewLoginString() {
		return newLoginString;
	}

	public void setNewLoginString(String newLoginString) {
		this.newLoginString = newLoginString;
	}
	
	public Date getNew_login_date() {
		return new_login_date;
	}
 
	public String getGuiColor() {
		return guiColor;
	}

	public void setGuiColor(String guiColor) {
		this.guiColor = guiColor;
	}

	public int getWarnings() {
		return warnings;
	}

	public void setWarnings(int warnings) {
		this.warnings = warnings;
	}
}
