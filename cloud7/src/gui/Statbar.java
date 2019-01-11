package gui;

import domein.DomeinController;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.Border;
import javafx.scene.layout.HBox;


public final class Statbar extends HBox{
    
    private DomeinController dc;
    private Label playerHp, playerHits, player, boss;
    
    public Statbar(DomeinController dc) {
        this.dc = dc;
        this.player = new Label(dc.player());
        this.boss = new Label("BOSS");
        this.getChildren().addAll(player, boss);
        setStyle();
    }
    
    private void setStyle() {
        this.setPadding(new Insets(10));
        this.setStyle("-fx-background-color: grey");
    }
    
    public void update() {
        player.setText(dc.player());
        boss.setText(dc.boss());
    }
}
