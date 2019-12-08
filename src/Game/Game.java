package Game;
import Enemy.Enemy;
import PlayerObj.Player;
import Tower.TowerFrame;
import javafx.scene.canvas.GraphicsContext;

import java.util.*;

public class Game {

    private Player player = new Player();
    private ArrayList<TowerFrame> towers = new ArrayList<TowerFrame>();
    public static ArrayList<Enemy> enemies = new ArrayList<Enemy>();

    public Game() {

        // This is the gæm loöp
        while(!player.isThisLoss())
        {
            for(TowerFrame tower : towers) tower.action(enemies);
            enemies.removeIf(enemy -> (enemy.getHealth()<=0));
            for(Enemy enemy : enemies) enemy.action(player);


            System.runFinalization(); // Prevent memory leak?

            if(player.isThisLoss()) break;

        }


    }
        public void addTower(String type)
        {
            towers.add(new TowerFrame(type));
        }

        public void drawEverything(GraphicsContext gc)
        {
            for(Enemy enemy : enemies) enemy.draw(gc);
            for(TowerFrame tower : towers) tower.draw(gc);
        }

}
