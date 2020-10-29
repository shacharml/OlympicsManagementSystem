package view;

import java.util.ArrayList;

import controller.ManagementSystemController;
import model.Athlete;
import model.Competition;
import model.Refere;
import model.Team;

public interface UIinterface {

	void createOlympic(String startDate, String endDate);

	void addAthlete();

	void addCompitition(Competition comp);

	void addReferes(Refere refere);

	void addStadiums(String stadium);

	void RemoveRefere();

	void removeAthlete();

	void removeStadium();

	void registerListener(ManagementSystemController managementSystemControllew);

	void showAllRefereAndStadiums(String showAll);

	void showAllAthletes(String allAthletes);

	void showAllTheWinners(String theWinners);

	void showAllOlimpics(String allOlimpic);

	void getArraySelectAthlete(ArrayList<Athlete> arraySelect, String typeAthlete, String indexRefere, String indexStadium);

	void getArraySelectTeam(ArrayList<Team> arraySelect, String typeAthlete, String indexRefere, String indexStadium);

}