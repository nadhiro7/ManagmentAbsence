package model;

public class Teacher {
	private String id;
	private String firstname;
	private String lastname;
	private String username;
	private String phone;
	private String address;
	private String password;
	public void setId(String id){
		this.id = id;
	}
	public void setFirstname(String firstname){
		this.firstname = firstname;
	}
	public void setLastname(String lastname){
		this.lastname = lastname;
	}
	public void setUsername(String username){
		this.username = username;
	}
	public void setPhone(String phone){
		this.phone = phone;
	}
	public void setPassword(String password){
		this.password = password;
	}
	public void setAddress(String address){
		this.address = address;
	}

	
	public String getId(){
		return this.id;
	}
	public String getFirstname(){
		return this.firstname;
	}
	public String getLastname(){
		return this.lastname;
	}
	public String getUsername(){
		return this.username;
	}
	public String getPhone(){
		return this.phone;
	}
	public String getPassword(){
		return this.password;
	}
	public String getAddress(){
		return this.address;
	}
}
