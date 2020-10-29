package model;

public class Stadium {

	private String name;
	private String location;
	private int numOfSeats;

	public Stadium(String name, String location, int numOfSeats) {

		this.location = location;
		this.name = name;
		this.numOfSeats = numOfSeats;
	}

	public String getName() {
		return name;
	}

	public String getLocation() {
		return location;
	}

	public int getNumOfSeats() {
		return numOfSeats;
	}

	@Override
	public String toString() {
		return name + ", Location: " + location + ", Num of Seats: " + numOfSeats;
	}

}