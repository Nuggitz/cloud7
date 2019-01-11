package gui;

import domein.DomeinController;
import javafx.animation.AnimationTimer;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class GameScreen extends BorderPane {

    private final Statbar statBar;
    private Group arena, boss;
    private Player player;
    private DomeinController dc;
    private final Stage stage;

    public GameScreen(Stage stage, DomeinController dc) {
        this.stage = stage;
        this.dc = dc;
        this.statBar = new Statbar(this.dc);
        this.arena = new Group();
        this.setTop(statBar);
        this.setBottom(arena);
        startGame();
    }

    private void updateStatBar() {
        statBar.update();
    }

    private void loadPlayer() {
        player = new Player(stage, dc);
        arena.getChildren().add(player);
    }

    private void loadBoss() {
        boss = new Boss(dc);
        arena.getChildren().add(boss);
    }

    private void startGame() {
        loadPlayer();
        dc.newFight();
        loadBoss();
        updateStatBar();
        
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                player.move();
            }
        };
        timer.start();
    }
}
