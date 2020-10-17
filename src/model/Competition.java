package model;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public abstract class Competition {

	private String type;
	private Refere refere;
	private Stadium stadium;

	//DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy_MM_dd");

	//final String TXT = ".txt";
	//final String COMPETITION = "Competition_";

	public Competition(Refere refere, Stadium stadium, String type) {

		this.refere = refere;
		this.stadium = stadium;
		this.type = type;
	}

	public abstract ArrayList<String> treeWinnersCountry();

	@Override
	public String toString() {
		return "Competition :" + type + ", refere=" + refere + ", stadium=" + stadium+"\n" ;
	}

	
	
	
	/*
	 * public String getDtf() { LocalDateTime now = LocalDateTime.now(); return
	 * dtf.format(now); }
	 * 
	 * public void SaveToFile() throws FileNotFoundException {
	 * 
	 * String nameFile = COMPETITION + getDtf() + TXT; File f = new File(nameFile);
	 * PrintWriter printW = new PrintWriter(f);
	 * 
	 * printW.close();
	 * 
	 * 
	 * }
	 */

}
