package domein;



public class DomeinController {
    private Player player;
    private Boss currentBoss;
    
    public DomeinController() {
        this.player = new Player(1);
    }
    
    public void damagePlayer(int damage) {
        player.damage(damage);
    }
    
    public void playerHit(int damage, Entity entity) {
        entity.damage(damage);
    }
    
    public void newBoss() {
        currentBoss = new Boss(1);
    }
    
    public String player() {
        return player.toString();
    }
    
    public String boss() {
        return currentBoss.toString();
    }
}