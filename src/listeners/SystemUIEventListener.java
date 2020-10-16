package listeners;

import java.time.LocalDate;

import model.Athlete.AthleteType;

public interface SystemUIEventListener {
	
	
	void createOlympicUIEvent(LocalDate startDate, LocalDate endDate);
	
	void addAthleteToUIEvent(String name, String country, AthleteType type , Integer score);
	void addTeamToUIEvent();
	void addCompetitionToUIEvent();
	void addStadiumToUIEvent();
	void addRefereToUIEvent();
	void showAllTheWinnersUIEvent();

	
	  void RemoveCompititionToUIEvent();
	  void RemoveReferesToUIEvent();
	  void RemoveCountryToUIEvent();
	  void RemoveStadiumsToUIEvent();

}
