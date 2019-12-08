package Gæm;
import Enemy.Enemy;
import PlayerObj.Player;
import Tower.TowerFrame;

import java.util.*;

public class Gæm {

    private Player player = new Player();
    private ArrayList<TowerFrame> towers = new ArrayList<TowerFrame>();
    private ArrayList<Enemy> enemies = new ArrayList<Enemy>();

    public Gæm() {

        // This is the gæm loöp
        while(!player.isthisLoss())
        {
            for(TowerFrame tower : towers) tower.action(enemies);
            for(Enemy enemy : enemies) enemy.action(player);
            System.runFinalization();
            if(player.isthisLoss()) break;

        }


    }
        public void addTower(String type)
        {
            towers.add(new TowerFrame(type));
        }

}
