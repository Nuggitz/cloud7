package domein;

import java.util.Random;


public class Hit {
    
    private double damage;
    private boolean crit = false;
    
    public Hit(Entity en1, Entity en2) {
        this.crit=calcCrit(en1.getCrit());
        this.damage = calcDamage(en1.getDamage());
        en2.damage(this.damage);
        en1.setLastHit(this);
        en1.hit();
    }
    
    public Hit(double damage) {
        this.damage = damage;
    }
    
    private void controleerDamage(int damage) {
        if(damage <= 0) {
            throw new IllegalArgumentException("damage niet onder 0");
        }
    }

    public double getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public boolean isCrit() {
        return crit;
    }

    public void setCrit(boolean crit) {
        this.crit = crit;
    }
    
    private boolean calcCrit(double crit) {
        Random r = new Random();
        return (r.nextInt(100) < crit);
    }
    
    private double calcDamage(double damage) {
        return crit ? damage*2 : damage;
    }
}
