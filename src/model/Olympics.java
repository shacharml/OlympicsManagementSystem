package model;

import java.util.ArrayList;
import model.Athlete.AthleteType;
import model.Competition.compatitionType;

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
		allCountrys = new ArrayList<Country>();
	}

	public Competition addCompitition(compatitionType type, String competitionType, int indexRefere, int indexStadium,
			ArrayList<Object> allAthlesOrAllTeams) {

		Competition competition;

		if (competitionType.equals("Personal Competition")) {
			competition = new PersonalCompetition(allReferes.get(indexRefere - 1), allStadiums.get(indexStadium - 1),
					type);
			for (int i = 0; i < allAthlesOrAllTeams.size(); i++) {
				Object TeamOrAthlete = allAthlesOrAllTeams.get(i);
				if (TeamOrAthlete instanceof Athlete) {
					Athlete at = (Athlete) TeamOrAthlete;
					((PersonalCompetition) competition).addAthleteToCom(at);

				}
			}
		} else
			competition = new TeamCompetition(allReferes.get(indexRefere - 1), allStadiums.get(indexStadium - 1), type);
		for (int i = 0; i < allAthlesOrAllTeams.size(); i++) {
			Object TeamOrAthlete = allAthlesOrAllTeams.get(i);
			if (TeamOrAthlete instanceof Team) {
				Team te = (Team) TeamOrAthlete;
				((TeamCompetition) competition).addTeams(te);
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
			ArrayList<String> tempWinning;
			// tempWinning : 3 winners countrys in competition num i
			if (allComptitions.get(i) instanceof PersonalCompetition) {
				tempWinning = ((PersonalCompetition) allComptitions.get(i)).treeWinnersCountry();
			} else {
				tempWinning = ((TeamCompetition) allComptitions.get(i)).treeWinnersCountry();
			}
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

	public int findMyCountry(String cuontry) {
		for (int i = 0; i < allCountrys.size(); i++) {
			if (allCountrys.get(i).getName().equalsIgnoreCase(cuontry)) {
				return i;
			}
		}
		return -1;
	}

	public void addAthlete(Athlete athlete) {

		allAthletes.add(athlete);

		String country = athlete.getCountry();
		AthleteType type = athlete.getType();
		int indexCountry = findMyCountry(country);

		if (indexCountry != -1) {

			if (type.equals(AthleteType.both)) {
				for (int i = 0; i < allCountrys.get(indexCountry).getAllTeams().size(); i++) {
					allCountrys.get(indexCountry).getAllTeams().get(i).addAthleteToTeam(athlete);
					allCountrys.get(indexCountry).getAllTeams().get(i).sumOfScoresAthlete();
				}

			} else {
				for (int i = 0; i < allCountrys.get(indexCountry).getAllTeams().size(); i++) {
					if (allCountrys.get(indexCountry).getAllTeams().get(i).getType().equals(type)) {
						allCountrys.get(indexCountry).getAllTeams().get(i).addAthleteToTeam(athlete);
						allCountrys.get(indexCountry).getAllTeams().get(i).sumOfScoresAthlete();
						return;
					}
				}
			}

		}

	}

	public void removeAthlete(int indexAthlete) {

		allAthletes.remove(indexAthlete - 1);
	}

	public ArrayList<String> treeCountrysWinning() {
		addMedalsToCountrys();

		bubbleSortByMedals();

		ArrayList<String> nameOfTheWinners = new ArrayList<String>();
		int newSize = 3;
		if (allCountrys.size()<3) {
			newSize = allCountrys.size();
		}
		
		for (int i = 0; i < newSize; i++) {
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
			if (allComptitions.get(i) instanceof PersonalCompetition) {
				str += (i + 1) + ")" + ((PersonalCompetition) allComptitions.get(i)).toString()+"\n";
			} else
				str += (i + 1) + ")" + ((TeamCompetition) allComptitions.get(i)).toString()+"\n";
		}
		return str;
	}

	public String showAllOlimpic() {
		String AllOlimpic = "Olimpic : \n Start Date : " + startDate + "\n Ending Date : " + endDate + "\n\n";
		AllOlimpic += showAllAthletes();
		AllOlimpic += "\n" + showAllRefereAndStadiums();
		AllOlimpic += "\n" + showAllCopetition();
		AllOlimpic += "\n" + showAllCountrys();
		return AllOlimpic;
	}

	public ArrayList<Team> getArraySelectTeam(String typeAthlete) {
		ArrayList<Team> allTeams = getAllTeams();
		ArrayList<Team> allTeamsByType = new ArrayList<Team>();

		for (int i = 0; i < allTeams.size(); i++) {
			if (allTeams.get(i).getType().toString().equalsIgnoreCase(typeAthlete)
					|| allTeams.get(i).getType().toString().equalsIgnoreCase("both")) {
				allTeamsByType.add(allTeams.get(i));
			}
		}
		return allTeamsByType;
	}

	public ArrayList<Team> getAllTeams() {
		ArrayList<Team> allTeams = new ArrayList<Team>();
		for (int i = 0; i < allCountrys.size(); i++) {
			for (int j = 0; j < allCountrys.get(i).getAllTeams().size(); j++) {
				allTeams.add(allCountrys.get(i).getAllTeams().get(j));
			}
		}
		return allTeams;
	}

	public ArrayList<Athlete> getArraySelectAthlete(String typeAthlete) {
		ArrayList<Athlete> allAthletesByType = new ArrayList<Athlete>();

		for (int i = 0; i < allAthletes.size(); i++) {
			if (allAthletes.get(i).getType().toString().equalsIgnoreCase(typeAthlete)
					|| allAthletes.get(i).getType().toString().equalsIgnoreCase("both")) {
				allAthletesByType.add(allAthletes.get(i));
			}
		}

		return allAthletesByType;
	}

	public void serchAndAddCountryByName(String country) {

		if (allCountrys.isEmpty()) {
			Country country2 = new Country(country);
			Team teamRun = new Team(country, AthleteType.Runner);
			Team teamJump = new Team(country, AthleteType.HighJumper);
			country2.getAllTeams().add(teamJump);
			country2.getAllTeams().add(teamRun);
			allCountrys.add(country2);

			return;
		}

		for (int i = 0; i < allCountrys.size(); i++) {
			if (allCountrys.get(i).getName().equalsIgnoreCase(country)) {
				return;
			}
		}

		Country country2 = new Country(country);
		Team teamRun = new Team(country, AthleteType.Runner);
		Team teamJump = new Team(country, AthleteType.HighJumper);
		country2.getAllTeams().add(teamJump);
		country2.getAllTeams().add(teamRun);
		allCountrys.add(country2);
		return;

	}

	public String getStartDate() {
		return startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public ArrayList<Competition> getAllComptitions() {
		return allComptitions;
	}

	public ArrayList<Refere> getAllReferes() {
		return allReferes;
	}

	public ArrayList<Country> getAllCountrys() {
		return allCountrys;
	}

	public ArrayList<Stadium> getAllStadiums() {
		return allStadiums;
	}

	public ArrayList<Athlete> getAllAthletes() {
		return allAthletes;
	}

}