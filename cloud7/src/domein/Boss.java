package domein;



public class Boss extends Entity {
    
    public Boss(int level) {
        super(level);
        super.setDamage(damage*3);
        super.setHealth(health*3);
    }

    @Override
    public String toString() {
        return String.format("level %d %s with %d health and %d damage", super.level, this.getClass(), super.getHealth(), super.getDamage());
    }
}
