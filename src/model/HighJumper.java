package model;

public class HighJumper extends Athlete {

	private double highJump;
	
	public HighJumper(String name, String country, double highJump) {
		super(name, country);
		this.highJump = highJump;
	}

}
