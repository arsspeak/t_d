package Tower;

import Enemy.Enemy;
import java.util.List;


public class TowerFrame {
    private int damage;
    private int cost;
    private int range;

    public int X;
    public int Y;

    private boolean lock;

    Enemy LockedEnemy;


    public TowerFrame(String type)
    {
        switch(type)
        {
            case "Reg_Lv1":
            case "Reg_Lv2":
            case "add more pls":
        }
    }

    private void attack(Enemy gae)
    {
        gae.getAttacked(damage);
    }

    private void lock(Enemy gae)
    {
        lock = true;
        LockedEnemy = gae;
    }

    private boolean inRange(Enemy gae)
    {
        if(Math.sqrt(Math.pow(this.X-gae.X, 2)+Math.pow(this.Y-gae.Y, 2))<range);
        return true;
    }

    private boolean outOfRange(Enemy gae)
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
            if(LockedEnemy.getHealth()<=0)
            {
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
