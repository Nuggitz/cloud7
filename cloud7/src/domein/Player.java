package domein;



public class Player extends Entity{
    
    private int points = 0;
    
    public Player(int level) {
        super(level);
    }
    
    private void controleerPoints(int points) {
        if(points < 0) {
            throw new IllegalArgumentException("points niet onder 0");
        }
    }

    public int getHits() {
        return hits;
    }

    public void setHits(int hits) {
        this.hits = hits;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        controleerPoints(points);
        this.points = points;
    }
}