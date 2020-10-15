package view;
import javafx.scene.control.Button;
//import java.awt.Button;
import java.util.ArrayList;
import java.util.Vector;
import controller.ManagementSystemController;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import listeners.SystemUIEventListener;

public class GUI implements UIinterface{

	private Vector<SystemUIEventListener>allListeners = new Vector<SystemUIEventListener>();


	public GUI(Stage theStage) {

		theStage.setTitle("--Menu--");

		VBox vbRoots = new VBox();
		vbRoots.setSpacing(10);
		vbRoots.setPadding(new Insets(10));
		vbRoots.setAlignment(Pos.TOP_LEFT);


		Button btCreatOlympics = new Button("Creat an olympics");
		Button btAddAthlete = new Button("Add athlete");
		//Button btAddTeam = new Button("Ädd team");
		Button btAddCompetition = new Button("Add competition");
		Button btAddStadium = new Button("Add Stadium");
		Button btAddRefere = new Button("Add Refere");
		Button btEndOlympics = new Button("End olympics and show the winners");



		vbRoots.getChildren().addAll(btCreatOlympics,btAddAthlete,btAddAthlete,btAddCompetition,btAddStadium,btAddRefere,btEndOlympics);



		vbRoots.setBackground(new Background(new BackgroundFill(Color.AQUAMARINE, null, null)));
		theStage.setScene(new Scene(vbRoots, 400, 350));
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

}
