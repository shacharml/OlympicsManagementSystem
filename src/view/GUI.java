package view;

import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Vector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.crypto.SealedObject;
import javax.swing.JOptionPane;

import controller.ManagementSystemController;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import model.Athlete;
import model.Competition;
import model.Competition.compatitionType;
import model.Refere;
import model.Team;

public class GUI implements UIinterface {

	private Vector<SystemUIEventListener> allListeners = new Vector<SystemUIEventListener>();
	private ObservableList<String> allCountrys = Stream.of(Locale.getISOCountries())
			.map(locales -> new Locale("", locales)).map(Locale::getDisplayCountry)
			.collect(Collectors.toCollection(FXCollections::observableArrayList));

	private Label allRefereAndAllStadium = new Label();
	private Label allAthletes = new Label();
	private Button btShowAllAthletes = new Button();
	private Button btShowAllRefereStadium = new Button();
	private String[] typeAthlete = { "Runner", "HighJumper", "both" };

	public GUI(Stage theStage) throws FileNotFoundException {

		FileInputStream input = new FileInputStream(
				"C:\\Users\\Anetg\\git\\OlympicsManagementSystem\\olympic-rings.png");
		Image image = new Image(input);
		ImageView imageView = new ImageView(image);
		imageView.setFitHeight(170);
		imageView.setFitWidth(230);

		theStage.setTitle("--Menu--");

		VBox vbRoots = new VBox();
		vbRoots.setSpacing(10);
		vbRoots.setPadding(new Insets(10));
		vbRoots.setAlignment(Pos.TOP_CENTER);

		btShowAllRefereStadium.setVisible(false);
		btShowAllRefereStadium.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent action) {
				for (SystemUIEventListener l : allListeners)
					l.showAllRefereAndStadiumsUIEvent();
			}
		});

		btShowAllAthletes.setVisible(false);
		btShowAllAthletes.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent action) {
				for (SystemUIEventListener l : allListeners)
					l.showAllAthletesUIEvent();
			}
		});

		Button btCreatOlympics = new Button("Creat an olympics");
		Button btAddAthlete = new Button("Add athlete");
		Button btAddCoutry = new Button("Ädd Country");
		Button btAddCompetition = new Button("Add competition");
		Button btAddStadium = new Button("Add Stadium");
		Button btAddRefere = new Button("Add Refere");

		Button btRemoveAthlete = new Button("Remove Athlete");
		Button btShowAllOlympic = new Button("Show All Olympic");
		Button btRemoveStadium = new Button("Remove Stadium");
		Button btRemoveRefere = new Button("Remove Refere");

		Button btEndOlympics = new Button("End olympics and show the winners");

		btCreatOlympics.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent action) {
				btCreatOlympics.setVisible(false);
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
				ComboBox<String> cmTypeOfAthlete = new ComboBox<String>();
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

						stageAddAthlete.close();
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
				btShowAllAthletes.fire();
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

				Label lbCompetitionType = new Label("choose type of compatition :");
				ComboBox<String> cmCompetitionType = new ComboBox<String>();
				cmCompetitionType.getItems().addAll("Personal Competition", "Team Competition");

				Label lbRefere = new Label("choose Index of Refere :");
				TextField txIndexRefere = new TextField();
				txIndexRefere.setMaxWidth(100);

				Label lbStadium = new Label("choose Index of Stadium :");
				TextField txStadium = new TextField();
				txStadium.setMaxWidth(100);

				Button btSelect = new Button(" select ");
				btSelect.setOnAction(new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent arg0) {

						for (SystemUIEventListener l : allListeners)
							l.getArraySelect(cmCompetitionType.getValue(), cmType.getValue(), txIndexRefere.getText(),
									txStadium.getText());
						stageAddCompetition.close();
					}
				});

				vbAddCompatition.getChildren().addAll(lbType, cmType, lbCompetitionType, cmCompetitionType, lbRefere,
						txIndexRefere, lbStadium, txStadium, spShowAll, btSelect);

				stageAddCompetition.setScene(new Scene(vbAddCompatition, 600, 600));
				stageAddCompetition.show();

			}
		});

		btAddStadium.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent action) {
				Stage stageAddStadium = new Stage();
				stageAddStadium.setTitle("add Stadium :");

				VBox vbAddStadium = new VBox();
				vbAddStadium.setSpacing(10);
				vbAddStadium.setPadding(new Insets(10));
				vbAddStadium.setAlignment(Pos.TOP_LEFT);

				Label lbName = new Label();
				lbName.setText("write  the name of the Stadium : ");
				TextField tfNameStadium = new TextField();
				tfNameStadium.setMaxWidth(100);

				Label lbLocation = new Label();
				lbLocation.setText("write  the Location of the Stadium : ");
				TextField tfLocation = new TextField();
				tfLocation.setMaxWidth(100);

				Label lbSeats = new Label();
				lbSeats.setText("pick the number of seats in the Stadium : ");

				final Label lbNumSeats = new Label();

				final Slider slider = new Slider(0, 10000, 0);
				slider.setShowTickLabels(true);
				slider.valueProperty().addListener(new ChangeListener<Number>() {

					@Override
					public void changed(ObservableValue<? extends Number> observableValue, Number oldValue,
							Number newValue) {
						lbNumSeats.textProperty().setValue(String.valueOf(newValue.intValue()));
					}

				});
				Button btAddSt = new Button("Add Stadium !");
				btAddSt.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent action) {

						for (SystemUIEventListener l : allListeners) {
							l.addStadiumToUIEvent(tfNameStadium.getText(), tfLocation.getText(),
									(int) slider.getValue());
							stageAddStadium.close();
						}
					}
				});

				vbAddStadium.getChildren().addAll(lbName, tfNameStadium, lbLocation, tfLocation, lbSeats, slider,
						lbNumSeats, btAddSt);
				stageAddStadium.setScene(new Scene(vbAddStadium));
				stageAddStadium.show();

			}
		});

		btAddRefere.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent action) {
				Stage stageAddRefere = new Stage();
				stageAddRefere.setTitle("add Refere :");

				VBox vbAddRefere = new VBox();
				vbAddRefere.setSpacing(10);
				vbAddRefere.setPadding(new Insets(10));
				vbAddRefere.setAlignment(Pos.TOP_LEFT);

				Label lbName = new Label();
				lbName.setText("write  the name of the Refere: ");
				TextField tfNameRefere = new TextField();
				tfNameRefere.setMaxWidth(100);

				Label lbcontry = new Label("insert the country of Refere : ");
				ComboBox<String> cmCountry = new ComboBox<String>();
				cmCountry.getItems().addAll(allCountrys);

				Label lbType = new Label("insert the juging Type of Refere : ");
				ComboBox<String> cmTypeOfjuging = new ComboBox<String>();
				cmTypeOfjuging.getItems().addAll(typeAthlete);

				Button btAddRefe = new Button("Add Refere !");
				btAddRefe.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent action) {

						for (SystemUIEventListener l : allListeners) {
							l.addRefereToUIEvent(tfNameRefere.getText(), cmCountry.getValue(),
									cmTypeOfjuging.getValue());
							stageAddRefere.close();
						}
					}
				});

				vbAddRefere.getChildren().addAll(lbName, tfNameRefere, lbcontry, cmCountry, lbType, cmTypeOfjuging,
						btAddRefe);
				stageAddRefere.setScene(new Scene(vbAddRefere));
				stageAddRefere.show();
			}
		});

		btRemoveAthlete.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent action) {

				btShowAllAthletes.fire();

				Stage stageRemoveAthlete = new Stage();
				stageRemoveAthlete.setTitle("Remove Athlete:");

				VBox vbRemoveAthlete = new VBox();
				vbRemoveAthlete.setSpacing(10);
				vbRemoveAthlete.setPadding(new Insets(10));
				vbRemoveAthlete.setAlignment(Pos.TOP_LEFT);

				Label lbIndexAthlete = new Label();
				lbIndexAthlete.setText("write index of the athlete you want to remove: ");
				TextField tfIndexAthleteR = new TextField();
				tfIndexAthleteR.setMaxWidth(100);

				ScrollPane spShowAllAthletes = new ScrollPane();
				spShowAllAthletes.setContent(allAthletes);
				spShowAllAthletes.setMaxWidth(600);

				Button btRemoveAthlete = new Button("Remove");
				btRemoveAthlete.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent action) {
						for (SystemUIEventListener l : allListeners) {
							l.RemoveAthleteToUIEvent(Integer.parseInt(tfIndexAthleteR.getText()));

						}

					}
				});

				vbRemoveAthlete.getChildren().addAll(lbIndexAthlete, tfIndexAthleteR, spShowAllAthletes,
						btRemoveAthlete);
				stageRemoveAthlete.setScene(new Scene(vbRemoveAthlete));
				stageRemoveAthlete.show();
			}
		});

		btRemoveStadium.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent action) {

				btShowAllRefereStadium.fire();

				Stage stageRemoveStadium = new Stage();
				stageRemoveStadium.setTitle("Remove Stadium:");

				VBox vbRemoveStadium = new VBox();
				vbRemoveStadium.setSpacing(10);
				vbRemoveStadium.setPadding(new Insets(10));
				vbRemoveStadium.setAlignment(Pos.TOP_LEFT);

				Label lbIndexStadium = new Label();
				lbIndexStadium.setText("write index of the Stadium you want to remove: ");
				TextField tfIndexStadiummR = new TextField();
				tfIndexStadiummR.setMaxWidth(100);

				ScrollPane spShowAllStadium = new ScrollPane();
				spShowAllStadium.setContent(allRefereAndAllStadium);
				spShowAllStadium.setMaxWidth(600);

				Button btRemoveStadium = new Button("Remove");
				btRemoveStadium.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent action) {
						for (SystemUIEventListener l : allListeners) {
							l.RemoveStadiumToUIEvent(Integer.parseInt(tfIndexStadiummR.getText()));

						}

					}
				});

				vbRemoveStadium.getChildren().addAll(lbIndexStadium, tfIndexStadiummR, spShowAllStadium,
						btRemoveStadium);
				stageRemoveStadium.setScene(new Scene(vbRemoveStadium));
				stageRemoveStadium.show();

			}
		});

		btRemoveRefere.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent action) {

				btShowAllRefereStadium.fire();

				Stage stageRemoveRefere = new Stage();
				stageRemoveRefere.setTitle("Remove refere:");

				VBox vbRemoveRefere = new VBox();
				vbRemoveRefere.setSpacing(10);
				vbRemoveRefere.setPadding(new Insets(10));
				vbRemoveRefere.setAlignment(Pos.TOP_LEFT);

				Label lbIndexRefere = new Label();
				lbIndexRefere.setText("write index of the refere you want to remove: ");
				TextField tfIndexRefere = new TextField();
				tfIndexRefere.setMaxWidth(100);

				ScrollPane spShowAllRefers = new ScrollPane();
				spShowAllRefers.setContent(allRefereAndAllStadium);
				spShowAllRefers.setMaxWidth(600);

				Button btRemoveRefere = new Button("Remove");
				btRemoveRefere.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent action) {
						for (SystemUIEventListener l : allListeners) {
							l.RemoveRefereToUIEvent(Integer.parseInt(tfIndexRefere.getText()));

						}

					}
				});

				vbRemoveRefere.getChildren().addAll(lbIndexRefere, tfIndexRefere, spShowAllRefers, btRemoveRefere);
				stageRemoveRefere.setScene(new Scene(vbRemoveRefere));
				stageRemoveRefere.show();

			}
		});

		btEndOlympics.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent action) {
				for (SystemUIEventListener l : allListeners)
					l.showAllTheWinnersUIEvent();
			}
		});

		btAddCoutry.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent action) {

				Stage stageAddCountry = new Stage();
				stageAddCountry.setTitle("Add Country");

				VBox vbAddCountry = new VBox();
				vbAddCountry.setSpacing(10);
				vbAddCountry.setPadding(new Insets(10));
				vbAddCountry.setAlignment(Pos.TOP_CENTER);

				Label lbAddCountry = new Label("Choose the country you want to add olimpics :");
				ComboBox<String> cb = new ComboBox<>(allCountrys);

				Button btAddCo = new Button("Add Country !");
				btAddCo.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent action) {
						for (SystemUIEventListener l : allListeners)
							l.addCountryToUI(cb.getValue());
						stageAddCountry.close();
					}
				});

				vbAddCountry.getChildren().addAll(lbAddCountry, cb, btAddCo);
				stageAddCountry.setScene(new Scene(vbAddCountry));
				stageAddCountry.show();

			}
		});

		btShowAllOlympic.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent action) {
				for (SystemUIEventListener l : allListeners)
					l.ShowAllOlimpicToUI();
			}
		});

		vbRoots.getChildren().addAll(imageView, btCreatOlympics, btAddCoutry, btAddAthlete, btAddStadium, btAddRefere,
				btAddCompetition, btRemoveAthlete, btRemoveStadium, btRemoveRefere, btEndOlympics, btShowAllOlympic);
		vbRoots.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, null, null)));

		theStage.setScene(new Scene(vbRoots, 300, 600));
		theStage.show();

	}

	@Override
	public void addCompitition(Competition comp) {
		JOptionPane.showMessageDialog(null, comp.toString());

	}

	@Override
	public void addReferes(Refere refere) {
		JOptionPane.showMessageDialog(null, refere.toString());

	}

	@Override
	public void addCountry() {
		JOptionPane.showMessageDialog(null, "the country was added");
	}

	@Override
	public void addStadiums(String stadium) {
		JOptionPane.showMessageDialog(null, stadium);

	}

	@Override
	public void addAthlete() {
		JOptionPane.showMessageDialog(null, " add an athlete ");

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
	public void RemoveRefere() {
		btShowAllRefereStadium.fire();

	}

	@Override
	public void createOlympic(String startDate, String endDate) {
		JOptionPane.showMessageDialog(null, startDate + "  " + endDate);

	}

	@Override
	public void showAllRefereAndStadiums(String showAll) {

		this.allRefereAndAllStadium.setText(showAll);
		/*
		 * Stage AllAll = new Stage(); AllAll.setScene(new
		 * Scene(allRefereAndAllStadium)); AllAll.show();
		 */

	}

	@Override
	public void showAllAthletes(String allAthletes) {
		this.allAthletes.setText(allAthletes);

	}

	@Override
	public void removeAthlete() {
		btShowAllAthletes.fire();

	}

	@Override

	public void removeStadium() {
		btShowAllRefereStadium.fire();

	}

	@Override
	public void showAllTheWinners(String theWinners) {
		Stage stagetheWinners = new Stage();
		Label lbWinners = new Label(theWinners);
		stagetheWinners.setScene(new Scene(lbWinners));
		stagetheWinners.show();
	}

	@Override
	public void showAllOlimpics(String allOlimpic) {
		Stage stageAllOlimpic = new Stage();
		Label lbAllOlimpic = new Label(allOlimpic);
		ScrollPane allOlimpicScroll  = new ScrollPane(lbAllOlimpic);
		
		stageAllOlimpic.setScene(new Scene(allOlimpicScroll));
		stageAllOlimpic.show();

	}

	@Override
	public void getArraySelectAthlete(ArrayList<Athlete> arraySelect, String typeAthlete, String indexRefere,
			String indexStadium) {
		ArrayList<Athlete> newArr = new ArrayList<Athlete>();
		for (int i = 0; i < arraySelect.size(); i++) {
			newArr.add(arraySelect.get(i));
		}
		ArrayList<Object> selectAthletes = new ArrayList<Object>();

		Stage stAllAtheleteSelect = new Stage();
		VBox vboxSelect = new VBox();
		Label lbIndexAthlete = new Label("choose the athletes or the teams you want(you need to press ctrl  ");
		ListView<Athlete> allAtletes = new ListView<Athlete>();
		// ObservableList<String> items = (ObservableList<String>) newArr ;
		// show on the screen
		ObservableList<Athlete> items = FXCollections.observableArrayList(newArr);

		// ObservableList<String> items = FXCollections.observableArrayList("Cricket",
		// "Chess", "Kabaddy", "Badminton",
		// "Football", "Golf", "CoCo", "car racing");
		allAtletes.setItems(items);
		allAtletes.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

		Button btselect = new Button(" Add Competition ");
		btselect.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				stAllAtheleteSelect.close();
				ObservableList<Athlete> selectItems = allAtletes.getSelectionModel().getSelectedItems();
				for (Athlete athlete : selectItems) {
					selectAthletes.add(athlete);

				}
				for (SystemUIEventListener l : allListeners)

					if (typeAthlete.equals(compatitionType.HighJumper.toString())) {
						l.addCompetitionToUIEvent(compatitionType.HighJumper, "Personal Competition", indexRefere,
								indexStadium, selectAthletes);
					} else
						l.addCompetitionToUIEvent(compatitionType.Runner, "Personal Competition", indexRefere,
								indexStadium, selectAthletes);

			}
		});

		vboxSelect.getChildren().addAll(lbIndexAthlete, allAtletes, btselect);
		stAllAtheleteSelect.setScene(new Scene(vboxSelect));

		stAllAtheleteSelect.show();

	}

	@Override
	public void getArraySelectTeam(ArrayList<Team> arraySelect, String typeTeam, String indexRefere,
			String indexStadium) {

		ArrayList<Team> newArr = new ArrayList<Team>();
		for (int i = 0; i < arraySelect.size(); i++) {
			newArr.add(arraySelect.get(i));
		}

		Stage stAllTeamSelect = new Stage();
		VBox vboxSelect = new VBox();
		Label lbIndexAthlete = new Label("choose the athletes or the teams you want(you need to press ctrl  ");
		ListView<Team> allAtletes = new ListView<Team>();
		// ObservableList<String> items = (ObservableList<String>) newArr ;
		ObservableList<Team> items = FXCollections.observableArrayList(newArr);
		// ("Cricket", "Chess", "Kabaddy", "Badminton", "Football", "Golf", "CoCo", "car
		// racing");
		allAtletes.setItems(items);
		allAtletes.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

		Button btselect = new Button(" Add Competition ");
		btselect.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				stAllTeamSelect.close();
				ArrayList<Object> selectTeams = new ArrayList<Object>();
				ObservableList<Team> selectItems = allAtletes.getSelectionModel().getSelectedItems();
				for (Team teams : selectItems) {
					selectTeams.add(teams);
				}

				for (SystemUIEventListener l : allListeners)
					if (typeTeam.equals(compatitionType.HighJumper.toString())) {
						l.addCompetitionToUIEvent(compatitionType.HighJumper, "Team Competition", indexRefere,
								indexStadium, selectTeams);
					} else
						l.addCompetitionToUIEvent(compatitionType.Runner, "Team Competition", indexRefere, indexStadium,
								selectTeams);
			}
		});

		vboxSelect.getChildren().addAll(lbIndexAthlete, allAtletes, btselect);
		stAllTeamSelect.setScene(new Scene(vboxSelect));
		stAllTeamSelect.show();

	}

}