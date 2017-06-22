package domein;



public abstract class Entity {
    protected int health;
    protected int damage;
    protected int level;
    
    public Entity(int level) {
        int hp = level*20;
        int dmg = level*2;
        controleerLevel(level);
        this.level = level;
        controleerHealth(hp);
        this.health = hp;
        controleerDamage(dmg);
        this.damage = dmg;
    }
    
    private void controleerHealth(int health) {
        if(health < 0) {
            throw new IllegalArgumentException("health onder 0");
        }
    }
    
    private void controleerDamage(int damage) {
        if(damage < 0) {
            throw new IllegalArgumentException("damage onder 0");
        }
    }
    
    private void controleerLevel(int level) {
        if(level < 0) {
            throw new IllegalArgumentException("level onder 0");
        }
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        controleerHealth(health);
        this.health = health;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        controleerDamage(damage);
        this.damage = damage;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
    
    public void damage(int damage) {
        setHealth(getHealth()-damage);
    }
    
    public boolean isDead() {
        return health == 0;
    }
    
    @Override
    public abstract String toString();
}
