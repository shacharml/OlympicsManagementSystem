package model;



public class Athlete {
	
	private String name;
	 private String country;
	 private int score;
	// public enum AthleteType {running , highJumpping, both};
     private String type;
	 
	 
	 public Athlete(String name ,String country,String type , int score ) {
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


	@Override
	public String toString() {
		return  name + ", country=" + country + ", score=" + score + ", type=" + type;
	}


	public String getType() {
		return type;
	}
	
	
	
	
	

}
