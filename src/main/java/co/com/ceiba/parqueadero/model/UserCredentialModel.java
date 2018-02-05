package co.com.ceiba.parqueadero.model;

public class UserCredentialModel {
	@Override
	public String toString() {
		return "UserCredentialModel [username=" + username + ", password=" + password + "]";
	}
	private String username;
	private String password;
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
	public UserCredentialModel(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	public UserCredentialModel() {
		super();
	}
	
	
}
