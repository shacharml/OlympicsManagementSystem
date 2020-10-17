package model;

import java.util.ArrayList;

public class Team {//<T extends Athlete>{

	protected enum teamType {Runner , HighJumper}
	private teamType type;
	
	private ArrayList<Athlete> allAthletes ;
	//private T t;
	private String country;
	private int outCome;
	//
	public Team( int outCome,String country , teamType type) {
		this.country = country;
		this.outCome = sumOfScoresAthlete();
		this.type = type;
		this.allAthletes = new ArrayList<Athlete>(); 	
		
	}



	public teamType getType() {
		return type;
	}



	private int sumOfScoresAthlete() {
		int outCome=0;
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
		return "Team [allAthletes=" + allAthletes + ", country=" + country + ", outCome=" + outCome + "]\n";
	}
	
	
	
	


}
