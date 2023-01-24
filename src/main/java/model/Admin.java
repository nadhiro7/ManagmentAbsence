package model;

public class Admin {
	private String firstname;
	private String lastname;
	private String email;
	private String password;
	public void setFirstname(String firstname){
		this.firstname = firstname;
	}
	public void setLastname(String lastname){
		this.lastname = lastname;
	}
	public void setEmail(String email){
		this.email = email;
	}
	public void setPassword(String password){
		this.password = password;
	}

	public String getFirstname(){
		return this.firstname;
	}
	public String getLastname(){
		return this.lastname;
	}
	public String getEmail(){
		return this.email;
	}
	public String getPassword(){
		return this.password;
	}
}
