package model;

import java.util.ArrayList;
import java.util.Arrays;

import model.Athlete.AthleteType;

public class Olympics {
	private String startDate;
	private String endDate;

	private ArrayList<Competition> allComptitions;
	private ArrayList<Refere> allReferes;
	private ArrayList<Country> allCountrys;
	private ArrayList<Stadium> allStadiums;
	private ArrayList<Athlete> allAthletes;

	public Olympics(String startDate, String endDate) {
		this.startDate = startDate;
		this.endDate = endDate;
		allComptitions = new ArrayList<Competition>();
		allReferes = new ArrayList<Refere>();
		allStadiums = new ArrayList<Stadium>();
		allAthletes = new ArrayList<Athlete>();

	}

	public void addCompitition(Competition competition) {
		allComptitions.add(competition);
	}

	/*
	 * public String setStartDate(int day, int mounth, int year ) { return day + "/"
	 * + mounth + "/" + year; } public String setEndDate(int day, int mounth, int
	 * year ) { return day + "/" + mounth + "/" + year; }
	 */

	public void addReferes(Refere refere) {
		allReferes.add(refere);
	}

	public void removeReferes(String nameRefere) {
		for (int i = 0; i < allReferes.size(); i++) {
			if (allReferes.get(i).getName().equalsIgnoreCase(nameRefere)) {
				allReferes.remove(i);
				return;
			}
		}
	}

	public void addCountry(Country country) {
		allCountrys.add(country);
	}

	public void removeCountry(String nameCountry) {
		for (int i = 0; i < allCountrys.size(); i++) {
			if (allCountrys.get(i).getName().equalsIgnoreCase(nameCountry)) {
				allCountrys.remove(i);
				return;
			}
		}
	}

	public void addStadiums(Stadium stadium) {
		allStadiums.add(stadium);

	}

	public void removeStadiums(String nameStadium) {
		for (int i = 0; i < allStadiums.size(); i++) {
			if (allStadiums.get(i).getName().equalsIgnoreCase(nameStadium)) {
				allStadiums.remove(i);
				return;
			}
		}
	}

	public void addMedalsToCountrys() {

		for (int i = 0; i < allComptitions.size(); i++) {

			ArrayList<String> tempWinning = allComptitions.get(i).treeWinnersCountry();

			for (int j = 0; j < tempWinning.size(); j++) {
				searchAddMedalsByName(tempWinning.get(j));

			}

		}
	}

	public void searchAddMedalsByName(String country) {

		for (int i = 0; i < allCountrys.size(); i++) {
			if (allCountrys.get(i).getName().equalsIgnoreCase(country)) {
				allCountrys.get(i).addMedals();
				return;

			}

		}
	}

	public void addAthlete(String name, String country, AthleteType type, int score) {

		Athlete athlete;
		if (type.equals(AthleteType.running)) {
			athlete = new Runner(score, name, type, country);
		} else if (type.equals(AthleteType.highJumpping)) {
			athlete = new HighJumper(name, country, type, score);
		} else {
			athlete = new RunnerAndJumper(name, country, type, score);
		}
		allAthletes.add(athlete);
	}

	//TODO need to work on this!!
	public void AddAtheleteToTeamInCountry(Athlete athlete) {
		String country = athlete.getCountry();
		ArrayList<String> Indexes ;
		
		if (athlete instanceof Runner) {
			String sulot = indexOfRightTeam("Runner", country);
			if (!sulot.equals("notFound")) {
				Indexes = new ArrayList<String>(Arrays.asList(sulot.split(",")));
				allCountrys.get(Integer.parseInt(Indexes.get(0))).getAllTeams().get(Integer.parseInt(Indexes.get(1)))
				.addAthleteToTeam(athlete);
			}
		}else if (athlete instanceof HighJumper) {
			indexOfRightTeam("HighJumper", country);
		}else {
			indexOfRightTeam("RunnerAndJumper", country);	
		}
		
		
		
		
		
		
		
		
		


	}

	public String indexOfRightTeam(String className, String countryName) {
		for (int i = 0; i < allCountrys.size(); i++) {
			if (allCountrys.get(i).getName().equalsIgnoreCase(countryName)) {
				for (int j = 0; j < allCountrys.get(i).getAllTeams().size(); j++) {
					if (allCountrys.get(i).getAllTeams().get(j).getClass().getName().equals(className)) {
						String st = i+","+j;
						return st;
					}
				}

			}

		}
		return "notFound";
	}

	public void removeAthlete(String nameAthlete) {
		for (int i = 0; i < allAthletes.size(); i++) {
			if (allAthletes.get(i).getName().equalsIgnoreCase(nameAthlete)) {
				allAthletes.remove(i);
				return;
			}
		}

	}

	public ArrayList<String> treeCountrysWinning() {
		addMedalsToCountrys();
		bubbleSortByMedals();

		ArrayList<String> nameOfTheWinners = new ArrayList<String>(3);
		for (int i = 0; i < nameOfTheWinners.size(); i++) {
			nameOfTheWinners.add(allCountrys.get(i).getName());

		}
		return nameOfTheWinners;

	}

	public void bubbleSortByMedals() {
		for (int i = 0; i < allCountrys.size() - 1; i++) {
			for (int j = 0; j < allCountrys.size() - 1; j++) {
				if (allCountrys.get(j).getTotalMedals() < allCountrys.get(j + 1).getTotalMedals()) {
					Country tempCountry = allCountrys.get(j);
					allCountrys.set(j, allCountrys.get(j + 1));
					allCountrys.set(j + 1, tempCountry);
				}

			}

		}

	}

}
