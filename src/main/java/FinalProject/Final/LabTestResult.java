package FinalProject.Final;

public class LabTestResult {
	private String labId;
	private String testId;
	private String patientID;
	private String testDate;
	private boolean isCovidPositive;
	
	public LabTestResult(String labId,String testId,String patientID,String testDate,boolean isCovidPositive) {
		this.setCovidPositive(isCovidPositive);
		this.setLabId(labId);
		this.setPatientID(patientID);
		this.setTestDate(testDate);
		this.setTestId(testId);
	}
	
	
	
	
	public String getLabId() {
		return labId;
	}
	public void setLabId(String labId) {
		this.labId = labId;
	}
	public String getTestDate() {
		return testDate;
	}
	public void setTestDate(String testDate) {
		this.testDate = testDate;
	}
	public String getTestId() {
		return testId;
	}
	public void setTestId(String testId) {
		this.testId = testId;
	}
	public boolean isCovidPositive() {
		return isCovidPositive;
	}
	public void setCovidPositive(boolean isCovidPositive) {
		this.isCovidPositive = isCovidPositive;
	}
	public String getPatientID() {
		return patientID;
	}
	public void setPatientID(String patientID) {
		this.patientID = patientID;
	}
}
