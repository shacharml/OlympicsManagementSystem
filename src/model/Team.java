package model;

import java.util.ArrayList;

import model.Athlete.AthleteType;

public class Team {

	private AthleteType type;
	private ArrayList<Athlete> allAthletes;
	private String country;
	private int outCome;

	public Team(String country, AthleteType type) {
		this.country = country;
		this.outCome = 0;
		this.type = type;
		this.allAthletes = new ArrayList<Athlete>();
	}

	public AthleteType getType() {
		return type;
	}

	public int sumOfScoresAthlete() {
		this.outCome = 0;
		for (int i = 0; i < allAthletes.size(); i++) {
			outCome += allAthletes.get(i).getScore();
		}
		return outCome;
	}

	public void addAthleteToTeam(Athlete athlete) {
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
		String str = country + "Team - " + type.toString() + ":\n";
		for (int i = 0; i < allAthletes.size(); i++) {
			str += (i + 1) + ") " + allAthletes.get(i).toString() + "\n";
		}
		str += "Score of all team : " + outCome;
		return str;
	}

	public ArrayList<Athlete> getAllAthletes() {
		return allAthletes;
	}

}