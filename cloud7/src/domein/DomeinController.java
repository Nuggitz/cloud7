package domein;


public class DomeinController {
    private Player player;
    private Boss currentBoss;
    private int bossLevel = 1;
    private int fights = 0;
    private Fight fight;
    private Dummie dummie;
    private int speed;
    
    public DomeinController() {
        this.player = new Player(1);
        this.speed = 5;
    }
    
    public void newFight() {
        fights+=1;
        bossLevel = player.getPointsSpent();
        currentBoss = new Boss(bossLevel);
        fight = new Fight(player,currentBoss);
    }
    
    public boolean[] damagePlayer() {
        Hit hit = new Hit(currentBoss, player);
        boolean[] hitA = {hit.isCrit(), hit.isBlock()};
        return hitA;
    }
    
    public boolean[] playerHit() {
        Hit hit = new Hit(player, currentBoss);
        boolean[] hitA = {hit.isCrit(), hit.isBlock()};
        return hitA;
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
        currentBoss.levelUp(this.player.getLevel());
    }
    
    // temporary
    public int levelPlayer(int levels) {
        int l;
        int hits = player.getHits();
        System.out.printf("\nworst %d%n", (int)Math.ceil(currentBoss.getTotalHp()/(player.getDamage()*1.0)));
        System.out.printf("worse %d%n", (int)Math.ceil(currentBoss.getTotalHp()/(player.getDamage()*1.25)));
        System.out.printf("bad %d%n", (int)Math.ceil(currentBoss.getTotalHp()/(player.getDamage()*1.5)));
        System.out.printf("normal %d%n", (int)Math.ceil(currentBoss.getTotalHp()/(player.getDamage()*1.75)));
        System.out.printf("good %d%n", (int)Math.ceil(currentBoss.getTotalHp()/(player.getDamage()*2.0)));
        System.out.printf("very good %d%n", (int)Math.ceil(currentBoss.getTotalHp()/(player.getDamage()*2.25)));
        System.out.printf("amazing %d%n", (int)Math.ceil(currentBoss.getTotalHp()/(player.getDamage()*2.5)));
        System.out.println();
        if(hits >= (int)Math.ceil(currentBoss.getTotalHp()/(player.getDamage()*1.0)) || player.getHits() == 0)
            l = 1;
        else if(hits >= (int)Math.ceil(currentBoss.getTotalHp()/(player.getDamage()*1.25)))
            l = 2;
        else if(hits >= (int)Math.ceil(currentBoss.getTotalHp()/(player.getDamage()*1.5)))
            l = 3;
        else if(hits >= (int)Math.ceil(currentBoss.getTotalHp()/(player.getDamage()*1.75)))
            l = 4;
        else if(hits >= (int)Math.ceil(currentBoss.getTotalHp()/(player.getDamage()*2.0)))
            l = 5;
        else if(hits >= (int)Math.ceil(currentBoss.getTotalHp()/(player.getDamage()*2.25)))
            l = 6;
        else if(hits >= (int)Math.ceil(currentBoss.getTotalHp()/(player.getDamage()*2.5)))
            l = 7;
        else
            l = 10;
        //player.levelUp(l);
        player.levelUp(levels);
        player.addPoint(l);
        return l;
    }
    
    /*
    0 for skip
    1 for crit
    2 for health
    3 for damage
    4 for level
    */
    public String[] upPlayerStats(int stat) {
        return player.upStats(stat);
    }
    
    public double[] playerLevelUpStats() {
        return player.getLevelUpStats();
    }
    
    public int playerHits() {
        return player.getHits();
    }
    
    public int getPoints() {
        return player.getPoints();
    }
    
    public void playerBlock() {
        player.block();
    }
    
    public boolean isPlayerBlock() {
        return player.isBlock();
    }
    
    public void playerBlocked() {
        player.setBlock(false);
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
    
    public void setPlayerImg(String img) {
        player.setImgURL(img);
    }
    
    public String getPlayerImg() {
        return player.getImgURL();
    }
    
    public void setBossImg(String img) {
        currentBoss.setImgURL(img);
    }
    
    public String getBossImg() {
        return currentBoss.getImgURL();
    }
}