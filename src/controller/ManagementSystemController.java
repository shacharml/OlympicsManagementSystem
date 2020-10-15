package controller;

import listeners.SystemEventListener;
import listeners.SystemUIEventListener;
import model.AdminSystem;
import view.UIinterface;

public class ManagementSystemController implements SystemEventListener, SystemUIEventListener {

	private AdminSystem adminSystem;
	private UIinterface systemInterface;

	public ManagementSystemController(AdminSystem adminSystem, UIinterface systemInterface) {
		this.adminSystem= adminSystem;
		this.systemInterface= systemInterface;
		
		adminSystem.registerListener(this);
		systemInterface.registerListener(this);

	}

	@Override
	public void addAthleteToUIEvent(String name, String country, String type) {
		// TODO Auto-generated method stub

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
		// TODO Auto-generated method stub

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

}
