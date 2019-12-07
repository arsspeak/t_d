package Gæm;
import Enemy.Enemy;
import PlayerObj.Player;
import Tower.TowerFrame;

import java.util.*;

public class Gæm {

    public void gæm() {

        // Init
        Player player = new Player();
        ArrayList<TowerFrame> towers = new ArrayList<TowerFrame>();
        ArrayList<Enemy> enemies = new ArrayList<Enemy>();

        // This is the gæm loöp
        while(!player.isthisLoss())
        {
            for(TowerFrame tower : towers) tower.action(enemies);
            for(Enemy enemy : enemies) enemy.action(player);
            System.runFinalization();
            if(player.isthisLoss()) break;

        }
    }

}
