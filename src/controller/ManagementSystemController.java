package controller;

import java.time.LocalDate;

import listeners.SystemEventListener;
import listeners.SystemUIEventListener;
import model.AdminSystem;
import model.Athlete.AthleteType;
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
	public void addAthleteToUIEvent(String name, String country, AthleteType type , Integer score) {
		adminSystem.addAthlete(name , country,type,score);
	}

	@Override
	public void addTeamToUIEvent() {
		// TODO Auto-generated method stub

	}

	@Override
	public void addCompetitionToUIEvent() {
		// TODO Auto-generated method stub

	}

	@Override
	public void addStadiumToUIEvent() {
		// TODO Auto-generated method stub

	}

	@Override
	public void addRefereToUIEvent() {
		// TODO Auto-generated method stub

	}

	@Override
	public void showAllTheWinnersUIEvent() {
		// TODO Auto-generated method stub

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
	public void addCompetitionToModelEvent() {
		// TODO Auto-generated method stub

	}

	@Override
	public void addStadiumToModelEvent() {
		// TODO Auto-generated method stub

	}

	@Override
	public void addRefereToModelEvent() {
		// TODO Auto-generated method stub

	}

	@Override
	public void showAllTheWinnersToModelEvent() {
		// TODO Auto-generated method stub

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
	public void RemoveReferesToModelEvent() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void RemoveCountryToModelEvent() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void RemoveStadiumsToModelEvent() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createOlympicUIEvent(LocalDate startDate, LocalDate endDate) {
		adminSystem.createOlypics(startDate, endDate);
		
	}

	@Override
	public void createOlympicModelEvent(String startDate, String endDate) {
		systemView.createOlympic(startDate,endDate);
		
	}

}
