package view;

import java.util.ArrayList;

import controller.ManagementSystemController;
import model.Competition;
import model.Refere;

public interface UIinterface {

	void createOlympic(String startDate, String endDate);

	void addAthlete();

	void addCompitition(Competition comp);

	void addReferes(Refere refere);

	void addStadiums(String stadium);

	void RemoveCompitition();

	void RemoveRefere();

	void removeAthlete();

	void removeStadium();

	ArrayList<String> treeCountrysWinning();

	void registerListener(ManagementSystemController managementSystemControllew);

	void showAllRefereAndStadiums(String showAll);

	void showAllAthletes(String allAthletes);

	void showAllTheWinners(String theWinners);

	void addCountry();

	void showAllOlimpics(String allOlimpic);

}
