public class User {
	private String username;
	private String password;
	private String firstName;
	private String lastName;

	public User(String username, String password, String firstName, String lastName) {
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public getUsername() {
		return username;
	}

	public setUsername(String username) {
		this.username = username;
	}

	public getPassword() {
		return password;
	}

	public setPassword(String password) {
		this.password = password;
	}

	public getFirstName() {
		return firstName;
	}

	public setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public getLastName() {
		return lastName;
	}

	public setLastName(String lastName) {
		this.lastName = lastName;
	}
	
 }