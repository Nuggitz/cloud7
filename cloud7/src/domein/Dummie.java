package domein;


public class Dummie extends Entity {

    public Dummie(int level) {
        super(level);
        super.setHealth(100);
        super.setDamage(0);
    }

    @Override
    public String toString() {
        return String.format("level %d %s with %.2f health and %.2f damage", super.level, this.getClass().getSimpleName(), super.getHealth(), super.getDamage());
    }
}
