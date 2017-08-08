package domein;

import exceptions.*;


public abstract class Entity {
    protected double totalHp, health, addHealth;
    protected double damage, addDamage;
    protected int level;
    protected double crit;
    protected Hit lastHit;
    protected int hits = 0;
    
    public Entity(int level) {
        controleerLevel(level);
        this.level = level;
        double hp = Math.pow(level, 2) + addHealth;
        double dmg = Math.pow(level, .2) + addDamage;
        controleerHealth(hp);
        this.health = hp;
        controleerDamage(dmg);
        this.damage = dmg;
        crit = 15;
    }
    
    private void calcStats() {
        this.health = Math.pow(level, 2) + addHealth;
        this.damage = Math.pow(level, .2) + addDamage;
    }
    
    private void controleerHealth(double health) {
        if(health <= 0) {
            throw new HealthException();
        }
    }
    
    private void controleerDamage(double damage) {
        if(damage < 0) {
            throw new DamageException();
        }
    }
    
    private void controleerLevel(int level) {
        if(level <= 0) {
            throw new LevelException();
        }
    }
    
    private void controleerCrit(double crit) {
        if(crit < 0 || crit > 100) {
            throw new CritException();
        }
    }

    public double getHealth() {
        return health;
    }

    public void setHealth(double health) {
        controleerHealth(health);
        this.health = health;
    }

    public double getDamage() {
        return damage;
    }

    public void setDamage(double damage) {
        controleerDamage(damage);
        this.damage = damage;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public double getCrit() {
        return crit;
    }

    public void setCrit(double crit) {
        controleerCrit(crit);
        this.crit = crit;
    }
    
    public void damage(double damage) {
        this.health -= damage;
    }
    
    public boolean isDead() {
        return health <= 0;
    }
    
    @Override
    public String toString() {
        return String.format("level %d %s with %.1f health, %.1f damage and %.1f%% crit chance", this.getLevel(), this.getClass().getSimpleName(), this.getHealth(), this.getDamage(), this.getCrit());
    }

    public Hit getLastHit() {
        return lastHit;
    }

    public void setLastHit(Hit lastHit) {
        this.lastHit = lastHit;
    }
    
    public void levelUp(int level) {
        this.level += level;
        calcStats();
    }
    
    public void hit() {
        this.hits+=1;
    }
    
    public void upCrit(double val) {
        this.setCrit(this.getCrit() + val);
    }
    
    public void upHealth(double val) {
        double hp = this.getHealth()*(val/100);
        this.setHealth(this.health + hp);
        this.addHealth += hp;
    }
    
    public void upDamage(double val) {
        double dam = this.getDamage()*(val/100);
        this.setDamage(this.damage+dam);
        this.addDamage += dam;
    }

    public double getTotalHp() {
        return totalHp;
    }

    public void setTotalHp(double totalHp) {
        this.totalHp = totalHp;
    }
}
