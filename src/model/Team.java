package model;

import java.util.ArrayList;

public class Team<T extends Athlete>{

	private ArrayList<T> allAthletes ;
	private T t;
	private String country;
	private int outCome;
	//
	public Team( int outCome,String country ) {
		allAthletes = new ArrayList<T>();
		this.country = country;
		this.outCome = sumOfScoresAthlete();		
	}

	private int sumOfScoresAthlete() {
		int outCome=0;
		for (int i = 0; i < allAthletes.size(); i++) {
			outCome += allAthletes.get(i).getScore();
		}
		return outCome;
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

	@Override
	public String toString() {
		return "Team [allAthletes=" + allAthletes + ", country=" + country + ", outCome=" + outCome + "]\n";
	}
	
	Class<T> getClassOfInstance()
	{
	    return (Class<T>) t.getClass();
	}

	public ArrayList<T> getAllAthletes() {
		return allAthletes;
	}

	
	
	


}
