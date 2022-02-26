package FinalProject.Final;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class FinalApplicationTests {

	

	@Test
	public void AssertAddress() throws Exception {
		
		
		System sys=new System();
		Patient pat=new Patient("a", "b", "c", "d","e" ,"f" , new Address("aa", null, 0, 0), 0, "g");
		ArrayList<PatientMedicalFile> files=new ArrayList<PatientMedicalFile>();
		sys.GetNurse().AddPatient(new ArrayList<PatientEncounter>(), new ArrayList<potentialPatient>(), new ArrayList<Station>(), new ArrayList<Route>(),
				files, pat.getGovtID(), pat.getFirstName(), pat.getLastName(), pat.getPhoneNumber(), pat.getBirthDate(), pat.getEmail(), pat.getAddress(), 0, pat.getInfectedByPatientID(), true, null, sys.GetStat());
		assertEquals(files.get(0).getFileOfPatient().getAddress(),pat.getAddress());
	}
	
	
	@Test
	public void AssertLabTestResult() throws Exception {
		
		
		System sys=new System();
		Patient pat=new Patient("a", "b", "c", "d","e" ,"f" , new Address("aa", null, 0, 0), 0, "g");
		ArrayList<PatientMedicalFile> files=new ArrayList<PatientMedicalFile>();
		sys.GetNurse().AddPatient(new ArrayList<PatientEncounter>(), new ArrayList<potentialPatient>(), new ArrayList<Station>(), new ArrayList<Route>(),
				files, pat.getGovtID(), pat.getFirstName(), pat.getLastName(), pat.getPhoneNumber(), pat.getBirthDate(), pat.getEmail(), pat.getAddress(), 0, pat.getInfectedByPatientID(), true, null, sys.GetStat());
		
		String id=sys.GetLaborant().Labtest("", "", "a", "", true, files, sys.GetNurse().getIsolated(),sys.GetStat());
		assertEquals(id,"a");
	}
	
	
	@Test
	public void AssertInfectedInAllCities() throws Exception {
		
		
		System sys=new System();
		Patient pat=new Patient("a", "b", "c", "d","e" ,"f" , new Address("aa", null, 0, 0), 0, "g");
		ArrayList<PatientMedicalFile> files=new ArrayList<PatientMedicalFile>();
		sys.GetNurse().AddPatient(new ArrayList<PatientEncounter>(), new ArrayList<potentialPatient>(), new ArrayList<Station>(), new ArrayList<Route>(),
				files, pat.getGovtID(), pat.getFirstName(), pat.getLastName(), pat.getPhoneNumber(), pat.getBirthDate(), pat.getEmail(), pat.getAddress(), 0, pat.getInfectedByPatientID(), true, null,sys.GetStat());
		
		String id=sys.GetLaborant().Labtest("", "", "a", "", true, files, sys.GetNurse().getIsolated(),sys.GetStat());
		assertEquals(sum(sys.GetStat().getCityStat()),sys.GetStat().infected);
	}
	
	private int sum(ArrayList<CityCovidStats> city) {
		int sum=0;
		for(CityCovidStats cit:city) {
			sum+=cit.getInfectedCount();
		}
		return sum;
	}
	
	
	
	@Test
	public void AssertRoutesWereAdded() throws Exception {
		
		
		System sys=new System();
		Patient pat=new Patient("a", "b", "c", "d","e" ,"f" , new Address("aa", null, 0, 0), 0, "g");
		ArrayList<PatientMedicalFile> files=new ArrayList<PatientMedicalFile>();
		ArrayList<Route>routes=new ArrayList<Route>();
		routes.add(new Route("a"));
		ArrayList<Station>stations=new ArrayList<Station>();
		stations.add(new Station("", "", "", new Address("aa", null, 0, 0)));
		
		Patient id=sys.GetNurse().AddPatient(new ArrayList<PatientEncounter>(), new ArrayList<potentialPatient>(),stations, routes,
				files, pat.getGovtID(), pat.getFirstName(), pat.getLastName(), pat.getPhoneNumber(), pat.getBirthDate(), pat.getEmail(), pat.getAddress(), 0, pat.getInfectedByPatientID(), true, null,sys.GetStat());
		
		assertEquals(stations.get(0),routes.get(0).getStations().get(routes.get(0).getStations().size()-1));
	}
	
	
	
	
	@Test
	public void AssertEncounteredWasAddedToIsolated() throws Exception {
		
		
		System sys=new System();
		Patient pat=new Patient("a", "b", "c", "d","e" ,"f" , new Address("aa", null, 0, 0), 0, "g");
		ArrayList<PatientMedicalFile> files=new ArrayList<PatientMedicalFile>();
		ArrayList<PatientEncounter>encounters=new ArrayList<PatientEncounter>();
		ArrayList<potentialPatient>isolated=new ArrayList<potentialPatient>();
		isolated.add(new potentialPatient("","","", ""));
		
		Patient id=sys.GetNurse().AddPatient(encounters, isolated, new ArrayList<Station>(), new ArrayList<Route>(),
				files, pat.getGovtID(), pat.getFirstName(), pat.getLastName(), pat.getPhoneNumber(), pat.getBirthDate(), pat.getEmail(), pat.getAddress(), 0, pat.getInfectedByPatientID(), true, null,sys.GetStat());
		
		assertEquals(encounters.get(encounters.size()-1).getDetail(),isolated.get(isolated.size()-1));
	}
	
}
