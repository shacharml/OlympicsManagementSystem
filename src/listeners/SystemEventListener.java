package listeners;

import model.Competition;
import model.Refere;

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


	
}
