package Enemy;

import Game.Game;
import PlayerObj.Player;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import Game.Game.*;
import javafx.scene.image.ImageView;

public class Enemy{

    private int health;

    private int speed;
    public int getHealth()
    {
        return health;
    }
    private int turnCount;

    private int damage;

    private Image img;
    private ImageView iv = new ImageView();

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

    public Enemy(String type, Image objImg) {

        //
        direction = 3; // Default RIGHT
        this.type = type;
        X = 0;
        Y= 2240;
        turnCount = 0;
        img = objImg;
        iv.setImage(img);
        switch (type)
        {
            case "lv1":
                setHealth(100);
                setSpeed(10);
                setDamage(100);
                iv.setRotate(0);
            case "lv2":
            case "aeroplane":
                setHealth(100);
                setSpeed(10);
                iv.setRotate(-16.7);
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
        if(type.equals("aeroplane")) fly();
        else {

            if (this.X >= player.getBaseX()) {
                player.rekt(damage);
                health = 0;
                timer.cancel();

            }
            if (isOrPassTurningPoint()) turn(this.iv);
        }
    }

    public void draw(GraphicsContext gc){

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

    private void doNotMove() {}

    private boolean isOrPassTurningPoint()
    {
        switch(turnCount)
        {
            case 0:
                if((int)X/128==17) return true;
            case 1:
                if((int)Y/128==7) return true;
            case 2:
                if((int)X/128==1) return true;
            case 3:
                if((int)Y/128==3) return true;
        }
        return false;

    }

    private void turn(ImageView iv)
    {
        // Make a turning matrix
        switch (turnCount)
        {
            case 0:
                direction = 0;
                iv.setRotate(-90);
            case 1:
                direction = 2;
                iv.setRotate(180);
            case 2:
                direction = 0;
                iv.setRotate(-90);
            case 3:
                direction = 3;
                iv.setRotate(0);
        }
    }

    private void fly()
    {
        X-=speed*Math.cos(16.7);
        Y-=speed*Math.sin(16.7);
    }





}
