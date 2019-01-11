package domein;



public class Player extends Entity{
    
    private int points, pointsSpent;
    private final double levelCrit, levelHealth, levelDamage;
    private double addHealth, addDamage;
    
    public Player(int level) {
        super(level);
        points = 0;
        levelCrit = 5;
        levelHealth = 50;
        levelDamage = 30;
        health += addHealth;
        damage += addDamage;
        crit = 50;
        pointsSpent = 1;
        super.imgURL = "/images/rickfront.png";
    }
    
    private void calcStats() {
        this.health = levelMod*level + addHealth;
        this.damage = (levelMod*level)/10 + addDamage;
    }
    
    @Override
    public void levelUp(int level) {
        this.level += level;
        this.calcStats();
    }
    
    public double upCrit(double val) {
        crit += val;
        return val;
    }
    
    public double upHealth(double val) {
        double hp = health*(val/100);
        health += hp;
        addHealth += hp;
        return hp;
    }
    
    public double upDamage(double val) {
        double dam = damage*(val/100);
        damage += dam;
        addDamage += dam;
        return dam;
    }
    
    private void controleerPoints(int points) {
        if(points < 0) {
            throw new IllegalArgumentException("points niet onder 0");
        }
    }
    
    /*
    0 for crit
    1 for health
    2 for damage
    */
    public String[] upStats(int stat) {
        String[] stats = {"nothing","0"};
        switch(stat) {
            case 0:
                break;
            case 1:
                stats[0] = "crit";
                stats[1] = String.format("%.1f", upCrit(levelCrit));
                addPoint(-1);
                this.pointsSpent++;
                return stats;
            case 2: 
                stats[0] = "health";
                stats[1] = String.format("%.1f", upHealth(levelHealth));
                addPoint(-1);
                this.pointsSpent++;
                return stats;
            case 3: 
                stats[0] = "damage";
                stats[1] = String.format("%.1f", upDamage(levelDamage));
                addPoint(-1);
                this.pointsSpent++;
                return stats;
            case 4:
                stats[0] = "level";
                stats[1] = "1";
                levelUp(1);
                addPoint(-1);
                this.pointsSpent++;
                return stats;
        }
        return stats;
    }
    
    public double[] getLevelUpStats() {
        double[] stats = {
            levelCrit,
            health*(levelHealth/100), 
            damage*(levelDamage/100)};
        return stats;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        controleerPoints(points);
        this.points = points;
    }
    
    public void addPoint(int p) {
        this.points+=p;
    }

    public int getPointsSpent() {
        return pointsSpent;
    }

    public void setPointsSpent(int pointsSpent) {
        this.pointsSpent = pointsSpent;
    }
}