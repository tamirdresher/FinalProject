package FinalProject.Final;

public class potentialPatient {
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String potentialPatientID;
	
	public potentialPatient(String id,String firstName,String lastName,String phoneNumber) {
		this.potentialPatientID=id;
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setPhoneNumber(phoneNumber);
		
	}
	
	
	
	
	public String getPotentialPatientID() {
		return potentialPatientID;
	}
	public void setPotentialPatientID(String potentialPatientID) {
		this.potentialPatientID = potentialPatientID;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
}
