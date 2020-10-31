package model;

import listeners.SystemEventListener;
import model.Athlete.AthleteType;
import model.Competition.compatitionType;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Vector;

import exceptions.DontSelectAll;
import exceptions.InccorentIndex;
import exceptions.NotValideDate;
import exceptions.RefereFirst;
import exceptions.StadiumFirst;
import exceptions.TheWrongTypeJudge;

public class AdminSystem {
	final int ZERO = 0;

	private Olympics olympics;
	private Vector<SystemEventListener> listeners;

	public AdminSystem() {
		listeners = new Vector<SystemEventListener>();
	}

	public void createOlypics(LocalDate startDate, LocalDate endDate) throws NotValideDate {
		olympics = new Olympics(startDate.toString(), endDate.toString());
		fireCreateOlympicEvent(startDate.toString(), endDate.toString());
	}

	private void fireCreateOlympicEvent(String startDate, String endDate) throws NotValideDate {
		for (SystemEventListener l : listeners)
			l.createOlympicModelEvent(startDate, endDate);
	}

	public void registerListener(SystemEventListener listenerControoler) {
		listeners.add(listenerControoler);

	}

	public void addAthlete(String name, String country, String type, int score) throws DontSelectAll {

		if (name.isBlank() || country.isBlank() || type.isBlank()) {
			throw new DontSelectAll();
		} else {
			olympics.serchAndAddCountryByName(country);

			Athlete athlete;

			if (type.equalsIgnoreCase(AthleteType.HighJumper.toString())) {
				athlete = new HighJumper(name, country, AthleteType.HighJumper, score);
			} else if (type.equalsIgnoreCase(AthleteType.Runner.toString())) {
				athlete = new Runner(name, country, AthleteType.Runner, score);
			} else {
				athlete = new RunnerAndJumper(name, country, AthleteType.both, score);
			}

			olympics.addAthlete(athlete);

			fireAddAthleteEvent();
		}
	}

	private void fireAddAthleteEvent() throws DontSelectAll {
		for (SystemEventListener l : listeners)
			l.addAthleteToModelEvent();
	}

	public void showAllRefereAndStadiums() {

		String showAll = olympics.showAllRefereAndStadiums();
		fireShowAllRefereAndStadiumsEvent(showAll);
	}

	private void fireShowAllRefereAndStadiumsEvent(String showAll) {
		for (SystemEventListener l : listeners)
			l.showAllRefereAndStadiumsUModelEvent(showAll);

	}

	public void addCompetition(compatitionType type, String competitionType, int indexRefere, int indexStadium,
			ArrayList<Object> allAthlesOrAllTeams) throws InccorentIndex, DontSelectAll {
		if (indexRefere < ZERO || olympics.getAllReferes().size() < indexRefere || indexStadium < ZERO
				|| olympics.getAllStadiums().size() < indexStadium) {
			throw new InccorentIndex();
		}
		if (type.equals(null) || competitionType.isBlank()) {
			throw new DontSelectAll();
		} else {
			Competition comp = (Competition) olympics.addCompitition(type, competitionType, indexRefere, indexStadium,
					allAthlesOrAllTeams);
			fireAddCompetitionEvent(comp);
		}
	}

	private void fireAddCompetitionEvent(Competition comp) throws InccorentIndex, DontSelectAll {
		for (SystemEventListener l : listeners)
			l.addCompetitionToModelEvent(comp);

	}

	public void addStadium(String name, String location, int seats) throws DontSelectAll {
		if (name.isBlank() || location.isBlank() || seats == ZERO) {
			throw new DontSelectAll();
		} else {
			Stadium stadium = new Stadium(name, location, seats);
			olympics.addStadiums(stadium);
			fireAddStadiumEvent(stadium.toString());
		}
	}

	private void fireAddStadiumEvent(String stadium) throws DontSelectAll {
		for (SystemEventListener l : listeners)
			l.addStadiumToModelEvent(stadium);
	}

	public void addRefere(String name, String country, String typeOfJuging) throws DontSelectAll {
		if (name.isBlank() || country.isBlank() || typeOfJuging.isBlank()) {
			throw new DontSelectAll();
		} else {
			Refere refere = new Refere(name, country, typeOfJuging);
			olympics.addReferes(refere);
			fireAddRefereEvent(refere);
		}
	}

	private void fireAddRefereEvent(Refere refere) {
		for (SystemEventListener l : listeners)
			l.addRefereToModelEvent(refere);

	}

	public void showAllAthletes() {
		String allAthletes = olympics.showAllAthletes();
		fireShowAllAthletes(allAthletes);
	}

	private void fireShowAllAthletes(String allAthletes) {
		for (SystemEventListener l : listeners)
			l.showAllAthletesModelEvent(allAthletes);

	}

	public void removeAthlete(int indexAthlete) throws InccorentIndex {
		if (indexAthlete < ZERO || olympics.getAllAthletes().size() < indexAthlete) {
			throw new InccorentIndex();
		} else
			olympics.removeAthlete(indexAthlete);
		fireRemoveAthleteEvent();
	}

	private void fireRemoveAthleteEvent() throws InccorentIndex {
		for (SystemEventListener l : listeners)
			l.RemoveAthleteToModelEvent();

	}

