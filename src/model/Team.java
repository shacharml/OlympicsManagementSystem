package model;

import java.util.ArrayList;

import model.Athlete.AthleteType;

public class Team {//<T extends Athlete>{

	//protected enum teamType {Runner , HighJumper}
	private AthleteType type;
	
	private ArrayList<Athlete> allAthletes ;
	//private T t;
	private String country;
	private int outCome;
	//
	public Team(String country , AthleteType type) {
		this.country = country;
		this.outCome = 0;
		this.type = type;
		this.allAthletes = new ArrayList<Athlete>(); 	
		
	}



	public AthleteType getType() {
		return type;
	}



	public int sumOfScoresAthlete() {
		
		for (int i = 0; i < allAthletes.size(); i++) {
			outCome += allAthletes.get(i).getScore();
		}
		
		return outCome;
	}

	public void addAthleteToTeam(Athlete athlete ) {
		allAthletes.add(athlete);
	}

	public int getOutCome() {
		return outCome;
	}

	public String getCountry() {
		return country;
	}

	@Override
	public String toString() {
		return "Team [allAthletes=" + allAthletes + ", country=" + country + ", outCome=" + outCome + "]" + "\n";
	}
	
	
	
	


}