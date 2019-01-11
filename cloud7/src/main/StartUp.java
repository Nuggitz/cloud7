package main;

import domein.DomeinController;
import gui.StartScreen;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;



public class StartUp extends Application{
    public static void main(String[] args) {
        //new CloudApp(new DomeinController()).start();
        launch(args);
    }
    
    @Override
    public void start(Stage stage){
        StartScreen root = new StartScreen(stage, new DomeinController());
        Scene scene = new Scene(root, 1920*.66, 1080*.66);
        stage.setScene(scene);
        stage.setTitle("Cloud 7");
    }
}
