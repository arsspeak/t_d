package Tower;

import Enemy.Enemy;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.locks.Lock;


public class TowerFrame {
    private int damage;
    private int cost;
    private int range;
    private int speed;

    private int X;
    private int Y;

    private boolean lock;

    private Enemy LockedEnemy;
    private Image img;

    private Timer timer = new Timer();
    private TimerTask task = new TimerTask() {
        @Override
        public void run() {
            attack(LockedEnemy);
        }
    };


    public TowerFrame(String type)
    {
        switch(type)
        {
            case "Reg_Lv1":
            case "Reg_Lv2":
            case "add more pls":
        }
    }

    public void action(List<Enemy> bruh)
    {

        while(lock)
        {
            timer.schedule(task, 1000/speed);
            if(outOfRange(LockedEnemy)) {
                lock = false;
                LockedEnemy = null;
                timer.cancel();
                break;
            }
            if(LockedEnemy.getHealth()<=0)
            {
                lock = false;
                LockedEnemy = null;
                timer.cancel();
                break;
            }
        }

        while(!lock)
        {
            for(int i=0; i<bruh.size(); i++)
            {
                if(inRange(bruh.get(i))) {
                    lock(bruh.get(i));
                    timer.schedule(task, 1000/speed);
                    break;
                }
            }
        }
    }

    public void draw(GraphicsContext gc){
        gc.drawImage(img, X, Y);
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
        if(Math.sqrt(Math.pow(this.X-gae.getX(), 2)+Math.pow(this.Y-gae.getY(), 2))<range);
        return true;
    }

    private boolean outOfRange(Enemy gae)
    {
        if(Math.sqrt(Math.pow(this.X-gae.getX(), 2)+Math.pow(this.Y-gae.getY(), 2))>range);
        return true;
    }

}
