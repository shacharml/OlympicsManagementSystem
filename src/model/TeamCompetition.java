package model;

import java.util.ArrayList;

public class TeamCompetition extends Competition{

	//private String PCtype;
		private ArrayList<Team<Athlete>> allTeams ;
	
	public TeamCompetition(Refere refere, Stadium stadium, competitionType type) {
		super(refere, stadium, type);
		allTeams = new ArrayList<Team<Athlete>>();
	}

	
	
	
	/*public ArrayList<T> BubbleSort(T t) {
		if (allTeams.isEmpty()) {
			return null;
			
		}
		
		if
		
	}*/
	
	

}
