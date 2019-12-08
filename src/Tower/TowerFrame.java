package Tower;

import Enemy.Enemy;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;


public class TowerFrame {
    private int damage;
    private int cost;
    private int range;
    private int speed;
    private String type;

    private Bullet bullet;

    private int X;
    private int Y;


    private boolean lock;

    private Enemy LockedEnemy;
    private Image img;
    private ImageView iv = new ImageView();

    private Timer timer = new Timer();
    private TimerTask task = new TimerTask() {
        @Override
        public void run() {
            attack(LockedEnemy);
        }
    };


    public TowerFrame(String type, int placeX, int placeY)
    {
        switch(type)
        {
            case "Reg_Lv1":
                this.type = type;
            case "Reg_Lv2":
                this.type = type;
            case "add more pls":
        }
        iv.setImage(img);
        X = placeX;
        Y = placeY;
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
        bullet = new Bullet(X,Y, gae.getX(), gae.getY(), this.type);
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

    public ImageView getIV(){
        return this.iv;
    }


}
