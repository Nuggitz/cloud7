package domein;


public class DomeinController {
    private Player player;
    private Boss currentBoss;
    private int bossLevel = 1;
    private int fights = 0;
    private Fight fight;
    private Dummie dummie;
    
    public DomeinController() {
        this.player = new Player(2);
    }
    
    public void newFight() {
        this.fights+=1;
        bossLevel++;
        currentBoss = new Boss(bossLevel);
        currentBoss.setLastHit(new Hit(0));
        this.fight = new Fight(player,currentBoss);
    }
    
    public boolean damagePlayer() {
        Hit hit = new Hit(currentBoss, player);
        return hit.isCrit();
    }
    
    public boolean playerHit() {
        Hit hit = new Hit(player, currentBoss);
        return hit.isCrit();
    }
    
    public String player() {
        return player.toString();
    }
    
    public double[] playerStats() {
        double[] stats = {(double)player.getLevel(),player.getDamage(),player.getHealth(),player.getCrit(),player.getLastHit().getDamage()};
        return stats;
    }
    
    public String boss() {
        return currentBoss.toString();
    }
    
    public double[] bossStats() {
        double[] stats = {(double)currentBoss.getLevel(),currentBoss.getLastHit().getDamage(),currentBoss.getHealth()};
        return stats;
    }
    
    public int[] gameStats() {
        int[] stats = {this.fights,player.getLevel(),currentBoss.getLevel()};
        return stats;
    }
    
    public boolean bossDead() {
        return currentBoss.isDead();
    }
    
    public boolean playerDead() {
        return player.isDead();
    }
    
    public void levelBoss() {
        currentBoss.setLevel(this.player.getLevel());
    }
    
    public int levelPlayer() {
        int l;
        double hits = (double)player.getHits();
        System.out.printf("\nworst %.2f%n", currentBoss.getTotalHp()/(player.getDamage()*1.0));
        System.out.printf("worse %.2f%n", currentBoss.getTotalHp()/(player.getDamage()*1.25));
        System.out.printf("bad %.2f%n", currentBoss.getTotalHp()/(player.getDamage()*1.5));
        System.out.printf("normal %.2f%n", currentBoss.getTotalHp()/(player.getDamage()*1.75));
        System.out.printf("good %.2f%n", currentBoss.getTotalHp()/(player.getDamage()*2.0));
        System.out.printf("very good %.2f%n", currentBoss.getTotalHp()/(player.getDamage()*2.25));
        System.out.printf("amazing %.2f%n", currentBoss.getTotalHp()/(player.getDamage()*2.5));
        System.out.println();
        if(hits >= currentBoss.getTotalHp()/(player.getDamage()*1.0) || player.getHits() == 0)
            l = 1;
        else if(hits >= currentBoss.getTotalHp()/(player.getDamage()*1.25))
            l = 2;
        else if(hits >= currentBoss.getTotalHp()/(player.getDamage()*1.5))
            l = 3;
        else if(hits >= currentBoss.getTotalHp()/(player.getDamage()*1.75))
            l = 4;
        else if(hits >= currentBoss.getTotalHp()/(player.getDamage()*2.0))
            l = 5;
        else if(hits >= currentBoss.getTotalHp()/(player.getDamage()*2.25))
            l = 6;
        else if(hits >= currentBoss.getTotalHp()/(player.getDamage()*2.5))
            l = 7;
        else
            l = 10;
        //player.levelUp(l);
        player.levelUp(1);
        addPoint(l);
        return l;
    }
    
    public int playerHits() {
        return player.getHits();
    }
    
    /*
    0 for crit
    1 for health
    2 for damage
    */
    public String[] upStats(int stat) {
        double crit = 5, health = 25, damage = 50;
        String[] stats = {"nothing","0"};
        switch(stat) {
            case 0:
                break;
            case 1:
                player.upCrit(crit);
                stats[0] = "crit";
                stats[1] = Double.toString(crit);
                addPoint(-1);
                return stats;
            case 2: 
                player.upHealth(health);
                stats[0] = "health";
                stats[1] = Double.toString(health);
                addPoint(-1);
                return stats;
            case 3: 
                player.upDamage(damage);
                stats[0] = "damage";
                stats[1] = Double.toString(damage);
                addPoint(-1);
                return stats;
        }
        return stats;
    }
    
    public void addPoint(int p) {
        player.setPoints(player.getPoints() + p);
    }
    
    public int getPoints() {
        return player.getPoints();
    }
}