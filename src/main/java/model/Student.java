package model;

import java.math.BigInteger;

public class Student {
	private String firstname;
	private String lastname;
	private String groupe;
	private String email;
	private String address;
	private String studentId;
	private String state;
	public void setFirstname(String firstname){
		this.firstname = firstname;
	}
	public void setLastname(String lastname){
		this.lastname = lastname;
	}
	public void setGroupe(String groupe){
		this.groupe = groupe;
	}
	public void setEmail(String email){
		this.email = email;
	}
	public void setStudentId(String string){
		this.studentId = string;
	}
	public void setAddress(String address){
		this.address = address;
	}
	public void setState(String state){
		this.state = state;
	}

	public String getFirstname(){
		return this.firstname;
	}
	public String getLastname(){
		return this.lastname;
	}
	public String getGroupe(){
		return this.groupe;
	}
	public String getEmail(){
		return this.email;
	}
	public String getStudentId(){
		return this.studentId;
	}
	public String getAddress(){
		return this.address;
	}
	public String getState(){
		return this.state;
	}
}
