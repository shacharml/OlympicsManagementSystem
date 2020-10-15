package model;
import listeners.SystemEventListener;
import java.util.Vector;

import controller.ManagementSystemController;
public class AdminSystem {
	
	private Olympics olympics;
	private Vector<SystemEventListener> listeners;
	
	public AdminSystem() {
		listeners = new Vector<SystemEventListener>();
	}
	
	public void createOlypics(int sday, int smounth, int syear,int eday, int emounth, int eyear) {
		olympics =new Olympics( sday,  smounth,  syear, eday,  emounth,  eyear);
		
	}

	public void registerListener(ManagementSystemController managementSystemController) {
		listeners.add(managementSystemController);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
