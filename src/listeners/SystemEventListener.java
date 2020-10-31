package listeners;

import java.util.ArrayList;

import exceptions.DontSelectAll;
import exceptions.InccorentIndex;
import exceptions.NotValideDate;
import model.Athlete;
import model.Competition;
import model.Refere;
import model.Team;

public interface SystemEventListener {

	void createOlympicModelEvent(String startDate, String endDate) throws NotValideDate;

	void addAthleteToModelEvent() throws DontSelectAll;

	void addCompetitionToModelEvent(Competition comp) throws InccorentIndex, DontSelectAll;

	void addStadiumToModelEvent(String stadium) throws DontSelectAll;

	void addRefereToModelEvent(Refere refere);

	void showAllTheWinnersToModelEvent(String theWinners);

	void RemoveAthleteToModelEvent() throws InccorentIndex;

	void RemoveRefereToModelEvent() throws InccorentIndex;

	void RemoveStadiumToModelEvent() throws InccorentIndex;

	void showAllRefereAndStadiumsUModelEvent(String showAll);

	void showAllAthletesModelEvent(String allAthletes);

	void showAllOlimpicsToModelEvent(String allOlimpic);

	void getArraySelectAthlete(ArrayList<Athlete> arraySelect, String typeAthlete, String indexRefere,
			String indexStadium);

	void getArraySelectTeam(ArrayList<Team> arraySelect, String typeAthlete, String indexRefere, String indexStadium);

}