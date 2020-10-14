package model;

import java.util.ArrayList;

public class PersonalCompetition<T extends Athlete> extends Competition {
	
	//private String PCtype;
	private ArrayList<T> allAthletes ;

	public PersonalCompetition(Refere refere, Stadium stadium, competitionType type) {
		super(refere, stadium, type);
		allAthletes = new ArrayList<T>();
	}

//sort by runner/jumpping high >> return sort array type Runner/Jummping high :)
	public ArrayList<T> BubbleSort(T t) {
		
		if (allAthletes.isEmpty()) {
			return null;
		}
		
		if (t instanceof Runner ) {
			ArrayList<Runner>allRunners = (ArrayList<Runner>)allAthletes;
            
			for (int i = 0; i < allRunners.size()-1; i++) {
				
				for (int j = 0; j < allRunners.size()-1; j++) {
					
					if (allRunners.get(j).getRunningSpeed() > allRunners.get(j+1).getRunningSpeed() ) {
											
					Runner tempRunner = allRunners.get(j);
					allRunners.set(j, allRunners.get(j+1));
					allRunners.set(j+1, tempRunner);
					}
				}
			}
			return (ArrayList<T>) allRunners;
		}
		
		else if(t instanceof Runner ) {
			ArrayList<Runner>allJumpping = (ArrayList<Runner>)allAthletes;
            
			for (int i = 0; i < allJumpping.size()-1; i++) {
				
				for (int j = 0; j < allJumpping.size()-1; j++) {
					
					if (allJumpping.get(j).getRunningSpeed() > allJumpping.get(j+1).getRunningSpeed() ) {
											
					Runner tempRunner = allJumpping.get(j);
					allJumpping.set(j, allJumpping.get(j+1));
					allJumpping.set(j+1, tempRunner);
					}
				}
			}
			return (ArrayList<T>) allJumpping;
		}
		
		else return null;
		
	}

	
	
}
