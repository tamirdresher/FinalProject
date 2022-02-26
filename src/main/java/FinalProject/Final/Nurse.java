package FinalProject.Final;

import java.util.ArrayList;

public class Nurse 
{
	private ArrayList<potentialPatient> isolated=new ArrayList<potentialPatient>();
	
	public Nurse( ArrayList<potentialPatient> isolated) {
		this.isolated=isolated;
	}
	

	public Patient AddPatient(ArrayList<PatientEncounter>encountered,ArrayList<potentialPatient>listOfEncountered,
			ArrayList<Station>stations,ArrayList<Route> route,ArrayList<PatientMedicalFile> patients,
			String id, String fname, String lname, String phone,String birthDate, String mail, 
			Address house,int houseResidentsAmount,String InfectedBy,boolean isCovidPositive,String potentialPatientId, statisticsHandler handler) {
		
		
		Patient pat=new Patient(id, fname, lname, phone,birthDate, mail, house,houseResidentsAmount,InfectedBy);
		for(PatientMedicalFile pat1: patients){
			if(pat1.getFileOfPatient().getGovtID().equals(pat.getGovtID())) {
				patients.get(patients.indexOf(pat1)).setFileOfPatient(pat);
				handler.updateStat(pat.getGovtID(), patients);
				return pat;
			}
		}
		
		for(Route routes: route){
			if(routes.getId().equals(id)) {
				route.get(route.indexOf(routes)).setStations(stations);
				
			}
		}
		
		for(potentialPatient potential:listOfEncountered) {
			encountered.add(new PatientEncounter(potential,pat));
			isolated.add(potential);
		}
		
		for(potentialPatient potential:isolated) {
			if(potential.getPotentialPatientID().equals(potentialPatientId)) {
				isolated.remove(potential);
			}
		}
		
		if(isCovidPositive) {
			patients.add(new PatientMedicalFile(pat, new ArrayList<LabTestResult>()));
		}
		handler.updateStat(pat.getGovtID(), patients);
		return patients.get(patients.size()-1).getFileOfPatient();
		
	}
	
		
	
	public void ContactIsolated(String fname,String lname,String phone) {
		for(potentialPatient patient:isolated){
			if(patient.getFirstName()==fname){
				isolated.get(isolated.indexOf(patient)).setFirstName(fname);
				isolated.get(isolated.indexOf(patient)).setLastName(lname);;
				isolated.get(isolated.indexOf(patient)).setPhoneNumber(phone);
			}
		}
	}
	
	
	
	

	public ArrayList<potentialPatient> getIsolated() {
		return isolated;
	}

	public void addIsolated(ArrayList<potentialPatient> isolated) {
		this.isolated = isolated;
	}

	
}
