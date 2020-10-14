package model;

import java.util.ArrayList;

public class Team<T extends Athlete>{
	
	private ArrayList<T> allAthletes ;
	private String country;
	private int outCome;
	//
	public Team(String country , int outCome) {
		allAthletes = new ArrayList<T>();
		this.country = country;
		//this.outCome = outCome;
	}
	
	public void addAthleteToTeam(T athlete ) {
		allAthletes.add(athlete);
		
	}

}
