package model;

import java.util.ArrayList;


public class Olympics {
	private String startDate;
	private String endDate;
	private ArrayList<Competition>allComptitions;
	private ArrayList<Refere>allReferes;
	private ArrayList<Country>allCountrys;
	private ArrayList<Stadium>allStadiums;



	public Olympics(int sday, int smounth, int syear,int eday, int emounth, int eyear) {
		this.startDate = setStartDate(sday, smounth, syear);
		this.endDate = setEndDate(eday, emounth, eyear);
		allComptitions = new ArrayList<Competition>();	
		allReferes = new ArrayList<Refere>();
		allStadiums = new ArrayList<Stadium>();

	}
	public void addCompitition(Competition competition) {
		allComptitions.add(competition);
	}
	public String setStartDate(int day, int mounth, int year ) {
		return day + "/" + mounth + "/" + year;
	}
	public String setEndDate(int day, int mounth, int year ) {
		return day + "/" + mounth + "/" + year;
	}

	public void addReferes(Refere refere) {
		allReferes.add(refere);
	}
	public void addCountry(Country country) {
		allCountrys.add(country);
	}
	public void addStadiums(Stadium stadium) {
		allStadiums.add(stadium);

	}

	public void addMedalsToCountrys() {
		
		for (int i = 0; i < allComptitions.size(); i++) {
			
		ArrayList<String> tempWinning = allComptitions.get(i).treeWinnersCountry();
		
			for (int j = 0; j < tempWinning.size(); j++) {
				searchAddMedalsByName(tempWinning.get(j));
				
			}
			
			
		}
	}
	public void searchAddMedalsByName(String country) {
		
		for (int i = 0; i < allCountrys.size(); i++) {
			if (allCountrys.get(i).getName().equalsIgnoreCase(country)) {
				allCountrys.get(i).addMedals();
				return;
				
			}
			
		}
	}
	
	public ArrayList<String> treeCountrysWinning(){
		addMedalsToCountrys();
		bubbleSortByMedals();
		
		ArrayList<String> nameOfTheWinners= new ArrayList<String>(3);
		for (int i = 0; i < nameOfTheWinners.size(); i++) {
			nameOfTheWinners.add(allCountrys.get(i).getName());
			
		}
		return nameOfTheWinners;
		
		
	}
	public void bubbleSortByMedals() {
		for (int i = 0; i < allCountrys.size()-1; i++) {
			for (int j = 0; j < allCountrys.size()-1; j++) {
				if(allCountrys.get(j).getTotalMedals()<allCountrys.get(j+1).getTotalMedals()) {
					Country tempCountry = allCountrys.get(j);
					allCountrys.set(j, allCountrys.get(j+1));
					allCountrys.set(j+1, tempCountry);
				}
				
			}
			
		}
		
	}
	

	
	
	
}
