package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public abstract class Competition {
	
	public enum competitionType {running , highJumpping, both};
	private competitionType type;
	private Refere refere;
	private Stadium stadium;
	
	
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy_MM_dd");

	final String TXT = ".txt";
	final String COMPETITION = "Competition_";
	
	
	public Competition(Refere refere, Stadium stadium , competitionType type) {
		
		this.refere = refere;
		this.stadium = stadium;
		this.type =type;
		}
	
	
	
	public abstract ArrayList<String> treeWinnersCountry();	
	
	/*public String getDtf() {
		LocalDateTime now = LocalDateTime.now();
		return dtf.format(now);
	}
	
	public void SaveToFile() throws FileNotFoundException {
		
		String nameFile = COMPETITION + getDtf() + TXT;
		File f = new File(nameFile);
		PrintWriter printW = new PrintWriter(f);

		printW.close();
		
		
		}*/
	
	
	
		
	
		
		
	}
	
	

	
	




