package Game;

import Map.Map;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class tmp extends Application {

    @Override
    public void start(Stage stage) throws FileNotFoundException {

        Image test = new Image(new FileInputStream("src/map.png"));
        Map map = new Map();
        map.img = test;
        ImageView iv = new ImageView();
        iv.setImage(map.img);

        Group root = new Group(iv);
        Canvas cv = new Canvas();
        GraphicsContext gc = cv.getGraphicsContext2D();
        Scene scene = new Scene(root);








        stage.setScene(scene);
        stage.show();
    }
}
