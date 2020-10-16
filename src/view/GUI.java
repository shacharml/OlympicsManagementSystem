package view;

import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Vector;

import javax.swing.JOptionPane;

import controller.ManagementSystemController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import listeners.SystemUIEventListener;
import model.Athlete.AthleteType;
import model.Refere;

public class GUI implements UIinterface {

	private Vector<SystemUIEventListener> allListeners = new Vector<SystemUIEventListener>();

	private String[] allCountrys = { "Israel", "Brazil" };

	private AthleteType running, highJumpping, both;

	private Label allRefereAndAllStadium = new Label();

	private AthleteType[] typeAthlete = { running, highJumpping, both };

	public GUI(Stage theStage) {

		theStage.setTitle("--Menu--");

		VBox vbRoots = new VBox();
		vbRoots.setSpacing(10);
		vbRoots.setPadding(new Insets(10));
		vbRoots.setAlignment(Pos.TOP_LEFT);

		Button btShowAllRefereStadium = new Button();
		btShowAllRefereStadium.setVisible(false);
		btShowAllRefereStadium.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent action) {
				for (SystemUIEventListener l : allListeners)
					l.showAllRefereAndStadiumsUIEvent();
			}
		});

		Button btCreatOlympics = new Button("Creat an olympics");
		Button btAddAthlete = new Button("Add athlete");
		// Button btAddTeam = new Button("Ädd team");
		Button btAddCompetition = new Button("Add competition");
		Button btAddStadium = new Button("Add Stadium");
		Button btAddRefere = new Button("Add Refere");

		Button btRemoveAthlete = new Button("Remove Athlete");
		Button btRemoveCompetition = new Button("Remove Competition");
		Button btRemoveStadium = new Button("Remove Stadium");
		Button btRemoveRefere = new Button("Remove Refere");

		Button btEndOlympics = new Button("End olympics and show the winners");

		btCreatOlympics.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent action) {
				Stage stageCreatOlympics = new Stage();
				stageCreatOlympics.setTitle("Creat Olympics");

				Label lbSDate = new Label("Choose olympic starting day :");
				DatePicker datePickerS = new DatePicker();
				Label lbEDate = new Label("Choose olympic endting day :");
				DatePicker datePickerE = new DatePicker();

				Button btCreate = new Button("creat !");
				btCreate.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent action) {
						for (SystemUIEventListener l : allListeners)
							l.createOlympicUIEvent(datePickerS.getValue(), datePickerE.getValue());
						stageCreatOlympics.close();
					}
				});

				VBox vbCreate = new VBox();
				vbCreate.setSpacing(10);
				vbCreate.setPadding(new Insets(10));
				vbCreate.setAlignment(Pos.TOP_LEFT);
				vbCreate.getChildren().addAll(lbSDate, datePickerS, lbEDate, datePickerE, btCreate);
				stageCreatOlympics.setScene(new Scene(vbCreate, 300, 200));
				stageCreatOlympics.show();

			}
		});

		btAddAthlete.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent action) {
				Stage stageAddAthlete = new Stage();
				stageAddAthlete.setTitle("Add Athlete : ");

				GridPane gpAddAthlete = new GridPane();
				gpAddAthlete.setPadding(new Insets(10));
				gpAddAthlete.setHgap(10);
				gpAddAthlete.setVgap(10);

				Label lbName = new Label("insert the Athlete name : ");
				TextField tfName = new TextField();

				Label lbType = new Label("insert the Type of Athlete : ");
				ComboBox<AthleteType> cmTypeOfAthlete = new ComboBox<AthleteType>();
				cmTypeOfAthlete.getItems().addAll(typeAthlete);

				Label lbcontry = new Label("insert the country of Athlete : ");
				ComboBox<String> cmCountry = new ComboBox<String>();
				cmCountry.getItems().addAll(allCountrys);

				Label lbScore = new Label("insert the score of Athlete : ");
				ComboBox<Integer> cmScoreOfAthlete = new ComboBox<Integer>();
				cmScoreOfAthlete.getItems().addAll(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

				Button btAddA = new Button(" Add ");
				btAddA.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent action) {
						for (SystemUIEventListener l : allListeners)
							l.addAthleteToUIEvent(tfName.getText(), cmCountry.getValue(), cmTypeOfAthlete.getValue(),
									cmScoreOfAthlete.getValue());
					}
				});

				gpAddAthlete.add(lbName, 1, 0);
				gpAddAthlete.add(tfName, 2, 0);
				gpAddAthlete.add(lbType, 1, 1);
				gpAddAthlete.add(cmTypeOfAthlete, 2, 1);
				gpAddAthlete.add(lbcontry, 1, 2);
				gpAddAthlete.add(cmCountry, 2, 2);
				gpAddAthlete.add(lbScore, 1, 3);
				gpAddAthlete.add(cmScoreOfAthlete, 2, 3);
				gpAddAthlete.add(btAddA, 1, 4);

				stageAddAthlete.setScene(new Scene(gpAddAthlete));
				stageAddAthlete.show();

			}
		});

		btAddCompetition.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent action) {

				btShowAllRefereStadium.fire();
				Stage stageAddCompetition = new Stage();
				stageAddCompetition.setTitle("add Competition :");

				VBox vbAddCompatition = new VBox();
				vbAddCompatition.setSpacing(10);
				vbAddCompatition.setPadding(new Insets(10));
				vbAddCompatition.setAlignment(Pos.TOP_LEFT);

				ScrollPane spShowAll = new ScrollPane();
				spShowAll.setContent(allRefereAndAllStadium);
				spShowAll.setMaxWidth(600); 
				
				
				Label lbType = new Label("choose type of compatition :");
				ComboBox<String> cmType = new ComboBox<String>();
				cmType.getItems().addAll("Run", "High Jump");

				Label lbRefere = new Label("choose Index of Refere :");
				TextField txRefere = new TextField();
				txRefere.setMaxWidth(100);

				Label lbStadium = new Label("choose Index of Stadium :");
				TextField txStadium = new TextField();
				txStadium.setMaxWidth(100);

				Button btAddComp = new Button(" Add Competition ");
				btAddComp.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent action) {
						for (SystemUIEventListener l : allListeners)
							l.addCompetitionToUIEvent();
					}
				});

				vbAddCompatition.getChildren().addAll(lbType, cmType, lbRefere, txRefere, lbStadium, txStadium,spShowAll,
						btAddComp);

				
				
				stageAddCompetition.setScene(new Scene(vbAddCompatition,600,600));
				stageAddCompetition.show();

			}
		});

		vbRoots.getChildren().addAll(btCreatOlympics, btAddAthlete, btAddCompetition, btAddStadium, btAddRefere,
				btRemoveAthlete, btRemoveCompetition, btRemoveStadium, btRemoveRefere, btEndOlympics);
		vbRoots.setBackground(new Background(new BackgroundFill(Color.LIGHTPINK, null, null)));
		theStage.setScene(new Scene(vbRoots, 500, 400));
		theStage.show();

	}

	@Override
	public void addCompitition() {
		// TODO Auto-generated method stub

	}

	@Override
	public void addReferes() {
		// TODO Auto-generated method stub

	}

	@Override
	public void addCountry() {
		// TODO Auto-generated method stub

	}

	@Override
	public void addStadiums() {
		// TODO Auto-generated method stub

	}

	@Override
	public ArrayList<String> treeCountrysWinning() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void registerListener(ManagementSystemController managementSystemController) {
		this.allListeners.add(managementSystemController);

	}

	@Override
	public void RemoveCompitition() {
		// TODO Auto-generated method stub

	}

	@Override
	public void RemoveReferes() {
		// TODO Auto-generated method stub

	}

	@Override
	public void RemoveCountry() {
		// TODO Auto-generated method stub

	}

	@Override
	public void RemoveStadiums() {
		// TODO Auto-generated method stub

	}

	@Override
	public void createOlympic(String startDate, String endDate) {
		JOptionPane.showMessageDialog(null, startDate + "  " + endDate);

	}

	@Override
	public void addAthlete() {
		JOptionPane.showMessageDialog(null, " add an athlete ");

	}

	@Override
	public void showAllRefereAndStadiums(String showAll) {

		allRefereAndAllStadium.setText(showAll);
		Stage AllAll = new Stage();
		AllAll.setScene(new Scene(allRefereAndAllStadium));
		AllAll.show();

	}

}
