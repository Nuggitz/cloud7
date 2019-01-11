package gui;

import domein.DomeinController;
import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class GameScreen1 extends AnchorPane {

    private final DomeinController dc;
    //private final Canvas canvas;
    //private final GraphicsContext gc;
    private Image imageRick;
    private Image imageBoss;
    private Node rick;
    private Node boss;
    private final double w, h;
    private boolean running, attacking, goUp, goDown, goLeft, goRight;
    private final Stage stage;
    private Group arena;

    public GameScreen1(Stage stage, DomeinController dc) {
        this.dc = dc;
        this.w = 1920;
        this.h = 1080;
        this.stage = stage;
        start();
        startFight();
    }

    private void start() {
        
        imageRick = new Image("images/rickfront.png");
        rick = new ImageView(imageRick);
        
        arena = new Group(rick);
        moveHeroTo(rick, w/2,h/2);
        Scene scene = new Scene(arena, w, h);
        
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCode()) {
                    case UP:
                        goUp = true;
                        break;
                    case DOWN:
                        goDown = true;
                        break;
                    case LEFT:
                        goLeft = true;
                        break;
                    case RIGHT:
                        goRight = true;
                        break;
                    case SHIFT:
                        running = true;
                        break;
                    case SPACE:
                        attacking = true;
                        break;
                }
            }
        });

        scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCode()) {
                    case UP:
                        goUp = false;
                        break;
                    case DOWN:
                        goDown = false;
                        break;
                    case LEFT:
                        goLeft = false;
                        break;
                    case RIGHT:
                        goRight = false;
                        break;
                    case SHIFT:
                        running = false;
                        break;
                    case SPACE:
                        attacking = false;
                        break;
                }
            }
        });
        
        stage.setScene(scene);
        stage.show();

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                int dx = 0, dy = 0;

                if (goUp) {
                    dy -= dc.getSpeed();
                }
                if (goDown) {
                    dy += dc.getSpeed();
                }
                if (goRight) {
                    dx += dc.getSpeed();
                }
                if (goLeft) {
                    dx -= dc.getSpeed();
                }
//                if (running) {
//                    dx *= 3;
//                    dy *= 3;
//                }
                moveHeroBy(rick, dx, dy);
            }
        };
        timer.start();
    }
    
    private void moveHeroBy(Node entity, int dx, int dy) {
        if (dx == 0 && dy == 0) return;

        final double cx = entity.getBoundsInLocal().getWidth()  / 2;
        final double cy = entity.getBoundsInLocal().getHeight() / 2;

        double x = cx + entity.getLayoutX() + dx;
        double y = cy + entity.getLayoutY() + dy;

        moveHeroTo(entity, x, y);
    }

    private void moveHeroTo(Node entity, double x, double y) {
        final double cx = entity.getBoundsInLocal().getWidth()  / 2;
        final double cy = entity.getBoundsInLocal().getHeight() / 2;

        if (x - cx >= 0 &&
            x + cx <= w &&
            y - cy >= 0 &&
            y + cy <= h) {
            entity.relocate(x - cx, y - cy);
        }
    }
    
    private void startFight() {
        imageBoss = new Image("/images/boomb.gif");
        boss = new ImageView(imageBoss);
        arena.getChildren().add(boss);
        moveHeroTo(boss, w*.6, h/2);
    }
}
