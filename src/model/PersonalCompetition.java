package model;

import java.util.ArrayList;

public class PersonalCompetition extends Competition {// <T extends Athlete> extends Competition {

	// private String PCtype;
	// private ArrayList<T> allAthletes ;

	private ArrayList<Athlete> allAthletes;

	public PersonalCompetition(Refere refere, Stadium stadium, compatitionType type) {
		super(refere, stadium, type);
		allAthletes = new ArrayList<Athlete>();
	}

	// sort by runner/jumpping high >> return sort array type Runner/Jummping high
	// :)
	@Override
	public ArrayList<String> treeWinnersCountry() {

		ArrayList<String> nameOfWinningCountrys = new ArrayList<String>(3);

		if (allAthletes.isEmpty()) {
			return null;
		}
//bubble sort
		for (int i = 0; i < allAthletes.size() - 1; i++) {

			for (int j = 0; j < allAthletes.size() - 1; j++) {

				if (allAthletes.get(j).getScore() < allAthletes.get(j + 1).getScore()) {

					Athlete tempAthlete = allAthletes.get(j);
					allAthletes.set(j, allAthletes.get(j + 1));
					allAthletes.set(j + 1, tempAthlete);
				}
			}

		}

		for (int k = 0; k < 3; k++) {
			nameOfWinningCountrys.add(allAthletes.get(k).getCountry());
		}
		return nameOfWinningCountrys;
	}

	/*
	 * public ArrayList<String> treeWinnersAthletes(){ ArrayList<String>
	 * treeWinnerAthletes = new ArrayList<String>(3);
	 * 
	 * 
	 * for (int i = 0; i < 3; i++) {
	 * treeWinnerAthletes.add(allAthletes.get(i).getCountry());
	 * 
	 * } return treeWinnerAthletes; }
	 */
	public void addAthleteToCom(Athlete athlete) {
		allAthletes.add(athlete);

	}

	public ArrayList<Athlete> getAllAthletes() {
		return allAthletes;
	}

	public void setAllAthletes(ArrayList<Athlete> allAthletes) {
		this.allAthletes = allAthletes;
	}

	@Override
	public String toString() {
		return "PersonalCompetition [allAthletes=" + allAthletes + "]";
	}

}