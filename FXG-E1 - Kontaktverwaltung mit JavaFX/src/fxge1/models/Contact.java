package fxge1.models;

public class Contact {

	
	private String fName ;	
	private String profileBase64;
	private String lName;
	private String eMail;

	public Contact(String fName , String lName , String eMail, String profileBase64) {
		this.fName = fName;
		this.lName = lName;
		this.eMail= eMail;
		this.profileBase64 = profileBase64;
		
	}
	
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getProfileBase64() {
		return profileBase64;
	}
	public void setProfileBase64(String profileBase64) {
		this.profileBase64 = profileBase64;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public String geteMail() {
		return eMail;
	}
	public void seteMail(String eMail) {
		this.eMail = eMail;
	}
}