package FinalProject.Final;

public class Address {
	private String city;
	private String street;
	private int houseNumber;
	private int apartmentNumber;
	
	public Address(String city, String street,int houseNum,int apartNum) {
		this.setCity(city);
		this.setHouseNumber(houseNum);
		this.setStreet(street);
		this.setApartmentNumber(apartNum);
	}
	
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public int getHouseNumber() {
		return houseNumber;
	}
	public void setHouseNumber(int houseNumber) {
		this.houseNumber = houseNumber;
	}
	public int getApartmentNumber() {
		return apartmentNumber;
	}
	public void setApartmentNumber(int apartmentNumber) {
		this.apartmentNumber = apartmentNumber;
	}
}
