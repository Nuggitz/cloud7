package domein;

import exceptions.*;


public abstract class Entity {
    protected double totalHp, health;
    protected double damage;
    protected int level;
    protected double crit, blockC, critD;
    protected Hit lastHit;
    protected int hits;
    protected double levelMod;//health = level * levelMod
    protected boolean block;
    protected String imgURL;
    
    public Entity(int level) {
        controleerLevel(level);
        this.level = level;
        levelMod = 5;
        double hp = levelMod*level;
        double dmg = (levelMod*level)/10;
        controleerHealth(hp);
        health = hp;
        controleerDamage(dmg);
        damage = dmg;
        crit = 0;
        totalHp = health;
        lastHit = new Hit(0);
        block = false;
        hits = 0;
        blockC = 75;
        imgURL = "/images/questionMark.png";
    }
    
    private void calcStats() {
        health = levelMod*level;
        damage = (levelMod*level)/10;
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

    public double getTotalHp() {
        return totalHp;
    }

    public void setTotalHp(double totalHp) {
        this.totalHp = totalHp;
    }
    
    public int getHits() {
        return hits;
    }

    public void setHits(int hits) {
        this.hits = hits;
    }
    
    public void block() {
        this.block = true;
    }

    public boolean isBlock() {
        return block;
    }

    public void setBlock(boolean block) {
        this.block = block;
    }

    public double getBlockC() {
        return blockC;
    }

    public void setBlockC(double blockC) {
        this.blockC = blockC;
    }

    public double getCritD() {
        return critD;
    }

    public void setCritD(double critD) {
        this.critD = critD;
    }

    public String getImgURL() {
        return imgURL;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }
}
