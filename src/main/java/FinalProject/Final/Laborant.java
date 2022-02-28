package FinalProject.Final;

import java.util.ArrayList;

public class Laborant {
	
	public String Labtest(String labID, String testID,String PatientID, String TestDate,boolean isCovidPositive, ArrayList<PatientMedicalFile> patients,ArrayList<potentialPatient> poten, statisticsHandler handler) {
		for(potentialPatient pat: poten){
			if(pat.getPotentialPatientID().equals(PatientID)) {
				if(isCovidPositive) {
					patients.add(new PatientMedicalFile(new Patient(), new ArrayList<LabTestResult>())) 
					patients.get(patients.indexOf(pat)).getLabResults().add(new LabTestResult(labID,testID,PatientID,TestDate,isCovidPositive));
					poten.remove(pat);
					return patients.get(patients.indexOf(pat)).getLabResults().get(patients.get(patients.indexOf(pat)).getLabResults().size()-1).getPatientID();
				}
				
			}
		}
		
		
		for(PatientMedicalFile pat: patients){
			if(pat.getFileOfPatient().getGovtID().equals(PatientID)) {
				
				patients.get(patients.indexOf(pat)).getLabResults().add(new LabTestResult(labID,testID,PatientID,TestDate,isCovidPositive));
				handler.updateStat(PatientID, patients);
				return patients.get(patients.indexOf(pat)).getLabResults().get(patients.get(patients.indexOf(pat)).getLabResults().size()-1).getPatientID();

			}
			
		}
		handler.updateStat(PatientID, patients);
		return null;
	}
}
