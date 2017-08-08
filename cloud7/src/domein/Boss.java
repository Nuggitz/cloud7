package domein;



public class Boss extends Entity {
    
    private int mod = 3;
    
    public Boss(int level) {
        super(level);
        super.setDamage(damage*this.mod);
        super.setHealth(health*this.mod);
        super.totalHp = super.health;
    }
}
