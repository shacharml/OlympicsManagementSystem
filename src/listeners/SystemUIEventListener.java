package listeners;

import java.time.LocalDate;

public interface SystemUIEventListener {
	
	
	void createOlympicUIEvent(LocalDate startDate, LocalDate endDate);
	
	void addAthleteToUIEvent(String name, String country, String type , Integer score);
	void addTeamToUIEvent();
	void addCompetitionToUIEvent(String type, String competitionType, String IndexRefere, String IndexStadium);
	void addStadiumToUIEvent(String name, String location, int seats);
	void addRefereToUIEvent(String name, String countery, String typeOfJuging);
	void showAllTheWinnersUIEvent();

	
	  void RemoveAthleteToUIEvent(int indexAthlete);
	  void RemoveCompititionToUIEvent();
	  void RemoveReferesToUIEvent();
	  void RemoveCountryToUIEvent();
	  void RemoveStadiumsToUIEvent();

	void showAllRefereAndStadiumsUIEvent();

	void showAllAthletesUIEvent();

	void RemoveStadiumToUIEvent(int indexStadium);

	void RemoveRefereToUIEvent(int indexRefere);

	

}
