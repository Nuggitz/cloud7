package gui;

import domein.DomeinController;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class Player extends Group {

    private Image imagePlayer, imageWeapon;
    private ImageView player, weapon;
    private final Stage stage;
    private final DomeinController dc;
    private boolean running, attacking, goUp, goDown, goLeft, goRight;
    private final double w, h;

    public Player(Stage stage, DomeinController dc) {
        this.stage = stage;
        this.dc = dc;
        this.w = stage.getWidth();
        this.h = stage.getHeight();
        imagePlayer = new Image(this.dc.getPlayerImg());
        player = new ImageView(imagePlayer);
        load();
    }

    private void load() {
        this.getChildren().add(player);
        moveTo(w / 2, h / 2);

        stage.getScene().setOnKeyPressed(new EventHandler<KeyEvent>() {
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

        stage.getScene().setOnKeyReleased(new EventHandler<KeyEvent>() {
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
    }

    public void move() {
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
        moveBy(dx, dy);
    }

    private void moveBy(int dx, int dy) {
        if (dx == 0 && dy == 0) {
            return;
        }

        final double cx = player.getBoundsInLocal().getWidth() / 2;
        final double cy = player.getBoundsInLocal().getHeight() / 2;

        double x = cx + player.getLayoutX() + dx;
        double y = cy + player.getLayoutY() + dy;

        moveTo(x, y);
    }

    private void moveTo(double x, double y) {
        final double cx = player.getBoundsInLocal().getWidth() / 2;
        final double cy = player.getBoundsInLocal().getHeight() / 2;

        if (x - cx >= 0
                && x + cx <= w
                && y - cy >= 0
                && y + cy <= h) {
            player.relocate(x - cx, y - cy);
        }
    }
}
