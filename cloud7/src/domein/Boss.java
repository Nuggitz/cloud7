package domein;



public class Boss extends Entity {
    
    private double mod;
    
    public Boss(int level) {
        super(level);
        mod = Math.ceil((double)level / 10);
        calcStats();
    }
    
    private void calcStats() {
        if(level > 50)
            crit = 50;
        else
            crit = level;
        damage*=mod;
        health*=mod;
        totalHp = health;
        super.imgURL = "/images/boomb.gif";
    }

    public double getMod() {
        return mod;
    }

    public void setMod(int mod) {
        this.mod = mod;
    }
}
