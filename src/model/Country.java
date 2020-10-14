package model;

public class Country {
	private String name;
	private int totalMedals;

	public Country(String name) {
		this.totalMedals =0 ;
		this.name = name;
	}
	
	
	private void addMedals() {
		totalMedals++;
	}
	
	
}
