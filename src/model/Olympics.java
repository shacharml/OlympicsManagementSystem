package model;

import java.util.ArrayList;
import java.util.Arrays;

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
		allCountrys= new ArrayList<Country>();
	}

	public Competition addCompitition(String type, String competitionType, int indexRefere, int indexStadium) {

		Competition competition;

		if (competitionType.equalsIgnoreCase("Personal Competition")) {
			if (type.equalsIgnoreCase("Run")) {
				competition = new PersonalCompetition<Runner>(allReferes.get(indexRefere - 1),
						allStadiums.get(indexStadium - 1), competitionType);
			} else {
				competition = new PersonalCompetition<HighJumper>(allReferes.get(indexRefere - 1),
						allStadiums.get(indexStadium - 1), competitionType);
			}

		} else {// Team Copetition
			if (type.equalsIgnoreCase("Run")) {
				competition = new TeamCompetition<Runner>(allReferes.get(indexRefere - 1),
						allStadiums.get(indexStadium - 1), competitionType);
			} else {
				competition = new TeamCompetition<HighJumper>(allReferes.get(indexRefere - 1),
						allStadiums.get(indexStadium - 1), competitionType);

			}

		}
		allComptitions.add(competition);
		return competition;
	}

	public void addReferes(Refere refere) {
		allReferes.add(refere);
	}

	public void removeReferes(int indexRefere) {

		allReferes.remove(indexRefere);

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

	public void removeStadiums(int indexStadium) {

		allStadiums.remove(indexStadium - 1);

	}

	public void addMedalsToCountrys() {

		for (int i = 0; i < allComptitions.size(); i++) {

			//tempWinning : 3 winners countrys in competition num i // israel brazil lebanon
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

	public void addAthlete(String name, String country, String type, int score) {

		Athlete athlete;
		if (type.equals("running")) {
			athlete = new Runner(score, name, type, country);
		} else if (type.equals("highJumpping")) {
			athlete = new HighJumper(name, country, type, score);
		} else {
			athlete = new RunnerAndJumper(name, country, type, score);
		}
		allAthletes.add(athlete);
	}

	// TODO need to work on this!!
	public void AddAtheleteToTeamInCountry(Athlete athlete) {

		String country = athlete.getCountry();
		
		for (int i = 0; i < allCountrys.size(); i++) {
			if (allCountrys.get(i).getName().equalsIgnoreCase(country)) {
				
				String athleteType = athlete.getType().toString();
				
				for (int j = 0; j < allCountrys.get(i).getAllTeams().size(); j++) {
					
					//if (allCountrys.get(i).getAllTeams().get(j).getAllAthletes().getClass().getName()
						//	.equalsIgnoreCase(athleteType)) {
						
					}
				}
				
				
				
				
				
			}
			
			
			
			
			
			
			
			
			
			
			
			
			
		}
		
		
		
		
		
		ArrayList<String> Indexes;

		if (athlete instanceof Runner) {
			String sulot = indexOfRightTeam("Runner", country);
			if (!sulot.equals("notFound")) {
				Indexes = new ArrayList<String>(Arrays.asList(sulot.split(",")));
				allCountrys.get(Integer.parseInt(Indexes.get(0))).getAllTeams().get(Integer.parseInt(Indexes.get(1)))
						.addAthleteToTeam(athlete);
			}
		} else if (athlete instanceof HighJumper) {
			indexOfRightTeam("HighJumper", country);
		} else {
			indexOfRightTeam("RunnerAndJumper", country);
		}

	}

	public String indexOfRightTeam(String className, String countryName) {
		for (int i = 0; i < allCountrys.size(); i++) {
			if (allCountrys.get(i).getName().equalsIgnoreCase(countryName)) {
				for (int j = 0; j < allCountrys.get(i).getAllTeams().size(); j++) {
					if (allCountrys.get(i).getAllTeams().get(j).getClass().getName().equals(className)) {
						String st = i + "," + j;
						return st;
					}
				}

			}

		}
		return "notFound";
	}

	public void removeAthlete(int indexAthlete) {

		allAthletes.remove(indexAthlete - 1);
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

	public String showAllRefereAndStadiums() {
		String str = "-------All the Referes :-------\n";

		for (int i = 0; i < allReferes.size(); i++) {
			str += (i + 1) + ")" + allReferes.get(i).toString() + "\n";
		}

		str += "\n-------All the Stadiums :-------\n";
		for (int i = 0; i < allStadiums.size(); i++) {
			str += (i + 1) + ")" + allStadiums.get(i).toString() + "\n";

		}

		return str;

	}

	public String showAllAthletes() {
		String str = "-------All the Athletes :-------\n";

		for (int i = 0; i < allAthletes.size(); i++) {
			str += (i + 1) + ")" + allAthletes.get(i).toString() + "\n";
		}

		return str;
	}

	public String showAllCountrys() {
		String str = "-------All the countrys :-------\n";

		for (int i = 0; i < allCountrys.size(); i++) {
			str += (i + 1) + ")" + allCountrys.get(i).toString() + "\n";
		}

		return str;
	}
	
	public String showAllCopetition() {
		String str = "-------All the competition :-------\n";

		for (int i = 0; i < allComptitions.size(); i++) {
			str += (i + 1) + ")" + allComptitions.get(i).toString() + "\n";
		}

		return str;
	}
	
	public String showAllOlimpic() {
		String AllOlimpic = "Olimpic : \n Start Date : " +startDate + "\n Ending Date : " +endDate +"\n";
		
		AllOlimpic += showAllRefereAndStadiums();
		AllOlimpic += "\n\n" +showAllCopetition();
		AllOlimpic += "\n\n" +showAllAthletes();
		AllOlimpic += "\n\n" +showAllCountrys();

		return AllOlimpic;
	}

}
