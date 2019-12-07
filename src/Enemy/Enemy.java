package Enemy;
import javafx.scene.image.*;

import java.io.InputStream;

public class Enemy {

    private int health;
    private int speed;
    private int damage;

    public int X;
    public int Y;

    public void Enemy(String type, int X, int Y) {

        //

        switch (type)
        {
            case "lv1":
                setHealth(100);
                setSpeed(10);
                setDamage(100);
            case "lv2":



        }
    }



    Image EnemyImg = new Image(InputStream.nullInputStream());

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void getAttacked(int damage)
    {
        this.health-=damage;
    }
}
