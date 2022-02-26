package FinalProject.Final;

import java.util.ArrayList;

public class PatientMedicalFile {
	private Patient FileOfPatient;
	private ArrayList<LabTestResult>labResults=new ArrayList<LabTestResult>();
	
	
	public PatientMedicalFile(Patient FileOfPatient,ArrayList<LabTestResult>labResults) {
		this.setFileOfPatient(FileOfPatient);
		this.setLabResults(labResults);
	}
	
	public Patient getFileOfPatient() {
		return FileOfPatient;
	}
	public void setFileOfPatient(Patient fileOfPatient) {
		FileOfPatient = fileOfPatient;
	}
	public ArrayList<LabTestResult> getLabResults() {
		return labResults;
	}
	public void setLabResults(ArrayList<LabTestResult> labResults) {
		this.labResults = labResults;
	}
	
}
