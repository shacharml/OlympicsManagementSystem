package listeners;

import java.util.ArrayList;

import model.Athlete;
import model.Competition;
import model.Refere;
import model.Team;

public interface SystemEventListener {
	
	void createOlympicModelEvent(String startDate, String endDate);
	
	void addAthleteToModelEvent();
	void addTeamToModelEvent();
	void addCompetitionToModelEvent(Competition comp);
	void addStadiumToModelEvent(String stadium);
	void addRefereToModelEvent(Refere refere);
	void showAllTheWinnersToModelEvent(String theWinners);

	void RemoveAthleteToModelEvent();
	  void RemoveCompititionToModelEvent();
	  void RemoveRefereToModelEvent();
	  void RemoveCountryToModelEvent();
	  void RemoveStadiumToModelEvent();
	  
	  void showAllRefereAndStadiumsUModelEvent(String showAll);

	void showAllAthletesModelEvent(String allAthletes);

	void addCountryToModelEvent();

	void showAllOlimpicsToModelEvent(String allOlimpic);

	void getArraySelectAthlete(ArrayList<Athlete> arraySelect, String typeAthlete, String indexRefere, String indexStadium);

	void getArraySelectTeam(ArrayList<Team> arraySelect, String typeAthlete, String indexRefere, String indexStadium);

	


	
}