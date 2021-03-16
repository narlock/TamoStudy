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
	
	public Profile() {
		this.username = "null";
		this.password = "null";
		this.tamo = new Tamo();
		
		this.join_date = new Date();
		this.dateString = formatter.format(join_date);
		
		this.money = -1;
	}
	
	public Profile(String username, String password, String tamoName) {
		this.username = username;
		this.password = password;
		this.tamo = new Tamo(tamoName);
		
		this.join_date = new Date();
		this.dateString = formatter.format(join_date);
		
		this.money = 0;
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
}