	public void removeStadium(int indexStadium) throws InccorentIndex {
		if (indexStadium < ZERO || olympics.getAllStadiums().size() < indexStadium) {
			throw new InccorentIndex();
		} else
			olympics.removeStadiums(indexStadium);
		fireRemoveStadiumEvent();
	}

	private void fireRemoveStadiumEvent() throws InccorentIndex {
		for (SystemEventListener l : listeners)
			l.RemoveStadiumToModelEvent();

	}

	public void removeRefere(int indexRefere) throws InccorentIndex {
		if (indexRefere < ZERO || olympics.getAllReferes().size() < indexRefere) {
			throw new InccorentIndex();
		} else
			olympics.removeReferes(indexRefere);
		fireRemoveRefere();
	}

	private void fireRemoveRefere() throws InccorentIndex {
		for (SystemEventListener l : listeners)
			l.RemoveRefereToModelEvent();
	}

	public void showAllTheWinners() throws FileNotFoundException {

		ArrayList<String> winnersCountrys = olympics.treeCountrysWinning();

		String theWinners = "";
		for (int i = 0; i < winnersCountrys.size(); i++) {
			theWinners += "Place #" + (i + 1) + ": " + winnersCountrys.get(i) + "\n";
		}
		saveViewFile();
		fireShowAllTheWinnersEvent(theWinners);
	}

	private void saveViewFile() throws FileNotFoundException{
		File allOlympics = new File("AllOlympics"+olympics.getStartDate() +"__"+ olympics.getEndDate()+".txt");
		PrintWriter pw = new PrintWriter(allOlympics);
		
		pw.println(olympics.showAllOlimpic());
		pw.println("\n\nThe Winners are: \n");
		pw.print(getAllWinners());
		pw.close();
		
	}

	private String getAllWinners() {
		ArrayList<String> winnersCountrys = olympics.treeCountrysWinning();
		
		String theWinners ="";
		for (int i = 0; i < winnersCountrys.size(); i++) {
			theWinners+= "Place #"+(i+1)+ " : "+ winnersCountrys.get(i)+"\n";
		}
		return theWinners;
	}

	private void fireShowAllTheWinnersEvent(String theWinners) {
		for (SystemEventListener l : listeners)
			l.showAllTheWinnersToModelEvent(theWinners);

	}

	public void showAllOlimpic() {
		String allOlimpic = olympics.showAllOlimpic();
		fireShowAllOlimpicEvent(allOlimpic);

	}

	private void fireShowAllOlimpicEvent(String allOlimpic) {
		for (SystemEventListener l : listeners)
			l.showAllOlimpicsToModelEvent(allOlimpic);

	}

	public void getArraySelect(String competitionType, String typeAthlete, String indexRefere, String indexStadium)
			throws DontSelectAll, InccorentIndex, TheWrongTypeJudge, RefereFirst, StadiumFirst {

		if (indexRefere.isBlank() || indexStadium.isBlank() || typeAthlete.isBlank() || competitionType.isBlank()) {
			throw new DontSelectAll();
		} else if (!(olympics.getAllReferes().get(Integer.parseInt(indexRefere) - 1).getSportJugement()
				.equals(typeAthlete))) {
			throw new TheWrongTypeJudge();
		} else if (olympics.getAllReferes().isEmpty()) {
			throw new RefereFirst();

		} else if (olympics.getAllStadiums().isEmpty()) {
			throw new StadiumFirst();
		} else {
			if (competitionType.equalsIgnoreCase("Personal Competition")) {
				ArrayList<Athlete> arraySelect = olympics.getArraySelectAthlete(typeAthlete);
				fireGetArraySelectAthlet(arraySelect, typeAthlete, indexRefere, indexStadium);
			} else {
				ArrayList<Team> arraySelect = olympics.getArraySelectTeam(typeAthlete);
				fireGetArraySelectTeam(arraySelect, typeAthlete, indexRefere, indexStadium);
			}
		}
	}

	public void fireGetArraySelectAthlet(ArrayList<Athlete> arraySelect, String typeAthlete, String indexRefere,
			String indexStadium) throws InccorentIndex {
		int indexRefere1 = Integer.parseInt(indexRefere);
		int indexStadium1 = Integer.parseInt(indexStadium);

		if (indexRefere1 < ZERO || olympics.getAllReferes().size() < indexRefere1 || indexStadium1 < ZERO
				|| olympics.getAllStadiums().size() < indexStadium1) {
			throw new InccorentIndex();
		} else {
			for (SystemEventListener l : listeners)
				l.getArraySelectAthlete(arraySelect, typeAthlete, indexRefere, indexStadium);
		}
	}

	public void fireGetArraySelectTeam(ArrayList<Team> arraySelect, String typeAthlete, String indexRefere,
			String indexStadium) throws InccorentIndex {

		int indexRefere1 = Integer.parseInt(indexRefere);
		int indexStadium1 = Integer.parseInt(indexStadium);

		if (indexRefere1 < ZERO || olympics.getAllReferes().size() < indexRefere1 || indexStadium1 < ZERO
				|| olympics.getAllStadiums().size() < indexStadium1) {
			throw new InccorentIndex();
		} else {
			for (SystemEventListener l : listeners)
				l.getArraySelectTeam(arraySelect, typeAthlete, indexRefere, indexStadium);
		}
	}

}