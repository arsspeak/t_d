package PlayerObj;

public class Player {
    private int score;
    private int credits;
    private int health;

    public int getScore(){
        return this.score;
    }

    public int getCredits(){
        return this.credits;
    }

    public int getHealth(){
        return this.health;
    }

    public void setScore(int score){
        this.score = score;
    }

    public void setHealth(int health){
        this.health = health;
    }

    public void setCredits(int credits){
        this.credits = credits;
    }

    public boolean isthisLoss(){
        if(this.health<=0) return true;
        else return false;
    }

}
