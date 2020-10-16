package view;

import java.util.ArrayList;

import controller.ManagementSystemController;

public interface UIinterface {
	
	  void createOlympic(String startDate, String endDate);
	  void addAthlete();
	  void addCompitition();
	  void addReferes();
	  void addCountry();
	  void addStadiums();
	 
	  void RemoveCompitition();
	  void RemoveReferes();
	  void RemoveCountry();
	  void RemoveStadiums();
	  
	  
	  ArrayList<String> treeCountrysWinning();
	void registerListener(ManagementSystemController managementSystemControllew);
	void showAllRefereAndStadiums(String showAll);
	  
	
	
	
	
	
	
	
	
	

}
