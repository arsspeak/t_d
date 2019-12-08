package PlayerObj;

public class Player {
    private int score;
    private int credits;
    private int health;

    private int baseX;
    public int getBaseX()
    {
        return baseX;
    }
    private int baseY;
    public int getBaseY()
    {
        return  baseY;
    }

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

    public boolean isThisLoss(){
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
