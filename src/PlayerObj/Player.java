package PlayerObj;

public class Player {
    private int score;
    private int credits;
    private int health;

    public int baseX;
    public int baseY;

    public int getScore(){
        return this.score;
    }

    public int getCredits(){
        return this.credits;
    }

    public int getHealth(){
        return this.health;
    }

    public void rekt(int damage)
    {
        this.health-=damage;
    }

    public boolean isthisLoss(){
        if(this.health<=0) return true;
        else return false;
    }

    public void Player()
    {
        score = 0;
        credits =1000;
        health =1000;
    }

}
