package FinalProject.Final;

public class Station {
	private String dateOfVisit;
	private String siteName;
	private Address siteAddress;
	
	
	public Station(String date, String city, String street,Address siteAddress) {
		this.dateOfVisit=date;
		this.siteName=city;
		this.setSiteAddress(siteAddress);
		
	}
	
	public String getdateOfVisit() {
		return dateOfVisit;
	}
	public void setdateOfVisit(String dateOfVisit) {
		this.dateOfVisit = dateOfVisit;
	}
	public String getsiteName() {
		return siteName;
	}
	public void setsiteName(String cityName) {
		this.siteName = cityName;
	}

	public Address getSiteAddress() {
		return siteAddress;
	}

	public void setSiteAddress(Address siteAddress) {
		this.siteAddress = siteAddress;
	}
	
}
