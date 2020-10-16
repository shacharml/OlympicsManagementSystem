package model;



public class Athlete {
	
	private String name;
	 private String country;
	 private int score;
	 public enum AthleteType {running , highJumpping, both};
     private AthleteType type;
	 
	 
	 public Athlete(String name ,String country,AthleteType type , int score ) {
		this.country = country;
		this.name = name;
		this.score = score;
		this.type =type;
	}


	public String getCountry() {
		return country;
	}


	public int getScore() {
		return score;
	}


	public String getName() {
		return name;
	}
	
	
	

}
