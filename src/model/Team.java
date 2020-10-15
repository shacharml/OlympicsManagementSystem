package model;

import java.util.ArrayList;

public class Team<T extends Athlete>{

	private ArrayList<T> allAthletes ;
	private String country;
	private int outCome;
	//
	public Team( int outCome,String country) {
		allAthletes = new ArrayList<T>();
		this.country = country;
		this.outCome = outCome;
	}

	public void addAthleteToTeam(T athlete ) {
		allAthletes.add(athlete);

	}

	public int getOutCome() {
		return outCome;
	}

	public String getCountry() {
		return country;
	}


}
