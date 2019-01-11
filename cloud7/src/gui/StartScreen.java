package gui;

import domein.DomeinController;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class StartScreen extends VBox {

    private Label title;
    private Button startButton, exitButton;
    private DomeinController dc;
    private final Stage stage;
    private double w, h;

    public StartScreen(Stage stage, DomeinController dc) {
        this.stage = stage;
        this.dc = dc;
        this.title = new Label("Cloud 7");
        this.startButton = new Button("START");
        startButton.setDefaultButton(true);
        startButton.setOnAction(this::startGame);
        this.exitButton = new Button("EXIT");
        exitButton.setCancelButton(true);
        exitButton.setOnAction(this::exitGame);
        load();
        setStyle();
    }

    private void setStyle() {
        this.w = stage.getWidth();
        this.h = stage.getHeight();
        System.out.println("h: " + stage.getHeight() + "\nw: " + stage.getWidth());
        this.setSpacing(30);
        this.setPadding(new Insets(h/6, w/5, 10, w/5));
        title.setMaxWidth(Double.MAX_VALUE);
        title.setAlignment(Pos.CENTER);
        title.setStyle("-fx-font-size: 30pt;");
        startButton.setStyle("-fx-font-size: 15pt;");
        exitButton.setStyle("-fx-font-size: 15pt;");
        startButton.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        exitButton.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
    }

    private void load() {
        this.getChildren().addAll(title, startButton, exitButton);
        stage.show();
    }

    private void startGame(ActionEvent event) {
        GameScreen gs = new GameScreen(stage, dc);
        stage.getScene().setRoot(gs);
    }

    private void exitGame(ActionEvent event) {
        System.exit(0);
    }
}
