package program;

import controller.ManagementSystemController;
import javafx.application.Application;
import javafx.stage.Stage;
import model.AdminSystem;
import view.GUI;
import view.UIinterface;

public class Main extends Application {

	public static void main(String[] args) {
		launch(args);

	}

	@Override
	public void start(Stage arg0) throws Exception {
	AdminSystem adminSystem= new AdminSystem();
	UIinterface SystemInterface= new GUI(arg0);
	ManagementSystemController controller = new ManagementSystemController(adminSystem,SystemInterface);
		
	}

}
