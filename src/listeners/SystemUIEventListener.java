package listeners;

public interface SystemUIEventListener {
	
	void addAthleteToUIEvent(String name , String country , String type);
	void addTeamToUIEvent();
	void addCompetitionToUIEvent();
	void addStadiumToUIEvent();
	void addRefereToUIEvent();
	void showAllTheWinnersUIEvent();

}
