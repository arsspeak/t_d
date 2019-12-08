package Enemy;

import Game.Game;
import PlayerObj.Player;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import Game.Game.*;

public class Enemy{

    private int health;

    private int speed;
    public int getHealth()
    {
        return health;
    }

    private int damage;
    private Image img;
    private int direction; // 0 1 2 3 | UP DOWN LEFT RIGHT //

    private int X;
    public int getX()
    {
        return X;
    }

    private int Y;
    public int getY()
    {
        return Y;
    }

    private String type;
    public String getType()
    {
        return type;
    }

    private Timer timer = new Timer();
    private TimerTask task = new TimerTask() {

        @Override
        public void run() {
            lookahead(Game.enemies);
        }
    };

    public Enemy(String type) {

        //
        direction = 3; // Default RIGHT
        this.type = type;
        switch (type)
        {
            case "lv1":
                setHealth(100);
                setSpeed(10);
                setDamage(100);
                img = new Image("bruh.png");
            case "lv2":
            case "aeroplane":
            case "boss":

        }
        timer.schedule(task, 1000/speed);
    }

    public void getAttacked(int damage)
    {
        this.health-=damage;
    }

    public void action(Player player)
    {
        if(this.X>=player.getBaseX()) player.rekt(damage);
        if(isOrPassTurningPoint()) turn();
    }

    public void draw(GraphicsContext gc){
        gc.drawImage(img, X, Y);
    }

    private void lookahead(ArrayList<Enemy> temp)
    {
        for(Enemy a : temp) if(this.type.equals(a.getType()))
        {
            switch(direction) {
                case 0:
                    if (X-speed>=a.getX()) doNotMove();
                case 1:
                    if (X+speed>=a.getX()) doNotMove();
                case 2:
                    if (Y-speed>=a.getX()) doNotMove();
                case 3:
                    if (Y+speed>=a.getX()) doNotMove();
            }
        }
        else moveAround();
    }

    private void setSpeed(int speed)
    {
        this.speed = speed;
    }

    private void setHealth(int health)
    {
        this.health = health;
    }

    private void setDamage(int damage)
    {
        this.damage = damage;
    }

    private void moveAround()
    {
        switch(direction)
        {
            case 0: Y-=speed;   // UP
            case 1: Y+=speed;   // DOWN
            case 2: X-=speed;   // LEFT
            case 3: X+=speed;   // RIGHT
        }
    }

    private void doNotMove()
    {

    }

    private boolean isOrPassTurningPoint()
    {
        return true;
        // Implement something
    }

    private void turn()
    {
        // Make a turning matrix
    }





}
