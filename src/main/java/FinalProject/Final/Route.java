package FinalProject.Final;

import java.util.ArrayList;

public class Route {
	private String id;
	private ArrayList<Station> stations;
	
	public Route(String id) {
		this.setStations(new ArrayList<Station>());
		this.setId(id);
	}

	public ArrayList<Station> getStations() {
		return stations;
	}

	public void setStations(ArrayList<Station> stations) {
		this.stations = stations;
	}
	
	public void AddStation(Station toAdd) {
		this.stations.add(toAdd);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
} 
