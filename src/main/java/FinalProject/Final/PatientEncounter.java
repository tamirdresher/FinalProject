package FinalProject.Final;

public class PatientEncounter {
	private potentialPatient detail=new potentialPatient(null, null, null, null);
	private Patient encounteredPatient=new Patient();
	
	public PatientEncounter(potentialPatient detail,Patient encounteredPatient) {
		this.setDetail(detail);
		this.setEncounteredPatient(encounteredPatient);
	}
	
	public potentialPatient getDetail() {
		return detail;
	}


	public void setDetail(potentialPatient detail) {
		this.detail = detail;
	}


	public Patient getEncounteredPatient() {
		return encounteredPatient;
	}


	public void setEncounteredPatient(Patient encounteredPatient) {
		this.encounteredPatient = encounteredPatient;
	}
	
}
