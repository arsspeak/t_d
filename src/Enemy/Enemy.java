package Enemy;
import javafx.scene.image.*;

import java.io.InputStream;
import PlayerObj.Player;

public class Enemy {

    private int health;
    private int speed;
    private int damage;
    private int direction; // 0 1 2 3 | UP DOWN LEFT RIGHT //

    public int X;
    public int Y;

    public void Enemy(String type) {

        //
        direction = 3;

        switch (type)
        {
            case "lv1":
                setHealth(100);
                setSpeed(10);
                setDamage(100);
            case "lv2":
            case "aeroplane":
            case "boss":

        }
    }



    Image EnemyImg = new Image(InputStream.nullInputStream());

    public void setSpeed(int speed)
    {
        this.speed = speed;
    }

    public void setHealth(int health)
    {
        this.health = health;
    }

    public void setDamage(int damage)
    {
        this.damage = damage;
    }

    public void getAttacked(int damage)
    {
        this.health-=damage;
    }

    private void movearound()
    {
        switch(direction)
        {
            case 0: X-=speed;
            case 1: X+=speed;
            case 2: Y-=speed;
            case 3: Y+=speed;
        }
    }

    private boolean isorpassturningPoint()
    {
        return true;
        // Implement something
    }

    private void turn()
    {
        // Make a turning matrix
    }



    public int getHealth()
    {
        return health;
    }

    public void action(Player player)
    {
        if(this.X>=player.baseX) player.rekt(damage);
        // EnemyImg.;
        movearound();
        if(isorpassturningPoint()) turn();
    }
}
