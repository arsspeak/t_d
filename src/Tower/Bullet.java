package Tower;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.sql.Time;
import java.util.Timer;
import java.util.TimerTask;

public class Bullet {

    ImageView iv = new ImageView();
    Timer timer = new Timer();
    TimerTask task = new TimerTask() {
        @Override
        public void run() {
            fly();
        }
    };
    private int X;
    private int Y;


    public Bullet(int TowerX, int TowerY, int EnemyX, int EnemyY, String type)
    {

        X = TowerX;
        Y = TowerY;
        fly();


    }
    private void fly()
    {

    }

}
