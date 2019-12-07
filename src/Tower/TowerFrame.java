package Tower;

import Enemy.Enemy;
import java.util.List;


public abstract class TowerFrame {
    public int damage;
    public int cost;
    public int range;

    public int X;
    public int Y;

    public boolean lock;

    Enemy LockedEnemy;


    public void attack(Enemy gae)
    {
        gae.getAttacked(damage);
    }

    public void lock(Enemy gae)
    {
        lock = true;
        LockedEnemy = gae;
    }

    public boolean inRange(Enemy gae)
    {
        if(Math.sqrt(Math.pow(this.X-gae.X, 2)+Math.pow(this.Y-gae.Y, 2))<range);
        return true;
    }

    public boolean outOfRange(Enemy gae)
    {
        if(Math.sqrt(Math.pow(this.X-gae.X, 2)+Math.pow(this.Y-gae.Y, 2))>range);
        return true;
    }

    public void action(List<Enemy> bruh)
    {

        while(lock)
        {
            attack(LockedEnemy);
            if(outOfRange(LockedEnemy)) {
                lock = false;
                LockedEnemy = null;
                break;
            }
        }

        while(!lock)
        {
           for(int i=0; i<bruh.size(); i++)
           {
               if(inRange(bruh.get(i))) {
                   lock(bruh.get(i));
                   break;
               }
           }
        }
    }
}
