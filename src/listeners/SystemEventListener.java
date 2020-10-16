package listeners;

public interface SystemEventListener {
	
	void createOlympicModelEvent(String startDate, String endDate);
	
	void addAthleteToModelEvent();
	void addTeamToModelEvent();
	void addCompetitionToModelEvent();
	void addStadiumToModelEvent();
	void addRefereToModelEvent();
	void showAllTheWinnersToModelEvent();

	  void RemoveCompititionToModelEvent();
	  void RemoveReferesToModelEvent();
	  void RemoveCountryToModelEvent();
	  void RemoveStadiumsToModelEvent();
	  
	  void showAllRefereAndStadiumsUModelEvent(String showAll);
}
