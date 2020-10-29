package controller;

import java.time.LocalDate;
import java.util.ArrayList;

import javafx.collections.ObservableList;
import listeners.SystemEventListener;
import listeners.SystemUIEventListener;
import model.AdminSystem;
import model.Athlete;
import model.Competition;
import model.Competition.compatitionType;
import model.Refere;
import model.Team;
import view.UIinterface;

public class ManagementSystemController implements SystemEventListener, SystemUIEventListener {

	private AdminSystem adminSystem;
	private UIinterface systemView;

	public ManagementSystemController(AdminSystem adminSystem, UIinterface systemView) {
		this.adminSystem= adminSystem;
		this.systemView= systemView;
		
		adminSystem.registerListener(this);
		systemView.registerListener(this);

	}

	@Override
	public void addAthleteToUIEvent(String name, String country, String type , Integer score) {
		adminSystem.addAthlete(name , country,type,score);
	}

	@Override
	public void addTeamToUIEvent() {
		// TODO Auto-generated method stub

	}

	@Override
	public void addStadiumToUIEvent(String name, String location, int seats) {
		adminSystem.addStadium(name,location,seats);

	}

	@Override
	public void addRefereToUIEvent(String name, String countery, String typeOfJuging) {
		adminSystem.addRefere(name,countery,typeOfJuging);

	}

	@Override
	public void showAllTheWinnersUIEvent() {
		adminSystem.showAllTheWinners();

	}

	@Override
	public void addAthleteToModelEvent() {
		systemView.addAthlete();

	}

	@Override
	public void addTeamToModelEvent() {
		// TODO Auto-generated method stub

	}

	@Override
	public void addCompetitionToModelEvent(Competition comp) {
		systemView.addCompitition(comp);

	}

	@Override
	public void addStadiumToModelEvent(String stadium) {
		systemView.addStadiums(stadium);

	}

	@Override
	public void addRefereToModelEvent(Refere refere) {
		systemView.addReferes(refere);

	}

	@Override
	public void showAllTheWinnersToModelEvent(String theWinners) {
		systemView.showAllTheWinners(theWinners);

	}

	@Override
	public void RemoveCompititionToUIEvent() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void RemoveReferesToUIEvent() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void RemoveCountryToUIEvent() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void RemoveStadiumsToUIEvent() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void RemoveCompititionToModelEvent() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void RemoveRefereToModelEvent() {
		systemView.RemoveRefere();
		
	}

	@Override
	public void RemoveCountryToModelEvent() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void RemoveStadiumToModelEvent() {
		systemView.removeStadium();
		
	}

	@Override
	public void createOlympicUIEvent(LocalDate startDate, LocalDate endDate) {
		adminSystem.createOlypics(startDate, endDate);
		
	}

	@Override
	public void createOlympicModelEvent(String startDate, String endDate) {
		systemView.createOlympic(startDate,endDate);
		
	}

	@Override
	public void showAllRefereAndStadiumsUIEvent() {
		adminSystem.showAllRefereAndStadiums();
		
	}

	@Override
	public void showAllRefereAndStadiumsUModelEvent(String showAll) {
		systemView.showAllRefereAndStadiums(showAll);
		
	}

	@Override
	public void addCompetitionToUIEvent(compatitionType type, String competitionType, String IndexRefere, String IndexStadium,ArrayList<Object>allAthlesOrAllTeams) {
		adminSystem.addCompetition(type , competitionType , Integer.parseInt(IndexRefere), Integer.parseInt(IndexStadium),allAthlesOrAllTeams);
		
	}

	@Override
	public void showAllAthletesUIEvent() {
		adminSystem.showAllAthletes();
		
	}

	@Override
	public void showAllAthletesModelEvent(String allAthletes) {
		systemView.showAllAthletes(allAthletes);
		
	}

	@Override
	public void RemoveAthleteToUIEvent(int indexAthlete) {
		adminSystem.removeAthlete(indexAthlete);
		
	}

	@Override
	public void RemoveAthleteToModelEvent() {
		systemView.removeAthlete();
		
	}

	@Override
	public void RemoveStadiumToUIEvent(int indexStadium) {
		adminSystem.removeStadium(indexStadium);
		
	}

	@Override
	public void RemoveRefereToUIEvent(int indexRefere) {
		adminSystem.removeRefere(indexRefere);
		
	}

	@Override
	public void addCountryToUI(String countryName) {
		adminSystem.addCountry(countryName);
		
	}

	@Override
	public void addCountryToModelEvent() {
		systemView.addCountry();
		
	}

	@Override
	public void ShowAllOlimpicToUI() {
		adminSystem.showAllOlimpic();
		
	}

	@Override
	public void showAllOlimpicsToModelEvent(String allOlimpic) {
		systemView.showAllOlimpics(allOlimpic);
		
	}

	@Override
	public void getArraySelect(String competitionType, String typeAthlete, String indexRefere, String indexStadium) {
		adminSystem.getArraySelect(competitionType,typeAthlete,indexRefere,indexStadium);
		
	}

	@Override
	

	public void getArraySelectAthlete(ArrayList<Athlete> arraySelect, String typeAthlete, String indexRefere, String indexStadium) {
		systemView.getArraySelectAthlete(arraySelect , typeAthlete,indexRefere,indexStadium);
		
	}

	@Override
	public void getArraySelectTeam(ArrayList<Team> arraySelect,String typeAthlete, String indexRefere, String indexStadium) {
		systemView.getArraySelectTeam(arraySelect, typeAthlete,indexRefere,indexStadium);		
	}


	
	

}