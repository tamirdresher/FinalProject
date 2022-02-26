package FinalProject.Final;

public class CityCovidStats {
	public String cityName;
	private int InfectedCount=0;
	
	public CityCovidStats(String name) {
		this.cityName=name;
		
	}
	
	
	public void InfectedUp() {
		this.InfectedCount += 1;
	}


	public int getInfectedCount() {
		return InfectedCount;
	}

	
	
}
