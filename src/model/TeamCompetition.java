  
package model;

import java.util.ArrayList;

public class TeamCompetition extends Competition{//<T extends Athlete> extends Competition{

	//private String PCtype;
	private ArrayList<Team> allTeams ;

	public TeamCompetition(Refere refere, Stadium stadium, compatitionType type) {
		super(refere, stadium, type);
		allTeams = new ArrayList<Team>();
	}
	public void addTeams(Team team) {
		allTeams.add(team);
		
	}




	public void bubbleSort() {
		if (allTeams.isEmpty()) 
			return;

		for (int i = 0; i < allTeams.size()-1; i++) {
			for (int j = 0; j < allTeams.size()-1; j++) {
				if (allTeams.get(j).getOutCome() < allTeams.get(j+1).getOutCome()) {
					Team tempTeam = allTeams.get(j);
					allTeams.set(j,allTeams.get(j+1));
					allTeams.set(j+1,tempTeam);
				}
			}
		}

	}
	@Override
	public ArrayList<String> treeWinnersCountry(){
		ArrayList<String> treeWinnerCountry = new ArrayList<String>(3);
		bubbleSort();
		for (int i = 0; i < 3; i++) {
			treeWinnerCountry.add(allTeams.get(i).getCountry());
			
		}
		return treeWinnerCountry ;

	}

}