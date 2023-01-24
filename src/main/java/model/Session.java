package model;

public class Session {
	private int sessionId;
	private String nameModule;
	private String teacherId;
	private String groupe;
	private String date;
	
	public void setSessionId(int sessionId){
		this.sessionId = sessionId;
	}
	public void setNameModule(String nameModule){
		this.nameModule = nameModule;
	}
	public void setGroupe(String groupe){
		this.groupe = groupe;
	}
	public void setTeacherId(String string){
		this.teacherId = string;
	}
	public void setDate(String date){
		this.date = date;
	}
	
	public int getSessionId(){
		return this.sessionId;
	}
	public String getNameModule(){
		return this.nameModule;
	}
	public String getGroupe(){
		return this.groupe;
	}
	public String getTeacherId(){
		return this.teacherId;
	}
	public String getDate(){
		return this.date;
	}

}
