package model;
import listeners.SystemEventListener;
import model.Athlete.AthleteType;
import model.Competition.compatitionType;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Vector;

import controller.ManagementSystemController;
public class AdminSystem {
	
	private Olympics olympics;
	private Vector<SystemEventListener> listeners;
	
	public AdminSystem() {
		listeners = new Vector<SystemEventListener>();
	}
	
	public void createOlypics(LocalDate startDate, LocalDate endDate) {
		//TODO need to check if endDate more late then StartDate mabye Excepcion
		olympics =new Olympics( startDate.toString(), endDate.toString());
		fireCreateOlympicEvent(startDate.toString(), endDate.toString());
	}	
	private void fireCreateOlympicEvent(String startDate , String endDate) {
		for(SystemEventListener l : listeners)
		  l.createOlympicModelEvent(startDate,endDate);
	}

	public void registerListener(SystemEventListener listenerControoler) {
		listeners.add(listenerControoler);
		
	}

	public void addAthlete(String name, String country, String type , int score) {

		olympics.serchAndAddCountryByName(country);
       
		
		Athlete athlete;
		if (type.equalsIgnoreCase(AthleteType.HighJumper.toString())) {
			 athlete = new HighJumper(name, country, AthleteType.HighJumper, score);
		}else if (type.equalsIgnoreCase(AthleteType.Runner.toString())) {
			 athlete = new Runner( name , country, AthleteType.Runner ,  score);
		}
		else {
			athlete = new RunnerAndJumper(name, country, AthleteType.both, score);
		}
		
		
		olympics.addAthlete(athlete);
		
		fireAddAthleteEvent();
	}

	private void fireAddAthleteEvent() {
		for(SystemEventListener l : listeners)
		  l.addAthleteToModelEvent();
	}

	public void showAllRefereAndStadiums() {
		 
		String showAll = olympics.showAllRefereAndStadiums();
		fireShowAllRefereAndStadiumsEvent(showAll);
	}

	private void fireShowAllRefereAndStadiumsEvent(String showAll) {
		for(SystemEventListener l : listeners)
			  l.showAllRefereAndStadiumsUModelEvent(showAll);
		
	}

	public void addCompetition(compatitionType type, String competitionType, int indexRefere, int indexStadium,ArrayList<Object>allAthlesOrAllTeams) {
		
	
		Competition comp = (Competition) olympics.addCompitition( type, competitionType, indexRefere,  indexStadium,allAthlesOrAllTeams);
		fireAddCompetitionEvent(comp);
	}

	private void fireAddCompetitionEvent(Competition comp) {
		for(SystemEventListener l : listeners)
			  l.addCompetitionToModelEvent(comp);
		
	}

	public void addStadium(String name, String location, int seats) {
		Stadium stadium = new Stadium(name, location, seats);
		olympics.addStadiums(stadium);
		fireAddStadiumEvent(stadium.toString());
	}

	private void fireAddStadiumEvent(String stadium) {
		for(SystemEventListener l : listeners)
		  l.addStadiumToModelEvent(stadium);
	}

	public void addRefere(String name, String country, String typeOfJuging) {
		
		Refere refere = new Refere(name, country, typeOfJuging);
		olympics.addReferes(refere);
		fireAddRefereEvent(refere);
	}

	private void fireAddRefereEvent(Refere refere) {
		for(SystemEventListener l : listeners)
			  l.addRefereToModelEvent(refere);
		
	}

	public void showAllAthletes() {
		String allAthletes = olympics.showAllAthletes();
		fireShowAllAthletes(allAthletes);
	}

	private void fireShowAllAthletes(String allAthletes) {
		for(SystemEventListener l : listeners)
			  l.showAllAthletesModelEvent(allAthletes);
		
	}

	public void removeAthlete(int indexAthlete) {
		olympics.removeAthlete(indexAthlete);
		fireRemoveAthleteEvent();
	}

	private void fireRemoveAthleteEvent() {
		for(SystemEventListener l : listeners)
			  l.RemoveAthleteToModelEvent();
		
		
	}

	public void removeStadium(int indexStadium) {
		olympics.removeStadiums(indexStadium);
		fireRemoveStadiumEvent();
	}

	private void fireRemoveStadiumEvent() {
		for(SystemEventListener l : listeners)
			  l.RemoveStadiumToModelEvent();
		
	}

	public void removeRefere(int indexRefere) {
		olympics.removeReferes(indexRefere);
		fireRemoveRefere();
	}

	private void fireRemoveRefere() {
		for(SystemEventListener l : listeners)
			  l.RemoveRefereToModelEvent();
		
	}

	public void showAllTheWinners() {
		
		ArrayList<String> winnersCountrys = olympics.treeCountrysWinning();
		
		String theWinners ="";
		for (int i = 0; i < winnersCountrys.size(); i++) {
			theWinners += "Place #" + (i+1) +": "+winnersCountrys.get(i) +"\n";
		}
		
		fireShowAllTheWinnersEvent(theWinners);

	}

	private void fireShowAllTheWinnersEvent(String theWinners) {
		for(SystemEventListener l : listeners)
			  l.showAllTheWinnersToModelEvent(theWinners);
		
	}

	public void addCountry(String countryName) {
		
		Country country = new Country(countryName);
		olympics.addCountry(country);
		fireAddCountryEvent();
		
	}

	private void fireAddCountryEvent() {
		for(SystemEventListener l : listeners)
			  l.addCountryToModelEvent();
		
	}

	public void showAllOlimpic() {
		String allOlimpic = olympics.showAllOlimpic();
		fireShowAllOlimpicEvent(allOlimpic);
		
	}

	private void fireShowAllOlimpicEvent(String allOlimpic) {
		for(SystemEventListener l : listeners)
			  l.showAllOlimpicsToModelEvent(allOlimpic);
		
	}

	public void getArraySelect(String competitionType, String typeAthlete, String indexRefere, String indexStadium) {
		if (competitionType.equalsIgnoreCase("Personal Competition")) {
			ArrayList<Athlete> arraySelect = olympics.getArraySelectAthlete();
			fireGetArraySelectAthlet(arraySelect , typeAthlete,indexRefere,indexStadium);
		}
		else {
			ArrayList<Team> arraySelect = olympics.getArraySelectTeam();
		   fireGetArraySelectTeam(arraySelect, typeAthlete,indexRefere,indexStadium);
		}
		
		
	}

	public void fireGetArraySelectAthlet(ArrayList<Athlete> arraySelect, String typeAthlete, String indexRefere, String indexStadium) {
		
		for(SystemEventListener l : listeners)
			  l.getArraySelectAthlete(arraySelect, typeAthlete,indexRefere,indexStadium);
		
		
		
	}
	
	public void fireGetArraySelectTeam(ArrayList<Team> arraySelect, String typeAthlete, String indexRefere, String indexStadium) {
		
		for(SystemEventListener l : listeners)
			  l.getArraySelectTeam(arraySelect, typeAthlete,indexRefere,indexStadium);
	}
	
	
}