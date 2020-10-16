package model;
import listeners.SystemEventListener;
import model.Athlete.AthleteType;

import java.time.LocalDate;
import java.util.Vector;

import controller.ManagementSystemController;
public class AdminSystem {
	
	private Olympics olympics;
	private Vector<SystemEventListener> listeners;
	
	public AdminSystem() {
		listeners = new Vector<SystemEventListener>();
	}
	
	public void createOlypics(LocalDate startDate, LocalDate endDate) {
		olympics =new Olympics( startDate.toString(), endDate.toString());
		fireCreateOlympicEvent(startDate.toString(), endDate.toString());
	}	
	private void fireCreateOlympicEvent(String startDate , String endDate) {
		for(SystemEventListener l : listeners)
		  l.createOlympicModelEvent(startDate,endDate);
	}

	public void registerListener(SystemEventListener listenerControoler) {
		listeners.add(listenerControoler);
		
	}

	public void addAthlete(String name, String country, AthleteType type , int score) {
		
		olympics.addAthlete(name, country, type , score);
		fireAddAthleteEvent();
	}

	private void fireAddAthleteEvent() {
		for(SystemEventListener l : listeners)
		  l.addAthleteToModelEvent();
	}

	public void showAllRefereAndStadiums() {
		 
		String showAll = olympics.showAllRefereAndStadiums();
		fireShowAllRefereAndStadiumsEvent(showAll);
	}

	private void fireShowAllRefereAndStadiumsEvent(String showAll) {
		for(SystemEventListener l : listeners)
			  l.showAllRefereAndStadiumsUModelEvent(showAll);
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
