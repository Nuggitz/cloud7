package domein;



public class Player extends Entity{
    
    public Player(int level) {
        super(level);
    }

    @Override
    public String toString() {
        return String.format("level %d %s with %d health and %d damage", super.level, this.getClass(), super.getHealth(), super.getDamage());
    }
    
}