package listeners;

import java.time.LocalDate;
import java.util.ArrayList;
import model.Competition.compatitionType;

public interface SystemUIEventListener {

	void createOlympicUIEvent(LocalDate startDate, LocalDate endDate);

	void addAthleteToUIEvent(String name, String country, String type, Integer score);

	void addCompetitionToUIEvent(compatitionType type, String competitionType, String IndexRefere, String IndexStadium,
			ArrayList<Object> allAthlesOrAllTeams);

	void addStadiumToUIEvent(String name, String location, int seats);

	void addRefereToUIEvent(String name, String countery, String typeOfJuging);

	void showAllTheWinnersUIEvent();

	void RemoveAthleteToUIEvent(int indexAthlete);

	void showAllRefereAndStadiumsUIEvent();

	void showAllAthletesUIEvent();

	void RemoveStadiumToUIEvent(int indexStadium);

	void RemoveRefereToUIEvent(int indexRefere);

	void ShowAllOlimpicToUI();

	void getArraySelect(String competitionType, String typeAthlete, String indexRefere, String indexStadium);

}