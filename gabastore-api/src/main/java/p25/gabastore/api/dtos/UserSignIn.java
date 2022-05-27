package p25.gabastore.api.dtos;

public class UserSignIn {

    private String username;

    private String password;

    public UserSignIn() {
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

    @Override
    public String toString() {
	return String.format("{username=%s, password=%s}", username, "[PROTECTED]");
    }

}
