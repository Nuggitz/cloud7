package gui;

import domein.DomeinController;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class Boss extends Group{
    
    private Image imageBoss, imageWeapon;
    private ImageView boss, weapon;
//    private final Stage stage;
    private DomeinController dc;
    
    public Boss(DomeinController dc) {
//        this.stage = stage;
        this.dc = dc;
        imageBoss = new Image(this.dc.getBossImg());
        boss = new ImageView(imageBoss);
        this.getChildren().add(boss);
    }
}
