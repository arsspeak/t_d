package Game;

import Enemy.Enemy;
import Map.Map;
import PlayerObj.Player;
import Tower.TowerFrame;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.InputStream;
import java.util.ArrayList;

public class Game extends Application {


    private Player player = new Player();
    private ArrayList<TowerFrame> towers = new ArrayList<TowerFrame>();
    public static ArrayList<Enemy> enemies = new ArrayList<Enemy>();



    // RESOURCES //
    Image Enemy_Lv1 = new Image(InputStream.nullInputStream());



    public Game(Group root) {

        // This is the gæm loöp
        player.reset();
        towers.clear();
        enemies.clear();



        while(!player.isThisLoss())
        {
            for(TowerFrame tower : towers) {
                root.getChildren().add(tower.getIV());
            }
            for(TowerFrame tower : towers) tower.action(enemies);
            enemies.removeIf(enemy -> (enemy.getHealth()<=0));
            for(Enemy enemy : enemies) enemy.action(player);
            System.runFinalization(); // Prevent memory leak?
            if(player.isThisLoss()) break;

        }
    }
    public void addTower(String type, int placeX, int placeY)
        {

            towers.add(new TowerFrame(type, placeX, placeY ));
        }

    public void spawnEnemy(String type) {
        switch (type){
            case "Lv1":
                enemies.add(new Enemy(type, Enemy_Lv1));

        }

    }






    @Override
    public void start(Stage stage)
    {




        GraphicsContext gc;
        Canvas cv = new Canvas();
        Group root = new Group();
        Scene scene = new Scene(root);
        scene.setFill(Color.BLACK);

        for(TowerFrame tower : towers) {
            root.getChildren().add(tower.getIV());
        }

        gc = cv.getGraphicsContext2D();

        Game game = new Game(root);
        Map map = new Map();

        stage.setScene(scene);
        stage.show();

    }

}
