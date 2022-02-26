package FinalProject.Final;

import java.util.ArrayList;

public class Patient {
	private static long Count=0;
	private long PatientID;
	private String govtID;
	private String firstName;
	private String lastName;
	private String birthDate;
	private String phoneNumber;
	private String email;
	private Address address;
	private int houseResidentsAmount;
	private String infectedByPatientID="";
	
	
	
	public Patient() {
		
	}
	
	
	public Patient(String id, String fname, String lname,String phone,String birthDate, String mail, Address house,int houseResidentsAmount,String isinfectedby) {
		this.PatientID=Count++;
		this.setGovtID(id);
		this.setFirstName(fname);
		this.setLastName(lname);
		this.setPhoneNumber(phone);
		this.setEmail(mail);
		this.setAddress(house);
		this.setBirthDate(birthDate);
		this.setInfectedByPatientID(isinfectedby);
	}
	


	public Patient(potentialPatient pat) {
		this.setGovtID(pat.getPotentialPatientID());
		this.setLastName(pat.getFirstName());
		this.setFirstName(pat.getLastName());
		this.setPhoneNumber(pat.getPhoneNumber());
		this.setEmail(null);
		this.setAddress(null);
	}



	public String getFirstName() {
		return firstName;
	}



	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}



	public String getGovtID() {
		return govtID;
	}



	public void setGovtID(String govtID) {
		this.govtID = govtID;
	}



	public String getBirthDate() {
		return birthDate;
	}



	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}



	public String getLastName() {
		return lastName;
	}



	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getPhoneNumber() {
		return phoneNumber;
	}



	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}



	public Address getAddress() {
		return address;
	}



	public void setAddress(Address address) {
		this.address = address;
	}



	public int getHouseResidentsAmount() {
		return houseResidentsAmount;
	}



	public void setHouseResidentsAmount(int houseResidentsAmount) {
		this.houseResidentsAmount = houseResidentsAmount;
	}



	
	public String getInfectedByPatientID() {
		return infectedByPatientID;
	}

	public void setInfectedByPatientID(String infectedByPatientID) {
		this.infectedByPatientID = infectedByPatientID;
	}


	
	
	
}
