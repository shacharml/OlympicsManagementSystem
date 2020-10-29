package model;

import java.util.ArrayList;

public class Country {
	private String name;
	private int totalMedals;
	private ArrayList<Team>allTeams;

	public Country(String name) {
		this.totalMedals =0 ;
		this.name = name;
		allTeams= new ArrayList<Team>();
	}
	public void addTeam(Team team) {
		allTeams.add(team);
	}


	public String getName() {
		return name;
	}
	public int getTotalMedals() {
		return totalMedals;
	}
	public ArrayList<Team> getAllTeams() {
		return allTeams;
	}
	public void addMedals() {
		this.totalMedals++;
	}
	@Override
	public String toString() {
		String str = name + ": \n";
		str += "Number of meadals : " +totalMedals+ "\n";
		for (int i = 0; i < allTeams.size(); i++) {
			str+= (i+1) +") " + allTeams.get(i).toString()+"\n";
		}
		str+= "\n\n";
		return   str;
	}

	


}