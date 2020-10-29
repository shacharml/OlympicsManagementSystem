package model;

import java.util.ArrayList;

public abstract class Competition {

	public static enum compatitionType {
		HighJumper, Runner
	}

	protected compatitionType type;
	protected Refere refere;
	protected Stadium stadium;

	public Competition(Refere refere, Stadium stadium, compatitionType type) {

		this.refere = refere;
		this.stadium = stadium;
		this.type = type;
	}

	public Refere getRefere() {
		return refere;
	}

	public Stadium getStadium() {
		return stadium;
	}

	public abstract ArrayList<String> treeWinnersCountry();

	@Override
	public String toString() {
		return "type: " + type + ", refere: " + refere + ", stadium: " + stadium + "\n";
	}

	public compatitionType getType() {
		return type;
	}
}