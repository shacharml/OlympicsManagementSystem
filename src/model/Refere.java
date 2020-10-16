package model;

public class Refere {
//juge
	
	private String name;
	private String country;
	private String sportJugement;
	
	public Refere(String name , String country , String sportJugement ) {
		this.country = country;
		this.name = name;
		this.sportJugement = sportJugement;
	}

	public String getName() {
		return name;
	}

	public String getCountry() {
		return country;
	}

	public String getSportJugement() {
		return sportJugement;
	}


}
