package FinalProject.Final;

import java.util.ArrayList;

public class statisticsHandler {
	private ArrayList<CityCovidStats> CityStat=new ArrayList<CityCovidStats>();
	public int infected=0;
	public int healed=0;
	public int isolated=0;
	
	
	
	public statisticsHandler() {
		this.setCityStat(new ArrayList<CityCovidStats>());
	}

	public void InfectedUp() {
		this.infected++;
	}
	
	public void healedUp() {
		this.healed++;
	}
	
	public void isolatedUp() {
		this.isolated++;
	}
	
	
	
	
	
	public ArrayList<CityCovidStats> getCityStat() {
		return CityStat;
	}

	
	public void setCityStat(ArrayList<CityCovidStats> cityStat) {
		CityStat = cityStat;
	}
	
	
	
	
	public void updateStat(String id,ArrayList<PatientMedicalFile> patientList) {
		for(PatientMedicalFile medic: patientList) {
			if(medic.getFileOfPatient().getGovtID().equals(id)&& medic.getLabResults().size()==1) {
				for(CityCovidStats city:getCityStat()) {
					if(city.cityName.equals(medic.getFileOfPatient().getAddress().getCity())) {
						getCityStat().get(getCityStat().indexOf(city)).InfectedUp();
						return;
					}
					
				}
				CityCovidStats newCity=new CityCovidStats(medic.getFileOfPatient().getAddress().getCity());
				getCityStat().add(newCity);
				getCityStat().get(getCityStat().size()-1).InfectedUp();
				InfectedUp();
			}
		}
	}

}