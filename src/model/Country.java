package model;

import java.util.ArrayList;

public class Country {
	private String name;
	private int totalMedals;
	private ArrayList<Team<Athlete>>allTeams;

	public Country(String name) {
		this.totalMedals =0 ;
		this.name = name;
		allTeams= new ArrayList<Team<Athlete>>();
	}
	public void addTeam(Team<Athlete> team) {
		allTeams.add(team);
	}


	public String getName() {
		return name;
	}
	public int getTotalMedals() {
		return totalMedals;
	}
	public ArrayList<Team<Athlete>> getAllTeams() {
		return allTeams;
	}
	public void addMedals() {
		this.totalMedals++;
	}
	@Override
	public String toString() {
		return "Country [name=" + name + ", totalMedals=" + totalMedals + "\n , allTeams=" + allTeams + "]";
	}

	


}
