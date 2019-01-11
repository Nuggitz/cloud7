package domein;


public class Fight {
    
    private Player player;
    private Boss boss;
    
    public Fight(Player player, Boss boss) {
        this.player = player;
        this.boss = boss;
        player.setHits(0);
        boss.setHits(0);
    }
}
