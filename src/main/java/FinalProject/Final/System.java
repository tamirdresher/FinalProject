package FinalProject.Final;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
@RestController

public class System {
	private statisticsHandler handler;
	private ArrayList<PatientMedicalFile> patientList=new ArrayList<PatientMedicalFile>();
	private ArrayList<PatientEncounter> Encounters=new ArrayList<PatientEncounter>();
	private ArrayList<Route> routes=new ArrayList<Route>();
	private ArrayList<Station> stations=new ArrayList<Station>();
	private ArrayList<potentialPatient> Encounters1=new ArrayList<potentialPatient>();
	private ArrayList<potentialPatient> isolated=new ArrayList<potentialPatient>();
	private Nurse nurse;
	private Laborant lab;

	
	public System() {
		this.lab=new Laborant();
		this.handler=new statisticsHandler();
		this.nurse=new Nurse(isolated);
		this.handler.setCityStat(new ArrayList<CityCovidStats>());
		
		
		
	}
	
	public Nurse GetNurse() {
		return this.nurse;
	}
	
	public Laborant GetLaborant() {
		return this.lab;
	}
	
	public statisticsHandler GetStat() {
		return this.handler;
	}
	
	
	@PutMapping("/patients")
	public Patient addPatient(@RequestBody Patient pat) {
		
		Patient patient=nurse.AddPatient(Encounters,Encounters1,
				stations,routes, patientList,
				pat.getGovtID(), pat.getFirstName(), pat.getLastName(), pat.getPhoneNumber(),pat.getBirthDate(), pat.getEmail(), 
				pat.getAddress(),pat.getHouseResidentsAmount(),pat.getInfectedByPatientID(),true,"",handler);
		
		return patient;
		
		
	}
	
	@GetMapping("/patients")
	public ArrayList<Patient> allPatients() {
		ArrayList<Patient>pat=new ArrayList<Patient>();
		for(PatientMedicalFile medic: this.patientList) {
			pat.add(medic.getFileOfPatient());
		}
		return pat;
	}
	
	@PutMapping("/patients/{id}/route")
	public Route addRoute(@PathVariable String id,@RequestBody Station stationToAdd) {
		for(Route route:routes) {
			if(route.getId().equals(id)) {
				routes.get(routes.indexOf(route)).AddStation(stationToAdd);
				return routes.get(routes.indexOf(route));
			}
		}
		routes.add(new Route(id));
		routes.get(routes.size()-1).AddStation(stationToAdd);
		return routes.get(routes.size()-1);
	}
	
	
	@GetMapping("/patients/{id}/route")
	public ArrayList<Station> ReturnRoutes(@PathVariable String id) {
		for(Route route:routes) {
			if(route.getId().equals(id))
				return route.getStations();
		}
		return null;
	}
	
	
	@PutMapping("/patients/{id}/encounters")
	public void addEncounter(@RequestBody potentialPatient patient,@PathVariable String id) {
		
		for(PatientMedicalFile medic: this.patientList) {
			if(medic.getFileOfPatient().getGovtID().equals(id)) {
				Encounters.add(new PatientEncounter(patient, medic.getFileOfPatient()));
				
				this.handler.isolatedUp();
			}
		}
	}
	
	
	

	@GetMapping("/patients/{id}/encounters")
	public PatientEncounter ReturnEncounters(@PathVariable String id) {

		for(PatientEncounter encounter:Encounters) {
			if(encounter.getEncounteredPatient().getGovtID().equals(id))return encounter;
		}
		return null;
	}
	
	@GetMapping("/patients/{id}/full")
	public PatientMedicalFile ReturnPatient(@PathVariable String id) {
		for(PatientMedicalFile file:patientList) {
			if(file.getFileOfPatient().getGovtID().equals(id))
				return file;
		}
		return null;
	}
	
	
	@GetMapping("/patients/potential")
	public ArrayList<PatientEncounter> ReturnPotentialPatient() {
		return this.Encounters;
	}
	
	
	
	
	
	@GetMapping("/patients/isolated")
	public ArrayList<PatientEncounter> returnIsolated() {
		return this.Encounters;
	}
	
	@PostMapping("patients/potential/{potentialPatientId}")
	public Patient FromPotIntoReal(@RequestBody Patient pat,@PathVariable String potentialPatientId) {
		return nurse.AddPatient(Encounters,Encounters1,
				stations,routes, patientList,
				pat.getGovtID(), pat.getFirstName(), pat.getLastName(), pat.getPhoneNumber(),pat.getBirthDate(), pat.getEmail(), 
				pat.getAddress(),pat.getHouseResidentsAmount(),pat.getInfectedByPatientID(),true,potentialPatientId, handler);
	}
	
	@PostMapping("/labtests")
	public String AssignLab(@RequestBody LabTestResult labt) {
		String id=lab.Labtest(labt.getLabId(), labt.getTestId(), labt.getPatientID(), labt.getTestDate(), labt.isCovidPositive(), patientList, isolated,handler);
		
		return id;
	}
	
	

	@GetMapping("/statistics")
	public statisticsHandler viewStats() {
		
		return this.handler;
	}
	
	
	
	
	
	
	@GetMapping("/patients/new")
	public ArrayList<Patient> soemthing(@RequestBody String since) {
		ArrayList<Patient> patientsSince=new ArrayList<Patient>();
		for(PatientMedicalFile pant:patientList) {
			if(pant.getLabResults().get(0).getTestDate().compareTo(since)==-1)
				patientsSince.add(pant.getFileOfPatient());
		}
		return patientsSince;
	}
	
}

