package listeners;

import java.time.LocalDate;
import java.util.ArrayList;

import exceptions.DontSelectAll;
import exceptions.InccorentIndex;
import exceptions.NotValideDate;
import exceptions.RefereFirst;
import exceptions.StadiumFirst;
import exceptions.TheWrongTypeJudge;
import model.Competition.compatitionType;

public interface SystemUIEventListener {

	void createOlympicUIEvent(LocalDate startDate, LocalDate endDate) throws NotValideDate;

	void addAthleteToUIEvent(String name, String country, String type, Integer score) throws DontSelectAll;

	void addCompetitionToUIEvent(compatitionType type, String competitionType, String IndexRefere, String IndexStadium,
			ArrayList<Object> allAthlesOrAllTeams) throws InccorentIndex, DontSelectAll;

	void addStadiumToUIEvent(String name, String location, int seats) throws DontSelectAll;

	void addRefereToUIEvent(String name, String countery, String typeOfJuging) throws DontSelectAll;

	void showAllTheWinnersUIEvent();

	void RemoveAthleteToUIEvent(int indexAthlete) throws InccorentIndex;

	void showAllRefereAndStadiumsUIEvent();

	void showAllAthletesUIEvent();

	void RemoveStadiumToUIEvent(int indexStadium) throws InccorentIndex;

	void RemoveRefereToUIEvent(int indexRefere) throws InccorentIndex;

	void ShowAllOlimpicToUI();

	void getArraySelect(String competitionType, String typeAthlete, String indexRefere, String indexStadium)
			throws DontSelectAll, InccorentIndex, TheWrongTypeJudge, RefereFirst, StadiumFirst;

}