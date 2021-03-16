import java.util.Date;

public class Profile {
	private String username;
	private String password;
	
	private Date join_date;
	
	private Tamo tamo;
	
	public Profile() {
		//TODO
	}
	
	public Profile(String username, String password, String tamoName) {
		this.username = username;
		this.password = password;
		this.tamo = new Tamo(tamoName);
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
}
