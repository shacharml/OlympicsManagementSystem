package model;

public class Athlete {
	 private String name;
	 private String country;
	 private int score;
	 
	 
	 public Athlete(String name ,String country,int score ) {
		this.country = country;
		this.name = name;
		this.score = score;
	}


	public String getCountry() {
		return country;
	}


	public int getScore() {
		return score;
	}
	

}
