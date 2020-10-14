package model;

public class RunnerAndJumper extends Athlete {

	private double highJump;
	private int runningSpeed;
	
	public RunnerAndJumper(String name, String country, int runningSpeed, double highJum) {
		super(name, country);
		this.highJump = highJum;
		this.runningSpeed = runningSpeed;
		
	}

}
